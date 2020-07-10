package org.example.library.feature.logictest.presentation

import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.livedata.LiveData
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.livedata.mergeWith
import dev.icerock.moko.mvvm.livedata.readOnly
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.permissions.DeniedAlwaysException
import dev.icerock.moko.permissions.DeniedException
import dev.icerock.moko.permissions.Permission
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc
import kotlinx.coroutines.launch

/**
Created by Denis Chornyy on 03,Июль,2020
All rights received.
 */
class TestViewModel(
    override val eventsDispatcher: EventsDispatcher<EventsListener>,
    private val permissionsController: PermissionsController
) : ViewModel(), EventsDispatcherOwner<TestViewModel.EventsListener> {

    val amount: MutableLiveData<String> = MutableLiveData("")
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading.readOnly()
    val isBuyButtonEnabled: LiveData<Boolean> =
        amount.mergeWith(isLoading) { first, second -> first.isNotBlank() && second.not() }


    fun onButtonPressed() {
        eventsDispatcher.dispatchEvent { processLogging() }
    }

    fun onButtonPhotoPressed() {
        val permission = Permission.CAMERA
        viewModelScope.launch {
            _isLoading.value = true
            try {
                permissionsController.providePermission(permission)
                eventsDispatcher.dispatchEvent { providePermissions("permission ${permission.name} provided!") }

            } catch (fatalEx: DeniedAlwaysException) {
                eventsDispatcher.dispatchEvent { showError("permission always fails at: ${fatalEx.message}".desc()) }
            } catch (ex: DeniedException) {
                eventsDispatcher.dispatchEvent { showError("permission failed: ${ex.message}".desc()) }
            } finally {
                _isLoading.value = false
            }
        }
    }

    interface EventsListener {
        fun processLogging()
        fun providePermissions(message: String)
        fun showError(err: StringDesc)
    }
}
package org.example.library.feature.testlib.presentation

import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.livedata.*
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.resources.desc.StringDesc

/**
Created by Denis Chornyy on 03,Июль,2020
All rights received.
 */
class TestViewModel(
    override val eventsDispatcher: EventsDispatcher<EventsListener>
) : ViewModel(), EventsDispatcherOwner<TestViewModel.EventsListener> {

    val amount: MutableLiveData<String> = MutableLiveData("")
    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading.readOnly()
    val isBuyButtonEnabled: LiveData<Boolean> = amount.mergeWith(isLoading) { first, second -> first.isNotBlank() && second.not() }

    fun onButtonPressed() {
        eventsDispatcher.dispatchEvent { processLogging() }
    }

    interface EventsListener {
        fun processLogging()
        fun showError(err: StringDesc)
    }
}
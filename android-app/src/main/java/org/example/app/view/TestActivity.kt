package org.example.app.view

import androidx.lifecycle.ViewModelProvider
import dev.icerock.moko.mvvm.BR
import dev.icerock.moko.mvvm.MvvmEventsActivity
import dev.icerock.moko.mvvm.createViewModelFactory
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import dev.icerock.moko.permissions.PermissionsController
import dev.icerock.moko.resources.desc.StringDesc
import org.example.app.R
import org.example.app.databinding.ActivityTestBinding
import org.example.app.ext.errToast
import org.example.app.ext.toast
import org.example.library.feature.testlib.presentation.TestViewModel

/**
Created by Denis Chornyy on 06,Июль,2020
All rights received.
 */
class TestActivity :
    MvvmEventsActivity<ActivityTestBinding, TestViewModel, TestViewModel.EventsListener>(),
    TestViewModel.EventsListener {
    override val layoutId: Int
        get() = R.layout.activity_test
    override val viewModelClass: Class<TestViewModel>
        get() = TestViewModel::class.java
    override val viewModelVariableId: Int
        get() = BR.viewmodel

    override fun viewModelFactory(): ViewModelProvider.Factory {
        val permissionsController = PermissionsController(applicationContext = this).also {
            it.bind(lifecycle, supportFragmentManager)
        }
        return createViewModelFactory {
            TestViewModel(
                eventsDispatcher = eventsDispatcherOnMain(),
                permissionsController = permissionsController
            )
        }


    }

    override fun processLogging() {
        toast("go to next page")
    }

    override fun providePermissions(message: String) {
        toast(message)
    }

    override fun showError(err: StringDesc) {
        errToast(err.toString(this))
        //Toast.makeText(this, err.toString(), Toast.LENGTH_LONG).show()
    }
}
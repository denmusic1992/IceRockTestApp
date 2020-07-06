package org.example.app.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import dev.icerock.moko.mvvm.BR
import dev.icerock.moko.mvvm.MvvmActivity
import dev.icerock.moko.mvvm.MvvmEventsActivity
import dev.icerock.moko.mvvm.createViewModelFactory
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import dev.icerock.moko.resources.desc.StringDesc
import org.example.app.R
import org.example.app.databinding.ActivityTestBinding
import org.example.library.feature.testlib.presentation.TestViewModel

/**
Created by Denis Chornyy on 06,Июль,2020
All rights received.
 */
class TestActivity: MvvmEventsActivity<ActivityTestBinding, TestViewModel, TestViewModel.EventsListener>(), TestViewModel.EventsListener {
    override val layoutId: Int
        get() = R.layout.activity_test
    override val viewModelClass: Class<TestViewModel>
        get() = TestViewModel::class.java
    override val viewModelVariableId: Int
        get() = BR.viewmodel

    override fun viewModelFactory(): ViewModelProvider.Factory {
        return createViewModelFactory { TestViewModel(eventsDispatcher = eventsDispatcherOnMain()) }
    }

    override fun processLogging() {
        Toast.makeText(this, "go to next page", Toast.LENGTH_SHORT).show()
    }

    override fun showError(err: StringDesc) {
        TODO("Not yet implemented")
    }
}
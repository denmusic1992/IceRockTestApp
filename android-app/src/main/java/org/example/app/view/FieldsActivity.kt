package org.example.app.view

import androidx.lifecycle.ViewModelProvider
import dev.icerock.moko.mvvm.BR
import dev.icerock.moko.mvvm.MvvmEventsActivity
import dev.icerock.moko.mvvm.createViewModelFactory
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import org.example.app.R
import org.example.app.databinding.ActivityValidationBinding
import org.example.app.ext.errToast
import org.example.app.ext.toast
import org.example.library.feature.logictest.presentation.FieldsViewModel

/**
Created by Denis Chornyy on 08,Июль,2020
All rights received.
 */
class FieldsActivity :
    MvvmEventsActivity<ActivityValidationBinding, FieldsViewModel, FieldsViewModel.EventsListener>(),
    FieldsViewModel.EventsListener {
    override val layoutId: Int
        get() = R.layout.activity_validation
    override val viewModelClass: Class<FieldsViewModel>
        get() = FieldsViewModel::class.java
    override val viewModelVariableId: Int
        get() = BR.viewmodel

    override fun viewModelFactory(): ViewModelProvider.Factory {
        return createViewModelFactory { FieldsViewModel(eventsDispatcherOnMain()) }
    }

    override fun showError(err: String) {
        errToast(err)
    }

    override fun showSuccess() {
        toast("Validation completes successfully!")
    }

}
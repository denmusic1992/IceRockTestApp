package org.example.library.feature.testlib.presentation

import dev.icerock.moko.fields.FormField
import dev.icerock.moko.fields.liveBlock
import dev.icerock.moko.fields.validate
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.resources.desc.StringDesc
import dev.icerock.moko.resources.desc.desc

/**
Created by Denis Chornyy on 08,Июль,2020
All rights received.
 */
class FieldsViewModel(override val eventsDispatcher: EventsDispatcher<EventsListener>) :
    ViewModel(), EventsDispatcherOwner<FieldsViewModel.EventsListener> {
    companion object {
        private const val err = "This field is incorrect! Please, edit it"
        private const val showErr = "Something went wrong! Please check it"
    }

    val panField = FormField<String, StringDesc>("",
        liveBlock {
            if (it.isBlank() || it.length < 16)
                err.desc()
            else null
        })

    val holderField = FormField<String, StringDesc>("",
        liveBlock {
            if (it.isBlank())
                err.desc()
            else null
        })

    val cvcField = FormField<String, StringDesc>(
        "",
        liveBlock {
            if (it.isBlank() || it.length != 3)
                err.desc()
            else null
        }
    )

    private val validators = listOf(panField, holderField, cvcField)

    fun validation() {

        eventsDispatcher.dispatchEvent {
            if (validators.validate()) showSuccess() else showError(showErr)
        }
    }

    interface EventsListener {
        fun showError(err: String)
        fun showSuccess()
    }
}
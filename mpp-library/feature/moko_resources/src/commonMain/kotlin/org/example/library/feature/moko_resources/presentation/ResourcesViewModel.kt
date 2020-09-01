package org.example.library.feature.moko_resources.presentation

import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.viewmodel.ViewModel

class ResourcesViewModel(
    override val eventsDispatcher: EventsDispatcher<EventsListener>,
    private val defaultLanguage: String
) : ViewModel(), EventsDispatcherOwner<ResourcesViewModel.EventsListener> {

    interface EventsListener {

    }
}
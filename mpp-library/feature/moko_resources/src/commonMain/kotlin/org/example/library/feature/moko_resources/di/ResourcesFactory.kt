package org.example.library.feature.moko_resources.di

import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import org.example.library.feature.moko_resources.presentation.ResourcesViewModel

class ResourcesFactory(
    private val defaultLanguage: String
) {
    fun createResourcesViewModel(
        eventsDispatcher: EventsDispatcher<ResourcesViewModel.EventsListener>
    ) = ResourcesViewModel(
        eventsDispatcher = eventsDispatcher,
        defaultLanguage = defaultLanguage
    )
}
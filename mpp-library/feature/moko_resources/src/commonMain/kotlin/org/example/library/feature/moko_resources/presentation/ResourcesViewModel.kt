package org.example.library.feature.moko_resources.presentation

import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.resources.desc.StringDesc
import org.example.library.feature.moko_resources.model.Person
import org.example.library.moko_resources.MR

class ResourcesViewModel(
    override val eventsDispatcher: EventsDispatcher<EventsListener>,
    private val defaultLanguage: String
) : ViewModel(), EventsDispatcherOwner<ResourcesViewModel.EventsListener> {

    private val myAge = 28

    val person = Person(
        name = getName(),
        age = getAge(age = myAge),
        greetings = getGreetings()
    )

    fun getTitle() = StringDesc.Resource(MR.strings.title)
    fun getNameTitle() = StringDesc.Resource(MR.strings.my_name_title)
    fun getAgeTitle() = StringDesc.Resource(MR.strings.my_age_title)
    fun getGreetingsTitle() = StringDesc.Resource(MR.strings.my_greetings_title)

    private fun getGreetings() = StringDesc.Resource(MR.strings.my_greetings)
    private fun getAge(age: Int) = StringDesc.ResourceFormatted(MR.strings.my_age, age)
    private fun getName() = StringDesc.Resource(MR.strings.my_name)

    interface EventsListener {
    }
}
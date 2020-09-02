package org.example.library.feature.moko_resources.presentation

import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.resources.FontResource
import dev.icerock.moko.resources.ImageResource
import dev.icerock.moko.resources.desc.StringDesc
import org.example.library.feature.moko_resources.model.Person
import org.example.library.moko_resources.MR

class ResourcesViewModel(
    override val eventsDispatcher: EventsDispatcher<EventsListener>,
    private val defaultLanguage: String
) : ViewModel(), EventsDispatcherOwner<ResourcesViewModel.EventsListener> {

    private val myAge = 28
    private val myLanguagesCount = 1

    val person = Person(
        name = getName(),
        age = getAge(age = myAge),
        greetings = getGreetings(),
        languages = getLanguages(languages = myLanguagesCount)
    )

    init {
        StringDesc.localeType = StringDesc.LocaleType.Custom(defaultLanguage)
    }

    fun getTitle() = StringDesc.Resource(MR.strings.title)
    fun getNameTitle() = StringDesc.Resource(MR.strings.my_name_title)
    fun getAgeTitle() = StringDesc.Resource(MR.strings.my_age_title)
    fun getGreetingsTitle() = StringDesc.Resource(MR.strings.my_greetings_title)
    fun getLanguagesTitle() = StringDesc.Resource(MR.strings.my_languages_title)
    fun getDrawable(): ImageResource = MR.images.icon
    fun getFontRegular(): FontResource = MR.fonts.Pacifico.regular

    private fun getGreetings() = StringDesc.Resource(MR.strings.my_greetings)
    private fun getAge(age: Int) = StringDesc.ResourceFormatted(MR.strings.my_age, age)
    private fun getName() = StringDesc.Resource(MR.strings.my_name)
    private fun getLanguages(languages: Int) =
        StringDesc.PluralFormatted(MR.plurals.my_languages, languages, languages)

    interface EventsListener {
    }
}
package org.example.library.feature.testlib.presentation

import dev.icerock.moko.mvvm.dispatcher.EventsDispatcher
import dev.icerock.moko.mvvm.dispatcher.EventsDispatcherOwner
import dev.icerock.moko.mvvm.livedata.MutableLiveData
import dev.icerock.moko.mvvm.livedata.map
import dev.icerock.moko.mvvm.viewmodel.ViewModel

/**
Created by Denis Chornyy on 03,Июль,2020
All rights received.
 */
class TestViewModel(
    override val eventsDispatcher: EventsDispatcher<EventsListener>
) : ViewModel(), EventsDispatcherOwner<TestViewModel.EventsListener> {
    private val _counter = MutableLiveData<Int>(0)
    val counter = _counter.map { it.toString() }

    fun onCounterButtonPressed() {
        val current = _counter.value
        _counter.value = current + 1
    }

    fun onButtonPressed() {
        eventsDispatcher.dispatchEvent { routeToMainPage() }
    }

    interface EventsListener {
        fun routeToMainPage()
    }
}
package org.example.app.view

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import dev.icerock.moko.mvvm.BR
import dev.icerock.moko.mvvm.MvvmEventsActivity
import dev.icerock.moko.mvvm.createViewModelFactory
import dev.icerock.moko.mvvm.dispatcher.eventsDispatcherOnMain
import org.example.app.AppComponent
import org.example.app.databinding.ActivityResourcesBinding
import org.example.app.R
import org.example.library.feature.moko_resources.presentation.ResourcesViewModel

class ResourcesActivity :
    MvvmEventsActivity<ActivityResourcesBinding, ResourcesViewModel, ResourcesViewModel.EventsListener>() {
    override val layoutId: Int = R.layout.activity_resources
    override val viewModelClass: Class<ResourcesViewModel> = ResourcesViewModel::class.java
    override val viewModelVariableId: Int = BR.viewModel

    override fun viewModelFactory(): ViewModelProvider.Factory = createViewModelFactory {
        AppComponent.factory.resourcesFactory.createResourcesViewModel(
            eventsDispatcher = eventsDispatcherOnMain()
        )
    }
}
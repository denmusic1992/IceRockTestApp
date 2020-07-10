package org.example.app.view

import androidx.lifecycle.ViewModelProvider
import dev.icerock.moko.mvvm.BR
import dev.icerock.moko.mvvm.MvvmActivity
import dev.icerock.moko.mvvm.createViewModelFactory
import org.example.app.R
import org.example.app.databinding.ActivityRecyclerBinding
import org.example.app.units.UnitFactoryImpl
import org.example.library.feature.logictest.presentation.MokoRecyclerViewModel

/**
Created by Denis Chornyy on 10,Июль,2020
All rights received.
 */
class RecyclerViewActivity: MvvmActivity<ActivityRecyclerBinding, MokoRecyclerViewModel>() {
    override val layoutId: Int
        get() = R.layout.activity_recycler
    override val viewModelClass: Class<MokoRecyclerViewModel>
        get() = MokoRecyclerViewModel::class.java
    override val viewModelVariableId: Int
        get() = BR.viewModel

    override fun viewModelFactory(): ViewModelProvider.Factory {
        return createViewModelFactory { MokoRecyclerViewModel(UnitFactoryImpl()) }
    }
}
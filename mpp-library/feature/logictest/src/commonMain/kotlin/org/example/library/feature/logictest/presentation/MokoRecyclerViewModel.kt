package org.example.library.feature.logictest.presentation

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import dev.icerock.moko.units.TableUnitItem

/**
Created by Denis Chornyy on 10,Июль,2020
All rights received.
 */
class MokoRecyclerViewModel(unitFactory: UnitFactory): ViewModel() {

    companion object {
        private const val url = "https://picsum.photos/200"
    }

    val items = listOf(
        unitFactory.createHeader("IceRock People"),
        unitFactory.createProfileTile(1, url, "Chornyy"),
        unitFactory.createProfileTile(2, url, "Usichenko"),
        unitFactory.createProfileTile(3, url, "Nesterov"),
        unitFactory.createProfileTile(4, url, "Shelar"),
        unitFactory.createProfileTile(5, url, "Minyaev"),
        unitFactory.createHeader("PMs"),
        unitFactory.createProfileTile(6, url, "Egorov"),
        unitFactory.createProfileTile(7, url, "Panchenko")
    )

    interface UnitFactory {
        fun createHeader(text: String): TableUnitItem
        fun createProfileTile(profileId: Long, avatarUrl: String, username: String): TableUnitItem
    }
}
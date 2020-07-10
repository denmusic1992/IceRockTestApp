package org.example.app.units

import dev.icerock.moko.units.TableUnitItem
import org.example.app.LayoutHeader
import org.example.app.LayoutProfileTile
import org.example.library.feature.logictest.presentation.MokoRecyclerViewModel

/**
Created by Denis Chornyy on 10,Июль,2020
All rights received.
 */
class UnitFactoryImpl: MokoRecyclerViewModel.UnitFactory {
    override fun createHeader(text: String): TableUnitItem {
        return LayoutHeader().apply {
            this.text = text
        }
    }

    override fun createProfileTile(
        profileId: Long,
        avatarUrl: String,
        username: String
    ): TableUnitItem {
        return LayoutProfileTile().apply {
            name = username
            url = avatarUrl
        }
    }
}
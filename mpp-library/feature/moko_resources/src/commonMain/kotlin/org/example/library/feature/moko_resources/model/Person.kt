package org.example.library.feature.moko_resources.model

import dev.icerock.moko.resources.desc.StringDesc

data class Person (
    val name: String,
    val age: Int,
    val greetings: StringDesc
)
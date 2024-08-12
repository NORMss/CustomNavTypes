package com.norm.mycustomnavtypes

import kotlinx.serialization.Serializable

@Serializable
data class Cat(
    val id: Int,
    val name: String,
)

enum class BreedSize {
    SMALL,
    MEDIUM,
    LARGE,
}
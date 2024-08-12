package com.norm.mycustomnavtypes

import android.net.Uri
import android.os.Bundle
import androidx.navigation.NavType
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeToSequence

object CustomNavType {
    val CatType = object : NavType<Cat>(
        isNullableAllowed = false
    ) {
        override fun get(bundle: Bundle, key: String): Cat? {
            return Json.decodeFromString(bundle.getString(key) ?: return null)
        }

        override fun parseValue(value: String): Cat {
            return Json.decodeFromString(Uri.decode(value))
        }

        override fun serializeAsValue(value: Cat): String {
            return Uri.encode(Json.encodeToString(value))
        }

        override fun put(bundle: Bundle, key: String, value: Cat) {
            bundle.putString(key, Json.encodeToString(value))
        }
    }
}
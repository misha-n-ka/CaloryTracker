package com.mkirilkinprojects.core.domain.models

sealed class ActivityLevel(val name: String) {
    object Low : ActivityLevel("low")
    object Medium : ActivityLevel("medium")
    object Hight : ActivityLevel("high")

    companion object {
        fun fromString(name: String?): ActivityLevel {
            return when (name) {
                "low" -> Low
                "medium" -> Medium
                "high" -> Hight
                else -> Hight
            }
        }
    }
}

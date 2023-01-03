package com.mkirilkinprojects.core.domain.preferences

import com.mkirilkinprojects.core.domain.models.ActivityLevel
import com.mkirilkinprojects.core.domain.models.Gender
import com.mkirilkinprojects.core.domain.models.GoalType
import com.mkirilkinprojects.core.domain.models.UserInfo

interface Preferences {

    fun saveGender(gender: Gender)
    fun saveAge(age: Int)
    fun saveWeight(weight: Float)
    fun saveHeight(height: Int)
    fun saveActivityLevel(level: ActivityLevel)
    fun saveGoalType(type: GoalType)
    fun saveCarbRatio(ratio: Float)
    fun saveProteinRatio(ratio: Float)
    fun saveFatRatio(ratio: Float)

    fun loadUserInfo(): UserInfo

    fun saveShouldShowOnboarding(shouldShow: Boolean)
    fun loadShouldShowOnboarding(): Boolean
}

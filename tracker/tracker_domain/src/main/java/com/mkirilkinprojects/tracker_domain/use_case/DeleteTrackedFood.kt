package com.mkirilkinprojects.tracker_domain.use_case

import com.mkirilkinprojects.tracker_domain.model.TrackedFood
import com.mkirilkinprojects.tracker_domain.repository.TrackerRepository

class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        food: TrackedFood
    ) {
        repository.deleteTrackedFood(food)
    }
}

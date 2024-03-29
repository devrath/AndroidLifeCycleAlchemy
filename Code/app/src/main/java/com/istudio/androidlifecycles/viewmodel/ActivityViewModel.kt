package com.istudio.androidlifecycles.viewmodel

import androidx.lifecycle.ViewModel

class ActivityViewModel: ViewModel() {

    private var activityRecreateCount = 0

    fun activityCreated() {
        activityRecreateCount++
    }

    fun getActivityRecreateCount(): Int {
        return activityRecreateCount
    }
}
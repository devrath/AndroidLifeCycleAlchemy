package com.istudio.androidlifecycles

import android.app.Application
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.istudio.androidlifecycles.configchanges.ConfigChangeActivity
import com.istudio.androidlifecycles.configchanges.ManualConfigChangeActivity
import com.istudio.androidlifecycles.fragments.FragmentHostActivity
import com.istudio.androidlifecycles.saveandrestore.SaveAndRestoreActivity
import com.istudio.androidlifecycles.service.ServiceActivity
import com.istudio.androidlifecycles.viewmodel.ViewModelActivity
import timber.log.Timber

class MainActivity : AppCompatActivity() {

    private lateinit var backgroundDetector: BackgroundDetector

    override fun onCreate(savedInstanceState: Bundle?) {

        Timber.i("onCreate()")

        val application = this.applicationContext as Application

        super.onCreate(savedInstanceState)

        backgroundDetector = (application as CustomApplication).backgroundDetector

        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btnNextActivity).setOnClickListener {
            SecondActivity.start(this)
        }

        findViewById<Button>(R.id.btnFragmentActivity).setOnClickListener {
            FragmentHostActivity.start(this)
        }

        findViewById<Button>(R.id.btnConfigChangeActivity).setOnClickListener {
            ConfigChangeActivity.start(this)
        }

        findViewById<Button>(R.id.btnManualConfigChangeActivity).setOnClickListener {
            ManualConfigChangeActivity.start(this)
        }

        findViewById<Button>(R.id.btnViewModelActivity).setOnClickListener {
            ViewModelActivity.start(this)
        }

        findViewById<Button>(R.id.btnSaveAndRestoreActivity).setOnClickListener {
            SaveAndRestoreActivity.start(this)
        }

        findViewById<Button>(R.id.btnServiceActivity).setOnClickListener {
            ServiceActivity.start(this)
        }
    }

    override fun onDestroy() {
        Timber.i("onDestroy()")
        super.onDestroy()
    }

    override fun onStart() {
        Timber.i("onStart()")
        super.onStart()
        backgroundDetector.activityStarted()
    }

    override fun onStop() {
        Timber.i("onStop()")
        super.onStop()
        backgroundDetector.activityStopped()
    }

    override fun onResume() {
        Timber.i("onResume()")
        super.onResume()
    }

    override fun onPause() {
        Timber.i("onPause()")
        super.onPause()
    }

    override fun onTopResumedActivityChanged(isTopResumedActivity: Boolean) {
        super.onTopResumedActivityChanged(isTopResumedActivity)
        Timber.i("onTopResumedActivityChanged(); isTopResumed: $isTopResumedActivity")
    }
}
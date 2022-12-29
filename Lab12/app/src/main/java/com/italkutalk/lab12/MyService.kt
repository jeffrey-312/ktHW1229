package com.italkutalk.lab12

import android.app.Service
import android.content.Intent
import android.os.IBinder
import kotlinx.coroutines.*

class MyService : Service() {

    override fun onCreate() {
        super.onCreate()
        GlobalScope.launch {
            try {
                delay(5000L)
                val intent = Intent(this@MyService, SecActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
            } catch (e: InterruptedException) {
                println(e)
            }
        }
    }

    override fun onStartCommand(intent: Intent, flags: Int, startid: Int): Int {
        return START_NOT_STICKY
    }

    override fun onBind(intent: Intent): IBinder? = null
///////////////////////////////////////////////////////////

}
suspend fun Wait() {
    delay(1000L)
}
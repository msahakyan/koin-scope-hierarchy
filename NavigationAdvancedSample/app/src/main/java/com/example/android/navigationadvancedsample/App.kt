package com.example.android.navigationadvancedsample

import android.app.Application
import android.util.Log
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import java.util.UUID

const val TAG = "Log"

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeKoin()
    }

    private fun initializeKoin() {
        startKoin {
            // Android context
            androidContext(this@App)
            // modules
            modules(androidModule, sessionModule, translationModule)
        }
    }
}

class Presenter(private val name: String) {

    fun present() =
        Log.d(TAG, "Presenting a $name")
}

class UserSession(uuid: UUID) {

    val sessionId: String = // UUID.randomUUID().toString()
        uuid.toString().filter { it.isDigit() }
}

class SessionManager(private val userSession: UserSession) {

    fun getSessionId() = userSession.sessionId

    fun dumpSession() = Log.e(TAG, "Dumping a session[${getSessionId()}]")
}

class SessionManagerHandler(private val sessionManager: SessionManager) {

    fun handleSessionDump() =
        Log.e(TAG, "Handling session dump => $sessionManager[${sessionManager.dumpSession()}]")
}
/*
 * Copyright 2019, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.navigationadvancedsample.listscreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.android.navigationadvancedsample.R
import com.example.android.navigationadvancedsample.ScopeAwareFragment
import com.example.android.navigationadvancedsample.SessionManager
import com.example.android.navigationadvancedsample.SessionManagerHandler
import com.example.android.navigationadvancedsample.TAG
import com.example.android.navigationadvancedsample.UserSession
import com.example.android.navigationadvancedsample.business.translator.Translator
import com.example.android.navigationadvancedsample.listscreen.MyAdapter.Companion.USERNAME_KEY
import org.koin.core.scope.inject
import java.util.Locale
import java.util.UUID


/**
 * Shows a profile screen for a user, taking the name from the arguments.
 */
class UserProfile : ScopeAwareFragment() {

    private val uuid: UUID by inject() // Application scoped!
    private val session: UserSession by inject() // Activity scoped!!
    private val sessionManager: SessionManager by inject() // Fragment scoped!!
    private val sessionManagerHandler: SessionManagerHandler by inject() // Fragment scoped!!
    private val translator: Translator by inject() // Fragment scoped from translation module!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_user_profile, container, false)
        val name = arguments?.getString(USERNAME_KEY) ?: "Ali Connors"
        view.findViewById<TextView>(R.id.profile_user_name).text = name
        return view
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "USER_PROFILE_ uuid = $uuid")
        Log.d(TAG, "USER_PROFILE_ sessionId = ${session.sessionId}")
        sessionManager.dumpSession()
        sessionManagerHandler.handleSessionDump()
        Log.d(TAG, "USER_PROFILE_ translation = ${translator.translate("poni", Locale.ENGLISH)}")
    }
}

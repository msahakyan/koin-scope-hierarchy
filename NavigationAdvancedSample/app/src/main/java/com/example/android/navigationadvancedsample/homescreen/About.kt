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

package com.example.android.navigationadvancedsample.homescreen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.android.navigationadvancedsample.Presenter
import com.example.android.navigationadvancedsample.R
import com.example.android.navigationadvancedsample.TAG
import com.example.android.navigationadvancedsample.UserSession
import org.koin.core.qualifier.named
import org.koin.core.scope.KoinScopeComponent
import org.koin.core.scope.Scope
import org.koin.core.scope.get
import org.koin.core.scope.inject
import org.koin.core.scope.newScope

/**
 * Shows "About"
 */
class About : Fragment() { /*, KoinScopeComponent {*/

//    override val scope: Scope by lazy { newScope() }
//    private val presenter: Presenter by inject()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_about, container, false)
    }

//    private fun reuseSession(): UserSession {
//        val ourSession = getKoin().getOrCreateScope("ourSession", named("session"))
//
//        // link ourSession scope to current `scope`, from ScopeActivity or ScopeFragment
//        scope.linkTo(ourSession)
//
//        // will look at MyActivity1's Scope + ourSession scope to resolve
//        return get()
//    }
//
//    override fun onResume() {
//        super.onResume()
//        presenter.present().also {
//            Log.d(TAG, "ABOUT_ Presenter $presenter")
//        }
////        Log.d(TAG, "ABOUT_ ${reuseSession().sessionId}")
//    }
}

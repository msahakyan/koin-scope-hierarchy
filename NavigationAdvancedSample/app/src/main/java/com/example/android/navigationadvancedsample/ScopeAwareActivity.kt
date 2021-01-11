package com.example.android.navigationadvancedsample

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import org.koin.core.scope.KoinScopeComponent
import org.koin.core.scope.Scope
import org.koin.core.scope.newScope

open class ScopeAwareActivity : AppCompatActivity(), KoinScopeComponent {

    override val scope: Scope by lazy { newScope() }

    private lateinit var activityScope: Scope

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityScope = createActivityScope()
    }

    private fun createActivityScope(): Scope =
        getKoin().createScope(SCOPE_ACTIVITY, ACTIVITY)
            .also {
                scope.linkTo(it)
            }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        scope.close()
        activityScope.close()
    }
}
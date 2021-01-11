package com.example.android.navigationadvancedsample

import android.os.Bundle
import androidx.annotation.CallSuper
import androidx.fragment.app.Fragment
import org.koin.core.scope.KoinScopeComponent
import org.koin.core.scope.Scope
import org.koin.core.scope.newScope

open class ScopeAwareFragment : Fragment(), KoinScopeComponent {

    override val scope: Scope by lazy { newScope() }

    private lateinit var fragmentScope: Scope

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentScope = linkFragmentScope()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        linkActivityScope()
    }

    private fun linkFragmentScope(): Scope =
        getKoin().getOrCreateScope(SCOPE_FRAGMENT, FRAGMENT)
            .also {
                scope.linkTo(it)
            }

    private fun linkActivityScope(): Scope =
        getKoin().getScope(SCOPE_ACTIVITY)
            .also {
                scope.linkTo(it)
            }

    @CallSuper
    override fun onDestroy() {
        super.onDestroy()
        scope.close()
        fragmentScope.close()
    }
}
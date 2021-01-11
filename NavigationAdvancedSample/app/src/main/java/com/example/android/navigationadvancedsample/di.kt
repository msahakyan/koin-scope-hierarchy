package com.example.android.navigationadvancedsample

import com.example.android.navigationadvancedsample.business.translator.TranslationService
import com.example.android.navigationadvancedsample.business.translator.TranslationServiceImpl
import com.example.android.navigationadvancedsample.business.translator.Translator
import com.example.android.navigationadvancedsample.formscreen.Registered
import com.example.android.navigationadvancedsample.homescreen.About
import com.example.android.navigationadvancedsample.homescreen.Title
import com.example.android.navigationadvancedsample.listscreen.UserProfile
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import java.util.UUID

val ACTIVITY = named("qualifier-activity")
val FRAGMENT = named("qualifier-fragment")

const val SCOPE_ACTIVITY = "scope-activity"
const val SCOPE_FRAGMENT = "scope-fragment"

val androidModule = module {

    single {
        "https://doc.insert-koin.io/#/koin-android/scope"
    }

    scope<Title> {
        scoped { Presenter(get()) }
    }

    scope<About> {
        scoped { Presenter(get()) }
    }

    scope<Registered> {}
    scope<UserProfile> {}
    scope<MainActivity> {}
}

val sessionModule = module {

    factory<UUID> {
        UUID.randomUUID()
    }

    // Shared user session data
    scope(ACTIVITY) {
        scoped {
            UserSession(
                uuid = get()
            )
        }

        scope(FRAGMENT) {
            scoped {
                SessionManager(userSession = getScope(SCOPE_ACTIVITY).get())
            }

            scoped {
                SessionManagerHandler(sessionManager = get())
            }
        }
    }
}

val translationModule = module {

    scope(ACTIVITY) {
        scoped<TranslationService> {
            TranslationServiceImpl(
                context = androidContext()
            )
        }
    }

    scope(FRAGMENT) {
        scoped {
            Translator(
                translationService = getScope(SCOPE_ACTIVITY).get()
            )
        }
    }

}
package com.example.android.navigationadvancedsample.business.translator

import android.content.Context
import android.util.Log
import com.example.android.navigationadvancedsample.R
import com.example.android.navigationadvancedsample.TAG
import java.util.Locale

class TranslationServiceImpl(private val context: Context) : TranslationService {

    private var initialized: Boolean = false
    private lateinit var locale: Locale

    override fun initialize(): Boolean {
        if (initialized.not()) {
            initialized = true
            Log.d(TAG, "Initializing...")
        } else {
            Log.d(TAG, "Already Initialized!")
        }
        return initialized
    }

    override fun setLocale(locale: Locale) {
        this.locale = locale
    }

    override fun translate(src: String): String =
        when (locale) {
            Locale.ENGLISH -> context.getString(R.string.placeholder_en_locale, src)
            Locale.GERMAN -> context.getString(R.string.placeholder_de_locale, src)
            else -> "Unsupported locale. Can't translate $src with locale ${locale.displayName}"
        }
}
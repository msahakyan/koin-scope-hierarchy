package com.example.android.navigationadvancedsample.business.translator

import java.util.Locale

interface TranslationService {

    fun initialize(): Boolean

    fun setLocale(locale: Locale)

    fun translate(src: String): String
}
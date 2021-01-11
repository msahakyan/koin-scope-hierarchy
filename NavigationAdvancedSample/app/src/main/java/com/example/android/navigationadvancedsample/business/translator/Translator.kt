package com.example.android.navigationadvancedsample.business.translator

import java.util.Locale

class Translator(private val translationService: TranslationService) {

    init {
        translationService.initialize()
    }

    fun translate(txt: String, locale: Locale): String =
        with(translationService) {
            setLocale(locale)
            translate(txt)
        }
}
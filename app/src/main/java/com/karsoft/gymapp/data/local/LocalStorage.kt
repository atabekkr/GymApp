package com.karsoft.gymapp.data.local

import android.content.Context
import com.karsoft.gymapp.app.App
import com.example.github.utils.BooleanPreference
import com.example.github.utils.StringPreference

class LocalStorage {

    companion object {
        val pref =
            App.instance.getSharedPreferences("GitHubSharedPref", Context.MODE_PRIVATE)
    }


    var isLogin by BooleanPreference(pref, false)

    var username by StringPreference(pref)

    var password by StringPreference(pref)

    var phone by StringPreference(pref)

}
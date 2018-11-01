package app.tez.daggertutokotlin.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Terence Zafindratafa on 31/10/2018
 */

private const val MY_PREF = "MY_PREF"
private const val KEY_CURRENT_EMAIL = "KEY_CURRENT_EMAIL"

class SharedPrefsUtils(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(MY_PREF, Context.MODE_PRIVATE)

    fun saveCurrentEmail(email: String) = prefs.edit().putString(KEY_CURRENT_EMAIL, email).apply()

    fun getCurrentEmail() = prefs.getString(KEY_CURRENT_EMAIL, "")
}
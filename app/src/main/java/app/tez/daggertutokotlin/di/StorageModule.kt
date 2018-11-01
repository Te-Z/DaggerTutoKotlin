package app.tez.daggertutokotlin.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import app.tez.daggertutokotlin.utils.SharedPrefsUtils

/**
 * Created by Terence Zafindratafa on 31/10/2018
 */

@Module
class StorageModule {

    @Provides
    @Singleton
    fun providesSharedPreferences(app: Context) = SharedPrefsUtils(app)
}
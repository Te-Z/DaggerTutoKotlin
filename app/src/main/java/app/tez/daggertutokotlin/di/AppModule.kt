package app.tez.daggertutokotlin.di

import android.content.Context
import dagger.Module
import dagger.Provides

/**
 * Created by Terence Zafindratafa on 31/10/2018
 */

@Module
class AppModule(private val context: Context) {

    @Provides
    fun providesApplicationContext(): Context = context
}
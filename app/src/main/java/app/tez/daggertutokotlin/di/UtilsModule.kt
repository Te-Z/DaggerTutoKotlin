package app.tez.daggertutokotlin.di

import app.tez.daggertutokotlin.utils.DateUtils
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * Created by Terence Zafindratafa on 31/10/2018
 */

@Module
class UtilsModule{

    @Provides
    @Singleton
    fun provideDateUtils(): DateUtils = DateUtils()
}
package app.tez.daggertutokotlin.di

import app.tez.daggertutokotlin.utils.DateUtils
import app.tez.daggertutokotlin.utils.DateUtilsUnitTest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class UtilsUnitTestModule {

    @Singleton
    @Provides
    fun provideDateUtils(): DateUtils = DateUtilsUnitTest()
}
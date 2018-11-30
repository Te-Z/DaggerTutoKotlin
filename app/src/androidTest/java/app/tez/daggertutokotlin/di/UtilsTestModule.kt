package app.tez.daggertutokotlin.di

import android.util.Log
import app.tez.daggertutokotlin.utils.DateUtils
import app.tez.daggertutokotlin.utils.DateUtilsTest
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class UtilsTestModule {

    @Provides
    @Singleton
    fun provideDateUtils(): DateUtils {
        Log.d("UtilsTestModule", "Injection..")
        return DateUtilsTest()
    }
}
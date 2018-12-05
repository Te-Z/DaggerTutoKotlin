package app.tez.daggertutokotlin.di

import app.tez.daggertutokotlin.MainActivityAndroidTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [StorageModule::class, UtilsTestModule::class, AppModule::class])
interface AndroidTestComponent: TutoComponent{

    fun inject(test: MainActivityAndroidTest)
}
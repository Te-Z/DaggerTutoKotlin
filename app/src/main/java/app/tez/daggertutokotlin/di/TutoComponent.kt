package app.tez.daggertutokotlin.di

import app.tez.daggertutokotlin.DaggerTutoApplication
import app.tez.daggertutokotlin.MainActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Terence Zafindratafa on 31/10/2018
 */

@Singleton
@Component(modules = [StorageModule::class, UtilsModule::class, AppModule::class])
interface TutoComponent {

    fun inject(application: DaggerTutoApplication)

    fun inject(mainActivity: MainActivity)
}
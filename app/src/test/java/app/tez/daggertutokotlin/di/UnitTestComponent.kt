package app.tez.daggertutokotlin.di

import app.tez.daggertutokotlin.base.TestDaggerTutoApplication
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [StorageModule::class, UtilsUnitTestModule::class, AppModule::class])
interface UnitTestComponent: TutoComponent {
    fun inject(application: TestDaggerTutoApplication)
}
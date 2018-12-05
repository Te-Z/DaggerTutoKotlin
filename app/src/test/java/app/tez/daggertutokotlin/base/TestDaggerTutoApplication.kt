package app.tez.daggertutokotlin.base

import app.tez.daggertutokotlin.DaggerTutoApplication
import app.tez.daggertutokotlin.di.*

class TestDaggerTutoApplication: DaggerTutoApplication() {

    override fun initDagger(): TutoComponent {
        val testComponent = DaggerUnitTestComponent.builder()
                .appModule(AppModule(this))
                .utilsUnitTestModule(UtilsUnitTestModule())
                .storageModule(StorageModule())
                .build() as UnitTestComponent
        testComponent.inject(this)

        return testComponent
    }
}
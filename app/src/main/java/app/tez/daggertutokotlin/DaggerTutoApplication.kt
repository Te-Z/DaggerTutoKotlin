package app.tez.daggertutokotlin

import android.app.Application
import app.tez.daggertutokotlin.di.*

/**
 * Created by Terence Zafindratafa on 31/10/2018
 */
class DaggerTutoApplication: Application() {

    private lateinit var tutoComponent: TutoComponent

    override fun onCreate() {
        super.onCreate()
        tutoComponent = DaggerTutoComponent.builder()
                .appModule(AppModule(this))
                .storageModule(StorageModule())
                .utilsModule(UtilsModule())
                .build()

        tutoComponent.inject(this)
    }

    fun getTutoComponent(): TutoComponent = tutoComponent
}
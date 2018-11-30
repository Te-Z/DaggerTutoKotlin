package app.tez.daggertutokotlin

import android.app.Application
import app.tez.daggertutokotlin.di.*

/**
 * Created by Terence Zafindratafa on 31/10/2018
 */
open class DaggerTutoApplication: Application() {

    lateinit var tutoComponent: TutoComponent

    override fun onCreate() {
        super.onCreate()
        tutoComponent = this.initDagger()

        tutoComponent.inject(this)
    }

    protected open fun initDagger(): TutoComponent =  DaggerTutoComponent.builder()
            .appModule(AppModule(this))
            .storageModule(StorageModule())
            .utilsModule(UtilsModule())
            .build()
}
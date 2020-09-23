package co.id.egiwibowo.imovie

import android.app.Application
import co.id.egiwibowo.imovie.data.di.DaggerDataComponent
import co.id.egiwibowo.imovie.data.di.DataComponent
import co.id.egiwibowo.imovie.di.AppComponent
import co.id.egiwibowo.imovie.di.DaggerAppComponent

open class MyApplication : Application() {

    private val dataComponent: DataComponent by lazy {
        DaggerDataComponent.factory().create(applicationContext)
    }

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(dataComponent)
    }


}
package co.id.egiwibowo.imovie.di

import co.id.egiwibowo.imovie.MainActivity
import co.id.egiwibowo.imovie.data.di.DataComponent
import co.id.egiwibowo.imovie.ui.home.HomeFragment
import dagger.Component

@AppScope
@Component(
    dependencies = [DataComponent::class],
    modules = [AppModule::class, ViewModelModule::class]
)
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(dataComponent: DataComponent): AppComponent
    }

    fun inject(activity: MainActivity)
    fun inject(fragment: HomeFragment)
}
package co.id.egiwibowo.imovie.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.id.egiwibowo.imovie.MainViewModel
import co.id.egiwibowo.imovie.ui.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel
}
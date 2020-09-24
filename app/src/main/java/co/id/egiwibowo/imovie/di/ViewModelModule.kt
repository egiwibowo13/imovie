package co.id.egiwibowo.imovie.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import co.id.egiwibowo.imovie.MainViewModel
import co.id.egiwibowo.imovie.abstraction.utils.viewmodel.ViewModelFactory
import co.id.egiwibowo.imovie.abstraction.utils.viewmodel.ViewModelKey
import co.id.egiwibowo.imovie.presentation.home.HomeViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @AppScope
    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    abstract fun bindHomeViewModel(viewModel: HomeViewModel): ViewModel
}
package uz.wiut.lineup.lineup.ui.common.di

import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.utils.Navigator
import javax.inject.Named

/**
 * Created by Shohruh on 20-Apr-18.
 */
@Module
abstract class BaseFragmentModule {
    companion object {
        const val BASE_FRAGMENT_MANAGER = "BaseFragmentModule.baseFragmentManager"
        const val FRAGMENT_NAVIGATOR = "BaseFragmentModule.navigator"
    }

    @Binds
    @Named(FRAGMENT_NAVIGATOR)
    @PerFragment
    abstract fun bindNavigator (navigator: Navigator) : Navigator
}
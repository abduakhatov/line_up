package uz.wiut.lineup.lineup.ui.common.di

import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity
import uz.wiut.lineup.lineup.utils.Navigator
import javax.inject.Named

/**
 * Created by Shohruh on 07-Mar-18.
 */
@Module
abstract class BaseActivityModule {

    companion object {
        const val ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager"
        const val ACTIVITY_NAVIGATOR = "BaseActivityModule.navigator"
    }

    @Binds
    @Named(ACTIVITY_NAVIGATOR)
    @PerActivity
    abstract fun bindNavigator (navigator: Navigator) : Navigator
}
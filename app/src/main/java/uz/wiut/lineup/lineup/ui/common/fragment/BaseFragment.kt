package uz.wiut.lineup.lineup.ui.common.fragment

import dagger.android.support.DaggerFragment
import uz.wiut.lineup.lineup.ui.common.di.BaseActivityModule
import uz.wiut.lineup.lineup.ui.common.di.BaseFragmentModule
import uz.wiut.lineup.lineup.utils.Navigator
import javax.inject.Inject
import javax.inject.Named

/**
 * Created by Shohruh on 20-Apr-18.
 */
abstract class BaseFragment : DaggerFragment() {

    @Inject
    @Named(BaseFragmentModule.FRAGMENT_NAVIGATOR)
    lateinit var navigator: Navigator
}
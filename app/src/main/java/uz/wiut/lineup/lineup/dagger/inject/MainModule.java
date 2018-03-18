package uz.wiut.lineup.lineup.dagger.inject;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity;
import uz.wiut.lineup.lineup.ui.common.BaseActivity;
import uz.wiut.lineup.lineup.ui.common.BaseActivityModule;
import uz.wiut.lineup.lineup.ui.main.MainActivity;
import uz.wiut.lineup.lineup.ui.main.di.MainActivityModule;
import uz.wiut.lineup.lineup.ui.test.TestActivity;
import uz.wiut.lineup.lineup.ui.test.di.TestActivityModule;

/**
 * Created by Shohruh on 09-Mar-18.
 */

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class MainModule {
    @PerActivity
    @ContributesAndroidInjector(modules = TestActivityModule.class)
    abstract TestActivity contributeTestActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = BaseActivityModule.class)
    abstract BaseActivity contributeBaseActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivity();
}

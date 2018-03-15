package uz.wiut.lineup.lineup.dagger.inject;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity;
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
}

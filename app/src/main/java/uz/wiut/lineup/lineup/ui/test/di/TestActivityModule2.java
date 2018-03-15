package uz.wiut.lineup.lineup.ui.test.di;

import android.support.v7.app.AppCompatActivity;

import dagger.Binds;
import dagger.Module;
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity;
import uz.wiut.lineup.lineup.ui.test.TestActivity;
import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenter;
import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenterImpl;
import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenterView;

/**
 * Created by Shohruh on 09-Mar-18.
 */

@Module
abstract public class TestActivityModule2 {
    @Binds
    @PerActivity
    abstract AppCompatActivity provideTestActivity(TestActivity activity);
    @Binds
    @PerActivity
    abstract TestActivityPresenterView provideTestActivityBaseView(TestActivity activity);
    @Binds
    @PerActivity
    abstract TestActivityPresenter provideTestActivityPresenter(TestActivityPresenterImpl presenter);
}

package uz.wiut.lineup.lineup.dagger.inject;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity;
import uz.wiut.lineup.lineup.dagger.inject.inject.PerChildFragment;
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment;
import uz.wiut.lineup.lineup.ui.bookmarks.BookmarkFragment;
import uz.wiut.lineup.lineup.ui.bookmarks.di.BookmarkFragmentModule;
import uz.wiut.lineup.lineup.ui.bookmarks.di.fragments.HistoryFragmentModule;
import uz.wiut.lineup.lineup.ui.bookmarks.di.fragments.SavedFragmentModule;
import uz.wiut.lineup.lineup.ui.bookmarks.fragments.HistoryOfBookmarksFragment;
import uz.wiut.lineup.lineup.ui.bookmarks.fragments.SavedBookmarkFragment;
import uz.wiut.lineup.lineup.ui.common.BaseActivity;
import uz.wiut.lineup.lineup.ui.common.di.BaseActivityModule;
import uz.wiut.lineup.lineup.ui.common.di.BaseFragmentModule;
import uz.wiut.lineup.lineup.ui.common.fragment.BaseFragment;
import uz.wiut.lineup.lineup.ui.organizationDetails.OrganizationDetailsActivity;
import uz.wiut.lineup.lineup.ui.home.di.HomeFragmentModule;
import uz.wiut.lineup.lineup.ui.organizationDetails.di.OrganizationDetailsActivityModule;
import uz.wiut.lineup.lineup.ui.organizationDetails.di.OrganizationDetailsFragmentModule;
import uz.wiut.lineup.lineup.ui.home.HomeFragment;
import uz.wiut.lineup.lineup.ui.organizationDetails.fragments.OrganizationDetailsFragment;
import uz.wiut.lineup.lineup.ui.main.HomeActivity;
import uz.wiut.lineup.lineup.ui.main.MainActivity;
import uz.wiut.lineup.lineup.ui.main.di.HomeActivityModule;
import uz.wiut.lineup.lineup.ui.main.di.MainActivityModule;
import uz.wiut.lineup.lineup.ui.my_profile.MyProfileFragment;
import uz.wiut.lineup.lineup.ui.my_profile.di.MyProfileFragmentModule;
import uz.wiut.lineup.lineup.ui.search.SearchFragment;
import uz.wiut.lineup.lineup.ui.search.di.CategorySearchFragmentModule;
import uz.wiut.lineup.lineup.ui.search.di.CitySearchFragmentModule;
import uz.wiut.lineup.lineup.ui.search.di.MapSearchFragmentModule;
import uz.wiut.lineup.lineup.ui.search.di.SearchFragmentModule;
import uz.wiut.lineup.lineup.ui.search.fragments.CategorySearchFragment;
import uz.wiut.lineup.lineup.ui.search.fragments.CitySearchFragment;
import uz.wiut.lineup.lineup.ui.search.fragments.MapSearchFragment;
import uz.wiut.lineup.lineup.ui.sign_up_in.SignInUpActivity;
import uz.wiut.lineup.lineup.ui.sign_up_in.di.SignInFragmentModule;
import uz.wiut.lineup.lineup.ui.sign_up_in.di.SignUpFragmentModule;
import uz.wiut.lineup.lineup.ui.sign_up_in.di.SignUpInActivityModule;
import uz.wiut.lineup.lineup.ui.sign_up_in.di.VerificationFragmentModule;
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignInFragment;
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.SignUpFragment;
import uz.wiut.lineup.lineup.ui.sign_up_in.fragments.VerificationFragment;
import uz.wiut.lineup.lineup.ui.splash.SplashScreenActivity;
import uz.wiut.lineup.lineup.ui.splash.di.SplashScreenModule;
import uz.wiut.lineup.lineup.ui.test.TestActivity;
import uz.wiut.lineup.lineup.ui.test.di.TestActivityModule;

/**
 * Created by Shohruh on 09-Mar-18.
 */

@Module(includes = AndroidSupportInjectionModule.class)
public abstract class MainModule {

    // Activities
    @PerActivity
    @ContributesAndroidInjector(modules = TestActivityModule.class)
    abstract TestActivity contributeTestActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = BaseActivityModule.class)
    abstract BaseActivity contributeBaseActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity contributeMainActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = SplashScreenModule.class)
    abstract SplashScreenActivity contributeSplashScreenActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = SignUpInActivityModule.class)
    abstract SignInUpActivity contributeSignInUpActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = HomeActivityModule.class)
    abstract HomeActivity contributeHomeActivity();

    @PerActivity
    @ContributesAndroidInjector(modules = OrganizationDetailsActivityModule.class)
    abstract OrganizationDetailsActivity contributeDetailsActivity();


    // Fragments
    @PerFragment
    @ContributesAndroidInjector(modules = BaseFragmentModule.class)
    abstract BaseFragment contributeBaseFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = SignInFragmentModule.class)
    abstract SignInFragment contributeSignInFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = SignUpFragmentModule.class)
    abstract SignUpFragment contributeSignUpFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = VerificationFragmentModule.class)
    abstract VerificationFragment contributeVerificationFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = SearchFragmentModule.class)
    abstract SearchFragment contributeSearchFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = MyProfileFragmentModule.class)
    abstract MyProfileFragment contributeMyProfileFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = HomeFragmentModule.class)
    abstract HomeFragment contributeHomeFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = OrganizationDetailsFragmentModule.class)
    abstract OrganizationDetailsFragment contributeOrganizationDetailsFragment();

    @PerFragment
    @ContributesAndroidInjector(modules = BookmarkFragmentModule.class)
    abstract BookmarkFragment contributeBookmarkFragment();


    // Child  Fragments
    @PerChildFragment
    @ContributesAndroidInjector(modules = CategorySearchFragmentModule.class)
    abstract CategorySearchFragment contributeCategorySearchFragment();

    @PerChildFragment
    @ContributesAndroidInjector(modules = CitySearchFragmentModule.class)
    abstract CitySearchFragment contributeCitySearchFragment();

    @PerChildFragment
    @ContributesAndroidInjector(modules = MapSearchFragmentModule.class)
    abstract MapSearchFragment contributeMapSearchFragment();

    @PerChildFragment
    @ContributesAndroidInjector(modules = SavedFragmentModule.class)
    abstract SavedBookmarkFragment contributeSavedFragmentFragment();

    @PerChildFragment
    @ContributesAndroidInjector(modules = HistoryFragmentModule.class)
    abstract HistoryOfBookmarksFragment contributeHistoryFragment();


}

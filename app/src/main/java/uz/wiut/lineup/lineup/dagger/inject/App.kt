package uz.wiut.lineup.lineup.dagger.inject

import android.app.Activity
import android.app.Application
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.DaggerApplication
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject


/**
 * Created by Shohruh on 07-Mar-18.
 */
public class App : Application(),HasActivityInjector {
    @Inject
    lateinit var activityInjector : DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder().application(this).build().inject(this)

    }

    override fun activityInjector(): AndroidInjector<Activity> = activityInjector
}
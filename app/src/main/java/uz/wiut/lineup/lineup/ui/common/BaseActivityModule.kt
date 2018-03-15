package uz.wiut.lineup.lineup.ui.common

import android.app.Activity
import android.app.FragmentManager
import android.content.Context
import android.support.v7.app.AppCompatActivity

import javax.inject.Named

import dagger.Binds
import dagger.Module
import dagger.Provides
import uz.wiut.lineup.lineup.dagger.inject.inject.PerActivity

//    companion object {

/**
 * Created by Shohruh on 07-Mar-18.
 */
//@Module
abstract class BaseActivityModule {
    var ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager"

//    @Provides
//    @Named("BaseActivityModule.activityFragmentManager")
//    @PerActivity
//    public fun activityFragmentManager(activity: AppCompatActivity): android.support.v4.app.FragmentManager = activity.supportFragmentManager
}
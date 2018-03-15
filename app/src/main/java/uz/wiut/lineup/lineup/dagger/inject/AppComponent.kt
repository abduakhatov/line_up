package uz.wiut.lineup.lineup.dagger.inject

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


/**
 * Created by Shohruh on 07-Mar-18.
 */
@Singleton
@Component(modules = arrayOf(AndroidSupportInjectionModule::class, MainModule::class))
interface AppComponent{
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application:App): Builder
        fun build(): AppComponent
    }

    fun inject (app:App)
}
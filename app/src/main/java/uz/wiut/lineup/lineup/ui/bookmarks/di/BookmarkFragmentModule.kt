package uz.wiut.lineup.lineup.ui.bookmarks.di

import android.support.v4.app.Fragment
import dagger.Binds
import dagger.Module
import uz.wiut.lineup.lineup.dagger.inject.inject.PerFragment
import uz.wiut.lineup.lineup.ui.bookmarks.BookmarkFragment

/**
 * Created by Shohruh on 22-Apr-18.
 */
@Module
abstract class BookmarkFragmentModule {
    @Binds
    @PerFragment
    abstract fun bindBookmartFragment (fragment: BookmarkFragment) : Fragment
}
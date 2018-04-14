package uz.wiut.lineup.lineup.ui.home.adapter

import android.util.SparseArray
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.app.FragmentStatePagerAdapter
import android.view.ViewGroup

/**
 * Created by Shohruh on 13-Apr-18.
 */
abstract class NavBarFragmentStatePagerAdapter<T : Fragment> : FragmentPagerAdapter {

    private val registeredFragments = SparseArray<T>()

    constructor(fm: FragmentManager?) : super(fm)

    // Register the fragment when the item is instantiated
    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val fragment = super.instantiateItem(container, position) as T
        registeredFragments.put(position, fragment)
        return fragment
    }

    // Unregister when the item is inactive
    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        registeredFragments.remove(position)
        super.destroyItem(container, position, `object`)
    }

    // Returns the fragment for the position (if instantiated)
    fun getRegisteredFragment(position: Int): T {
        return registeredFragments.get(position)
    }

}
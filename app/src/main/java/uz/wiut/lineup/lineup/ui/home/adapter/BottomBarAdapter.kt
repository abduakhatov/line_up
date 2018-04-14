package uz.wiut.lineup.lineup.ui.home.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager

/**
 * Created by Shohruh on 13-Apr-18.
 */
class BottomBarAdapter : NavBarFragmentStatePagerAdapter<Fragment> {

    private val fragments = ArrayList<Fragment>()

    constructor(fm: FragmentManager?) : super(fm)

    fun addFragments(fragment: Fragment) {
        fragments.add(fragment)
    }

    override fun getItem(position: Int): Fragment {
        return fragments.get(position);
    }

    override fun getCount(): Int {
        return fragments.size;
    }
}
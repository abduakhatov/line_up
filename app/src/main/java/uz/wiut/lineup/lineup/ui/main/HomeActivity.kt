package uz.wiut.lineup.lineup.ui.main

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.support.annotation.ColorRes
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.widget.Toolbar
import butterknife.BindView
import butterknife.ButterKnife
import co.revely.gradient.RevelyGradient
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import com.aurelhubert.ahbottomnavigation.notification.AHNotification
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.bookmarks.fragments.BookmarkFragment
import uz.wiut.component.utils.ui.NoSwipePager
import uz.wiut.lineup.lineup.ui.home.fragments.HomeFragment
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.ui.home.adapter.BottomBarAdapter
import uz.wiut.lineup.lineup.ui.my_profile.MyProfileFragment
import uz.wiut.lineup.lineup.ui.search.SearchFragment


class HomeActivity : AppCompatActivity() {

    @BindView(R.id.bottom_navigation)
    lateinit var bottomNavigation: AHBottomNavigation
    @BindView(R.id.toolbar)
    lateinit var toolbar: Toolbar
    @BindView(R.id.viewpager)
    lateinit var viewPager: NoSwipePager


    private lateinit var pagerAdapter: BottomBarAdapter
    private var notificationVisible : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_main)
        ButterKnife.bind(this)
        initUI()
//        changeFragment(HomeFragment.newInstance())
    }

    fun initUI(){
        setupViewPager();
        val item1 = AHBottomNavigationItem("Home", R.drawable.ic_pass)
        val item2 = AHBottomNavigationItem("Search", R.drawable.ic_pass)
        val item3 = AHBottomNavigationItem("Bookmark", R.drawable.ic_pass)
        val item4 = AHBottomNavigationItem("Profile", R.drawable.ic_pass)

        bottomNavigation.addItem(item1)
        bottomNavigation.addItem(item2)
        bottomNavigation.addItem(item3)
        bottomNavigation.addItem(item4)
        bottomNavigation.setCurrentItem(0)
        bottomNavigation.setOnTabSelectedListener(object: AHBottomNavigation.OnTabSelectedListener{
            override fun onTabSelected(position:Int, wasSelected:Boolean):Boolean {
                if (!wasSelected)
                    viewPager.setCurrentItem(position);

                // remove notification badge
                val lastItemPos = bottomNavigation.getItemsCount() - 1
                if (notificationVisible && position == lastItemPos)
                    bottomNavigation.setNotification(AHNotification(), lastItemPos)
                return true
            }
        })
        bottomNavigation.setDefaultBackgroundColor(Color.WHITE)
        bottomNavigation.setAccentColor(fetchColor(R.color.grad_blue_light))
        bottomNavigation.setInactiveColor(fetchColor(R.color.nav_bar_icon))
        bottomNavigation.setTitleState(AHBottomNavigation.TitleState.ALWAYS_SHOW)
        bottomNavigation.setTranslucentNavigationEnabled(true)
        bottomNavigation.setBehaviorTranslationEnabled(true);
        createFakeNotification()

        RevelyGradient.linear()
                .angle(45f)
                .colors(Constants.arrOfColsToolbar)
                .onBackgroundOf(toolbar)

    }

    private fun setupViewPager() {
        viewPager.setPagingEnabled(false);
        pagerAdapter = BottomBarAdapter(getSupportFragmentManager())

        pagerAdapter.addFragments(HomeFragment.newInstance());
        pagerAdapter.addFragments(SearchFragment.newInstance());
        pagerAdapter.addFragments(BookmarkFragment.newInstance());
        pagerAdapter.addFragments(MyProfileFragment.newInstance());

        viewPager.setAdapter(pagerAdapter);
    }

    private fun createFakeNotification() {
        Handler().postDelayed({
            var notification = AHNotification.Builder()
                    .setText("1")
                    .setBackgroundColor(Color.RED)
                    .setTextColor(Color.WHITE)
                    .build();
            // Adding notification to last item.

            bottomNavigation.setNotification(notification, bottomNavigation.getItemsCount() - 1);

            notificationVisible = true;
        }, 1000)
    }

    private fun fetchColor(@ColorRes color: Int): Int {
        return ContextCompat.getColor(this, color)
    }

    private fun changeFragment(fragment: Fragment) {
        if (fragment != null) {
            supportFragmentManager
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.flMainContent, fragment)
                    .commit()

//            navigator?.startActivity(this, fragment)
        }
    }
}

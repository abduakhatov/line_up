package uz.wiut.lineup.lineup.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.design.widget.NavigationView
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.bookmarks.fragments.BookmarkFragment
import uz.wiut.lineup.lineup.ui.common.BaseActivity
import uz.wiut.lineup.lineup.ui.home.fragments.HomeFragment
import uz.wiut.lineup.lineup.ui.main.pv.MainActivityPresenterImpl
import uz.wiut.lineup.lineup.ui.main.pv.MainActivityView
import uz.wiut.lineup.lineup.ui.message.MessagesActivity
import uz.wiut.lineup.lineup.ui.my_profile.MyProfileFragment
import uz.wiut.lineup.lineup.ui.search.SearchFragment
import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenterImpl
import javax.inject.Inject

class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener, MainActivityView{

    @Inject
    lateinit var presenter : MainActivityPresenterImpl

    fun start(context: Context) {
        navigator.startActivity(this, this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar = findViewById<View>(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)
        val fab = findViewById<View>(R.id.fab) as FloatingActionButton
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        val toggle = ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<View>(R.id.nav_view) as NavigationView
        navigationView.setNavigationItemSelectedListener(this)

        initUI()
    }

    fun initUI(){
        changeFragment(HomeFragment.newInstance())
    }

    override fun onBackPressed() {
        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.nav_home) {
            changeFragment(HomeFragment.newInstance())
        } else if (id == R.id.nav_search) {
            changeFragment(SearchFragment.newInstance())
        } else if (id == R.id.nav_bookmark) {
            changeFragment(BookmarkFragment.newInstance())
        } else if (id == R.id.nav_my_profile) {
            changeFragment(MyProfileFragment.newInstance())
        } else if (id == R.id.nav_message) {
            navigator.startActivity(this, MainActivity())
        }

        val drawer = findViewById<View>(R.id.drawer_layout) as DrawerLayout
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun changeFragment(fragment: Fragment) {
//        if (fragment != null) {
//            supportFragmentManager
//            getSupportFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.flMainContent, fragment)
//                    .commit()
//
//            navigator?.startActivity(this, fragment)
//        }
    }

}
package uz.wiut.lineup.lineup.ui.search.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.search.mvp.map.MapSearchFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.search.mvp.map.MapSearchFragmentView
import javax.inject.Inject

/**
 * Created by abduakhatov on 1/17/18 at 6:40 PM.
 */
class MapSearchFragment : DaggerFragment(), MapSearchFragmentView {

    @Inject
    lateinit var presenter : MapSearchFragmentPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_map, container, false)
    }
}
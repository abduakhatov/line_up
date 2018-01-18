package uz.wiut.lineup.lineup.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.wiut.lineup.lineup.R

/**
 * Created by abduakhatov on 1/17/18 at 6:41 PM.
 */
class CategorySearchFragment : Fragment(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_search_category, container, false)
    }
}
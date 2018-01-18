package uz.wiut.lineup.lineup.search

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.search.adapters.SeachListAdapter

/**
 * Created by abduakhatov on 1/17/18 at 12:46 PM.
 */

class NameSearchFragment : Fragment(){

    override fun onCreate(savedInstanceState: Bundle?) = super.onCreate(savedInstanceState)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_search_category, container, false)
        val adapter = SeachListAdapter(this.context, ArrayList())
        val rvSearchList = view.findViewById<View>(R.id.rvSearchList) as RecyclerView

        val llManager = LinearLayoutManager(this.context)

        rvSearchList.layoutManager = llManager
        rvSearchList.adapter = adapter
        return view
    }


    private val openClosed = booleanArrayOf(true, false, true, false, true, false, true, false)
    private val orgs = arrayOf("Organization One", "Organization Two",
            "Organization Three", "Organization Four", "Organization Five",
            "Organization Six", "Organization Seven", "Organization Eight")
    private val location = arrayOf("Tashkent, Uzbekistan", "Shymkent, Kazakhstan",
            "Tashkent, Uzbekistan", "Tashkent, Uzbekistan",
            "Samarkand, Uzbekistan", "Fergana, Uzbekistan",
            "Namangan, Uzbekistan", "Tashkent, Uzbekistan")
    private val distance = floatArrayOf(1f, 2f, 3f, 4f, 5f, 6f, 7f, 8f)
}
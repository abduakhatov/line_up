package uz.wiut.lineup.lineup.ui.my_profile

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import butterknife.BindView
import butterknife.ButterKnife
import uz.wiut.component.utils.ui.ripleEffect.RippleBackground
import uz.wiut.lineup.lineup.R

class MyProfileFragment : Fragment() {

    @BindView(R.id.btnSave)
    lateinit var btnSave : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_my_profile, container, false) as View
        ButterKnife.bind(this, view)

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = MyProfileFragment()
    }


}

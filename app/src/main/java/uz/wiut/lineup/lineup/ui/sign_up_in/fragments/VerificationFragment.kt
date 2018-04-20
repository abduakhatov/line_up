package uz.wiut.lineup.lineup.ui.sign_up_in.fragments


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.android.support.DaggerFragment

import uz.wiut.lineup.lineup.R
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.Verification.VerificationFragmentPresenterImpl
import uz.wiut.lineup.lineup.ui.sign_up_in.mvp.Verification.VerificationFragmentView
import javax.inject.Inject


class VerificationFragment : DaggerFragment(), VerificationFragmentView{
    @Inject
    lateinit var presenter : VerificationFragmentPresenterImpl


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_verification, container, false)
    }

}
package uz.wiut.lineup.lineup.ui.test

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import uz.wiut.lineup.lineup.ui.common.BaseActivity
import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenterImpl
import uz.wiut.lineup.lineup.ui.test.presenter.TestActivityPresenterView
import javax.inject.Inject

/**
 * Created by Shohruh on 09-Mar-18.
 */
class TestActivity : BaseActivity(), TestActivityPresenterView {
    @Inject
    lateinit var presenter : TestActivityPresenterImpl

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var tv : TextView = TextView(this)
        tv.setText("Helloo")
        tv.setOnClickListener(View.OnClickListener {
            // todo
            presenter.touch()
        })
        setContentView(tv)
    }

    override fun callPhone() {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        Toast.makeText(this, "call helloo", Toast.LENGTH_LONG).show()
    }

}
package uz.wiut.lineup.lineup.utils

import android.graphics.Color
import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by abduakhatov on 1/19/18 at 1:01 AM.
 */
class Constants {
    companion object {
        val OPEN = "Open"
        val CLOSED = "Closed"
        val BREAK = "Break"
        val DEBUG = "==========>"
        val SIGN_CLICK_LISTENER = "SignInClickListener"
        val AUTH = "Authentification"
        val IS_FOR_SIGN_UP = "isForSignUp"
        val ORG_DETAIL = "Organization Details"

        val arrOfColsToolbar = intArrayOf(Color.parseColor("#0072ff"), Color.parseColor("#2acffd"))
        val arrOfCols = intArrayOf(Color.parseColor("#0072ff"), Color.parseColor("#21bae4"))
        val instagCOls = intArrayOf(Color.parseColor("#FF2525"), Color.parseColor("#6078EA"))
        val arrOfColsBelowToolbar = intArrayOf(Color.parseColor("#006aed"), Color.parseColor("#21bae4"))


        fun getTimestamp() : Long{
            val cal = Calendar.getInstance() // locale-specific
            cal.setTime(Date())
            cal.set(Calendar.HOUR_OF_DAY, 0)
            cal.set(Calendar.MINUTE, 0)
            cal.set(Calendar.SECOND, 0)
            cal.set(Calendar.MILLISECOND, 0)
            return cal.getTimeInMillis()
        }

        fun getDate(timestamp: Long?, format: String) : String{
            return SimpleDateFormat(format).format(Date(timestamp!!))
        }
    }
}
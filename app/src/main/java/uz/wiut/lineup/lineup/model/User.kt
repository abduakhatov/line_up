package uz.wiut.lineup.lineup.model

import android.telephony.cdma.CdmaCellLocation
import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties

/**
 * Created by Shohruh on 20-Apr-18.
 */
//@IgnoreExtraProperties
class User(){
    var dqId: String? = null
    var isMale: Boolean = false
    var phoneNumber: String? = null
    var oSubUserOrganizaitons: List<SubUserOrganizaiton>? = null
    var name: String? = null
    var password: String? = null

//    @Exclude
}

class SubUserOrganizaiton() {
    var category: String? = null
    var location: String? = null
    var oId: String? = null
}
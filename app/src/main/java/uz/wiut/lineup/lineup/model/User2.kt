package uz.wiut.lineup.lineup.model

import android.telephony.cdma.CdmaCellLocation

/**
 * Created by Shohruh on 20-Apr-18.
 */

class User(){
    var dqId: String? = null
    var isMale: Boolean? = null
    var phoneNumber: String? = null
    var oSubUserOrganizaitons: List<SubUserOrganizaiton>? = null
    var name: String? = null
    var password: String? = null
}

class SubUserOrganizaiton() {
    var category: String? = null
    var location: String? = null
    var oId: String? = null
}
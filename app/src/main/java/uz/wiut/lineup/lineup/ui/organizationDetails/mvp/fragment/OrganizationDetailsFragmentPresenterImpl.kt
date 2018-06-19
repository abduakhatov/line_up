package uz.wiut.lineup.lineup.ui.organizationDetails.mvp.fragment

import android.telephony.SmsManager
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import android.R.attr.key
import com.google.firebase.database.*
import uz.wiut.lineup.lineup.model.*
import uz.wiut.lineup.lineup.utils.Constants
import uz.wiut.lineup.lineup.utils.events.OrgDetails
import java.util.*


/**
 * Created by Shohruh on 20-Apr-18.
 */
class OrganizationDetailsFragmentPresenterImpl : OrganizationDetailsFragmentPresenter {
    @Inject
    lateinit var view: OrganizationDetailsFragmentView

    private var mAuth: FirebaseAuth?
    private var dbRef: DatabaseReference
    private var uid: String?
    private lateinit var org: Organization
    private lateinit var regedOrg: RegisteredOrganization

    private var user: User? = null


    @Inject
    constructor() {
        mAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference("v1")
        uid = mAuth?.currentUser?.uid
    }


    override fun onRegisterClicked(networkAvailable: Boolean, orgDetails: OrgDetails) {
        org = orgDetails.org!!
        regedOrg = orgDetails.regedOrg!!
        if (!networkAvailable) sendSMS(org.locationTitle, org.categoryTitle, org.oId)

        dbRef.child("usersList/clients/${uid}").addListenerForSingleValueEvent(object : ValueEventListener {//todo look at path
            override fun onDataChange(p0: DataSnapshot ) {
                if (p0 == null) return
                user = p0.getValue<User>(User::class.java)!!
                saveQueueData()
            }

            override fun onCancelled(p0: DatabaseError ) {

            }
        })
    }

    private fun saveQueueData() {
        var queueUrl = "dailyQueues/${regedOrg.timestamp}/${regedOrg.location}/${regedOrg.category}/${regedOrg.oId}/${regedOrg.queueId}/peopleWaiting/${uid}"
        var wp =  WaitingPeople()

        wp.name = user?.name
        wp.phoneNumber = user?.phoneNumber

        dbRef.child(queueUrl).setValue(wp)

        saveToHistory()
    }

    private fun saveToHistory() {
        var history = History()
        history.category = regedOrg.category
        history.lastVisit = regedOrg.timestamp
        history.location = regedOrg.location
        history.oId = regedOrg.oId

        var historyUrl = "histories/${uid}"
        var key = dbRef.child(historyUrl).push().key
        dbRef.child(historyUrl).child(key!!).setValue(history)

        saveToUsersList()
    }

    private fun saveToUsersList() {
        var userUrl = "usersList/clients/${uid}/dQId/${regedOrg.queueId}"
        dbRef.child(userUrl).setValue(regedOrg)
        view.saved()
    }

    fun sendSMS(location: String?, category: String?, orgId: String?) {
        var number = "0789"
        var smsBody = "navbt ${location}_${category}_${orgId}_${uid}"
        try {
            val sms = SmsManager.getDefault()  // using android SmsManager
            sms.sendTextMessage(number, null, smsBody, null, null)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
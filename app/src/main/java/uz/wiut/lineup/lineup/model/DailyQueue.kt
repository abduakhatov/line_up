package uz.wiut.lineup.lineup.model

import java.util.*

/**
 * Created by Shohruh on 23-Apr-18.
 */

class DailyQueue() {

    var averageWaitingTime: Int = 0
    var isActive: Boolean = false
    var peopleWaiting: List<WaitingPeople>? = null

}

class WaitingPeople() {
    var name: String? = null
    var phoneNumber: String? = null
    var registrationTime: Long = Date().time
}
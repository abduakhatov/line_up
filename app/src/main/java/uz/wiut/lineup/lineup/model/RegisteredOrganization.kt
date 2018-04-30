package uz.wiut.lineup.lineup.model

import uz.wiut.lineup.lineup.utils.Constants
import java.io.Serializable

/**
 * Created by abduakhatov on 2/5/18 at 3:58 PM.
 */
class RegisteredOrganization : Serializable {
    var queueId: String? = null
    var averageWaitingTime: Int = 0
    var category: String? =null
    var location: String? =null
    var oId: String? =null
    var peopleWaiting: Int = 0
    var timestamp: Long = Constants.getTimestamp()

    constructor()
    constructor(queueId: String?, averageWaitingTime: Int, category: String?, location: String?, oId: String?, peopleWaiting: Int, timestamp: Long) {
        this.queueId = queueId
        this.averageWaitingTime = averageWaitingTime
        this.category = category
        this.location = location
        this.oId = oId
        this.peopleWaiting = peopleWaiting
        this.timestamp = timestamp
    }


}
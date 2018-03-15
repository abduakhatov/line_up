package uz.wiut.lineup.lineup.ui.model

/**
 * Created by abduakhatov on 2/5/18 at 3:58 PM.
 */
data class RegisteredOrganization(
        var organization: Organization,
        var numberOnQueue: Int,
        var waitingTime: Int,
        var approximateTime: Int

)
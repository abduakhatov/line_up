package uz.wiut.lineup.lineup.model.toDelete

import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.model.RegisteredOrganization

/**
 * Created by abduakhatov on 1/19/18 at 12:35 AM.
 */
data class Organzatn(
        var organization: Organization,
        var regOrganization: RegisteredOrganization,
        var location: String,
        var distance: Float,
        var openClosed: Boolean
)

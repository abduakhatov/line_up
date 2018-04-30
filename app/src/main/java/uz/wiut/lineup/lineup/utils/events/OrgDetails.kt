package uz.wiut.lineup.lineup.utils.events

import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.model.RegisteredOrganization
import java.io.Serializable

/**
 * Created by Shohruh on 24-Apr-18.
 */
class OrgDetails : Serializable {
    var org: Organization? = null
    var regedOrg: RegisteredOrganization? = null

    constructor()
    constructor(org: Organization?, regedOrg: RegisteredOrganization?) {
        this.org = org
        this.regedOrg = regedOrg
    }


}
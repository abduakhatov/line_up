package uz.wiut.lineup.lineup.ui.home.mvp.fragment

import uz.wiut.lineup.lineup.model.DailyQueue
import uz.wiut.lineup.lineup.model.Organization
import uz.wiut.lineup.lineup.model.RegisteredOrganization
import uz.wiut.lineup.lineup.ui.organizationDetails.OrganizationDetailsActivity
import uz.wiut.lineup.lineup.utils.events.OrgDetails

/**
 * Created by Shohruh on 20-Apr-18.
 */
interface HomeFragmentView {
    fun setOrganizationData(organization: ArrayList<Organization>)
    fun log(message: String)
    fun message(message: String)
    fun setQueueData(queueList: ArrayList<RegisteredOrganization>)
    fun startActivity(organizationDetailsActivity: OrganizationDetailsActivity, orgDetails: OrgDetails)
}
package uz.wiut.lineup.lineup.ui.organizationDetails.mvp.fragment

import uz.wiut.lineup.lineup.utils.events.OrgDetails

/**
 * Created by Shohruh on 20-Apr-18.
 */
interface OrganizationDetailsFragmentPresenter {
    fun onRegisterClicked(networkAvailable: Boolean, orgDetails: OrgDetails) {}
}
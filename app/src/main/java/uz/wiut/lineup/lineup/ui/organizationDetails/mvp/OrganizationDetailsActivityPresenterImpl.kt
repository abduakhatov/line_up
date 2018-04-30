package uz.wiut.lineup.lineup.ui.organizationDetails.mvp

import javax.inject.Inject

/**
 * Created by Shohruh on 19-Apr-18.
 */
class OrganizationDetailsActivityPresenterImpl : OrganizationDetailsActivityPresenter {

    @Inject
    lateinit var view : OrganizationDetailsActivityView

    @Inject
    constructor() {}
}
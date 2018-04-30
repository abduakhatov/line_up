package uz.wiut.lineup.lineup.model

import java.io.Serializable

/**
 * Created by Shohruh on 23-Apr-18.
 */

class Organization() : Serializable{
    var address: String? = null
    var categoryTitle: String? = null
    var description: String? = null
    var isOpen: Int = -1
    var lattitude: Float = 0f
    var locationTitle: String? = null
    var longitude: Float = 0f
    var name: String? = null
    var oId: String? = null
    var officeHours: String? = null
    var website: String? = null

    var admins: Map<String, Boolean>? = null
}

class Category() : Serializable{
    var organizations: Map<String, Organization>? = null
}

class Location() : Serializable{
    var category: Map<String, Category>? = null
    var location: String? = null
}
package uz.wiut.component.utils.events

import java.io.Serializable

/**
 * Created by Shohruh on 21-Apr-18.
 */
data class Authentification (
        var phone : String? = null,
        var password : String? = null
) : Serializable{
}
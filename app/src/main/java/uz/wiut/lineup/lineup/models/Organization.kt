package uz.wiut.lineup.lineup.models

/**
 * Created by abduakhatov on 1/19/18 at 12:35 AM.
 */
data class Organization(
//    @SerializedName("foo")
//    @Expose
    var organization:String,
    var location:String,
    var distance:Int,
    var openClosed:Boolean
)
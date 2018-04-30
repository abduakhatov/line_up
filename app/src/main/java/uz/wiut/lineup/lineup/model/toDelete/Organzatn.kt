package uz.wiut.lineup.lineup.model.toDelete

/**
 * Created by abduakhatov on 1/19/18 at 12:35 AM.
 */
data class Organzatn(
//    @SerializedName("foo")
//    @Expose
        var organization: String,
        var location: String,
        var distance: Float,
        var openClosed: Boolean
)

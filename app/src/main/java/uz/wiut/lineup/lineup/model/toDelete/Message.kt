package uz.wiut.lineup.lineup.model.toDelete

/**
 * Created by abduakhatov on 1/19/18 at 11:32 PM.
 */
data class Message(
        var sender: String,
        var body: String,
        var time: Int,
        var isRead: Boolean
)
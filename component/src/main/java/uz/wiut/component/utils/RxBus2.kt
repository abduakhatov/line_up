package uz.wiut.component.utils

import android.support.annotation.IntDef
import android.util.SparseArray
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.subjects.PublishSubject
import org.jetbrains.annotations.NotNull
import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import java.util.HashMap

/**
 * Created by Shohruh on 20-Mar-18.
 */
class RxBus2 {
    constructor()

    @Retention(RetentionPolicy.SOURCE)
    @IntDef(SUBJECT_MY_SUBJECT, SUBJECT_ANOTHER_SUBJECT, CHANGE_SEARCH_DATA,
            CHANGE_USER_DATA, VEHICLE_DATA, REGISTER_ITEM_ADDED )
    internal annotation class Subject

    companion object {

        private val sSubjectMap = SparseArray<PublishSubject<Any>>()
        private val sSubscriptionsMap = HashMap<Any, CompositeDisposable>()

        const val SUBJECT_MY_SUBJECT = 0
        const val SUBJECT_ANOTHER_SUBJECT = 1
        // Its for search result to refresh...
        const val CHANGE_SEARCH_DATA = 2
        // Its for change user data(update profile, add new saved search)
        const val CHANGE_USER_DATA = 3
        const val VEHICLE_DATA = 4

        const val TOOLBAR_HIDE = 4

        const val CHANGE_FRAGMENT = 5
        const val SIGN_IN = 6
        const val ITEM_DELETE = 7
        const val REGISTER_ITEM_ADDED = 8

        /**
         * Get the subject or create it if it's not already in memory.
         */
        @NotNull
        private fun getSubject(@Subject subjectCode: Int): PublishSubject<Any> {
            var subject: PublishSubject<Any>? = sSubjectMap.get(subjectCode)
            if (subject == null) {
                subject = PublishSubject.create()
                subject!!.subscribeOn(AndroidSchedulers.mainThread())
                sSubjectMap.put(subjectCode, subject)
            }
            return subject
        }

        /**
         * Get the CompositeDisposable or create it if it's not already in memory.
         */
        @NotNull
        private fun getCompositeDisposable(`object`: Any): CompositeDisposable {
            var compositeDisposable: CompositeDisposable? = sSubscriptionsMap[`object`]
            if (compositeDisposable == null) {
                compositeDisposable = CompositeDisposable()
                sSubscriptionsMap.put(`object`, compositeDisposable)
            }
            return compositeDisposable
        }

        /**
         * Subscribe to the specified subject and listen for updates on that subject. Pass in an object to associate
         * your registration with, so that you can unsubscribe later.
         * <br></br><br></br>
         * **Note:** Make sure to call [RxBus.unregister] to avoid memory leaks.
         */
        fun subscribe(@Subject subject: Int, lifecycle: Any, action: Consumer<Any>) {
            val disposable = getSubject(subject)
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(action)
            getCompositeDisposable(lifecycle).add(disposable)
        }

        /**
         * Unregisters this object from the bus, removing all subscriptions.
         * This should be called when the object is going to go out of memory.
         */
        fun unregister(lifecycle: Any) {
            //We have to remove the composition from the map, because once you dispose it can't be used anymore
            val compositeDisposable = sSubscriptionsMap.remove(lifecycle)
            compositeDisposable?.dispose()
        }

        /**
         * Publish an object to the specified subject for all subscribers of that subject.
         */
        fun publish(@Subject subject: Int, message: Any) {
            getSubject(subject).onNext(message)
        }
    }
}
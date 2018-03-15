package uz.wiut.lineup.lineup.dagger.inject.inject

import java.lang.annotation.Documented
import javax.inject.Qualifier
import javax.inject.Scope
import kotlin.annotation.Retention

/**
 * Created by Shohruh on 07-Mar-18.
 */

@Scope  // Required to specify the annotation as a qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PerActivity
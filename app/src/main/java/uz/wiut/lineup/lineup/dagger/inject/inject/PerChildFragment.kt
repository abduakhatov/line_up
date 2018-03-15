package uz.wiut.lineup.lineup.dagger.inject.inject

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

/**
 * Created by Shohruh on 07-Mar-18.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerChildFragment

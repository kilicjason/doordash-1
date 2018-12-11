package com.doordash.anroid.di

import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class ApplicationScope

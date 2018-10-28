package net.crosp.android.dagger2scopeinternals.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Created by Alexander Molochko on 1/17/17.
 * Project HeartHealthMonitor
 * Copyright (C) 2017 CROSP Solutions
 */

@Scope
@Retention(RUNTIME)
public @interface PerActivity {}
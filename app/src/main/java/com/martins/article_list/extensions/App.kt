@file:Suppress("DEPRECATION")

package com.martins.article_list.extensions

import android.app.Application
import com.martins.article_list.di.AppComponent
import com.martins.article_list.di.AppModule
import com.martins.article_list.di.DaggerAppComponent
import com.martins.article_list.di.RemoteModule

val Application.component : AppComponent
    get() = DaggerAppComponent.builder()
        .appModule(AppModule(this))
        .remoteModule(RemoteModule())
        .build()
//    get() = DaggerAppComponent

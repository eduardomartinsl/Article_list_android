package com.martins.article_list.di

import androidx.appcompat.app.AppCompatActivity
import com.martins.article_list.ui.activity.ArticlesListActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (RemoteModule::class)])
interface AppComponent {

    //activity
    fun inject(activity: ArticlesListActivity)

    //viewModels
}
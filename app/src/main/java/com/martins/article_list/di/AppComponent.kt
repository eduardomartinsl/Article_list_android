package com.martins.article_list.di

import com.martins.article_list.ui.activity.ArticlesActivity
import com.martins.article_list.ui.viewModel.ArticlesViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (RemoteModule::class)])
interface AppComponent {

    //activity
    fun inject(activity: ArticlesActivity)

    //viewModels
    fun inject(viewModel: ArticlesViewModel)
}
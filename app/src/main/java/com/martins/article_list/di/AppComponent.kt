package com.martins.article_list.di

import androidx.appcompat.app.AppCompatActivity
import com.martins.article_list.ui.activity.ArticlesListActivity
import com.martins.article_list.ui.fragment.ArticlesListFragment
import com.martins.article_list.ui.viewModel.ArticlesListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(AppModule::class), (RemoteModule::class)])
interface AppComponent {

    //activity
    fun inject(activity: ArticlesListActivity)

    //viewModels
    fun inject(viewModel: ArticlesListViewModel)

    //fragments
    fun inject(fragment: ArticlesListFragment)
}
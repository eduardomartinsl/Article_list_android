package com.martins.article_list.ui.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.martins.article_list.extensions.component
import javax.inject.Inject

class ArticlesListViewModel (application: Application) : AndroidViewModel(application){

    init {
        getApplication<Application>().component.inject(this)
    }




}
package com.sumanta.mvvm.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.sumanta.mvvm.data.repositories.QuotesRepository
import com.sumanta.mvvm.util.lazyDeferred

class QuotesViewModel(
    repository: QuotesRepository
) : ViewModel() {

   val quotes by lazyDeferred {
       repository.getQuotes()
   }
}

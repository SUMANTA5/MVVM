package com.sumanta.mvvm.ui.home.quotes

import com.sumanta.mvvm.R
import com.sumanta.mvvm.data.db.entities.Quote
import com.sumanta.mvvm.databinding.ItemQuoteBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
): BindableItem<ItemQuoteBinding>(){
    override fun getLayout() = R.layout.item_quote

    override fun bind(viewBinding: ItemQuoteBinding, position: Int) {
       viewBinding.setQuote(quote)
    }
}
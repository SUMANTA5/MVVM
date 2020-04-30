package com.sumanta.mvvm.data.network.responses

import com.sumanta.mvvm.data.db.entities.Quote

data class QuotesResponse (
    val isSuccessful: Boolean,
    val quotes: List<Quote>
)
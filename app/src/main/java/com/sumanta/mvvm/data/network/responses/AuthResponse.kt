package com.sumanta.mvvm.data.network.responses

import com.sumanta.mvvm.data.db.entities.User

data class AuthResponse(
    val isSuccessful: Boolean?,
    val message: String?,
    val user: User?

)
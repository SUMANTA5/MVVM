package com.sumanta.mvvm.data.repository


import com.sumanta.mvvm.data.db.AppDatabase
import com.sumanta.mvvm.data.db.entities.User
import com.sumanta.mvvm.data.network.MyApi
import com.sumanta.mvvm.data.network.SafeApiRequest
import com.sumanta.mvvm.data.network.responses.AuthResponse

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest(){

    suspend fun userLogin(email: String, password: String) : AuthResponse{
        return apiRequest { api.userLogin(email, password)}

    }

    suspend fun saveUser(user: User)= db.getUserDao().upsert(user)
}
package com.sumanta.mvvm.ui.home.profile

import androidx.lifecycle.ViewModel
import com.sumanta.mvvm.data.repositories.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}

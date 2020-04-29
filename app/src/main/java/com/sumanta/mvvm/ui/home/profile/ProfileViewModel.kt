package com.sumanta.mvvm.ui.home.profile

import androidx.lifecycle.ViewModel
import com.sumanta.mvvm.data.repository.UserRepository

class ProfileViewModel(
    repository: UserRepository
) : ViewModel() {

    val user = repository.getUser()

}

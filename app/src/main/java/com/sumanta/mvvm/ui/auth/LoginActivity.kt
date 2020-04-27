package com.sumanta.mvvm.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.sumanta.mvvm.R
import com.sumanta.mvvm.data.db.AppDatabase
import com.sumanta.mvvm.data.db.entities.User
import com.sumanta.mvvm.data.network.MyApi
import com.sumanta.mvvm.data.network.NetworkConnectionInterceptor
import com.sumanta.mvvm.data.repository.UserRepository
import com.sumanta.mvvm.databinding.ActivityLoginBinding
import com.sumanta.mvvm.ui.home.HomeActivity
import com.sumanta.mvvm.util.hide
import com.sumanta.mvvm.util.show
import com.sumanta.mvvm.util.snackbar
import com.sumanta.mvvm.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        val api = MyApi(networkConnectionInterceptor)
        val db = AppDatabase(this)
        val repository = UserRepository(api,db)
        val factory = AuthViewModelFactory(repository)

        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this, factory)
            .get(AuthViewModel::class.java)
        binding.viewmodel = viewModel

        viewModel.authListener= this

        viewModel.getLoggedInUser().observe(this, Observer { User ->
            if (User != null){
               Intent(this,HomeActivity::class.java).also {
                   it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                   startActivity(it)
               }
            }
        })
    }

    override fun onStarted() {
        progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
        toast("${user.name} Is Logged In")
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}

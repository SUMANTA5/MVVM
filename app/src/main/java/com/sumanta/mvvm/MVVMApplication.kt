package com.sumanta.mvvm

import android.app.Application
import com.sumanta.mvvm.data.db.AppDatabase
import com.sumanta.mvvm.data.network.MyApi
import com.sumanta.mvvm.data.network.NetworkConnectionInterceptor
import com.sumanta.mvvm.data.repository.UserRepository
import com.sumanta.mvvm.ui.auth.AuthViewModelFactory
import com.sumanta.mvvm.ui.home.profile.ProfileViewModelFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MVVMApplication : Application(), KodeinAware {

    override val kodein = Kodein.lazy {
        import(androidXModule(this@MVVMApplication))

        bind() from singleton { NetworkConnectionInterceptor(instance()) }
        bind() from singleton { MyApi(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { UserRepository(instance(), instance()) }
        bind() from provider { AuthViewModelFactory(instance()) }
        bind() from provider { ProfileViewModelFactory(instance()) }


    }

}
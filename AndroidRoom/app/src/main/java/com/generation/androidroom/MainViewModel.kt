package com.generation.androidroom

import android.app.Application
import android.content.Context
import android.view.ContextThemeWrapper
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.generation.androidactivity.UserDatabase
import com.generation.androidactivity.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class MainViewModel (application: Application): AndroidViewModel(application){

    val selectUsers: LiveData<List<Usuario>>
    val repository: UserRepository

    init {
        val userDatabase = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        selectUsers = repository.selectUsers

    }

    fun addUser(usuario: Usuario){
        viewModelScope.launch (Dispatchers.IO ) {
            repository.addUser(usuario)
        }
    }
}

object userDao {

}

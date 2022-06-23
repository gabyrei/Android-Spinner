package com.generation.androidactivity


class UserRepository (private val userDao: UserDao: UserDao) {

    val selectUsers  = userDao.selectUsers()

    fun addUser(usuario: Usuario){
        userDao.addUser(usuario)
    }
}
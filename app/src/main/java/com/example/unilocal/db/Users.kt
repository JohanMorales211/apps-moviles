package com.example.unilocal.db

import com.example.unilocal.model.User

object Users {

    private var id:Int = 1
    private val users:java.util.ArrayList<User> = ArrayList()

    init {
        users.add(User(id, "Eduardo", "Vasquez", "user@gmail.com", "Eduardito", "1234", 1, 1, 1, 22,"","3188730873"))
        id++
        users.add(User(id, "Johan", "Ocampo", "user2@gmail.com", "Johancalida", "1234", 1, 1, 1, 20,"","3206340436"))
        id++
        users.add(User(id, "Camila", "Incapie", "user3@gmail.com", "Camimilo", "4321", 1, 2, 2, 219,"", "3207449924"))
        id++
    }

    fun list():ArrayList<User>{
        return users
    }

    fun findNameByID(id:Int): String?{
        try {
            var user= users.first { u -> u.id == id }
            return user.name
        } catch (e:Exception){
            return null
        }
    }

    fun findByEmail(email:String): User? {
        try {
            var user= users.first { u -> u.email == email }
            return user
        }catch (e:Exception){
            return null
        }
    }

    fun findByUsername(username:String): User? {
        try {
            var user= users.first { u -> u.nickname == username }
            return user
        }catch (e:Exception){
            return null
        }
    }

    fun findByPhone(phone:String): User? {
        try {
            var user= users.first { u -> u.phone == phone }
            return user
        }catch (e:Exception) {
            return null
        }
    }

    fun add (user: User){
        id++
        users.add(user)
    }

    fun size (): Int {
        return users.size
    }

    /*fun login(email:String, pass:String):User{
        val answer = users.first { u -> u.password == pass && u.email == email }
        return answer
    }*/
}
package com.example.unilocal.db

import com.example.unilocal.model.Moderator

object Moderators {

    private val moderators:ArrayList<Moderator> = ArrayList()

    init {
        moderators.add(Moderator(1,"Eduardo","Ocampo","eduardo@gmail.com","axMIAW","1234",1,1,1,22, "1234"))

        moderators.add(Moderator(2,"Johan","Morales","johan@gmail.com","PetroBB","4321",1,1,1,20, "4321"))

        moderators.add(Moderator(3,"Camila","Incapie","camila@gmail.com","Macalu","1423",1,1,1,29, "1234"))

    }

    fun list():ArrayList<Moderator>{
        return moderators
    }

    fun get(id:Int): Moderator?{
        return moderators.firstOrNull { a -> a.id == id }
    }
}
package com.example.unilocal.db

import com.example.unilocal.model.Comment

object Comments {

    private val list:ArrayList<Comment> = ArrayList()

    init {
        list.add( Comment(1, "Exelente servicio", 1, 5, 1))
        list.add( Comment(2, "Me dieron algo que no pedi:(", 2, 2, 2))
        list.add( Comment(3, "Sin palabras", 3, 2, 3))
        list.add( Comment(4, "Tiene las 3 b", 1, 5, 2))
        list.add( Comment(5, "Me parecio bastante agradable el servicio", 2, 4, 1))
        list.add( Comment(6, "Terrible la atención, se pasaron de groseros", 1, 1, 3))
        list.add( Comment(7, "Apto para salir con la familia", 1, 5, 1))
        list.add( Comment(8, "Exelente, perfecto e inolvidable", 3, 5, 2))
    }

    fun listById(idPlace:Int):ArrayList<Comment>{
        return list.filter { c -> c.id == idPlace }.toCollection(ArrayList())
    }

    fun new(comment: Comment){
        list.add(comment)
    }

    fun getSize():Int{
        return list.size
    }
}
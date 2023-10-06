package com.example.unilocal.db

import com.example.unilocal.model.Place
import com.example.unilocal.model.PlaceStatus
import com.example.unilocal.model.Schedule
import com.example.unilocal.model.User

object Places {

    private val places:java.util.ArrayList<Place> = ArrayList()
    private var id:Int = 1

    init {
        val schedule1 = Schedule(1, Schedules.getAll(),12,20)
        val schedule2 = Schedule(2, Schedules.getWeekDay(),9,20)
        val schedule3 = Schedule(3, Schedules.getWeekend(),14,13)

        val place1 = Place(id, "Maria Juana", "Comida mexicana", 1, PlaceStatus.ACCEPTED, 3, "Cll 12B 15-02",45.545454f,-23.87867f,1,1,1)
        place1.schedules.add(schedule1)
        id++
        val place2 = Place(id, "Hotel estelar", "El hotel iconico de armenia", 2, PlaceStatus.ACCEPTED, 1, "1043 Carrera 16 Edificio",45.545454f,-23.87867f,1,1,1)
        place2.schedules.add(schedule2)
        id++
        val place3 = Place(id, "MOI24", "Licorera", 3, PlaceStatus.ACCEPTED, 5, "Av. Centenario B13-9",45.545454f,-23.87867f,1,1,1)
        place3.schedules.add(schedule3)
        id++
        val place4 = Place(id, "poportal del quindio", "Centro Comercial unicentro", 3, PlaceStatus.REJECTED, 4, "San Agustín 22-30",45.545454f,-23.87867f,1,1,1)
        place4.schedules.add(schedule2)
        id++
        val place5 = Place(id, "Parque de la vida", "Parque Recreacional", 1, PlaceStatus.PENDING, 4, "Cra 28A 12-01",45.545454f,-23.87867f,1,1,1)
        place5.schedules.add(schedule1)
        id++
        val place6 = Place(id, "Bar la locura", "Bar preferido por todos", 2, PlaceStatus.ACCEPTED, 5, "cr16 #19-25 ",45.545454f,-23.87867f,1,1,1)
        place6.schedules.add(schedule2)
        id++


        places.add(place1)
        places.add(place2)
        places.add(place3)
        places.add(place4)
        places.add(place5)
        places.add(place6)

    }

    fun ListByState(status:PlaceStatus):ArrayList<Place>{
        return places.filter { p -> p.status == status }.toCollection(ArrayList())
    }

    fun ListByOwner(idOwner:Int):ArrayList<Place>{
        return places.filter { p -> p.idOwner == idOwner }.toCollection(ArrayList())
    }

    fun get(id:Int): Place?{
        return places.firstOrNull { p -> p.id == id }
    }

    fun size (): Int {
        return places.size
    }

    fun findByName(name:String): ArrayList<Place> {
        return places.filter { p -> p.name.lowercase().contains(name.lowercase()) && p.status == PlaceStatus.ACCEPTED }.toCollection(ArrayList())
    }

    fun add (place: Place){
        id++
        places.add(place)
    }

    fun create(place:Place){
        places.add( place )
    }

    fun findByCity(idCity:Int): ArrayList<Place> {
        return places.filter { p -> p.idCity == idCity && p.status == PlaceStatus.ACCEPTED }.toCollection(ArrayList())
    }

    fun findByCategory(idCategory:Int): ArrayList<Place> {
        return places.filter { p -> p.idCategory == idCategory && p.status == PlaceStatus.ACCEPTED }.toCollection(ArrayList())
    }

    fun changeStatus(id:Int, newStatus:PlaceStatus){

        val place = places.firstOrNull{ p -> p.id == id}

        if(place!=null){
            place.status = newStatus
        }

    }

}
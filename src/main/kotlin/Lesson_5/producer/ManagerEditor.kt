package Lesson_5.producer

import slot.Slot
import java.util.*
import Lesson_5.listeners.EventListener


class ManagerEditor(vararg doctors: String?) {
    var listeners: MutableMap<String?, MutableList<EventListener>> = HashMap()
    fun subscribe(doctor: String?, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[doctor]!!
        users.add(listener)
    }

    fun unsubscribe(doctor: String?, listener: EventListener) {
        val users: MutableList<EventListener> = listeners[doctor]!!
        users.remove(listener)
    }

    fun notify(doctor: String?, slot: Slot?) {
        val users: List<EventListener> = listeners[doctor]!!
        for (listener in users) {
            doctor?.let { slot?.let { it1 -> listener.update(it, it1) } }
        }
    }

    init {
        for (doctor in doctors) {
            listeners[doctor] = ArrayList<EventListener>()
        }
    }
}
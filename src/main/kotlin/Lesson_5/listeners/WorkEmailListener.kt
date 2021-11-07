package Lesson_5.listeners

import slot.Slot

class WorkEmailListener(private val email: String) : EventListener, java.util.EventListener {
    override fun update(doctor: String, slot: Slot) {
        println("Email to $email: Someone has performed $doctor operation with the following file: $slot")
    }
}
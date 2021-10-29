package Lesson_5.listeners

import slot.Slot


class ScoreboardListener(private val scoreboard: String) : EventListener, java.util.EventListener {
    override fun update(eventType: String, slot: Slot) {
        println("Email to $scoreboard: Someone has performed $eventType operation with the following file: $slot")
    }
}
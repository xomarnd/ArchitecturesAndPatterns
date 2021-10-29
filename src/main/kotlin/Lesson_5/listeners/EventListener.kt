package Lesson_5.listeners

import slot.Slot


interface EventListener {
    fun update(eventType: String, slot: Slot)
}
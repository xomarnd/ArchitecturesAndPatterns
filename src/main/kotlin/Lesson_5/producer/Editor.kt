package Lesson_5.producer

import slot.Slot

class Editor {
    var events: ManagerEditor = ManagerEditor("Ivanova", "Volkov")
    private val slot: Slot? = null
    fun visitDoctor(doctor: String?, slot: Lesson_5.slot.Slot?) {
        doctor?.let { events.notify(it, slot) }
    }
}
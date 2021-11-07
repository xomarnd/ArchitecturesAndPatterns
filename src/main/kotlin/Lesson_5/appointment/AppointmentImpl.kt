package Lesson_5.appointment


import Lesson_5.patient.Patient
import Lesson_5.service.Service
import Lesson_5.slot.Slot
import java.time.LocalDateTime

abstract class AppointmentImpl : Appointment {
    var id: Long? = null
    var createdAt: LocalDateTime? = null
    var slot: Slot? = null
    var patient: Patient? = null
    var service: Service? = null

    constructor(id: Long?, createdAt: LocalDateTime?, slot: Slot?, patient: Patient?, service: Service?) {
        this.id = id
        this.createdAt = createdAt
        this.slot = slot
        this.patient = patient
        this.service = service
    }

    constructor()

}

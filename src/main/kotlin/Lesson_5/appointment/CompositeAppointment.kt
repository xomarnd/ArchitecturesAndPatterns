package Lesson_5.appointment

import Lesson_5.doc.DocPackage
import Lesson_5.patient.Patient
import Lesson_5.service.Service
import Lesson_5.slot.Slot
import kotlin.collections.ArrayList


class CompositeAppointment : Appointment {
    var appointments: MutableList<Appointment> = ArrayList()
    override fun createDocPackage(docPackage: DocPackage?): DocPackage? {
        for (operation in appointments) {
            operation.createDocPackage(docPackage)
        }
        return docPackage
    }

    override fun addPatient(patient: Patient?): Patient? {
        for (operation in appointments) {
            operation.addPatient(patient)
        }
        return patient
    }

    override fun addService(service: Service?): Service? {
        for (operation in appointments) {
            operation.addService(service)
        }
        return service
    }

    override fun addSlot(slot: Slot?): Slot? {
        for (operation in appointments) {
            operation.addSlot(slot)
        }
        return slot
    }

    fun add(vararg operations: Appointment?): Appointment {
        appointments.addAll(listOf<Appointment>(*operations))
        return this
    }
}
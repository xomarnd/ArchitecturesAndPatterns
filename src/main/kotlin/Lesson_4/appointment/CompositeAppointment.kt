package Lesson_4.appointment

import doc.DocPackage
import patient.Patient
import service.Service
import slot.Slot
import java.util.*

class CompositeAppointment : Appointment {
    var appointments: ArrayList<Appointment> = ArrayList()
    override fun createDocPackage(docPackage: DocPackage?): DocPackage {
        for (operation in appointments) {
            operation.createDocPackage(docPackage)
        }
        return docPackage!!
    }

    override fun addPatient(patient: Patient?): Patient {
        for (operation in appointments) {
            operation.addPatient(patient)
        }
        return patient!!
    }

    override fun addService(service: Service?): Service {
        for (operation in appointments) {
            operation.addService(service)
        }
        return service!!
    }

    override fun addSlot(slot: Slot?): Slot {
        for (operation in appointments) {
            operation.addSlot(slot)
        }
        return slot!!
    }
    fun add(vararg operations: List<appointment.Appointment>): Appointment {
        appointments.add(operations)
        return this
    }
}
package Lesson_4.appointment

import appointment.Appointment
import doc.DocPackage
import patient.Patient
import service.Service
import slot.Slot

interface Appointment : Appointment {
    fun createDocPackage(docPackage: DocPackage?): DocPackage
    fun addPatient(patient: Patient?): Patient
    fun addService(service: Service?): Service
    fun addSlot(slot: Slot?): Slot?
}
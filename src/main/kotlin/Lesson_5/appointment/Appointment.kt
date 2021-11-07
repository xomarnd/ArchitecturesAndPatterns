package Lesson_5.appointment

import Lesson_5.doc.DocPackage
import Lesson_5.patient.Patient
import Lesson_5.service.Service
import Lesson_5.slot.Slot

interface Appointment {
    fun createDocPackage(docPackage: DocPackage?): DocPackage?
    fun addPatient(patient: Patient?): Patient?
    fun addService(service: Service?): Service?
    fun addSlot(slot: Slot?): Slot?
}
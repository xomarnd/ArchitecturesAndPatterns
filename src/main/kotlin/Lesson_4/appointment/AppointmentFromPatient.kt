package Lesson_4.appointment

import appointment.Appointment
import doc.DocPackage
import doc.DocPackageByPatient
import patient.Patient
import patient.PatientByPatient
import service.Service
import service.ServiceByPatient
import slot.Slot
import slot.SlotByPatient

abstract class AppointmentFromPatient : Appointment {
    override fun createDocPackage(docPackage: DocPackage?): DocPackage {
        return DocPackageByPatient()
    }

    override fun addPatient(patient: Patient?): Patient {
        return PatientByPatient()
    }

    override fun addService(service: Service?): Service {
        return ServiceByPatient()
    }

    override fun addSlot(slot: Slot?): Slot {
        return SlotByPatient()
    }
}
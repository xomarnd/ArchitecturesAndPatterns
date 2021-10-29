package Lesson_4.appointment

import doc.DocPackage
import doc.DocPackageByManager
import patient.Patient
import patient.PatientByManager
import service.Service
import service.ServiceByManager
import slot.Slot
import slot.SlotByManager

class AppointmentFromManager : Appointment {
    override fun createDocPackage(docPackage: DocPackage?): DocPackage {
        return DocPackageByManager()
    }

    override fun addPatient(patient: Patient?): Patient {
        return PatientByManager()
    }

    override fun addService(service: Service?): Service {
        return ServiceByManager()
    }

    override fun addSlot(slot: Slot?): Slot {
        return SlotByManager()
    }
}
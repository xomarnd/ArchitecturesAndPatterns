package Lesson_5.appointment

import Lesson_5.doc.DocPackage
import Lesson_5.doc.DocPackageByPatient
import Lesson_5.patient.Patient
import Lesson_5.patient.PatientByPatient
import Lesson_5.service.Service
import Lesson_5.service.ServiceByPatient
import Lesson_5.slot.Slot
import Lesson_5.slot.SlotByPatient


class AppointmentFromPatient : AppointmentImpl() {
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
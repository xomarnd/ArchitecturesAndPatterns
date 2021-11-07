package Lesson_5.appointment

import Lesson_5.doc.DocPackage
import Lesson_5.doc.DocPackageByManager
import Lesson_5.patient.Patient
import Lesson_5.patient.PatientByManager
import Lesson_5.service.Service
import Lesson_5.service.ServiceByManager
import Lesson_5.slot.Slot
import Lesson_5.slot.SlotByManager
import java.time.LocalDateTime

class AppointmentFromManager : AppointmentImpl {
    constructor(id: Long?, createdAt: LocalDateTime?, slot: Slot?, patient: Patient?, service: Service?) : super(
        id,
        createdAt,
        slot,
        patient,
        service
    ) {
    }

    constructor() {}

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
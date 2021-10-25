package appointment

import doc.DocPackage
import doc.DocPackageByManager
import patient.Patient
import patient.PatientByManager
import service.Service
import service.ServiceByManager
import slot.Slot
import slot.SlotByManager

class AppointmentFromManager : Appointment {
    override fun createDocPackage(): DocPackage {
        return DocPackageByManager()
    }

    override fun addPatient(): Patient {
        return PatientByManager()
    }

    override fun addService(): Service {
        return ServiceByManager()
    }

    override fun addSlot(): Slot {
        return SlotByManager()
    }
}
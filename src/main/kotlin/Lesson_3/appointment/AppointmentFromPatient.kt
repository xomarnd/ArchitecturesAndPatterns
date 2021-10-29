package appointment

import doc.DocPackage
import doc.DocPackageByPatient
import patient.Patient
import patient.PatientByPatient
import service.Service
import service.ServiceByPatient
import slot.Slot
import slot.SlotByPatient

class AppointmentFromPatient : Appointment {
    override fun createDocPackage(): DocPackage {
        return DocPackageByPatient()
    }

    override fun addPatient(): Patient {
        return PatientByPatient()
    }

    override fun addService(): Service {
        return ServiceByPatient()
    }

    override fun addSlot(): Slot {
        return SlotByPatient()
    }
}

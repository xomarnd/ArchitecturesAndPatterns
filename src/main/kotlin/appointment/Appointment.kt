package appointment

import doc.DocPackage
import patient.Patient
import service.Service
import slot.Slot

interface Appointment {
    fun createDocPackage(): DocPackage
    fun addPatient(): Patient
    fun addService(): Service
    fun addSlot(): Slot
}
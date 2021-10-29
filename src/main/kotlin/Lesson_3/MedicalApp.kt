import doc.DocPackage
import patient.Patient
import service.Service
import slot.Slot
import kotlin.jvm.JvmStatic

object MedicalApp {
    private var docPackage: DocPackage? = null
    private var patient: Patient? = null
    private var service: Service? = null
    private var slot: Slot? = null
    @JvmStatic
    fun main(args: Array<String>) {
        val fromWho = "from_manager"
        val appointment = AppointmentService.instance.createApplication(fromWho)
        docPackage = appointment.createDocPackage()
        patient = appointment.addPatient()
        service = appointment.addService()
        slot = appointment.addSlot()
    }
}

import appointment.Appointment
import appointment.AppointmentFromManager
import appointment.AppointmentFromPatient
import java.util.NoSuchElementException

class AppointmentService private constructor() {
    fun createApplication(creator: String): Appointment {
        return when (creator) {
            FROM_MANAGER -> {
                AppointmentFromManager()
            }
            FROM_PATIENT -> {
                AppointmentFromPatient()
            }
            else -> {
                throw NoSuchElementException("нет такого варианта создания записи на прием")
            }
        }
    }

    companion object {
        const val FROM_MANAGER = "from_manager"
        const val FROM_PATIENT = "from_patient"
        val instance = AppointmentService()
    }
}
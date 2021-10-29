package Lesson_4

import appointment.Appointment
import appointment.AppointmentFromManager
import appointment.AppointmentFromPatient

class AppointmentService private constructor() {
    fun createAppointment(creator: String): Appointment {
        return if (creator == FROM_MANAGER) {
            AppointmentFromManager()
        } else if (creator == FROM_PATIENT) {
            AppointmentFromPatient()
        } else {
            throw NoSuchElementException("нет такого варианта создания записи на прием")
        }
    }

    companion object {
        const val FROM_MANAGER = "from_manager"
        const val FROM_PATIENT = "from_patient"
        val instance = AppointmentService()
    }
}

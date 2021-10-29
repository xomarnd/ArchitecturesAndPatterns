package Lesson_5

import Lesson_5.appointment.Appointment
import Lesson_5.appointment.AppointmentFromManager
import Lesson_5.appointment.AppointmentFromPatient


class AppointmentService private constructor() {
    fun createAppointment(creator: String): Appointment {
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
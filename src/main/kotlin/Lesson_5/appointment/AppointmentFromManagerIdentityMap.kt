package Lesson_5.appointment

import java.sql.SQLException
import java.util.HashMap
import java.util.NoSuchElementException
import kotlin.Throws

class AppointmentFromManagerIdentityMap(var appointmentFromManagerMapper: AppointmentFromManagerMapper) {
    private val appointmentFromManagerMap: MutableMap<Long?, AppointmentFromManager?> = HashMap()
    fun addAppointment(appointmentFromManager: AppointmentFromManager?) {
        appointmentFromManagerMap[appointmentFromManager!!.id] = appointmentFromManager
    }

    @Throws(SQLException::class)
    fun getAppointment(id: Long?): AppointmentFromManager? {
        if (appointmentFromManagerMap[id] == null) {
            addAppointment(appointmentFromManagerMapper.findById(id))
        } else {
            throw NoSuchElementException()
        }
        return appointmentFromManagerMap[id]
    }

    fun deleteAppointment(id: Long?) {
        if (appointmentFromManagerMap[id] == null) {
            throw NoSuchElementException()
        } else {
            appointmentFromManagerMap.remove(id)
        }
    }
}
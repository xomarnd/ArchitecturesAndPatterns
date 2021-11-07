package Lesson_5.appointment

import Lesson_5.patient.Patient
import Lesson_5.service.Service
import Lesson_5.slot.Slot
import java.sql.Connection
import java.sql.SQLException
import java.time.LocalDateTime

class AppointmentFromManagerMapper(var connection: Connection) {

    @Throws(SQLException::class)
    fun findById(idAppointment: Long?): AppointmentFromManager {
        val statement = connection.prepareStatement(
            "SELECT ID, CREATED_AT, SLOT, PATIENT, SERVICE FROM APPOINTMENT WHERE IDPERSON = ?"
        )
        statement.setLong(1, idAppointment!!)
        statement.executeQuery().use { resultSet ->
            while (resultSet.next()) {
                val appointment = AppointmentFromManager()
                appointment.id = resultSet.getLong(1)
                appointment.createdAt = resultSet.getObject(2, LocalDateTime::class.java)
                appointment.slot = resultSet.getObject(3, Slot::class.java)
                appointment.patient = resultSet.getObject(4, Patient::class.java)
                appointment.service = resultSet.getObject(4, Service::class.java)
                return appointment
            }
        }
        throw NoSuchElementException()
    }

    @Throws(SQLException::class)
    fun insert(appointment: AppointmentFromManager) {
        val statement = connection.prepareStatement(
            "insert into APPOINTMENT (ID, CREATED_AT, SLOT, PATIENT, SERVICE) VALUES (?,?,?,?,?)"
        )
        try {
            statement.setLong(1, appointment.id!!)
            statement.setObject(2, appointment.createdAt)
            statement.setObject(3, appointment.slot)
            statement.setObject(3, appointment.patient)
            statement.setObject(3, appointment.service)
            val row = statement.executeUpdate()
        } catch (throwables: SQLException) {
            throwables.printStackTrace()
        }
    }

    @Throws(SQLException::class)
    fun findAll(): List<AppointmentFromManager> {
        val arrayList: MutableList<AppointmentFromManager> = ArrayList()
        val statement = connection.prepareStatement(
            "select ID, CREATED_AT, SLOT, PATIENT, SERVICE from  APPOINTMENT"
        )
        try {
            statement.executeQuery().use { resultSet ->
                while (resultSet.next()) {
                    val appointment = AppointmentFromManager(
                        resultSet.getLong(1),
                        resultSet.getObject(2, LocalDateTime::class.java),
                        resultSet.getObject(3, Slot::class.java),
                        resultSet.getObject(4, Patient::class.java),
                        resultSet.getObject(5, Service::class.java)
                    )
                    arrayList.add(appointment)
                }
            }
        } catch (throwables: SQLException) {
            throwables.printStackTrace()
        }
        return arrayList
    }

    @Throws(SQLException::class)
    fun delete(appointment: AppointmentFromManager) {
        val statement = connection.prepareStatement(
            "delete from APPOINTMENT where ID=?"
        )
        try {
            statement.setLong(1, appointment.id!!)
            val row = statement.executeUpdate()
        } catch (throwables: SQLException) {
            throwables.printStackTrace()
        }
    }

    @Throws(SQLException::class)
    fun update(appointment: AppointmentFromManager) {
        val statement = connection.prepareStatement(
            "update APPOINTMENT set CREATED_AT=?, SLOT=?, PATIENT=?, SERVICE=? where ID=?"
        )
        try {
            statement.setObject(1, appointment.createdAt)
            statement.setObject(2, appointment.slot)
            statement.setObject(3, appointment.patient)
            statement.setObject(4, appointment.service)
            statement.setLong(5, appointment.id!!)
            val row = statement.executeUpdate()
        } catch (throwables: SQLException) {
            throwables.printStackTrace()
        }
    }
}
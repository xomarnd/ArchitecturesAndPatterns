package Lesson_4

import Lesson_4.appointment.CompositeAppointment
import appointment.Appointment
import doc.DocPackage
import patient.Patient
import service.Service
import slot.Slot

object MedicalApp {
    var docPackage: DocPackage? = null
    var patient: Patient? = null
    var service: Service? = null
    var slot: Slot? = null
    @JvmStatic
    fun main(args: Array<String>) {
        val fromWho = "from_manager"
        val fromWho1 = "from_patient"
        val appointment = AppointmentService.instance.createAppointment(fromWho)
        val appointment1 = AppointmentService.instance.createAppointment(fromWho1)
        val appointment2 = AppointmentService.instance.createAppointment(fromWho)
        docPackage = appointment.createDocPackage(docPackage)
        patient = appointment.addPatient(patient)
        service = appointment.addService(service)
        slot = appointment.addSlot(slot)
        val appointmentCollection = listOf(appointment, appointment1, appointment2)
        val appointments: Appointment = CompositeAppointment().add(appointmentCollection)

        service = appointments.addService(service)
    }
}
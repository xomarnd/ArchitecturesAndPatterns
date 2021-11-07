package Lesson_5

import Lesson_5.appointment.CompositeAppointment
import Lesson_5.listeners.ScoreboardListener
import Lesson_5.listeners.WorkEmailListener
import Lesson_5.producer.Editor
import Lesson_5.appointment.Appointment
import Lesson_5.doc.DocPackage
import Lesson_5.patient.Patient
import Lesson_5.service.Service
import Lesson_5.slot.Slot


object MedicalApp {
    private var docPackage: DocPackage? = null
    private var patient: Patient? = null
    private var service: Service? = null
    private var slot: Slot? = null
    @JvmStatic
    fun main(args: Array<String>) {
        val fromWho = "from_manager"
        val fromWho1 = "from_patient"
        val appointment: Appointment = AppointmentService.instance.createAppointment(fromWho)
        val appointment1: Appointment = AppointmentService.instance.createAppointment(fromWho1)
        val appointment2: Appointment = AppointmentService.instance.createAppointment(fromWho)
        docPackage = appointment.createDocPackage(docPackage)
        patient = appointment.addPatient(patient)
        service = appointment.addService(service)
        slot = appointment.addSlot(slot)
        val appointments: Appointment = CompositeAppointment().add(appointment, appointment1, appointment2)
        service = appointments.addService(service)

        //подписка
        val editor = Editor()
        editor.events.subscribe("Ivanov", ScoreboardListener("Табло в регистратуре"))
        editor.events.subscribe("Volkov", WorkEmailListener("admin@example.com"))
        editor.visitDoctor("Ivanova", slot)
    }
}
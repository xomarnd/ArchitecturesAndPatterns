package Lesson_4.patient

class PatientByManager : Patient {
    override val patient: Patient
        get() = PatientByManager()
}
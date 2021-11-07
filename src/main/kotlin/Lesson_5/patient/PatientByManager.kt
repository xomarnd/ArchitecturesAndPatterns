package Lesson_5.patient

class PatientByManager : Patient {
    override val patient: Patient
        get() = PatientByManager()
}
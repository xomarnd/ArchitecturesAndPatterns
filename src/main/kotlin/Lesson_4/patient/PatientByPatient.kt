package Lesson_4.patient

class PatientByPatient : Patient {
    override val patient: Patient
        get() = PatientByPatient()
}
package Lesson_5.patient


class PatientByPatient : Patient {
    override val patient: Patient
        get() = PatientByPatient()
}
package patient

class PatientByManager : Patient {
    override val patient: Patient
        get() = PatientByManager()
}
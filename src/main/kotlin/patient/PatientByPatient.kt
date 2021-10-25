package patient

class PatientByPatient : Patient {
    override val patient: Patient
        get() = PatientByPatient()
}
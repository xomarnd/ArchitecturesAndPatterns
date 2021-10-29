package service

class ServiceByPatient : Service {
    override val service: Service
        get() = ServiceByPatient()
}

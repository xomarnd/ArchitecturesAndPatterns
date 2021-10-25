package service

class ServiceByManager : Service {
    override val service: Service
        get() = ServiceByManager()
}

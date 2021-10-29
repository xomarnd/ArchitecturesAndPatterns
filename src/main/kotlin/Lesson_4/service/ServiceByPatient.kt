package Lesson_4.service

class ServiceByPatient : Service {
    override val service: Service
        get() = ServiceByPatient()
}
package Lesson_5.service


class ServiceByPatient : Service {
    override val service: Service
        get() = ServiceByPatient()
}
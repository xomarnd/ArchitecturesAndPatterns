package Lesson_5.service


class ServiceByManager : Service {
    override val service: Service
        get() = ServiceByManager()
}
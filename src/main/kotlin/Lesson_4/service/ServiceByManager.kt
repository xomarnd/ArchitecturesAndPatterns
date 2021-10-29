package Lesson_4.service

class ServiceByManager : Service {
    override val service: Service
        get() = ServiceByManager()
}
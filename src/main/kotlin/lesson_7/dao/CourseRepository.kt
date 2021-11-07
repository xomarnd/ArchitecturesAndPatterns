package lesson_7.dao

import lesson_7.model.Course
import java.util.*

interface CourseRepository {
    fun findAll(): List<Course?>
    fun findById(id: Long?): Optional<Course>
    fun save(course: Course?)
    fun delete(id: Long?)
    fun findByTitleWithPrefix(prefix: String?): List<Course?>
}
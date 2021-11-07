package lesson_7.service

import lesson_7.dao.CourseRepository
import lesson_7.model.Course
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CourseService @Autowired constructor(private val courseRepository: CourseRepository) {
    fun findByTitleWithPrefix(prefix: String): List<Course?> {
        return courseRepository.findByTitleWithPrefix(prefix)
    }

    fun save(course: Course?) {
        courseRepository.save(course)
    }

    fun delete(id: Long?) {
        courseRepository.delete(id)
    }

    fun findById(id: Long?): Optional<Course> {
        return courseRepository.findById(id)
    }
}
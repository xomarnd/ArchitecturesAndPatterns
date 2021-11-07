package lesson_7.dao.impl

import lesson_7.dao.CourseRepository
import lesson_7.model.Course
import org.springframework.stereotype.Component
import java.util.*
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.atomic.AtomicLong
import java.util.stream.Collectors
import javax.annotation.PostConstruct

@Component
abstract class MemoryBasedCourseRepositoryImpl : CourseRepository {
    private val courseMap: MutableMap<Long, Course> = ConcurrentHashMap()
    private val identity = AtomicLong()

    @PostConstruct
    fun init() {
        save(Course(null, "author1", "title1"))
        save(Course(null, "author2", "title1"))
        save(Course(null, "author3", "title2"))
    }

    override fun findAll(): List<Course?> {
        return ArrayList(courseMap.values)
    }

    fun findById(id: Long): Optional<Course> {
        return Optional.ofNullable(courseMap[id])
    }

    override fun save(course: Course?) {
        if (course?.id == null) {
            course!!.id = identity.incrementAndGet()
        }
        course.id?.let { courseMap.put(it,course) }
    }

    fun delete(id: Long) {
        courseMap.remove(id)
    }

    override fun findByTitleWithPrefix(prefix: String?): List<Course> {
        return courseMap.values
            .stream().filter { course: Course -> course.title!!.startsWith(prefix.toString()) }
            .collect(Collectors.toList())
    }
}
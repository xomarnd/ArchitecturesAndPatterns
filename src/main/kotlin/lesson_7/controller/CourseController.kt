package lesson_7.controller

import lesson_7.exception.NotFoundException
import lesson_7.model.Course
import org.springframework.beans.factory.annotation.Autowired
import lesson_7.service.CourseService
import javax.validation.Valid
import org.springframework.validation.BindingResult
import org.springframework.web.servlet.ModelAndView
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller
@RequestMapping("/course")
class CourseController @Autowired constructor(private val courseService: CourseService) {
    @GetMapping
    fun courseTable(
        model: Model,
        @RequestParam(name = "titlePrefix", required = false) titlePrefix: String
    ): String {
        model.addAttribute(
            "courses",
            courseService.findByTitleWithPrefix(titlePrefix)
        )
        return "coursetable"
    }

    @PostMapping
    fun submitCourseForm(course: @Valid Course?, bindingResult: BindingResult): String {
        if (bindingResult.hasErrors()) {
            return "courseform"
        }
        courseService.save(course)
        return "redirect:/course"
    }

    @GetMapping("/{id}")
    fun courseForm(model: Model, @PathVariable("id") id: Long?): String {
        model.addAttribute("course", courseService.findById(id).orElseThrow { NotFoundException() })
        return "courseform"
    }

    @GetMapping("/new")
    fun courseForm(model: Model): String {
        model.addAttribute("course", Course())
        return "courseform"
    }

    @DeleteMapping("/{id}")
    fun deleteCourse(@PathVariable("id") id: Long?): String {
        courseService.delete(id)
        return "redirect:/course"
    }

    @ExceptionHandler
    fun notFoundExceptionHandler(ex: NotFoundException?): ModelAndView {
        val modelAndView = ModelAndView("notfound")
        modelAndView.status = HttpStatus.NOT_FOUND
        return modelAndView
    }
}
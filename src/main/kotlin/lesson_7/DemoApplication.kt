package lesson_7

import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication
import org.springframework.context.annotation.Configuration

@Configuration
@SpringBootApplication
object DemoApplication {
    @JvmStatic
    fun main(args: Array<String>) {
        SpringApplication.run(DemoApplication::class.java, *args)
    }
}
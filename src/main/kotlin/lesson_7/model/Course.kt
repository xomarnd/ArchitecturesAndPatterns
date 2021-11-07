package lesson_7.model

import javax.validation.constraints.NotBlank

class Course {
    var id: Long? = null
    var author: @NotBlank(message = "Автор курса должен быть заполнен") String? = null
    var title: @NotBlank(message = "Название курса должно быть заполнено") String? = null

    constructor()
    constructor(id: Long?, author: String?, title: String?) {
        this.id = id
        this.author = author
        this.title = title
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }
        if (other !is Course) {
            return false
        }

        if (if (id != null) id != other.id else other.id != null) {
            return false
        }
        if (if (author != null) author != other.author else other.author != null) {
            return false
        }
        return if (title != null) title == other.title else other.title == null
    }

    override fun hashCode(): Int {
        var result = if (id != null) id.hashCode() else 0
        result = 31 * result + if (author != null) author.hashCode() else 0
        result = 31 * result + if (title != null) title.hashCode() else 0
        return result
    }
}
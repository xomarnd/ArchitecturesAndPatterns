package Lesson_4.doc

class DocPackageByManager : DocPackage {
    override fun generateDocPackage(): DocPackage {
        return DocPackageByManager()
    }
}
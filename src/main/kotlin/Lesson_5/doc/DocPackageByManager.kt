package Lesson_5.doc


class DocPackageByManager : DocPackage {
    override fun generateDocPackage(): DocPackage {
        return DocPackageByManager()
    }
}
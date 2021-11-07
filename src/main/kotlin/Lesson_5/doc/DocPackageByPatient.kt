package Lesson_5.doc


class DocPackageByPatient : DocPackage {
    override fun generateDocPackage(): DocPackage {
        return DocPackageByPatient()
    }
}
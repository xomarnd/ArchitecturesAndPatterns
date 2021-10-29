package Lesson_4.doc

class DocPackageByPatient : DocPackage {
    override fun generateDocPackage(): DocPackage {
        return DocPackageByPatient()
    }
}
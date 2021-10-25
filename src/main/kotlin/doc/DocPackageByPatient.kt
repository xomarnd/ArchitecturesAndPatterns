package doc

class DocPackageByPatient : DocPackage {
    override fun generateDocPackage(): DocPackage {
        return DocPackageByPatient()
    }
}
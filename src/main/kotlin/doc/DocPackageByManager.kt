package doc

class DocPackageByManager : DocPackage {
    override fun generateDocPackage(): DocPackage {
        return DocPackageByManager()
    }
}
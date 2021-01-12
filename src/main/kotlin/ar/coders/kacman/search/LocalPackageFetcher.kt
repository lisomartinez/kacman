package ar.coders.kacman.search

class LocalPackageFetcher : PackageFetcher {
    var packages: String = ""
    override fun fetchPackagesFro(packageName: String): String {
        return packages
    }
}

package search

interface PackageFetcher {
    fun fetchPackagesFro(packageName: String): String
}
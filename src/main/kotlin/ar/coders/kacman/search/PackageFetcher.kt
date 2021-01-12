package ar.coders.kacman.search

interface PackageFetcher {
    fun fetchPackagesFro(packageName: String): String
}
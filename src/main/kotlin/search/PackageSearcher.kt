package search

import format.ResultFormatter

class PackageSearcher(private val resultFormatter: ResultFormatter, private val packageFetcher: PackageFetcher) {
    fun searchFor(packageName: String): String {
        assertPackageNameIsPresent(packageName)
        val packages = packageFetcher.fetchPackagesFro(packageName)
        if (packages.isBlank()) return "No packages found!"
        return resultFormatter.format(packages)
    }

    private fun assertPackageNameIsPresent(packageName: String) {
        if (packageName.isBlank()) {
            throw RuntimeException("Cannot search a package with an empty name")
        }
    }
}
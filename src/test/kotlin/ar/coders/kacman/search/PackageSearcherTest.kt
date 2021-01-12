package ar.coders.kacman.search

import ar.coders.kacman.format.ColoringAgent
import ar.coders.kacman.format.ResultFormatter
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PackageSearcherTest: StringSpec({
    lateinit var packageFetcher: LocalPackageFetcher

    val createPackageSearcher =
        { fetcher: LocalPackageFetcher -> PackageSearcher(ResultFormatter(ColoringAgent(), FieldExtractor()), fetcher) }
    beforeTest() {
        packageFetcher = LocalPackageFetcher()
    }
    "searches package by name in yay" {
        val searcher: PackageSearcher = createPackageSearcher(packageFetcher)
        loadPackages(packageFetcher)
        val results = searcher.searchFor("httpie")
        results shouldBe httpieResults()
    }

    "searches package by empty name throws" {
        val searcher: PackageSearcher = createPackageSearcher(packageFetcher)
        val exception = shouldThrow<RuntimeException> {
            searcher.searchFor("")
        }
        exception.message shouldBe "Cannot ar.coders.kacman.search a package with an empty name"
    }

    "searches package by name not found should inform that no package was found" {
        val searcher: PackageSearcher = createPackageSearcher(packageFetcher)
        val results = searcher.searchFor("httpie")
        results shouldBe "No packages found!"
    }

})

private fun loadPackages(packageFetcher: LocalPackageFetcher) {
    packageFetcher.packages = """community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.
community/httpie 2.3.0-3 (111.8 KiB 488.8 KiB) (Installed)
    cURL for humans

"""
}

fun httpieResults(): String {
    val formatter = ColoringAgent()
    return """${formatter.formatName("\uD83D\uDC49 CURLIE \uD83D\uDC48")}
            |Repository: ${formatter.formatRepository("community")}
            |Description: The power of curl, the ease of use of httpie.
            |Version: 1.6.0-1
            |Size: (863.1 KiB 2.6 MiB)
            |
            |${formatter.formatName("\uD83D\uDC49 HTTPIE \uD83D\uDC48")}
            |Repository: ${formatter.formatRepository("community")}
            |Description: cURL for humans
            |Version: 2.3.0-3
            |Size: (111.8 KiB 488.8 KiB)
        """.trimMargin()
}
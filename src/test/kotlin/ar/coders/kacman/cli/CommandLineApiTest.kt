package ar.coders.kacman.cli

import ar.coders.kacman.format.ColorBasedFormatter
import ar.coders.kacman.format.ResultFormatter
import ar.coders.kacman.search.LocalPackageFetcher
import ar.coders.kacman.search.PackageSearcher
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CommandLineApiTest : StringSpec({
    lateinit var packageFetcher: LocalPackageFetcher
    val formatter = ColorBasedFormatter();
    lateinit var outContent: ByteArrayOutputStream
    lateinit var errContent: ByteArrayOutputStream

    beforeTest {
        packageFetcher = LocalPackageFetcher()
        outContent = ByteArrayOutputStream()
        errContent = ByteArrayOutputStream()
        System.setOut(PrintStream(outContent))
        System.setErr(PrintStream(errContent))
    }

    afterTest {
        System.setOut(PrintStream(System.out))
        System.setErr(PrintStream(System.err))
    }

    "receives package name and prints results" {
        val cli: CommandLineApi = CommandLineApi(PackageSearcher(ResultFormatter.createDefault(), packageFetcher))
        loadPackages(packageFetcher)
        cli.search(arrayOf("httpie"))
        outContent.toString() shouldBe """${formatter.formatName("\uD83D\uDC49 CURLIE \uD83D\uDC48")}
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
            |""".trimMargin()
    }

    "prints not found when there is not result" {
        val cli: CommandLineApi = CommandLineApi(PackageSearcher(ResultFormatter.createDefault(), packageFetcher))
        cli.search(arrayOf("curly"))
        outContent.toString() shouldBe """No packages found!
            |""".trimMargin()
    }

    "when not package name is given prints error" {
        val cli: CommandLineApi = CommandLineApi(PackageSearcher(ResultFormatter.createDefault(), packageFetcher))
        cli.search(emptyArray())
        errContent.toString() shouldBe "Missing package name!\n"
    }
})

private fun loadPackages(packageFetcher: LocalPackageFetcher) {
    packageFetcher.packages = """community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.
community/httpie 2.3.0-3 (111.8 KiB 488.8 KiB) (Installed)
    cURL for humans

"""
}
package format

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain

class ResultFormatterTest : StringSpec({
    val agent: ColoringAgent = ColoringAgent()
    lateinit var formatter: ResultFormatter

    beforeTest {
        formatter = ResultFormatter(ColoringAgent(), FieldExtractor())
    }

    "formats package name" {
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Name: ${agent.formatName("curlie")}"
    }

    "formats package version" {
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Version: 1.6.0-1"
    }

    "formats package description" {
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Description: The power of curl, the ease of use of httpie."
    }

    "formats package repository" {
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Repository: ${agent.formatRepository("community")}"
    }

    "formats package size" {
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Size: (863.1 KiB 2.6 MiB)"
    }

    "formats all fields of package" {
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldBe """Name: ${agent.formatName("curlie")}
            |Repository: ${agent.formatRepository("community")}
            |Description: The power of curl, the ease of use of httpie.
            |Version: 1.6.0-1
            |Size: (863.1 KiB 2.6 MiB)
        """.trimMargin()
    }

    "formats multiple packages" {
        val result = createMultiplePacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldBe """Name: ${agent.formatName("curlie")}
            |Repository: ${agent.formatRepository("community")}
            |Description: The power of curl, the ease of use of httpie.
            |Version: 1.6.0-1
            |Size: (863.1 KiB 2.6 MiB)
            |
            |Name: ${agent.formatName("httpie")}
            |Repository: ${agent.formatRepository("community")}
            |Description: cURL for humans
            |Version: 2.3.0-3
            |Size: (111.8 KiB 488.8 KiB)
        """.trimMargin()
    }
})

private fun createPacmanSearchResultLines(): String {
    return """community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.
"""
}

private fun createMultiplePacmanSearchResultLines(): String {
    return """community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.

community/httpie 2.3.0-3 (111.8 KiB 488.8 KiB) (Installed)
    cURL for humans

"""
}
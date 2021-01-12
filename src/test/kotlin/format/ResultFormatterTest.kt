package format

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.string.shouldContain

class ResultFormatterTest : StringSpec({
    val agent: ColoringAgent = ColoringAgent()

    "formats package name" {
        val formatter: ResultFormatter = ResultFormatter()
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Name: ${agent.colorName("curlie")}"
    }

    "formats package version" {
        val formatter: ResultFormatter = ResultFormatter()
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Version: 1.6.0-1"
    }

    "formats package description" {
        val formatter: ResultFormatter = ResultFormatter()
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Description: The power of curl, the ease of use of httpie."
    }

    "formats package repository" {
        val formatter: ResultFormatter = ResultFormatter()
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Repository: ${agent.colorRepository("community")}"
    }

    "formats package size" {
        val formatter: ResultFormatter = ResultFormatter()
        val result = createPacmanSearchResultLines()
        val formattedResult: String = formatter.format(result)
        formattedResult shouldContain "Size: (863.1 KiB 2.6 MiB)"
    }
})

private fun createPacmanSearchResultLines(): String {
    return """community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.
"""
}
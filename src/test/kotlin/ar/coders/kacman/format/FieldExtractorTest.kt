package ar.coders.kacman.format

import ar.coders.kacman.search.FieldExtractor
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FieldExtractorTest : StringSpec({
    lateinit var extractor: FieldExtractor
    val formatter = FakeFieldFormatter()
    beforeTest {
        extractor = FieldExtractor()
    }

    "extracts package name from ar.coders.kacman.search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedName(formatter) shouldBe "\uD83D\uDC49 CURLIE \uD83D\uDC48"
    }

    "extracts package repository from ar.coders.kacman.search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedRepository(formatter) shouldBe "community"
    }

    "extracts package version form ar.coders.kacman.search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedVersion(formatter) shouldBe "1.6.0-1"
    }
    "extract package sizes from ar.coders.kacman.search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        (fields as PacmanPackage).size shouldBe "(863.1 KiB 2.6 MiB)"
    }

    "extracts package description from ar.coders.kacman.search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedDescription(formatter) shouldBe "The power of curl, the ease of use of httpie."
    }

    "extracts aur package description from ar.coders.kacman.search result lines" {
        val lines = createAurSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedDescription(formatter) shouldBe "AWSv4 auth plugin for HTTPie"
    }

    "extracts aur package name from ar.coders.kacman.search result lines" {
        val lines = createAurSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedName(formatter) shouldBe "👉 HTTPIE-AWS-AUTHV4-GIT 👈"
    }

    "extracts aur package version form ar.coders.kacman.search result lines" {
        val lines = createAurSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedVersion(formatter) shouldBe "r22.6165193-1"
    }

    "extract aur package rating from ar.coders.kacman.search result lines" {
        val lines = createAurSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        val aurFields = fields as AurPackage
        aurFields.formattedRating(formatter) shouldBe "+0"
    }

    "extract aur package downloads from ar.coders.kacman.search result lines" {
        val lines = createAurSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        val aurFields = fields as AurPackage
        aurFields.formattedDownloads(formatter) shouldBe "0.00"
    }

})

private fun createPacmanSearchResultLines(): List<String> {
    return listOf("community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB)", "The power of curl, the ease of use of httpie.")
}

private fun createAurSearchResultLines(): List<String> {
    return listOf("aur/httpie-aws-authv4-git r22.6165193-1 (+0 0.00", "AWSv4 auth plugin for HTTPie")

}
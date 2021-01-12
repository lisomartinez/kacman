package format

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class FieldExtractorTest : StringSpec({
    lateinit var extractor: FieldExtractor
    val formatter = FakeFieldFormatter()
    beforeTest {
        extractor = FieldExtractor()
    }

    "extracts package name from search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedName(formatter) shouldBe "curlie"
    }

    "extracts package repository from search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedRepository(formatter) shouldBe "community"
    }

    "extracts package version form search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedVersion(formatter) shouldBe  "1.6.0-1"
    }
    "extract package sizes from search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedSize(formatter) shouldBe "(863.1 KiB 2.6 MiB)"
    }

    "extracts package description from search result lines" {
        val lines = createPacmanSearchResultLines()
        val fields: Package = extractor.extractFields(lines)
        fields.formattedDescription(formatter) shouldBe "The power of curl, the ease of use of httpie."
    }


})

private fun createPacmanSearchResultLines(): List<String> {
    return listOf("community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB)", "The power of curl, the ease of use of httpie.")
}
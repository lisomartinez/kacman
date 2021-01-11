package format

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.maps.shouldContain

class FieldExtractorTest : StringSpec({
    "extracts package name from search result lines" {
        val extractor: FieldExtractor = FieldExtractor()
        val lines = """community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.
"""
        val fields: Map<String, String> = extractor.extractFields(lines)
        fields shouldContain Pair("name", "curlie")
    }

    "extracts package repository from search result lines" {
        val extractor: FieldExtractor = FieldExtractor()
        val lines = """community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.
"""
        val fields: Map<String, String> = extractor.extractFields(lines)
        fields shouldContain Pair("repository", "community")
    }

    "extracts package version form search result lines" {
        val extractor: FieldExtractor = FieldExtractor()
        val lines = """community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.
"""
        val fields: Map<String, String> = extractor.extractFields(lines)
        fields shouldContain Pair("version", "1.6.0-1")
    }
    "extract package sizes from search result lines" {
        val extractor: FieldExtractor = FieldExtractor()
        val lines = """community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.
"""
        val fields: Map<String, String> = extractor.extractFields(lines)
        fields shouldContain Pair("size", "(863.1 KiB 2.6 MiB)")
    }
})
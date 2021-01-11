package format

class FieldExtractor {
    fun extractFields(lines: String): Map<String, String> {
        return mapOf(
            "name" to lines.split("/")[1].split(" ")[0],
            "repository" to lines.split("/")[0],
            "version" to lines.split("/")[1].split(" ")[1].trim(),
            "size" to lines.split("/")[1].split(" ").slice(2..5).joinToString(" ")
        )
    }

}

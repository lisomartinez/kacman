package format


class FieldExtractor {

    fun extractFields(lines: String): Map<Field, String> {
        return mapOf(
            Field.NAME to lines.split("/")[1].split(" ")[0],
            Field.REPOSITORY to lines.split("/")[0],
            Field.VERSION to lines.split("/")[1].split(" ")[1].trim(),
            Field.SIZE to lines.split("/")[1].split(" ").slice(2..5).joinToString(" "),
            Field.DESCRIPTION to lines.split("\n")[1].trim()
        )
    }

}

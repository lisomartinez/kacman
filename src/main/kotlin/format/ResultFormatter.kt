package format

private const val WITH_NEW_LINE = "\n\n"

private const val TWO_LINES = 2

class ResultFormatter(private val formatter: FieldFormatter, private val fieldExtractor: FieldExtractor) {

    fun format(result: String): String {
        val packages = result.lineSequence()
            .windowed(TWO_LINES, TWO_LINES)
            .takeWhile(isNotLastLine())

        return packages
            .map { fieldExtractor.extractFields(it) }
            .joinToString(WITH_NEW_LINE) { formatPackage(it, formatter) }
    }

    private fun isNotLastLine() = { list: List<String> -> list[0].isNotEmpty() && list[1].isNotEmpty() }

    private fun formatPackage(fields: Package, agent: FieldFormatter): String {
        return if (fields.isPacman()) {
            "Name: ${fields.formattedName(agent)}\n" +
                    "Repository: ${fields.formattedRepository(agent)}\n" +
                    "Description: ${fields.formattedDescription(agent)}\n" +
                    "Version: ${fields.formattedVersion(agent)}\n" +
                    "Size: ${fields.formattedSize(agent)}"
        } else {
            "Name: ${fields.formattedName(agent)}\n" +
                    "Repository: ${fields.formattedRepository(agent)}\n" +
                    "Description: ${fields.formattedDescription(agent)}\n" +
                    "Version: ${fields.formattedVersion(agent)}\n" +
                    "Rating: ${(fields as AurPackage).rating}\n" +
                    "Downloads: ${(fields as AurPackage).downloads}"
        }
    }

}

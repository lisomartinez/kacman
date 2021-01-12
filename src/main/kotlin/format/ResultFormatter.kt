package format

class ResultFormatter(private val formatter: FieldFormatter, private val fieldExtractor: FieldExtractor) {

    fun format(result: String): String {
        val packages = result.lineSequence()
            .windowed(2, 2)
            .takeWhile(isNotLastLine())

        return packages
            .map { fieldExtractor.extractFields(it) }
            .joinToString("\n\n") { formatPackage(it, formatter) }
    }

    private fun isNotLastLine() = { list: List<String> -> list[0].isNotEmpty() && list[1].isNotEmpty() }

    private fun formatPackage(fields: Package, agent: FieldFormatter): String {
        return "Name: ${fields.formattedName(agent)}\n" +
                "Repository: ${fields.formattedRepository(agent)}\n" +
                "Description: ${fields.formattedDescription(agent)}\n" +
                "Version: ${fields.formattedVersion(agent)}\n" +
                "Size: ${fields.formattedSize(agent)}"
    }

}

package format

class ResultFormatter(private val formatter: FieldFormatter, private val fieldExtractor: FieldExtractor) {

    fun format(result: String): String {
        val packages = result.split("\n\n")
        return packages
            .filter { it.isNotBlank() }
            .map { fieldExtractor.extractFields(it) }
            .joinToString("\n\n") { formatPackage(it, formatter) }
    }

    private fun formatPackage(fields: Package, agent: FieldFormatter): String {
        return "Name: ${fields.formattedName(agent)}\n" +
                "Repository: ${fields.formattedRepository(agent)}\n" +
                "Description: ${fields.formattedDescription(agent)}\n" +
                "Version: ${fields.formattedVersion(agent)}\n" +
                "Size: ${fields.formattedSize(agent)}"
    }

}

package format

class ResultFormatter() {
    private val agent = ColoringAgent()
    private val fieldExtractor = FieldExtractor()
    fun format(result: String): String {
        val packages = result.split("\n\n")
        return packages
            .filter { it.isNotBlank() }
            .map { fieldExtractor.extractFields(it) }
            .joinToString("\n\n") { formatPackage(it, agent) }
    }

    private fun formatPackage(fields: Map<Field, String>, agent: ColoringAgent): String {
        return "Name: ${agent.colorName(fields.getOrDefault(Field.NAME, "") )}\n" +
                "Repository: ${agent.colorRepository(fields.getOrDefault(Field.REPOSITORY, ""))}\n" +
                "Description: ${fields.getOrDefault(Field.DESCRIPTION, "")}\n" +
                "Version: ${fields.getOrDefault(Field.VERSION, "")}\n" +
                "Size: ${fields.getOrDefault(Field.SIZE, "")}"
    }

}

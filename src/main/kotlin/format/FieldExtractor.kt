package format


class FieldExtractor {

    fun extractFields(lines: String): Package {
        val firstPartOfFirstLine = lines.split("/")[0]
        val remainingOfFirstLine = lines.split("/")[1].split(" ")
        val secondLine = lines.split("\n")[1]

        return Package(
            repository = repositoryFrom(firstPartOfFirstLine),
            name = nameFrom(remainingOfFirstLine),
            version = versionFrom(remainingOfFirstLine),
            size = sizeFrom(remainingOfFirstLine),
            description = descriptionFrom(secondLine)
        )
    }




    private fun sizeFrom(firstLine: List<String>) = firstLine.slice(2..5).joinToString(" ")

    private fun versionFrom(firstLine: List<String>) = firstLine[1].trim()

    private fun descriptionFrom(secondLine: String) = secondLine.trim()

    private fun nameFrom(firstLine: List<String>) = firstLine[0]

    private fun repositoryFrom(repository: String) = repository

}

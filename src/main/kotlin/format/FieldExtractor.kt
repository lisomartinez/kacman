package format


class FieldExtractor {

    fun extractFields(lines: List<String>): Package {
        val firstPartOfFirstLine = lines[0].split("/")[0]
        val remainingOfFirstLine = lines[0].split("/")[1].split(" ")
        val secondLine = lines[1]

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

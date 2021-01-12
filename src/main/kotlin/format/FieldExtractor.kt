package format


class FieldExtractor {

    fun extractFields(lines: List<String>): Package {
        val firstPartOfFirstLine = getFirstPartOfFirstLine(lines)
        val remainingOfFirstLine = getRemainingPartOfFirstLine(lines)
        val secondLine = getSecondLine(lines)

        return Package(
            repository = repositoryFrom(firstPartOfFirstLine),
            name = nameFrom(remainingOfFirstLine),
            version = versionFrom(remainingOfFirstLine),
            size = sizeFrom(remainingOfFirstLine),
            description = descriptionFrom(secondLine)
        )
    }

    private fun getRemainingPartOfFirstLine(lines: List<String>) =
        lines[0].split("/")[1].split(" ")

    private fun getFirstPartOfFirstLine(lines: List<String>) = lines[0].split("/")[0]


    private fun sizeFrom(firstLine: List<String>) = firstLine.slice(2..5).joinToString(" ")

    private fun versionFrom(firstLine: List<String>) = firstLine[1].trim()

    private fun getSecondLine(lines: List<String>) = lines[1]

    private fun descriptionFrom(secondLine: String) = secondLine.trim()

    private fun nameFrom(firstLine: List<String>) = firstLine[0]

    private fun repositoryFrom(repository: String) = repository

}

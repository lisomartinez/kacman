package format


class FieldExtractor {

    fun extractFields(lines: List<String>): Package {
        val firstPartOfFirstLine = getFirstPartOfFirstLine(lines)
        val remainingOfFirstLine = getRemainingPartOfFirstLine(lines)
        val secondLine = getSecondLine(lines)

        val repository = repositoryFrom(firstPartOfFirstLine)
        if (repository != Repository.AUR.asString) {
            return Package(
                repository = repository,
                name = nameFrom(remainingOfFirstLine),
                version = versionFrom(remainingOfFirstLine),
                size = sizeFrom(remainingOfFirstLine),
                description = descriptionFrom(secondLine)
            )
        } else {
            return AurPackage(
                repository = repository,
                name = nameFrom(remainingOfFirstLine),
                version = versionFrom(remainingOfFirstLine),
                size = "0",
                description = descriptionFrom(secondLine),
                rating = ratingFrom(remainingOfFirstLine),
                downloads = downloadsFrom(remainingOfFirstLine)
            )
        }
    }

    private fun downloadsFrom(remainingOfFirstLine: List<String>): String = remainingOfFirstLine[3]

    private fun ratingFrom(remainingOfFirstLine: List<String>): String = remainingOfFirstLine[2].drop(1)

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

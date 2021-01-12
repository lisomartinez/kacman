package ar.coders.kacman.format

import ar.coders.kacman.search.FieldExtractor

private const val WITH_NEW_LINE = "\n\n"

private const val TWO_LINES = 2

class ResultFormatter(private val formatter: FieldFormatter, private val fieldExtractor: FieldExtractor) :
    PackageFormatter {

    companion object {
        fun createDefault() = ResultFormatter(ColoringAgent(), FieldExtractor())
    }

    fun format(result: String): String {
        val packages = result.lineSequence()
            .windowed(TWO_LINES, TWO_LINES)
            .takeWhile(isNotLastLine())

        return packages
            .map { fieldExtractor.extractFields(it) }
            .joinToString(WITH_NEW_LINE, transform = this::formatPackage)
    }

    private fun isNotLastLine() = { list: List<String> -> list[0].isNotEmpty() && list[1].isNotEmpty() }

    private fun formatPackage(fields: Package): String {
        return fields.accept(this)
    }

    override fun format(extractedPackage: PacmanPackage): String {
        return "${extractedPackage.formattedName(formatter)}\n" +
                "Repository: ${extractedPackage.formattedRepository(formatter)}\n" +
                "Description: ${extractedPackage.formattedDescription(formatter)}\n" +
                "Version: ${extractedPackage.formattedVersion(formatter)}\n" +
                "Size: ${extractedPackage.formattedSize(formatter)}"
    }

    override fun format(extractedPackage: AurPackage): String {
        return "${extractedPackage.formattedName(formatter)}\n" +
                "Repository: ${extractedPackage.formattedRepository(formatter)}\n" +
                "Description: ${extractedPackage.formattedDescription(formatter)}\n" +
                "Version: ${extractedPackage.formattedVersion(formatter)}\n" +
                "Rating: ${extractedPackage.formattedRating(formatter)}\n" +
                "Downloads: ${extractedPackage.formattedDownloads(formatter)}"
    }

}

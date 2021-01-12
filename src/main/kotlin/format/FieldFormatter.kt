package format

interface FieldFormatter {
    fun formatName(name: String): String
    fun formatRepository(repository: String): String
}
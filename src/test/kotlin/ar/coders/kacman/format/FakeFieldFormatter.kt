package ar.coders.kacman.format

class FakeFieldFormatter : FieldFormatter {
    override fun formatName(name: String): String {
        return name
    }

    override fun formatRepository(repository: String): String {
        return repository
    }
}
package format


open class Package(
    private val name: String,
    private val repository: String,
    private val description: String,
    private val version: String,
    private val size: String
) {
    fun formattedName(formatter: FieldFormatter): String {
        return formatter.formatName(name)
    }

    fun formattedRepository(formatter: FieldFormatter): String {
        return formatter.formatRepository(repository)
    }

    fun formattedDescription(formatter: FieldFormatter): String {
        return description
    }

    fun formattedVersion(agent: FieldFormatter): String {
        return version
    }

    fun formattedSize(agent: FieldFormatter): String {
        return size
    }

}

class AurPackage(
    name: String,
    repository: String,
    description: String,
    version: String,
    size: String,
    val rating: String,
    val downloads: String
) :
    Package(name, repository, description, version, "0")
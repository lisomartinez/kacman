package format


abstract class Package(
    private val name: String,
    private val repository: String,
    private val description: String,
    private val version: String
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


    abstract fun accept(formatter: PackageFormatter): String;
}

class PacmanPackage(name: String, repository: String, description: String, version: String, val size: String) :
    Package(name, repository, description, version) {
    override fun accept(formatter: PackageFormatter): String {
        return formatter.format(this)
    }

    fun formattedSize(formatter: FieldFormatter): String {
        return size;
    }

}

class AurPackage(
    name: String,
    repository: String,
    description: String,
    version: String,
    private val rating: String,
    private val downloads: String
) :
    Package(name, repository, description, version) {
    override fun accept(formatter: PackageFormatter): String {
        return formatter.format(this)
    }

    fun formattedRating(agent: FieldFormatter): String {
        return rating
    }

    fun formattedDownloads(agent: FieldFormatter): String {
        return downloads
    }
}
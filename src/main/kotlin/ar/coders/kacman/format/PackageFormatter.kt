package ar.coders.kacman.format

interface PackageFormatter {
    fun format(extractedPackage: PacmanPackage): String
    fun format(extractedPackage: AurPackage): String
}

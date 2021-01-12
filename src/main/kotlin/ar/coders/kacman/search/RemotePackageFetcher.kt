package ar.coders.kacman.search

class RemotePackageFetcher : PackageFetcher {
    override fun fetchPackagesFro(packageName: String): String {
        val process = Runtime.getRuntime().exec("yay -Ss $packageName")
        var packages = ""
        process.inputStream.reader(Charsets.UTF_8).use {
            packages = it.readText()
        }
        process.waitFor()
        return packages
    }
}
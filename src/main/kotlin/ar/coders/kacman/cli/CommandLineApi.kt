package ar.coders.kacman.cli

import ar.coders.kacman.search.PackageSearcher
import com.github.ajalt.mordant.terminal.Terminal

class CommandLineApi(private val searcher: PackageSearcher) {

    companion object {
        fun create() = CommandLineApi(PackageSearcher.createDefault())
    }

    fun search(args: Array<String>) {
        try {
            val response = searcher.searchFor(args[0])
            Terminal().println(response)
        } catch (e: ArrayIndexOutOfBoundsException) {
            System.err.println("Missing package name!")
        } catch (e: RuntimeException) {
            System.err.println(e.message)
        }

    }

}

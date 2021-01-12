import ar.coders.kacman.format.ColoringAgent
import ar.coders.kacman.format.ResultFormatter
import ar.coders.kacman.search.FieldExtractor
import ar.coders.kacman.search.PackageSearcher
import ar.coders.kacman.search.RemotePackageFetcher
import com.github.ajalt.mordant.terminal.Terminal

fun main(args: Array<String>) {
    val resultFormatter = ResultFormatter(ColoringAgent(), FieldExtractor())
    val searcher = PackageSearcher(resultFormatter, RemotePackageFetcher())
    val terminal = Terminal()
    terminal.println(searcher.searchFor("httpie"))
}
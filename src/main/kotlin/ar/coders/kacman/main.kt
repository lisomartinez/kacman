import ar.coders.kacman.search.PackageSearcher
import com.github.ajalt.mordant.terminal.Terminal

fun main(args: Array<String>) {
    val searcher = PackageSearcher.createDefault()
    val terminal = Terminal()
    terminal.println(searcher.searchFor("httpie"))
}
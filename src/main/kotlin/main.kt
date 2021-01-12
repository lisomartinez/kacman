import format.ColoringAgent
import format.ResultFormatter
import search.FieldExtractor
import search.PackageSearcher
import search.RemotePackageFetcher

fun main(args: Array<String>) {
    val resultFormatter = ResultFormatter(ColoringAgent(), FieldExtractor())
    val searcher = PackageSearcher(resultFormatter, RemotePackageFetcher())
    println(searcher.searchFor("httpie"))
}
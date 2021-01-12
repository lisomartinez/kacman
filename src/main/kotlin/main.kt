import format.ColoringAgent
import format.FieldExtractor
import format.ResultFormatter
import search.PackageSearcher
import search.RemotePackageFetcher

fun main(args: Array<String>) {
    val resultFormatter = ResultFormatter(ColoringAgent(), FieldExtractor())
    val searcher = PackageSearcher(resultFormatter, RemotePackageFetcher())
    println(searcher.searchFor("httpie"))
}
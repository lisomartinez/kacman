package search

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class PackageSearcherTest: StringSpec({
    "search package name in yay" {
        val searcher: PackageSearcher = PackageSearcher()
        val results = searcher.searchFor("httpie")
        results shouldBe httpieResults()
    }


})

private fun httpieResults(): String {
    return """aur/httpie-aws-authv4-git r22.6165193-1 (+0 0.00) 
    AWSv4 auth plugin for HTTPie
aur/batcli-git 0.0.1.r9.gcba1c6b-1 (+0 0.00) (Orphaned) 
    Bat is a CLI cURL-like tool for humans inspired by Httpie and written in Go.
aur/goploader-server 1.0-2 (+1 0.00) 
    Easy file sharing with server-side encryption, curl/httpie/wget compliant
aur/httpie-unixsocket-git r18.76d98b2-1 (+1 0.00) (Orphaned) 
    UNIX socket transport plugin for HTTPie
aur/httpie-ntlm 1.0.2-2 (+1 0.00) 
    NTLM auth plugin for HTTPie
aur/python-httpie-oauth 5.6cf6ed4-2 (+1 0.00) 
    OAuth plugin for httpie
aur/python-httpie-jwt-auth 0.4.0-1 (+2 0.53) 
    JWTAuth (JSON Web Tokens) auth plugin for HTTPie
community/httpie 2.3.0-3 (111.8 KiB 488.8 KiB) (Installed)
    cURL for humans
community/curlie 1.6.0-1 (863.1 KiB 2.6 MiB) 
    The power of curl, the ease of use of httpie.

"""
}
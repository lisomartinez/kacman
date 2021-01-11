package format

import com.github.ajalt.mordant.terminal.TextColors.*

class ColoringAgent {
    fun colorName(title: String): String = green(title)

    fun colorRepository(repository: String): String {
        return when(repository) {
            "core" -> (black on brightBlue)(repository)
            "extra" -> (black on red)(repository)
            else -> ""
        }

    }

}

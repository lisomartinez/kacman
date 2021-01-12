package format

import com.github.ajalt.mordant.terminal.TextColors.*

class ColoringAgent : FieldFormatter{
    override fun formatName(name: String): String = green(name)

    override fun formatRepository(repository: String): String {
        return when(repository) {
            "core" -> (black on brightBlue)(repository)
            "extra" -> (black on red)(repository)
            "multilib" -> (black on brightMagenta)(repository)
            "community" -> (black on brightWhite)(repository)
            else -> ""
        }

    }

}

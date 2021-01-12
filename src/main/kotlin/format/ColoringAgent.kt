package format

import com.github.ajalt.mordant.terminal.TextColors.*

class ColoringAgent : FieldFormatter{
    override fun formatName(name: String): String = green(name)

    override fun formatRepository(repository: String): String {
        return when(repository) {
            Repositoy.CORE.asString -> (black on brightBlue)(repository)
            Repositoy.EXTRA.asString -> (black on red)(repository)
            Repositoy.MULTILIB.asString -> (black on brightMagenta)(repository)
            Repositoy.COMMUNITY.asString -> (black on brightWhite)(repository)
            else -> ""
        }

    }

}

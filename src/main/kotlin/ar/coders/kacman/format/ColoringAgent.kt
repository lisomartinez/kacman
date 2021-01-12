package ar.coders.kacman.format

import com.github.ajalt.mordant.terminal.TextColors.*

class ColoringAgent : FieldFormatter{
    override fun formatName(name: String): String = (white)(name)

    override fun formatRepository(repository: String): String {
        return when (repository) {
            Repository.CORE.asString -> (black on brightBlue)(repository)
            Repository.EXTRA.asString -> (black on red)(repository)
            Repository.MULTILIB.asString -> (black on brightMagenta)(repository)
            Repository.COMMUNITY.asString -> (black on brightWhite)(repository)
            Repository.AUR.asString -> (black on brightYellow)(repository)
            else -> "other"
        }

    }

}

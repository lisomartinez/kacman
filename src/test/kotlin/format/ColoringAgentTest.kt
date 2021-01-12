package format

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

const val ANSI_GREEN = "\u001B[32m"
const val ANSI_DEFAULT_FOREGROUND = "\u001B[39m"
const val ANSI_BLACK_ON_BRIGHTBLUE = "\u001B[30;104m"
const val ANSI_BLACK_ON_BRIGHT_MAGENTA = "\u001B[30;105m"
const val ANSI_DEFAUTLS = "\u001B[39;49m"
const val ANSI_BLACK_ON_RED = "\u001B[30;41m"
const val ANSI_BLACK_ON_BRIGHT_WHITE = "\u001B[30;107m"

class ColoringAgentTest : StringSpec({

    lateinit var agent: ColoringAgent

    beforeTest {
        agent = ColoringAgent()
    }


    "coloring empty package name is empty" {
        val coloredName: String = agent.formatName("")
        coloredName shouldBe ""
    }

    "coloring package name with green" {
        val packageName = "wget"
        val coloredName: String = agent.formatName(packageName)
        val name = "wget"
        coloredName shouldBe ofColorGreen(name)
    }

    "coloring 'core' repository with blue background color and black foreground" {
        val repository = "core"
        val coloredRepository: String = agent.formatRepository(repository)
        coloredRepository shouldBe ofBackgroundBlue(repository)
    }

    "coloring 'extra' repository with red background and black foreground" {
        val repository = "extra"
        val coloredRepository: String = agent.formatRepository(repository)
        coloredRepository shouldBe ofBackgroundRed(repository)
    }

    "coloring 'multilib' repository with magenta background and black foreground" {
        val repository = "multilib"
        val coloredRepository: String = agent.formatRepository(repository)
        coloredRepository shouldBe ofBackgroundMagenta(repository)
    }

    "coloring 'community' repository with cyan background and black foreground" {
        val repository = "community"
        val coloredRepository: String = agent.formatRepository(repository)
        coloredRepository shouldBe ofBackgroundWhite(repository)
    }

    "coloring 'aur' repository with cyan background and black foreground" {
        val repository = "aur"
        val coloredRepository: String = agent.formatRepository(repository)
        coloredRepository shouldBe ofBackgroundWhite(repository)
    }
})

private fun ofBackgroundWhite(repository: String) = "${ANSI_BLACK_ON_BRIGHT_WHITE}$repository${ANSI_DEFAUTLS}"

private fun ofBackgroundMagenta(repository: String) =
    "${ANSI_BLACK_ON_BRIGHT_MAGENTA}$repository${ANSI_DEFAUTLS}"

private fun ofBackgroundRed(repository: String) = "${ANSI_BLACK_ON_RED}$repository${ANSI_DEFAUTLS}"

private fun ofBackgroundBlue(repository: String) = "${ANSI_BLACK_ON_BRIGHTBLUE}$repository${ANSI_DEFAUTLS}"

private fun ofColorGreen(name: String) = "${ANSI_GREEN}$name${ANSI_DEFAULT_FOREGROUND}"
package format

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class ColoringAgentTest : StringSpec({
    val ANSI_GREEN = "\u001B[32m"
    val ANSI_DEFAULT_FOREGROUND = "\u001B[39m"
    val ANSI_WHITE_ON_BRIGHTBLUE = "\u001B[30;104m"
    val ANSI_DEFAUTLS = "\u001B[39;49m"
    val ANSI_BLACK_ON_RED = "\u001B[30;41m"
    lateinit var agent: ColoringAgent

    beforeTest {
        agent = ColoringAgent()
    }


    "coloring empty package name is empty" {
        val coloredName: String = agent.colorName("")
        coloredName shouldBe ""
    }

    "coloring package name with green" {
        val packageName = "wget"
        val coloredName: String = agent.colorName(packageName)
        val name = "wget"
        coloredName shouldBe ofColorGreen(name)
    }

    "coloring 'core' repository with blue background color and white foreground" {
        val repository = "core"
        val coloredRepository: String = agent.colorRepository(repository)
        coloredRepository shouldBe "${ANSI_WHITE_ON_BRIGHTBLUE}$repository${ANSI_DEFAUTLS}"
    }

    "coloring 'extra' repository with red backgroud and white foreground" {
        val repository = "extra"
        val coloredRepository: String = agent.colorRepository(repository)
        coloredRepository shouldBe "${ANSI_BLACK_ON_RED}$repository${ANSI_DEFAUTLS}"
    }
})

private fun ofColorGreen(name: String) = "\u001B[32m$name\u001B[39m"
package format

class ResultFormatter {
    fun format(result: String): String {
        val agent = ColoringAgent()
        return "Name: ${agent.colorName("curlie")}\n" + "Version: 1.6.0-1\n"
    }

}

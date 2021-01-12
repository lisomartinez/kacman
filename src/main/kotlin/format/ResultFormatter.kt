package format

class ResultFormatter {
    fun format(result: String): String {
        val agent = ColoringAgent()
        return "Name: ${agent.colorName("curlie")}\n" +
                "Repository: ${agent.colorRepository("community")}\n" +
                "Description: The power of curl, the ease of use of httpie.\n" +
                "Version: 1.6.0-1\n" +
                "Size: (863.1 KiB 2.6 MiB)"
    }

}

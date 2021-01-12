fun main(args: Array<String>) {
    println("Hello World!")
    val exec = Runtime.getRuntime().exec("yay -Ss")
    exec.inputStream.reader(Charsets.UTF_8).use {
        println(it.readText())
    }
    exec.waitFor()
}
package format


enum class Repository(val asString: String) {
    CORE("core"), MULTILIB("multilib"), COMMUNITY("community"), EXTRA("extra"), AUR("aur")
}

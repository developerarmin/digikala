package ir.truelearn.androidmvvmsample

data class AppSettings(
    val language: Language = Language.PERSIAN
)

enum class Language {
    PERSIAN, ENGLISH
}
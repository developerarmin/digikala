package ir.truelearn.androidmvvmsample.util

object Constants {
    const val BASE_URL = "https://dig-za0p.onrender.com/api/v1/"
    const val API_KEY = "EB43556E671B925B9C98E74643BCA"

    fun numberWithLocate(englishStr: String):String {
        var result = ""
        var fa = '۰'
        for (ch in englishStr) {
            fa = ch
            when (ch) {
                '0' -> fa = '۰'
                '1' -> fa = '۱'
                '2' -> fa = '۲'
                '3' -> fa = '۳'
                '4' -> fa = '۴'
                '5' -> fa = '۵'
                '6' -> fa = '۶'
                '7' -> fa = '۷'
                '8' -> fa = '۸'
                '9' -> fa = '۹'
            }
            result = "${result}$fa"
        }
        return result
    }
}
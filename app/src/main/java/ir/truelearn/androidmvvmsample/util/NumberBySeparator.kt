package ir.truelearn.androidmvvmsample.util

import java.text.DecimalFormat

class NumberBySeparator(private val price: String) {

    operator fun invoke(): String {
        val priceFormat = DecimalFormat("###,###")
        return priceFormat.format(Integer.valueOf(price))

    }

}

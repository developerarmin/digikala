package ir.truelearn.androidmvvmsample.util

class DiscountCalculator(private val price: Int, private val discountPercent: Int) {

    operator fun invoke(): Int {
        val discountAmount = (price * discountPercent) / 100
        return price - discountAmount

    }

}


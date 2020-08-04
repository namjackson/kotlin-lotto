package lotto.model

import lotto.model.generator.LottoNumberGenerater
import lotto.model.generator.RandomNumberGenerater

data class Lotto(
    private val generator: LottoNumberGenerater = RandomNumberGenerater
) {
    private val numbers: Numbers = generator.generate()

    override fun toString(): String {
        return numbers.list.toString()
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBER_COUNT = 6
        const val PRICE = 1_000

        fun newAutoInstance() = Lotto()
    }
}

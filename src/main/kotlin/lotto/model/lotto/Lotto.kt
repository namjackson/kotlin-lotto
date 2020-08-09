package lotto.model.lotto

import lotto.model.Prize
import lotto.model.generator.LottoNumberGenerator
import lotto.model.generator.RandomNumberGenerator

data class Lotto(
    private val generator: LottoNumberGenerator = RandomNumberGenerator
) {
    private val numbers: Numbers = generator.generate()

    override fun toString(): String {
        return numbers.list.toString()
    }

    fun checkNumbers(winningNumbers: Numbers, bonusNumber: LottoNumber) =
        Prize.getPrize(numbers.getMatchingCounts(winningNumbers), numbers.isMatch(bonusNumber))

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val NUMBER_COUNT = 6
        const val PRICE = 1_000

        fun newAutoInstance(generator: LottoNumberGenerator = RandomNumberGenerator) =
            Lotto(generator)

        fun isLottoNumberRange(number: LottoNumber) = number.number in MIN_NUMBER..MAX_NUMBER
    }
}

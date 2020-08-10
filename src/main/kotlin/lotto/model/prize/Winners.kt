package lotto.model.prize

class Winners(
    list: List<Prize>
) {
    val lottoBuyCount: Int = list.size
    private val winLotto: Map<Prize, Int> = list.groupingBy { it }.eachCount()

    fun getPrizeCount(prize: Prize): Int = winLotto.getOrDefault(prize, Prize.ZERO.prizeMoney.value)

    fun getTotalYield() = getTotalPrizeMoney() / (lottoBuyCount * Money.LOTTO_PRICE).toDouble()

    private fun getTotalPrizeMoney() = Prize.values().sumBy { (it.prizeMoney * getPrizeCount(it)).value }
}

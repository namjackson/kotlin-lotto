package lotto.model

class LottoManager(money: Int) {
    private val _lottos: MutableList<Lotto> = mutableListOf()
    val lottos: List<Lotto>
        get() = _lottos

    init {
        (1..purchaseCount(money)).forEach { _ ->
            _lottos.add(makeLotto())
        }
    }

    fun checkNumbers(winningNumbers: Numbers): Winners {
        val winners = lottos.map { it.checkNumbers(winningNumbers) }
        return Winners(winners)
    }

    private fun purchaseCount(money: Int) =
        if (money < 0) 0 else (money / Lotto.PRICE)

    private fun makeLotto() = Lotto.newAutoInstance()
}

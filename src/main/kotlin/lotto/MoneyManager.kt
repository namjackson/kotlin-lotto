package lotto

import lotto.model.LottoManager
import lotto.model.lotto.Tickets
import lotto.model.prize.Money
import lotto.view.InputView
import lotto.view.ResultView

fun main() {
    MoneyManager().execute()
}

class MoneyManager(
    private val input: InputView = InputView(),
    private val resultView: ResultView = ResultView
) {
    private lateinit var lottoManager: LottoManager

    fun execute() {
        val money = Money(input.getBuyPrice())
        buyLotto(money)
        checkNumbers()
    }

    private fun buyLotto(money: Money) {
        val manualLottoCount = input.getManualNumberLottoCount(money.availableLottoCount())
        val tickets = Tickets(input.getManualNumbers(manualLottoCount))
        lottoManager = LottoManager(money, tickets)
        resultView.showLottos(lottoManager.lottos)
    }

    private fun checkNumbers() {
        val winners = lottoManager.checkNumbers(input.getWinnerNumbers())
        resultView.showWinners(winners)
    }
}

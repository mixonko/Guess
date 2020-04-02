package com.app.mixonko.guess

class GamePresenter(val view: GameContract, private val random: Random = Random()) {
    private var score = 0
    private var choice = 0

    fun onJokerClick(userChoice: Int) {
        choice = userChoice
        startAnim()
    }

    fun onLepriconClick(userChoice: Int) {
        choice = userChoice
        startAnim()
    }

    fun onFenixClick(userChoice: Int) {
        choice = userChoice
        startAnim()
    }

    private fun getRandom() = random.getRandom()

    private fun startAnim() {
        view.setDisabled()
        view.setEnabled()
        var randomAnim = getRandom()
        when (randomAnim) {
            1 -> view.startAnimJoker()
            2 -> view.startAnimLepricon()
            3 -> view.startAnimFenix()
        }

        if (choice == randomAnim) {
            view.showYouWin()
            view.hideYouWin()
            score++
        } else {
            view.showTryAgain()
            view.hideTryAgain()
            score = 0
        }

        view.setScoreText(score)

    }
}

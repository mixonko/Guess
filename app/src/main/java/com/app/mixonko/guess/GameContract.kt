package com.app.mixonko.guess

interface GameContract {
    fun showYouWin()
    fun hideYouWin()
    fun showTryAgain()
    fun hideTryAgain()
    fun startAnimJoker()
    fun startAnimLepricon()
    fun startAnimFenix()
    fun setEnabled()
    fun setDisabled()
    fun setScoreText(score: Int)
}

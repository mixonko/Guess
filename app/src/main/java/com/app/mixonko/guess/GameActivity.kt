package com.app.mixonko.guess

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import android.widget.TextView

class GameActivity : AppCompatActivity(), GameContract {

    private lateinit var presenter: GamePresenter

    private lateinit var joker: ImageView
    private lateinit var lepricon: ImageView
    private lateinit var fenix: ImageView
    private lateinit var card: ImageView
    private lateinit var youWin: ImageView
    private lateinit var tryAgain: ImageView

    private lateinit var scoreText: TextView

    private val duration = 300L
    private val delayMillis = 1200L

    override fun onCreate(savedInstanceState: Bundle?)  {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        presenter = GamePresenter(this)

        init()

        setOnClickListener()

        setTag()

    }

    private fun setTag() {
        joker.setTag(1)
        lepricon.setTag(2)
        fenix.setTag(3)
    }

    private fun setOnClickListener() {
        joker.setOnClickListener {
            presenter.onJokerClick(joker.getTag() as Int)
        }
        lepricon.setOnClickListener {
            presenter.onLepriconClick(lepricon.getTag() as Int)
        }
        fenix.setOnClickListener {
            presenter.onFenixClick(fenix.getTag() as Int)
        }
    }

    private fun init() {
        joker = findViewById(R.id.joker)
        lepricon = findViewById(R.id.lepricon)
        fenix = findViewById(R.id.fenix)
        card = findViewById(R.id.card)
        youWin = findViewById(R.id.you_win)
        tryAgain = findViewById(R.id.try_again)
        scoreText = findViewById(R.id.score)
    }

    override fun showYouWin() {
        youWin.visibility = View.VISIBLE

    }

    override fun hideYouWin() {
        Handler().postDelayed({
            youWin.visibility = View.INVISIBLE
        }, delayMillis)
    }

    override fun showTryAgain() {
        tryAgain.visibility = View.VISIBLE

    }

    override fun hideTryAgain() {
        Handler().postDelayed({
            tryAgain.visibility = View.INVISIBLE
        }, delayMillis)
    }

    override fun startAnimJoker() {
        card.setImageResource(R.drawable.card_1)

        card.animate()
            .rotationY(90F)
            .setDuration(duration)
            .withEndAction  {
                card.setImageResource(R.drawable.joker_big)
                    card.setRotationY(-90f)
                    card.animate()
                    .rotationY(0F)
                    .setDuration(duration)
                    .start()
            } .start()

        setDefaultImage(R.drawable.joker_big_second)

    }

    override fun startAnimLepricon() {
        card.setImageResource(R.drawable.card_1)

        card.animate()
            .rotationY(90F)
            .setDuration(duration)
            .withEndAction {
                card.setImageResource(R.drawable.lepricon_big)
                card.setRotationY(-90f)
                card.animate()
                    .rotationY(0F)
                    .setDuration(duration)
                    .start()
            }.start()

        setDefaultImage(R.drawable.lepricon_big)

    }

    override fun startAnimFenix() {
        card.setImageResource(R.drawable.card_1)

        card.animate()
            .rotationY(90F)
            .setDuration(duration)
            .withEndAction {
                card.setImageResource(R.drawable.fenix_big)
                card.setRotationY(-90f)
                card.animate()
                    .rotationY(0F)
                    .setDuration(duration)
                    .start()
            }.start()

        setDefaultImage(R.drawable.fenix_big_second)
    }

    override fun setEnabled() {
        Handler().postDelayed({
            joker.isEnabled = true
            lepricon.isEnabled = true
            fenix.isEnabled = true
        }, delayMillis * 3 / 2)
    }

    override fun setDisabled() {
        joker.isEnabled = false
        lepricon.isEnabled = false
        fenix.isEnabled = false
    }

    private fun setDefaultImage(image: Int){
        Handler().postDelayed({
            card.setImageResource(image)
            card.animate()
                .rotationY(90F)
                .setDuration(duration)
                .withEndAction {
                    card.setImageResource(R.drawable.card_2)
                    card.setRotationY(-90f)
                    card.animate()
                        .rotationY(0F)
                        .setDuration(duration)
                        .start()
                }.start()
        }, delayMillis)
    }

    override fun setScoreText(score: Int){
        scoreText.setText("Score - " + score.toString())
    }
}

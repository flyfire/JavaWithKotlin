package com.solarexsoft.kotlinexercise

/**
 * Created by houruhou on 2018/11/7.
 * Desc:
 */
sealed class PlayerCmd {
    class Play(val url: String, val position: Long = 0): PlayerCmd()

    object Pause: PlayerCmd()

    object Resume: PlayerCmd()
}

class Seek(val position: Long): PlayerCmd()

object Stop: PlayerCmd()

enum class PlayState {
    IDEL, PAUSE, PLAYING, STOP
}
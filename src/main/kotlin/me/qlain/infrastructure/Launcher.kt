package me.qlain.infrastructure

import javafx.application.Application

/**
 * 起源
 */
class Launcher {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(MainApp::class.java)
            //println(Font.getFamilies())
        }
    }
}
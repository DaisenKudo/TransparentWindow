package me.qlain

import javafx.application.Application
import javafx.scene.text.Font

class Launcher {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            Application.launch(MainApp::class.java)
            //println(Font.getFamilies())
        }
    }
}
package me.qlain.infrastructure

import javafx.application.Application
import me.qlain.infrastructure.repositoryimpl.Settings
import java.lang.IndexOutOfBoundsException

/**
 * 起源
 */
class Launcher {
    companion object {
        var settingFilePath: String = ""

        @JvmStatic
        fun main(args: Array<String>) {
            try {
                if (args[0] == "--develop") {
                    "src/main/resources/me/qlain/infrastructure/repositoryimpl/settings.json"
                } else {
                    "settings.json"
                }
            } catch (e: IndexOutOfBoundsException) {
                "settings.json"
            }.also { settingFilePath = it }

            Application.launch(MainApp::class.java)
            //println(Font.getFamilies())
        }
    }
}
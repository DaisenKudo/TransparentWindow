package me.qlain.infrastructure.repositoryimpl

import java.io.File
import kotlin.collections.HashMap

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import me.qlain.interfaces.repository.SettingsDefinition
import me.qlain.interfaces.repository.SettingsRepository
import kotlin.IllegalStateException

object Settings : SettingsDefinition {
    //実行するコマンド
    override val command: String
    //コマンドの実行間隔
    override val interval: Int

    private val settings: SettingsRepository

    init {
        settings = LoadSettings().load()
        command = settings.command
        interval = settings.interval
    }

    private class LoadSettings : SettingsRepository {
        override val command: String
            get() = getSettings("command") as String
        override val interval: Int
            get() = getSettings("interval") as Int

        private var settings: HashMap<String, Any> = HashMap()

        override fun load(): LoadSettings {
            settings = jacksonObjectMapper().readValue(
                File("src/main/resources/me/qlain/infrastructure/repositoryimpl/settings.json").readText(),
                HashMap<String, Any>().javaClass
            ) ?: throw IllegalStateException("不正なJSON")

            return this
        }

        private fun getSettings(s: String) = settings[s]
    }
}
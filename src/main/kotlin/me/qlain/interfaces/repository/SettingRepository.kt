package me.qlain.interfaces.repository;

interface SettingRepository {
    val command: String
    val interval: Int

    fun load(): SettingRepository
}

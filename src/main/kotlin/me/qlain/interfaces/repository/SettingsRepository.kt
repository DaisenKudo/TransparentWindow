package me.qlain.interfaces.repository;

interface SettingsRepository : SettingsDefinition {
    fun load(path: String): SettingsRepository
}
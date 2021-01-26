package me.qlain.interfaces.repository;

interface SettingsRepository : SettingsDefinition {
    fun load(): SettingsRepository
}
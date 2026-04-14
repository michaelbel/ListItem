package org.michaelbel.listitem

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object AppSettings {

    private val _dynamicColorsFlow = MutableStateFlow(false)
    val dynamicColorsFlow: StateFlow<Boolean> = _dynamicColorsFlow.asStateFlow()

    fun toggleDynamicColors() {
        _dynamicColorsFlow.value = !_dynamicColorsFlow.value
    }
}

package org.michaelbel.listitem

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.ui.Alignment
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

object AppSettings {

    private val _dynamicColorsFlow = MutableStateFlow(false)
    val dynamicColorsFlow: StateFlow<Boolean> = _dynamicColorsFlow.asStateFlow()

    fun toggleDynamicColors() {
        _dynamicColorsFlow.value = !dynamicColorsFlow.value
    }

    private val _navigationVisibleFlow = MutableStateFlow(true)
    val navigationVisibleFlow: StateFlow<Boolean> = _navigationVisibleFlow.asStateFlow()

    fun toggleNavigationVisible() {
        _navigationVisibleFlow.value = !_navigationVisibleFlow.value
    }

    private val _navigationArrangementFlow = MutableStateFlow(Arrangement.Top)
    val navigationArrangementFlow: StateFlow<Arrangement.Vertical> = _navigationArrangementFlow.asStateFlow()

    fun setNavigationArrangement(arrangement: Arrangement.Vertical) {
        _navigationArrangementFlow.value = arrangement
    }

    private val _primaryActionAlignmentFlow = MutableStateFlow(Alignment.End)
    val primaryActionAlignmentFlow: StateFlow<Alignment.Horizontal> = _primaryActionAlignmentFlow.asStateFlow()

    fun setPrimaryActionAlignment(alignment: Alignment.Horizontal) {
        _primaryActionAlignmentFlow.value = alignment
    }

    private val _customNavigationColorsFlow = MutableStateFlow(false)
    val customNavigationColorsFlow: StateFlow<Boolean> = _customNavigationColorsFlow.asStateFlow()

    fun toggleCustomNavigationColors() {
        _customNavigationColorsFlow.value = !_customNavigationColorsFlow.value
    }
}

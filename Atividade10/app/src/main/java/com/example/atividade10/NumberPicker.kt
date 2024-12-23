package com.example.atividade10

import android.widget.NumberPicker
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun NumberPicker(
    state: MutableState<Int>,
    range: IntRange,
    modifier: Modifier = Modifier
) {
    AndroidView(
        factory = { context ->
            NumberPicker(context).apply {
                minValue = range.first
                maxValue = range.last
                value = state.value
                setOnValueChangedListener { _, _, newVal ->
                    state.value = newVal
                }
            }
        },
        modifier = modifier
    )
}



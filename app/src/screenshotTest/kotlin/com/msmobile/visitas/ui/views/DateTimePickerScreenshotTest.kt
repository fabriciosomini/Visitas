package com.msmobile.visitas.ui.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewScreenshotTest
import com.msmobile.visitas.ui.theme.VisitasTheme
import java.time.LocalDateTime

class DateTimePickerScreenshotTest {

    @PreviewScreenshotTest
    @Preview
    @Composable
    fun dateTimePickerPreview() {
        VisitasTheme(dynamicColor = false) {
            DateTimePicker(
                dateTime = LocalDateTime.of(2024, 6, 15, 10, 30),
                onDateSelected = {},
                onDismiss = {}
            )
        }
    }
}

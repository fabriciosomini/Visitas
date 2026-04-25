package com.msmobile.visitas.ui.theme

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "Foldable",
    device = "spec:parent=pixel_9_pro_fold,orientation=landscape",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Foldable",
    device = "spec:parent=pixel_9_pro_fold,orientation=landscape",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class PreviewFoldable

@Preview(
    name = "Phone",
    device = "id:pixel_9",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Preview(
    name = "Phone",
    device = "id:pixel_9",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class PreviewPhone

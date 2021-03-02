package com.smokelaboratory.jc_challenge_week_1.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.smokelaboratory.jc_challenge_week_1.R

private val appFontFamily1 = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.rocknroll_regular,
            weight = FontWeight.W900,
            style = FontStyle.Normal
        )
    )
)

private val appFontFamily2 = FontFamily(
    fonts = listOf(
        Font(
            resId = R.font.reggae_one_regular,
            weight = FontWeight.W900,
            style = FontStyle.Normal
        )
    )
)

private val defaultTypography = Typography()
val appTypography = Typography(
    h1 = defaultTypography.h1.copy(fontFamily = appFontFamily1),
    h2 = defaultTypography.h2.copy(fontFamily = appFontFamily1),
    h3 = defaultTypography.h3.copy(fontFamily = appFontFamily1),
    h4 = defaultTypography.h4.copy(fontFamily = appFontFamily1),
    h5 = defaultTypography.h5.copy(fontFamily = appFontFamily1),
    h6 = defaultTypography.h6.copy(fontFamily = appFontFamily1),
    subtitle1 = defaultTypography.subtitle1.copy(fontFamily = appFontFamily1),
    subtitle2 = defaultTypography.subtitle2.copy(fontFamily = appFontFamily1),
    body1 = defaultTypography.body1.copy(fontFamily = appFontFamily1),
    body2 = defaultTypography.body2.copy(fontFamily = appFontFamily2),
    button = defaultTypography.button.copy(fontFamily = appFontFamily1),
    caption = defaultTypography.caption.copy(fontFamily = appFontFamily1),
    overline = defaultTypography.overline.copy(fontFamily = appFontFamily1)
)
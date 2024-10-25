package com.example.visitcountry.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Structure(
    @StringRes val structureNameRes: Int,
    @DrawableRes val structureImageRes: Int,
) {
}
package com.example.visitcountry.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Country(
    @StringRes val countryNameRes: Int,
    @StringRes val capitalNameRes: Int,
    @DrawableRes val countryImageRes: Int,
    @StringRes val countryStructureRes: Int
)
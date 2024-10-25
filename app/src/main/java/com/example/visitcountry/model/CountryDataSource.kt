package com.example.visitcountry.model

import com.example.visitcountry.R

class CountryDataSource {
   fun loadCountrys(): List<Country> {
        return listOf<Country>(
            Country(
                countryNameRes = R.string.almanya_name,
                capitalNameRes = R.string.almanya_capital,
                countryImageRes = R.drawable.almanya,
                countryStructureRes = R.string.almanya_structure
            ),
            Country(
                countryNameRes = R.string.ingiltere_name,
                capitalNameRes = R.string.ingiltere_capital,
                countryImageRes = R.drawable.ingiltere,
                countryStructureRes = R.string.ingiltere_structure
            ),
            Country(
                countryNameRes = R.string.italya_name,
                capitalNameRes = R.string.italya_capital,
                countryImageRes = R.drawable.italya,
                countryStructureRes = R.string.italya_structure
            ),
            Country(
                countryNameRes = R.string.ispanya_name,
                capitalNameRes = R.string.ispanya_capital,
                countryImageRes = R.drawable.ispanya,
                countryStructureRes = R.string.ispanya_structure
            ),
            Country(
                countryNameRes = R.string.fransa_name,
                capitalNameRes = R.string.fransa_capital,
                countryImageRes = R.drawable.fransa,
                countryStructureRes = R.string.fransa_structure
            )
        )
    }
}
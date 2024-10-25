package com.example.visitcountry.model

import com.example.visitcountry.R


class StructureDataSource {
    fun loadStructures(): List<Structure> {
        return listOf<Structure>(
            Structure(
                structureNameRes = R.string.reichstag,
                structureImageRes = R.drawable.reichstagbinasi
            ),
            Structure(
                structureNameRes = R.string.koln,
                structureImageRes = R.drawable.kolnkatedrali
            ),
            Structure(
                structureNameRes = R.string.brandenburg,
                structureImageRes = R.drawable.brandenburgkapisi
            )
        )
    }
}
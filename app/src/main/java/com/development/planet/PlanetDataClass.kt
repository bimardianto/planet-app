package com.development.planet

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PlanetDataClass(
    var name: String,
    var type: String,
    var description: String,
    var photo: Int,
    var radius: String,
    var averageTemperature: String,
    var gravity: String
) : Parcelable

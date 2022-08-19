package com.juanimozo.weatherapp.data.network.accuweather_api.current_conditions

import com.juanimozo.weatherapp.data.network.accuweather_api.current_conditions.Direction
import com.juanimozo.weatherapp.data.network.accuweather_api.current_conditions.Speed

data class Wind(
    val Direction: Direction,
    val Speed: Speed
)
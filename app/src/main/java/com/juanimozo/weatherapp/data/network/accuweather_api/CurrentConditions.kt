package com.juanimozo.weatherapp.data.network.accuweather_api

import com.juanimozo.weatherapp.data.network.accuweather_api.current_conditions.CurrentConditionsItem

data class CurrentConditions(
    val currentConditions: List<CurrentConditionsItem>
)
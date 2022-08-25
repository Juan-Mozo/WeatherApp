package com.juanimozo.weatherapp.domain.location

import android.location.Location
import com.juanimozo.weatherapp.util.resource.Resource

interface LocationTracker {

    suspend fun getCurrentLocation(): Resource<Location?>

}
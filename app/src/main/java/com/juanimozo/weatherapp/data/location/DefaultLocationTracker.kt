package com.juanimozo.weatherapp.data.location

import android.Manifest
import android.app.Application
import android.content.Context
import android.content.pm.PackageManager
import android.content.res.Resources
import android.location.Location
import android.location.LocationManager
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.juanimozo.weatherapp.R
import com.juanimozo.weatherapp.domain.location.LocationTracker
import com.juanimozo.weatherapp.util.resource.Resource
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.suspendCancellableCoroutine
import javax.inject.Inject
import kotlin.coroutines.resume

@ExperimentalCoroutinesApi
class DefaultLocationTracker @Inject constructor(
    private val locationClient: FusedLocationProviderClient,
    private val application: Application
): LocationTracker {

    override suspend fun getCurrentLocation(): Resource<Location?> {

        // Check permissions
        val hasAccessFineLocationPermission = ContextCompat.checkSelfPermission(
            application, Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED
        val hasAccessCoarseLocationPermission = ContextCompat.checkSelfPermission(
            application, Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        // Check gps connection
        val locationManager = application.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        // Handle errors
        if (!hasAccessCoarseLocationPermission) {
            return Resource.Error(
                data = null,
                message = "Location permission not granted"
            )
        }
        if (!hasAccessFineLocationPermission) {
            return Resource.Error(
                data = null,
                message = "Location permission not granted"
            )
        }
        if (!isGpsEnabled) {
            return Resource.Error(
                data = null,
                message = "Please turn on device location"
            )
        }

        // Send result
        return suspendCancellableCoroutine { cont ->
            locationClient.lastLocation.apply {
                if (isComplete) {
                    if (isSuccessful) {
                        cont.resume(Resource.Success(result))
                    } else {
                        cont.resume(Resource.Error(
                            data = null,
                            message = "Coroutine task was not successful"
                        ))
                    }
                    return@suspendCancellableCoroutine
                }
                addOnSuccessListener {
                    cont.resume(Resource.Success(it))
                }
                addOnFailureListener {
                    cont.resume(Resource.Error(
                        data = null,
                        message = "Listener failure"
                    ))
                }
                addOnCanceledListener {
                    cont.cancel()
                }
            }
        }
    }

}
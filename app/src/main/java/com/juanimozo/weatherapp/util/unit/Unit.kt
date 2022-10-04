package com.juanimozo.weatherapp.util.unit

sealed class Unit(val name: String, val isMetric: Boolean)  {


    class Metric(name: String = "Metric", isMetric: Boolean = true): Unit(name, isMetric)
    class Imperial(name: String = "Imperial", isMetric: Boolean = false): Unit(name, isMetric)

    companion object {

        fun booleanToUnit(isMetric: Boolean): Unit {
            return if (isMetric) {
                Metric()
            } else {
                Imperial()
            }
        }

        val unitsList = listOf<Unit>(Metric(), Imperial())

    }

}

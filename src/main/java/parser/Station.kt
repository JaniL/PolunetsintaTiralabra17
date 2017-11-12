package main.java.parser

/**
 * A Kotlin type representation of a Station (from Digitransit API)
 */
data class Station (val name: String, val stationId: String, val lat: Double, val lon: Double)
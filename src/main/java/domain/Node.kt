package main.java.domain
import kotlin.js.Math

/**
 * Node that represents a city bike station
 *
 * @property[name] Name of the station
 * @property[x] x-axis of the coordinates
 * @property[y] y-axis of coordinate
 */
data class Node (val name: String, val x: Double, val y: Double)  {
    /**
     * Calculates the Euclidean distance from this [Node] to another,
     * based on their x/y coordinates
     *
     * @return the Euclidean distance of nodes
     */
    fun distance(destination: Node): Double {
        val x = Math.pow(2.0, x - destination.x)
        val y = Math.pow(2.0, y - destination.y)
        return Math.sqrt(x + y)
    }
}
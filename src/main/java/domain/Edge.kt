package main.java.domain
import Node;

/**
 * An edge that connects two nodes with weight
 *
 * One use example for weight is to define the distance
 * between two nodes
 */
data class Edge (val start: Node, val end: Node, val weight: Double)
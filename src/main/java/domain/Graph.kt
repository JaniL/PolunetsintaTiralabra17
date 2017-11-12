package main.java.domain
import Node

/**
 * Data structure of graph
 *
 * Graph is constructed from a set of [Node]'s and a set of [Edge]'s
 */
data class Graph (val nodes: Set<Node>, val edges: Set<Edge>)
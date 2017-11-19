package pathfinder

import main.java.domain.Graph
import main.java.domain.Node

class Dijkstra {
    fun search(graph: Graph, start: Node, target: Node) {
        val Q: Set<Node> = graph.nodes
        // val dist: Array<Double> = Array(graph.nodes.size, { i -> Double.MAX_VALUE })
        // val prev: Array<Node?> = arrayOfNulls(graph.nodes.size)
        val dist: MutableMap<Node, Double> = mutableMapOf<Node, Double>()
        val prev: MutableMap<Node, Node> = mutableMapOf<Node, Node>()

        for (node in graph.nodes) {
            dist.set(node, Double.MAX_VALUE)
        }

        dist.set(start, 0.0)

        while (Q.isNotEmpty()) {
        
        }

    }
}
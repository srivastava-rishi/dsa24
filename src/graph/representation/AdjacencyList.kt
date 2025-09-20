package graph.representation

fun main() {
    // also it's also and undirected graph
    val v = 5
    val edges = mutableListOf(
        mutableListOf(1, 2),
        mutableListOf(2, 3),
        mutableListOf(3, 4),
        mutableListOf(4, 2),
        mutableListOf(1, 3),
    )
    printGraphUsingList(edges)
}

fun printGraphUsingList(
    edges: MutableList<MutableList<Int>>
) {
    val graph = mutableMapOf<Int, MutableList<Int>>()
    // Also if you want store weights you can use Pair like
    val graphWithWeights = mutableMapOf<Int, MutableList<Pair<Int, Int>>>()
    /*
   Nothing was printing ad initially there were no existing key with vertex1 or vertex2
    for (i in edges.indices) {
        val vertex1 = edges[i][0]
        val vertex2 = edges[i][1]
        graph[vertex1]?.add(vertex2)
        // vice - verse - as it's an undirected graph
        graph[vertex2]?.add(vertex1)
    }
      */

    for (i in edges.indices) {
        val vertex1 = edges[i][0]
        val vertex2 = edges[i][1]
        graph.getOrPut(vertex1) { mutableListOf() }.add(vertex2)
        // vice - verse - as it's an undirected graph
        graph.getOrPut(vertex2) { mutableListOf() }.add(vertex1)
    }
    println(graph)
}
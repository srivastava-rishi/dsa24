package graph.detectcycle.undirected

fun main() {
    /*
     V = 4, E = 4, edges[][] = [[0, 1], [0, 2], [1, 2], [2, 3]]
     */

    val a = isCycle(
        4,
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
    )

    println(
        "contain cycle - $a"
    )
}


private fun isCycle(v: Int, edges: Array<IntArray>): Boolean {
    val graph = mutableMapOf<Int, MutableList<Int>>()

    for (i in edges.indices) {
        graph.getOrPut(edges[i][0]) { mutableListOf() }.add(edges[i][1])
        // as it's an undirected graph
        graph.getOrPut(edges[i][1]) { mutableListOf() }.add(edges[i][0])
    }
    val visitedArray = IntArray(v)
    // because we can't just fix a starting node for the  graph as it has multiple nodes
    for (i in 0 until v) {
        // -1 as parent node because we are assuming it will only run for a unique components
        // visitedArray[i] != 1 -> Such that we can avoid calling a function if it's already visited
        if (visitedArray[i] != 1 && dfs(graph, i, -1, visitedArray)) {
            return true
        }
    }
    return false
}

private fun dfs(
    graph: MutableMap<Int, MutableList<Int>>,
    sourceNode: Int,
    parentNode: Int,
    visitedArray: IntArray
): Boolean {
    visitedArray[sourceNode] = 1
    // apply dfs on all it's connected components
    for (i in graph[sourceNode]?.indices ?: emptyList()) {
        val currentNode = graph[sourceNode]!![i]
        /* here we can improve the code by using continue key using that you won;t need
          to write currentNode != parentNode twice */

        if (currentNode != parentNode && visitedArray[currentNode] == 1) {
            return true
        }
        if (currentNode != parentNode && dfs(graph, currentNode, sourceNode, visitedArray)) {
            return true
        }
    }
    return false
}

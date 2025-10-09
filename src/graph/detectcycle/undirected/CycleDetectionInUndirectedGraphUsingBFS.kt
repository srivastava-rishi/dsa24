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
        if (visitedArray[i] != 1 && bfs(graph, i, -1, visitedArray)) {
            return true
        }
    }

    return false
}

fun bfs(
    graph: MutableMap<Int, MutableList<Int>>,
    sourceNode: Int,
    parentNode: Int,
    visitedArray: IntArray
): Boolean {
    val queue = ArrayDeque<Pair<Int, Int>>()
    // add your starting node
    queue.addFirst(Pair(sourceNode, parentNode))
    // mark that to true
    visitedArray[sourceNode] = 1

    while (queue.isNotEmpty()) {
        val currP = queue.removeFirst()
        for (i in graph[currP.first]?.indices ?: emptyList()) {
            val currentNode = graph[currP.first]!![i]
            if (currP.second != currentNode && visitedArray[currentNode] == 1) {
                return true
            } else {
                queue.addLast(Pair(currentNode, currP.first))
            }

        }
    }

    return false
}


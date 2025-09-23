package graph.transversal


fun main() {
    val v = 5
    val visitedArray = IntArray(v + 1)
    val edgeList = mutableListOf(
        mutableListOf(0, 1),
        mutableListOf(1, 4),
        mutableListOf(1, 2),
        mutableListOf(2, 3)
    )

    // make your graph
    val graph = mutableMapOf<Int, MutableList<Int>>()
    for (i in edgeList.indices) {
        graph.getOrPut(edgeList[i][0]) { mutableListOf() }.add(edgeList[i][1])
        graph.getOrPut(edgeList[i][1]) { mutableListOf() }.add(edgeList[i][0])
    }
//    println(graph)
    dfs(v, 0, visitedArray, graph)
}

fun dfs(
    vertices: Int,
    sourceNode: Int,
    visitedArray: IntArray,
    graph: MutableMap<Int, MutableList<Int>>
) {
    println(sourceNode)
    visitedArray[sourceNode] = 1
    for (i in graph[sourceNode]?.indices ?: emptyList()) {
        if (visitedArray[graph[sourceNode]?.get(i)!!] != 1) {
            dfs(vertices, graph[sourceNode]?.get(i)!!, visitedArray, graph)
        }
    }
}
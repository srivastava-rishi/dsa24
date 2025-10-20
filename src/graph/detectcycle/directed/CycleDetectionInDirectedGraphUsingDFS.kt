package graph.detectcycle.directed


fun main() {
    val a = isCycle(
        4,
        arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 3)
        )
    )

//    val a = isCycle(
//        3,
//        arrayOf(
//            intArrayOf(0, 1),
//            intArrayOf(1, 2)
//        )
//    )
    println(
        "contain cycle - $a"
    )
}

private fun isCycle(
    v: Int,
    edges: Array<IntArray>
): Boolean {
    val graph = mutableMapOf<Int, MutableList<Int>>()
    val visitedArray = IntArray(v)
    val currentPath = IntArray(v)
    for (i in edges.indices) {
        graph.getOrPut(edges[i][0]) { mutableListOf() }.add(edges[i][1])
    }
    // We will start dfs from every other node
    for (i in 0 until  v) {
//        if (visitedArray[i] == 1 && currentPath[i] != 1) {
//            return true
//        } else {
//            dfs(i,graph,currentPath,visitedArray)
//        }
        if (dfs(i,graph,currentPath,visitedArray)) {
            return true
        }

    }
    return false
}

fun dfs(
    startEdge: Int,
    graph: MutableMap<Int, MutableList<Int>>,
    currentPath: IntArray,
    visitedArray: IntArray
): Boolean {
    visitedArray[startEdge] = 1
    currentPath[startEdge] = 1
    for (i in graph[startEdge]?.indices ?: emptyList()) {
        val nextNode = graph[startEdge]!![i]
        if (visitedArray[nextNode] != 1) {
            dfs(nextNode,graph,currentPath,visitedArray)
        }
        if (visitedArray[nextNode] == 1 && currentPath[nextNode] == 1){
            return true
        }
    }
    currentPath[startEdge] = 0
    return false
}
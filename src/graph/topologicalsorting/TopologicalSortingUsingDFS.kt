package graph.topologicalsorting

import java.util.*


fun main() {
    val v = 4
    val edges = arrayOf(
        intArrayOf(3, 0),
        intArrayOf(1, 0),
        intArrayOf(2, 0)
    )

    println(topoSort(v, edges))
}

fun topoSort(v: Int, edges: Array<IntArray>): List<Int> {
    val visitedArray = IntArray(v)
    val graph = mutableMapOf<Int, MutableList<Int>>()
    val stack = Stack<Int>()
    val answerList = mutableListOf<Int>()

    // prepare your graph
    for (i in edges.indices) {
        graph.getOrPut(edges[i][0]) { mutableListOf() }.add(edges[i][1])
    }
    // Apply DFS on each vertex
    for (i in 0 until v) {
        if (visitedArray[i] == 0) {
            dfs(
                i,
                graph,
                visitedArray,
                stack
            )
        }
    }
    while (stack.isNotEmpty()) {
        answerList.add(stack.peek())
        stack.pop()
    }
    return answerList
}

fun dfs(
    node: Int,
    graph: MutableMap<Int, MutableList<Int>>,
    visitedArray: IntArray,
    stack: Stack<Int>
) {
    visitedArray[node] = 1
    for (i in graph[node]?.indices ?: emptyList()) {
        val childNode = graph[node]!![i]
        if (visitedArray[childNode] == 1) continue
        dfs(childNode,graph,visitedArray,stack)
    }
    stack.add(node)
}


/*
 public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here

    }
 */
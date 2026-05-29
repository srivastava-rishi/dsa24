package graph.transversal

import java.util.LinkedList


fun main() {
    val edgeList = mutableListOf(
        mutableListOf(0, 1),
        mutableListOf(1, 4),
        mutableListOf(1, 2),
        mutableListOf(2, 3)
    )
    val vertices = 5
    //  Make an adjacency list from above -
    val adjacencyList = mutableMapOf<Int, MutableList<Int>>()
    for (i in edgeList.indices) {
        adjacencyList.getOrPut(edgeList[i][0]) { mutableListOf() }.add(edgeList[i][1])
        adjacencyList.getOrPut(edgeList[i][1]) { mutableListOf() }.add(edgeList[i][0])
    }
    //  println(adjacencyList)
    breadthForSearch(adjacencyList, vertices, 0)
}
// 29 May 26 - Revisited
fun bfsRevisit(
    adjacencyList: MutableMap<Int, MutableList<Int>>,
    vertices: Int,
    source: Int
) {
    val visitedArray = IntArray(vertices)
    val queue = LinkedList<Int>()
    queue.add(source)
    visitedArray[0] = 1
    while (queue.isNotEmpty()) {
        val removalVertex = queue.poll()
        println(removalVertex)
        for (i in adjacencyList[removalVertex]?.indices ?: emptyList()) {
            adjacencyList[removalVertex]?.get(i)?.let {
                if(visitedArray[it] != 1){
                    queue.add(it)
                    visitedArray[it] = 1
                }
            }
        }
    }
}

fun breadthForSearch(
    adjacencyList: MutableMap<Int, MutableList<Int>>,
    vertices: Int,
    source: Int,
) {
    /*
    Queue: a line — FIFO (First-In, First-Out). Add at back, remove from front.
    Deque (“deck”, double-ended queue): a flexible line — can add/remove at both front and back.
    Can behave like a queue or a stack.
   -----------------------------------------------
    Ways to make a queue : -
    Revisted this one -
    0. (Most common way). val queueExample = LinkedList<Int>() Link - https://blog.logrocket.com/kotlin-queue-guide-for-android/
    1. val queue = ArrayDeque<Int>() - this way it's queue and deque both
    2. val jq: Queue<Int> = JArrayDeque() - Java style option
     */
    val visitedArray = IntArray(vertices + 1)
    val queue = ArrayDeque<Int>()
    queue.addLast(source) // add in back
    visitedArray[source] = 1
    while (queue.isNotEmpty()) {
        val node = queue.removeFirst()
        print(node)
        for (i in adjacencyList[node]?.indices ?: emptyList()) {
            val childNode = adjacencyList[node]!![i]
            if (visitedArray[childNode] != 1) {
                adjacencyList[node]?.get(i)?.let {
                    queue.addLast(it)
                    visitedArray[it] = 1
                }
            }
        }
    }
}
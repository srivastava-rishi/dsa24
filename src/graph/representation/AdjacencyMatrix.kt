package graph.representation

fun main() {
    // also it's and undirected graph
    val v = 5
    val edges = mutableListOf(
        mutableListOf(1, 2),
        mutableListOf(2, 3),
        mutableListOf(3, 4),
        mutableListOf(4, 2),
        mutableListOf(1, 3),
    )
    printGraphUsingMatrix(v, edges)
}


fun printGraphUsingMatrix(
    vertices: Int,
    edges: MutableList<MutableList<Int>>
) {
    // to store in actual sense we will be making an n + 1 X n + 1 Matrix
    val matrix = Array(vertices + 1) { IntArray(vertices + 1) }

    for (i in edges.indices) {
        matrix[edges[i][0]][edges[i][1]] = 1 // mapping edges and setting to 1
        // vice - verse as both are connected with each other
        matrix[edges[i][1]][edges[i][0]] = 1
    }
    println(matrix.contentDeepToString())
    /*
    vetices = 5
    edges = (1, 2), (2, 3), (3, 4), (4, 2), (1, 3)
    [
     0   1  2  3  4  5
 0   [0, 0, 0, 0, 0, 0],
 1   [0, 0, 1, 1, 0, 0],
 2   [0, 1, 0, 1, 1, 0],
 3   [0, 1, 1, 0, 1, 0],
 4   [0, 0, 1, 1, 0, 0],
 5   [0, 0, 0, 0, 0, 0]
    ]
     */
}



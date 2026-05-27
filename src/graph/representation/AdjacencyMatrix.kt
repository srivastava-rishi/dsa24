package graph.representation

/*
Revision - May 27 - 2026
 * Kotlin Array init function notes
 *
 * Array constructor:
 *
 *     Array(size: Int, init: (Int) -> T)
 *
 * This constructor takes two parameters:
 *
 * 1. size: Int
 *    - This is the number of elements in the outer Array.
 *    - Example:
 *
 *          Array(7) { ... }
 *
 *      means Kotlin will create an Array with 7 elements.
 *
 * 2. init: (Int) -> T
 *    - This is a function.
 *    - The function receives the current index as an Int.
 *    - The function must return the value that should be stored at that index.
 *
 * Example:
 *
 *     val arr = Array(5) { index ->
 *         index * 2
 *     }
 *
 * Kotlin calls the init function like this:
 *
 *     index = 0 -> returns 0
 *     index = 1 -> returns 2
 *     index = 2 -> returns 4
 *     index = 3 -> returns 6
 *     index = 4 -> returns 8
 *
 * So the final array becomes:
 *
 *     [0, 2, 4, 6, 8]
 *
 * For a 2D matrix:
 *
 *     val matrix = Array(rows) { rowIndex ->
 *         IntArray(cols)
 *     }
 *
 * Here:
 *
 *     Array(rows)
 *
 * creates the outer array, meaning the rows.
 *
 * The init function:
 *
 *     { rowIndex -> IntArray(cols) }
 *
 * runs once for every row.
 *
 * If rows = 3 and cols = 4, Kotlin does something like:
 *
 *     rowIndex = 0 -> creates IntArray(4)
 *     rowIndex = 1 -> creates IntArray(4)
 *     rowIndex = 2 -> creates IntArray(4)
 *
 * So the matrix becomes:
 *
 *     [
 *       [0, 0, 0, 0],
 *       [0, 0, 0, 0],
 *       [0, 0, 0, 0]
 *     ]
 *
 * Important:
 *
 *     IntArray(cols)
 *
 * creates a new row every time the init function runs.
 * So each row is separate.
 *
 * Example:
 *
 *     val matrix = Array(3) { IntArray(4) }
 *
 * This creates:
 *
 *     matrix[0] -> new IntArray(4)
 *     matrix[1] -> new IntArray(4)
 *     matrix[2] -> new IntArray(4)
 *
 * Because of this:
 *
 *     matrix[0][0] = 99
 *
 * only changes the first row:
 *
 *     [99, 0, 0, 0]
 *     [0, 0, 0, 0]
 *     [0, 0, 0, 0]
 *
 * The rowIndex is optional if you do not need it.
 *
 * These are the same:
 *
 *     val matrix = Array(rows) { rowIndex ->
 *         IntArray(cols)
 *     }
 *
 *     val matrix = Array(rows) {
 *         IntArray(cols)
 *     }
 *
 * If you do not use rowIndex, you can omit it.
 *
 * Why this does not work:
 *
 *     val j = Array(7) {
 *         Array(7)
 *     }
 *
 * Because normal Array needs both:
 *
 *     Array(size, initFunction)
 *
 * So the inner Array(7) is incomplete.
 * Kotlin knows the size is 7, but it does not know what values to put inside.
 *
 * Correct version:
 *
 *     val j = Array(7) {
 *         Array(7) { 0 }
 *     }
 *
 * This creates Array<Array<Int>>.
 *
 * For integer matrices, this is usually better:
 *
 *     val j = Array(7) {
 *         IntArray(7)
 *     }
 *
 * This creates Array<IntArray>.
 * IntArray(7) works because IntArray can fill values with 0 automatically.
 *
 * Simple memory:
 *
 *     Array(rows) { IntArray(cols) }
 *
 * means:
 *
 *     Create rows number of elements.
 *     For each row, run the init function.
 *     The init function returns a new IntArray(cols).
 */

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



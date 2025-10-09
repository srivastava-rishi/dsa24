package graph.questions

val possibleMoves: Array<IntArray> = arrayOf(
    intArrayOf(-2, -1),
    intArrayOf(-2, 1),
    intArrayOf(-1, -2),
    intArrayOf(-1, 2),
    intArrayOf(1, -2),
    intArrayOf(1, 2),
    intArrayOf(2, -1),
    intArrayOf(2, 1)
) // total 8 possible of our knights

fun main() {
    val knightPos = intArrayOf(3, 3) // intArrayOf(4, 5)
    val targetPos = intArrayOf(1, 2) // intArrayOf(1, 1)
    val n = 6
    val answer = minStepToReachTarget(
        knightPos = knightPos,
        targetPos = targetPos,
        n = n
    )
    println("level is - $answer")
}

fun minStepToReachTarget(
    knightPos: IntArray,
    targetPos: IntArray,
    n: Int // vertices
): Int {
    /*
   RelationShip establishment from the given coordinates ,to our matrix based coordinates that we
   usually use :-

   for - 1. row = n - row and column = column - 1

     */
    val sourceX = n - knightPos[1]
    val sourceY = knightPos[0] - 1
    var targetX = n - targetPos[1]
    var targetY = targetPos[0] - 1

    val queue = ArrayDeque<Pair<Int, Int>>()
    val visitedArray = Array(n) { IntArray(n) }

    // add source - knight start position
    queue.addLast(Pair(sourceX, sourceY))
    visitedArray[sourceX][sourceY] = 1
    var level = 0
    while (queue.isNotEmpty()) {
        var nodesPresentInCurrentLevel = queue.size
        /*
        Initially I putted this here, which was wrong as basically because of this nothing going
        to be run - Think about this  you will get this
           var currentNode = queue.removeFirst()
           if (currentNode.first == targetX && currentNode.second == targetY) {
               return level
            }
         */
        while (nodesPresentInCurrentLevel > 0) {
            var currentNode = queue.removeFirst()
            if (currentNode.first == targetX && currentNode.second == targetY) {
                return level
            }
            for (i in possibleMoves.indices) {
                val row = currentNode.first - possibleMoves[i][0]
                val column = currentNode.second - possibleMoves[i][1]
                if (row in 0 until n && column in 0 until n) {
                    if (visitedArray[row][column] != 1) {
                        queue.addLast(Pair(row, column))
                        visitedArray[row][column] = 1
                    }
                }
            }
            nodesPresentInCurrentLevel--
        }
        level++
    }

    return level
}
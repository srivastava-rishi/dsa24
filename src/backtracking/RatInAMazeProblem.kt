package backtracking


/*
Input: mat[][] = [[1, 0, 0, 0], [1, 1, 0, 1], [1, 1, 0, 0], [0, 1, 1, 1]]
Output: ["DDRDRR", "DRDDRR"]
 */

lateinit var direction: List<TravelPass>

fun main() {
    val a = arrayOf(
        intArrayOf(1, 0, 0, 0),
        intArrayOf(1, 1, 0, 1),
        intArrayOf(1, 1, 0, 0),
        intArrayOf(0, 1, 1, 1),
    )
    direction = initiateData()
    println(ratInMaze(a))
}


fun ratInMaze(maze: Array<IntArray>): List<String> {
    val answer = mutableListOf<String>()
    val temp = mutableListOf<Char>()
    solve(0, 0, maze, temp, answer)
    return answer
}


fun solve(x: Int, y: Int, maze: Array<IntArray>, temp: MutableList<Char>, answer: MutableList<String>) {
    // rat said bc
    if (x == maze.size - 1 && y == maze[0].size - 1) {
        answer.add(temp.joinToString(""))
    }
    // offBounds case
    if (x !in maze.indices || y !in maze.indices) return
    //    val visited =
    for (i in direction.indices) {
        if (maze[x][y] != 0) {
            // add
            temp.add(direction[i].direction)
            // also to handle repeated cases mark o if visited
            maze[x][y] = 0
            solve(
                x = (x + direction[i].x),
                y = (y + direction[i].y),
                maze = maze,
                temp = temp,
                answer = answer
            )
            // backtrack
            maze[x][y] = 1
            if (temp.isNotEmpty()) {
                temp.removeAt(temp.size - 1)
            }
        }
    }
}

fun initiateData(): List<TravelPass> {
    return listOf(
        TravelPass(
            direction = 'U',
            x = -1,
            y = 0
        ),
        TravelPass(
            direction = 'D',
            x = 1,
            y = 0
        ),
        TravelPass(
            direction = 'L',
            x = 0,
            y = -1
        ),
        TravelPass(
            direction = 'R',
            x = 0,
            y = 1
        )
    )
}

data class TravelPass(
    val direction: Char,
    val x: Int,
    val y: Int,
)
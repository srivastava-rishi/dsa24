package slidingWindow


fun main() {
    val data = arrayOf(1, 2, 3, 4)

    var i = 0
    var j = 0
    val givenWindowSize = 3
    var answer = Int.MIN_VALUE
    var sum = 0

    while (j < data.size) {
        sum += data[j]
        when {
            j - i + 1 < givenWindowSize -> {
                j++
            }

            else -> {
                answer = answer.coerceAtLeast(sum)
                sum -= data[i]
                i++
                j++
            }
        }
    }

    println(answer)
}

class SlidingWindow {
}
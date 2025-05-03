package slidingWindow


fun main() {
    val array = intArrayOf(12, -1, -7, 8, -15, 30, 16, 28)
    val windowSize = 3


    // for sliding window
    var i = 0
    var j = 0
    var answerList = mutableListOf<Int>()
    var tempList = mutableListOf<Int>()

    while (j < array.size) {
        if (array[j] < 0) {
            tempList.add(array[j])
        }
        when {
            (j - i + 1) < windowSize -> {
                j++
            }

            else -> {
                if (tempList.isNotEmpty()) {
                    answerList.add(tempList[0])
                    if (array[i] == tempList[0]) {
                        tempList.removeAt(0)
                    }
                } else {
                    answerList.add(0)
                }
                println("tempList = $tempList")
                i++
                j++
            }
        }
    }

    println(answerList)
}
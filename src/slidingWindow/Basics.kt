package slidingWindow

fun main() {
    val arr = arrayOf(1, 2, 3, 4)

    /*
    Q1. Find all possible subArrays
       Formula - n*(n+/1/2) = 1
//    */
//    for (i in arr.indices) {
//        var temp = ""
//        for (j in i until arr.size) {
//            temp = temp + " " + arr[j]
//            print(temp)
//            println()
//        }
//    }

    /*
    Same answer but different approach
    val answer = mutableListOf<MutableList<Int>>()
    for (i in arr.indices) {
        val temp = mutableListOf<Int>()
        for (j in i until arr.size) {
            temp.add(arr[j])
            answer.add(temp.toMutableList())
        }
    }
     println(answer)
    */

    // this time let's say questions changes to  find the subArray of length 3 which has the largest sum
    val answerList = HashMap<Int, MutableList<MutableList<Int>>>()
    var maxValue = Int.MIN_VALUE
    val k = 3
    for (i in arr.indices) {
        val temp = mutableListOf<Int>()
        var t2 = 0
        for (j in i until arr.size) {
            t2 += arr[j]
            temp.add(arr[j])
            if (temp.size == 3) {
                if (answerList.containsKey(t2)) {
                    answerList[t2]?.let {
                        it.add(temp.toMutableList())
                        answerList[t2] = it
                    }
                }
                else{
                    answerList[t2] = mutableListOf(temp.toMutableList())
                }
                maxValue = maxValue.coerceAtLeast(t2)
            }
        }
    }

    println(answerList)
    println(answerList[maxValue])
}
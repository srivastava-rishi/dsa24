package named


fun main() {
    var pot = arrayOf(1, 2, 3, 4)

    /*
    to get all possible subArray
     */
//    for (i in pot.indices) {
//        var a = ""
//        for (j in i until pot.size) {
//            a = a + " " + pot[j]
//            println(a)
//        }
//    }

    /*
    find the subArray of length 3 that has the largest sum
  */
    var largestSum = Int.MIN_VALUE
    for (i in pot.indices) {
        var a = ""
        for (j in i until pot.size) {
            a = a + " " + pot[j]
            //  println(a.replace(" ",""))
            if (a.replace(" ", "").length == 3) {
//                println(a)
                val sum = a.replace(" ", "").sumOf {
                    it.digitToInt()
                }
                println(a)
                largestSum = largestSum.coerceAtLeast(sum)
            }
        }
    }
    println(largestSum)
}

class AllPossibleSubArray {
}
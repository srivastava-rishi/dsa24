package slidingWindow


fun main() {
    val s = "aabaabaa"
    val t = "aaba"
    val windowSize = t.length
    var i = 0
    var j = 0
    val hm1 = mutableMapOf<Char, Int>()
    var answer = 0
    // lets save the occurrence like below in hm1
    /*  { a:3, b:1 }  */
    for (i in t.indices) {
        if (hm1.contains(t[i])) {
            hm1[t[i]] = (hm1[t[i]] ?: 0) + 1
        } else {
            hm1[t[i]] = 1
        }
    }
    var countOfDistinctCharacter = hm1.size
    while (j < s.length) {
        // let's search if it is present
        println("line no 23- hm1 -> $hm1 , countOfDistinctCharacter - $countOfDistinctCharacter and j = $j ")
        if (hm1.contains(s[j])) {
            if ((hm1[s[j]] ?: 0) - 1 == 0) countOfDistinctCharacter--
            hm1[s[j]] = (hm1[s[j]] ?: 0) - 1
        }
        println("line no 29 - hm1 -> $hm1 countOfDistinctCharacter - $countOfDistinctCharacter and j = $j")
        when {
            (j - i + 1 < windowSize) -> {
                j++
            }

            else -> {
                println("line no 36 countOfDistinctCharacter - $countOfDistinctCharacter")
                if (countOfDistinctCharacter == 0) answer++
                if (hm1.containsKey(s[i])) {
                    if ((hm1[s[i]] ?: 0) == 0) countOfDistinctCharacter++
                    hm1[s[i]] = (hm1[s[i]] ?: 0) + 1
                }
                println("line no 42 answer - $answer , countOfDistinctCharacter - $countOfDistinctCharacter")
                i++
                j++
            }
        }
    }

    println(answer)
}
/*
    aabaabaa

    val s = "aaba"
    { a:0, b:0 }
    answer = 1

    But then we removed a from our window hence increment 1
    { a:1, b:0 }
    but as we have also added 'a' again it becomes an anagram
    answer = 2

    "aa baab aa"

    { a:1, b:1 }

 */


object CountOccurrencesOfAnagrams {
    fun myWay(
        text: String,
        pattern: String
    ): Int {

        var i = 0
        var j = 0
        var windowSize = pattern.length

        var hm1 = mutableMapOf<Char, Int>()
        var hm2 = mutableMapOf<Char, Int>()

        var answer = 0

        for (k in pattern.indices) {
            if (hm1.containsKey(pattern[k])) {
                hm1[pattern[k]] = (hm1[pattern[k]] ?: 0) + 1
            } else {
                hm1[pattern[k]] = 1
            }
        }
        while (j < text.length) {
            //
            if (hm2.containsKey(text[j])) {
                hm2[text[j]] = (hm2[text[j]] ?: 0) + 1
            } else {
                hm2[text[j]] = 1
            }
            //
            when {
                (j - i + 1) < windowSize -> {
                    j++
                }

                else -> {
                    //logic
                    if (hm1 == hm2) {
                        answer++
                    }
                    if (hm2.containsKey(text[i])) {
                        hm2[text[j]] = (hm2[text[j]] ?: 0) - 1
                    }
                    i++
                    j++
                }
            }
        }

        return answer
    }
}
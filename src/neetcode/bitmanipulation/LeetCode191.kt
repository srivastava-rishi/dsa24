package neetcode.bitmanipulation


fun main() {
    var number = 5
    var binary = ""


    while (number > 0) {
        binary = (number % 2).toString() + binary
        number /= 2
    }
    println(5.toString(2).count { it != '0' }) // a way do the same

    println(binary)
}

class LeetCode191 {
}
package kotlinleetcode


fun main() {
    val a = "anagram"
    val b = "nagaram"
    //
    val aSort = a.toCharArray().sorted()
    val bSort = b.toCharArray().sorted()
    println(aSort === bSort)
}
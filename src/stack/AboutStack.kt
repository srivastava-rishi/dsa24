package stack

import java.util.Stack

/*
 * 🔍 Stack vs List in Kotlin – Real Difference
 *
 * ✅ At the base level, both List and Stack can behave the same — they support LIFO if used that way.
 * ✅ The main difference lies in *intent* and *usage pattern*.
 *
 * A List is a general-purpose data structure. You can:
 * - Add at any index
 * - Access by index
 * - Remove from anywhere
 *
 * A Stack is a restricted structure meant only for:
 * - push (add)
 * - pop (remove last)
 * - peek (see top element)
 *
 * So while technically you can use a List as a Stack,
 * using a real Stack (like ArrayDeque) makes your intention clear,
 * avoids accidental misuse, and improves code readability.
 *
 * 💡 Summary: Stack is just a restricted List with only LIFO operations allowed.
 */


fun main() {
  // Let's see it's uses :-
    val stack = ArrayDeque<Int>()
    val h = Stack<Int>() // java way
    val stack2 = ArrayDeque<List<List<Int>>>()
    stack.addLast(2)
    stack.addLast(5)
    println(stack)
    stack.removeLast()
    println(stack)
}

package stack

import java.util.Deque


/*

Let;s make our own custom stack ;)

note:- Kotlin does not have any class like stack,but we can
use ArrayDeque<Int>() to use it.


It should have below features :-
1. peek() - Lets you peek (see) the topmost element in the stack without removing it.
2. push(item) - Pushes (adds) a new element to the top of the stack.
3. pop() - both removes the top element AND returns it.
 */

fun main() {
    val a = Stack<String>()
    a.push("A")
    a.push("B")
    a.push("C")
    println(a.pop())
}

class Stack<T> {
    private val list = mutableListOf<T>()
    fun peek(): T {
        return list[list.size - 1]
    }

    fun pop(): T {
        val removingElement = list[list.size - 1]
        list.removeAt(list.size - 1)
        return removingElement
    }

    fun push(add: T) {
        list.add(add)
    }
}
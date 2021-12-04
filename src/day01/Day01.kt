package day01

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { it.toInt() }
            .windowed(size = 2)
            .count { (i, j) ->
                j > i
            }
    }

    fun part2(input: List<String>): Int {
        var previousSum = -1;

        return input
            .map { it.toInt() }
            .windowed(size = 3)
            .count { (i, j, k) ->
                val sum = i + j + k
                val temp = previousSum
                previousSum = sum
                sum > temp && temp != -1
            }
    }

    // test if implementation meets criteria from the description, like:
    val testInput = readInput("day01/Day01_test")
    check(part1(testInput) == 7)

    val dayOne = readInput("day01/Day01")
    check(part1(dayOne) == 1602)
}

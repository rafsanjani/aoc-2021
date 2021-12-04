package day02

import readInput

fun main() {
    fun part1(input: List<String>): Int {
        var horizontalPosition = 0
        var depth = 0

        input.map {
            val (a, b) = it.split(" ")
            Movement(a, b.toInt())
        }
            .forEach { movement ->
                if (movement.direction == "forward") {
                    horizontalPosition += movement.distance
                }
                if (movement.direction == "down") {
                    depth += movement.distance
                }
                if (movement.direction == "up") {
                    depth -= movement.distance
                }
            }.also {
                println(horizontalPosition * depth)
            }

        return horizontalPosition * depth
    }


    fun part2(input: List<String>): Int{
        var horizontalPosition = 0
        var aim = 0
        var depth = 0

        input.map {
            val (a, b) = it.split(" ")
            Movement(a, b.toInt(), 0)
        }.forEach { movement ->
            if (movement.direction == "forward") {
                horizontalPosition += movement.distance
                if (aim != 0) {
                    depth += movement.distance * aim
                }
            }

            if (movement.direction == "down") {
                aim += movement.distance
            }
            if (movement.direction == "up") {
                aim -= movement.distance
            }
        }

        return horizontalPosition * depth
    }


    check(part1(readInput("day02/Day02")) == 1480518)
    check(part1(readInput("day02/Day02_Test")) == 150)

    check(part2(readInput("day02/Day02")) == 1282809906)
    check(part2(readInput("day02/Day02_Test")) == 900)
}

data class Movement(
    val direction: String,
    val distance: Int,
    val aim: Int = 0
)
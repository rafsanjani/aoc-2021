package day03

import readInput

fun main() {

    fun String.binaryToDecimal(): Int =
        toInt(2)

    fun String.gammaToEpsilon(): Int =
        map { if (it == '0') '1' else '0' }
            .joinToString(separator = "")
            .toInt(2)


    fun part1(input: List<String>): Int {
        var gammaString = ""

        val bitLength = input.first().length;

        var position = 0;

        while (position < bitLength) {
            var binary = ""

            for (item in input) {
                binary += item[position]
            }

            val zeroes = binary.count {
                it == '0'
            }

            gammaString += if (zeroes > input.size / 2) {
                "0"
            } else {
                "1"
            }

            position++
        }


        return gammaString.binaryToDecimal() * gammaString.gammaToEpsilon()
    }

    fun findOxygenRating(values: List<String>, position: Int = 0): String {
        if (values.size == 1)
            return values.first()

        val highs = values.count { it[position] == '1' }
        val lows = values.count { it[position] == '0' }


        val bitToKeep = if (highs > lows) '1' else if (lows > highs) '0' else '1'

        val newValues = mutableListOf<String>()

        values.forEach {
            if (it[position] == bitToKeep)
                newValues.add(it)
        }

        return findOxygenRating(newValues, position + 1)
    }

    fun findCO2Rating(values: List<String>, position: Int = 0): String {
        if (values.size == 1)
            return values.first()

        val highs = values.count { it[position] == '1' }
        val lows = values.count { it[position] == '0' }


        val bitToKeep = if (highs > lows) '0' else if (lows > highs) '1' else '0'

        val newValues = mutableListOf<String>()

        values.forEach {
            if (it[position] == bitToKeep)
                newValues.add(it)
        }

        return findCO2Rating(newValues, position + 1)
    }

    fun part2(input: List<String>): Int {
        return findCO2Rating(input).binaryToDecimal() * findOxygenRating(input).binaryToDecimal()
    }


    check(part1(readInput("day03/Day03_test")) == 198)
    check(part1(readInput("day03/Day03")) == 3429254)

    check(part2(readInput("day03/Day03_test")) == 230)
    check(part2(readInput("day03/Day03")) == 5410338)
}
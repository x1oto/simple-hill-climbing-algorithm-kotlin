import Constants.chars
import kotlin.random.Random

fun main() {
    // Set the target string that the algorithm will try to match
    val target = "YOUR STRING"

    // Generate a random initial string of the same length as the target
    var current = randomString(target)

    // Set the maximum number of iterations for the Hill Climbing algorithm
    val maxIterations = 1000

    // Run the Hill Climbing algorithm to optimize the current string toward the target
    runHillClimbingAlgorithm(maxIterations, target, current)
}

private fun runHillClimbingAlgorithm(maxIterations: Int, target: String, current: String) {
    var current1 = current
    // Iterate through the algorithm for a maximum of maxIterations
    for (i in 0..maxIterations) {
        // Calculate the fitness of the current string
        val bestFitness = fitness(target, current1)

        // Generate a neighboring string by modifying one character of the current string
        val newNeighbor = generateNeighbor(current1)

        // Calculate the fitness of the neighboring string
        val newFitness = fitness(target, newNeighbor)

        // If the new neighbor has a better fitness score, update the current string
        if (newFitness > bestFitness) {
            current1 = newNeighbor

            // If the current string matches the target, stop the algorithm
            if (current1 == target) {
                println("Target string has been found on iteration $i.! Current string --> $current1, Target: $target")
                break
            } else {
                // Otherwise, print the updated fitness information
                println("Upgraded fitness has been found on iteration $i.! Current string --> $current1, Target: $target")
            }
        }
    }
}

private fun generateNeighbor(current: String): String {
    // Convert the current string to a char array for modification
    val charArray = current.toCharArray()

    // Select a random index in the string to change
    val randomIndex = Random.nextInt(from = 0, until = current.length)

    // Select a random character from the list of available characters
    val newChar = Random.nextInt(from = 0, until = chars.length)

    // Replace the character at the random index with a new character
    charArray[randomIndex] = chars[newChar]

    // Join the char array back into a string and return it
    return charArray.joinToString("")
}

private fun fitness(target: String, current: String): Int {
    var match = 0
    // Compare each character in the target and current strings and count matches
    target.forEachIndexed { index, char -> if (current[index] == char) match++ }
    return match
}

private fun randomString(target: String) =
    // Generate a random string of the same length as the target, using random characters
    target.map { chars.random() }.joinToString("")

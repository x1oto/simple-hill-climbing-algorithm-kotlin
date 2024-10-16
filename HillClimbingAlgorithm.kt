import Constants.CHARS
import Constants.TIMES
import kotlin.random.Random

class SimpleHillClimbingAlgorithm {

    // Run the hill-climbing algorithm to evolve a string toward the target.
    fun run(target: String) {
        // Initialize the current string with a randomly generated one.
        var current = randomString(target)

        // Iterate a fixed number of times (controlled by TIMES constant).
        for (i in 0..TIMES) {
            // Calculate the fitness of the current string (number of matching characters).
            val bestFitness = fitness(target, current)
            // Generate a neighbor string by modifying one character from the current string.
            val newNeighbor = generateNeighbor(current)
            // Calculate the fitness of the new neighbor string.
            val newFitness = fitness(target, newNeighbor)

            // If the neighbor's fitness is better, replace the current string with the neighbor.
            if (newFitness > bestFitness) {
                current = newNeighbor

                // If the new string matches the target, print a success message and break the loop.
                if (current == target) {
                    println("Target string has been found on iteration $i! Current string --> $current, Target: $target")
                    break
                } else {
                    // Otherwise, print the updated fitness and the current string.
                    println("Upgraded fitness has been found on iteration $i! Current string --> $current, Target: $target")
                }
            }
        }
    }

    // Generate a neighboring string by changing a random character in the current string.
    private fun generateNeighbor(current: String): String {
        // Convert the current string to a char array for modification.
        val charArray = current.toCharArray()

        // Select a random index in the string to change.
        val randomIndex = Random.nextInt(from = 0, until = current.length)

        // Select a random character from the list of available characters (CHARS).
        val newChar = Random.nextInt(from = 0, until = CHARS.length)

        // Replace the character at the random index with a new random character.
        charArray[randomIndex] = CHARS[newChar]

        // Join the char array back into a string and return it.
        return charArray.joinToString("")
    }

    // Calculate the fitness of a string, which is the number of characters that match the target string.
    private fun fitness(target: String, current: String): Int {
        var match = 0
        // Compare each character in the target and current strings and count the matches.
        target.forEachIndexed { index, char -> if (current[index] == char) match++ }
        return match
    }

    // Generate a random string of the same length as the target string using random characters from CHARS.
    private fun randomString(target: String) =
        target.map { CHARS.random() }.joinToString("")
}

# Implementation of Hill Climbing Algorithm in Kotlin

## Situation
We are tasked with finding an optimal match for a target string using a Hill Climbing algorithm. The challenge involves starting with a random string of the same length as the target and iteratively improving it by changing characters until it matches the target.

## Goal
The main goal is to generate a string that exactly matches the target string `"YOUR STRING"`. At each step, the algorithm modifies one random character in the current string, compares it to the target, and retains changes that improve the match.

## Use of Hill Climbing Algorithm
Hill Climbing is a heuristic search algorithm that iteratively moves towards a better solution by making local changes. In this implementation, the goal is to maximize the number of matching characters between the current string and the target string. The algorithm continues until it finds an exact match or reaches the maximum number of iterations.

## The process will involve several key stages:

1. **Initialization:**  
   Start with a randomly generated string of the same length as the target.

2. **Fitness Evaluation:**  
   Measure how close the current string is to the target by counting the number of matching characters. The more matching characters, the higher the fitness score.

3. **Generate Neighbor:**  
   Create a new neighbor by randomly changing one character in the current string.

4. **Comparison:**  
   Compare the fitness of the new neighbor with the current string. If the neighbor has a higher fitness score (more matching characters), it becomes the new current string.

5. **Iteration:**  
   Repeat the process, continually moving towards better solutions. If no further improvement can be made, the algorithm stops.

6. **Termination:**  
   The algorithm ends when either the target string is found, or the maximum number of iterations is reached.

## Example of Target and Random String Matching
For the target string `"MYKOLA SUPER"`, the algorithm will start with a randomly generated string of the same length. With each iteration, it changes one character at a time, trying to increase the fitness score by matching more characters to the target.

## Code Structure:

- **`runHillClimbingAlgorithm`**: This function drives the Hill Climbing process, iterating through the algorithm until the target string is found or a local maximum is reached.
  
- **`generateNeighbor`**: This function creates a neighboring string by modifying a random character in the current string.

- **`fitness`**: This function calculates the fitness score by counting the number of matching characters between the current string and the target.

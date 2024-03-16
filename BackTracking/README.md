# Backtracking

This directory contains solutions to problems that can be solved using the `Tree` Data Structure.

## Questions
1. [N-Queens Problem](#n-queens-problem)

## Approach

### N-Queens Problem 

> [!IMPORTANT]
>To find the kth smallest node in a binary tree, we can utilize the property of in-order traversal. In an in-order traversal, visiting nodes in non-decreasing order (left-root-right) ensures that the smallest node is visited first, followed by the second smallest, and so on. Therefore, the kth node visited during an in-order traversal of the tree will be the kth smallest node.

> [!IMPORTANT]
> O(N!) solution using Backtracking + Hashing + Recursion
   Here's a step-by-step explanation of the approach:

   1. **In-Order Traversal**: We perform an in-order traversal of the binary tree.
   2. **Counting Nodes**: While traversing, we keep track of the number of nodes visited so far.
   3. **Stopping Condition**: When the count of visited nodes becomes equal to k, we stop the traversal.
   4. **Returning the Node**: The node visited at the point of stopping will be the kth smallest node.

   To implement the above approach, we might need additional data structures or variables to assist in counting nodes and maintaining the traversal state. Here's a brief explanation of some key components used in the provided code:

      - **leftRowHash**: This array is used to mark whether a row in the chessboard (used in the N-Queens problem) has a queen placed on it. It helps in checking whether a particular row is available for placing a queen.
      - **upperDiagonalHash**: This array helps in marking whether the upper diagonal of the current position on the chessboard has a queen placed on it. It ensures that no queen attacks another queen diagonally.
      - **lowerDiagonalHash**: Similar to the upper diagonal hash, this array marks the availability of the lower diagonal for placing a queen, preventing diagonal attacks.

   These arrays are used to efficiently check whether a particular position on the chessboard is safe for placing a queen, thus aiding in the backtracking algorithm used to solve the N-Queens problem.

   The `solve()` method is a recursive backtracking algorithm that attempts to place queens on the chessboard while satisfying the constraints of the problem. It explores different configurations of queens on the board until a valid solution is found.

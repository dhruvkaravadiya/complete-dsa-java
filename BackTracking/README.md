# Backtracking

This directory contains solutions to problems that can be solved using the `Tree` Data Structure.

## Questions
1. [N-Queens Problem](#n-queens-problem)
2. [Generate Parenthesis](#generate-parenthesis) 
3. [Subsets](#subsets)
4. [Permutations](#permutations)
5. [Combination Sum](#combination-sum)

## Approach

### N-Queens Problem
- `O(N!) solution using Backtracking + Hashing + Recursion`

> [!IMPORTANT]
>To find the kth smallest node in a binary tree, we can utilize the property of in-order traversal. In an in-order traversal, visiting nodes in non-decreasing order (left-root-right) ensures that the smallest node is visited first, followed by the second smallest, and so on. Therefore, the kth node visited during an in-order traversal of the tree will be the kth smallest node.


Here's a step-by-step explanation of the approach:

1. **In-Order Traversal**: We perform an in-order traversal of the binary tree.
2. **Counting Nodes**: While traversing, we keep track of the number of nodes visited so far.
3. **Stopping Condition**: When the count of visited nodes becomes equal to k, we stop the traversal.
4. **Returning the Node**: The node visited at the point of stopping will be the kth smallest node.

To implement the above approach, we might need additional data structures or variables to assist in counting nodes and maintaining the traversal state. Here's a brief explanation of some key components used in the provided code:

   - `leftRowHash`: This array is used to mark whether a row in the chessboard (used in the N-Queens problem) has a queen placed on it. It helps in checking whether a particular row is available for placing a queen.
   - `upperDiagonalHash`: This array helps in marking whether the upper diagonal of the current position on the chessboard has a queen placed on it. It ensures that no queen attacks another queen diagonally.
   - `lowerDiagonalHash`: Similar to the upper diagonal hash, this array marks the availability of the lower diagonal for placing a queen, preventing diagonal attacks.

   These arrays are used to efficiently check whether a particular position on the chessboard is safe for placing a queen, thus aiding in the backtracking algorithm used to solve the N-Queens problem.

   The `solve()` method is a recursive backtracking algorithm that attempts to place queens on the chessboard while satisfying the constraints of the problem. It explores different configurations of queens on the board until a valid solution is found.

---

### Generate Parenthesis
> [!IMPORTANT]
> Input: n = 3
> Expected Output: ["((()))","(()())","(())()","()(())","()()()"]
1. `Base Case`: If both the count of opening and closing parentheses equals n, add the current combination to the result list.
2. `Recursive Exploration`: For each recursive call, there are two possibilities:
   - If the count of opening parentheses is less than n, add an opening parenthesis to the current combination and recursively call the function with an incremented count of opening parentheses.
   - If the count of closing parentheses is less than the count of opening parentheses, add a closing parenthesis to the current combination and recursively call the function with an incremented count of closing parentheses.
3. `Backtracking Step`: After exploring all possibilities with the current combination, remove the last added parenthesis before backtracking to the previous state
---

### Subsets
> [!IMPORTANT]
> Input: arr = [1,2,3]
> Expected Output: [[],[1],[1,2],[1,2,3],[1,3],[2],[2,3],[3]]
1. `Base Case`: Add the current subset to the result list.
2. `Recursive Exploration`: Iterate through the array elements starting from the given index. For each element:
   - Add the current element to the subset.
   - Recursively call the function with the updated subset and incremented index.
3. `Backtracking Step`: After exploring all possibilities with the current element, remove it from the subset before backtracking to the previous state.
---

### Permutations
> [!IMPORTANT]
> You are supposed to to return all possible combinations of each of the element of the array with no repetations ,
> Example : arr = [1,2,3] , then solution = [ [1,2,3] , [1,3,2] , [2,1,3] , [2,3,1] , [3,1,2] , [3,2,1] ]
1. `Base Case`: If the current permutation has the same length as the input array, add it to the result list.
2. `Recursive Exploration`: Iterate through the array elements. For each element:
   - If the element is not already present in the current permutation, add it to the permutation.
   - Recursively call the function with the updated permutation and array.
3. `Backtracking Step`: After exploring all possibilities with the current element, remove it from the permutation before backtracking to the previous state.
---

### Combination Sum
> [!IMPORTANT]
> Input: arr = [1,2,3], target = 7
> Expected Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
1. `Base Cases`:
   - If the target becomes zero, it means we've found a combination that sums up to the target. Add this combination to the result list.
   - If the target becomes negative, it means the current combination exceeds the target. In this case, backtrack and try other combinations.
2. `Recursive Exploration`:
   - Iterate through the array starting from the given index.
   - For each element:
      Add the current element to the current combination.
      Recursively call the function with the updated target (subtracting the current element) and index.
3. `Backtracking Step`: Removing the last added element before trying other combinations.
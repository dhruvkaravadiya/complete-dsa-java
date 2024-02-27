# Two Pointers

This directory contains solutions to problems that can be solved using the 'Two Pointers' technique.

## Questions

1. Binary Search:
       - [Solution]()
       - [Approach](#binary-search)

## Approach

### Binary Search

1. Initialize 2 pointers - `low = 0`, `high = n-1`
2. Repeat until `low <= high`:
       - Calculate the `mid`, and if `arr[mid] == target`, return `i`
       - If `arr[mid] < target`, move the `low` pointer to `mid + 1`
       - If `arr[mid] > target`, move the `high` pointer to `mid - 1`
3. Return the index

### Binary Search In 2D Array

- Brute Force Approach `O(n^2)`:
      Simply search in each element until you find the element.

- `O(n) + O(log m)` approach for `n*m` matrix:
      - Iterate through every row and apply binary search on that row only where the target resides, i.e. `arr[i][0] <= target && target <= arr[i][cols - 1]`

- Optimized Approach `O(n)`, `n = rows`:
      Converting matrix to a linear array (Hypothetically):
      1. Initialize `low = 0` and `high = (rows * cols) - 1`
      2. Repeat until `low <= high`:
             - Calculate the `mid = low + (high-low)/2`
                   - `r = mid / cols`, `c = mid % cols`
             - If `arr[r][c] == target`, return the indexes
             - If `arr[r][c] < target`, `low = mid + 1`
             - If `arr[r][c] > target`, `high = mid - 1`

      We know that elements within rows are sorted, and also rows are sorted. Here we are basically iterating through hypothetical indexes in a linear array. For example, `[[1,2,3],[4,5,6],[7,8,9]]`, then 4 is at `[1][0]` index, i.e. 3rd index linearly, so we make use of that. Also, to find the `[r][c]` index based on `[]` index:
      - `r = mid / cols`, `c = mid % cols`
      - Example: `mid = 5` (at index `(1,1)`, i.e. 4th index in 1D)
            - Now, `r = 4 / 3 = 1`, `c = 4 % 3`
      - Similarly, if `mid` is at `(2,1)` (i.e. `arr[mid] = 8`, `mid = 7`)
            - `r = 7 / 3 = 2`, `c = 7 % 3 = 1`

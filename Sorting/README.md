# Sorting

This directory contains solutions to problems that can be solved using the `Binary Search` technique.

## Questions

1. Bubble Sort: - [Solution]() - [Approach](#bubble-sort)
---

## Approach

### Bubble Sort
> [!TIP]
> For every outer loop iteration , the largest element will be pushed at the back
> and the loop will be shrinking from the right side for inner loop w.r.t outer loop
1. iterate from i = 0 -> arr.length
2. then iterate from j = 0 -> arr.length - i - 1
3. compare the 2 consecutive elements and swap of ith element > (i+1)th element

--- 

### Selection Sort
> [!TIP] 
> The algorithm then selects the smallest element from the unsorted part and
> swaps it with the leftmost element of the unsorted part.
> This process continues until the entire array is sorted.
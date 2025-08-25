# Sorting

This directory contains solutions to problems that can be solved using different **Sorting Algorithms**.

## Questions

1. Bubble Sort: - [Solution]() - [Approach](#bubble-sort)
2. Optimized Bubble Sort: - [Solution]() - [Approach](#optimized-bubble-sort)

---

## Approach

### Bubble Sort
Select 2 elements, swap if the first one is larger.  
Keep doing this until you reach the end.  
Start again from index `i+1` and repeat.  

Thus, 2 nested loops → **O(N²)**  

> [!TIP]
> For every outer loop iteration, the largest element will be pushed to the back.  
> The inner loop shrinks from the right side as elements at the end get sorted.  

**Steps:**
1. Iterate from `i = 0 → arr.length`
2. For each `i`, iterate from `j = 0 → arr.length - i - 1`
3. Compare two consecutive elements and swap if `arr[j] > arr[j+1]`

**Computation of Comparisons (Worst Case Example)**  
- For 10 elements:  
  - 1st pass → 9 comparisons  
  - 2nd pass → 8 comparisons  
  - … until last pass → 1 comparison  
- Total comparisons = (n-1) + (n-2) + ... + 1 = **n(n-1)/2** ≈ O(N²)

**Time Complexity**
- Best: O(N) (NOT POSSIBLE IN BRUTE FORCE BUBBLE SORT)  
- Average: O(N²)  
- Worst: O(N²)  

**Space Complexity**  
- O(1) (only temp variable)



---

### Optimized Bubble Sort
In normal bubble sort, comparisons are made even if the array is already sorted.  
This means **N·N comparisons even when sorted**, while ideally it should only take **N**.

To fix this, we introduce a **flag `swapped`**:
- Initialize `swapped = false`
- If any elements are swapped in the inner loop → set `swapped = true`
- If no swaps occur → the array is already sorted → **break the outer loop**

This saves unnecessary iterations.

**Steps:**
1. Iterate `i = 0 → arr.length`
2. Set `swapped = false`
3. Inner loop: `j = 0 → arr.length - i - 1`
   - Compare `arr[j]` and `arr[j+1]`
   - Swap if needed, set `swapped = true`
4. If after inner loop, `swapped == false` → break (array is sorted)

**Time Complexity**
- Best: O(N) (only one pass if already sorted)  
- Average: O(N²)  
- Worst: O(N²)  

**Space Complexity**  
- O(2): one temp variable + one boolean flag

---

### Selection Sort
> [!TIP] 
> The algorithm selects the smallest element from the unsorted part  
> and swaps it with the leftmost element of the unsorted part.  
> This continues until the entire array is sorted.

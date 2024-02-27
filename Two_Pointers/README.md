# Two Pointers

This directory contains solutions to problems that can be solved using the 'Two Pointers' technique.

## Questions

1. Two Sum: - [Solution](question1_solution.md) - [Approach](#two-sum)
2. Three Sum: - [Solution]() - [Approach](#three-sum) 

## Approach

### Two Sum

1. Place the start pointer at the 0th index and the end pointer at the (n-1)th index.
2. Calculate the sum of the elements at the positions of the pointers.
3. If the sum is less than the target sum, move the start pointer one index to the right.
4. If the sum is greater than the target sum, move the end pointer one index to the left.
5. If the sum is equal to the target sum, record the indexes of the start and end pointers and break the loop.

### Three Sum

1. First, sort the array using any sorting algorithm.
2. Declare an empty list to store the indexes.
3. Run a for loop until the (n-2)th element.
   - Skip the current element if it is equal to the next element.
   - If the next element is different from the current element, set the start pointer to the next element.
   - Set the end pointer to the last element.
   - Run a while loop until the start pointer is less than the end pointer.
   - Calculate the sum of the elements at the start, end, and current positions.
   - If the sum is equal to the target sum, add the indexes to the list.
   - If the sum is less than the target sum, move the start pointer to the right.
   - If the sum is greater than the target sum, move the end pointer to the left.
   - Skip duplicate elements by moving the start pointer until it's different from the previous element.
4. Return the list of indexes containing the triplets that sum up to the target sum.
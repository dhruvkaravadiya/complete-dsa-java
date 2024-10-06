# Arrays

This directory contains solutions to problems that can be solved using the `Array` Data Structure.

## Questions
1. [Array Element Occurs More Than N/3](#array-element-occurs-more-than-n3)
2. [Reverse an Array](#reverse-an-array)
3. [Array Partition]()
4. [Count Triplets]()

## Approach

### Array Element Occurs More Than N/3
1. Push all array elements to the hashmap
2. From the entrySet , push elements to a new list for which element.value > n/3
3. Return the list

---

### Reverse an Array
Using **Two Pointer** , left= 0, right= n-1
swap the left and right , until left < right

---

### Count Triplets
Fix the first number , then look for a number greater than that number,
if true then count++
if false then add count to ans for that first number
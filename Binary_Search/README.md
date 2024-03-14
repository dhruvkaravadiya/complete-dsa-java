# Binary Search

This directory contains solutions to problems that can be solved using the `Binary Search` technique.

## Questions

1. Binary Search: - [Solution]() - [Approach](#binary-search)
2. Binary Search in 2D Array - [Solution]() - [Approach](#binary-search-in-2d-array)
3. Upper Bound - [Solution]() - [Approach](#upper-bound)
4. Lower Bound - [Solution]() - [Approach](#lower-bound)
5. Square Of Sorted Array - [Solution]() - [Approach](#square-of-sorted-array)
6. Koko Eating Bananas - [Solution]() - [Approach](#koko-eating-bananas)
7. Capacity to Ship Packages Within Days - [Solution]() - [Approach](#capacity-to-ship-packages-within-days)
8. Arranging Coins - [Solution]() - [Approach](#arranging-coins)
9. First Missing Positive - [Solution]() - [Approach](#first-missing-positive)
10. Guess Number Higher Or Lower - [Solution]() - [Approach](#guess-number-higher-or-lower)
11. Find Minimum in A Rotated Sorted Array - [Solution]() - [Approach](#find-minimum-in-a-rotated-sorted-array)
12. Search In A Rotated Sorted Array - [Solution]() - [Approach](#search-in-a-rotated-sorted-array)
13. Successful Pairs of Potions and Spells - [Solution]() - [Approach](#successful-pairs-of-potions-and-spells)
---

## Approach

### Binary Search
1. Initialize 2 pointers - at low = 0 , high = n-1
2. repeat until low <= high , 
      i. calculate the mid , and if arr[mid] == target, return i
     ii. if arr[mid] < target, move the low pointer to mid + 1
    iii. if arr[mid] > target, move end high pointer to mid - 1
3. Return the index

--- 

### Binary Search In 2D Array
- Brute Force Approach `0(n^2)`: 
      Simply Search In each element till you find the element

- `[O(n) + O(log m)]` approach for n*m matrix
=> Iterate through every row and apply binary search on that 
   row only where target resides , 
   i.e. arr[i][0] <= target && target <= arr[i][cols - 1]

- Optimized Approach `O(n)`, n = rows: 
Converting matrix to linear array (Hypothetically)
1. Initialize the low = 0 and high = (rows * cols) - 1
2. repeat until low <= high
      i. calculate the mid = low + (high-low)/2
         r = mid /cols, c = mid % cols
     ii. if arr[r][c] == target, return the indexes
    iii. if arr[r][c] < target, low = mid + 1 
     iv. if arr[r][c] > target, high = mid - 1 

=> we know that elements within rows are sorted, and also rows are sorted
Here we are basically iterating through hypothetical indexes in a linear array
Example, [[1,2,3],[4,5,6],[7,8,9]], then 4 is at [1][0] index, i.e. 3 index linearly, so we make use of that
Also to find the [r][c] index based on [] index
r = mid / cols , c = mid % cols
Ex : mid = 5: at index (1,1), i.e. 4th index in 1d 
      now, r = 4 / 3 = 1 ,c = 4 % 3
      similarly if mid is at (2,1), i.e. arr[mid] = 8 ,mid = 7 
            r =  7 / 3 = 2 (int) , c = 7 % 3 = 1 

---

### Lower Bound 
> [!NOTE]
> Return the least index of the element
> Example : [1,2,3,3,4,5,6,7] , element = k , then lower bound = index = 2
1. Initialize the left and the right element at `0`, and `n-1` respectively, and index = `-1`(not found case);
2. Now if target is found then update the `index = mid` and take the right pointer to the `right = mid-1`, thus taking the right to mid - 1 will break the next loop ,
EX: ARR = {1,2,2}, mid = 1, left, 0, right =2 , then at mid element 2 is found , so we take right pointer to mid - 1 , i.e. at 0 , index, now next loop will breaK
3. else if `target < mid element` , then we delete the right half array and basically take the right element to mid - 1
4. else last case `target > mid element`, delete the first half and take the left  to mid + 1 

---

### Upper Bound
> [!NOTE]
> Return the max index of the element
> Example : [1,2,3,3,4,5,6,7] , element = k , then upper bound = index = 3
1. Initialize the left and the right element at `0`, and `n-1` respectively, and index = `-1`(not found case);
2. Now if target is found then update the `index = mid` and take the right pointer to the `left = mid + 1`, thus taking the left to mid + 1 will break the next loop ,
3. else if `target < mid element` , then we delete the right half array and basically take the right element to mid - 1
4. else last case `target > mid element`, delete the first half and take the left  to mid + 1

---

### Square of Sorted Array
1. Take 2 elements , one at `left` and one at the `right` element of the sorted array, declare `result array` of same size as given sorted array, and then also `index` variable pointer to the last index of the array, as we will add the largest element from the last
2. Square them and compare them
   - If `leftSquaredValue > rightSquaredValue`, then add the leftSquaredValue from the last of te result array and also increment the left pointer
   - if `leftSquaredValue < rightSquaredValue`, then assign the rightSquaredValue from the current last unassigned index of the result array and also decrement the right pointer
3. Decrement the index
4. Repeat until left<=right

---

### Koko Eating Bananas
> [!NOTE]
> In Simple words we have to return the min eating speed of bananas/hours koko must have to eat all the bananas before exceeding the given time limit
1. We are given array of piles of bananes, each pile having x amount of bananas, and the min time limit in hours
2. Now we initialize 2 variables, `left = 1`, which is the least amount of bananas, and then then max of elements of the piles, `right = max(Array[element])`, as the two pointers.
3. repeat while left <= right
   - if koko can eat bananas with given speed == mid, within given hours for all bananas of   piles array, then we delete the right sub array by moving the right to mid
   - if koko cant eat , then means , take the left pointer to mid + 1, cause we delete the array upto mid from left.

>[!IMPORTANT] 
>But how do we determine whether koko can eat bananas within that time frame or not with speed == mid or not? Follow the below instruction to make that helper function to be used in the if condition to check whether koko can eat or not
> we can calculate the current hours that will be taken for the speed == mid by taking the sum of each piles's bananas' number and the current speed -1 and then dividing the whole by the speed . like piles = [7,8,1,3] , then for  7 , first mid speed = 4 , and then not to eat first pile, it will take 2 hours , for pile = 8 , 2 hours,and 1 ,and 1 for 1 and 3 , so total 2+2+1+1 = 6 , and its lesser than 8 (given hours limit) , so this function will  return true, by comparing if found sum <= given time limit in hours

---

### Capacity To Ship Packages Within Days
> [!NOTE]
> We are given the number of i
---

### Arranging Coins

---

### First Missing Positive

---

### Guess Number Higher Or Lower

---

### Find Minimum in A Rotated Sorted Array
1. If current array is sorted, i.e. `arr[low] <= arr[high]`, simply return the first element arr[low]
2. If low to mid is sorted, i.e. `arr[mid] <= arr[high]`,update the min and the low pointer to mid+1.
3. else if mid to high is sorted, update the min and the high pointer to mid - 1.
---

### Search In A Rotated Sorted Array
> [!TIP] 
> Intuition is to check if one of the half arrays are sorted or not, if sorted, then search for the element in that half array.
1. If found at mid return mid
2. if `arr[low] < arr[mid]`,meaning left half array is sorted, look for the target in this `low-mid` range
3. else `arr[mid] < arr[high]`,meaning right half array is sorted, look for the target in this `mid-high` range
---

### Successful Pairs of Potions and Spells
1. For each of the spells multiplied by potions, its value should be greater equal target, then its a successfull pair. 
2. Count the number of pairs of a spell i with potions j, for each of the spell i.
3. And return those value as array, thus answer array would be of same size as the spells array.

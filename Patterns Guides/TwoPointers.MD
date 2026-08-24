# 🔥 Two Pointers

Two Pointers is one of the most important DSA patterns for technical interviews.

Instead of checking every possible pair/subarray in `O(n²)`, we use two indices to intelligently reduce the search space, often achieving `O(n)` or `O(n log n)`.

---

## 📌 Patterns Covered

* [ ] Opposite Ends
* [ ] Fast & Slow Pointers
* [ ] Same Direction / In-Place
* [ ] Two Arrays / Merging
* [ ] String Two Pointers
* [ ] Sliding Window
* [ ] Partitioning
* [ ] Advanced Two Pointers

> **Goal:** Don't solve every Two Pointer problem on LeetCode.
> Master the patterns through a carefully selected set of problems.

---

# 1️⃣ Opposite Ends — Left & Right

### Pattern

```java
int left = 0;
int right = nums.length - 1;

while (left < right) {

    // process nums[left] and nums[right]

    if (...) {
        left++;
    } else {
        right--;
    }
}
```

### Problems

* [Done] ⭐ [Two Sum II — Input Array Is Sorted](https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/)
* [Done] ⭐ [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
* [Done] ⭐ [Reverse String](https://leetcode.com/problems/reverse-string/)
* [Done] ⭐ [Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
* [ ] ⭐ [3Sum](https://leetcode.com/problems/3sum/)
* [ ] [4Sum](https://leetcode.com/problems/4sum/)
* [ ] [Boats to Save People](https://leetcode.com/problems/boats-to-save-people/)
* [done] [Squares of a Sorted Array](https://leetcode.com/problems/squares-of-a-sorted-array/)
* [done] [Valid Palindrome II](https://leetcode.com/problems/valid-palindrome-ii/)

### 🎯 Pattern to Remember

> **Sorted array + pair/triplet → think Two Pointers.**

---

# 2️⃣ Fast & Slow Pointers

Usually used with **Linked Lists**.

### Pattern

```java
ListNode slow = head;
ListNode fast = head;

while (fast != null && fast.next != null) {
    slow = slow.next;
    fast = fast.next.next;
}
```

### Problems

* [Done] ⭐ [Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
* [Done] ⭐ [Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
* [Done] ⭐ [Linked List Cycle II](https://leetcode.com/problems/linked-list-cycle-ii/)
* [Done] ⭐ [Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)
* [ ] ⭐ [Reorder List](https://leetcode.com/problems/reorder-list/)
* [Done] [Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)
* [Done] [Rotate List](https://leetcode.com/problems/rotate-list/)

### 🎯 Pattern to Remember

> **Linked List + middle/cycle/end → think Fast & Slow.**

---

# 3️⃣ Same Direction — Slow & Fast

Both pointers move forward.

The **fast pointer searches**, while the **slow pointer builds the result**.

### Pattern

```java
int slow = 0;

for (int fast = 0; fast < nums.length; fast++) {

    if (condition) {
        nums[slow] = nums[fast];
        slow++;
    }
}
```

### Problems

* [Done] ⭐ [Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
* [Done] ⭐ [Remove Element](https://leetcode.com/problems/remove-element/)
* [Done] ⭐ [Move Zeroes](https://leetcode.com/problems/move-zeroes/)
* [ ] ⭐ [Sort Colors](https://leetcode.com/problems/sort-colors/)
* [ ] [Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
* [ ] [Duplicate Zeros](https://leetcode.com/problems/duplicate-zeros/)
* [ ] [Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)
* [ ] [Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/)

### 🎯 Pattern to Remember

> **In-place modification → slow writes, fast scans.**

---

# 4️⃣ Two Arrays / Merging

Use one pointer for each array.

### Pattern

```java
int i = 0;
int j = 0;

while (i < nums1.length && j < nums2.length) {

    if (nums1[i] < nums2[j]) {
        i++;
    } else {
        j++;
    }
}
```

### Problems

* [ ] ⭐ [Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
* [ ] ⭐ [Intersection of Two Arrays II](https://leetcode.com/problems/intersection-of-two-arrays-ii/)
* [ ] ⭐ [Is Subsequence](https://leetcode.com/problems/is-subsequence/)
* [ ] ⭐ [Intersection of Two Linked Lists](https://leetcode.com/problems/intersection-of-two-linked-lists/)
* [ ] [Heaters](https://leetcode.com/problems/heaters/)
* [ ] [Find the Distance Value Between Two Arrays](https://leetcode.com/problems/find-the-distance-value-between-two-arrays/)
* [ ] [Longest Word in Dictionary Through Deleting](https://leetcode.com/problems/longest-word-in-dictionary-through-deleting/)
* [ ] [Long Pressed Name](https://leetcode.com/problems/long-pressed-name/)

### 🎯 Pattern to Remember

> **Two sorted sequences → one pointer for each sequence.**

---

# 5️⃣ String Two Pointers

Two pointers can process strings from opposite directions or compare two strings.

### Problems

* [ ] ⭐ [Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
* [ ] ⭐ [Is Subsequence](https://leetcode.com/problems/is-subsequence/)
* [ ] ⭐ [Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)
* [ ] ⭐ [String Compression](https://leetcode.com/problems/string-compression/)
* [ ] [Reverse Only Letters](https://leetcode.com/problems/reverse-only-letters/)
* [ ] [Long Pressed Name](https://leetcode.com/problems/long-pressed-name/)
* [ ] [Reverse Words in a String III](https://leetcode.com/problems/reverse-words-in-a-string-iii/)

### 🎯 Pattern to Remember

Ask:

> **Can I solve this by scanning the string instead of repeatedly creating substrings?**

---

# 6️⃣ Sliding Window

Sliding Window is essentially a **specialized Two Pointer technique**.

### Pattern

```java
int left = 0;

for (int right = 0; right < nums.length; right++) {

    // add nums[right]

    while (windowIsInvalid) {
        // remove nums[left]
        left++;
    }

    // update answer
}
```

### Problems

* [ ] ⭐ [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
* [ ] ⭐ [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
* [ ] ⭐ [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)
* [ ] ⭐ [Longest Repeating Character Replacement](https://leetcode.com/problems/longest-repeating-character-replacement/)
* [ ] [Count Binary Substrings](https://leetcode.com/problems/count-binary-substrings/)
* [ ] [K-diff Pairs in an Array](https://leetcode.com/problems/k-diff-pairs-in-an-array/)

### 🎯 Pattern to Remember

> **Longest/shortest subarray or substring satisfying a condition → think Sliding Window.**

---

# 7️⃣ Partitioning

Pointers divide the array into different regions.

### Problems

* [ ] ⭐ [Sort Colors](https://leetcode.com/problems/sort-colors/)
* [ ] ⭐ [Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)
* [ ] [Sort Array By Parity II](https://leetcode.com/problems/sort-array-by-parity-ii/)
* [ ] ⭐ [Partition List](https://leetcode.com/problems/partition-list/)

### 🎯 Pattern to Remember

Think in terms of regions:

```text
[ processed | unknown | processed ]
```

Move elements from the unknown region into their correct region.

---

# 8️⃣ Advanced Two Pointers

Once the basic patterns are comfortable, move here.

### Problems

* [ ] ⭐ [Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
* [ ] ⭐ [3Sum Closest](https://leetcode.com/problems/3sum-closest/)
* [ ] ⭐ [Valid Triangle Number](https://leetcode.com/problems/valid-triangle-number/)
* [ ] ⭐ [Number of Subsequences That Satisfy the Given Sum Condition](https://leetcode.com/problems/number-of-subsequences-that-satisfy-the-given-sum-condition/)
* [ ] [Find K-th Smallest Pair Distance](https://leetcode.com/problems/find-k-th-smallest-pair-distance/)
* [ ] [Minimum Length of String After Deleting Similar Ends](https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/)

---

# 🧠 Two Pointers Recognition Guide

| Situation                        | Pattern             |
| -------------------------------- | ------------------- |
| Sorted array + target pair       | Opposite Ends       |
| Palindrome                       | Left + Right        |
| Max area between elements        | Left + Right        |
| Triplet sum                      | Sort + Two Pointers |
| Linked List middle               | Fast + Slow         |
| Linked List cycle                | Fast + Slow         |
| Remove elements in-place         | Slow + Fast         |
| Remove duplicates                | Slow + Fast         |
| Merge two sorted arrays          | Two Arrays          |
| Compare two strings              | Two Arrays          |
| Longest/shortest valid substring | Sliding Window      |
| Partition array                  | Multiple pointers   |

---

# 🏆 Must-Solve Set

If you are short on time, **these are the ones I would absolutely not skip**:

### ⭐ Core 20

* [ ] Two Sum II
* [ ] 3Sum
* [ ] Container With Most Water
* [ ] Trapping Rain Water
* [ ] Valid Palindrome
* [ ] Reverse String
* [ ] Middle of the Linked List
* [ ] Linked List Cycle
* [ ] Linked List Cycle II
* [ ] Remove Nth Node From End
* [ ] Reorder List
* [ ] Remove Duplicates from Sorted Array
* [ ] Remove Element
* [ ] Move Zeroes
* [ ] Sort Colors
* [ ] Merge Sorted Array
* [ ] Is Subsequence
* [ ] Intersection of Two Arrays II
* [ ] Longest Substring Without Repeating Characters
* [ ] Longest Repeating Character Replacement

---

# 🚀 Recommended Progression

```text
Basic Opposite Ends
        ↓
Fast & Slow
        ↓
Same Direction
        ↓
Two Arrays
        ↓
Strings
        ↓
Sliding Window
        ↓
Partitioning
        ↓
Advanced
```

### Rule

> **Don't move to the next pattern just because you solved the problems.**
>
> Move when you can look at a new problem and explain **why** a particular Two Pointer pattern should work.

---

## 📊 Progress

**Total Target: ~40 Problems**

```text
Solved: 0 / 40
```

### Patterns

* [ ] Opposite Ends
* [ ] Fast & Slow
* [ ] Same Direction
* [ ] Two Arrays
* [ ] String Two Pointers
* [ ] Sliding Window
* [ ] Partitioning
* [ ] Advanced

---

## 🔑 Final Takeaway

Two Pointers isn't one algorithm.

It's a **family of techniques** where we use pointer movement to avoid unnecessary work.

The most important skill is recognizing:

```text
"Can I avoid checking every pair?"

"Can I move one pointer safely?"

"Is the array sorted?"

"Can I maintain a valid window?"

"Can one pointer build the answer while another scans?"
```

If the answer is yes, **Two Pointers might be the pattern.**

# Sliding Window Patterns

> **Goal:** *Master Sliding Window by recognizing the underlying pattern rather than memorizing individual solutions.*

> **Legend:** *✅ Completed · ⬜ Not Completed*

---

## Pattern 1: Fixed-Size Window

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ✅ | Maximum Average Subarray I | <span style="color:#2da44e">Easy</span> | [LC 643](https://leetcode.com/problems/maximum-average-subarray-i/) |
| ✅ | Max Consecutive Ones III | <span style="color:#d29922">Medium</span> | [LC 1004](https://leetcode.com/problems/max-consecutive-ones-iii/) |
| ✅ | Maximum Sum of Distinct Subarrays With Length K | <span style="color:#d29922">Medium</span> | [LC 2461](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/) |
| ✅ | Contains Duplicate II | <span style="color:#2da44e">Easy</span> | [LC 219](https://leetcode.com/problems/contains-duplicate-ii/) |
| ✅ | K Radius Subarray Averages | <span style="color:#d29922">Medium</span> | [LC 2090](https://leetcode.com/problems/k-radius-subarray-averages/) |
| ✅ | Maximum Points You Can Obtain from Cards | <span style="color:#d29922">Medium</span> | [LC 1423](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) |

---

## Pattern 2: Variable-Size Window — Expand + Shrink

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ✅ | Longest Substring Without Repeating Characters | <span style="color:#d29922">Medium</span> | [LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |
| ✅ | Minimum Size Subarray Sum | <span style="color:#d29922">Medium</span> | [LC 209](https://leetcode.com/problems/minimum-size-subarray-sum/) |
| ✅ | Fruit Into Baskets | <span style="color:#d29922">Medium</span> | [LC 904](https://leetcode.com/problems/fruit-into-baskets/) |
| ✅ | Subarray Sum Equals K | <span style="color:#d29922">Medium</span> | [LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) |
| ✅ | Binary Subarrays With Sum | <span style="color:#d29922">Medium</span> | [LC 930](https://leetcode.com/problems/binary-subarrays-with-sum/) |
| ⬜ | Maximum Erasure Value | <span style="color:#d29922">Medium</span> | [LC 1695](https://leetcode.com/problems/maximum-erasure-value/) |

---

## Pattern 3: Sliding Window + Frequency Map

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ✅ | Permutation in String | <span style="color:#d29922">Medium</span> | [LC 567](https://leetcode.com/problems/permutation-in-string/) |
| ✅ | Find All Anagrams in a String | <span style="color:#d29922">Medium</span> | [LC 438](https://leetcode.com/problems/find-all-anagrams-in-a-string/) |
| ⬜ | Minimum Window Substring | <span style="color:#cf222e">Hard</span> | [LC 76](https://leetcode.com/problems/minimum-window-substring/) |
| ⬜ | Count Complete Substrings | <span style="color:#cf222e">Hard</span> | [LC 2953](https://leetcode.com/problems/count-complete-substrings/) |
| ⬜ | Longest Substring with Equal Character Frequency | <span style="color:#d29922">Medium</span> | [LC 2958](https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/) |

---

## Pattern 4: Longest / Shortest Window Under a Condition

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ⬜ | Longest Repeating Character Replacement | <span style="color:#d29922">Medium</span> | [LC 424](https://leetcode.com/problems/longest-repeating-character-replacement/) |
| ✅ | Max Consecutive Ones III | <span style="color:#d29922">Medium</span> | [LC 1004](https://leetcode.com/problems/max-consecutive-ones-iii/) |
| ⬜ | Shortest Subarray With Sum at Least K | <span style="color:#cf222e">Hard</span> | [LC 862](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) |
| ✅ | Longest Subarray of 1s After Deleting One Element | <span style="color:#d29922">Medium</span> | [LC 1493](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/) |
| ✅ | Maximum Erasure Value | <span style="color:#d29922">Medium</span> | [LC 1695](https://leetcode.com/problems/maximum-erasure-value/) |
| ⬜ | Shortest Subarray to Be Removed to Make Array Sorted | <span style="color:#d29922">Medium</span> | [LC 1574](https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/) |
| ⬜ | Minimum Window Substring | <span style="color:#cf222e">Hard</span> | [LC 76](https://leetcode.com/problems/minimum-window-substring/) |

---

## Pattern 5: Exactly K / At Most K Distinct Elements

> **Key Trick:** `Exactly K = AtMost(K) - AtMost(K - 1)`

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ⬜ | Longest Substring Without Repeating Characters | <span style="color:#d29922">Medium</span> | [LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |
| ⬜ | Longest Repeating Character Replacement | <span style="color:#d29922">Medium</span> | [LC 424](https://leetcode.com/problems/longest-repeating-character-replacement/) |
| ⬜ | Fruit Into Baskets | <span style="color:#d29922">Medium</span> | [LC 904](https://leetcode.com/problems/fruit-into-baskets/) |
| ⬜ | Count Complete Substrings | <span style="color:#cf222e">Hard</span> | [LC 2953](https://leetcode.com/problems/count-complete-substrings/) |
| ⬜ | Longest Semi-Repetitive Substring | <span style="color:#d29922">Medium</span> | [LC 2730](https://leetcode.com/problems/longest-semi-repetitive-substring/) |

---

## Pattern 6: Window With Sum / Product Constraints

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ⬜ | Subarray Product Less Than K | <span style="color:#d29922">Medium</span> | [LC 713](https://leetcode.com/problems/subarray-product-less-than-k/) |
| ⬜ | Minimum Size Subarray Sum | <span style="color:#d29922">Medium</span> | [LC 209](https://leetcode.com/problems/minimum-size-subarray-sum/) |
| ✅ | Continuous Subarray Sum | <span style="color:#d29922">Medium</span> | [LC 523](https://leetcode.com/problems/continuous-subarray-sum/) |
| ✅ | Subarray Sum Equals K | <span style="color:#d29922">Medium</span> | [LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) |
| ✅ | Maximum Points You Can Obtain from Cards | <span style="color:#d29922">Medium</span> | [LC 1423](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) |
| ⬜ | K Divisible Elements Subarrays | <span style="color:#d29922">Medium</span> | [LC 2261](https://leetcode.com/problems/k-divisible-elements-subarrays/) |
| ⬜ | Maximum Subarray Sum with One Deletion | <span style="color:#d29922">Medium</span> | [LC 1186](https://leetcode.com/problems/maximum-subarray-sum-with-one-deletion/) |

---

## Pattern 7: Sliding Window + Monotonic Queue / Deque

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ⬜ | Sliding Window Maximum | <span style="color:#cf222e">Hard</span> | [LC 239](https://leetcode.com/problems/sliding-window-maximum/) |
| ⬜ | Sum of Subarray Minimums | <span style="color:#d29922">Medium</span> | [LC 907](https://leetcode.com/problems/sum-of-subarray-minimums/) |
| ⬜ | Constrained Subsequence Sum | <span style="color:#cf222e">Hard</span> | [LC 1425](https://leetcode.com/problems/constrained-subsequence-sum/) |
| ⬜ | Shortest Subarray With Sum at Least K | <span style="color:#cf222e">Hard</span> | [LC 862](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) |
| ⬜ | Longest Continuous Subarray With Absolute Diff ≤ Limit | <span style="color:#d29922">Medium</span> | [LC 1438](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) |
| ⬜ | Daily Temperatures | <span style="color:#d29922">Medium</span> | [LC 739](https://leetcode.com/problems/daily-temperatures/) |

---

## Pattern 8: Sliding Window + Prefix Sums

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ✅ | Subarray Sum Equals K | <span style="color:#d29922">Medium</span> | [LC 560](https://leetcode.com/problems/subarray-sum-equals-k/) |
| ✅ | Continuous Subarray Sum | <span style="color:#d29922">Medium</span> | [LC 523](https://leetcode.com/problems/continuous-subarray-sum/) |
| ⬜ | Shortest Subarray With Sum at Least K | <span style="color:#cf222e">Hard</span> | [LC 862](https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/) |
| ⬜ | Minimum Operations to Reduce X to Zero | <span style="color:#d29922">Medium</span> | [LC 1658](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/) |
| ⬜ | Find Pivot Index | <span style="color:#2da44e">Easy</span> | [LC 724](https://leetcode.com/problems/find-pivot-index/) |
| ✅ | Maximum Points You Can Obtain from Cards | <span style="color:#d29922">Medium</span> | [LC 1423](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) |

---

## Pattern 9: Sliding Window + Two Pointers

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ⬜ | Longest Continuous Subarray With Absolute Diff ≤ Limit | <span style="color:#d29922">Medium</span> | [LC 1438](https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/) |
| ⬜ | Minimum Window Substring | <span style="color:#cf222e">Hard</span> | [LC 76](https://leetcode.com/problems/minimum-window-substring/) |
| ⬜ | Maximum Number of Vowels in a Substring of Given Length | <span style="color:#d29922">Medium</span> | [LC 1456](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/) |
| ⬜ | Longest Subarray of 1s After Deleting One Element | <span style="color:#d29922">Medium</span> | [LC 1493](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/) |
| ⬜ | Minimum Operations to Reduce X to Zero | <span style="color:#d29922">Medium</span> | [LC 1658](https://leetcode.com/problems/minimum-operations-to-reduce-x-to-zero/) |
| ⬜ | Longest Nice Subarray | <span style="color:#d29922">Medium</span> | [LC 2401](https://leetcode.com/problems/longest-nice-subarray/) |

---

## Pattern 10: Dual Windows / Multiple Window Tracking

| Status | Problem | Difficulty | LeetCode |
|---|---|---|---|
| ⬜ | Substring With Concatenation of All Words | <span style="color:#cf222e">Hard</span> | [LC 30](https://leetcode.com/problems/substring-with-concatenation-of-all-words/) |
| ⬜ | Number of Subarrays Containing All Three Numbers | <span style="color:#d29922">Medium</span> | [LC 1358](https://leetcode.com/problems/number-of-subarrays-containing-all-three-numbers/) |
| ⬜ | Longest Nice Subarray | <span style="color:#d29922">Medium</span> | [LC 2401](https://leetcode.com/problems/longest-nice-subarray/) |
| ⬜ | Substring With Largest Variance | <span style="color:#cf222e">Hard</span> | [LC 2272](https://leetcode.com/problems/substring-with-largest-variance/) |
| ⬜ | Longest Substring Without Repeating Characters | <span style="color:#d29922">Medium</span> | [LC 3](https://leetcode.com/problems/longest-substring-without-repeating-characters/) |
| ⬜ | Count Complete Substrings | <span style="color:#cf222e">Hard</span> | [LC 2953](https://leetcode.com/problems/count-complete-substrings/) |
| ⬜ | Longest Semi-Repetitive Substring | <span style="color:#d29922">Medium</span> | [LC 2730](https://leetcode.com/problems/longest-semi-repetitive-substring/) |

---

# 📊 Progress Summary

| Metric | Progress |
|---|---:|
| Pattern Categories | **10** |
| Completed Problems | **13** |
| Remaining | **~35** |
| Progress | **~27%** |

### Difficulty Legend

- <span style="color:#2da44e">**Easy**</span>
- <span style="color:#d29922">**Medium**</span>
- <span style="color:#cf222e">**Hard**</span>

---

# ✅ Already Completed

1. ✅ [Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/) — LC 643
2. ✅ [Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/) — LC 1004
3. ✅ [Maximum Sum of Distinct Subarrays With Length K](https://leetcode.com/problems/maximum-sum-of-distinct-subarrays-with-length-k/) — LC 2461
4. ✅ [Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/) — LC 219
5. ✅ [K Radius Subarray Averages](https://leetcode.com/problems/k-radius-subarray-averages/) — LC 2090
6. ✅ [Maximum Points You Can Obtain from Cards](https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/) — LC 1423
7. ✅ [Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/) — LC 3
8. ✅ [Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/) — LC 209
9. ✅ [Subarray Sum Equals K](https://leetcode.com/problems/subarray-sum-equals-k/) — LC 560
10. ✅ [Binary Subarrays With Sum](https://leetcode.com/problems/binary-subarrays-with-sum/) — LC 930
11. ✅ [Permutation in String](https://leetcode.com/problems/permutation-in-string/) — LC 567
12. ✅ [Find All Anagrams in a String](https://leetcode.com/problems/find-all-anagrams-in-a-string/) — LC 438
13. ✅ [Continuous Subarray Sum](https://leetcode.com/problems/continuous-subarray-sum/) — LC 523

---

# 🎯 Recommended Learning Order

```text
1. Fixed-Size Window

        ↓

2. Variable-Size Window

        ↓

3. Frequency Map

        ↓

4. At Most K / Exactly K

        ↓

5. Sum / Product Constraints

        ↓

6. Two Pointers + Sliding Window

        ↓

7. Prefix Sum + Window

        ↓

8. Monotonic Deque

        ↓

9. Dual Windows

        ↓

10. Hard Mixed Problems
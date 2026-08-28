# Master Guide: Data Structures & Algorithms Lab Assignments

This repository contains complete, interactive Java implementations for all **3 Lab Assignments** assigned by **Dr. Manoj Kumar**, along with deep-dive conceptual explanations, concrete worked examples, code execution instructions, complexity analyses, algorithm blueprints, and viva questions.

---

## 📑 Table of Contents
1. [Project Overview & File Mapping](#-project-overview--file-mapping)
2. [How to Compile and Execute](#-how-to-compile-and-execute)
3. [Assignment 1: Random Weighted Undirected Graph Generator](#-assignment-1-random-weighted-undirected-graph-generator)
   - [1. Concept & Problem Breakdown](#1-concept--problem-breakdown)
   - [2. How We Solve It (Theory & Math)](#2-how-we-solve-it-theory--math)
   - [3. Concrete Example Walkthrough](#3-concrete-example-walkthrough)
   - [4. Data Structures Used](#4-data-structures-used)
   - [5. How the Code Works Under the Hood](#5-how-the-code-works-under-the-hood)
   - [6. How to Run & Use the Code](#6-how-to-run--use-the-code)
   - [7. Time & Space Complexity](#7-time--space-complexity)
4. [Assignment 2: Sparse Matrix Operations](#-assignment-2-sparse-matrix-operations)
   - [1. Concept: Why Sparse Matrix?](#1-concept-why-sparse-matrix)
   - [2. Data Structure: 3-Tuple (Triplet) Representation](#2-data-structure-3-tuple-triplet-representation)
   - [3. How We Solve Each Operation (Transpose, Addition, Multiplication)](#3-how-we-solve-each-operation-transpose-addition-multiplication)
   - [4. Concrete Example Walkthrough](#4-concrete-example-walkthrough)
   - [5. How the Code Works Under the Hood](#5-how-the-code-works-under-the-hood)
   - [6. How to Run & Use the Code](#6-how-to-run--use-the-code)
   - [7. Time & Space Complexity](#7-time--space-complexity)
5. [Assignment 3: Dynamic Programming (0/1 Knapsack & LCS)](#-assignment-3-dynamic-programming-01-knapsack--lcs)
   - [1. Dynamic Programming Fundamentals](#1-dynamic-programming-fundamentals)
   - [2. Part A: 0/1 Knapsack Problem (Concept, DP Recurrence, Concrete Example, Code Walkthrough)](#2-part-a-01-knapsack-problem)
   - [3. Part B: Longest Common Subsequence (LCS) (Concept, DP Recurrence, Concrete Example, Code Walkthrough)](#3-part-b-longest-common-subsequence-lcs)
   - [4. How to Run & Use the Code](#4-how-to-run--use-the-code)
   - [5. Time & Space Complexity](#5-time--space-complexity)
6. [Curated Code Walkthrough Video Recommendations](#-curated-code-walkthrough-video-recommendations)
7. [Comprehensive Viva-Voce & Professor Q&A](#-comprehensive-viva-voce--professor-qa)

---

## 📁 Project Overview & File Mapping

| Assignment | File Path | Description |
| :--- | :--- | :--- |
| **Assignment 1** | [`Assignment1_RandomGraph.java`](file:///d:/Placement%20Preparation/complete-dsa-java/Assignments/Assignment1_RandomGraph.java) | Random weighted graph generator; density $d$; weights $[1..n]$; dual storage in **Adjacency Matrix** & **Adjacency List**. |
| **Assignment 2** | [`Assignment2_SparseMatrix.java`](file:///d:/Placement%20Preparation/complete-dsa-java/Assignments/Assignment2_SparseMatrix.java) | Memory-efficient Triplet representation; **dynamic user input**; **Fast Transpose** ($O(\text{cols} + \text{terms})$); addition; multiplication; full 2D grid rendering. |
| **Assignment 3** | [`Assignment3_KnapsackAndLCS.java`](file:///d:/Placement%20Preparation/complete-dsa-java/Assignments/Assignment3_KnapsackAndLCS.java) | Bottom-Up Tabulation DP; **0/1 Knapsack** with item selection traceback; **LCS** with DP table printing & string reconstruction. |

---

## 🚀 How to Compile and Execute

Open your terminal in the workspace root (`d:\Placement Preparation\complete-dsa-java`):

```bash
# 1. Compile all assignment files
javac Assignments/*.java

# 2. Run Assignment 1 (Random Graph Generator)
java Assignments.Assignment1_RandomGraph

# 3. Run Assignment 2 (Sparse Matrix Operations)
java Assignments.Assignment2_SparseMatrix

# 4. Run Assignment 3 (0/1 Knapsack & LCS Dynamic Programming)
java Assignments.Assignment3_KnapsackAndLCS
```

---

# 🔹 Assignment 1: Random Weighted Undirected Graph Generator

### 1. Concept & Problem Breakdown
An **undirected graph** $G = (V, E)$ consists of a set of vertices $V$ and edges $E$. Each edge bidirectionally connects two distinct vertices with a numerical weight $w$.

#### Sir's Problem Requirements:
1. **$n$ Vertices:** Labeled $0, 1, 2, \dots, n-1$.
2. **Density Factor $d$:** A decimal value where $0 < d < 1.0$ (e.g., $d = 0.4$ means 40% of all possible edges are present).
3. **Total Edges to Generate:** Exactly $E = \text{round}\left(d \times \frac{n(n-1)}{2}\right)$.
4. **Random Edge Weights:** Every generated edge gets a random weight $w \in [1, n]$ (inclusive).
5. **Storage Formats:** Must store and print both as an **Adjacency Matrix** and an **Adjacency List**.

---

### 2. How We Solve It (Theory & Math)

1. **Calculate Maximum Possible Edges:**
   In a simple undirected graph without self-loops or multi-edges:
   $$\text{Max Edges} = \binom{n}{2} = \frac{n(n-1)}{2}$$
2. **Calculate Target Edges ($E$):**
   $$E = \text{round}\left(d \times \frac{n(n-1)}{2}\right)$$
3. **Generate Uniform Random Edges Without Duplicates:**
   - Pre-generate all $\frac{n(n-1)}{2}$ unique pairs $(u, v)$ with $u < v$.
   - Shuffle this list of pairs using Fisher-Yates shuffle (`Collections.shuffle`).
   - Pick the first $E$ pairs. This guarantees zero duplicates, zero self-loops, and true randomness without infinite retry loops.
4. **Assign Weights:**
   For each selected edge $(u, v)$, generate $w = \text{random.nextInt}(n) + 1$.
5. **Populate Storage:**
   - Since the graph is undirected, $(u, v)$ means setting both `adjMatrix[u][v] = w` and `adjMatrix[v][u] = w`.
   - In the Adjacency List, append $(v, w)$ to $u$'s list, and $(u, w)$ to $v$'s list.

---

### 3. Concrete Example Walkthrough

#### Input Values:
- Vertices: $n = 4$ (Vertices are `0, 1, 2, 3`)
- Density: $d = 0.5$ (50% density)

#### Manual Calculation:
- $\text{Max Edges} = \frac{4 \times 3}{2} = 6 \text{ pairs: } \{(0,1), (0,2), (0,3), (1,2), (1,3), (2,3)\}$
- $E = 0.5 \times 6 = \mathbf{3 \text{ edges}}$
- Weight range: $[1..4]$

#### Suppose Random Selection Picks:
- Edge `(0, 2)` with weight **4**
- Edge `(0, 3)` with weight **2**
- Edge `(1, 2)` with weight **3**

#### 1. Adjacency Matrix ($4 \times 4$ 2D Array):
```
          V0   V1   V2   V3
   V0 |    0    0    4    2     <-- V0 connects to V2 (wt 4) and V3 (wt 2)
   V1 |    0    0    3    0     <-- V1 connects to V2 (wt 3)
   V2 |    4    3    0    0     <-- V2 connects to V0 (wt 4) and V1 (wt 3)
   V3 |    2    0    0    0     <-- V3 connects to V0 (wt 2)
```

#### 2. Adjacency List:
```
Vertex 0 -> (2, weight=4) -> (3, weight=2)
Vertex 1 -> (2, weight=3)
Vertex 2 -> (0, weight=4) -> (1, weight=3)
Vertex 3 -> (0, weight=2)
```

---

### 4. Data Structures Used

```java
// 1. Neighbor node representation in Adjacency List
public static class EdgeNode {
    int neighbor;
    int weight;
}

// 2. Adjacency Matrix: 2D integer array (O(1) edge lookup, O(n^2) space)
int[][] adjMatrix = new int[n][n];

// 3. Adjacency List: Dynamic list of neighbor lists (O(n + E) space)
List<List<EdgeNode>> adjList = new ArrayList<>(n);
```

---

### 5. How the Code Works Under the Hood

- `Assignment1_RandomGraph(n, d)`: Constructor validates inputs ($n > 1, 0 < d < 1.0$) and calculates $E$.
- `generateRandomGraph()`: Creates all pairs $(u, v)$ where $u < v$, calls `Collections.shuffle()`, slices $E$ pairs, and populates both data structures symmetrically.
- `printAdjacencyMatrix()`: Prints a formatted grid with row and column headers.
- `printAdjacencyList()`: Iterates through each vertex $0 \dots n-1$ and prints its linked neighbors.

---

### 6. How to Run & Use the Code

```bash
java Assignments.Assignment1_RandomGraph
```
**Interactive Prompt:**
```text
Enter number of vertices (n > 1): 4
Enter density factor d (0 < d < 1.0, e.g. 0.4): 0.5
```
The program will display the calculated edges, the selected random pairs with weights, the full Adjacency Matrix, and the linked Adjacency List.

---

### 7. Time & Space Complexity

| Operation | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **All-pairs generation** | $O(n^2)$ | $O(n^2)$ |
| **Shuffle & Sampling** | $O(E)$ | $O(E)$ |
| **Adjacency Matrix Storage** | $O(1)$ query | $O(n^2)$ space |
| **Adjacency List Storage** | $O(\text{deg}(u))$ query | $O(n + E)$ space |
| **Overall Execution** | $\mathbf{O(n^2)}$ | $\mathbf{O(n^2)}$ |

---

# 🔹 Assignment 2: Sparse Matrix Operations

### 1. Concept: Why Sparse Matrix?
A matrix is called **sparse** when the majority of its elements are zero ($0$).
- If a matrix is $1000 \times 1000$ and contains only $50$ non-zero elements, storing it as a 2D array allocates $1,000,000 \times 4\text{ bytes} \approx 4\text{ MB}$.
- Storing it in **Triplet representation** stores only the 50 elements: $50 \times 3 \times 4\text{ bytes} \approx 600\text{ bytes}$ (**99.98% memory saved**).

---

### 2. Data Structure: 3-Tuple (Triplet) Representation
Every non-zero entry is stored as a tuple `(row, col, value)`.
The Sparse Matrix maintains:
- `rows`: Total rows in original matrix
- `cols`: Total columns in original matrix
- `numTerms`: Count of non-zero elements
- `terms`: List of `Triplet(row, col, value)` sorted in row-major order (`row` ascending, then `col` ascending).

```java
public static class Triplet implements Comparable<Triplet> {
    int row;
    int col;
    int value;
    
    @Override
    public int compareTo(Triplet other) {
        if (this.row != other.row) return Integer.compare(this.row, other.row);
        return Integer.compare(this.col, other.col);
    }
}
```

---

### 3. How We Solve Each Operation (Transpose, Addition, Multiplication)

#### A. Fast Transpose ($O(\text{cols} + \text{terms})$):
- Transposing an entry $(r, c, v)$ turns it into $(c, r, v)$.
- To avoid expensive sorting ($O(\text{terms} \log \text{terms})$) or naive column scanning ($O(\text{cols} \times \text{terms})$), Fast Transpose uses **Counting Sort**:
  1. `colCount[c]`: Count how many non-zero entries exist in column $c$.
  2. `startPos[c]`: Cumulative prefix sum giving the exact starting index for column $c$ in the transposed array.
  3. Single pass through terms: Place each element directly at `transposed[startPos[t.col]++]`.

#### B. Sparse Matrix Addition ($A + B$):
- **Rule:** Dimensions must match ($A_{\text{rows}} == B_{\text{rows}}$ and $A_{\text{cols}} == B_{\text{cols}}$).
- **Algorithm:** Two-pointer merge (like in Merge Sort) traversing the sorted terms of $A$ and $B$:
  - If $A[i]$ position $< B[j]$ position: insert $A[i]$, $i++$.
  - If $B[j]$ position $< A[i]$ position: insert $B[j]$, $j++$.
  - If positions match: add values. If $(A[i].\text{val} + B[j].\text{val} \ne 0)$, insert sum. Increment both $i, j$.

#### C. Sparse Matrix Multiplication ($A \times B$):
- **Rule:** Columns of A must equal Rows of B ($A_{\text{cols}} == B_{\text{rows}}$).
- **Algorithm:**
  1. Transpose matrix $B \implies B^T$.
  2. Because $B^T$ has columns of $B$ as its rows, multiplying $A$ by $B$ matches terms where $A[i].\text{col} == B^T[j].\text{col}$.
  3. Accumulate products in a hash map keyed by $(\text{row}_A \times B_{\text{cols}} + \text{col}_B)$.
  4. Convert non-zero accumulated sums into the result sparse matrix.

---

### 4. Concrete Example Walkthrough

#### Matrices:
$$\text{Matrix } A (3 \times 3) = \begin{bmatrix} 5 & 0 & 0 \\ 0 & 0 & 8 \\ 0 & 0 & 0 \end{bmatrix}, \quad \text{Matrix } B (3 \times 3) = \begin{bmatrix} 3 & 0 & 0 \\ 0 & 0 & 2 \\ 0 & 0 & 0 \end{bmatrix}$$

#### Triplet Representation:
- **Matrix A:** `(0, 0, 5)`, `(1, 2, 8)`
- **Matrix B:** `(0, 0, 3)`, `(1, 2, 2)`

#### Operations Step-by-Step:

1. **Transpose of A ($A^T$):**
   Swap `row` and `col`:
   - `(0, 0, 5)` $\to$ `(0, 0, 5)`
   - `(1, 2, 8)` $\to$ `(2, 1, 8)`
   ```
   Full Grid A^T:
        5     0     0
        0     0     0
        0     8     0
   ```

2. **Addition ($A + B$):**
   - At `(0, 0)`: $5 + 3 = 8 \implies (0, 0, 8)$
   - At `(1, 2)`: $8 + 2 = 10 \implies (1, 2, 10)$
   ```
   Full Grid (A + B):
        8     0     0
        0     0    10
        0     0     0
   ```

3. **Multiplication ($A \times B$):**
   - Row 0 of A $\times$ Col 0 of B: $A(0,0) \times B(0,0) = 5 \times 3 = \mathbf{15} \implies (0, 0, 15)$
   - All other row-col products equal $0$.
   ```
   Full Grid (A * B):
       15     0     0
        0     0     0
        0     0     0
   ```

---

### 5. How the Code Works Under the Hood

- `inputSparseMatrix(Scanner, name)`: Interactively prompts for matrix dimensions ($M \times N$), number of non-zero terms ($K$), and reads coordinates `(row, col, value)` with boundary validation.
- `transpose()`: Executes Fast Transpose using `colCount` and `startPos` arrays.
- `add(SparseMatrix a, SparseMatrix b)`: Validates dimensions and performs a two-pointer merge on sorted triplets.
- `multiply(SparseMatrix a, SparseMatrix b)`: Transposes matrix $B$, accumulates dot products, and converts non-zero products into result triplets.
- `printTripletRepresentation()` and `printFullMatrix()`: Displays the 3-column table and reconstructed 2D grid.

---

### 6. How to Run & Use the Code

```bash
java Assignments.Assignment2_SparseMatrix
```
**Sample Input Sequence:**
```text
Enter Details for Matrix A:
Enter number of rows: 3
Enter number of columns: 3
Enter number of non-zero elements: 2
Element #1 [row col value]: 0 0 5
Element #2 [row col value]: 1 2 8

Enter Details for Matrix B:
Enter number of rows: 3
Enter number of columns: 3
Enter number of non-zero elements: 2
Element #1 [row col value]: 0 0 3
Element #2 [row col value]: 1 2 2
```
The program will display the Triplet tables and full 2D grids for $A$, $B$, $A^T$, $B^T$, $A + B$, and $A \times B$.

---

### 7. Time & Space Complexity

| Operation | Time Complexity | Auxiliary Space |
| :--- | :--- | :--- |
| **Fast Transpose** | $\mathbf{O(\text{cols} + \text{terms})}$ | $O(\text{cols} + \text{terms})$ |
| **Matrix Addition** | $\mathbf{O(\text{terms}_A + \text{terms}_B)}$ | $O(\text{terms}_A + \text{terms}_B)$ |
| **Matrix Multiplication**| $\mathbf{O(\text{terms}_A \times \text{terms}_{B^T})}$ | $O(\text{terms}_{\text{result}})$ |

---

# 🔹 Assignment 3: Dynamic Programming (0/1 Knapsack & LCS)

### 1. Dynamic Programming Fundamentals
Dynamic Programming (DP) solves complex problems by breaking them into smaller subproblems, solving each subproblem once, and storing the results in a table (Memoization / Tabulation). It requires:
1. **Optimal Substructure:** Optimal solution of problem contains optimal solutions to subproblems.
2. **Overlapping Subproblems:** Subproblems recur many times rather than generating new subproblems.

---

## 🎒 2. Part A: 0/1 Knapsack Problem

### Concept:
You are given $N$ items, each with a weight `weights[i]` and a value `values[i]`, and a knapsack of capacity $W$. Determine the maximum value you can carry. Each item can either be taken ($1$) or left ($0$).

### Why Greedy Fails (Proof by Counterexample):
Suppose knapsack capacity $W = 50$:
- Item 1: Weight = 10, Value = 60 (Ratio = 6.0)
- Item 2: Weight = 20, Value = 100 (Ratio = 5.0)
- Item 3: Weight = 30, Value = 120 (Ratio = 4.0)

A greedy approach by value-to-weight ratio takes Item 1 + Item 2 (Weight = 30, Value = 160). Remaining capacity (20) cannot fit Item 3.
The DP optimal solution selects Item 2 + Item 3 (Weight = 50, Value = **220**).

### DP Recurrence Relation:
Let `dp[i][w]` be the maximum value obtained using a subset of the first $i$ items with weight capacity $w$:

$$\text{dp}[i][w] = \begin{cases} 
\text{dp}[i-1][w] & \text{if } \text{weight}[i-1] > w \quad (\text{Item too heavy}) \\
\max\Big(\text{dp}[i-1][w],\; \text{value}[i-1] + \text{dp}[i-1][w - \text{weight}[i-1]]\Big) & \text{if } \text{weight}[i-1] \le w \quad (\text{Exclude vs Include})
\end{cases}$$

### Concrete Example Walkthrough:
- **Items:** $N = 4$
  - Item 1: Weight = 2, Value = 3
  - Item 2: Weight = 3, Value = 4
  - Item 3: Weight = 4, Value = 5
  - Item 4: Weight = 5, Value = 6
- **Capacity:** $W = 5$

#### DP Table:
```
Item\Cap |    0    1    2    3    4    5
---------+------------------------------
Init (0) |    0    0    0    0    0    0
Item 1   |    0    0    3    3    3    3
Item 2   |    0    0    3    4    4    7
Item 3   |    0    0    3    4    5    7
Item 4   |    0    0    3    4    5    7
```

#### Item Backtracking:
1. Start at `dp[4][5] = 7`.
2. `dp[4][5] == dp[3][5]` ($7 == 7$) $\to$ Item 4 **NOT taken**.
3. `dp[3][5] == dp[2][5]` ($7 == 7$) $\to$ Item 3 **NOT taken**.
4. `dp[2][5] != dp[1][5]` ($7 \ne 3$) $\to$ Item 2 **TAKEN**. Remaining weight = $5 - 3 = 2$.
5. `dp[1][2] != dp[0][2]` ($3 \ne 0$) $\to$ Item 1 **TAKEN**.
- **Result:** Max Value = **7**, Items: Item 1 + Item 2 (Total Weight = 5/5).

---

## 🔤 3. Part B: Longest Common Subsequence (LCS)

### Concept:
Given strings $S_1$ (length $m$) and $S_2$ (length $n$), find the longest subsequence common to both. Characters in a subsequence maintain relative order but do not need to be contiguous.

### DP Recurrence Relation:
Let `dp[i][j]` be the LCS length of prefixes $S_1[0..i-1]$ and $S_2[0..j-1]$:

$$\text{dp}[i][j] = \begin{cases} 
\text{dp}[i-1][j-1] + 1 & \text{if } S_1[i-1] == S_2[j-1] \quad (\text{Characters match}) \\
\max\Big(\text{dp}[i-1][j],\; \text{dp}[i][j-1]\Big) & \text{if } S_1[i-1] \ne S_2[j-1] \quad (\text{Characters differ})
\end{cases}$$

### Concrete Example Walkthrough:
- $S_1 = \text{"AGGTAB"}$, $S_2 = \text{"GXTXAYB"}$

#### DP Table:
```
S1\S2  |   -    G   X   T   X   A   Y   B
-------+---------------------------------
  -    |   0    0   0   0   0   0   0   0
  A    |   0    0   0   0   0   1   1   1
  G    |   0    1   1   1   1   1   1   1
  G    |   0    1   1   1   1   1   1   1
  T    |   0    1   1   2   2   2   2   2
  A    |   0    1   1   2   2   3   3   3
  B    |   0    1   1   2   2   3   3   4
```

#### String Reconstruction:
- Start at `dp[6][7]`: `('B' == 'B')` $\to$ Pick `'B'`, move diagonally to `dp[5][6]`.
- At `dp[5][5]`: `('A' == 'A')` $\to$ Pick `'A'`, move diagonally to `dp[4][4]`.
- At `dp[4][3]`: `('T' == 'T')` $\to$ Pick `'T'`, move diagonally to `dp[3][2]`.
- At `dp[2][1]`: `('G' == 'G')` $\to$ Pick `'G'`, move diagonally to `dp[1][0]`.
- Reverse collected characters: **`"GTAB"`** (Length = 4).

---

### 4. How to Run & Use the Code

```bash
java Assignments.Assignment3_KnapsackAndLCS
```
**Interactive Menu:**
```text
1. Solve 0/1 Knapsack Problem
2. Solve Longest Common Subsequence (LCS)
3. Run Both
4. Exit
Choose an option (1-4): 3
```
Follow the prompts to enter item weights/values and capacity for Knapsack, and the two strings for LCS. The program prints the DP table and reconstructed solutions.

---

### 5. Time & Space Complexity

| Problem | Time Complexity | Space Complexity |
| :--- | :--- | :--- |
| **0/1 Knapsack** | $\mathbf{O(N \times W)}$ | $\mathbf{O(N \times W)}$ |
| **LCS** | $\mathbf{O(m \times n)}$ | $\mathbf{O(m \times n)}$ |

---

# 📺 Curated Code Walkthrough Video Recommendations

### Assignment 1: Graph Representation in Java
1. **Striver (take U forward)** – *“G-3: Graph Representation in Java | Adjacency Matrix & Adjacency List”*
2. **Kunal Kushwaha** – *“Introduction to Graphs in Java | Full Graph Theory & Code”*
3. **Anuj Bhaiya** – *“Graph Data Structure in Java (Adjacency Matrix and List)”*

### Assignment 2: Sparse Matrix Operations
1. **Abdul Bari** – *“Sparse Matrix representation using Class / Struct (Code Walkthrough)”*
2. **Abdul Bari** – *“Sparse Matrix Addition & Transpose Code Walkthrough”*
3. **Neso Academy** – *“Fast Transpose of Sparse Matrix (Algorithm & Code Tracing)”*

### Assignment 3: Dynamic Programming (0/1 Knapsack & LCS)
1. **Striver (take U forward)** – *“DP 19. 0/1 Knapsack | Tabulation (Bottom-Up) Code in Java”*
2. **Striver (take U forward)** – *“DP 26. Print Longest Common Subsequence | DP Table Backtracking in Java”*
3. **Aditya Verma** – *“0/1 Knapsack Problem Tabulation (Bottom-Up DP Matrix & Code)”*

---

# 🎯 Comprehensive Viva-Voce & Professor Q&A

### Q1: Why do we store a graph as both Adjacency Matrix and Adjacency List?
> **Answer:** Adjacency Matrix gives $O(1)$ edge query time but takes $O(V^2)$ space. Adjacency List takes only $O(V + E)$ space, which is optimal for sparse graphs.

### Q2: Why is Fast Transpose called "Fast"?
> **Answer:** Standard transpose uses $O(\text{cols} \times \text{terms})$ by scanning columns repeatedly. Fast Transpose uses Counting Sort with frequency and prefix sum arrays to place elements directly into their target positions in $O(\text{cols} + \text{terms})$ time.

### Q3: Why is 0/1 Knapsack time complexity $O(N \times W)$ called "Pseudo-Polynomial"?
> **Answer:** $W$ is a numeric value, not the count of inputs. In binary, $W$ takes $\log_2(W)$ bits. The runtime is polynomial with respect to $W$, but exponential with respect to input bit length $O(2^k)$.

### Q4: How do you reconstruct the optimal solution from the DP table in Knapsack?
> **Answer:** Compare `dp[i][w]` with `dp[i-1][w]`. If different, item $i$ was included; subtract item $i$'s weight from $w$ and move to $i-1$. If equal, item $i$ was excluded; move to $i-1$. Repeat until $i=0$ or $w=0$.

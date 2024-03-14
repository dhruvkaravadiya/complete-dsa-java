# Tree

This directory contains solutions to problems that can be solved using the `Tree` Data Structure.

## Questions

1. Invert Binary Tree: - [Solution]() - [Approach](#invert-binary-tree)


## Approach

### Depth First Search
> [!IMPORTANT]
> Depth first search involves recursively searching through the left sub tree and then through the right sub tree
- Root , left , right is the order to search 

### Breadth First Search
> [!IMPORTANT]
> Search Thorugh each level
> Basically for each level we add the left and right subtres's root nodes to the queue and then check if the value is equal by removing one node after another 
1. Create a queue and push the main root node of the tree to it
2. now we will poll/remove last added node from the queue and check if its equal to the target and then add the left and right nodes to the queue, until queue becomes empty  

### PreOrder Traversal
- Root - Left - Right

### InOrderTraversal
- Left - Root - Right

### PostOrder Traversal
- Left - Right - Root

### Invert Binary Tree
1. Check if root null, if null return it.
2. Recursively call a function which swaps the left and right node and then call itself for both the left and the right node. 
3. At last return the node from that function

### Max Depth of Binary Tree
1. Recursively call a function which
   - Returns 0 if `node == null`
   - Returns 1 + max( length of left sub tree , length of right sub tree )

### Level Order Traversal
> [!TIP]
> We want to get all the nodes at each level, so we say that we want to traverse each level and return al  the nodes of each level using BREADTH FIRST SEARCH (BFS)
To achieve this follow these steps:
1. Initialize an empty 2D list, and now we create a queue and push the first root node to it until queue become empty.
2. now for each of the nodes of the level, we do bfs and if left or right nodes are not null then we add them to the queue.
3. then add the current root node to the list of levelnodes.
4. add that list to the 2D list of list of nodes.

### Validate Binary Tree
> [!TIP] 
> A tree is valid binary tree if
> 1. Left Subtree of root contains only nodes with value less than the root.
> 2. Right Subtree of root contains only nodes with value more than the root.
> 3. Left and Right Subtrees are also valid binary trees
- Recursive simple solution by first checking if the left sub tree is valid or not
- Here we can keep track of the previous visited node and the compare its value to its subtree's root value and if the value if less than / equal to previous' value 
- Then again recursively checking of the right subtree is valid or not

### Number Of Leaf Nodes


### Kth Smallest Node
> [!TIP]
> Kth smallest node in a tree is the `k - 1` th element from the end when in its inOrder Traversal
The above tip is enough 
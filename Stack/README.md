# Stack

This directory contains solutions to problems that can be solved using the 'Stack' data structure.

## Questions

1. Implement Stack Using Array: - [Solution]() - [Approach](#implement-stack-using-array)
2. Infix To Postfix: - [Solution]() - [Approach](#infix-to-postfix)
4. Postfix to Infix: - [Solution]() - [Approach](#postfix-to-infix)
5. Prefix to Infix: - [Solution]() - [Approach](#prefix-to-infix)
6. Valid Parenthesis: - [Solution]() - [Approach](#valid-parenthesis)
7. Generate Parenthesis: - [Solution]() - [Approach](#generate-parenthesis)
8. Min Stack - [Solution]() - [Approach](#min-stack)
9. Daily Temperatures - [Solution]() - [Approach](#daily-temperatures)

## Approach

### Implement Stack Using Array
N = Array Size, stk = array of integers, TOP = -1
1. PUSH Algorithm
   - Check for Stack Overflow (When top is at last element or more than length)
   - else increment the TOP and add element stk[top] = element
2. POP Algorithm
   - Check for Stack Underflow (When TOP < 0)
   - else decrement TOP and return the new TOP element
3. PEEK Algorithm
   - Check for Stack Underflow ( TOP < 0 )
   - else retrun top

### Infix to Postfix

### Postfix to Infix

### Prefix to Infix

### Valid Parenthesis
Given : String of parenthesis. Example : `({[()]})` or `(){}[]` (Both are valid)
1. Iterate over each character of the string
   - push the character if its opening bracket
   - if character is closing bracket, then look for the corresponding opening bracket on the top of the stack and pop that, if found, else return false 
2. At last if stack is empty return true

### Generate Parenthesis
> [!NOTE]  
> Return all possible combinations of valid parenthesis for values of n = 1, 2, 3, ...
> Further make a recursive tree for all possible combination (VALID + INVALID)
> n == 1 => `()`
> n == 2 => `()()` , `(())`
> n == 3 => `((()))`,`(())()`,`(()())`,`()()()`,`()(())` etc
> To achieve this Follow the Following steps:
Approach:
1. Initialize a String solution = `(`, a list to store all valid combinations, int n
2. Make a function named `makeAndCheckParenthesis` with 3 params: (list, sol, n) 
   - We want to create a function which checks if the solution strnig length is equal 2 * n , basically if solutions string length is even, 
      - then iterate over each character of string of length 2 * n 
         if `(` is found then push to stack
         - else pop from stack()
      - check if stack is empty, and add the current solution string to the list
   - finally then recursively call the function twice by adding `(` and `)` alternatively to solution string , along with the list

### Min Stack

### Daily Temperatures


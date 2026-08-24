import java.util.*;

public class FruitsIntoBasket {

    public static int totalFruit(int[] fruits) {

        int left = 0;
        int right = 0;
        int max = 2;
        int n = fruits.length;

        HashMap<Integer , Integer> map = new HashMap<>();
        

        int maxWindow = Integer.MIN_VALUE;
        // we keep a window and keep expanding it until we dont encounter 3rd element
        // when we encounter 3rd character , we start to shrink the window until current window has just 2 types of characters 

        while (right < n) {

            // just add it, we check after that 
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);

            // if map size>2 then we shrink from left until its not > 2
            while(map.size() > 2){
                int count = map.getOrDefault(fruits[left], 0);
                
                if (count <= 1) {
                    map.remove(fruits[left]);
                } else {
                    map.put(fruits[left], count - 1);
                }
                left++;
            }
            maxWindow = Math.max(maxWindow , right - left + 1);
            right++;
        }

        return maxWindow;
    }

    public static void main(String[] args) {

        int[][] testCases = {

            // Basic
            {1},
            {1, 1, 1, 1},
            {1, 2},
            {1, 2, 1, 2},
            {1, 2, 3},

            // Good sliding-window tests
            {1, 2, 3, 2, 2},
            {1, 2, 3, 4},
            {1, 1, 2, 2, 3},
            {1, 2, 2, 3, 3},
            {1, 2, 3, 2, 1},
            {1, 2, 3, 3, 2, 2},

            // Shrinking tests
            {1, 2, 3, 4, 5},
            {1, 2, 1, 3, 4, 3, 3, 4},
            {1, 1, 1, 2, 3, 3, 3},
            {1, 2, 1, 3, 1, 2, 1, 1},
            {1, 2, 3, 2, 2, 2, 3, 3},

            // Edge cases
            {5, 5, 5, 5, 5, 5},
            {1, 2, 1, 2, 1, 2, 1, 2},
            {1, 2, 3, 4, 5, 6, 7},
            {1, 2, 3, 4, 4, 4},
            {1, 1, 1, 2, 3, 4},

            // 30 elements
            {
                1, 2, 1, 2, 3, 2, 2, 3, 3, 4,
                4, 3, 3, 2, 2, 1, 1, 2, 3, 3,
                2, 2, 2, 4, 4, 4, 3, 3, 3, 3
            },

            // 40 elements
            {
                1, 2, 3, 2, 2, 1, 1, 2, 3, 3,
                3, 2, 2, 4, 4, 5, 4, 4, 5, 5,
                5, 3, 3, 2, 2, 3, 4, 4, 4, 3,
                3, 1, 1, 2, 2, 2, 3, 3, 3, 2
            },

            // 45 elements
            {
                1, 2, 3, 4, 5, 4, 4, 5, 5, 6,
                6, 6, 5, 5, 4, 4, 3, 3, 3, 4,
                4, 5, 6, 6, 7, 7, 6, 6, 5, 5,
                5, 4, 4, 3, 2, 2, 3, 3, 4, 4,
                4, 3, 3, 2, 2
            },

            // Repeated blocks
            {
                1, 1, 1, 2, 2, 2, 3, 3, 3, 4,
                4, 4, 5, 5, 5, 4, 4, 4, 3, 3,
                3, 2, 2, 2, 1, 1, 1, 2, 2, 2,
                3, 3, 3, 4, 4, 4, 5, 5, 5, 4,
                4, 4, 3, 3, 3
            },

            // Nasty middle-window case
            {
                5, 5, 5, 1, 1, 2, 3, 4, 4, 4,
                3, 3, 4, 4, 3, 3, 3, 4, 4, 4,
                2, 2, 2, 1, 1, 3, 3, 3, 4, 4,
                4, 4, 3, 3, 2, 2, 1, 1, 1, 1
            },

            // 100-ish element stress test
            {
                1,2,1,3,2,2,1,1,2,3,
                3,2,2,3,3,4,4,3,3,2,
                1,2,3,4,4,4,3,3,2,2,
                5,5,4,4,5,5,6,6,5,5,
                4,4,3,3,4,4,3,3,2,2,
                1,1,2,2,3,3,2,2,1,1,
                4,4,4,3,3,3,4,4,5,5,
                6,6,5,5,4,4,3,3,2,2,
                7,7,6,6,7,7,8,8,7,7,
                6,6,5,5,5,4,4,3,3,2
            }
        };
        System.out.println(testCases.length);
        for (int i = 0; i < testCases.length; i++) {

            int result = totalFruit(testCases[i]);

            System.out.println(
                "Test Case " + (i + 1) +
                " -> " + result
            );
        }
    }
}
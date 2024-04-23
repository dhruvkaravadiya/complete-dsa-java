public class mergeTwoSortedArrays {
    public static void main(String[] args) {
        int a1[] = { 1, 2, 3, 4, 5, 6 };
        int a2[] = { 3, 4, 5, 6, 7, 8 };
        int x = a1.length, y = a2.length;
        int result[] = new int[x + y];
        int i = 0, j = 0, k = 0;
        while (i < x && j < y) {
            if (a1[i] < a2[j]) {
                result[k] = a1[i];
                i++;
                k++;
            } else if (a1[i] > a2[j]) {
                result[k] = a2[j];
                k++;
                j++;
            } else {
                result[k] = a1[i];
                i++;
                j++;
                k++;
            }
        }
        while (i < x)

        {
            result[k] = a1[i];
            k++;
            i++;
        }
        while (j < y) {
            result[k] = a2[j];
            k++;
            j++;
        }
        for (int z = 0; z < x + y; z++) {
            System.out.print(result[z] + " ");
        }
    }
}

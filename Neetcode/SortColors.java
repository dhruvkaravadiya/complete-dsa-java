import java.util.Arrays;

public class SortColors {

    public static void sortColors(int[] nums) {

        int count0=0;
        int count1=0;
        int count2=0;
        for(int i = 0 ; i <nums.length ; i++){
            if(nums[i]==0){
                count0++;
            }
            else if(nums[i] ==1){
                count1++;
            }
            else{
                count2++;
            }
        }
        for(int i = 0 ; i < nums.length ;i++){
            if(i < count0){
                nums[i] = 0;
            }
            else if(i>= count0 && i < count0 + count1){
                nums[i] = 1;
            }
            else if(i>= count0+count1 && i < nums.length){
                
                nums[i] = 2;
            }
        }
    }

    public static void main(String[] args) {

        int[] nums1 = {2, 0, 2, 1, 1, 0};
        int[] nums2 = {2, 0, 1};
        int[] nums3 = {0};
        int[] nums4 = {1};
        int[] nums5 = {2};
        int[] nums6 = {0, 1, 2};
        int[] nums7 = {2, 2, 1, 1, 0, 0};
        int[] nums8 = {1, 2, 0, 1, 2, 0, 1, 2};
        int[] nums9 = {1, 1, 1, 0, 0, 2, 2};
        int[] nums10 = {0, 0, 0, 0, 0};

        sortColors(nums1);
        sortColors(nums2);
        sortColors(nums3);
        sortColors(nums4);
        sortColors(nums5);
        sortColors(nums6);
        sortColors(nums7);
        sortColors(nums8);
        sortColors(nums9);
        sortColors(nums10);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
        System.out.println(Arrays.toString(nums3));
        System.out.println(Arrays.toString(nums4));
        System.out.println(Arrays.toString(nums5));
        System.out.println(Arrays.toString(nums6));
        System.out.println(Arrays.toString(nums7));
        System.out.println(Arrays.toString(nums8));
        System.out.println(Arrays.toString(nums9));
        System.out.println(Arrays.toString(nums10));
    }
}
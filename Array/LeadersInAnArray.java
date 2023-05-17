public class LeadersInAnArray {
    public static void main(String[] args) {
        int nums[] = {17,18,5,2,6,1};
        int n = nums.length;
        if(nums.length == 1){
            System.out.print(nums[0]);
        }
        else{
            int max = nums[n-1];
            for(int i = n-2 ; i>=0 ; i--){
                if(nums[i] > max){   
                    max = nums[i];
                    System.out.print(max+" ");
                }
            }
        }
    }
}

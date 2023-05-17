package LinkedList;
public class maxTwinSum {
    public int maxTwinSumOfLinkedList(ListNode head){
        //Check if linked list empty
        if(head == null){
            return 0;
        }
        else{
            ListNode temp = head;
            int n = 0;
            while(temp!=null){
                temp = temp.next;
                n++;   
            }
            int arr[] = new int[n];
            ListNode curr = head;
            int i=0;
            while(curr!=null){
                arr[i]=curr.val;
                curr = curr.next;
                i++;
            }
            int maxSum=0;
            for(int j = 0 ; j < n ; j++){
                int sum = arr[j] + arr[n-j-1];
                if(sum>maxSum){
                    maxSum = sum;
                }
            }
        return maxSum;
        }
    }
}

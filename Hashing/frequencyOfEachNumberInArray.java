package Hashing;

import java.util.HashMap;
import java.util.Map;

public class frequencyOfEachNumberInArray {
    public static void main (String[] args)
    {
        int[] arr={1,1,2,2,2,3};
        
        int length=arr.length;
        int[] arr1=new int[length];
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i: arr)
        {
            hm.put(i, hm.getOrDefault(i,0 )+1);
        }
     System.out.println(hm);
     int max=0;
     int temp=0;
     int num=0;

     while(!hm.isEmpty())
     {
        for(Map.Entry<Integer,Integer> e:hm.entrySet())
        {
             temp=e.getValue();
             if (temp>max)
             {
                max=temp;
                num=e.getKey();
                
             }
             
        }
            // System.out.print(max);
            for(int i=0;i<max;i++)
            {
                arr1[i]=num;
            }
        hm.remove(num);
        System.out.println(hm);
     }
    
    }

}
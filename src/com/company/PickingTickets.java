package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PickingTickets {

    public static int maxLenSub(List<Integer> tickets)
    {
        int n=tickets.size();
        int[] arr=new int[tickets.size()];
        for(int i=0;i<tickets.size();i++){
            arr[i]=tickets.get(i);
        }
        // to store the maximum length subsequence
        int max_val = 0;
        int start = 0;

        // hash table to map the array element with the
        // length of the longest subsequence of which
        // it is a part of and is the last element of
        // that subsequence
        HashMap<Integer, Integer> map = new HashMap<>();

        // traverse the array elements
        for (int i = 0; i < arr.length; i++)
        {


            // initialize current length
            // for element arr[i] as 0
            int temp = 0;
            if (map.containsKey(arr[i] - 1))
            {
                temp = map.get(arr[i] - 1);
            }

            if (map.containsKey(arr[i]))
            {
                temp = Math.max(temp, map.get(arr[i]));
            }

            if (map.containsKey(arr[i] + 1))
            {
                temp = Math.max(temp, map.get(arr[i] + 1));
            }
            temp++;

            // update maximum length
            if (temp > max_val)
            {
                max_val = temp;
            }
            map.put(arr[i], temp);
        }

        // required maximum length subsequence
        return max_val;
        //*********************
       /* int n=tickets.size();
        int[] arr=new int[tickets.size()];
        for(int i=0;i<tickets.size();i++){
            arr[i]=tickets.get(i);
        }
        Arrays.sort(arr);
        int mls[] = new int[n], max = 0;

        // Initialize mls[] values for all indexes
        for (int i = 0; i < n; i++)
            mls[i] = 1;

        // Compute optimized maximum length
        // subsequence values in bottom up manner
        for (int i = 1; i < n; i++)
            for (int j = 0; j < i; j++)
                if (Math.abs(arr[i] - arr[j]) <= 1
                        && mls[i] < mls[j] + 1)
                    mls[i] = mls[j] + 1;

        // Store maximum of all 'mls' values in 'max'
        for (int i = 0; i < n; i++)
            if (max < mls[i])
                max = mls[i];

        // required maximum length subsequence
        return max;*/
    }

    /* Driver program to test above function */
    public static void main(String[] args)
    {
        //int arr[] = {4,13,2,3};
        //int arr[] = {8,5,4,8,4};
        List<Integer> arr=new ArrayList<>();
        arr.add(8);
        arr.add(5);
        arr.add(4);
        arr.add(8);
        arr.add(4);
        //int n = arr.length;

        System.out.println("Maximum length subsequence = "+
                maxLenSub(arr));

    }
}

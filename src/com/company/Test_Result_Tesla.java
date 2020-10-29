package com.company;

import java.util.*;

public class Test_Result_Tesla {
    static Map<String, List<String>> map=new HashMap<>();
    static Set<String> seen=new HashSet<>();
    static int noOfGroups=0;
    public static int Solution(String[] t,String[] r){
        if(t==null || r==null || t.length==0 || r.length==0 || (t.length!=r.length))
            return 0;
        int numericIndex=0;
        //loop to retrive the index of the
        for(int idx=0;idx<t[0].length();idx++){
            char c =t[0].charAt(idx);
            if(!Character.isDigit(c))
                continue;
            numericIndex=idx+1;
            break;
        }
        for(int i=0;i<t.length;i++){
                String key=t[i].substring(0,numericIndex);
                String val=r[i].toUpperCase();
                if(!map.containsKey(key) && !seen.contains(key)) {
                    seen.add(key);
                    noOfGroups++;
                    if(val.equals("OK")){
                        map.put(key,new ArrayList<>());
                        map.get(key).add(val);
                    }
                }
                else{
                    if(!val.equals("OK") && map.containsKey(key)){
                        map.remove(key);
                    }

                }
                break;
            }
        return (map.size()*100)/noOfGroups;
    }

    public static void main(String[] args){
        //Test case 1
        String[] T=new String[5];
        T[0]="test1a";
        T[1]="test2";
        T[2]="test1b";
        T[3]="test1c";
        T[4]="test3";
        String[] R=new String[5];
        R[0]="Wrong answer";
        R[1]="OK";
        R[2]="Runtime error";
        R[3]="OK";
        R[4]="Time limit exceeded";

        //Test case 2
       /* String[] T=new String[5];
        T[0]="codility1";
        T[1]="codility3";
        T[2]="codility2";
        T[3]="codility4b";
        T[4]="codility4a";
        String[] R=new String[5];
        R[0]="Wrong answer";
        R[1]="OK";
        R[2]="OK";
        R[3]="Runtime error";
        R[4]="Runtime error";*/

        int result= Test_Result.Solution(T,R);

        System.out.println("Score is: "+result);
    }
}

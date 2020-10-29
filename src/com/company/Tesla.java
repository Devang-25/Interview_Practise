package com.company;
import java.util.*;
public class Tesla {
    static Map<String,List<String>> map=new HashMap<>();
    static Set<String> seen=new HashSet<>();
    static int noOfGroups=0;
    public static int solution(String[] T, String[] R) {
        // write your code in Java SE 8
        if(T==null || R==null || T.length==0 || R.length==0 || (T.length!=R.length)){
            return 0;
        }

        int numIndex=-1;
        //loop to retrieve the index of first digit occurence
        for(int i=0;i<T[0].length();i++){
            char c =T[0].charAt(i);
            if(!Character.isDigit(c)){
                continue;
            }

            numIndex=i+1;
            break;
        }

        for(int i=0;i<T.length;i++){
            String key=T[i].substring(0,numIndex);
            String val=R[i].toUpperCase();
            System.out.println("key: "+ key);
            System.out.println("value: "+ val);
            if(!map.containsKey(key) && !seen.contains(key)){
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

        }

        System.out.println("map size: "+ map.size());
        return (map.size()*100/noOfGroups);
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

        int result= Tesla.solution(T,R);

        System.out.println("Score is: "+result);
    }
}

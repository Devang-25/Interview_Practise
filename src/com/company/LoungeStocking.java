package com.company;

import java.util.HashMap;

public class LoungeStocking {

    static HashMap<Integer,Integer> hand;
    static HashMap<Integer,Integer> supply;

    public LoungeStocking(){
        hand=new HashMap<>();
        supply=new HashMap<>();
    }

    private static int stockLounge(int[] onHand,int[] supplier,int demand){
        int max=Integer.MIN_VALUE;
        for(int i:onHand){
            hand.put(i,hand.getOrDefault(i,0)+1);
            max=Math.max(max,i);
        }
      /* for(int i:hand.keySet()){
            System.out.println("hand key: "+i);
           System.out.println("hand value: "+hand.get(i));
        }*/

        for(int i:supplier){
            supply.put(i,supply.getOrDefault(i,0)+1);
        }
        //System.out.println("Max is: "+max);
        int count=0,maxCount=0, ldemand=0;
        for(int i=0;i<=max;i++){
            ldemand=demand;
            if(hand.containsKey(i)) {
                int ha = hand.get(i);
                System.out.println("Loop no: "+i);
                if (ha > ldemand)
                    return -1;
                else if (ha == ldemand)
                    continue;
                else if (ha > 0 && ha < ldemand && supply.containsKey(i) && supply.get(i) > 0) {
                    while (ldemand - ha > 0 && supply.get(i) > 0) {
                        //System.out.println("i am here");
                        count++;
                        ha++;
                        supply.put(i, supply.get(i) - 1);
                    }
                } else if (ha == 0 && supply.containsKey(i) && supply.get(i) > 0) {
                    //int curr = 0;
                    //int sa=supply.get((onHand[i]));
                    while (ldemand > 0 && supply.get(i) > 0) {
                        count++;
                        ldemand--;
                        supply.put(i, supply.get(i) - 1);
                    }
                }
               /* else {
                    int diff = Math.abs(hand.get(i + 1) - supply.get(i + 1));
                    while (diff < demand) {
                        count++;
                        hand.put(i + 1, hand.get(i + 1) - 1);

                    }
                }*/
            }
           /* else if(supply.containsKey(i) && ){

            }*/
            /*else if(i<max){
                while(ldemand>0 && ){
                    hand.put(i + 1, hand.get(i + 1) - 1);
                    ldemand--;
                }
            }*/
        }

        return count==0?-1:count;

    }

    public static void main(String[] args) {

        //test case 1: output:2
        int[] onHand={0,2,2};
        int[] supplier={2,0,0};

        //test case 2: output:3
        //int[] onHand={1,0,1};
        //int[] supplier={2,0,2,0,0,2};

        //test case 3: output:-1
        //int[] onHand={1,1,1};
        //int[] supplier={2,0,0,0};

        //test case 4: output:3
        //int[] onHand={0,2,2,2};
        //int[] supplier={0,0,2,2};

        int demand=2;

        LoungeStocking ls=new LoungeStocking();
        int result=ls.stockLounge(onHand,supplier,demand);
        System.out.println("The max amount needed is: " +result);
    }

}

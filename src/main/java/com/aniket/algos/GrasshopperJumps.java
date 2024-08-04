package com.aniket.algos;

import java.lang.reflect.Array;
import java.util.*;

public class GrasshopperJumps {

    public static void main(String[] args) {
        //System.out.println(minStartingStair(new int[]{1,-4,2,5}));

    }

    private static int minStartingStair(int[] jumps){
        int minStairReached = Integer.MAX_VALUE;
        //The current Stair
        int currentStair = 1;

        for (int jump : jumps){
            //irrespective of what's the value of jump(+ or -) we going to add it to current stair
            currentStair = currentStair+jump;

            if(currentStair < minStairReached){
                minStairReached = currentStair;
            }
        }
        //as grasshopper can't go below stair 1
        return Math.max((1 - (minStairReached-1)),1);
    }







}

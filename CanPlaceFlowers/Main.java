package CanPlaceFlowers;

public class Main {
    public static void main(String[] args)
    {
        int[] flowerbed = {0};
        int  n =1;

        Solution sl = new Solution();
        System.out.println(sl.canPlaceFlowers(flowerbed,n));
    }
}
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        for(int i = 0;i<flowerbed.length;i++)
        {
            if(n == 0){ return true;}
            if(i == 0){if(flowerbed.length>1){if(flowerbed[i+1] == 0 && flowerbed[i] == 0){n--;flowerbed[i] = 1;}} else if(flowerbed.length == 1 && flowerbed[i] == 0){n--;flowerbed[i] = 1;}}
            else if(i == flowerbed.length-1){if(flowerbed[i-1] == 0 && flowerbed[i] == 0){n--;flowerbed[i] = 1;}}
            else if(flowerbed[i-1] == 0 && flowerbed[i+1]==0 && flowerbed[i] == 0){n--;flowerbed[i] = 1;}
            if(n == 0){ return true;}
        }
        return false;
    }
}

//O(n) = n
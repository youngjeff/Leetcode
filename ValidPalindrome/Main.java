package ValidPalindrome;

public class Main {
}
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0,j = s.length()-1;
        boolean result = s.matches("[a-zA-Z]+");
        while(i<j)
        {
            if(!s.substring(i,i+1).matches("[a-zA-Z0-9]+"))
            {
                i++;continue;
            }
            if(!s.substring(j,j+1).matches("[a-zA-Z0-9]+")){
                j--;continue;
            }
            if(s.substring(i,i+1).toLowerCase().equals(s.substring(j,j+1).toLowerCase())){
                i++;j--;
            }
            else{
                return false;
            }
        }

        return true;
    }
}
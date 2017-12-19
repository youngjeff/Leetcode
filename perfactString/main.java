package perfactString;



import java.util.Arrays;
import java.util.Scanner;

public class main {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] word = new int[26];
        for(int i=0;i<26;i++)
        {
            word[i] = 0;
        }
        for(int i=0;i<input.length();i++)
        {
           if(input.charAt(i) >= 'a' && input.charAt(i) <= 'z')
           {
               word[input.charAt(i)-'a']++;
           }
           else{
               word[input.charAt(i)-'A']++;
           }
        }
        Arrays.sort(word);
        int value = 0;
        for(int i=26;i>0;i--)
        {
            value += word[i-1] * i;
        }
        System.out.print(value);
    }
}

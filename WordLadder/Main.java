package WordLadder;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        ArrayList<String> reached = new ArrayList<>();
        reached.add(beginWord);
        wordList.add(endWord);
        int distance = 1;
        while(!reached.contains(endWord))
        {
            ArrayList<String> toAdd = new ArrayList<>();
            for (String each : reached){
                for (int i=0;i<each.length();i++)
                {
                    char[] chars = each.toCharArray();
                    for (char ch = 'a';ch<='z';ch++)
                    {
                        chars[i] = ch;
                        String word = new String(chars);
                        if(wordList.contains(word))
                        {
                            toAdd.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            distance++;
            if (toAdd.size() == 0) return 0;
            reached = toAdd;
        }


        return distance;
    }
}
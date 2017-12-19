package GroupAnagrams;

import ArrayDemo1.Array;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        try {
            String file = "D:/algoritum/src/GroupAnagrams/1.txt";
            BufferedReader bre = new BufferedReader(new FileReader(file));
            String str="";
            while(bre.readLine()!=null)
            {
                str+=bre.readLine();
            }
            String[] data = str.split(",");
            Solution sl = new Solution();
            List<List<String>> result = sl.groupAnagrams(data);
            System.out.println(result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<String> list = Arrays.asList(strs);
        Collections.sort(list, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return (getHash(o1).compareTo(getHash(o2)));
            }
        });
        List<List<String>>result = new ArrayList<>();
        for(int i=0;i<list.size();i++)
        {
            if(i==0)
            {
                List<String> temp = new ArrayList<>();
                temp.add(list.get(i));
                result.add(temp);
            }
            else{
                if(getHash(list.get(i-1)).equals(getHash(list.get(i))))
                {
                    result.get(result.size()-1).add(list.get(i));
                }
                else{
                    List<String> temp = new ArrayList<>();
                    temp.add(list.get(i));
                    result.add(temp);
                }
            }
        }
        return result;
    }
    public String getHash(String str)
    {
        char[] temp = str.toCharArray();//将str转为char[]
        Arrays.sort(temp);//对char排序
        return new String(temp);
    }
}

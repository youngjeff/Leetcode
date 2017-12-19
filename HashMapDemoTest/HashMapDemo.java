package HashMapDemoTest;

import java.util.HashMap;
import java.util.Map;

public class HashMapDemo {
    public static void main(String[] argv)
    {
        Map<String, String> map = new HashMap<String,String>();
        map.put("Adobe", "Mountain View CA");
        map.put("asdasd","asd");

        String queryString = "O'Really";
        System.out.println("You ask about " + queryString + ".");
        String resultString = map.get(queryString);
        System.out.println("The are localte in:" + resultString);
        System.out.println();

        for(String key: map.keySet()){
            System.out.println("Key " + key + ":Value " + map.get(key));
        }
        map.entrySet().forEach(mE ->System.out.println("Key + " + mE.getKey()+ ";Value"+mE.getValue()));

     }
}

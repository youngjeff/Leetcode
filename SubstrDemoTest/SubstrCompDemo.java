package SubstrDemoTest;

import java.util.Arrays;

public class SubstrCompDemo {
    public static void main(String args)
    {
        String[] strings = {
                "painful",
                "mainly",
                "gaining",
                "raindrops"
        };
        Arrays.sort(strings);
        dump(strings, "Using Default Sort");
    }
    static void dump(String[] args, String title)
    {
        System.out.println(title);
        for(int i=0;i<args.length;i++)
        {
            System.out.println(args[i]);
        }

    }
}

package StringParseDemo;

public class StringParse {
    public static boolean parse(String in, char lookFor, MutableInteger whereFound)
    {
        int i = in.indexOf(lookFor);
        if(i == -1)
        {
            return false;
        }

        whereFound.setValue(i);
        return true;
    }

    public static void main(String[] args)
    {
        MutableInteger mi = new MutableInteger();
        String text = "Hello, world";

        char c = 'W';
        if(parse(text, c, mi))
        {
            System.out.println("Character "+ c + "found at offset");
        }
        else{
            System.out.println("Not found");
        }
    }
}

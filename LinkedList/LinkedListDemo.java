package LinkedList;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
    public static void main(String[] argv)
    {
        System.out.println("Here is a demo of java's LinkedList class");
        LinkedList<String> l = new LinkedList<>();
        l.add(new Object().toString());
        l.add("Hello");
        l.add("end of the list");

        System.out.println("Here is a list of all the element ");

        ListIterator li = l.listIterator(0);
        while(li.hasNext())
        {
            System.out.println("Next to:" + li.next());
        }
        if(l.indexOf("hello") < 0)
        {
            System.out.println("Lookup does not work");
        }
        else{
            System.out.println("Lookup works");
        }
        while(li.hasPrevious())
        {
            System.out.println("Back to:" + li.previous());
        }

    }
}

package StringBuilder;

import java.util.StringTokenizer;

public class StringBuilderCommaList {
   public static void main(String argv[]){
       StringBuilder sb1 = new StringBuilder();
       String SAMPLE_STRING = "this is my firt String Builder CommaList";
       for(String word : SAMPLE_STRING.split(" ")){
            if(sb1.length() > 0){
                sb1.append(", ");

            }
            System.out.println(sb1);

           StringTokenizer st = new StringTokenizer(SAMPLE_STRING);
           StringBuilder sb2 = new StringBuilder();
           while (st.hasMoreElements()){
               sb2.append(st.nextToken());
               if(st.hasMoreElements()){
                   sb2.append(", ");
               }
           }
           System.out.println(sb2);
       }

   }
}

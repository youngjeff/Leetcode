package SoundexDeno;

public class Soundex {
    static boolean debug = false;

    public static final char[] MAP = {
            //A B C D E F G H I J K L M
            '0' , '1' , '2' , '3' , '0' , '1' , '2' , '0' , '0' , '2' , '2' , '4' , '5' ,
            //N O P W R S T U V W X Y Z
            '5' , '0' , '1' , '2' , '6' , '2' , '3' , '0' , '1' , '0' , '2' , '0' , '2'
    };

    public static String soundex(String s) {
        String t = s.toUpperCase();

        StringBuilder res = new StringBuilder();
        char c, prev = '?', preOutput = '?';

        for (int i = 0; i < t.length() && res.length() < 4 && ((c = t.charAt(i)) != ','); i++){
            if(c>='A' && c<='Z' && c != prev){
                prev = c;
                if(i==0){
                    res.append(c);
                }else{
                    char m = MAP[c-'A'];
                    if(debug){
                        System.out.println(c + "-->" + m);
                    }
                    if(m != '0' && m != preOutput){
                        res.append(m);
                        preOutput = m;
                    }
                }
            }
        }

        if(res.length() == 0){
            return null;
        }
        for(int i=res.length();i<4;i++){
            res.append('0');
        }
        return res.toString();
    }
}

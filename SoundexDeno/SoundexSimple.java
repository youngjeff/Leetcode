package SoundexDeno;

public class SoundexSimple {
    public static void main(String[] args){
        String[] names = {
                "Darwin, Ian" ,
                "Davidson, Greg" ,
                "Darwent, William" ,
                "Derwin, Daemon"
        };
        for (String name : names){
            System.out.println(Soundex.soundex(name) + ' '+ name);
        }
    }
}

package Formatter;


import java.io.*;
import java.util.StringTokenizer;

public class Fmt {
    public static final int COLWIDTH = 72;
    final BufferedReader in;
    PrintWriter out;


    public static void main(String[] av) throws IOException{
        String avs = "It's a nice\n" +
                "day, isn't it, Mr. Mxyzzptllxy?\n" +
                "I think we should\n" +
                "go for a walk.";
        av = avs.split(" ");
        if (avs.length() == 0)
            new Fmt(System. in). format();
        else for (String name : av) {
            new Fmt(name). format();

        }

    }

    public Fmt(BufferedReader inFile, PrintWriter outFile) throws IOException{
        this.in = inFile;
        this.out = outFile;
    }

    public Fmt(PrintWriter out) throws IOException{
        this(new BufferedReader(new InputStreamReader(System.in)), out);
    }

    public Fmt(BufferedReader file) throws IOException{
        this(file, new PrintWriter(System.out));
    }

    public Fmt(String fname) throws IOException{
        this(new BufferedReader(new FileReader(fname)));
    }

    public Fmt(InputStream file) throws IOException{
        this(new BufferedReader(new InputStreamReader(file)));
    }

    public void format() throws IOException{
        String line;
        StringBuffer outBuf = new StringBuffer();
        while((line = in.readLine()) != null){
            if(line.length() == 0){
                System.out.println(outBuf);
                System.out.println();
                outBuf.setLength(0);
            }else{
                StringTokenizer st = new StringTokenizer(line);
                while(st.hasMoreTokens()){
                    String word = st.nextToken();

                    if(outBuf.length() + word.length() > COLWIDTH){
                        System.out.println(outBuf);
                        outBuf.setLength(0);
                    }
                    outBuf.append(word).append(' ');
                }
            }

        }
        if(outBuf.length() > 0){
            System.out.println(outBuf);
        }else{
            System.out.println();
        }
    }
}

package JGrepDemo;

import com.jeff.lang.GetOpt;
import sun.security.krb5.internal.PAData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;


public class JGrep {
    private static final String USAGE = "Usage: JGrep pattern [-chilrsnv][-f pattfile][filename...]";

    protected Pattern pattern;
    protected Matcher matcher;
    private boolean debug;

    protected static boolean countOnly = false;
    protected static boolean ignoreCase = false;

    protected static boolean dontPrintFileName = false;
    protected static boolean listOnly = false;
    protected static boolean numbered = false;
    protected static boolean silent = false;
    protected static boolean inVert = false;
    protected static boolean recursive = false;

    public static void main(String[] argv) {
        if (argv.length < 1) {
            System.err.println(USAGE);
            System.exit(1);
            String patt = null;

            GetOpt go = new GetOpt("cf:hilnrRsv");

            char c;
            while ((c = go.getopt(argv)) != 0) {
                switch (c) {
                    case 'c':
                        countOnly = true;
                        break;
                    case 'f':
                        try (BufferedReader b = new BufferedReader(new FileReader(go.optarg()))) {
                            patt = b.readLine();
                        } catch (IOException e) {
                            System.err.println("Can't read pattern file" + go.optarg());
                            System.exit(1);
                        }
                        break;
                    case 'h':
                        dontPrintFileName = true;
                        break;
                    case 'i':
                        ignoreCase = true;
                        break;
                    case 'l':
                        listOnly = true;
                        break;
                    case 'n':
                        numbered = true;
                        break;
                    case 'r':
                    case 'R':
                        recursive = true;
                        break;
                    case 's':
                        silent = true;
                        break;
                    case 'v':
                        inVert = true;
                        break;
                    case '?':
                        System.err.println("Getopts was not happy!");
                        System.err.println(USAGE);
                        break;

                }

            }
            int ix = go.getOptInd();
            if (patt == null) {
                patt = argv[ix++];
            }
            JGrep prog = null;
            try {
                prog = new JGrep(patt);
            } catch (PatternSyntaxException ex) {
                System.err.println("RE Syntax error in " + patt);
                return;
            }

            if (argv.length == ix) {
                dontPrintFileName = true;
                if (recursive) {
                    System.err.println("WEarning: recursive search of stdin!");
                }
                prog.process(new InputStreamReader(System.in), null);
            } else {
                if (!dontPrintFileName)
                    dontPrintFileName = ix == argv.length - 1;
                if (recursive)
                    dontPrintFileName = false;

                for (int i = ix; i < argv.length - 1;i++) {
                    try {
                        prog.process(new File(argv[i]));

                    } catch (Exception e) {
                        System.err.println(e);
                    }
                }
            }
        }

    }

    public JGrep(String patt) throws PatternSyntaxException {
        if (debug) {
            System.err.printf("JGrep.JGrep(%s)%n", patt);
        }

        int caseMode = ignoreCase ? Pattern.UNICODE_CASE | Pattern.CASE_INSENSITIVE : 0;
        pattern = Pattern.compile(patt, caseMode);
        matcher = pattern.matcher("");
    }

    public void process(File file) throws FileNotFoundException{
        if(!file.exists() || !file.canRead()){
            System.err.println("ERROR:can't read file "+ file.getAbsolutePath());
            return ;
        }
        if(file.isFile()){
            process(new BufferedReader(new FileReader(file)),file.getAbsolutePath());
            return ;
        }
        if(file.isDirectory()){
            if(!recursive){
                System.err.println("Error: -r not specified but dicectory given " + file.getAbsolutePath());
                return ;
            }
            for (File nf:file.listFiles()){
                process(nf);
            }
            return;
        }
        System.err.println("WEIRDNESS: neither file not directory: " + file.getAbsolutePath());
    }
    public void process(Reader ifile, String fileName){
        String inputLine;
        int matches = 0;

        try(BufferedReader reader = new BufferedReader(ifile)){
            while((inputLine = reader.readLine()) != null){
                matcher.reset(inputLine);
                if(matcher.find()){
                    if(listOnly){
                        System.out.println(fileName);
                        return ;
                    }
                    if(countOnly){
                        matches++;
                    }
                    else{
                        if(!dontPrintFileName){
                            System.out.print(fileName + ": ");
                        }
                        System.out.println(inputLine);
                    }
                }else if(inVert){
                    System.out.println(inputLine);
                }
            }
            if(countOnly){
                System.out.println(matches+ " matches in " + fileName);
            }


        }catch (IOException e){
            System.err.println(e);
        }
    }

}
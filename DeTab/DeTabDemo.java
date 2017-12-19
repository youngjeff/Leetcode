//package DeTab;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.io.PrintWriter;
//
//public class DeTabDemo {
//    Tabs ts;
//
//    public static void main(String[] argv) throws IOException{
//        DeTabDemo dt = new DeTabDemo(8);
//        dt.detab(new BufferedReader(new InputStreamReader(System.in)),
//                new PrintWriter(System.out));
//    }
//
//    public DeTabDemo(int n){
//        ts = new Tabs(n);
//    }
//
//    public DeTabDemo(){
//        ts = new Tabs();
//    }
//
//    public void detab(BufferedReader is, PrintWriter out) throws IOException{
//        String line;
//        while ((line = is.readLine()) != null){
//            out.println(detabLine(line));
//        }
//    }
//
//    public String detabLine(String line) {
//        char c;
//        int col;
//        StringBuffer sb = new StringBuffer();
//        col = 0;
//        for (int i = 0; i < line.length(); i++) {
//            if ((c = line.charAt(i)) != '\t') {
//                if ((c = line.charAt(i)) != '\t') {
//                    sb.append(c);
//                    ++col;
//                    continue;
//                }
//                do {
//                    sb.append(' ');
//
//                } while (!ts.isTabStop(++col));
//            }
//
//        }
//        return sb.toString();
//    }
//}

package DeTab;

public class Tabs {
    public final static int DEFTABSPACE = 8;
    protected  int tabSpace = DEFTABSPACE;
    public final static int MAXLINE = 255;

    public Tabs(int n){
        if(n <= 0){
            n = 1;
        }
        tabSpace = n;
    }
    public Tabs(){
        this(DEFTABSPACE);
    }
    public int getTabSpacing(){
        return tabSpace;
    }

    public boolean isTabStop(int col){
        if(col <= 0){
            return false;
        }
        return (col+1) % tabSpace == 0;
    }
}


public class Culori {
    private String colors;
    private int rosu, verde, albastru, alpha;
    private final static int UNU = 1, TREI = 3, CINCI = 5, SAPTE = 7, SAISPREZECE = 16;

    public Culori(final String rgb, final int a) {
        colors = rgb;
        alpha = a;
    }
    /* Separ codurile pentru rosu, verde si albastru */
    public void getColors() {
        rosu = Integer.parseInt(colors.substring(UNU, TREI), SAISPREZECE);
        verde = Integer.parseInt(colors.substring(TREI, CINCI), SAISPREZECE);
        albastru = Integer.parseInt(colors.substring(CINCI, SAPTE), SAISPREZECE);
    }
    /* Returneaza codul pentru rosu */
    public int getRed() {
        return rosu;
    }
    /* Returneaza codul pentru verde */
    public int getGreen() {
        return verde;
    }
    /* Returneaza codul pentru albastru */
    public int getBlue() {
        return albastru;
    }
    /* Returneaza codul pentru transparenta */
    public int getAlpha() {
        return alpha;
    }
}

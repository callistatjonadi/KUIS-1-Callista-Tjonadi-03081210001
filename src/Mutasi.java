public class Mutasi {
    public String logBerita;
    public int uang;

    public Mutasi(int uang, String logBerita){
        this.uang = uang;
        this.logBerita = logBerita;   
    }

    @Override
    public String toString(){
    return "------------------------------\n" +
    "|" + String.format("%1$" + 28 + "s", uang) + "|" + "\n" + "|\t\t\t" + logBerita + "|\n" + "------------------------------" ;
    }
}



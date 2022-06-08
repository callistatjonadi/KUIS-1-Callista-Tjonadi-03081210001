public class Akun {
  public String namaAkun;
  public String nomorRekening;
  public int saldo;


  public Akun(String namaAkun, String nomorRekening, int saldo){
      this.namaAkun = namaAkun;
      this.nomorRekening = nomorRekening;
      this.saldo = saldo;
  }

  public boolean saldoTersedia(int uang){
    if (uang > this.saldo){
      return false;
    }
    return true;
  }

  public boolean Transfer(int uang){
    if (saldoTersedia(uang)){
      this.saldo -= uang;
      return true;
    }
    else{
      System.out.println("Maaf, saldo di rekening Anda tidak cukup.");
      return false;
    }
  }

  public void Credit(int uang){
    this.saldo += uang;
  }
}


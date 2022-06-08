import java.util.ArrayList;
import java.util.Scanner;

public class AplikasiPerbankan {
    public static void main(String[] args) throws Exception {
        ArrayList<Akun> listNasabah = new ArrayList<Akun>();
        Akun nasabah1 = new Akun("Siti", "0213456", 1000000);
        Akun nasabah2 = new Akun("Budi", "0314865", 500000);
        listNasabah.add(nasabah1);
        listNasabah.add(nasabah2);
        
        ArrayList<Mutasi> beritaAcara = new ArrayList<Mutasi>();
        
        Scanner keyboard = new Scanner(System.in);

        int pilihan = 0;
        String yn = "y";

        do{
            cetakMenu();
            pilihan = keyboard.nextInt();

            if (pilihan == 1){
                System.out.print("Masukkan nominal yang ingin ditarik: ");
                int uang = keyboard.nextInt();
                
                if (listNasabah.get(0).Transfer(uang)) {
                    Mutasi berita = new Mutasi(uang, "Debit");
                    beritaAcara.add(berita);
                    System.out.print("Nomor rekening yang dituju: ");
                    String nomorRekening =  keyboard.next();
                    if(nomorRekening.equals(listNasabah.get(1).nomorRekening)){
                        listNasabah.get(1).Credit(uang);
                        System.out.println("Transaksi berhasil.");
                    }
                    else{
                        System.out.println("Nomor Rekening yang Anda tuju tidak tersedia.");
                    }
                }
            }

            else if (pilihan == 2){
                System.out.println("MUTASI");
                for (Mutasi log : beritaAcara) {
                    System.out.println(log);
                }
            }  

            else if (pilihan == 3){
                System.out.println("Saldo Anda saat ini: " + nasabah1.saldo);
            }

            else if (pilihan == 4){
                break;
            }

            else{
                System.out.println("Silahkan memilih pilihan dari 1/2/3/4.");
            }

            System.out.print("Apakah Anda ingin kembali ke Menu Pilihan (y/n)?");
            yn = keyboard.next();
            hapusLayar();
        }while(yn.equalsIgnoreCase("y"));
        }

    public static void cetakMenu(){
        System.out.println("---------- Selamat datang di Aplikasi BANK INDAH ----------");
        System.out.println("Menu Pilihan: ");
        System.out.println("1. Transfer");
        System.out.println("2. Cek Mutasi");
        System.out.println("3. Cek Saldo");
        System.out.println("4. Keluar");
        System.out.print("Pilihan Anda (1/2/3/4): ");
    }

    public static void hapusLayar(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}

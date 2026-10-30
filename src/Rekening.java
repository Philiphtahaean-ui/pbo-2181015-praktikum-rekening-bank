public class Rekening {
    private String nomor;
    private String pemilik;
    private int saldo;

    public Rekening(String nomor, String pemilik, int saldo) {
        this.nomor = nomor;
        this.pemilik = pemilik;
        this.saldo = saldo;
    }

    // Read-only: getter only, no setSaldo
    public int getSaldo() {
        return saldo;
    }

    public boolean setor(int jumlah) {
        if (jumlah <= 0) {
            return false;
        }
        saldo += jumlah;
        return true;
    }

    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    public void cetakInfo() {
        System.out.printf("%s | %-6s | %12s%n", nomor, pemilik, formatRupiah(saldo));
    }

    // Formats 120000 -> "Rp120.000"
    private String formatRupiah(int jumlah) {
        String digit = String.valueOf(Math.abs(jumlah));
        StringBuilder sb = new StringBuilder();
        int hitung = 0;
        for (int i = digit.length() - 1; i >= 0; i--) {
            sb.insert(0, digit.charAt(i));
            hitung++;
            if (hitung % 3 == 0 && i > 0) {
                sb.insert(0, '.');
            }
        }
        return (jumlah < 0 ? "-Rp" : "Rp") + sb;
    }
}
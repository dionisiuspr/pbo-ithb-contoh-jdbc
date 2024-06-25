package databaseeex;

/**
 *
 * @author Dionisius Pratama
 */
public class Mahasiswa {

    private String nama;
    private String nim;

    public Mahasiswa() {

    }

    public Mahasiswa(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    @Override
    public String toString() {
        return nama + " - " + nim;
    }

}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempatbelas;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "mahasiswa")
@NamedQueries({
    @NamedQuery(name = "Mahasiswa.findAll", query = "SELECT m FROM Mahasiswa m"),
    @NamedQuery(name = "Mahasiswa.findByNim", query = "SELECT m FROM Mahasiswa m WHERE m.nim = :nim"),
    @NamedQuery(name = "Mahasiswa.findByNama", query = "SELECT m FROM Mahasiswa m WHERE m.nama = :nama"),
    @NamedQuery(name = "Mahasiswa.findByJenisKelamin", query = "SELECT m FROM Mahasiswa m WHERE m.jenisKelamin = :jenisKelamin"),
    @NamedQuery(name = "Mahasiswa.findByAngkatan", query = "SELECT m FROM Mahasiswa m WHERE m.angkatan = :angkatan")})
public class Mahasiswa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "nim")
    private String nim;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Column(name = "jenis_kelamin")
    private String jenisKelamin;
    @Column(name = "angkatan")
    private Integer angkatan;
    @JoinColumn(name = "kode_prodi", referencedColumnName = "kode_prodi")
    @ManyToOne
    private Prodi kodeProdi;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim) {
        this.nim = nim;
    }

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getJenisKelamin() {
        return jenisKelamin;
    }

    public void setJenisKelamin(String jenisKelamin) {
        if (jenisKelamin == null) {
            this.jenisKelamin = "";
        } else {
            this.jenisKelamin = jenisKelamin.trim();
        }
    }

    public Integer getAngkatan() {
        return angkatan;
    }

    // setter utama: menerima Integer
    public void setAngkatan(Integer angkatan) {
        this.angkatan = angkatan;
    }

    // overload yang menerima String (aman)
    public void setAngkatan(String angkatanStr) {
        if (angkatanStr == null || angkatanStr.trim().isEmpty()) {
            this.angkatan = null;
            return;
        }
        try {
            this.angkatan = Integer.valueOf(angkatanStr.trim());
        } catch (NumberFormatException ex) {
            // opsi: lempar IllegalArgumentException agar caller tahu input salah
            this.angkatan = null;
        }
    }

    public Prodi getProdi() {
        return kodeProdi;
    }

    public void setProdi(Prodi prodi) {
        this.kodeProdi = prodi;
    }

    // optional helper jika UI mengirim kodeProdi sebagai String
    public void setKodeProdi(String kodeProdiStr) {
        if (kodeProdiStr == null || kodeProdiStr.trim().isEmpty()) {
            this.kodeProdi = null;
            return;
        }
        Prodi p = new Prodi();
        p.setKodeProdi(kodeProdiStr.trim());
        this.kodeProdi = p;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nim != null ? nim.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Mahasiswa)) {
            return false;
        }
        Mahasiswa other = (Mahasiswa) object;
        if ((this.nim == null && other.nim != null) || (this.nim != null && !this.nim.equals(other.nim))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datamahasiswa.Mahasiswa[ nim=" + nim + " ]";
    }

}

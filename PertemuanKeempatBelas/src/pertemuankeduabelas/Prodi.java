/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeduabelas;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mursi
 */
@Entity
@Table(name = "prodi")
@NamedQueries({
    @NamedQuery(name = "Prodi.findAll", query = "SELECT p FROM Prodi p"),
    @NamedQuery(name = "Prodi.findByKodeProdi", query = "SELECT p FROM Prodi p WHERE p.kodeProdi = :kodeProdi"),
    @NamedQuery(name = "Prodi.findByNamaProdi", query = "SELECT p FROM Prodi p WHERE p.namaProdi = :namaProdi"),
    @NamedQuery(name = "Prodi.findByJenjang", query = "SELECT p FROM Prodi p WHERE p.jenjang = :jenjang")})
public class Prodi implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "kode_prodi")
    private String kodeProdi;
    @Basic(optional = false)
    @Column(name = "nama_prodi")
    private String namaProdi;
    @Column(name = "jenjang")
    private String jenjang;
    @OneToMany(mappedBy = "kodeProdi")
    private Collection<Mahasiswa> mahasiswaCollection;

    public Prodi() {
    }

    public Prodi(String kodeProdi) {
        this.kodeProdi = kodeProdi;
    }

    public Prodi(String kodeProdi, String namaProdi) {
        this.kodeProdi = kodeProdi;
        this.namaProdi = namaProdi;
    }

    public String getKodeProdi() {
        return kodeProdi;
    }

    public void setKodeProdi(String kodeProdi) {
        this.kodeProdi = kodeProdi;
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public void setNamaProdi(String namaProdi) {
        this.namaProdi = namaProdi;
    }

    public String getJenjang() {
        return jenjang;
    }

    public void setJenjang(String jenjang) {
        this.jenjang = jenjang;
    }

    public Collection<Mahasiswa> getMahasiswaCollection() {
        return mahasiswaCollection;
    }

    public void setMahasiswaCollection(Collection<Mahasiswa> mahasiswaCollection) {
        this.mahasiswaCollection = mahasiswaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (kodeProdi != null ? kodeProdi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prodi)) {
            return false;
        }
        Prodi other = (Prodi) object;
        if ((this.kodeProdi == null && other.kodeProdi != null) || (this.kodeProdi != null && !this.kodeProdi.equals(other.kodeProdi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "datamahasiswa.Prodi[ kodeProdi=" + kodeProdi + " ]";
    }
    
}

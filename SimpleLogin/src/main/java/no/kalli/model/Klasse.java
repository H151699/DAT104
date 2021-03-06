package no.kalli.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "klasse")
@Table(schema = "student", name = "klasse")
public class Klasse {
    @Id
    @Column(name = "kode")
    private String kode;
    @Column(name = "program")
    private String program;

    @OneToMany(mappedBy = "klasseByKlasseKode", fetch = FetchType.LAZY)
    private List<Student> studenter;

    public Klasse() {
        this("", "");
        this.studenter = new ArrayList<Student>();
    }

    public Klasse(String kode, String program) {
        this.kode = kode;
        this.program = program;
        this.studenter = new ArrayList<Student>();
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public List<Student> getStudenter() {
        return studenter;
    }

    public void setStudenter(List<Student> studenter) {
        this.studenter = studenter;
    }
}

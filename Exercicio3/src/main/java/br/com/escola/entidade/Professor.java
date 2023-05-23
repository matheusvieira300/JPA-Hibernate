package br.com.escola.entidade;



import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private String tnome;
    private String assunto;

    @ManyToMany
    @JoinTable(
            name = "professor_classes",
            joinColumns = @JoinColumn(name = "professor_tid"),
            inverseJoinColumns = @JoinColumn(name = "classe_cid")
    )
    private Set<Classe> classes = new HashSet<>();

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTnome() {
        return tnome;
    }

    public void setTnome(String tnome) {
        this.tnome = tnome;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public Set<Classe> getClasses() {
        return classes;
    }

    public void setClasses(Set<Classe> classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "tid=" + tid +
                ", tnome='" + tnome + '\'' +
                ", assunto='" + assunto + '\'' +
                '}';
    }
}

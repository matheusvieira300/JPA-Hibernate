package br.com.escola.entidade;



import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "classes")
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cid;
    private String cnome;

    @ManyToMany(mappedBy = "classes")
    private Set<Professor> professores = new HashSet<>();

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCnome() {
        return cnome;
    }

    public void setCnome(String cnome) {
        this.cnome = cnome;
    }


    public Set<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(Set<Professor> professores) {
        this.professores = professores;
    }

    @Override
    public String toString() {
        return "Classe{" +
                "cid=" + cid +
                ", cnome='" + cnome + '\'' +
                '}';
    }
}

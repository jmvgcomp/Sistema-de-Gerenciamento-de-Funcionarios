package dev.jmvg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "departamentos")
public class Departamento extends AbstractEntity<Long> {
    @Column(nullable = false, unique = true, length = 60)
    private String nome;

    //relacionamento bidirecional
    @OneToMany(mappedBy = "departamento") //lado departamento é o lado fraco da relação
    List<Cargo> cargos;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}

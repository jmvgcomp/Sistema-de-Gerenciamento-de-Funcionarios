package dev.jmvg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "departamentos")
public class Departamento extends AbstractEntity<Long> {
    @NotBlank(message = "Informe um nome")
    @Size(min = 3, max = 60, message = "O nome do departamento deve ter entre {min} e {max} caracteres.")
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

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }
}

package dev.jmvg.dao;

import dev.jmvg.model.Funcionario;

import java.util.List;

public interface FuncionarioDao {
    void save(Funcionario funcionario);
    void update(Funcionario funcionario);
    void delete(Long id);
    Funcionario findById(Long id);
    List<Funcionario> findAll();

    List<Funcionario> findByNome(String nome);

    List<Funcionario> findByCargoId(Long id);
}

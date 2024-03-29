package dev.jmvg.service;

import dev.jmvg.dao.FuncionarioDao;
import dev.jmvg.model.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class FuncionarioServiceImpl implements FuncionarioService {

    private FuncionarioDao dao;

    @Autowired
    public FuncionarioServiceImpl(FuncionarioDao dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(Funcionario funcionario) {
        dao.save(funcionario);
    }

    @Override
    public void editar(Funcionario funcionario) {
        dao.update(funcionario);
    }

    @Override
    public void excluir(Long id) {
        dao.delete(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Funcionario buscarPorId(Long id) {
        return dao.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Funcionario> buscarTodos() {
        return dao.findAll();
    }

    @Override
    public List<Funcionario> buscarPorNome(String nome) {
        return dao.findByNome(nome);
    }

    @Override
    public List<Funcionario> buscarPorcargo(Long id) {
        return dao.findByCargoId(id);
    }

    @Override
    public List<Funcionario> buscarPordata(LocalDate entrada, LocalDate saida) {
        if(entrada != null & saida != null){
            return dao.findByDataEntradaDataSaida(entrada, saida);
        }else if(entrada != null){
            return dao.findByDataEntrada(entrada);
        }else if(saida != null){
            return dao.findByDataSaida(saida);
        }else{
            return new ArrayList<>();
        }
    }
}

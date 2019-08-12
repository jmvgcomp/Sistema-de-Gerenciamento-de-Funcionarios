package dev.jmvg.service;

import dev.jmvg.dao.DepartamentoDao;
import dev.jmvg.model.Departamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    private DepartamentoDao dao;
    @Autowired
    public DepartamentoServiceImpl(DepartamentoDao dao) {
        this.dao = dao;
    }

    @Override
    public void salvar(Departamento departamento) {
        dao.save(departamento);
    }

    @Override
    public void editar(Departamento departamento) {

    }

    @Override
    public void excluir(Long id) {

    }

    @Override
    @Transactional(readOnly = true)
    public Departamento buscarPorId(Long id) {
        return null;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Departamento> buscarTodos() {
        return null;
    }
}

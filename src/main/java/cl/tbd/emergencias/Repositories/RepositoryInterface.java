package cl.tbd.emergencias.Repositories;

import cl.tbd.emergencias.Models.Voluntario;

import java.util.List;

public interface RepositoryInterface<T>{
    public List<T> getAll();
    public T getOneById(Integer id);
    public Integer create(T obj);
    public Integer delete(Integer id);
    public Integer update(T obj);
}

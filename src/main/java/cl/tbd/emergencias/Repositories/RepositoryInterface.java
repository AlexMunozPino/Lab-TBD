package cl.tbd.emergencias.Repositories;

import java.util.List;
// Se definen interfaces que se ocuparán en los repositorios
public interface RepositoryInterface<T>{
    public List<T> getAll();
    public T getOneById(Integer id);
    public Integer create(T obj);
    public Integer delete(Integer id);
    public Integer update(T obj);
}

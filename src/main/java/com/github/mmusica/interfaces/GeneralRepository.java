package com.github.mmusica.interfaces;

public interface GeneralRepository<T> {


    public T add(T entity);

    public  T find(Long id);


    public T update(T entity, Long id);


    public void delete(T entity);


    public void close();


}

package com.baizhi.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UtilDAO<E> {

    public List<E> showAll();

    public void insert(E e);

    public void delete(E e);

    public void update(E e);

    public E selectById(@Param("id")String id);

}

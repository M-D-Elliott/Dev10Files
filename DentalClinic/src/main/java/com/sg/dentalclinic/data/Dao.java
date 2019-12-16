/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.dentalclinic.data;

import java.util.List;

/**
 *
 * @author Marcus
 * @param <T> -- generic accepted to create new dao.
 */
public interface Dao<T> {
    List<T> findAll();

    T find(int ID);

    void add(T arg) throws StorageException;

    boolean update(int ID, T arg) throws StorageException, NotFoundException;

    boolean delete(int ID) throws StorageException, NotFoundException;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.bugsafari.data;

import com.sg.bugsafari.models.Bug;
import java.util.List;


public interface IBugDao {

    Bug create(Bug bug) throws DataException;

    boolean delete(int bugId) throws DataException;

    List<Bug> findAll() throws DataException;

    Bug getById(int bugId) throws DataException;

    boolean update(Bug bug) throws DataException;

    public Bug findById(int bugId);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.statecapitalsv2.Objects;

/**
 *
 * @author Marcus
 */
public interface IJurisdiction {
    String getName();
    @Override
    String toString();
    int getPopulation();
    int getSquareMileage();
}

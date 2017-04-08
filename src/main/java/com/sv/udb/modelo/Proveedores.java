/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sv.udb.modelo;

/**
 *
 * @author Jose Lira
 */
public class Proveedores {    
    private int codiProv;
    private String nombProv;
    private String direProv;
    private String teleProv;
    
    public Proveedores(){
    }

    public Proveedores(int codiProv, String nombProv, String direProv, String teleProv) {
        this.codiProv = codiProv;
        this.nombProv = nombProv;
        this.direProv = direProv;
        this.teleProv = teleProv;
    }

    public int getCodiProv() {
        return codiProv;
    }

    public void setCodiProv(int codiProv) {
        this.codiProv = codiProv;
    }

    public String getNombProv() {
        return nombProv;
    }

    public void setNombProv(String nombProv) {
        this.nombProv = nombProv;
    }

    public String getDireProv() {
        return direProv;
    }

    public void setDireProv(String direProv) {
        this.direProv = direProv;
    }

    public String getTeleProv() {
        return teleProv;
    }

    public void setTeleProv(String teleProv) {
        this.teleProv = teleProv;
    }

    @Override
    public String toString() {
        return this.nombProv;
    }
    
    
}

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
public class Bodega {
    private int codiBode;
    private int codiPiez;
    private int codiProv;
    private int cant;
    private String fech;
    private String prov;
    private String piez;
    
    public Bodega(){
    }

    public Bodega(int codiBode, String piez, String prov, int cant, String fech) {
        this.codiBode = codiBode;
        this.piez = piez;
        this.prov = prov;        
        this.cant = cant;
        this.fech = fech;
    }

    

    public int getCodiBode() {
        return codiBode;
    }

    public void setCodiBode(int codiBode) {
        this.codiBode = codiBode;
    }

    public int getCodiPiez() {
        return codiPiez;
    }

    public void setCodiPiez(int codiPiez) {
        this.codiPiez = codiPiez;
    }

    public int getCodiProv() {
        return codiProv;
    }

    public void setCodiProv(int codiProv) {
        this.codiProv = codiProv;
    }

    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public String getFech() {
        return fech;
    }

    public void setFech(String fech) {
        this.fech = fech;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getPiez() {
        return piez;
    }

    public void setPiez(String piez) {
        this.piez = piez;
    }

    @Override
    public String toString() {
        return this.fech;
    }

    
}

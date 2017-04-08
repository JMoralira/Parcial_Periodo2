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
public class Piezas {
    private int codiPiez;
    private String nombPiez;
    private String tipoPiez;
    private String marcPiez;
    
    public Piezas(){
    }

    public Piezas(int codiPiez, String nombPiez, String tipoPiez, String marcPiez) {
        this.codiPiez = codiPiez;
        this.nombPiez = nombPiez;
        this.tipoPiez = tipoPiez;
        this.marcPiez = marcPiez;
    }

    public int getCodiPiez() {
        return codiPiez;
    }

    public void setCodiPiez(int codiPiez) {
        this.codiPiez = codiPiez;
    }

    public String getNombPiez() {
        return nombPiez;
    }

    public void setNombPiez(String nombPiez) {
        this.nombPiez = nombPiez;
    }

    public String getTipoPiez() {
        return tipoPiez;
    }

    public void setTipoPiez(String tipoPiez) {
        this.tipoPiez = tipoPiez;
    }

    public String getMarcPiez() {
        return marcPiez;
    }

    public void setMarcPiez(String marcPiez) {
        this.marcPiez = marcPiez;
    }

    @Override
    public String toString() {
        return this.nombPiez;
    }
    
    
    
}

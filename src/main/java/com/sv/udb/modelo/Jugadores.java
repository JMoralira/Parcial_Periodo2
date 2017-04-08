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
public class Jugadores {
        private int codiJuga;
        private int codiEqui;
        private String nombJuga;
        private int edadJuga;
        private double altuJuga;
        private double pesoJuga;
        private byte[] imag;

        public Jugadores(){
}

    public Jugadores(int codiJuga, int codiEqui, String nombJuga, int edadJuga, double altuJuga, double pesoJuga, byte[] imag) {
        this.codiJuga = codiJuga;
        this.codiEqui = codiEqui;
        this.nombJuga = nombJuga;
        this.edadJuga = edadJuga;
        this.altuJuga = altuJuga;
        this.pesoJuga = pesoJuga;
        this.imag = imag;
    }

    public int getCodiJuga() {
        return codiJuga;
    }

    public void setCodiJuga(int codiJuga) {
        this.codiJuga = codiJuga;
    }

    public int getCodiEqui() {
        return codiEqui;
    }

    public void setCodiEqui(int codiEqui) {
        this.codiEqui = codiEqui;
    }

    public String getNombJuga() {
        return nombJuga;
    }

    public void setNombJuga(String nombJuga) {
        this.nombJuga = nombJuga;
    }

    public int getEdadJuga() {
        return edadJuga;
    }

    public void setEdadJuga(int edadJuga) {
        this.edadJuga = edadJuga;
    }

    public double getAltuJuga() {
        return altuJuga;
    }

    public void setAltuJuga(double altuJuga) {
        this.altuJuga = altuJuga;
    }

    public double getPesoJuga() {
        return pesoJuga;
    }

    public void setPesoJuga(double pesoJuga) {
        this.pesoJuga = pesoJuga;
    }

    public byte[] getImag() {
        return imag;
    }

    public void setImag(byte[] imag) {
        this.imag = imag;
    }

    @Override
    public String toString() {
        return this.nombJuga;
    }
        
    
}

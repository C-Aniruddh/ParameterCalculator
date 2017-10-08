package com.aniruddh.parametercalculator.technologies;

/**
 * Created by Aniruddh on 08-10-2017.
 */

public class Tech018 {
    private float Esiox = (float) (3.45*Math.pow(10,-11));
    private float tox, uon, uop, vtn, vtp, vsat, length, iref;

    public Tech018(float tox, float uon, float uop, float vtn, float vtp, float vsat, float length, float iref){
        this.tox = tox;
        this.uon = uon;
        this.uop = uop;
        this.vtn = vtn;
        this.vtp = vtp;
        this.vsat = vsat;
        this.length = length;
        this.iref = iref;
    }

    public double getCox(){
        float c = Esiox/tox;
        return c;
    }

    public double getKp(){
        double k = uop*getCox()*Math.pow(10,-4);
        return k;
    }

    public double getKn(){
        double k = uon*getCox()*Math.pow(10,-4);
        return k;
    }

    public double getWn(){
        double w = ((2*iref*length)/(getKn()*(Math.pow(vsat, 2))))*Math.pow(10, 6);
        return w;
    }

    public double getWp(){
        double w = ((2*iref*length)/(getKp()*(Math.pow(vsat, 2))))*Math.pow(10, 6);
        return w;
    }
}

package br.edu.ifpb.si.pdm.jogodoarrocha;

import java.util.Random;

/**
 * Created by admin on 27/05/16.
 */
public class Arrocha {
    private int menor, maior, numero;

    public Arrocha() {
        this.menor = 1;
        this.maior = 100;

        Random r = new Random();
        this.numero = r.nextInt(98) + 2;
    }

    public int getMenor() {
        return menor;
    }

    public int getMaior() {
        return maior;
    }

    public int getNumero() {
        return numero;
    }

    private boolean isArrochado(){
        return this.menor + 2 == this.maior;
    }

    public void apostar(int chute) throws JogoVenceuException, JogadorVenceuException{
        if (chute <= this.menor || chute >= maior) throw new JogoVenceuException();
        if (chute == this.numero) throw new JogadorVenceuException();
        if (chute < this.numero) this.menor = chute;
        else this.maior = chute;
        if (this.isArrochado()) throw new JogoVenceuException();
    }
}

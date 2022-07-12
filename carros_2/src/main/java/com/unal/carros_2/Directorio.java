/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.unal.carros_2;

/**
 *
 * @author Usuario
 */
import java.util.ArrayList;
import java.util.List;

public class Directorio {

    public String nombre;
    List<Directorio> subdirs;
    List<String> archivos;

    Directorio(String nombre) {
        this.nombre = nombre;
        this.subdirs = new ArrayList<>();
        this.archivos = new ArrayList<>();
    }

    public String espacios(int nivel) {
        String s = "";
        for (int i = 0; i < nivel; i++) {
            s += " ";
        }
        return s;
    }

    String toString(int nivel) {
        String s = espacios(nivel) + nombre + '\n';
        for (Directorio d : subdirs) {
            s += d.toString(nivel + 1) + '\n';
        }
        for (String a : archivos) {
            s += espacios(nivel + 1) + a + '\n';
        }
        return s;
    }

    public String toString() {
        return this.toString(0);
    }

    public static void main(String[] args) {
        Directorio root = new Directorio("root");
// Primernivel
        root.subdirs.add(new Directorio("bin"));
        root.subdirs.add(new Directorio("home"));
        root.subdirs.add(new Directorio("lib"));
// Segundonivel
        root.subdirs.get(0).subdirs.add(new Directorio("will"));
        System.out.println(root);
    }
}

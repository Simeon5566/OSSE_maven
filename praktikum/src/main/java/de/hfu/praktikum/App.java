package de.hfu.praktikum;

import javax.swing.JOptionPane;

public class App 
{
    public static void main( String[] args )
    {
        String texteingabe;
        texteingabe = JOptionPane.showInputDialog("Geben sie einen Text ein.");
        System.out.println(texteingabe.toUpperCase());
    }
}

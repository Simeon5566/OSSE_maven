package de.hfu.praktikum;

import javax.swing.JOptionPane;
import org.junit.Assert.*;
import org.junit.Test;
public class App 
{
    public static void main( String[] args )
    {
        String texteingabe;
        texteingabe = JOptionPane.showInputDialog("Geben sie einen Text ein.");
        System.out.println(texteingabe.toUpperCase());
       
    }
    @Test
    public void StringTest() {
    	
    }
}

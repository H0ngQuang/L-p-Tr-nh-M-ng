/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Task2;
import UDP.Book;
import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author Admin
 */
public class test {
    public static void main(String[] args) {
       String s = "ABcdEfghIK";
       int dich =100;
       String res = "";
       for(char c : s.toCharArray()){
           char base = Character.isUpperCase(c) ? 'A' : 'a';
           c = (char) ((c-base + dich) % 26  + base); 
           res += c;
       }
        System.err.println(res);
    }
}

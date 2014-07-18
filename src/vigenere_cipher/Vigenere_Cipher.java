package vigenere_cipher;
import java.util.Scanner;

/**
 *
 * @author todyerutz @ plainintricacy.wordpress.com
 * Java program that simulates an encryption device based on the Vigenere Cipher:
 * https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher
 */

public class Vigenere_Cipher {

    public static String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
    public static void main(String[] args) {
    
        try (Scanner input = new Scanner(System.in)) {
            System.out.println("Please enter your message:");
            char[] arr = input.nextLine().toUpperCase().toCharArray();
            System.out.println("Please enter your keyword:");
            char[] KeyArr = input.nextLine().toUpperCase().toCharArray();
            System.out.println("Encrypted message:");
            encrypt(arr, KeyArr);
            System.out.println();
            input.close();
        }    
    }
    
    public static boolean isLetter(Character x){
        for(int i=0; i<alphabet.length(); i++){
            if(x==alphabet.charAt(i)){
                return true;
            }
        }
        return false;
    }
    
    public static int Lpos(Character x){
        for(int i=0; i<alphabet.length(); i++){
            if(x==alphabet.charAt(i)){
                return i;
            }
        }
        return 0;
    }
    
    public static int Apos(int x){
        if(x>alphabet.length()){
            return x-alphabet.length();
        }else
            if(x<0){
                return alphabet.length()+x;
            }        
        return x;
    }
    
    public static void encrypt(char[] a, char[] b){
        int q = 0;
        for(int i=0; i<a.length; i++){
            if(isLetter(a[i])){
                if(q==b.length){
                    q=0;}
                    a[i] = alphabet.charAt(Lpos(alphabet.charAt(Apos(Lpos(a[i])+Lpos(b[q])))));
                    q++;
            }
        }
        for(int i=0; i<a.length; i++){
            System.out.print(a[i]);
        }
    }
}

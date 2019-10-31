/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alphabet;
import java.util.Scanner;

/**
 *
 * @author bren4
 */
public class Alphabet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Scanner sc = new Scanner(System.in);
        String given = sc.nextLine();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        int sol = alphaCompare(given, alphabet);
        System.out.println(26 - sol);
        
    }
    
    public static int alphaCompare(String given, String alphabet){
        int m = given.length();
        int n = alphabet.length();
        
        int bet[][] = new int [m+1][n+1];
        
        for(int i = 0; i <= m; i++){
            for(int j = 0; j <= n; j++){
                if(i == 0 || j == 0)
                    bet[i][j] = 0;
                else if(given.charAt(i-1) == alphabet.charAt(j-1))
                    
                bet[i][j] = 1 + bet[i-1][j-1];
                
                else
                    bet[i][j] = Math.max(bet[i-1][j], bet[i][j-1]);
            }
        }
        return bet[m][n];
    }
    
}

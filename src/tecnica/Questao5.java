package tecnica;

import java.util.Scanner;

public class Questao5 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Informe uma string: ");
        String texto = scanner.nextLine();

        char[] caracteres = texto.toCharArray();
        
        String textoInvertido = "";

        for (int i = caracteres.length - 1; i >= 0; i--) {
            textoInvertido += caracteres[i];  
        }

        System.out.println(textoInvertido);

        scanner.close();
    }
}
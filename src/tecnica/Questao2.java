package tecnica;

import java.util.Scanner;

public class Questao2 {

    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe um número: ");
        int numero = scanner.nextInt();
        
        int anterior = 0;
        int atual = 1;
        boolean pertence = false;

        if (numero == 0 || numero == 1) {
            pertence = true;
        } else {
            while (atual < numero) {
                int proximo = anterior + atual;  
                anterior = atual;
                atual = proximo;
            }

            if (atual == numero) {
                pertence = true;
            }
        }
        
        if (pertence) {
            System.out.println(numero + " pertence a sequência de Fibonacci");
        } else {
            System.out.println(numero + " não pertence a sequência de Fibonacci");
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora;

// Importa de classes
import java.util.Scanner;
import java.io.IOException;

public class Calculadora {
    
    // Constantes
    public static final int SOMA = 0;
    public static final int SUB = 1;
    public static final int MULT = 2;
    public static final int DIV = 3;
    
    public static void main(String[] args) throws IOException, InterruptedException {
        
        // Variáveis
        double num_1 = 0.0, num_2 = 0.0;
        char verificador = 's';
        int opcao;
        
        // Declaração do buffer
        Scanner read = new Scanner(System.in);
        
        
        while(verificador != 'n') {
        
            System.out.println("-----Calculadora-----\n");
            Legenda(); 
            
            System.out.print("Digite qual a opção desejada: ");
            opcao = read.nextInt();
            
            // condição que verifica se a opção escolhida é a correta
            if ((opcao <= 3 && opcao >= 0) == false) {
                
                boolean flag = true;
                while (flag) {
                    
                    // cria um processo para limpar o terminal do windows
                    if (System.getProperty("os.name").contains("Windows")) {
                        
                        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
                    }
                    
                    
                    Legenda();
                    System.out.print("Por favor digite um valor valido entre 0 - 3: ");
                    opcao = read.nextInt();
                    
                    if (opcao <= 3 && opcao >= 0)
                        flag = false;
                    
                }
            } // end if      
            
            // limpa o terminal
            
            System.out.print("Digite o primero número: ");
            num_1 = read.nextDouble();
            System.out.print("Digite o segundo número: ");
            num_2 = read.nextDouble();
            
            // Testa a opção para ver qual operação fazer
            switch (opcao) {
                
                case SOMA:
                    System.out.println(">>>Soma<<<\nResultado: " + Soma(num_1, num_2));
                    break;
                
                case SUB:
                    System.out.println(">>>Subtracao<<<\nResultado: " + Soma(-num_1, -num_2));
                    break;

                case MULT:
                    System.out.println(">>>Multiplicacao<<<\nResultado: " + Mult(num_1, num_2));
                    break;
                
                case DIV:
                    System.out.println(">>>Divisao<<<\nResultado: " + Div(num_1, num_2));
                    break;
            }
            
            
            System.out.println("\n\nVocê deseja continuar? (s/n)");
            verificador = read.next().charAt(0);
            
            // cria um processo para limpar o terminal do windows
            if (System.getProperty("os.name").contains("Windows")) {
                        
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            }
        } // end while
        
    }
    
    // Função para exibir legenda da calculadora
    public static void Legenda() {
        System.out.println("0 - SOMA");
        System.out.println("1 - SUBTRACAO");
        System.out.println("2 - MULTIPLICACAO");
        System.out.println("3 - DIVISAO\n");
    }
    
    // Função usada tanto na adição quanto na subtração
    public static double Soma(double a, double b) {
        
        return a + b;
    }
    
    // Função usada para a multiplicação
    public static double Mult(double a, double b) {
        
        return a * b;
    }
    
    // Função usada na divisão
    public static double Div(double a, double b) {
        
        return a / b;
    }
}

//dependencias

import java.io.*;
import java.util.*;

public class Binario {

    public static Scanner in = new Scanner (System.in);

    public static void read ( ){
        //mostrar para o usuario dado a ser lido
        System.out.println ( "" );
        System.out.println ( "Entre com o valor decimal desejado para a conversao: ");
    }//end read ( )

    public static String binRec ( int resto, int decimal ){
        //definir dado de retorno
        String resp = "";

        //verificar se dado valido e retornar
        if ( decimal > 0 ) {
            //chamar o proprio metodo enquanto decimal for valido
            resp = resp + resto + binRec(decimal%2, decimal/2);
        }//end if
        return (resp);
    }//end binRec ( )

    public static String inverter ( String binario ){
        String bin = "";
        //repetir inverter e definir binario
        for ( int i = binario.length()-1; i > 0; i-- ){
            //inverter string
            bin = bin + binario.charAt(i);
        }//end for
        return bin;
    }//end inverter

    public static void Binario ( int decimal ){
        //definir dados
        int dec = 0, d = 0, count = 0;
        int resto = 0;
        String binario = "", bin = "";

        //definir respectivos valores
        dec = decimal;
        d   = decimal;

        //repetir para contar a quantidade de repeticoes necessarias
        do {
            //fazer divisoes sucessivas
            decimal = decimal/2;
            //contar quantas repeticoes
            count++;
        } while ( decimal > 0 );

        //repetir para calcular e concatenar dados na string
        while ( count > 0 ){
            //calcular resto
            resto = d % 2;
            //concatenar na string
            binario = binario + resto;
            //calcular o proximo inteiro
            d = d/2;
            //variar contador
            count--;
        }//end while
        //inverter e concatenar
        bin = inverter(binario);
        //mostrar para o usuario o resultado
        System.out.println ( "DECIMAL: " +dec+ "(10) | BINARIO: " +bin+"(2)" );
    }//end Binario ( )

    public static void main ( String [ ] args ) throws IOException {
        //definir dados
        int opcao   = 0;
        int decimal = 0;
        String rec  = "";
        do {
            //mostrar para usuario as possiveis opcoes
            System.out.println("");
            System.out.println("DIGITE A OPCAO DESEJADA: ");
            System.out.println("");
            System.out.println("0 - ENCERRAR.");
            System.out.println("1 - Metodo iterativo.");
            System.out.println("2 - Metodo recursivo.");
            //ler opcao
            opcao = in.nextInt();
            //permitir escolha
            if ( opcao == 1 ){
                    //permitir que o usuario digite o valor decimal desejado
                    read();
                    //ler este valor
                    decimal = in.nextInt();
                    //chamar metodo iterativo
                    Binario(decimal);
            } else if ( opcao == 2 ) {
                //permitir que o usuario digite o valor decimal desejado
                read();
                //ler este valor
                decimal = in.nextInt();
                //chamar metodo recursivo
                rec = binRec ( 0, decimal );
                //mostrar resultdo
                rec = inverter (rec);
                System.out.println ( "DECIMAL: " +decimal+ "(10)| BINARIO: " +rec+"(2)");
            } else {
                //definir parada
                 opcao = 0;
            }//end else
        } while ( opcao != 0 );
    }//end main ( )
}//end class

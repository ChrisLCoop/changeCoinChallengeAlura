package com.alura.principal;

import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner teclado = new Scanner(System.in);
        double cantidadDeDinero;
        int opcion = 0;
        Api api = new Api();
        api.consultaApi();

        System.out.println("******************");
        System.out.println("Bienvenido a tu casa de Cambio ");
        System.out.println();

        while ( opcion !=7){

            System.out.println("Que operación desea realizar?");
            System.out.println();
            System.out.println("1) Dólar =>> Peso argentino");
            System.out.println("2) Peso argentino =>> Dólar");
            System.out.println("3) Dólar =>> Real Brasileño");
            System.out.println("4) Real Brasileño =>> Dólar");
            System.out.println("5) Dólar =>> Peso colombiano");
            System.out.println("6) Peso colombiano =>> Dólar");
            System.out.println("7) Salir");
            System.out.println();
            System.out.println("Digite el número de la operacion");
            System.out.println("*********************************");
            if (opcion == 7) {
                System.out.println("gracias por usar este sistema .");

                break;
            }

            if(teclado.hasNextInt()){
                opcion= teclado.nextInt();
            }else{
                System.out.println("(o.O) No ingresastes un valor numerico.");
                break;
            }

            if (opcion == 7){
                System.out.println("gracias por usar este sistema .");
                break;
            }else if(opcion > 7){
                System.out.println("(o.O)  Por el momento no tenemos esa opcion.");
                break;
            } else if (0 >= opcion) {
                System.out.println("(o.O)  No tenemos ninguna opcion en negativo o nulo");
                break;
            }

            System.out.println("Cuanto dinero desea convertir?:");
            if (teclado.hasNextDouble()){
                cantidadDeDinero = teclado.nextDouble();
            }else{
                System.out.println("(o.O) solo es valido valores numericos..");
                break;
            }

            if(0> cantidadDeDinero){
                System.out.println("solo es valido numeros positivos");
                break;
            }

            CalculoDeConversion calculo = new CalculoDeConversion(api.getValorConversion1(),api.getValorConversion2(),api.getValorConversion3(),cantidadDeDinero);
            calculo.operacionDeConversion();

            switch (opcion){
                case 1:

                    System.out.println("Su cambio es : "+ calculo.getUsdArs() + "[ARS]- Pesos Argentinos");
                    break;
                case 2:
                    System.out.println("Su cambio es : "+ calculo.getArsUsd() + "[USD]- Dólares Americanos");
                    break;
                case 3:
                    System.out.println("Su cambio es : "+ calculo.getUsdBrl() + "[BRL]- Reales Brasileños");
                    break;
                case 4:
                    System.out.println("Su cambio es : "+ calculo.getBrlUsd() + "[USD]- Dólares Americanos");
                    break;
                case 5:
                    System.out.println("Su cambio es : "+ calculo.getUsdCop() + "[COP]- Pesos Colombianos");
                    break;
                case 6:
                    System.out.println("Su cambio es : "+ calculo.getCopUsd() + "[USD]- Dólares Americanos");
                    break;
            }
        }








    }
}

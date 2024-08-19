package com.juandavid;

import java.util.Scanner;

/**
 * @author Juan Escalante
 */
public class Main {

    public static void main(String[] args) {

        // Variable declaration
        // Shows the main menu
        String menuPrincipal = """
            ********************************
            *        Menú Principal        *
            * Equipo: XX Nombre: Juan David*
            ********************************
            *     a. Cargar Datos.         *
            *     b. Informe Especial.     *
            *     c. Operaciones           *
            *     d. Salir                 *
            ********************************""";

        // If option C is selected, show the Options menu
        String menuOperaciones = """
            *    Introduzca una opción:    *
            ********************************
            *     a. Agregar               *
            *     b. Editar                *
            *     c. Borrar                *
            *     d. Salir                 *
            ********************************""";

        String userInput = "";
        boolean isRunning = true;
        ListaChico listaChicos = new ListaChico();

        try (Scanner input = new Scanner(System.in)) {
            while(isRunning == true){
                // Print main menu
                System.out.println(menuPrincipal);

                userInput = input.nextLine();

                switch(userInput){
                    case "a": // Cargar datos
                        listaChicos.loadChicosFromCSV("chicos.csv");
                        listaChicos.printChicos();
                        break;
                    case "b": // Informe especial
                        if(listaChicos.getListaChicos().isEmpty()){
                            System.out.println("No se han cargado los datos.");
                        } else {
                            System.out.println("******* Lista de Chicos *******");
                            listaChicos.printChicos();
                            System.out.println("******* Totales por Ciudad *******");
                            listaChicos.printCiudades();
                            System.out.println("******* Totales por Grupo de Edad *******");
                            listaChicos.printGrupos();
                        }
                        break;
                    case "c": // Operaciones
                        System.out.println("C");
                        break;
                    case "d": //Salir
                        System.out.println("Gracias por usar nuestro serivico. Los datos han sido guardados exitosamente en el archivo 'chicos.csv'.");
                        isRunning = false;
                    default:
                        System.out.println("Opción inválida. Intente denuevo.");
                }
            }
        }
    }
}

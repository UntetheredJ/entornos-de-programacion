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
        boolean isOptionsRunning = false;
        ListaChico listaChicos = null;

        try (Scanner input = new Scanner(System.in)) {
            while(isRunning){
                // Print main menu
                System.out.println(menuPrincipal);

                userInput = input.nextLine().toLowerCase();

                switch(userInput){
                    case "a": // Cargar datos
                        listaChicos = new ListaChico();
                        listaChicos.loadChicosFromCSV("chicos.csv");
                        //listaChicos.printChicos();
                        System.out.println("Chicos cargados desde 'chicos.csv'");
                        break;
                    case "b": // Informe especial
                        if(listaChicos== null){
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
                        if(listaChicos == null){
                            System.out.println("No se han cargado los datos.");
                            break;
                        } else {
                            isOptionsRunning = true;
                            System.out.println(menuOperaciones);

                            while(isOptionsRunning){
                                userInput = input.nextLine().toLowerCase();
                                switch(userInput){
                                    case "a": // Agregar chico
                                        Chico newChico = new Chico();

                                        // Sets Codigo for Chico
                                        boolean validCodigo = false;
                                        Integer userInputInteger = 0;

                                        while(!validCodigo){
                                            System.out.println("---------------------");
                                            System.out.println("Ingrese el código del chico:");
                                            userInput = input.nextLine();
                                            try {
                                                userInputInteger = Integer.parseInt(userInput);
                                                validCodigo = true;
                                            } catch (NumberFormatException e) {
                                                System.out.println("El dato ingresado no es válido.");
                                            }
                                        }

                                        newChico.setCodigo(userInputInteger);

                                        // Sets Sexo for Chico
                                        boolean validSexo = false;

                                        while(!validSexo){
                                            System.out.println("---------------------");
                                            System.out.println("""
                                                Ingrese el sexo del chico:
                                                - F: Femenino
                                                - M: Masculino""");
                                            userInput = input.nextLine().toUpperCase();
                                            switch(userInput){
                                                case "F":
                                                    validSexo = true;
                                                    break;
                                                case "M":
                                                    validSexo = true;
                                                    break;
                                                default:
                                                    System.out.println("Inserte un sexo válido.");
                                                    break;

                                            }
                                        }

                                        newChico.setSexo(userInput);

                                        // Sets Nombre for Chico:
                                        System.out.println("Ingrese el nombre del chico:");
                                        userInput = input.nextLine().toUpperCase();
                                        newChico.setNombre(userInput);

                                        // Sets Edad for Chico:
                                        boolean validEdad = false;

                                        while(!validEdad){
                                            System.out.println("---------------------");
                                            System.out.println("Ingrese la edad del chico:");
                                            userInput = input.nextLine();
                                            try {
                                                userInputInteger = Integer.parseInt(userInput);
                                                validEdad = true;
                                            } catch (NumberFormatException e) {
                                                System.out.println("El dato ingresado no es válido.");
                                            }
                                        }

                                        newChico.setEdad(userInputInteger);

                                        // Set Ciudad for Chico:
                                        boolean validCiudad = false;

                                        while(!validCiudad){
                                            System.out.println("---------------------");
                                            System.out.println("""
                                                    Ingrese la ciudad del Chico:
                                                    1. Bucaramanga
                                                    2. Girón
                                                    3. Floridablanca
                                                    4. Piedecuesta""");
                                            userInput = input.nextLine();

                                            try {
                                                userInputInteger = Integer.parseInt(userInput);
                                                if(userInputInteger >= 1 && userInputInteger <= 4){
                                                    validCiudad = true;
                                                } else {
                                                    System.out.println("La ciudad no existe. Intente de nuevo.");
                                                    continue;
                                                }
                                                validCiudad = true;
                                            } catch (NumberFormatException e) {
                                                System.out.println("El dato ingresado no es válido.");
                                            }
                                        }

                                        newChico.setCiudad(userInputInteger);

                                        // Add Chico to listaChicos
                                        listaChicos.addChico(newChico);
                                        isOptionsRunning = false;

                                        break;
                                    case "b": // Editar chico
                                        boolean editCompleted = false;
                                        boolean chicoSelected = false;
                                        Chico chicoToEdit = null;
                                        userInputInteger = 0;
                                    
                                        while (!editCompleted) {
                                            System.out.println("---------------------");
                                            if (!chicoSelected) {
                                                System.out.println("Ingrese el código del chico a editar:");
                                                userInput = input.nextLine();
                                                try {
                                                    userInputInteger = Integer.parseInt(userInput);
                                                    chicoToEdit = listaChicos.findChicoByCodigo(userInputInteger);
                                                    if (chicoToEdit == null) {
                                                        System.out.println("El chico con el código " + userInputInteger + " no existe.");
                                                        continue;
                                                    } else {
                                                        chicoSelected = true;
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("El dato ingresado no es válido.");
                                                    continue;
                                                }
                                            }
                                    
                                            System.out.println("""
                                                *   ¿Qué valor desea editar?   *
                                                ********************************
                                                *     a. Código                *
                                                *     b. Sexo                  *
                                                *     c. Nombre                *
                                                *     d. Edad                  *
                                                *     e. Ciudad                *
                                                *     f. Volver                *
                                                ********************************""");
                                            userInput = input.nextLine().toLowerCase();
                                            switch (userInput) {
                                                case "a": // Editar código
                                                    validCodigo = false;
                                                    while (!validCodigo) {
                                                        System.out.println("---------------------");
                                                        System.out.println("Ingrese el nuevo código del chico.");
                                                        userInput = input.nextLine();
                                                        try {
                                                            userInputInteger = Integer.parseInt(userInput);
                                                            chicoToEdit.setCodigo(userInputInteger);
                                                            validCodigo = true;
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("El dato ingresado no es válido.");
                                                        }
                                                    }
                                                    System.out.println("Código del chico editado satisfactoriamente.");
                                                    break;
                                                case "b": // Editar sexo
                                                    validSexo = false;
                                                    while (!validSexo) {
                                                        System.out.println("---------------------");
                                                        System.out.println("""
                                                            Ingrese el nuevo sexo del chico:
                                                            - F: Femenino
                                                            - M: Masculino""");
                                                        userInput = input.nextLine().toUpperCase();
                                                        switch (userInput) {
                                                            case "F":
                                                            case "M":
                                                                chicoToEdit.setSexo(userInput);
                                                                validSexo = true;
                                                                System.out.println("Sexo del chico editado satisfactoriamente.");
                                                                break;
                                                            default:
                                                                System.out.println("Inserte un sexo válido.");
                                                                break;
                                                        }
                                                    }
                                                    break;
                                                case "c": // Editar nombre
                                                    System.out.println("Ingrese el nuevo nombre del chico:");
                                                    userInput = input.nextLine().toUpperCase();
                                                    chicoToEdit.setNombre(userInput);
                                                    System.out.println("Nombre del chico editado satisfactoriamente.");
                                                    break;
                                                case "d": // Editar edad
                                                    validEdad = false;
                                                    while (!validEdad) {
                                                        System.out.println("---------------------");
                                                        System.out.println("Ingrese la nueva edad del chico:");
                                                        userInput = input.nextLine();
                                                        try {
                                                            userInputInteger = Integer.parseInt(userInput);
                                                            chicoToEdit.setEdad(userInputInteger);
                                                            validEdad = true;
                                                            System.out.println("Edad del chico editada satisfactoriamente.");
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("El dato ingresado no es válido.");
                                                        }
                                                    }
                                                    break;
                                                case "e": // Editar ciudad
                                                    validCiudad = false;
                                                    while (!validCiudad) {
                                                        System.out.println("---------------------");
                                                        System.out.println("""
                                                            Ingrese la nueva ciudad del Chico:
                                                            1. Bucaramanga
                                                            2. Girón
                                                            3. Floridablanca
                                                            4. Piedecuesta""");
                                                        userInput = input.nextLine();
                                                        try {
                                                            userInputInteger = Integer.parseInt(userInput);
                                                            if (userInputInteger >= 1 && userInputInteger <= 4) {
                                                                chicoToEdit.setCiudad(userInputInteger);
                                                                validCiudad = true;
                                                                System.out.println("Ciudad del chico editada satisfactoriamente.");
                                                            } else {
                                                                System.out.println("La ciudad no existe. Intente de nuevo.");
                                                            }
                                                        } catch (NumberFormatException e) {
                                                            System.out.println("El dato ingresado no es válido.");
                                                        }
                                                    }
                                                    break;
                                                case "f": // Salir
                                                    editCompleted = true;
                                                    break;
                                                default:
                                                    System.out.println("Opción no válida. Intente de nuevo.");
                                                    break;
                                            }
                                        }
                                    
                                        isOptionsRunning = false;
                                        break;
                                    case "c": // Eliminar chico
                                        boolean removalCompleted = false;
                                        chicoSelected = false;
                                        chicoToEdit = null;
                                        userInputInteger = 0;
                                    
                                        while (!removalCompleted) {
                                            System.out.println("---------------------");
                                            if (!chicoSelected) {
                                                System.out.println("Ingrese el código del chico a eliminar:");
                                                userInput = input.nextLine();
                                                try {
                                                    userInputInteger = Integer.parseInt(userInput);
                                                    chicoToEdit = listaChicos.findChicoByCodigo(userInputInteger);
                                                    if (chicoToEdit == null) {
                                                        System.out.println("El chico con el código " + userInputInteger + " no existe.");
                                                        continue;
                                                    } else {
                                                        chicoSelected = true;
                                                    }
                                                } catch (NumberFormatException e) {
                                                    System.out.println("El dato ingresado no es válido.");
                                                    continue;
                                                }
                                            }
                                            removalCompleted = true;
                                        }

                                        listaChicos.deleteChico(chicoToEdit);
                                        isOptionsRunning = false;
                                        break;
                                    case "d": // Volver
                                        System.out.println("D");
                                        isOptionsRunning = false;
                                        break;
                                    default:
                                        System.out.println("Opción inválida. Intente de nuevo.");
                                        break;
                                }
                            }
                        }
                        break;
                    case "d": //Salir y guardar en CSV solamente si los datos fueron cargados previamente
                        if(listaChicos == null){
                            System.out.println("No se han cargado los datos, por lo tanto, no se guardó el archivo.");
                        } else {
                            listaChicos.exportChicosToCSV("src/main/resources/chicos.csv");
                            System.out.println("Gracias por usar nuestro serivico. Los datos han sido guardados exitosamente en el archivo 'chicos.csv'.");
                        }
                        System.out.println("Código: 2182308 | Juan David Escalante Pinilla | Autoevaluación: 4.9");
                        isRunning = false;
                        break;
                    default:
                        System.out.println("Opción inválida. Intente de nuevo.");
                        break;
                }
            }
        }
    }
}

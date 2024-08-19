package com.juandavid;

import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

/**
 * @author Juan Escalante
 */
public class ListaChico {

    // Instance variables
    private List<Chico> listaChicos;

    // Empty constructor
    public ListaChico() {
        this.listaChicos = new ArrayList<>();
    }

    // Constructor
    public ListaChico(ArrayList<Chico> listaChicos) {
        this.listaChicos = listaChicos;
    }

    // Getters & Setters
    public List<Chico> getListaChicos() {
        return listaChicos;
    }

    public void setListaChicos(ArrayList<Chico> listaChicos) {
        this.listaChicos = listaChicos;
    }

    /**
     * A partir del nombre de un archivo CSV, crea objetos Chico y los guarda en ListaChico.
     * @param fileName el nombre del archivo.
     */
    public void loadChicosFromCSV(String fileName){

        try (Reader reader = new InputStreamReader(ListaChico.class.getClassLoader().getResourceAsStream(fileName));
            CSVReader csvReader = new CSVReader(reader)){
            CsvToBean<Chico> csvToBean = new CsvToBeanBuilder<Chico>(csvReader)
            .withType(Chico.class)
            .withIgnoreLeadingWhiteSpace(true)
            .withIgnoreEmptyLine(true)
            .build();

            List<Chico> chicos = csvToBean.parse();
            this.listaChicos = new ArrayList<>(chicos);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Exporta el contenido de listaChicos en el archivo csv enviado como parametro.
     * @param filePath el path del archivo csv
     */
    public void exportChicosToCSV(String filePath){
        try (Writer writer = new FileWriter(filePath);
             CSVWriter csvWriter = new CSVWriter(writer)) {

            for (Chico chico : listaChicos) {
                String[] data = {
                    chico.getCodigo().toString(),
                    chico.getSexo(),
                    chico.getNombre(),
                    chico.getEdad().toString(),
                    chico.getCiudad().toString(),
                };
                csvWriter.writeNext(data);
            }

            System.out.println("Total chicos exportados: " + listaChicos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Imprime la lista de chicos.
     */
    public void printChicos(){
        if(listaChicos.isEmpty()){
            System.out.println("No hay chicos en la lista.");
        } else {
            for (Chico chico : listaChicos){
                System.out.println(chico);
            }
        }
    }

    /**
     * Imprime los datos de cada ciudad, su participación y su porcentaje con respecto al total de chicos.
     */
    public void printCiudades(){
        Map<Integer, Integer> totalCiudades = new HashMap<>();
        Integer totalChicos = listaChicos.size();

        for (Chico chico : listaChicos){
            Integer ciudad = chico.getCiudad();
            totalCiudades.put(ciudad, totalCiudades.getOrDefault(ciudad, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry: totalCiudades.entrySet()){
            int ciudad = entry.getKey();
            int chicosCiudad = entry.getValue();
            double porcentaje = (chicosCiudad / (double) totalChicos) * 100;

            String ciudadDisplay = "null";
            switch(ciudad){
                case 1 -> ciudadDisplay = "Bucaramanga";
                case 2 -> ciudadDisplay = "Girón";
                case 3 -> ciudadDisplay = "Floridablanca";
                case 4 -> ciudadDisplay = "Piedecuesta";
            }

            System.out.println("Ciudad: " + ciudadDisplay + " | Total: " + chicosCiudad +" | Porcentaje: " + porcentaje + "%");
        }
    }

    /**
     * Imprime los datos de los chicos en tres grupos según la edad.
     * Grupo 1: menores e iguales a 5 años
     * Grupo 2: mayor a 5 y menor e igual a 5 años
     * Grupo 3: mayor a 10 años
     */
    public void printGrupos(){
        Map<String, Integer> grupoSegunEdad = new HashMap<>();
        
        grupoSegunEdad.put("Grupo 1", 0);
        grupoSegunEdad.put("Grupo 2", 0);
        grupoSegunEdad.put("Grupo 3", 0);

        for(Chico chico: listaChicos){
            int edad = chico.getEdad();

            if(edad <= 5){
                grupoSegunEdad.put("Grupo 1", grupoSegunEdad.get("Grupo 1") + 1);
            } else if(edad > 5 && edad <= 10){
                grupoSegunEdad.put("Grupo 2", grupoSegunEdad.get("Grupo 2") + 1);
            } else {
                grupoSegunEdad.put("Grupo 3", grupoSegunEdad.get("Grupo 3") + 1);
            }
        }

        for(Map.Entry<String, Integer> entry: grupoSegunEdad.entrySet()) {
            String grupo = entry.getKey();
            int chicosGrupo = entry.getValue();

            System.out.println(grupo + ": " + chicosGrupo + " chicos.");
        }
    }

    /**
     * Agrega un Chico a listaChicos.
     * @param chico el Chico a agregar.
     */
    public void addChico(Chico newChico){
        try{
            listaChicos.add(newChico);
            System.out.println("El chico fue agregado exitosamente.");
        } catch (Exception e) {
            System.out.println("No se pudo agregar el chico: " + e);
        }
    }

    /**
     * Elimina a un Chico de listaChicos.
     * @param chico el Chico a eliminar.
     */
    public void deleteChico(Chico chico){
        if(listaChicos.contains(chico)){
            listaChicos.remove(chico);
            System.out.println("El chico fue eliminado satisfactoriamente.");
        } else {
            System.out.println("El chico no existe - no se pudo eliminar.");
        }
    }

    /**
     * Busca un chico en listaChicos a partir del código.
     * @param codigo el código del Chico a buscar
     * @return el Chico encontrado
     */
    public Chico findChicoByCodigo(Integer codigo){
        Chico foundChico = null;
        
        for(Chico chico: listaChicos){
            if(codigo.equals(chico.getCodigo())){
                return chico;
            }
        }
        // Returns null if no Chico was found
        return foundChico;
    }
}

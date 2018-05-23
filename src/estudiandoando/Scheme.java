/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiandoando;
import java.util.ArrayList;

/**
 *
 * @author Juan_Ardila
 */
public class Scheme {
    
    private String name;
    private ArrayList<Table> tables;

    public Scheme(String name) {
        this.name = name;
        this.tables= new ArrayList();
    }
    
    public void AgregarTablas(Table s){
        tables.add(s);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Table> getTables() {
        return tables;
    }
    
    public void ImprimirTodo(){
        for (Table table : tables) {
            System.out.println(table.getName() + " contiene: ");
            System.out.println("Columnas: ");
            for (Column columna : table.getColumnas()) {
                System.out.println(" - "+columna.getName()+ " " + columna.getDataType());
            }
            System.out.println("Llaves: ");
            for (Key llave : table.getLlaves()){
                System.out.println(" - "+llave.getName()+" "+llave.getDataType());
            }
            System.out.println("Llaves Foraneas: ");
            for (ForeignKey extranjero : table.getLlavesEx()){
                System.out.println(" - "+extranjero.getName() + " " + extranjero.getDataType());
            }
            System.out.println("\n");
        }
    }
    
}

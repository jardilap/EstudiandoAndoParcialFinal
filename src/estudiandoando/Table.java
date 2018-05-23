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
public class Table{
    
    private String name;
    private ArrayList<ForeignKey> llavesEx;
    private ArrayList<Key> llaves;
    private ArrayList<Column> columnas;

    public Table(String name, Key llave, Column columna) {
        this.name = name;
        this.columnas=new ArrayList();
        this.llaves=new ArrayList();
        this.llavesEx=new ArrayList();
        llaves.add(llave);
        columnas.add(columna);
    }
    
    public void AgregarLlavesEx(ForeignKey s){
        llavesEx.add(s);
    }
    public void AgregarLlaves(Key s){
        llaves.add(s);
    }
    public void AgregarColumna(Column s){
        columnas.add(s);
    }

    public String getName() {
        return name;
    }

    public ArrayList<ForeignKey> getLlavesEx() {
        return llavesEx;
    }

    public ArrayList<Key> getLlaves() {
        return llaves;
    }

    public ArrayList<Column> getColumnas() {
        return columnas;
    }
    
    
}

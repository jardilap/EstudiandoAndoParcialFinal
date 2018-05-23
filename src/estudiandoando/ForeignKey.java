/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudiandoando;

/**
 *
 * @author Juan_Ardila
 */
public class ForeignKey extends Column{
    private Table tabla;
    public ForeignKey(String name, String dataType, Table tabla) {
        super(name, dataType);
        this.tabla = tabla;
    }

    public Table getTabla() {
        return tabla;
    }

    
    
}

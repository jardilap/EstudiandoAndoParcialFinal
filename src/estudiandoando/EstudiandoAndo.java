
package estudiandoando;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class EstudiandoAndo {

    private static final Scheme s = new Scheme("Esquema");
    public static void main(String[] args) {
        
        
        /*
        //Table 1
        Key k1 = new Key("Paul", "String");
        Column c1 = new Column("1", "Int");
        Table t1 = new Table("Tabla 1", k1, c1);
        
        //Table 2
        Key k2 = new Key("Juan", "String");
        Column c2 = new Column("2", "Int");
        Table t2 = new Table("Tabla 2", k2, c2);
        ForeignKey f1 = new ForeignKey("John 117", "Spartan", t2);
        t2.AgregarLlavesEx(f1);
        
        //llaves y columnas
        
        Key k3 = new Key("Arbiter", "Sangheili");
        Key k4 = new Key("William", "Nigga");
        Column c3 = new Column("Columna", "Int");
        
        //Agregacion
        t1.AgregarLlaves(k4);
        t1.AgregarLlaves(k3);
        t2.AgregarColumna(c3);
        s.AgregarTablas(t1);
        s.AgregarTablas(t2);
        */
        
        CargarArchivo();
        
        s.ImprimirTodo();
        
        System.out.println("Columnas Existentes: ");
        for (Column c : eC) {
            System.out.println(" - "+c.getName());
        }
        System.out.println("Tablas con Foreign Keys: ");
        for (Table f : fTables) {
            System.out.println(" - "+f.getName());
            
        }
        SubirArchivo();
        
        
    }
    private static ArrayList<Table> fTables= new ArrayList();
    private static ArrayList<Column> eC= new ArrayList();
    
    public static void SubirArchivo(){
        File archivo = new File("info2.txt");
        PrintStream writer = null;
        try {
            writer= new PrintStream(archivo);
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
        
        for (Table table : s.getTables()) {
            writer.println(table.getName() + ", "+ table.getColumnas().size()+", "+table.getLlaves().size()+", "+table.getLlavesEx().size());
            for (Column columna : table.getColumnas()) {
                writer.println(columna.getName()+ ", " + columna.getDataType());
            }
            for (Key llave : table.getLlaves()){
                writer.println(llave.getName()+ ", " + llave.getDataType());
            }
            for (ForeignKey extranjero : table.getLlavesEx()){
                writer.println(extranjero.getName()+ ", " + extranjero.getDataType());
            }
        }
    }
    
    
    public static void CargarArchivo(){
        File archivo = new File("info.txt");
        String linea;
        
        
            Scanner reader;
            try{
                reader = new Scanner(archivo);
                while(reader.hasNextLine()){
                    linea = reader.nextLine();
                    String list[] = linea.split(",");
                    
                    String nColumns= list[1].trim();
                    int nC=Integer.parseInt(nColumns);
                    ArrayList<Column> ArrayC= new ArrayList();

                    String nKey= list[2].trim();
                    int nK=Integer.parseInt(nKey);
                    ArrayList<Key> ArrayK= new ArrayList();

                    String nForeign= list[3].trim();
                    int nF=Integer.parseInt(nForeign);
                    ArrayList<ForeignKey> ArrayF= new ArrayList();
                    
                    if(nC>0){
                        for(int i=0;i<nC;i++){
                            linea = reader.nextLine();
                            String listC[] = linea.split(",");
                            String name= listC[0];
                            String type= listC[1].trim();
                            Column c= new Column(name, type);
                            ArrayC.add(c);
                            if(!eC.contains(c)){
                                eC.add(c);
                            }
                        }
                    }
                    if(nK>0){
                        for(int i=0;i<nK;i++){
                            linea = reader.nextLine();
                            String listK[] = linea.split(",");
                            String name= listK[0];
                            String type= listK[1].trim();
                            Key k= new Key(name, type);
                            ArrayK.add(k);
                        }
                    }
                    
                    Table t1 = new Table(list[0], ArrayK.get(0), ArrayC.get(0));
                    
                    
                    for(int i=0;i<nF;i++){
                        linea = reader.nextLine();
                        String listF[] = linea.split(",");
                        String name= listF[0];
                        String type= listF[1].trim();
                        ForeignKey f= new ForeignKey(name, type, t1);
                        t1.AgregarLlavesEx(f);
                        if(!fTables.contains(t1)){
                            fTables.add(t1);
                        }
                    }
                    for(int i = 1; i<ArrayC.size(); i++){
                        t1.AgregarColumna(ArrayC.get(i));
                    }
                    for(int i = 1; i<ArrayK.size(); i++){
                        t1.AgregarLlaves(ArrayK.get(i));
                    }
                    
                    s.AgregarTablas(t1);
                }
                
                
            }catch(FileNotFoundException e){
                System.err.println("No se encontró el archivo");
            }
            
        
    }
}

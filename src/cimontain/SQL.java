/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cimontain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Famil
 */
public class SQL {
    private static Connection Conexion;
    
    //Conexcion con la BD
    public void MySQLConnection(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            System.out.println("Se ha iniciado la conexión con el servidor de forma exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Cerrar conexcion a la Base de Datos
    public void closeConnection() {
        try {
            Conexion.close();
            System.out.println("Se ha finalizado la conexión con el servidor");
        } catch (SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Crear BD
    public void CrearBD(String BD_Nombre,String BD_Contraseña, String BD_User){
        try{
            String Query = "CREATE DATABASE " + BD_Nombre;
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            MySQLConnection(BD_User, BD_Contraseña, BD_Nombre);
            JOptionPane.showMessageDialog(null, "Se ha creado la base de datos " + BD_Nombre + " de forma exitosa");
        }catch(SQLException ex){
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Crear Tabla Login
    public void createTable_L(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE Login"
                    + "(User VARCHAR(15),Nombre VARCHAR(10),"
                    + " Contraseña VARCHAR(20))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Login de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    //Crear Tabla Inventario
    public void createTable_I(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE Inventario"
                    + "(Clave_P VARCHAR(8),Nombre_P VARCHAR(25),Cantidad INTEGER,Tipo_P VARCHAR(20),Sector_P VARCHAR(10) "
                    + ",PRIMARY KEY(Clave_P))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Inventario de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    //Crear Tabla Compra
    public void createTable_C(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE Compra"
                    + "(Cantidad_C INTEGER,Gasto_C INTEGER,Fecha_C DATE,Clave_P VARCHAR(8),FOREIGN KEY(Clave_P) REFERENCES Inventario(Clave_P))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Compra de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Crear Tabla Compra Externa
    public void createTable_C_E(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE Compra_Ex"
                    + "(Cantidad_C INTEGER,Gasto_C INTEGER,Fecha_C DATE,Descripcion VARCHAR(20))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Compra_Externa de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //ejemplo
     public void createTableejem(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE ejemplo"
                    + "(usuario INTEGER,clave_inv INTEGER,Fecha_C DATE,Descripcion VARCHAR(20))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla ejemplo de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Crear Tabla Venta
    public void createTable_V(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE Venta"
                    + "(Cantidad_V INTEGER,Cobro_Total_V INTEGER,Descuento_V INTEGER,Fecha_V DATE,Clave_P VARCHAR(8),FOREIGN KEY(Clave_P) REFERENCES Inventario(Clave_P))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Venta de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Crear Tabla Precios  
    public void createTable_P(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE Precios"
                    + "(Clave_Pr VARCHAR(10),Precio_Pr INTEGER,Cantidad_Pr INTEGER,Cantidad_D_Pr INTEGER,Precio_D_Pr INTEGER,Clave_P VARCHAR(8),PRIMARY KEY(Clave_Pr),FOREIGN KEY(Clave_P) REFERENCES Inventario(Clave_P))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Precios de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //Insertar Datos en Tabla Login
    public void insertData_L(String User, String Nombre, String Contraseña) {
        try {
            String Query = "INSERT INTO Login VALUES("
                    + "\"" + User + "\","
                    + "\"" + Nombre + "\","
                    + "\"" + Contraseña + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha registrado al nuevo usuario " + Nombre + " de forma exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Insertar Datos en Tabla Inventario
    public void insertData_I(String Clave_P, String Nombre_P,String Cantidad_P,String Tipo_P,String Sector_P) {
        try {
            String Query = "INSERT INTO Inventario VALUES("
                    + "\"" + Clave_P + "\","
                    + "\"" + Nombre_P + "\","
                    + "\"" + Cantidad_P + "\","
                    + "\"" + Tipo_P + "\","
                    + "\"" + Sector_P + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha registrado un nuevo producto: " + Nombre_P + " de forma exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Insertar Datos en Tabla Compra
    public void insertData_C(String Cantidad_C, String Gasto_C,String Fecha_C,String Clave_P) {
        try {
            String Query = "INSERT INTO Compra VALUES("
                    + "\"" + Cantidad_C + "\","
                    + "\"" + Gasto_C + "\","
                    + "\"" + Fecha_C + "\","
                    + "\"" + Clave_P + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha registrado su nueva Compra.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Insertar Datos en Tabla Compra Externo
    public void insertData_C_E(String Cantidad_C, String Gasto_C,String Fecha_C,String Descripcion) {
        try {
            String Query = "INSERT INTO Compra_Ex VALUES("
                    + "\"" + Cantidad_C + "\","
                    + "\"" + Gasto_C + "\","
                    + "\"" + Fecha_C + "\","
                    + "\"" + Descripcion + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha registrado su nueva Compra.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Insertar Datos en Tabla Venta
    public void insertData_V(String Cantidad_V, String Cobro_Total_V,String Descuento_V,String Fecha_V,String Clave_P) {
        try {
            String Query = "INSERT INTO Venta VALUES("
                    + "\"" + Cantidad_V + "\","
                    + "\"" + Cobro_Total_V + "\","
                    + "\"" + Descuento_V + "\","
                    + "\"" + Fecha_V + "\","
                    + "\"" + Clave_P+ "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha registrado la Venta.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Insertar Datos en Tabla Precios
    public void insertData_P(String Clave_Pr,String Precio_Pr, String Cantidad_Pr,String Cantidad_D_Pr,String Precio_D_Pr,String Clave_P) {
        try {
            String Query = "INSERT INTO precios VALUES("
                    + "\"" + Clave_Pr + "\","
                    + "\"" + Precio_Pr + "\","
                    + "\"" + Cantidad_Pr + "\","
                    + "\"" + Cantidad_D_Pr + "\","
                    + "\"" + Precio_D_Pr + "\","
                    + "\"" + Clave_P + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);            
            JOptionPane.showMessageDialog(null, "Se ha registrado los Precios de venta del producto.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Comparacion de datos(Inicio de Sesion)
    public static void L_L(String datos[],String BD_User, String BD_Contraseña, String BD_Nombre){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + BD_Nombre, BD_User, BD_Contraseña);
        Statement instruccionSQL = Conexion.createStatement();
        ResultSet resultadosConsulta = instruccionSQL.executeQuery ("SELECT * FROM Login WHERE User='"+datos[0]+"' AND Contraseña='"+datos[1]+"'");
        if(resultadosConsulta.first()){
            JOptionPane.showMessageDialog(null,"Binvenido " + datos[0]);
            Interfaz_Completa1 m = new Interfaz_Completa1();
            m.setVisible(true);
        }else{
            JOptionPane.showMessageDialog(null,"Usuario y contraseña no encontrado");
        }
        }catch(SQLException e){
         javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
     }  catch (ClassNotFoundException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    
    //Obtener Datos de la Base Login y Poner En tabla con autocarga
    /*public void cargartabla_I(){
        try{
            String titulos[] = {"Id_P","Clave_P","Nombre_P","Catidad_P","Tipo_P","Secto_P","Fecha_Cad_P"};
            m = new DefaultTableModel(null,titulos);
            String fila[] = new String[6];
            SQL obj = new SQL();
            String consulta = "SELECT * FROM registros";
            ResultSet r;
            r = obj.Listar(consulta, "root", "", "MySQL_Test");
            while (r.next()){
                fila[0] = r.getString(1);
                fila[1] = r.getString(2);
                fila[2] = r.getString(3);
                fila[3] = r.getString(4);
                fila[4] = r.getString(5);
                fila[5] = r.getString(6);
                m.addRow(fila);
            }
            Tabla_BD.setModel(m);
            this.Tabla_BD.setModel(m);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al Obtener los datos","Advertencia",JOptionPane.WARNING_MESSAGE);
        }
    }*/
    
    //Obtener lista de datos
    public ResultSet Listar(String Cad,String user, String pass, String db_name){
     try{
         Class.forName("com.mysql.jdbc.Driver");
         Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);

         PreparedStatement da = Conexion.prepareStatement(Cad);
         ResultSet tbl = da.executeQuery();
         return tbl;
     }catch(ClassNotFoundException | SQLException e){
         javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
         return null;
     }
    }

    private void dispose() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //Crear tabla compra temporal 
   public void Temporal_C(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE TCompra"
                    + "(Cantidad_C INTEGER,Gasto_C INTEGER,Fecha_C DATE,Clave_P VARCHAR(8))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Compra de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   //CRear tabla temporal de compra externa
   public void Temporal_C_E(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE TCompra_Ex"
                    + "(Cantidad_C INTEGER,Gasto_C INTEGER,Fecha_C DATE,Descripcion VARCHAR(20))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Compra_Externa de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
    public void TC(String Cantidad_C, String Gasto_C,String Fecha_C,String Clave_P) {
        try {
            String Query = "INSERT INTO TCompra VALUES("
                    + "\"" + Cantidad_C + "\","
                    + "\"" + Gasto_C + "\","
                    + "\"" + Fecha_C + "\","
                    + "\"" + Clave_P + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha registrado su nueva Compra.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Insertar Datos en Tabla Compra Externo
    public void In_T_CE(String Cantidad_C, String Gasto_C,String Fecha_C,String Descripcion) {
        try {
            String Query = "INSERT INTO TCompra_Ex VALUES("
                    + "\"" + Cantidad_C + "\","
                    + "\"" + Gasto_C + "\","
                    + "\"" + Fecha_C + "\","
                    + "\"" + Descripcion + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha registrado su nueva Compra.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }    
        
    
    //Tabla de listas
    /*public void CTabla_Listas(String user, String pass, String db_name){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE TLista"
                    + "(Ventas INTEGER,Compras INTEGER,Listado INTEGER)";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Compra_Externa de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }*/
    
    //llenado de listas
    /*public void LlenadoL(String Ventas,String Compras,String Lista){
        try {
            String Query = "INSERT INTO TCompra_Ex VALUES("
                    + "\"" + Ventas + "\","
                    + "\"" + Compras + "\","
                    + "\"" + Lista + "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha registrado su nueva Compra.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }*/
           public void createTable_tV(String user, String pass, String db_name) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
            String Query = "CREATE TABLE tVenta"
                    + "(Cantidad_V INTEGER,Cobro_Total_V INTEGER,Descuento_V INTEGER,Fecha_V DATE,Clave_P VARCHAR(8))";
            JOptionPane.showMessageDialog(null, "Se ha creado la tabla Venta de forma exitosa");
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
        } catch (ClassNotFoundException|SQLException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
    public void insertData_tV(String Cantidad_V, String Cobro_Total_V,String Descuento_V,String Fecha_V,String Clave_P) {
        try {
            String Query = "INSERT INTO tVentas VALUES("
                    + "\"" + Cantidad_V + "\","
                    + "\"" + Cobro_Total_V + "\","
                    + "\"" + Descuento_V + "\","
                    + "\"" + Fecha_V + "\","
                    + "\"" + Clave_P+ "\")";
            Statement st = Conexion.createStatement();
            st.executeUpdate(Query);
            JOptionPane.showMessageDialog(null, "Se ha registrado la Venta.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
    
    //Actualizar Datos de Base de Datos
     public static void Actualizar(String[] datos,String user, String pass, String db_name){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
        
        String query = "UPDATE Precios set Clave_Pr=?,Precio_Pr=?,Cantidad_Pr=?,Cantidad_D_Pr=?,Precio_D_Pr=?,Clave_P=? WHERE Clave_Pr=? AND Clave_P=?";
        PreparedStatement da = Conexion.prepareStatement(query);
        da.setString(1,datos[0]);
        da.setString(2,datos[1]);
        da.setString(3,datos[2]);
        da.setString(4,datos[3]);
        da.setString(5,datos[4]);
        da.setString(6,datos[5]);
        da.setString(7,datos[6]);
        da.setString(8,datos[7]);
        da.executeUpdate();
        JOptionPane.showMessageDialog(null, "Se ha registrado forma exitosa");
        }catch(SQLException e){
         javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
     }  catch (ClassNotFoundException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     
     //Actualizar Tabla Inventario conforme ventas
     public static void Actualizar1(String[] datos,String user, String pass, String db_name){
        try{
        Class.forName("com.mysql.jdbc.Driver");
        Conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, user, pass);
        String query = "UPDATE Inventario set Cantidad=? WHERE Clave_P=?";
        PreparedStatement da = Conexion.prepareStatement(query);
        da.setString(1,datos[0]);
        da.setString(2,datos[1]);
        da.executeUpdate();
        }catch(SQLException e){
         javax.swing.JOptionPane.showMessageDialog(null, e.getMessage());
     }  catch (ClassNotFoundException ex) {
            Logger.getLogger(SQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
    }
   


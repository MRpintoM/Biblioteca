
package BaseDatos;
import BaseDatos.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author zeus
 */
public class BS_formu {
    
    private Conexion conn;
    private Connection cn;
    private PreparedStatement prstmt = null;
    private ResultSet result = null;
                StringBuffer respuesta =  new StringBuffer();
   
    public BS_formu(){
        conn= new Conexion();
        cn=conn.conectar();
        
    }
         public String registro_autor (String ID_AUTOR, String NOMBRE_AUTOR ){
        String sql = "INSERT INTO B_REGISTRO_AUTOR ( ID_AUTOR, NOMBRE_AUTOR )";
        sql += "VALUES(?,?)";
        System.out.println(ID_AUTOR);
        System.out.println(sql);
            
            
                
        
        try {                    
            prstmt = cn.prepareStatement(sql);
            prstmt.setString(1, ID_AUTOR);
            prstmt.setString(2, NOMBRE_AUTOR);
           
            
            
            int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                   return "1";
                }else{
                     return "0";
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.contains("ORA-00001")){
                //salida.append("ORA-00001");
                  return "ORA-00001";
            }else{
                //salida.append(error);
                  return "error al guardar";
            }
        }
     }

     
     
      public String registro_editorial (String ID_EDITORIAL, String NOMBRE_EDITORIAL ){
        String sql = "INSERT INTO B_REGISTRO_EDITORIAL ( ID_EDITORIAL, NOMBRE_EDITORIAL )";
        sql += "VALUES(?,?)";
        System.out.println(ID_EDITORIAL);
        System.out.println(sql);
            
                
        
        try {                    
            prstmt = cn.prepareStatement(sql);
            prstmt.setString(1, ID_EDITORIAL);
            prstmt.setString(2, NOMBRE_EDITORIAL);
            
            
            int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                   return "1";
                }else{
                     return "0";
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.contains("ORA-00001")){
                //salida.append("ORA-00001");
                  return "ORA-00001";
            }else{
                //salida.append(error);
                  return "error al guardar";
            }
        }
      }
      
          
    
      
       public String registro_categoria (String ID_CATEGORIA, String CATEGORIA_LIB ){
        String sql = "INSERT INTO B_CATEGORIA_LIB ( ID_CATEGORIA, CATEGORIA_LIB )";
        sql += "VALUES(?,?)";
        System.out.println(ID_CATEGORIA);
        System.out.println(sql);
            
                
        
        try {                    
            prstmt = cn.prepareStatement(sql);
            prstmt.setString(1, ID_CATEGORIA);
            prstmt.setString(2, CATEGORIA_LIB);
            
            
            int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                   return "1";
                }else{
                     return "0";
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.contains("ORA-00001")){
                //salida.append("ORA-00001");
                  return "ORA-00001";
            }else{
                //salida.append(error);
                  return "error al guardar";
            }
        }
    }
        
    public String registro_libro (String ID_LIBRO, String NOMBRE_LIBRO, String B_ID_AUTOR, String B_ID_EDITORIAL, String B_ID_CATEGORIA ){
        String sql = "INSERT INTO B_REGISTRO_LIBRO ( ID_LIBRO, NOMBRE_LIBRO, B_ID_AUTOR, B_ID_EDITORIAL, B_ID_CATEGORIA )";
        sql += "VALUES(?,?,?,?,?)";
        System.out.println(ID_LIBRO);
        System.out.println(sql);
        
        try {                    
            prstmt = cn.prepareStatement(sql);
            prstmt.setString(1, ID_LIBRO);
            prstmt.setString(2, NOMBRE_LIBRO);
            prstmt.setString(3, B_ID_AUTOR);
            prstmt.setString(4, B_ID_EDITORIAL);
            prstmt.setString(5, B_ID_CATEGORIA);
            
           
            
            int resultado = prstmt.executeUpdate(); 
                if(resultado > 0){
                   return "1";  
                }else{
                     return "0";
                }
        }catch(SQLException e){
            String error = e.getMessage();  
            if(error.indexOf("ORA-00001") != -1){
                //salida.append("ORA-00001");
                  return "ORA-00001";
            }else{
                //salida.append(error);
                  return "error al guardar";
            }
        }
    }
    

        public StringBuffer Tablas_Autor()
    {
        String sql= "SELECT * FROM B_REGISTRO_AUTOR ";
      
                
            System.out.println(sql);
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("ID_AUTOR")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_AUTOR")).append("</td>");
              
                
                respuesta.append("</tr>");}
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        } 
        
  
        public StringBuffer Tablas_Edit()
    {
        String sql= "SELECT * FROM B_REGISTRO_EDITORIAL ";
      
                
            System.out.println(sql);
            
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("ID_EDITORIAL")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_EDITORIAL")).append("</td>");
              
                respuesta.append("</tr>");}
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        }

        
              
        public StringBuffer Tablas_Categoria()
    {
        String sql= "SELECT * FROM B_CATEGORIA_LIB ";
      
                
            System.out.println(sql);
            
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("ID_CATEGORIA")).append("</td>");
                respuesta.append("<td >").append(result.getString("CATEGORIA_LIB")).append("</td>");
              
                respuesta.append("</tr>");}
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        }
        
             public StringBuffer Tabla_Libro()
    {
        String sql= "SELECT * FROM B_REGISTRO_LIBRO ";
      
                
            System.out.println(sql);
            
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("ID_LIBRO")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_LIBRO")).append("</td>");
                respuesta.append("<td >").append(result.getString("B_ID_AUTOR")).append("</td>");
                respuesta.append("<td >").append(result.getString("B_ID_EDITORIAL")).append("</td>");
                respuesta.append("<td >").append(result.getString("B_ID_CATEGORIA")).append("</td>");
               
                respuesta.append("</tr>");}
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        }
        
        
             
             public StringBuffer Tabla_R_Lib()
    {
        String sql= "SELECT ID_LIBRO,NOMBRE_LIBRO, NOMBRE_AUTOR, NOMBRE_EDITORIAL,CATEGORIA_LIB FROM b_registro_libro INNER JOIN b_registro_autor on b_registro_libro.b_id_autor = b_registro_autor.id_autor\n"+
            "INNER JOIN b_registro_editorial ON b_registro_libro.b_id_editorial=b_registro_editorial.id_editorial\n"+
            "INNER JOIN b_categoria_lib ON b_registro_libro.b_id_categoria=b_categoria_lib.id_categoria\n"+
            "WHERE b_registro_libro.nombre_libro LIKE '%'\n"+
            "and b_registro_libro.nombre_libro LIKE '%' ORDER by b_registro_libro.nombre_libro"; 
            
            System.out.println(sql);
            
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("ID_LIBRO")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_LIBRO")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_AUTOR")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_EDITORIAL")).append("</td>");
                respuesta.append("<td >").append(result.getString("CATEGORIA_LIB")).append("</td>");
               
                respuesta.append("</tr>");}
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        }
            
             
               public StringBuffer Buscar()
    {
        String sql= "SELECT ID_LIBRO, NOMBRE_AUTOR,NOMBRE_LIBRO, NOMBRE_EDITORIAL,CATEGORIA_LIB FROM b_registro_libro INNER JOIN b_registro_autor on b_registro_libro.b_id_autor = b_registro_autor.id_autor\n"+
            "INNER JOIN b_registro_editorial ON b_registro_libro.b_id_editorial=b_registro_editorial.id_editorial\n"+
            "INNER JOIN b_categoria_lib ON b_registro_libro.b_id_categoria=b_categoria_lib.id_categoria\n"+
            "WHERE b_registro_autor.nombre_autor like '%'"; 
            
      
                
            System.out.println(sql);
            
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("ID_LIBRO")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_LIBRO")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_AUTOR")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_EDITORIAL")).append("</td>");
                respuesta.append("<td >").append(result.getString("CATEGORIA_LIB")).append("</td>");
               
                respuesta.append("</tr>");}
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        }
             
             
             
                 public StringBuffer Tabla_R_aut()
    {
        String sql= "SELECT ID_LIBRO, NOMBRE_AUTOR,NOMBRE_LIBRO, NOMBRE_EDITORIAL,CATEGORIA_LIB FROM b_registro_libro INNER JOIN b_registro_autor on b_registro_libro.b_id_autor = b_registro_autor.id_autor\n"+
            "INNER JOIN b_registro_editorial ON b_registro_libro.b_id_editorial=b_registro_editorial.id_editorial\n"+
            "INNER JOIN b_categoria_lib ON b_registro_libro.b_id_categoria=b_categoria_lib.id_categoria\n"+
            "WHERE b_registro_autor.nombre_autor like '%' ORDER BY b_registro_autor.nombre_autor";
            
           
            System.out.println(sql);
            
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("ID_LIBRO")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_AUTOR")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_LIBRO")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE_EDITORIAL")).append("</td>");
                respuesta.append("<td >").append(result.getString("CATEGORIA_LIB")).append("</td>");
               
                respuesta.append("</tr>");}
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        }
           
             
              
                      
     public StringBuffer Tablas_Relacionadas()
    {
        String sql= "SELECT * FROM PRODUCTO ";
      
                
            System.out.println(sql);
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<tr>");
                respuesta.append("<td >").append(result.getString("ID_PRODUCTO")).append("</td>");
                respuesta.append("<td >").append(result.getString("NOMBRE")).append("</td>");
                respuesta.append("<td >").append(result.getString("CANTIDAD")).append("</td>");
                respuesta.append("<td >").append(result.getString("PRECIO")).append("</td>");
                
                respuesta.append("</tr>");}
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        System.out.println(respuesta);
        return respuesta;
        } 
        
         public StringBuffer MostrarCategoria()
    {
        String sql= "SELECT * FROM CATEGORIA ";
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<option >").append(result.getString("ID_CATEGORIA")).append("</option>");
                }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        System.out.println(respuesta);
        return respuesta;
        }
         
         
            public StringBuffer MostrarMarca()
    {
        String sql= "SELECT * FROM MARCA ";
        try{
        prstmt = cn.prepareStatement(sql);                        
        result = prstmt.executeQuery();            
                while (result.next()){
                respuesta.append("<option >").append(result.getString("ID_MARCA")).append("</option>");
                
                }
        }
        catch(SQLException ex){
            ex.printStackTrace();
        }
        System.out.println(respuesta);
        return respuesta;
        }
        
      
        
        

        /* public StringBuffer MostrarSecciones(){
        prstmt=null;
        result=null;
        try{
        String sql = "SELECT * FROM DATOS_REGISTRO INNER JOIN DATOS_ESTUDIANTE "+"  ON  DATOS_REGISTRO.ID_CARNE= datos_estudiante.carne";
        prstmt=cn.prepareStatement(sql);
        result=prstmt.executeQuery();
        respuesta.append("<option> HOla Mundo</option>");
        while(result.next()){
       respuesta.append("<option> ").append(result.getString("ID_CARNE")).append(" </option>");
       respuesta.append("<option> ").append(result.getString("NOMBRE_Y_APELLIDO")).append(" </option>");
       respuesta.append("<option> ").append(result.getString("CORREO_ELEC")).append(" </option>");
       respuesta.append("<option> ").append(result.getString("TELEFONO")).append(" </option>");
       respuesta.append("<option> ").append(result.getString("ID_GRADO")).append(" </option>");
       respuesta.append("<option> ").append(result.getString("ID_SECCION")).append(" </option>");
       
       
        }
        
        
        }catch(SQLException e){
       String error=e.getMessage();
       if(error.indexOf("ORA-00001")!=-1){
       return respuesta.append(error);
       }else{
       return respuesta.append(error);
       }
       }
        return respuesta;
 
       } */      
    
        
}
            
        
        

    
        
        
        
         
               
    
           

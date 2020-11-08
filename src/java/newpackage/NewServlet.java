/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import BaseDatos.BS_formu;
import BaseDatos.Conexion;
import java.io.IOException;
import java.io.Writer;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author zeus
 */
@WebServlet(name = "NewServlet", urlPatterns = {"/NewServlet"})
public class NewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Conexion conexion = new Conexion();
        conexion.conectar();
        
        Writer ajaxSalir = response.getWriter();  
        BS_formu bd_form = new BS_formu();
        StringBuilder respuestaBS = new StringBuilder(); 
        
        response.setContentType("text/html;charset=UTF-8");
        try {
                String comando= request.getParameter("comando");
                    switch(comando){
                
                        case  "registro_autor":
                            String var1 = request.getParameter("idautor");
                            String var2 = request.getParameter("nomautor");
                            String respuesta1 =(bd_form.registro_autor(var1,var2));
                            response.getWriter().print(respuesta1);
               
                        break;
                        case "registro_editorial":
                            String var3 = request.getParameter("idedito");
                            String var4 = request.getParameter("nomedito");
                            String respuesta2 =(bd_form.registro_editorial(var3,var4));
                            response.getWriter().print(respuesta2);
                        break;
                        case "registro_categoria":
                            String var5 = request.getParameter("idcatego");
                            String var6 = request.getParameter("nomcat");
                            String respuesta3 =(bd_form.registro_categoria(var5,var6));
                            response.getWriter().print(respuesta3);
                        break;
                
                        case "registro_libro":
                    
                            String var7 = request.getParameter("nocodig");
                            String var8 =  request.getParameter("nombrelib");
                            String var9 = request.getParameter("idautor");
                            String var10 =  request.getParameter("idedito");
                            String var11 = request.getParameter("idcatego");
                            
                            String respuesta4 =(bd_form.registro_libro(var7, var8,var9, var10, var11));
                            response.getWriter().print(respuesta4);
                        break; 
            
                        case "Tablas_Autor":

                            respuestaBS.append(bd_form.Tablas_Autor());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                        
                        case "Tablas_Edit":

                            respuestaBS.append(bd_form.Tablas_Edit());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                        
                        case "Tablas_Categoria":

                            respuestaBS.append(bd_form.Tablas_Categoria());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                        case "Tabla_Libro":

                            respuestaBS.append(bd_form.Tabla_Libro());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                        
                        case "Tabla_R_aut":

                            respuestaBS.append(bd_form.Tabla_R_aut());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;     
                        
                         case "Buscar":

                            respuestaBS.append(bd_form.Buscar());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                        
                        
                        case "Tabla_R_Lib":

                            respuestaBS.append(bd_form.Tabla_R_Lib());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                   
                        case "MostrarMarca":
                            respuestaBS.append(bd_form.MostrarMarca());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
                   
                         case "MostrarCategoria":
                            respuestaBS.append(bd_form.MostrarCategoria());
                            System.out.println(respuestaBS);
                            ajaxSalir.write(respuestaBS.toString());
                            ajaxSalir.flush();
                            ajaxSalir.close();
                        break;
            
          
        }
            }catch(Exception e){
                e.getMessage();}
        
      
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

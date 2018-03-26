
package AcessoEscolar;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lucas Carvalho
 */
@WebServlet(name = "CadastraNotasServlet", urlPatterns = {"/CadastraNotasServlet"})
public class CadastraNotasServlet extends HttpServlet {
 ArrayList <Aluno> bobaes = new ArrayList <Aluno>();
 
 @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
  
        try{
            boolean nota1t, trabalhot, frequenciat, projetot, pft;
            
            
            double nota1 = Double.parseDouble((String)req.getParameter("Nota 1"));
            double trabalho = Double.parseDouble((String)req.getParameter("Trabalho"));
            double frequencia = Double.parseDouble((String)req.getParameter("Frequencia"));
            double projeto = Double.parseDouble((String)req.getParameter("Projeto"));
            double pf = Double.parseDouble((String)req.getParameter("Prova Final"));
            double m1 = (0.7*((nota1+trabalho)/2))+(projeto*0.3);
            String nome = (String)req.getParameter("Nome");
            String situacao;
            
          
            if(nota1>=0 && nota1 <=10){
                nota1t=true;
                
            }else{
                nota1t=false;
                req.setAttribute("Errnota1","Valor da Nota deve ser entre 0 e 10");}
                
                
            if(trabalho>=0 && trabalho <=10){
                trabalhot=true;
               
            }else{
                trabalhot=false;
                req.setAttribute("Errtrab","Valor do Trabalho deve ser entre 0 e 10");
            }
            
            
            if(frequencia>=0 && frequencia <=100){
                frequenciat=true;
                
            }else{
                frequenciat=false;
                req.setAttribute("Errfreq","Valor da Frequencia deve ser entre 0 e 10");
            }
            
            if(projeto>=0 && projeto <=10){
                projetot=true;
              
            }else{
                projetot=false;
                req.setAttribute("Errproj","Valor do Projeto deve ser entre 0 e 10");
            }
            
            if(pf>=0 && pf <=10){
                pft=true;
               
            }else{
                pft=false;
                req.setAttribute("Errpf","Valor da PF deve ser entre 0 e 10");
            }
                
            
            
            
            
            if(frequencia >= 75){
                if(m1 >=7){
                    situacao = "Aprovado";
                }
                else if(m1 < 3){  
                    situacao = "Reprovado";
                }
                else{
                    if(((pf + m1)/2)>=5){  
                        situacao = "Aprovado";
                    }
                    else{
                        situacao = "Reprovado";
                    }
                }
            }
            else{
                situacao = "Reprovado";
            }
            
            if(nota1t && trabalhot && frequenciat && projetot && pft){
            Aluno bobao = new Aluno(nome,nota1,trabalho,projeto,frequencia,pf,situacao);
            bobaes.add(bobao);
            req.setAttribute("bobaes",bobaes);
            req.getRequestDispatcher("TabelaAlunos.jsp").forward(req, resp);
            }else{
                
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            }
           
            
           
        }
        catch(Exception e){
            
            return;
        }

        

     
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp); 
    }
   
    
    
}

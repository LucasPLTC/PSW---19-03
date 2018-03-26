<%-- 
    Document   : index
    Created on : 26/03/2018, 18:07:29
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastre Notas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <form action ="CadastraNotasServlet" method ="POST">
            Nome: <input type ="text" name="Nome" ><br>
            Nota 1: <input type ="text" name="Nota 1"><%= request.getAttribute("Errnota1") != null ? request.getAttribute("Errnota1") : "" %><br>
            Trabalho: <input type ="text" name="Trabalho"><%= request.getAttribute("Errtrab") != null ? request.getAttribute("Errtrab") : "" %><br>
            Frequencia: <input type ="text" name="Frequencia"><%= request.getAttribute("Errfreq") != null ? request.getAttribute("Errfreq") : "" %><br>
            Projeto: <input type ="text" name="Projeto"><%= request.getAttribute("Errproj") != null ? request.getAttribute("Errproj") : "" %><br>
            PF: <input type ="text" name="Prova Final"><%= request.getAttribute("Errpf") != null ? request.getAttribute("Errpf") : "" %><br>
            <button type ="submit"> Enviar </button>
        </form>
    </body>
</html>

<%-- 
    Document   : TabelaAlunos
    Created on : 26/03/2018, 16:31:06
    Author     : Lucas Carvalho
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "AcessoEscolar.Aluno"%>
<%@page import = "java.io.*"%>
<%@page import = "java.util.*"%>

<%  
        ArrayList<Aluno> bobaes = new ArrayList();
        bobaes = (ArrayList)request.getAttribute("bobaes");


%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tabela de Notas</title>
    </head>
    <body>
        <table>
            <th> Nome </th>
            <th> Nota 1 </th>
            <th> Trabalho </th>
            <th> Projeto </th>
            <th> Frequencia </th>
            <th> Prova Final </th>
            <th> Situacao </th>
            <%for(Aluno bobo : bobaes){%>
                <tr>
                <td><%=bobo.getNome()%></td>
                <td><%=bobo.getNota1()%></td>
                <td><%=bobo.getTrabalho()%></td>
                <td><%=bobo.getProjeto()%></td>
                <td><%=bobo.getFrequencia()%></td>
                <td><%=bobo.getProva_final()%></td>
                <td><%=bobo.getSituacao()%></td>
                </tr>
                <% } %>
            </table>
            </body>
            </html>
        </table>
    </body>
</html>

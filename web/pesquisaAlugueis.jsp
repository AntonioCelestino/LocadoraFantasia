<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Alugueis</title>
    </head>
    <body>
        <a href="FrontController?action=">Menu</a>
        <h1>Pesquisa de Alugueis</h1>
        <table border="1">
            <tr>
                <th>Id Aluguel</th>
                <th>Cliente</th>
                <th>Fantasia</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${alugueis}" var="aluguel">
                <tr>
                    <td><c:out value="${aluguel.codAluguel}"/></td>
                    <td><c:out value="${aluguel.pessoa.nome}"/></td>
                    <td><c:out value="${aluguel.fantasia.nome}"/></td>
                    <td>
                        <a href="FrontController?action=Aluguel&acao=prepararOperacao&operacao=Editar&codAluguel=<c:out value="${aluguel.codAluguel}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="FrontController?action=Aluguel&acao=prepararOperacao&operacao=Excluir&codAluguel=<c:out value="${aluguel.codAluguel}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="FrontController?action=Aluguel&acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>

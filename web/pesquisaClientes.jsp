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
        <h1>Pesquisa de Clientes</h1>
        <table border="1">
            <tr>
                <th>Id Cliente</th>
                <th>Pessoa</th>
                <th>Tipo</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${clientes}" var="cliente">
                <tr>
                    <td><c:out value="${cliente.codCliente}"/></td>
                    <td><c:out value="${cliente.pessoa.nome}"/></td>
                    <td><c:out value="${cliente.tipo}"/></td>
                    <td>
                        <a href="FrontController?action=Cliente&acao=prepararOperacao&operacao=Editar&codCliente=<c:out value="${cliente.codCliente}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="FrontController?action=Cliente&acao=prepararOperacao&operacao=Excluir&codCliente=<c:out value="${cliente.codCliente}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="FrontController?action=Cliente&acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>

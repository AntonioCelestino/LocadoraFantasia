<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Fantasias</title>
    </head>
    <body>
        <a href="FrontController?action=">Menu</a>
        <h1>Pesquisa de Fantasias</h1>
        <table border="1">
            <tr>
                <th>Id Fantasia</th>
                <th>Nome Fantasia</th>
                <th>Estado Fantasia</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${fantasias}" var="fantasia">
                <tr>
                    <td><c:out value="${fantasia.codFantasia}"/></td>
                    <td><c:out value="${fantasia.nome}"/></td>
                    <td><c:out value="${fantasia.estado}"/></td>
                    <td>
                        <a href="FrontController?action=Fantasia&acao=prepararOperacao&operacao=Editar&codFantasia=<c:out value="${fantasia.codFantasia}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="FrontController?action=Fantasia&acao=prepararOperacao&operacao=Excluir&codFantasia=<c:out value="${fantasia.codFantasia}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="FrontController?action=Fantasia&acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>

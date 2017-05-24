<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Pessoas</title>
    </head>
    <body>
        <a href="FrontController?action=">Menu</a>
        <h1>Pesquisa de Pessoas</h1>
        <table border="1">
            <tr>
                <th>Id Pessoa</th>
                <th>Nome Pessoa</th>
                <th>E-mail Pessoa</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${pessoas}" var="pessoa">
                <tr>
                    <td><c:out value="${pessoa.codPessoa}"/></td>
                    <td><c:out value="${pessoa.nome}"/></td>
                    <td><c:out value="${pessoa.email}"/></td>
                    <td>
                        <a href="FrontController?action=Pessoa&acao=prepararOperacao&operacao=Editar&codPessoa=<c:out value="${pessoa.codPessoa}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="FrontController?action=Pessoa&acao=prepararOperacao&operacao=Excluir&codPessoa=<c:out value="${pessoa.codPessoa}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="FrontController?action=Pessoa&acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>

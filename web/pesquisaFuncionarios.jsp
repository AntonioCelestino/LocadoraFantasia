<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Funcionarios</title>
    </head>
    <body>
        <a href="FrontController?action=">Menu</a>
        <h1>Pesquisa de Funcionarios</h1>
        <table border="1">
            <tr>
                <th>Id Funcionario</th>
                <th>Pessoa</th>
                <th>Cargo</th>
                <th colspan="2">Ação</th>
            </tr>
            <c:forEach items="${funcionarios}" var="funcionario">
                <tr>
                    <td><c:out value="${funcionario.codFuncionario}"/></td>
                    <td><c:out value="${funcionario.pessoa.nome}"/></td>
                    <td><c:out value="${funcionario.cargo}"/></td>
                    <td>
                        <a href="FrontController?action=Funcionario&acao=prepararOperacao&operacao=Editar&codFuncionario=<c:out value="${funcionario.codFuncionario}"/>">Editar</a>
                    </td>
                    <td>
                        <a href="FrontController?action=Funcionario&acao=prepararOperacao&operacao=Excluir&codFuncionario=<c:out value="${funcionario.codFuncionario}"/>">Excluir</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <form action="FrontController?action=Funcionario&acao=prepararOperacao&operacao=Incluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir"/>
        </form>
    </body>
</html>

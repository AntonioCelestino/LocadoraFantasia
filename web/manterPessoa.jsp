<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Pessoa</title>
    </head>
    <body>
        <h1>Manter Pessoa - ${operacao}</h1>
        <form action="FrontController?action=Pessoa&acao=confirmarOperacao&operacao=${operacao}&codPessoa=${pessoa.codPessoa}" method="post">
            <table>
                <tr>
                    <td>CPF:</td>
                    <td><input type="text" name="txtCPF" value="${pessoa.cpf}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Nome:</td>
                    <td><input type="text" name="txtNome" value="${pessoa.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>E-mail:</td>
                    <td><input type="text" name="txtEmail" value="${pessoa.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td><input type="submit"></td>
                </tr>
            </table>
        </form>
    </body>
</html>

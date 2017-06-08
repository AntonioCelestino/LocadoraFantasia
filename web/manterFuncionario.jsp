<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Funcionario</title>
    </head>
    <body>
        <h1>Manter Funcionario - ${operacao}</h1>
        <h3>Mensagem: ${mensagem}</h3>
        <form action="FrontController?action=Funcionario&acao=confirmarOperacao&operacao=${operacao}&codFuncionario=${funcionario.codFuncionario}" method="post">
            <table>
                <tr> 
                    <td><hr />Escolha a Pessoa:
                        <select name="optPessoa" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${pessoa.codPessoa == null}"> selected</c:if>> </option>  
                            <c:forEach items="${pessoas}" var="pessoa">
                                <option value="${pessoa.codPessoa}" <c:if test="${pessoa.codPessoa == pessoa.codPessoa}"> selected</c:if>>${pessoa.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td>Cargo</td> 
                    <td> 
                        <input type="radio" name="optCargo" value="Gerente" <c:if test="${funcionario.cargo == 'Gerente'}"> checked</c:if>>Gerente
                        <br /><input type="radio" name="optCargo" value="Vendedor" <c:if test="${funcionario.cargo == 'Vendedor'}"> checked</c:if>>Vendedor
                        <br /><input type="radio" name="optCargo" value="Recepcionista" <c:if test="${funcionario.cargo == 'Recepcionista'}"> checked</c:if>>Recepcionista
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Confirmar ${operacao}"></td>
                </tr>
            </table>
        </form>
    </body>
</html>

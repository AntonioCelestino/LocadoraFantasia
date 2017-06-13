<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Cliente</title>
    </head>
    <body>
        <h1>Manter Cliente - ${operacao}</h1>
        <h3>Mensagem: ${mensagem}</h3>
        Mensagens Observable:<br><textarea rows="5" cols="100" readonly="true">${observable}</textarea>
        <form action="FrontController?action=Cliente&acao=confirmarOperacao&operacao=${operacao}&codCliente=${cliente.codCliente}" method="post">
            <table>
                <tr> 
                    <td><hr />Escolha a Pessoa:
                        <select name="optPessoa" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${pessoa.codPessoa == null}"> selected</c:if>> </option>  
                            <c:forEach items="${pessoas}" var="pessoa">
                                <option value="${pessoa.codPessoa}" <c:if test="${pessoa.codPessoa == cliente.pessoa.codPessoa}"> selected</c:if>>${pessoa.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td><hr />Informar quando a fantasia 
                        <select name="optFantasia" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" selected ></option>  
                            <c:forEach items="${fantasias}" var="fantasia">
                                <option value="${fantasia.codFantasia}">${fantasia.nome}</option>  
                            </c:forEach>
                        </select>
                        mudar de estado.
                    </td>
                </tr>
                <tr> 
                    <td>Tipo</td> 
                    <td> 
                        <input type="radio" name="optTipo" value="Comum" <c:if test="${cliente.tipo == 'Comum'}"> checked</c:if>>Comum
                        <br /><input type="radio" name="optTipo" value="Vip" <c:if test="${cliente.tipo == 'Vip'}"> checked</c:if>>Vip
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Confirmar ${operacao}"></td>
                </tr>
            </table>
            <table border="1">
                <tr>
                    <th>Cliente</th>
                    <th>Fantasia</th>
                    <th>Ação</th>
                </tr>
                <c:forEach items="${interesses}" var="interesse">
                    <tr>
                        <td><c:out value="${interesse.cliente.pessoa.nome}"/></td>
                        <td><c:out value="${interesse.fantasia.nome}"/></td>
                        <td>
                            <a href="FrontController?action=ExcluirInteresse&acao=confirmarOperacao&codCliente=<c:out value="${interesse.cliente.codCliente}"/>&codFantasia=<c:out value="${interesse.fantasia.codFantasia}"/>">Não estou mais interessado</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>
    </body>
</html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Fantasia</title>
    </head>
    <body>
        <h1>Manter Fantasia - ${operacao}</h1>
        <form action="FrontController?action=Fantasia&acao=confirmarOperacao&operacao=${operacao}&codFantasia=${fantasia.codFantasia}&btnMemento=" method="post">
            <table>
                <tr>
                    <td>Nome</td> 
                    <td><input type="text" name="txtNome" maxlength="20" value="${fantasia.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Categoria</td> 
                    <td><input type="text" name="txtCategoria" value="${fantasia.categoria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Tamanho</td> 
                    <td>
                        <input type="radio" name="optTamanho" value="Pequeno" <c:if test="${fantasia.tamanho == 'Pequeno'}"> checked</c:if>>Pequeno<br/>
                        <input type="radio" name="optTamanho" value="Médio" <c:if test="${fantasia.tamanho == 'Médio'}"> checked</c:if>>Médio<br/>
                        <input type="radio" name="optTamanho" value="Grande" <c:if test="${fantasia.tamanho == 'Grande'}"> checked</c:if>>Grande<br/>
                    </td>
                </tr>
                <tr>
                    <td>Diaria</td> 
                    <td><input type="text" name="txtDiaria" value="${fantasia.diaria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td>Estado</td> 
                    <td> 
                        <input type="radio" name="optEstado" value="Disponível" <c:if test="${fantasia.nomeEstado == 'Disponível'}"> checked</c:if>>Disponivel
                        <br /><input type="radio" name="optEstado" value="Alugada" <c:if test="${fantasia.nomeEstado == 'Alugada'}"> checked</c:if>>Alugada
                        <br /><input type="radio" name="optEstado" value="Restaurando" <c:if test="${fantasia.nomeEstado == 'Restaurando'}"> checked</c:if>>Restaurando
                        <br /><input type="radio" name="optEstado" value="Descartada" <c:if test="${fantasia.nomeEstado == 'Descartada'}"> checked</c:if>>Descartada
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Confirmar ${operacao}"></td>
                </tr>
            </table>
        </form>
        <form action="FrontController?action=Fantasia&acao=confirmarOperacao&operacao=${operacao}&codFantasia=${fantasia.codFantasia}&btnMemento=restaurarEstado" method="post">
            <input type="submit" value="Restaurar Estado Fantasia">
        </form>
</html>

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
        <form action="FrontController?action=Fantasia&acao=confirmarOperacao&operacao=${operacao}&codFantasia=${fantasia.codFantasia}" method="post">
            <table>
                <tr>
                    <td>Nome</td> 
                    <td><input type="text" name="txtNomeFantasia" maxlength="20" value="${fantasia.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Categoria</td> 
                    <td><input type="text" name="txtCategoriaFantasia" value="${fantasia.categoria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Tamanho</td> 
                    <td><input type="text" name="txtTamanhoFantasia" value="${fantasia.tamanho}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Diaria</td> 
                    <td><input type="text" name="txtDiariaFantasia" value="${fantasia.diaria}" <c:if test="${operacao != 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td>Estado</td> 
                    <td> 
                        <input type="radio" name="opt_estado" value="Disponivel" <c:if test="${fantasia.estado == 'Disponivel'}"> checked</c:if>>Disponivel
                        <br /><input type="radio" name="opt_estado" value="Alugado" <c:if test="${fantasia.estado == 'Alugado'}"> checked</c:if>>Alugado
                        <br /><input type="radio" name="opt_estado" value="Restaurando" <c:if test="${fantasia.estado == 'Restaurando'}"> checked</c:if>>Restaurando
                        <br /><input type="radio" name="opt_estado" value="Descartado" <c:if test="${fantasia.estado == 'Descartado'}"> checked</c:if>>Descartado
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                </tr>
            </table>
        </form>
</html>

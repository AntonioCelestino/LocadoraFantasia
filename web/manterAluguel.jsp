<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Aluguel</title>
    </head>
    <body>
        <h1>Manter Aluguel - ${operacao}</h1>
        <form action="FrontController?action=Aluguel&acao=confirmarOperacao&operacao=${operacao}&codAluguel=${aluguel.codAluguel}&btnFinalizar=" method="post">
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
                    <td><hr />Escolha a Fantasia:
                        <select name="optFantasia" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${fantasia.codFantasia == null}"> selected</c:if>> </option>  
                            <c:forEach items="${fantasias}" var="fantasia">
                                <option value="${fantasia.codFantasia}" <c:if test="${fantasia.codFantasia == fantasia.codFantasia}"> selected</c:if>>${fantasia.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Data do Aluguel</td>
                    <td><input type="text" name="txtDataAluguel" value="${aluguel.dtAluguel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Data da Devolução</td>
                    <td><input type="text" name="txtDataDevolucao" value="${aluguel.dtDevolucao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Preco do Aluguel</td>
                    <td><input type="text" name="txtPrecoAluguel" value="${aluguel.precoAluguel}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                </tr>
                <tr> 
                    <td>Promoção</td> 
                    <td> 
                        <input type="radio" name="optPromocao" value="" <c:if test="${aluguel.promocao == ''}"> checked</c:if>>Nenhuma
                        <br/><input type="radio" name="optPromocao" value="Carnaval" <c:if test="${aluguel.promocao == 'Carnaval'}"> checked</c:if>>Carnaval
                        <br/><input type="radio" name="optPromocao" value="ComicCon" <c:if test="${aluguel.promocao == 'ComicCon'}"> checked</c:if>>ComicCon
                    </td>
                </tr>
                <tr>
                    <td><input type="submit" value="Confirmar ${operacao}"></td>
                </tr>
            </table>
        </form>
        <form action="FrontController?action=Aluguel&acao=confirmarOperacao&operacao=${operacao}&codAluguel=${aluguel.codAluguel}&btnFinalizar=finalizarAluguel" method="post">
            <input type="submit" value="Finalizar Aluguel">
        </form>
    </body>
</html>

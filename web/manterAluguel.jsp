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
        <h3>Mensagem Promocional:<br> ${mensagem}</h3>
        <form action="FrontController?action=Aluguel&acao=confirmarOperacao&operacao=${operacao}&codAluguel=${aluguel.codAluguel}" method="post">
            <table>
                <tr> 
                    <td><hr />Escolha a Pessoa:
                        <select name="optPessoa" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${pessoa.codPessoa == null}"> selected</c:if>> </option>  
                            <c:forEach items="${pessoas}" var="pessoa">
                                <option value="${pessoa.codPessoa}" <c:if test="${pessoa.codPessoa == aluguel.pessoa.codPessoa}"> selected</c:if>>${pessoa.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                </tr>
                <tr> 
                    <td><hr />Escolha a Fantasia:
                        <select name="optFantasia" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <option value="0" <c:if test="${fantasia.codFantasia == null}"> selected</c:if>> </option>  
                            <c:forEach items="${fantasias}" var="fantasia">
                                <option value="${fantasia.codFantasia}" <c:if test="${fantasia.codFantasia == aluguel.fantasia.codFantasia}"> selected</c:if>>${fantasia.nome}</option>  
                            </c:forEach>
                        </select>
                    </td>
                    <td>
                        Fantasia está ${aluguel.fantasia.nomeEstado}
                        <input type="checkbox" name="finalizar">Finalizar Aluguel<br>
                    </td>
                </tr>
                <tr>
                    <td>Data do Aluguel</td>
                    <td><input type="text" name="txtDataAluguel" value="${aluguel.dtAluguel}" <c:if test="${operacao != 'Editar'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Data da Devolução</td>
                    <td><input type="text" name="txtDataDevolucao" value="${aluguel.dtDevolucao}" <c:if test="${operacao != 'Editar'}"> readonly</c:if>></td>
                </tr>
                <tr>
                    <td>Preco do Aluguel:</td>
                    <td>${aluguel.precoAluguel}</td>
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
    </body>
</html>

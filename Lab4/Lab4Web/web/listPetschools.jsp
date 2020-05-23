<%-- 
    Document   : addPetschools
    Created on : 23.05.2020, 17:06:35
    Author     : Алиса
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>petschool</title>
    </head>
    <body>
        <h1>Список всех школ для питомцев</h1>
        <table>
            <tr>
                <th>№</th>
                <th>Название</th>
                <th>Адрес</th>
                <th></th>
            </tr>
            <c:forEach items="${petschool}" var="master">
            <tr>
                <td>${petschool.id}</td>
                <td>${petschool.name}</td>
                <td>${petschool.place}</td>
                <td><form action=<c:url value="updatePetschool.jsp"/>
                        <input type="hidden" value="${petschool}">
                        <input class="btn" type="submit" value="Update">                     
                    </form>
                    </td>

                    <form action="delete" method="post">
                        <input type="hidden" name="id" value="${petschool}">
                        <input type="submit" value="удалить">
                    </form></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>


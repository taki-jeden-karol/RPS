<%-- 
    Document   : list
    Created on : 05.05.2020, 21:10:21
    Author     : Алиса
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>master</title>
    </head>
    <body>
        <h1>Список всех хозяев</h1>
        <table>
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Адрес</th>
                <th>Имя питомца</th>
                <th>Вид питомца</th>
                <th></th>
            </tr>
            <c:forEach items="${master}" var="master">
            <tr>
                <td>${master.id}</td>
                <td>${master.name}</td>
                <td>${master.address}</td>
                <td>${master.petname}</td>
                <td>${master.petrace}</td>
                <td><form action=<c:url value="update.jsp"/>
                        <input type="hidden" value="${master}">
                        <input class="btn" type="submit" value="Update">                     
                    </form>
                    </td>

                    <form action="delete" method="post">
                        <input type="hidden" name="id" value="${master}">
                        <input type="submit" value="удалить">
                    </form></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>

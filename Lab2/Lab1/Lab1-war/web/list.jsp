<%-- 
    Document   : list
    Created on : 23.03.2020, 11:19:32
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
        <a href="add">Добавить хозяина</a>
        <table>
            <tr>
                <th>№</th>
                <th>Имя</th>
                <th>Адрес</th>
                <th>Имя питомца</th>
                <th></th>
            </tr>
            <c:forEach items="${master}" var="master">
            <tr>
                <td>${master.id}</td>
                <td>${master.name}</td>
                <td>${master.address}</td>
                <td>${master.petname}</td>
                <td><a href="edit">Изменить</a></td>
                <td>
                    <form action="delete" method="post">
                        <input type="hidden" name="id" value="${master.id}">
                        <input type="submit" value="удалить">
                    </form></td>
            </tr>
            </c:forEach>
        </table>
    </body>
</html>


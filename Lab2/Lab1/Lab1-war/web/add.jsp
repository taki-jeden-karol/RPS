<%-- 
    Document   : add
    Created on : 23.03.2020, 11:20:09
    Author     : Алиса
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add</title>
    </head>
    <body>
        <form action="add" method="post">
            <input type="hidden" name="id" value="${master.id}">
            <table>
                <tr> 
                    <td>Имя</td>
                    <td><input required type="text" name="name" value="${master.name}"></td>
                </tr>
                <tr> 
                    <td>Адрес</td>
                    <td><input required type="text" name="address" value="${master.address}"></td>
                </tr>
                <tr> 
                    <td>Имя питомца</td>
                    <td><input required type="text" name="petname" value="${master.petname}"></td>
                </tr>
                <tr> 
                    <td colspan="2"><input type="submit" value="Создать"></td>
                </tr>
            </table>
        </form>

    </body>
</html>


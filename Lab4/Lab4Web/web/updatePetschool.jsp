<%-- 
    Document   : updatePetschool
    Created on : 23.05.2020, 17:07:14
    Author     : Алиса
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>upd</title>
    </head>
    <body>
         <table>
        <form action="PetschoolController" method="post">
        <input type="hidden" name="param" value="Update"/>
        <tr>
            <td>Название школы для питомцев</td>
            <td>${petschool.name} </td>
        </tr>
        <tr>
            <td>Обновленное название школы для питомцев</td>
            <td><input type="text" name="petschoolName" /></td>
        </tr>
        <tr>
            <td>Адрес школы для питомцев</td>
            <td>${petschool.place} </td>
        </tr>
        <tr>
            <td>Обновленный адрес школы для питомцев</td>
            <td><input type="text" name="petschoolPlace" /></td>
        </tr>
            <td>
                <input type="submit" value="Сохранить изменения">
            </td>
        </tr>
    </body>
</html>


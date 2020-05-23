<%-- 
    Document   : update
    Created on : 05.05.2020, 21:42:59
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
        <form action="MasterController" method="post">
        <input type="hidden" name="param" value="Update"/>
        <tr>
            <td>Имя хозяина</td>
            <td>${master.name} </td>
        </tr>
        <tr>
            <td>Обновленное имя хозяина</td>
            <td><input type="text" name="masterName" /></td>
        </tr>
        <tr>
            <td>Адрес хозяина</td>
            <td>${master.address} </td>
        </tr>
        <tr>
            <td>Обновленный адрес хозяина</td>
            <td><input type="text" name="masterAddress" /></td>
        </tr>
        <tr>
            <td>Имя питомца </td>
            <td>${master.petname} </td>
        </tr>
        <tr>
            <td>Обновленное имя питомца</td>
            <td><input type="text" name="masterPetname" /></td>
        </tr>
            <td>Вид питомца </td>
            <td>${master.petrace} </td>
        </tr>
        <tr>
            <td>Обновленный вид питомца</td>
            <td><input type="text" name="masterPetrace" /></td>
        </tr>
        <tr>
            
            <td>
                <input type="submit" value="Сохранить изменения">
            </td>
        </tr>
    </body>
</html>

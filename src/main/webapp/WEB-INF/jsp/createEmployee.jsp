<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
 <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
 
<html>  
<head>  
<style>
.error {
    color: red;
    font-style: italic;
}
</style>
</head>  
<body> 
<h1>Create Employee</h1>
<form:form method="post" action="/create-employee">
    <table>
        <tr>
            <td>Name: </td>
            <td><form:input path="name"/></td>
            <td><form:errors path="name" cssClass="error" /></td>
        </tr>
        <tr>
            <td>Department: </td>
            <td><form:input path="department"/></td>
            <td><form:errors path="department" cssClass="error" /></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Create"/></td>
        </tr>
    </table>
</form:form>
</body> 
</html>
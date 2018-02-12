<%@include file="../_includes/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<h1>Add customer</h1>
<form method="post" action="${SITE_URL}/customers/add">
    <table border="0">
        <tr>
            <td>First Name: </td>
            <td><input type="text" name ="firstname" required="required" autofocus="autofocus"/></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><input type="text" name ="lastname" required="required" /></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><input type="email" name ="email"  /></td>
        </tr>
        <tr>
            <td>Contact: </td>
            <td><input type="text" name ="contact"  /></td>
        </tr>
        <tr>
            <td>Status: </td>
            <td>  <input type="checkbox" name ="status"/></td>
        </tr>
    </table>
    <button type="submit">Add</button>
    <a href="${SITE_URL}/customers" style="background:red; border:1px; border-radius: 3px; padding: 2px; text-decoration: none;">Back</a>
</form>
<%@include file="../_includes/footer.jsp" %>
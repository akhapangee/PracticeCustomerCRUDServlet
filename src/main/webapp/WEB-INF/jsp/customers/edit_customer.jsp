<%@include file="../_includes/header.jsp" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<h1>Update customer</h1>
<form method="post" action="${SITE_URL}/customers/edit_customer?id=${customer.id}">
    <table border="0">
        <tr>
            <td>Id: </td>
            <td><input type="text" name ="id"  value="${customer.id}" readonly=""/></td>
        </tr>
        <tr>
            <td>First Name: </td>
            <td><input type="text" name ="firstname" required="required" autofocus="autofocus" value="${customer.firstName}"/></td>
        </tr>
        <tr>
            <td>Last Name: </td>
            <td><input type="text" name ="lastname" required="required" value="${customer.lastName}"/></td>
        </tr>
        <tr>
            <td>Email: </td>
            <td><input type="email" name ="email"  value="${customer.email}" /></td>
        </tr>
        <tr>
            <td>Contact: </td>
            <td><input type="text" name ="contact" value="${customer.contact}" /></td>
        </tr>
        <tr>
            <td>Status: </td>
            <td>  <input type="checkbox" name ="status"
                         <c:if test="${customer.status =='true'}"> checked </c:if> />
            </td>
        </tr>
    </table>
            <button type="submit">Update</button>
    <a href="${SITE_URL}/customers" style="background:red; border:1px; border-radius: 3px; padding: 2px; text-decoration: none;">Back</a>
</form>
<%@include file="../_includes/footer.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<%@include file="_includes/header.jsp" %>
<a href="_includes/header.jsp"></a>
<h1 style="text-decoration: underline">JSP and Servlet Covered In Class</h1>
<h1>Accesing name using expression language and jsp code respectively</h1>
<!--using Expression Language-->
<h1 style="color: green">Name: ${requestScope.name}</h1>

<!--using JSP code-->
<h1 style="color: green">Using jsp code: <%=request.getAttribute("name")%></h1>
${"================================================start of customer section====================================================="}
<h1>Click: <a href="${SITE_URL}/customers">CUSTOMER SECTION</a></h1>

${"===============================================end of customer section======================================================"}

${"===============================================form section======================================================"}
<form  method="post" action="">
    <div><label><h1>Enter your name</h1></label></div>
    <input type="text" name="name" required="required" autofocus/>
    <button type="submit" value="submit">Save</button>
</form>
<div></div>
${"===============================================form section======================================================"}
<%@include file="_includes/header.jsp" %>

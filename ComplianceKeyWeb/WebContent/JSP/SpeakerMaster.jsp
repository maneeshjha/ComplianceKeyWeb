<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="java.util.*" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Speaker Profile</title>
</head>
<body>
<table align="center">
<tr>
<td>Speaker Name:</td> <td><html:text property="speakerName" value=""/></td>
</tr>
<tr>
<td>Description:</td> <td><html:textarea property="description" value=""/></td>
</tr>
<tr>
<td>Speaker Photo:</td> <td><html:file property="photoName" value=""/></td>
</tr>
</table>
</body>
</html>
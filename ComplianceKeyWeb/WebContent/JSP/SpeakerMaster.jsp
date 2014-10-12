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
<%String msg=(String)request.getAttribute("msg"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Speaker Profile</title>
</head>
<body>
<html:form action="/speakerAction.do?reqCode=updateSpeakerInfo" enctype="multipart/form-data">
<table align="center">
<% if(msg!=null && msg.length()>0){%>
<tr>
<%=msg%>
</tr>
<%} %>
<tr>
<td>Speaker Name:</td> <td><html:text property="speakerName" value=""/></td>
</tr>
<tr>
<td>Description:</td> <td><html:textarea property="description" value=""/></td>
</tr>
<tr>
<td>Speaker Photo:</td> <td><html:file property="file" value=""/></td>
</tr>
<tr><td>Status<td><input type="radio" name="status" value="ACTIVE"/>ACTIVE</td><td><input type="radio" name="status" value="INACTIVE"/>INACTIVE</td></tr>
<tr><td><input type="submit" value="Submit"/></td></tr>
</table>
</html:form>
</body>

</html>
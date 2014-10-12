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
<script language="javascript" src="<%=request.getContextPath()%>/js/common.js"></script>
<script language="javaScript" src="<%=request.getContextPath()%>/js/Master/SpeakerMaster.js"></script>	
<script language="javascript">history.forward(-1); </script>
<script>
 var $j = jQuery.noConflict();
</script>
<script language="JavaScript" src="<%=request.getContextPath()%>/js/prototype.js" type="text/javascript"></script>
<%String msg=(String)request.getAttribute("msg"); %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Speaker Details</title>
</head>
<body>
<html:form action="/speakerAction.do">
<input type="hidden" name="reqCode" value="" />	
<table align="center">
<tr>
<td>Speaker Name:</td> <td><html:text property="speakerName" value="" title="Please Enter Speaker Name" onkeyup="return getStatusWiseSpeakerName(this,event)"/></td>
</tr>
<tr><td>Status<td><input type="radio" name="status" value="ACTIVE"/>ACTIVE</td><td><input type="radio" name="status" value="INACTIVE"/>INACTIVE</td></tr>
<tr><td><input type="button" value="Search"/></td><td><input type="button" value="Clear"/></td><td><input type="button" value="AddNew" onclick="return showAddEmployeeMasterPage()"/></td></tr>
</table>
</html:form>
</body>

</html>
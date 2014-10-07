<%
String path = request.getContextPath();
%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<title>ComplianceKey</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/Rah.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/qms.css">
</head>

<style>

.bg{background:url(<%=path%>/images/bg.jpg) no-repeat; width:50%;}


</style>
<body>
<html:form action="/login.do?reqCode=checkLogin" focus="login">
<table width="100%" border="0" align="center" cellpadding="0" cellspacing="0">
  <tr>
    <td height="40"><table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td><img src="<%=path%>/images/logo.jpg" width="279" height="66" /></td>
      </tr>
    </table></td>
  </tr>
  <tr>
    <td height="5" align="left" valign="top" bgcolor="#F5F5F5"></td>
  </tr>
  <tr>
    <td height="650" align="left" valign="top" class="bg"><table width="800" border="0" align="center" cellpadding="0" cellspacing="0">
      <tr>
        <td colspan="2">&nbsp;</td>
      </tr>
      <tr>
        <td width="565" align="left" valign="middle">&nbsp;</td>
        <td width="250" align="left" valign="middle" bgcolor="#F8F8F8"><table width="230" border="0" align="center" cellpadding="0" cellspacing="0" bgcolor="#F5F5F5" class="normaltext">
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="25"><h2 class="Maintitle">Login to Compliance Key	</h2></td>
          </tr>
          <tr>
            <td height="30">&nbsp;</td>
          </tr>
		  <% String msg = (String)request.getAttribute("msg");
				if(msg !=null && msg.length() > 0)
				{%>
				
				<tr>
				  <td align="center" valign="middle" class="FAIL"><%=msg%></td>
				  </tr>
				 <tr>
				  <td align="center" valign="middle" >&nbsp;</td>
				  </tr>
				<%}%> 
          <tr>
            <td height="20">User Name </td>
          </tr>
          <tr>
            <td height="30"><html:text  property="login" styleClass="textbox" value=""/></td>
          </tr>
          <tr>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td height="20">Password</td>
          </tr>
          <tr>
            <td height="30"><html:password property="password" styleClass="textbox" value=""/></td>
          </tr>
          <tr>
            <td height="30"><input type="button" class="btn" value="Login" onclick="return validateLogin()"></td>
          </tr>
          <tr>
            <td height="30">&nbsp;</td>
          </tr>
          <tr>
            <td height="30">&nbsp;</td>
          </tr>
          <tr>
            <td height="30">&nbsp;</td>
          </tr>
        </table></td>
      </tr>
    </table></td>
  </tr>
</table>
</html:form>
</body>
</html>
<script language="javascript">
function validateLogin()
{
	var userName = trim(document.loginForm.login.value);
	var password = trim(document.loginForm.password.value);
	if(userName=="")
	{
		alert("Please Enter User Name.");
	//	document.loginForm.write("Please Enter User Name");
	
		document.loginForm.login.value = "";
		document.loginForm.login.focus();
		return false;
	}
	if(password=="")
	{
		alert("Please Enter Password.");
		document.loginForm.password.value = "";
		document.loginForm.password.focus();
		return false;
	}
	document.loginForm.submit();
  
}
function trim(str)
{
	return str.replace(/^\s\s*/, '').replace(/\s\s*$/, '');
}

</script>	

// JavaScript Document
function showAddEmployeeMasterPage()
{
	document.SpeakerForm.reqCode.value="showSpeakerMasterPage";
	document.SpeakerForm.submit();
}
function getStatusWiseSpeakerName(obj,event)
{
	var empName	   =	trim(obj.value);
	var reqCode		=	"getStatusWiseEmpList";
	var url			=	"commonMethodAction.do";
	var keyvalue		=	event.keyCode;
	if(keyvalue == 38 || keyvalue == 40 || keyvalue == 13 || keyvalue == 9)
	{	
		if(document.getElementById("divEmpName").innerHTML != "")
		 {
			if(keyvalue == 13)
			{
				changeEmpNameVal();				
			}
			else
			{
				obj.value	=	obj.value; /*to move focus at end when using crome.*/
				arrowKeyFunctionForTTS(event,"ajaxEmpNameID");			
			}
		 }
	}
	else
	{
		document.EmployeeForm.empId.value	=	"";
		if(empName.length > 0)
		{	
			showProcessing("divEmpName");
			new Ajax.Request
			(
				url,
					{
					  method		: 'post',
					  parameters	: {reqCode:reqCode,empName:empName,status:"ACTIVE",departmentid:departmentid},
					  onSuccess		: processEmpList,
					  onFailure		: function()
									  { 
										  alert("There was an error with the connection"); 
									  }								  
					}
			 );
		}
		else
		{
			$j("#divEmpName").html("");
			$j("#divEmpName").hide();
		}
	}
}

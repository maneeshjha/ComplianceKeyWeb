// JavaScript Document
function showAddEmployeeMasterPage()
{
	document.SpeakerForm.reqCode.value="showSpeakerMasterPage";
	document.SpeakerForm.submit();
}
function getStatusWiseSpeakerName(obj,event)
{
	var spkName	    =	trim(obj.value);
	alert(spkName);
	var reqCode		=	"getStatusWiseSpeakerList";
	var url			=	"commonMethodAction.do";
	var keyvalue	=	event.keyCode;
	if(keyvalue == 38 || keyvalue == 40 || keyvalue == 13 || keyvalue == 9)
	{	
		if(document.getElementById("divSpeakerName").innerHTML != "")
		 {
			if(keyvalue == 13)
			{
				changeSpknameVal();				
			}
			else
			{
				obj.value	=	obj.value; /*to move focus at end when using crome.*/
				arrowKeyFunctionForTTS(event,"ajaxSpeakerNameID");			
			}
		 }
	}
	else
	{
		document.SpeakerForm.speakerID.value	=	"";
		if(spkName.length > 0)
		{	
			showProcessing("divSpeakerName");
			alert("Hi again!!!");
			new Ajax.Request
			(
				url,
					{
					  method		: 'post',
					  parameters	: {reqCode:reqCode,spkName:spkName,status:"ACTIVE"},
					  onSuccess		: processSpeakerList,
					  onFailure		: function()
									  { 
										  alert("There was an error with the connection"); 
									  }								  
					}
			 );
		}
		else
		{
			$j("#divSpeakerName").html("");
			$j("#divSpeakerName").hide();
		}
	}
}
function processSpeakerList(transprot)
{
	var response = 	transprot.responseText;
	alert("hI");
	var data	 =	eval("("+response+")"); 
    var dataList =	data.DataList;
	var text	 =	"";
	if(dataList.length > 0)
	{
		text  += '<select name="ajaxSpeakerNameID" id="ajaxEmpNameID"  size="5" class="multitextbox" ondblclick=changeSpknameVal() onkeypress=checkSpkName(event)>';
		
		for(var i=0;i<dataList.length;i++)
		{
			text 	+= '<option value="'+dataList[i].value+'">'+dataList[i].name+'</option>';
		}
			text	+=  '</select>';
		
		$j("#divSpeakerName").html(text);
		$j("#divSpeakerName").css("top",($j("[name=speakerName]").position().top+20));			
		$j("#divSpeakerName").css("left",$j("[name=speakerName]").position().left);
		$j("#divSpeakerName").show();	
	}
	else
	{
		$j("#divSpeakerName").html("");
		$j("#divSpeakerName").hide();
	}
		
}

function changeSpknameVal()
{
	  $j("[name=speakerName]").val($j("#ajaxEmpNameID option:selected").text());
	 $j("[name=speakerID]").val($j("#ajaxEmpNameID option:selected").val());	
	 
	 $j("#divEmpame").html("");
	 $j("#divEmpName").hide();
}

function checkSpkName(e)
{
	var KeyID = (window.event) ? event.keyCode : e.keyCode;	
	if(KeyID == 13 )
	{ 
		changeSpknameVal();	
	}
}
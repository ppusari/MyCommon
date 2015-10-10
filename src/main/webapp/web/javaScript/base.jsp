<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	window.onload = function(){
		
		var jobCreateJsonString = "{'Input':{'Url':'./test.mp4'},'OutputUrlPrefix':'./media','Outputs':[{'Key':'test-transcoded-1','ThumbnailPattern':'{key}_{resolution}_{count}','PresetId':'webm','Captions':{'CaptionSources':[{'Url':'./test.smi'}]}},{'Key':'test-transcoded-2','ThumbnailPattern':'{key}_{resolution}_{count}','PresetId':'m4a'}]}";
		jobCreateJsonString = jobCreateJsonString.replace(/'/gi, "\"");		
		alert(jobCreateJsonString); 
	};
</script>
</head>
<body>
hi~

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.7.0.min.js"></script>
<script type="text/javascript">
window.onload = function(){		
	
	$('#json1').click(function(){
		var str = '{"Input":{"Url":"./test.mp4"},"OutputUrlPrefix":"./media","Outputs":[{"Key":"test-transcoded-1","ThumbnailPattern":"{key}_{resolution}_{count}","PresetId":"webm","Captions":{"CaptionSources":[{"Url":"./test.smi"}]}},{"Key":"test-transcoded-2","ThumbnailPattern":"{key}_{resolution}_{count}","PresetId":"m4a"}]}';			
		var json= $.parseJSON(str);
		var url = json.Input.Url;
		var out = json.OutputUrlPrefix;
		alert(typeof json);
		alert("URL: " + url + "\r\nOutputUrlPrefix " + out);
		 
	 	for (key in json){
			alert( "key is " + key + ", value is " + json[ key ] );
		}
	 	
	 	jQuery.each(json, function(index, value){
	 		alert("index: " + index + " Value: " + value);	 		
	 	})
	});
	
	$('#json2').click(function(){		
 
	   	var str = '{"Input":{"Url":"./test.mp4"},"OutputUrlPrefix":"./media","Outputs":[{"Key":"test-transcoded-1","ThumbnailPattern":"{key}_{resolution}_{count}","PresetId":"webm","Captions":{"CaptionSources":[{"Url":"./test.smi"}]}},{"Key":"test-transcoded-2","ThumbnailPattern":"{key}_{resolution}_{count}","PresetId":"m4a"}]}';
	   	var list = $.parseJSON(str);
	   	
	   	alert(list.Outputs[0].Key);
	   	
		var outputsList = list.Outputs;	
		for (var i=0; i<outputsList.length; i++){
			var obj = outputsList[i].PresetId;
			alert(obj);
		}
	   
	});
	
	
 	

 
	
 
};
</script>
</head>
<body>

	<div>
		<button type="button" id="json1">json1</button>
		<button type="button" id="json2">json2</button>
	</div>

</body>
</html>
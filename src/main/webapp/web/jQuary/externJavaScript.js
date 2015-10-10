/**
 * 2014.9.30 
 * js 파일을 만드는 방법. javascript source file 을 선택한다.
 */

var data = [
	{id:'id01',name:'name01'},
	{id:'id02',name:'name02'},
	{id:'id03',name:'name03'},
	{id:'id04',name:'name04'},
	{id:'id05',name:'name05'}
	]; // 배열

var Clist = {};

Clist.makeTable = function(){     
	// append & appendTo 차이점은 앞뒤가 바뀐다.
	$('#clist').append('<table>');
	$('#clist > table').append('<tr><th>ID</th><th>NAME</th></tr>');	 
};  

Clist.makeStyle = function(){
	 
	// 속성  attr ( 뿌릴때 가져올때 모두 attr 이다 )
	$('table').attr({
		width:300,height:200
	});
	
	// 스타일 css
	$('table').css('border','2px solid red');	
	$('tr:odd').css('background','pink');
	$('tr:even').css('background','cyan');
	$('tr').eq(0).css({
		'background':'black',
		'color':'white'
	})
	
	$('body > div > table > tbody > tr').hover(function(){
		
	}, function(){
		
	});
};
    
$(document).ready(function(){
	Clist.makeTable();
	$(data).each(function(index, item){
		with(item){ // with is javaScript 
			var output = '';
			output += '<tr>';
				output += '<td>' + id + '</td>';
				output += '<td>' + name + '</td>';
			output += '</tr>'
							
			$('tr').eq(0).after(output);
		}
		
		
	});
	Clist.makeStyle();
});
    
       
           
      
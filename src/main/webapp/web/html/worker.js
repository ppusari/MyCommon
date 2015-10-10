/**
 * js는 백그라운드에서 돈다.
 */

onmessage = function(e) {
	var num = e.data;
	var result = 0;
	for (var i = 1; i < e.data; i++) {
		result += i;
	}

	postMessage(result); // 
};
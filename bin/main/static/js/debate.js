$(document).ready(function () {
    $.ajax({
        url: "/debateCommentList",
        type: "get",
        dataType: "json",
        success: function (result) {
 
        	console.log(result);
        	var contact = JSON.parse(JSON.stringify(result));
    		for (var i = 0; i < contact.length; i++) {
    	
			    var div = document.createElement('div');
			    div.innerHTML = document.getElementById('commentbox').innerHTML;
			    document.getElementById('commentboxList').appendChild(div);
			    
			    var list = document.getElementsByClassName("contentclass");//같은 클래스이름을 가진애들을 리스트로 받음
			    for (var j = 0; j < list.length; j++) {
			     list[j].setAttribute("id", "comment_content" + j);//id 이름을 하나씩 증가시키면서 변경해줌
			    }
			    
			    var list2 = document.getElementsByClassName("nameclass");
			    for (var k = 0; k < list2.length; k++) {
			     list2[k].setAttribute("id", "nick_name" + k);
			    }
			    
			    $("#content"+i).append(contact[i].content); // content와 nickname 은 input에 있던 id다
			    $("#nickname"+i).append(contact[i].nickname);
			
			}
        },
        error: function name() {
            alert("실패");
        }
    });
});






$(document).ready(function () {
    $.ajax({
        url: "/freeboardCommentList",
        type: "get",
        dataType: "json",
        success: function (result) {
 
        	console.log(result);
        	var contact = JSON.parse(JSON.stringify(result));
    		for (var i = 0; i < contact.length; i++) {
    	
			    var div = document.createElement('div');
			    div.innerHTML = document.getElementById('commentbox').innerHTML;
			    document.getElementById('commentList').appendChild(div);
			    
			    var list = document.getElementsByClassName("contentclass");
			    for (var j = 0; j < list.length; j++) {
			     list[j].setAttribute("id", "content" + j);
			    }
			    
			    var list2 = document.getElementsByClassName("nameclass");
			    for (var k = 0; k < list2.length; k++) {
			     list2[k].setAttribute("id", "nickname" + k);
			    }
			    
			    $("#content"+i).append(contact[i].content);
			    $("#nickname"+i).append(contact[i].wirter);
			
			}
    		$("#commentbox").css("display","none");
        },
        error: function name() {
            alert("실패")
        }
    });
    function getFormData(data) {
        var unindexed_array = data;
        var indexed_array = {};
        $.map(unindexed_array, function(n, i) {
            indexed_array[n['name']] = n['value'];
        });
        return indexed_array;
    }
    $('#defaultCommentWrite').click(function () {
        var formData = $('#freeboardComment0').serializeArray();
        $.ajax({
            url : '/freeboardCommentWrite',
            dataType : 'json',
            type:'POST',
            contentType : 'application/json',
            data : JSON.stringify(getFormData(formData)),
            success : function () {
                console.log("inserted");
            },
            error : function () {
                console.log(formData);
            }
        });
    });
    $('#contentrewrite').click(function() {
        var formData = $('#freeboardid').val();
        var formData2 = $('#getuserid').val();
        var freeid = $('#getfreeid').val();
        
        if(formData == formData2){
    	document.getElementById("contenttext").readOnly=false;
        }
        if(document.getElementById("contenttext").readOnly==false){
        	$('#contentrewrite').click(function() {
        		var stringreturn = document.getElementById("contenttext").value;
        		console.log(stringreturn);
                var objParams = {
                        "stringreturn" : stringreturn,
                        "freeid" : freeid  
                    };
                
        		$.ajax({
                    url : '/freeboardRewrite',
                    dataType : 'json',
                    type:'POST',
                    data : objParams,
                    success : function () {
                        console.log("ok?");
                    },
                    error : function () {
                        console.log("fff");
                    }
        		});
        		document.getElementById("contenttext").readOnly=true;
        		

        	
        	 });
        	}
        
    });
    
    $('#contentdrop').click(function () {
        var formData = $('#freeboardid').val();
        var formData2 = $('#getuserid').val();
        var freeid = $('#getfreeid').val();
        console.log(freeid);
        if(formData == formData2)
        	{
        		okreturn="ok";
        	}
        else{
        	 okreturn = "no";
        }
        var objParams = {
                "ok"      : okreturn,
                "freeid" : freeid  
            };
        $.ajax({
            url : '/freeboardDrop',
            dataType : 'json',
            type:'POST',
            data : objParams,
            success : function () {
                console.log("ok?");
            },
            error : function () {
                console.log();
            }
        });
    });
});






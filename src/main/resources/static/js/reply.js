console.log("Reply js Module");

var replyService=(function(){
	
	function add(reply,callback,error){
		console.log("replyService.add ");
		console.log(reply);
		
		$.ajax({
			type:'post',
			url:'/replies/new',
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			beforeSend: function(xhr){   
                xhr.setRequestHeader(reply.csrf_header, reply.csrf_token);
            },
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(status);
				}
			}
		});
	}
	
	
	function getReplies(param,callback,error){
		console.log("replyService.getReplies");
		console.log(param);
		
		$.ajax({
			type:'get',
			url:'/replies/pages/'+param.bno+'/'+param.page,
			dataType:'json',
			success:function(result){
				if(callback)
					callback(result.replyCnt,result.list);
			},
			error:function(xhr,status,er){
				if(error){
					error(status);
				}
			}
		});
	}
	
	function remove(reply,callback,error){
		console.log("replyService.remove");
		console.log(reply);
		
		$.ajax({
			type:'delete',
			url:'/replies/'+reply.rno,
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			beforeSend: function(xhr){   
                xhr.setRequestHeader(reply.csrf_header, reply.csrf_token);
            },
			success:function(deleteResult,status,xhr){
				if(callback){
					callback(deleteResult);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(status);
				}
			}
		});
	}
	
	function update(reply,callback,error){
		console.log("replyService.update");
		console.log(reply);
		
		$.ajax({
			type:'put',
			url:'/replies/'+reply.rno,
			data:JSON.stringify(reply),
			contentType:"application/json; charset=utf-8",
			beforeSend: function(xhr){   
                xhr.setRequestHeader(reply.csrf_header, reply.csrf_token);
            },
			success:function(result,status,xhr){
				if(callback){
					callback(result);
				}
			},
			error:function(xhr,status,er){
				if(error){
					error(status);
				}
			}
		});
	}
	
	return {
		add:add,
		getReplies:getReplies,
		remove:remove,
		update:update
	};	
})();
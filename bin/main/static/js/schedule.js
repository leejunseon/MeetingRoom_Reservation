console.log("Schedule js Module");

var scheduleService=(function(){	
	
	function remove(schedule,callback,error){
		console.log("scheduleService.remove");
		console.log(schedule);
		
		$.ajax({
			type:'delete',
			url:'/schedule/remove',
			data:schedule,
			beforeSend: function(xhr){   
                xhr.setRequestHeader(schedule.csrf_header, schedule.csrf_token);
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
	
	function update(schedule,callback,error){
		console.log("scheduleService.update");
		console.log(schedule);
		
		$.ajax({
			type:'put',
			url:'/schedule/update',
			data:schedule,
			beforeSend: function(xhr){
                xhr.setRequestHeader(schedule.csrf_header, schedule.csrf_token);
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
		remove:remove,
		update:update
	};	
})();
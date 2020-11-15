$(function() {
		//按钮添加事件
		$("input.gm").click(function() {
			operatorMoney(this);
		});
	})

	//取款操作
	function operatorMoney(te) {
		
		var value = $(te).val();
		var type = $("#opm_hi_val").val();
		var url_val="";
		if(type=="取款"){
			url_val="GM";
		}
		if(type=="存款"){
			url_val="SM";
		}
		//window.location.href=url_val+"?money="+value;
		var obj = new Object();
		obj.money=value;
		$.ajax({
            type:"post",
			url:url_val,
			data:obj,
			success:function(data){
				if(data.status==1){
					var value = data.message;
					$("#opm_show_value").html(value);	
				}
				
			}
		})
		
	}
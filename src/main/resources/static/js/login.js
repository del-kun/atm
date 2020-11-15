$(function() {
	//按钮添加事件
	$("#login_bu").click(function() {
		login();
	});
})

//取款操作
function login() {
	var username = $("#login_username").val();
	var pwd = $("#login_pwd").val();
	//window.location.href=url_val+"?money="+value;
	var obj = new Object();
	obj.username=username;
	obj.pwd=pwd;
	if(validate(obj)){
		 //模态框显示提示信息
		 $('#indexModel').modal("show");
		 //提示消息设置
		 $('#indexMsg').html("银行卡号或密码输入有误，请重新输入");
		 
         setTimeout(function(){
             $("#indexModel").modal("hide")
         },2000);
		return;
	}
	$.ajax({
        type:"post",
		url:"vu",
		data:obj,
		success:function(data){
			if(data.status==1){
				window.location.href= "main";	
			}
		}
	})
}

function validate(obj){

	  
}
$(function() {
	//按钮添加事件
	$("button").click(function() {
		operator(this);
	});
	init();
})

//业务操作
function init(){
	$.ajax({
        type:"get",
		url:"gu",
		success:function(data){
			if(data.status==1){
				$("#main_b_username").html(data.user.username);
			}
		}
	})
}


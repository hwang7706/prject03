/**
 * 이곳은 공통적으로 들어가는 javascript 파일입니다.
 */
/*	console.log("hello world");
	$(document).ready(function(){
		$('#mainColor1').change(function(){
			var colorValue1 = $('#mainColor1').val();
			var colorValue2 = $('#mainColor2').val();
			$('body').css("background","linear-gradient("+colorValue1+","+colorValue2+")");
		});
		$('#mainColor2').change(function(){
			var colorValue1 = $('#mainColor1').val();
			var colorValue2 = $('#mainColor2').val();
			$('body').css("background","linear-gradient("+colorValue1+","+colorValue2+")");
		});
	});*/
	function test(uid,sessionID,btcat,name,img,price){
			var count1 = document.getElementById("count").value
		insertcart(uid,count1,sessionID,btcat,name,img,price)
		}
		
 var insertcart =	function insertcart(uid,count1,sessionID,btcat,name,img,price){
		var datavalue = {item_uid:uid,amount:count1,user_id:sessionID,itemName:name,itemBottomCategory:btcat,img_m:img,itemPrice:price}
		$(function(){
			$.ajax({
				type:"POST",
				url:"/CartRest/CartInsert",
				data:JSON.stringify(datavalue),
				contentType:"application/json; charset=utf-8",
				success:function(data){
					var jsondata = JSON.parse(data);
					var count =  jsondata.acount[0].count;
					var input = document.querySelector('.cartspan');
					sessionStorage.setItem("amount",count);
					var amount = sessionStorage.getItem("amount");
					document.querySelector('.cartspan').dataset.count = amount;
					alert("장바구니추가완료!")
					document.getElementById("count").value = 1;
				},
				error:function(error){
					console.log("실패");
				}
			})
		})
	}
	var slideIndex = 1;
	showDivs(slideIndex);
	
	function plusDivs(n){
		showDivs(slideIndex += n);
	}
	
	function showDivs(n){
		var i;
		var x = document.getElementsByClassName("slide");
		if(n > x.length){
			slideIndex = 1;
		}
		if(n < 1){
			slideIndex = x.length;
		}
		for(i = 0; i < x.length; i++){
			x[i].style.display = "none";
		}
		x[slideIndex-1].style.display = "block";
	}
	
	
	
	var secondslideIndex = 0;
	carousel();
	
	function carousel(){
		console.log(secondslideIndex);
		var i;
		var x = document.getElementsByClassName("slide");
		for(i = 0; i < x.length; i++){
			x[i].style.display = "none";
		}
		
		secondslideIndex++;
		if(secondslideIndex > x.length){
			secondslideIndex = 1;
		}
		x[secondslideIndex-1].style.display = "block";
		setTimeout(carousel, 5000);
	}
	
	var str;
	
	function changeAmount(amount,uid){
		var datavalue = {amount:amount,item_uid:uid}
		$(function(){
			$.ajax({
				type:"POST",
				url:"/CartRest/changeamount",
				contentType:"application/json; charset=utf-8",
				data:JSON.stringify(datavalue),
				success:function(data){
					
				},
				error:function(){	
				}
				})
			})
		}
		
	function deletefromcart(uid,sessionid,amount){
		var datavalue = {item_uid:uid}
		$(function(){
			$.ajax({
				type:"POST",
				url:"/CartRest/deletecart",
				contentType:"application/json; charset=utf-8",
				data:JSON.stringify(datavalue),
				success:function(data){
					var jsondata = JSON.parse(data);
					var count = jsondata.delete[0].count;
					sessionStorage.removeItem("amount");
					var modifyamount  = sessionStorage.setItem("amount",count-amount);
					document.querySelector('.cartspan').dataset.count = modifyamount;
					window.location.href = "/cart/cart?sessionid="+sessionid+"";
				},
				error:function(){
					
				}
			})
		})
	}

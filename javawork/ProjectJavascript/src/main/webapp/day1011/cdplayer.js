$(function(){
	//h1.title을 클릭시 .music-list를 slide down 한다.
	$("h1.title").click(function(){
		$("ul.music-list").slideDown("slow");
	});
	//노래 제목을 클릭시 클릭한 곳의 제목을 얻어서 h1.title에 넣은 후 slideup한다.
	$("ul.music-list li").click(function(){
		//노래제목
		let title = $(this).text();
		console.log(title);
		$("h1.title").text(title);
		//class를 얻는다.
		let selectClass=$(this).attr("class");
		
		//적용 - animate
		$("#cd").animate({width:'0'},'slow',function(){
			//cd변경
			$("#cd").attr("class",selectClass);
			//너비를 다시 300으로 변경
			$(this).animate({width:'300px'},'slow')
		})
		$("ul.music-list").slideUp("slow");
	});
})
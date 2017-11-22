$(function(){
    $(".panel-heading").click(function(e){
        /*切换折叠指示图标*/
        $(this).find("span").toggleClass("glyphicon-chevron-down");
        $(this).find("span").toggleClass("glyphicon-chevron-up");
    });

    
    $(".list-group-item").find("a").click(function(e){
    	$(".curr-a").removeClass("curr-a");
    	$(this).addClass("curr-a");
    })
    setInterval(offsetMainHeight,100);
    function offsetMainHeight(){
    	var offsetHeight = document.documentElement.clientHeight;
	    var hrader_height = document.getElementById("header").offsetHeight;
	    document.getElementById("main").style.height=(offsetHeight-hrader_height)+"px";
    }

});
function getAjaxPageList_new(str,url,page,structure) {
    $.ajax({
        type: "GET",
        url: url,
        data: {'page': page},
        async:false,
        dataType: 'json',
        beforeSend: function () {
           console.log("正在加载中···");
        },
        success: function (dataObj) {
            if(!dataObj) return;
            paging(dataObj.data);
            $('#HtmlList').html($(replace_str_pre(dataObj.data.list,str,structure)));
        }
    })
}
function replace_str_pre(obj,str,structure){
    var html_str = "";
    for(var i in obj){
        html_str += replace_str(obj[i],str,structure);
    }
    return html_str;
}
function replace_str(obj,str,structure){
    for(var i in structure){
        var reString = obj[structure[i]];
        if(!obj[structure[i]]) reString = "";
        str = str.replace(new RegExp('value.'+structure[i], 'g'), reString);
    }
    return str;
}

function paging(data){
    var total = data.pages
    var pageNum = data.pageNum;
    var pageHtml = "";
    var leftOmit = 0;
    var rightOmit = 0;
    var nextPage = data.nextPage;
    var prePage = data.prePage;
    if(pageNum>1) pageHtml += "<li><a onclick='pageLocation("+prePage+")' href='javascript:;'>&laquo;</a></li>";
    if(total>6 && pageNum>3){
        pageHtml += "<li><a class='disabled' href='javascript:;'>···</a></li>";
    }
    for(var i=1;i<=total;i++){
        if(i==pageNum)
        {
            pageHtml += "<li class='paging active'><a href='javascript:;'>"+i+"</a></li>";
        }else{
            if(pageNum>3 && pageNum-3>=i){
                continue;
            }
            else if(total-pageNum>3 && pageNum+3<=i){
                continue
            }else{
                pageHtml += "<li onclick='pageLocation("+i+")' class='paging'><a href='javascript:;'>"+i+"</a></li>";
            }
        }
    }
    if(total>6 && total-pageNum>3){
        pageHtml += "<li><a class='disabled' href='javascript:;'>···</a></li>";
    }
    if(pageNum<total) pageHtml += "<li><a onclick='pageLocation("+nextPage+")' href='javascript:;'>&raquo;</a></li>";
    $(".pagination").html(pageHtml);
}

function checkForm(form){
    for(var i=0;i<form.length;i++){
        var type = $(form[i]).attr("check-type");
        var tip = $(form[i]).attr("check-tip");
        var val = $(form[i]).val();
        if(type && !checkType(type,val)){
            layer.msg(tip?tip:'不能为空');
            form[i].focus();
            return;
        }
    }
    return true;
}
function checkType(type,val){
    if((type=="*" && !val) || !val){
        return;
    }
    if(type=="double"){
        return isNaN(val) === false;
    }
    if(type=="int"){
        return val % 1 === 0;
    }
    if(type=="selectOne" && val == 0){
    	return;
    }
    return true;
}
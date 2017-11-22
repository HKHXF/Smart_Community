function bule(aaa){
  var td = $(aaa).attr('dataid');
  var bb = $(aaa).attr('dataname');
  $("#focusedInput").val(bb);
  $("#focusedInput").attr("dataid",td);
}


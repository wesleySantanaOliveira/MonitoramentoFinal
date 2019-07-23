
$(document).ready(function(){
  $("#validar").on("keyup", function() {
    var value = $(this).val().toLowerCase();
    $("#spinner tr").filter(function() {
      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
    });
  });
});

<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <script type="text/javascript" src="jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="js/crReq.js"></script>
    <script type="text/javascript" src="js/Header.js"></script>
    <script type="text/javascript" src="js/XML.js"></script>
    <script type="text/javascript" src="js/JSON.js"></script>
    <script>
        $(window).on('load', function() {
            $("[name='fbtn']").click(function(){
                $.ajax({
                    type : "get",
                    url : "http://localhost:8085/lab21/Sss_JSON_sync",
                    data : "n=8",
                    success : function(msg) {
                        $('#json2').html(msg);
                        $('#json2').removeClass('h2');
                        $('#json2').addClass('h1');
                    },
                    dataType : 'text'
                });
            });
        });
    </script>
</head>

<body>
<b> AJAX Example (Header) </b>
<form name="FHeader" action="#" method="POST">
    <input name="x" type="text" value="0" size="5" maxlength="5" />
    <input name="y" type="text" value="0" size="5" maxlength="5" />
    <input name="BAdd" 	value="Add" type="button" size="10"
           maxlength="10"
           onclick="OnClick_Header(this.form.x, this.form.y, this.form.z)"/>
    <input 	name="z" id="z" type="text" value="0" />
</form>
<br/>


<b> AJAX Example (JSON) </b>
<form name="FJSON" action="#" method="POST">
    <input name="n" type="text" value="0" size="2" maxlength="2" />
    <input name="BRand" value="Rand" type="button" size="10" maxlength="10"
           onclick="OnClick_JSON(this.form.n.value,
                     document.getElementById('json'))" />
    &emsp; <span id="json" class="h2">.....</span>
</form>
<br/>


<br/>
<form name="FJSON" action="#" method="POST">
    <input name="n" type="text" value="0" size="2" maxlength="2" />
    <br /><br /><input name="fbtn" value="Rand" type="button" size="10" maxlength="10" id="btn"/>
    <br /><p id="json2" class="h2">.....</p>
</form>
<br/>

<b> AJAX Example (XML) </b>
<form name="FXML" action="#" method="POST">
    <label>
        <input name="n" type="text" value="0" size="2" maxlength="2" />
    </label>
    <input name="BRand" value="Rand" type="button" size="10" maxlength="10"
           onclick="OnClickXml(this.form.n.value,
                     document.getElementById('xml'))" />
    &emsp; <span id="xml" class="h2">.....</span>
</form>

</body>
</html>
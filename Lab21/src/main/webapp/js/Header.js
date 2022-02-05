//Header.js
//JavaScript-сценарий для обмена данными с сервером
function OnClick_Header(x,y,z){
    var req = new XMLHttpRequest();
    var patern = new RegExp(/^[0-9]*\.?[0-9]+$/);
    if (patern.test(x.value) && patern.test(y.value)){
        if (req){
            req.open("POST","http://localhost:8085/lab21/sss_header", true);
            req.setRequestHeader("Value-X",  x.value);
            req.setRequestHeader("Value-Y",  y.value);
            req.onreadystatechange = function(){
                if (req.readyState == 4){
                    if (req.status == 200){
                        z.value=req.getResponseHeader("Value-Z");
                    }
                    else alert("status = " + req.status +"\n" + req.statusText);
                }
            };
            req.send("null");
        }
    }else alert ("error");
}

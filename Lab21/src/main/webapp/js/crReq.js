// crReq.js
//JavaScript-сценарий для создания объекта XMLHTTPRequest
function crReq ()
{
    //alert( "crReq");
    var req = null;
    if (window.XMLHttpRequest)
    {
        req = window.XMLHttpRequest;
        //alert( "req = XMLHttpRequest");
    }
    else if (window.ActiveXObject)
    {
        try{
            req = new ActiveXObject("Msxml2.XMLHTTP");
            //alert( "req = Msxml2.XMLHTTP");
        }catch(e){
            try{
                req = new ActiveXObject("Microsoft.XMLHTTP");
                //alert( "req = Microsoft.XMLHTTP");
            }catch(e){
                req = null;
                //alert( "req = null");
            }
        }
    }
    return req;
}

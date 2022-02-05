function Fill(req){
    let xmldoc = req.responseXML;
    let tsnum = xmldoc.getElementsByTagName("num");
    let rc = "";
    for (let i = 0; i < tsnum.length; i++){
        rc += tsnum[i].textContent + " ";
    }
    return (rc);
}
function OnClickXml(n, s) {
    let patern = new RegExp(/^[1-9]+[0-9]*$/);
    if (patern.test(n)){
        let req = new XMLHttpRequest();
        if (req){
            req.open("POST","http://localhost:8085/lab21/sss_xml",true);
            req.onreadystatechange = function(){
                if (req.readyState == 4){
                    if (req.status == 200){
                        s.firstChild.data = Fill(req);
                        s.className ="h1";
                    }else alert("status = "+
                        req.status +"\n"+req.statusText);
                }
            };
            req.setRequestHeader("XRand-N",  n);
            req.send("null");
        }
    }else alert ("error");
}

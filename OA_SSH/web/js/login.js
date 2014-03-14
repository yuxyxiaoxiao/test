 function showWindow(){
        mask=document.createElement("div");
        var W=$(document).width();
        var H=$(document).height();
        mask.id="mask";
        mask.style.cssText="position:absolute;z-index:5;width:"+W+"px;height:"+H+"px;background:#000;filter:alpha(opacity=30);opacity:0.3;top:0;left:0;";
        document.body.appendChild(mask);
        var o = document.getElementById("edit");
        o.style.display="block";
        o.style.top="300px";
        o.style.left="600px"; 
    }
    function closeWindow(){
    	var mask = document.getElementById("mask");
    		 document.body.removeChild(mask);
    	var edit = document.getElementById("edit");
    	edit.style.display = "none";
    	}
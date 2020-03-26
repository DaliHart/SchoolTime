// <div>
//  <span id="childSpan">foo bar</span>
// </div>

// crear un nodo con un elemento vacío
// sin ID, atributos, ni contenido
function lig(dato)
{
	var info = document.createElement("div");
	info.style.cssText='margin: 0 auto; max-width: 600px; padding: 0.5em; border: 0px solid #CCC;  border-radius: 1em; background-color: white; height: 100px; margin-bottom: 1rem;';
    var w ='I had a dream...';
    var texto = document.createTextNode(w);
    info.appendChild(texto);
    document.getElementById(dato).appendChild(info);


    //var node = document.getElementById(dato);
    //if (node.parentNode){
    // node.removeChild(node.childNodes[0]);
    //}

}


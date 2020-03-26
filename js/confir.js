function confir(){
  var respuesta = confirm("¿Está seguro que desea eliminar este Evento? Al eliminar este evento se enviará un correo donde se dirá que fue cancelado.")
  if (respuesta == true)
  {
    return true;
  }else{
    return false;
  }
};

function confirMod(){
  var respuesta = confirm("¿Está seguro que desea eliminar este Moderador?")
  if (respuesta == true)
  {
    return true;
  }else{
    return false;
  }
};

function confirEdit(){
  var respuesta = confirm("Al editar este evento se reenviará un correo con los nuevos datos.")
  if (respuesta == true)
  {
    return true;
  }else{
    return false;
  }
};

//Marcar Todos los Checboxes

function marcar(source) 
{
  checkboxes=document.getElementsByTagName('input'); //obtenemos todos los controles del tipo Input
  for(i=0;i<checkboxes.length;i++) //recoremos todos los controles
  {
    if(checkboxes[i].name== "grupo[ ]") //solo si es un checkbox entramos
    {
      checkboxes[i].checked=source.checked; //si es un checkbox le damos el valor del checkbox que lo llamó (Marcar/Desmarcar Todos)
    }
  }
}

//Seleccionar al menos un checkbox

    function validar(esto){
      valida=false;
      for(a=0;a<esto.elements.length;a++){
      if(esto[a].name=="para[ ]" && esto[a].checked==true){
      valida=true;
      break
      }
      
      }
      if(!valida){
      alert("Seleccione para quiénes es el evento");return false
      }



      valido=false;
      for(a=0;a<esto.elements.length;a++){
      if(esto[a].name=="grupo[ ]" && esto[a].checked==true){
      valido=true;
      break
      }
      
      }
      if(!valido){
      alert("Seleccione al menos un grupo");return false
      }

    
      
      }



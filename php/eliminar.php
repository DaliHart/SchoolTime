<?php

include "conexion.php";

$id=$_REQUEST['id_evento'];

/* Eliminar Fecha */

$queryFecha="SELECT * FROM tbl_evento AS evento 
INNER JOIN tbl_fecha_evento AS fecha ON evento.id_fecha=fecha.id_fecha 
WHERE evento.id_evento='$id'";
$resultadoFecha=$conexion->query($queryFecha);
$rowFecha=$resultadoFecha->fetch_assoc();
$id_fecha = $rowFecha['id_fecha'];

$queryF="DELETE FROM tbl_fecha_evento WHERE id_fecha='$id_fecha'";
$resultadoF=$conexion->query($queryF);

/* Eliminar Hora */

$queryHora="SELECT * FROM tbl_evento AS evento 
INNER JOIN tbl_hora_evento AS hora ON evento.id_horas=hora.id_horas 
WHERE evento.id_evento='$id'";
$resultadoHora=$conexion->query($queryHora);
$rowHora=$resultadoHora->fetch_assoc();
$id_hora = $rowHora['id_horas'];

$queryF="DELETE FROM tbl_hora_evento WHERE id_horas='$id_hora'";
$resultadoF=$conexion->query($queryF);

/* Eliminar Evento X Grupo */

$queryExG="DELETE FROM tbl_eventoxgrupo WHERE id_evento='$id'";
$resultadoExG=$conexion->query($queryExG);

/* Eliminar Evento */

$query="DELETE FROM tbl_evento WHERE id_evento='$id'";
$resultado=$conexion->query($query);
if ($resultado) {
	if($rol=="Moderador"){
		header("location:../moderador/eventos.php");
	}else{
		header("location:../admin/eventos.php?id=PROGRAMADO");
	}
	
}else{
	echo "Error";
}

?>
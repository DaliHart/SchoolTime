<?php
  session_start();
  include "../php/conexion.php";
  $empty=$_SESSION['usuario'];

  /* Comprobar si el usuario no es vacío o nulo
  Si lo es lo redirigirá al login */
  if($empty == null || $empty ==''){
    session_destroy();
		echo "<script>window.location='../login.php';</script>";
  }
  include "../php/variables.php";
?>


<!DOCTYPE html>
<html lang="es">
<head>
<?php
    
    $title="Moderador | SchoolTime";
    echo Links($title);
    ?>
    <link rel="stylesheet" type="text/css" href="../css/style.css">
    <link rel='stylesheet' href='../css/bootstrap.min.css'>
</head>
<body>
<?php 
    $titulo="eventos";
    echo EventosModerador($titulo); 
    /* Lla funcón EventosModerador() imprime el nav
    para la vista del moderador */?>

<br>
<br>
<br>
<br>

<?php
/* Definición de la variable requerida id del evento */
$id=$_REQUEST['id'];
$query="SELECT * FROM tbl_evento WHERE id_evento='$id'";
$resultado=$conexion->query($query);
$row=$resultado->fetch_assoc();
?>

<!-- Formulario con los datos disponibles para actualizar -->
<form id="for" action="../php/modificar2.php?id=<?php echo $row['id_evento']?>" method="post">
<div class="container margen">
  <div class="row">
    <div class="col-sm">
      <input type="hidden" name="id_evento" placeholder="Id Evento" >
      <!-- Titulo evento -->
        <div class="center nuevo_evento">
            <input type="text" class="titulo_evento" name="titulo_e" value="<?php echo $row['titulo_e'];?>" >
        </div>
        <!-- Tipo de evento -->
   <div class="nuevo_evento">
    <div class="linea_azul">&nbsp;&nbsp;Tipo de evento</div><br>
  <?php
 $queryT="SELECT * FROM tbl_evento AS evento INNER JOIN tbl_tipo_evento AS tipo ON evento.id_tipo=tipo.id_tipo  WHERE evento.id_evento='$id'";
 $resultadoT=$conexion->query($queryT);
 $rowT=$resultadoT->fetch_assoc();
 ?>

 <!-- Si cambio, reunion o celebracion es igual a 1 se seleccionará la opción -->
    <select name="tipo_e" class="form-control" required>
    <option value="">Tipo de Evento</option>
        <option  <?php if($rowT['cambio_horario']=="1"){ echo "selected"; }?>>Cambio de Horario</option>
        <option  <?php if($rowT['reunion']=="1"){ echo "selected"; }?>>Reunion</option>
        <option  <?php if($rowT['celebracion']=="1"){ echo "selected"; }?>>Celebracion</option>
      </select>
</div>

<!-- Fecha -->
<?php
$fecha_actual = date('Y-m-d');
?>
<div class="nuevo_evento">
    <button type="button" class="btn btn-primary">FECHA</button>
    <?php
    $queryF="SELECT * FROM tbl_fecha_evento as fecha INNER JOIN tbl_evento as evento ON fecha.id_fecha=evento.id_fecha WHERE evento.id_evento='$id'";
    $resultadoF=$conexion->query($queryF);
    $rowF=$resultadoF->fetch_assoc();
    ?>
    <input class="fecha" min="<?php echo $fecha_actual ?>" type="date" name="fecha_e" value="<?php echo $rowF['fecha_evento'];?>">
   </div>
   <!-- Hora -->
   <div class="nuevo_evento">
    <button type="button" class="btn btn-primary">HORA</button>
    <?php
    $queryH="SELECT * FROM tbl_hora_evento as hora INNER JOIN tbl_evento as evento ON hora.id_horas=evento.id_horas WHERE evento.id_evento='$id'";
    $resultadoH=$conexion->query($queryH);
    $rowH=$resultadoH->fetch_assoc();
    ?>
    <input class="fecha" type="time" name="hora_e" value="<?php echo $rowH['hora_evento'];?>">
   </div>
    </div>
    <div class="col-sm">
    

<!-- Descripcion -->
<div class="nuevo_evento ">
    <textarea class="descrip" name="descripcion_e" ><?php echo $row['descripcion_e'];?></textarea>
  </div>


    <!-- Para = a qué tipo de público va dirigido el evento-->
    <div class="nuevo_evento">
 <div class="linea_azul">&nbsp;&nbsp;Para</div><br>
 
 <?php
 $queryC="SELECT * FROM tbl_evento AS evento INNER JOIN tbl_eventoxgrupo AS exg  ON evento.id_evento=exg.id_evento  WHERE evento.id_evento='$id'";
 $resultadoC=$conexion->query($queryC);
 $rowC=$resultadoC->fetch_assoc();
 ?>
 <div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="para[ ]" id="e" value="estudiantes" <?php if($rowC['estudiante']=="1"){ echo "checked"; }?>> 
<label class="custom-control-label" for="e">Estudiantes</label>
</div>
<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="para[ ]" id="a" value="docentes" <?php if($rowC['docente']=="1"){ echo "checked"; }?>> 
<label class="custom-control-label" for="a">Docentes</label>
</div>
<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="para[ ]" id="ac" value="acudientes" <?php if($rowC['acudiente']=="1"){ echo "checked"; }?>> 
<label class="custom-control-label" for="ac">Acudientes</label>
</div>
</div>
    </div>
    <div class="col-sm">

    <!-- Dirigido a = grupos a los que va dirigido el evento -->
  <div class="nuevo_evento">
 
 <div class="linea_azul">&nbsp;&nbsp;Dirigido a</div><br>

<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input"  id="Marcar" onclick="marcar(this);"> 
<label class="custom-control-label" for="Marcar">Todos</label>
</div>

<?php
$query="SELECT * FROM tbl_grupo ORDER BY grado_g";
$resultado=$conexion->query($query);
while ($row=$resultado->fetch_assoc()){
?>

<?php

if( $row['grado_g']!=null){
?>

<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="grupo[ ]" id="<?php echo $row['codigo_g']?>" value="<?php echo $row['codigo_g']?>" <?php if($row['codigo_g']==$rowC['codigo_g']){ echo "checked";} ?>> 
<label class="custom-control-label" for="<?php echo $row['codigo_g']?>"><?php echo $row['grado_g']?>°<?php echo $row['grupo_g']?></label>
</div>

<?php
}

if( $row['codigo_g']=="DOCENTES"){
?>

<!-- <small>Docentes</small> -->
<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="grupo[ ]" id="Docentes" value="<?php echo $row['codigo_g']?>" <?php if($row['codigo_g']==$rowC['codigo_g']){ echo "checked";} ?>> 
<label class="custom-control-label" for="Docentes">Docentes sin dirección de grupo</label>
</div>
<?php
}
}
?>
</div> 
    </div>
  </div>
</div>
<center>
  <div class="form-check form-check-inline">
  <input class="btn_nuevo_evn" type="submit" value="">
  </div>
  </center>
</form>






</body>
</html>

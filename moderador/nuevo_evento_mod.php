
<?php
  session_start();
  include "../php/conexion.php";
  $empty=$_SESSION['usuario'];
  if($empty == null || $empty ==''){
    session_destroy();
		echo "<script>window.location='../login.php';</script>";
  }
  include "../php/variables.php";
?>

<!doctype html>
<html>
  <head>
  <?php
    $title="Moderador | SchoolTime";
    echo Links($title);
    ?>
  </head>
  <body >
  <?php 
    $titulo="eventos";
    echo EventosModerador($titulo); ?>

<br>
<br>
<br>
<br>
<form action="../php/cod_registro2.php" method="post" onsubmit="return validar(this);">
<div class="container margen">
  <div class="row">
    <div class="col-sm">
      <input type="hidden" name="id_evento" placeholder="Id Evento" required>
      <!-- Titulo evento -->

          <datalist id="titulo_e">
            <option value="Reunión de..."></option>
            <option value="Reunión de Acudientes"></option>
            <option value="Reunión de Docentes"></option>
            <option value="Cambio en el horario"></option>
            <option value="No hay clase"></option>
            <option value="Día de..."></option>
            <option value=""></option>
          </datalist>
    
        <div class="center nuevo_evento">
            <input list="titulo_e" type="text" class="titulo_evento" name="titulo_e" autocomplete="off" placeholder="Evento sin título" required>
        </div>
        <!-- Tipo de evento -->
   <div class="nuevo_evento">
    <div class="linea_azul">&nbsp;&nbsp;Tipo de evento</div><br>
    <select name="tipo_e" class="form-control" required>
        <option selected>Selecciona...</option>
        <option value="Cambio">Cambio de Horario</option>
        <option value="Reunion">Reunión</option>
        <option value="Celebracion">Celebración</option>
      </select>
</div>







<!-- Fecha -->

        <div class="nuevo_evento">
    <button type="button" class="btn btn-blue">FECHA</button>
    <input class="fecha" type="date" name="fecha_e" required>
   </div>
   <!-- Hora -->
   <div class="nuevo_evento">
    <button type="button" class="btn btn-blue">HORA</button>
    <input class="fecha" type="time" name="hora_e" required>
   </div>


    </div>



    
    <div class="col-sm">

    <!-- Descripcion -->
  <div class="nuevo_evento ">
    <textarea class="descrip" name="descripcion_e" placeholder="Descripción" required></textarea>
  </div>

    <!-- Para -->
<div class="nuevo_evento">
 <div class="linea_azul">&nbsp;&nbsp;Para</div><br>
 <div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="para[ ]" id="e" value="estudiantes" > 
<label class="custom-control-label" for="e">Estudiantes</label>
</div>
<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="para[ ]" id="a" value="docentes"> 
<label class="custom-control-label" for="a">Docentes</label>
</div>
<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="para[ ]" id="ac" value="acudientes"> 
<label class="custom-control-label" for="ac">Acudientes</label>
</div>
</div>
  
    </div>


    <div class="col-sm">


    <!-- Dirigido a -->
  <div class="nuevo_evento">
 
 <div class="linea_azul">&nbsp;&nbsp;Dirigido a</div><br>
 

<!-- Checkbox -->
<!-- <div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="grupo[ ]" id="Todos" value="Todos"> 
<label class="custom-control-label" for="Todos">Todos</label>
</div> -->

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
<input type="checkbox" class="custom-control-input" name="grupo[ ]" id="<?php echo $row['codigo_g']?>" value="<?php echo $row['codigo_g']?>"> 
<label class="custom-control-label" for="<?php echo $row['codigo_g']?>"><?php echo $row['grado_g']?>°<?php echo $row['grupo_g']?></label>
</div>

<?php
}

if( $row['codigo_g']=="DOCENTES"){
?>

<!-- <small>Docentes</small> -->
<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="grupo[ ]" id="Docentes" value="<?php echo $row['codigo_g']?>"> 
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
  <input class="btn_nuevo_evn" type="submit" value="" name="registrar" >
  </div>
  </center>
</form>

 
 


  </body>
</html>


<?php
  session_start();
  include "../php/conexion.php";

  /* Comprobar si el usuario que ha iniciado sesión es administrador con una
  consulta en la base de datos */
  $empty=$_SESSION['usuario'];
  $query = mysqli_query($conexion,"SELECT * FROM tbl_administrador WHERE usuario_adm= '$empty'");

  /* Si el usuario es nulo o está vacío, cerrará la sesión y lo redirigirá al login */
  if($empty == null || $empty ==''){
    session_destroy();
		echo "<script>window.location='../login.php';</script>";
  }

  /* Si el usuario no es administrador, lo devolverá una ventana atrás */
  if(!$consulta = mysqli_num_rows($query)>0 ){
    echo "<script>window.history.back();</script>";
  }
  include "../php/variables.php";
?>

<!doctype html>
<html>
  <head>
  <?php
    $title="Administrador | SchoolTime";
    echo Links($title);
    ?>
  </head>
  <body >
  <?php 
    $titulo="eventos";
    echo Eventos($titulo); ?>

<br>
<br>
<br>
<br>
<!-- Formulario con los datos del evento -->
<form action="../php/cod_registro2.php" method="post" onsubmit="return validar(this);">
<div class="container margen">
  <div class="row">
    <div class="col-sm">
      <input type="hidden" name="id_evento" placeholder="Id Evento" required>
      <!-- Titulo evento -->

          <!-- Lista de sugerencias para el título del evento -->
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
        <option value="">Selecciona...</option>
        <option value="Cambio">Cambio de Horario</option>
        <option value="Reunion">Reunión</option>
        <option value="Celebracion">Celebración</option>
      </select>
</div>







<!-- Fecha -->

<?php
//Adquirir la fecha local del sistema
$fecha_actual = date('Y-m-d');
?>

        <div class="nuevo_evento">
    <button type="button" class="btn btn-blue">FECHA</button>
   <!--  Input fecha con las fechas anteriores al día actual inhabilidatas -->
    <input class="fecha" type="date" min="<?php echo $fecha_actual ?>" name="fecha_e" required>
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

    <!-- Para - campo que hace refencia a qué tipo de público va
    dirigido el evento -->
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

<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input"  id="Marcar" onclick="marcar(this);"> 
<label class="custom-control-label" for="Marcar">Todos</label>
</div>
<!-- Lista de grupos exixtentes para enviar el evento -->
<?php
$query="SELECT * FROM tbl_grupo ORDER BY grado_g";
$resultado=$conexion->query($query);
while ($row=$resultado->fetch_assoc()){
?>


<!-- Si el codigo del grupo es igual a 'DOCENTES' se imprimirá 'Docentes sin dirección'
en lugar del grado y el grupo -->
<?php

if( $row['codigo_g']=="DOCENTES"){
?>

<!-- <small>Docentes</small> -->
<div class="custom-control custom-checkbox">
<input type="checkbox" class="custom-control-input" name="grupo[ ]" id="Docentes" value="<?php echo $row['codigo_g']?>"> 
<label class="custom-control-label" for="Docentes">Docentes sin dirección de grupo</label>
</div>


<?php
}else{
  ?>
  <div class="custom-control custom-checkbox">
  <input type="checkbox" class="custom-control-input" name="grupo[ ]" id="<?php echo $row['codigo_g']?>" value="<?php echo $row['codigo_g']?>"> 
  <label class="custom-control-label" for="<?php echo $row['codigo_g']?>"><?php echo $row['grado_g']?>°<?php echo $row['grupo_g']?></label>
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
  <!-- Botón para registrar -->
  <input class="btn_nuevo_evn" type="submit" value="" name="registrar" >
  </div>
  </center>
</form>

 
 


  </body>
</html>


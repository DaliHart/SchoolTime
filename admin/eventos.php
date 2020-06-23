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
echo Eventos($titulo);

/* Variable requerida estado, que hace referencia al estado del
evento, el cual puede ser Programado, Cumplido o Cancelado */
$estado=$_REQUEST['id'];

$id_evento_actual="";
?>
    <br>
    <br>
    <br>
    <br>

    <div class="container">
      <div class="row">

      <!-- Consulta de los eventos programados en orden descendente -->
  <?php
	$query="SELECT * FROM tbl_evento  WHERE estado_e='$estado' order by id_evento desc";
  $resultado=$conexion->query($query);

	while ($row=$resultado->fetch_assoc()){
    $id_evento_actual = $row['id_evento'];
  ?>


    <!-- Muestra de ícono de acuerdo al tipo de evento -->
  <div class="col-sm">
            <div class="card evento" onclick="lig(4)">
    <div class="row no-gutters">
      <div class="col-md-4">
        <?php if($row['id_tipo']=="00B"){
          ?>
          <img class="tipo-evento" src="../svg/cambio.svg">
          <?php

        }elseif($row['id_tipo']=="00C"){
          ?>
          <img class="tipo-evento" src="../svg/reunion.svg">
          <?php

        }else{
          ?>
          <img class="tipo-evento" src="../svg/fiesta.svg">
<?php
        }?>
        
      </div>
      <!-- <div class="col-md-1">
      </div> -->
      <div class="col-md-7">
        
          <div class=" titulo_perfil large"><?php echo $row['titulo_e']?></div>
  
       
    </div>
  </div>
 <!--  <p class="titulo_perfil"><?php echo $row['titulo_e']?></p> -->
  <table class="table">
  <thead>
    <tr>
      <th  scope="col">Descripción</th>
      <td class="st_ryde"><?php echo $row['descripcion_e']?></td>
    </tr>
  </thead>
  <tbody>
    <tr>
    <th scope="col">Fecha</th>

    <!-- Consulta de la fecha del evento -->
    <?php 
    $consultaFecha="SELECT * FROM tbl_evento as evento INNER JOIN tbl_fecha_evento as fecha ON evento.id_fecha=fecha.id_fecha where evento.id_evento='$id_evento_actual'";
	$result=$conexion->query($consultaFecha);
	while ($rowF=$result->fetch_assoc()){
  ?>
     <td class="st_ryde"><?php echo $rowF['fecha_evento']?></td>
     <?php
     }
     ?>
    </tr>
    <tr>
    <th scope="col">Hora</th>

    <!-- Consulta de la hora del evento -->
    <?php 
    $consultaFecha="SELECT * FROM tbl_evento as evento INNER JOIN tbl_hora_evento as hora ON evento.id_horas=hora.id_horas  where evento.id_evento='$id_evento_actual'";
	$result=$conexion->query($consultaFecha);
	while ($rowH=$result->fetch_assoc()){
  ?>
    <td class="st_ryde"><?php echo $rowH['hora_evento']?></td>
    <?php
  }
    ?>
</tr>
<tr>
    <th scope="col">Dirigido a</th>
    <td class="st_ryde">

    <!-- Grupo a los que va dirigido el evento -->
    <?php
    $consultaDirigido="SELECT * FROM tbl_eventoxgrupo as exg INNER JOIN tbl_evento as evento ON exg.id_evento=evento.id_evento INNER JOIN tbl_grupo as grupo ON exg.codigo_g=grupo.codigo_g WHERE exg.id_evento='$id_evento_actual' ORDER BY grupo.grado_g";
  $resulta=$conexion->query($consultaDirigido);

  /* Variable count para imprimir 'Estudiantes Acudientes Docentes de' solo una vez */
  $count=1;
	while ($rowD=$resulta->fetch_assoc()){
    ?>
    <?php

    if($rowD['grado_g']!=null){
      if($count==1){
        if($rowD['estudiante'] == "1"){
          echo " Estudiantes ";
        }
        if($rowD['acudiente'] == "1"){
          echo " Acudientes ";
        }
        if($rowD['docente'] == "1"){
          echo " Docentes ";
        }
  
        echo " de ";
  
      }
      $count++;
  
      echo $rowD['grado_g']."°".$rowD['grupo_g'];

      /* Si el codigo del grupo es igual a 'DOCENTES' imprimirá 'Docentes sin dirección' */
    }elseif($rowD['codigo_g']=="DOCENTES"){
      echo "Docentes sin dirección.";
    }
    


    
    ?>
     <?php
     }
     ?>
  </td>
  
</tr>

<!-- La opción eliminar evento solo aparecerá si el estado del evento es PROGRAMADO -->
<?php
if($estado=="PROGRAMADO"){
?>
<tr>
<td >

    <a href="../php/eliminar2.php?id_evento=<?php echo $row['id_evento']?>" style="color: white; text-decoration: none; " onclick="return confir();">
<button type="button" class="btn btn-danger btn_icon">
    <img class="icon" src="../svg/delete.svg"></button></a>

</td>
<td >


  <!-- Link para editar eventos -->
  <a href="actualizar_evento.php?id=<?php echo $row['id_evento']?>" style="color: white; text-decoration: none;" onclick="return confirEdit();">
<button type="button" class="btn btn-primary btn_icon edit2 ">
  <img class="icon" src="../svg/edit.svg"></button></a>

  </td >
</tr>

<?php
}
?>

	
  </tbody>
</table>

</div>
</div>
<?php
  }
?>

</div>
</div>


    


















    

    

    
 <center>
  <div class="form-check form-check-inline">
  <input class="btn_ok large" type="button" onclick="window.location.href = '<?php echo $n_evento?>';" value="Nuevo Evento">
  </div>
  </center>


</div>
</div>

</div>

  </body>
</html>
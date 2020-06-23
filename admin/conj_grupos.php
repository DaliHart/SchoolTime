<!-- Conjunto de grupo o Jornada y grupos que pertenecen a ella -->
<?php
  session_start();
  include "../php/conexion.php";
  $empty=$_SESSION['usuario'];

  /* Comprobar si el usuario que ha iniciado sesión es administrador con una
  consulta en la base de datos */
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
  <body>
    <?php 
    $titulo="grupos";
    echo Eventos($titulo); ?>
<br>
<br>
<br>
<br>
<?php
/* Definición de la variable requerida id para ver los grupos de la jornda */
$id=$_REQUEST['id'];
  $queryJ="SELECT * FROM tbl_jornada WHERE id_jornada='$id'";
  $resultadoJ=$conexion->query($queryJ);
  $rowJ=$resultadoJ->fetch_assoc();
  ?>

<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <?php
  if($rowJ['id_jornada'] == "J1"){
    ?>
    <img class="tipo-evento" src="../iconos/manana3.png">
    <?php
  }elseif($rowJ['id_jornada'] == "J2"){
    ?>
    <img class="tipo-evento" src="../iconos/tarde3.png">
    <?php
  }else{
    ?>
    <img class="cuadro_grupo">
    <?php
  }
  ?>

    <!-- Descripción/Nombre de la Jornada -->
    <?php echo $rowJ['descripcion_j']?>

    <table class="table margin-top-1">
    <thead>
    <tr>
      <th scope="col">Grupo</th>
      <th>Código</th>
      <th></th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  

  <!-- Mostrar los grupos que pertecen a la jornada -->
  <?php
  $query="SELECT * FROM tbl_grupo WHERE id_jornada='$id' ORDER BY grado_g";
	$resultado=$conexion->query($query);
	while ($row=$resultado->fetch_assoc()){
  ?>
  
  <tbody>
    <tr>
    <th scope="col"><?php echo $row['grado_g']?>°<?php echo $row['grupo_g']?></th>
     <td><?php echo $row['codigo_g']?></td>
     <td>
     </td>
     <td>

     <!-- Link para ver los integrantes del grupo -->
      <a  href="grupos_desc.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
     <button type="button" class="btn btn-primary btn-icon-2">
      <img class="icon" src="../svg/view.png"></button></a>
     </td>

     <td>

     <!-- Link para actualizar el grupo seleccionado -->
      <a  href="actualizar_grupo.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
     <button type="button" class="btn btn-primary btn-icon-2">
      <img class="icon" src="../svg/edit.svg"></button></a>
     </td>
    </tr>

    <?php
}
?>

    
  </tbody>
</table>

    
  </div>
</div>








</div>
  





<center>
<a href="nuevo_grupo.php?id=<?php echo $rowJ['id_jornada']?>">
  <div class="form-check form-check-inline">
  <input  class="btn_ok large" type="button" value="Nuevo Grupo">
  </div>
  </a>
  </center>


  </body>
</html>
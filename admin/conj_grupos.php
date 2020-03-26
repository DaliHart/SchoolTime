<?php
  session_start();
  include "../php/conexion.php";
  $empty=$_SESSION['usuario'];
  $query = mysqli_query($conexion,"SELECT * FROM tbl_administrador WHERE usuario_adm= '$empty'");
  if($empty == null || $empty ==''){
    session_destroy();
		echo "<script>window.location='../login.php';</script>";
  }
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
$id=$_REQUEST['id'];
  $queryJ="SELECT * FROM tbl_jornada WHERE id_jornada='$id'";
  $resultadoJ=$conexion->query($queryJ);
  $rowJ=$resultadoJ->fetch_assoc();
  ?>

<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <img class="cuadro_grupo">
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
     <button type="button" class="btn btn-primary btn-icon-2">
      <a  href="grupos_desc.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
      <img class="icon" src="../svg/view.png"></a></button>
     </td>

     <td>
     <button type="button" class="btn btn-primary btn-icon-2">
      <a  href="actualizar_grupo.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
      <img class="icon" src="../svg/edit.svg"></a></button>
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
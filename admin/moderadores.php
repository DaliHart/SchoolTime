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
    $titulo="perfil";
    echo Eventos($titulo); ?>
<br>
<br>
<br>
<br>

<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <img class="cuadro_grupo">
    Moderadores

    <table class="table margin-top-1">
    <thead>
    <tr>
      <th scope="col">Nombre</th>
      <th>Cargo</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  
  <tbody>

  <?php
	$query="SELECT * FROM tbl_moderador order by nombre_mod ";
	$resultado=$conexion->query($query);
	while ($row=$resultado->fetch_assoc()){
  
  ?>


    <tr>
    <th scope="col"><?php echo $row['nombre_mod']; ?></th>
     <td><?php echo $row['cargo_mod']; ?></td>
     <td>
     </td>
    
     <td>
      <a href="actualizar_mod.php?id=<?php echo $row['id_moderador']?>" style="color: white; text-decoration: none;">
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
  <div class="form-check form-check-inline">
  <input class="btn_ok large" type="button" onclick="window.location.href = '<?php echo $n_moderador?>';" value="Nuevo Moderador">
  </div>
  </center>


  </body>
</html>
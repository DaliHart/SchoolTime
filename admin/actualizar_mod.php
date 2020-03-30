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
    echo Eventos($titulo); 
    $id=$_REQUEST['id'];
    ?>
<br>
<br>
<br>
<br>



<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <div class="row no-gutters">
  <div class="col-md-4">
  <img class="cuadro_grupo">
  Editar Moderador
  </div>
  <div class="col-md-9">
  <div class="form-group">
    <!-- <input type="text" class="input margin-2 width-80" id="buscador" placeholder="Buscar"> -->
  </div>
  </div>
  </div>
 

    
    <div class="table-responsive">
    <table class="table margin-top-1">

  <?php
	$queryDoc="SELECT * FROM tbl_moderador WHERE id_moderador='$id'";
	$resultadoDoc=$conexion->query($queryDoc);
	while ($rowDoc=$resultadoDoc->fetch_assoc()){
  ?>
  <form action="../php/modificar_mod.php?id=<?php echo $id?>" method="post">
  <tbody>
    <br>
    <tr>
    <td>
    <label class="bold" for="nombre">Nombre</label>
    </td>
    <td>
    <input type="text" class="titulo_evento" id="nombre" autocomplete="off" name="nombre_mod" value="<?php echo $rowDoc['nombre_mod']?>" required>
    </td>
    </tr>

    <tr>
    <td>
    <label class="bold" for="apellido">Apellido</label>
    </td>
    <td>
    <input type="text" class="titulo_evento" id="apellido" autocomplete="off" name="apellido_mod" value="<?php echo $rowDoc['apellido_mod']?>" required>
    </td>
    </tr>

    <tr>
    <td>
    <label class="bold" for="cargo">Cargo</label>
    </td>
    <td>
    <input type="text" class="titulo_evento" id="cargo" autocomplete="off" name="cargo_mod" value="<?php echo $rowDoc['cargo_mod']?>" required>
    </td>
    </tr>

    <tr>
    <td >

        <a href="../php/eliminar_mod.php?id=<?php echo $rowDoc['id_moderador']?>" style="color: white; text-decoration: none; " onclick="return confirMod();">
    <button type="button" class="btn btn-danger btn_icon">
        <img class="icon" src="../svg/delete.svg"></button></a>

    </td>
    <td >


    

   


    <?php
}
?>


  </tbody>
</table>  
</div>

    
  </div>
</div>
</div>
  


<center>
  <div class="form-check form-check-inline">
  <input class="btn_aceptar" type="submit" value="" name="actualizar">
  </div>
</center>
</form>

  </body>
</html>
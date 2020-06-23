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
  </div>
  </div>
  </div>
 

    
    <div class="table-responsive">
    <table class="table margin-top-1">

  <!-- Consulta de los datos de moderador a modificar -->
  <?php
	$queryDoc="SELECT * FROM tbl_moderador WHERE id_moderador='$id'";
	$resultadoDoc=$conexion->query($queryDoc);
	while ($rowDoc=$resultadoDoc->fetch_assoc()){
  ?>

  <!-- Formulario con los datos disposibles para modificar -->
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

        <!-- Botón para eliminar Moderador
        El moderador sólo puede eliminarse si no ha creado ningún evento antes -->
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
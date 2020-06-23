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
/* Definición de variable requeriga codigo del grupo para acceder a los datos */
  $codigo=$_REQUEST['id'];

  /* Consulta los datos del grupo selecionado */
	$query="SELECT * FROM tbl_grupo WHERE codigo_g='$codigo'";
  $resultado=$conexion->query($query);
  $row=$resultado->fetch_assoc();
  ?>

<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <div class="row no-gutters">
  <div class="col-md-3">

  <!-- Imprime el grado y grupo del grupo seleccionado -->
  <img class="cuadro_grupo"> <?php echo $row['grado_g']?>°<?php echo $row['grupo_g']?>
  
  
  
  </div>
  <div class="col-md-9">
  <div class="form-group">
  </div>
  </div>
  </div>
 

    
    <div class="table-responsive">
    <table class="table margin-top-1">
    <form action="../php/modificar_grupo.php?id=<?php echo $row['codigo_g']?>" method="post">
    <tbody>
    <br>
      <label class="bold" for="codigoG">Editar Codigo</label>
      <input type="text" class="titulo_evento" id="codigoG" name="codigo_grupo" value="<?php echo $row['codigo_g']?>" required>
      <div class="linea_azul"></div>
      <br>
      <select name="jornada" class="form-control">
      
      <!-- Consulta de las jornadas para seleccionar -->
      <?php
	$queryJ="SELECT * FROM tbl_jornada";
	$resultadoJ=$conexion->query($queryJ);
	while ($rowJ=$resultadoJ->fetch_assoc()){
    ?>
    <option value="<?php echo $rowJ['id_jornada']?>" <?php if($rowJ['id_jornada']==$row['id_jornada']){ echo "selected"; }?>><?php echo $rowJ['descripcion_j'] ?></option>
    <?php
    }
    ?>
    </select>
    
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
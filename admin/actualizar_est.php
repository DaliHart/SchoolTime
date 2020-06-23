<!-- Actualizar Estudiante -->
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
    echo Eventos($titulo); 
    /* Definir la variable id requerida para acceder a los datos actuales del estudiante */
    $id=$_REQUEST['id'];
    echo $id;
    ?>
<br>
<br>
<br>
<br>


<!-- Encabezado con el título e ícono estudiante -->
<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <div class="row no-gutters">
  <div class="col-md-4">
  <img class="tipo-evento" src="../iconos/estudiante.png">
  Editar Estudiante
  </div>
  <div class="col-md-9">
  <div class="form-group">
  </div>
  </div>
  </div>
 

    
    <div class="table-responsive">
    <table class="table margin-top-1">

  <!-- Consulta a la base de datos para acceder a los datos del estudiante por el id -->
  <?php
	$queryDoc="SELECT * FROM tbl_estudiante WHERE id_estudiante='$id'";
	$resultadoDoc=$conexion->query($queryDoc);
	while ($rowDoc=$resultadoDoc->fetch_assoc()){
  ?>

  <!-- Formulario con los campos dispinibles para actualizar -->
  <form action="../php/modificar_est.php?id=<?php echo $id?>" method="post">
  <tbody>
    
    <tr>
    <td>
    <label class="bold" for="nombre">Nombre</label>
    </td>
    <td>
    <input type="text" class="titulo_evento" id="nombre" name="nombre_e" value="<?php echo $rowDoc['nombre_e']?>" required>
    </td>
    </tr>

    <tr>
    <td>
    <label class="bold" for="apellido">Apellido</label>
    </td>
    <td>
    <input type="text" class="titulo_evento" id="apellido" name="apellido_e" value="<?php echo $rowDoc['apellido_e']?>" required>
    </td>
    </tr>

    <tr>
    <td>
    <label class="bold" for="matricula">Matricula</label>
    </td>
    <td>
    <input type="text" class="titulo_evento" id="matricula" name="matricula_e" value="<?php echo $rowDoc['matricula_e']?>" required>
    </td>
    </tr>

    <tr>
    <td>
    <label class="bold" for="correo">Correo</label>
    </td>
    <td>
    <input type="text" class="titulo_evento" id="correo" name="correo_e" value="<?php echo $rowDoc['correo_e']?>" required>
    </td>
    </tr>


    <tr>
    <td>
    <label class="bold" for="nombre">Pertenece a</label>
    </td>
    <td>
    <select name="grupo_e" class="form-control" required>
    <option value="">Grupo sin seleccionar</option>

    <!-- Consulta de los grupos existentes -->
    <?php
	$queryG="SELECT * FROM tbl_grupo ORDER BY grado_g";
	$resultadoG=$conexion->query($queryG);
	while ($rowG=$resultadoG->fetch_assoc()){
    ?>
       <option value="<?php echo $rowG['codigo_g']?>" <?php if($rowG['codigo_g']==$rowDoc['codigo_g']){ echo "selected"; }?>><?php 
       if($rowG['grado_g']!=null){echo $rowG['grado_g']."°".$rowG['grupo_g'];}elseif($rowG['codigo_g']=="DOCENTES"){ echo "Docentes sin dirección";}?></option>
    <?php
    }
    ?>   
      </select>
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
</div>
  


<center>
  <div class="form-check form-check-inline">
  <input class="btn_aceptar" type="submit" value="" name="actualizar">
  </div>
</center>
</form>

  </body>
</html>
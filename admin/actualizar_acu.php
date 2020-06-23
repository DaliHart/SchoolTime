<!-- Actualizar Acudiente -->
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
    /* Vea la descripción de la funcipon Links() en php/variables.php */
    echo Links($title);
    ?>
  </head>
  <body>
    <?php 
    $titulo="grupos";
    /* Vea la descripción de la función Eventos() en php/variables.php */
    echo Eventos($titulo); 
    $id=$_REQUEST['id'];
    
    ?>
<br>
<br>
<br>
<br>


<!-- Encabezado con e ícono de acudiente y título -->
<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <div class="row no-gutters">
  <div class="col-md-4">
  <img class="tipo-evento" src="../iconos/acudiente.png">
  Editar Acudiente
  </div>
  <div class="col-md-9">
  <div class="form-group">
  </div>
  </div>
  </div>
 

    
    <div class="table-responsive">
    <table class="table margin-top-1">


  <!-- Consulta a la base de datos para obtener los datos del acudiente por el id -->
  <?php
	$queryDoc="SELECT * FROM tbl_acudiente WHERE id_acudiente='$id'";
	$resultadoDoc=$conexion->query($queryDoc);
	while ($rowDoc=$resultadoDoc->fetch_assoc()){
  ?>
  <form action="../php/modificar_acu.php?id=<?php echo $id?>" method="post">
  <tbody>
    
    <!-- Nombre del acudiente -->
    <tr>
    <td>
    <label class="bold" for="nombre">Nombre</label>
    </td>
    <td>
    <input type="text" class="titulo_evento" id="nombre" name="nombre_acu" value="<?php echo $rowDoc['nombre_acu']?>" required>
    </td>
    </tr>

    <!-- Apellido del acudiente -->
    <tr>
    <td>
    <label class="bold" for="apellido">Apellido</label>
    </td>
    <td>
    <input type="text" class="titulo_evento" id="apellido" name="apellido_acu" value="<?php echo $rowDoc['apellido_acu']?>" required>
    </td>
    </tr>

      <!-- Correo electrónico del acudiente -->
    <tr>
    <td>
    <label class="bold" for="correo">Correo</label>
    </td>
    <td>
    <input type="email" class="titulo_evento" id="correo" name="correo_acu" value="<?php echo $rowDoc['correo_acu']?>" required>
    </td>
    </tr>

    <!-- Grupo al que pertenece el acudiente -->
    <tr>
    <td>
    <label class="bold" for="nombre">Pertenece a</label>
    </td>
    <td>

    <!-- Consulta de los grupos existentes en la base de datos para seleccionar  -->
    <select name="grupo_acu" class="form-control" required>
    <option value="">Grupo sin seleccionar</option>
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
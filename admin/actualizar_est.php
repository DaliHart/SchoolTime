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
    echo Eventos($titulo); 
    $id=$_REQUEST['id'];
    echo $id;
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
  <img class="tipo-evento" src="../iconos/docente3.png">
  Editar Estudiante
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
	$queryDoc="SELECT * FROM tbl_estudiante WHERE id_estudiante='$id'";
	$resultadoDoc=$conexion->query($queryDoc);
	while ($rowDoc=$resultadoDoc->fetch_assoc()){
  ?>
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
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
  <body >
    
<?php 
    $titulo="grupos";
    echo Eventos($titulo);?>
    <br>
    <br>
    <br>
    <br>
    

    <div class="center-90">


      <div class="medio">
  <img class="cuadro_grupo default">
    <a class="titulo_perfil default">Nuevo estudiante</a>
    <form action="../php/crear_estudiante.php" method="post">
    <input type="number" class="titulo_evento margin-1 " name="id_e" autocomplete="off" placeholder="Número de Identificación" required>
    <div class="linea_azul"></div>
    <input type="text" class="titulo_evento margin-1 " name="nombre_e" autocomplete="off" placeholder="Nombres" required>
    <div class="linea_azul"></div>
    <input type="text" class="titulo_evento margin-1 " name="apellido_e" autocomplete="off" placeholder="Apellidos" required>
    <div class="linea_azul"></div>
    <input type="text" class="titulo_evento margin-1 " name="matricula_e" autocomplete="off" placeholder="Matricula" required>
    <div class="linea_azul"></div>
    <input type="email" class="titulo_evento margin-1 " name="correo_e" autocomplete="off" placeholder="Correo Electrónico" required>
    <div class="linea_azul"></div>
    <input type="password" class="titulo_evento margin-1 " name="contrasena_e" placeholder="Contraseña" required>
    <div class="linea_azul"></div>
    <input type="password" class="titulo_evento margin-1 " name="contrasena2_e" placeholder="Confirmar Contraseña" required>
    <div class="linea_azul"></div>

    <br>
    <select name="grupo_e" class="form-control" required>
    <option value="DOCENTES">Grupo sin seleccionar</option>
    <?php
	$queryG="SELECT * FROM tbl_grupo ORDER BY grado_g";
	$resultadoG=$conexion->query($queryG);
	while ($rowG=$resultadoG->fetch_assoc()){
    ?>
       <option value="<?php echo $rowG['codigo_g']?>" ><?php 
       if($rowG['grado_g']!=null){echo $rowG['grado_g']."°".$rowG['grupo_g'];}elseif($rowG['codigo_g']=="DOCENTES"){ echo "Docentes sin dirección";}?></option>
    <?php
    }
    ?>   
</select>
    

    <br>
</div>


</div>

 <center>
  <div class="form-check form-check-inline">
  <input class="btn_aceptar large" type="submit" name="crear" value="Crear">
  </div>
  </center>
</form>

</div>
</div>

</div>

  </body>
</html>
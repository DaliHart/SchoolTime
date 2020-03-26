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
    $titulo="perfil";
    echo Eventos($titulo);?>
    <br>
    <br>
    

    <div class="center-90">


      <div class="medio">
  <img class="cuadro_grupo default">
    <a class="titulo_perfil default">Nuevo moderador</a>
    <form action="../php/crear_mod.php" method="post">
    <input type="text" class="titulo_evento margin-1 " name="nombre_mod" autocomplete="off" placeholder="Nombres" required>
    <div class="linea_azul"></div>
    <input type="text" class="titulo_evento margin-1 " name="apellido_mod" autocomplete="off" placeholder="Apellidos" required>
    <div class="linea_azul"></div>
    <input type="text" class="titulo_evento margin-1 " name="cargo_mod" autocomplete="off" placeholder="Cargo" required>
    <div class="linea_azul"></div>
    <input type="text" class="titulo_evento margin-1 " name="usuario_mod" autocomplete="off" placeholder="Usuario" required>
    <div class="linea_azul"></div>
    <input type="password" class="titulo_evento margin-1 " name="contrasena_mod" placeholder="Contraseña" required>
    <div class="linea_azul"></div>
    <input type="password" class="titulo_evento margin-1 " name="contrasena2_mod" placeholder="Confirmar Contraseña" required>
    <div class="linea_azul"></div>

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
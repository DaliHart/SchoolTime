<?php
  session_start();
  include "../php/conexion.php";
  $empty=$_SESSION['usuario'];
  if($empty == null || $empty ==''){
    session_destroy();
		echo "<script>window.location='../login.php';</script>";
  }
  include "../php/variables.php";
?>

<!doctype html>
<html>
  <head>
  <?php
    $title="Perfil | SchoolTime";
    echo Links($title);
    ?>
  </head>
  <body>
    <?php 
    $titulo="perfil";
    echo EventosModerador($titulo); ?>

<br>
<br>
<br>
<br>
<div class="center-90">
  <div class="medio">
    <img class="tipo-evento" src="../svg/admin.svg">
    <a class="titulo_perfil default">Moderador</a>
</div>


<div class="medio">
  <table class="table">
  <thead>
    <tr>
      <th class="default" >Configuración de la cuenta</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td class="pointer" onclick="window.location.href = 'contrasena_mod.php';">Cambiar contraseña</td>
    </tr>
    <tr>
      <td class="pointer" onclick="window.location.href = '../php/logout.php';">Cerrar Sesión</td>
    </tr>

  </tbody>
</table>
</div>

</div>



  
<center>
  <div class="form-check form-check-inline">
  <input class="invisible" type="button" >
  </div>
</center>

  </body>
</html>


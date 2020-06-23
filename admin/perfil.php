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
    $title="Perfil | SchoolTime";
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
  <div class="medio">
    <img class="tipo-evento" src="../svg/admin.svg">
    <a class="titulo_perfil default">Administrador</a>
</div>

<!-- Link para acceder a la lista de moderadores -->
<a class="titulo_perfil pointer">
<div class="medio grupo" onclick="window.location.href = '<?php echo $moderadores?>';">
  <img class="tipo-evento" src="../iconos/moderador.png"v>
    Moderadores
</div>
</a>

<div class="medio">
  <table class="table">
  <thead>
    <tr>
      <th class="default">Configuración de cuenta</th>
    </tr>
  </thead>
  <tbody>
  <!-- Link cambiar contraseña -->
    <tr class="azul">
      <td class="pointer" onclick="window.location.href = '<?php echo $cambiar_contra ?>';">Cambiar contraseña</td>
    </tr>
    <!-- Link cerrar sesión -->
    <tr class="azul">
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


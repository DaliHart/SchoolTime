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
  </head><body >
    
    <?php 
        $titulo="perfil";
        echo Eventos($titulo); ?>
        <br>
        <br>
        <br>
        <br>
    
        <div class="center-90">
        <div class="medio">
        <img class="cuadro_grupo default">

        <!-- Formulario para cambiar contraseña -->
        <a class="titulo_perfil default">Cambiar Contraseña</a>
        <form action="../php/cambiar_contra.php" method="post">
        <input type="password" class="titulo_evento margin-1 " name="contrasena" placeholder="Contraseña actual" required>
        <div class="linea_azul"></div>
        <input type="password" class="titulo_evento margin-1 " name="n_contrasena" placeholder="Nueva contraseña" required>
        <div class="linea_azul"></div>
        <input type="password" class="titulo_evento margin-1 " name="confir_n_contrasena" placeholder="Confirmar nueva contraseña" required>
        <div class="linea_azul"></div>
        
    </div>
    </div>
    
     <center>
      <div class="form-check form-check-inline">
      <input class="btn_aceptar" type="submit" value="">
      </div>
      </center>
    </form>
    
    </div>
    </div>
    
    </div>
    
      </body>
      </html>
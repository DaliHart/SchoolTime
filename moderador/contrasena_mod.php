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
    
    $title="Moderador | SchoolTime";
    echo Links($title);
    ?>
  </head><body >
    
    <?php 
        $titulo="perfil";
        echo EventosModerador($titulo); ?>
        <br>
        <br>
        <br>
        <br>
    
        <div class="center-90">
    
    
        <div class="medio">
        <img class="cuadro_grupo default">
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
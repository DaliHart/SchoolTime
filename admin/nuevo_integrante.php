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

<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <div class="row no-gutters">
  <div class="col-md-4">
  <img class="tipo-evento" src="../iconos/nuevo.png">
  Nuevo Integrante
  </div>
  <div class="col-md-9">
  <div class="form-group">
  </div>
  </div>
  </div>
 

    
    <div class="table-responsive">
    <table class="table margin-top-1">
    <thead>
    <!-- Link para acceder a Nuevo Estudiante -->
    <tr class="azul">
    <td class="pointer" onclick="window.location.href = '<?php echo $n_estudiante ?>';">Nuevo Estudiante</td>
    </tr>
    <!-- Link para acceder a Nuevo Acudiente -->
    <tr class="azul">
    <td class="pointer" onclick="window.location.href = '<?php echo $n_acudiente ?>';">Nuevo Acudiente</td>
    </tr>
    <!-- Link para acceder a Nuevo Docente -->
    <tr class="azul">
    <td class="pointer" onclick="window.location.href = '<?php echo $n_docente ?>';">Nuevo Docente</td>
    </tr>
    

    
  </thead>

</table>  
</div>

    
  </div>
</div>

</div>
  



  </body>
</html>
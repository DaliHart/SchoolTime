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
    <!-- <input type="text" class="input margin-2 width-80" id="buscador" placeholder="Buscar"> -->
  </div>
  </div>
  </div>
 

    
    <div class="table-responsive">
    <table class="table margin-top-1">
    <thead>
    <tr class="azul">
    <td class="pointer" onclick="window.location.href = '<?php echo $n_estudiante ?>';">Nuevo Estudiante</td>
    </tr>

    <tr class="azul">
    <td class="pointer" onclick="window.location.href = '<?php echo $n_acudiente ?>';">Nuevo Acudiente</td>
    </tr>

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
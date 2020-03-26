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
    echo Eventos($titulo); ?>
    <br>
    <br>
    <br>
    <br>

    <?php
  $jornada=$_REQUEST['id'];

    ?>

    <div class="center-90">


      <div class="medio">
  <img class="cuadro_grupo default">
    <a class="titulo_perfil default">Nuevo grupo</a>
<form action="../php/crear_grupo.php" method="post">

      <select name="grado" id="inputState" class="form-control" required>
        <option >Seleccione Grado...</option>
        <option  value="1" >Primero</option>
        <option value="2">Segundo</option>
        <option value="3">Tercero</option>
        <option value="4">Cuarto</option>
        <option value="5">Quinto</option>
        <option value="6">Sexto</option>
        <option value="7">Séptimo</option>
        <option value="8">Octávo</option>
        <option value="9">Noveno</option>
        <option value="10">Décimo</option>
        <option value="11">Once</option>
      </select>

    <input type="text" class="titulo_evento" name="grupo" placeholder="Grupo" required>
    <div class="linea_azul"></div>
    <br>
    <select name="jornada" id="inputState" class="form-control" required>
        <option >Seleccione Jornada...</option>
        <option  value="Manana" >Jornada Mañana</option>
        <option value="Tarde">Jornada Tarde</option>
      </select>
      <br>

      <input type="text" class="titulo_evento" name="codigo_grupo" placeholder="Código" required>

      <div class="linea_azul"></div>
    <!-- <button type="button" class="btn btn_st_blue">Generar código</button> -->
</div>
</div>
 <center>
  <div class="form-check form-check-inline">
  
  <input class="btn_aceptar" type="submit" value="" name="crear">
  </div>
  
  </center>
</form>

</div>
</div>

</div>

  </body>
</html>
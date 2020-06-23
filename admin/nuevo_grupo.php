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
  <body >
<?php 
    $titulo="grupos";
    echo Eventos($titulo); ?>
    <br>
    <br>
    <br>
    <br>

<!-- Variable requerida id de la jornada-->
    <?php
  $jornada=$_REQUEST['id'];
    ?>
    <div class="center-90">
      <div class="medio">
  <img class="tipo-evento default" src="../iconos/nuevo_grupo.png">
    <a class="titulo_perfil default">Nuevo grupo</a>
<form action="../php/crear_grupo.php" method="post">
      <br>

      <!-- Select para asignar grado al nuevo grupo -->
      <select name="grado" id="inputState" class="form-control" required>
      <option value="">Seleccione Grado...</option>
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

    <!-- Select para asignar jornada al nueo grupo -->
    <select name="jornada" id="inputState" class="form-control" required>
    <option value="">Seleccione Jornada...</option>
        <option  value="Manana" >Jornada Mañana</option>
        <option value="Tarde">Jornada Tarde</option>
      </select>
      <br>
      <input type="text" class="titulo_evento" name="codigo_grupo" placeholder="Código" required>
      <div class="linea_azul"></div>
</div>
</div>
 <center>
  <div class="form-check form-check-inline">
  <!-- Botón aceptar y crear -->
  <input class="btn_aceptar" type="submit" value="" name="crear">
  </div>
  </center>
</form>

</div>
</div>

</div>

  </body>
</html>
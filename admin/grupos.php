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
<!-- Muestra de las jornadas registradas -->
<?php
	$query="SELECT * FROM tbl_jornada";
	$resultado=$conexion->query($query);
	while ($row=$resultado->fetch_assoc()){
  ?>
 
 <!-- Link para ver los grupos de una jornada -->
<a class="titulo_perfil pointer" href="<?php echo $conj_grupos?>?id=<?php echo $row['id_jornada']?>">
  <div class="medio azul" >

  <!-- Icono de la Jornada de acuerdo a su descripción -->
  <?php
  if($row['id_jornada'] == "J1"){
    ?>
    <img class="tipo-evento" src="../iconos/manana3.png">
    <?php
  }elseif($row['id_jornada'] == "J2"){
    ?>
    <img class="tipo-evento" src="../iconos/tarde3.png">
    <?php
  }else{
    ?>
    <img class="cuadro_grupo">
    <?php
  }
  ?>
  
    <!-- Descripción de la Jornada -->
    <?php echo $row['descripcion_j'];
    ?>
  </div>
</a>


<?php
  }
  ?>

<!-- Link para ver la lista de docentes -->
<a class="titulo_perfil pointer" href="docentes.php">
  <div class="medio azul" >
  <img class="tipo-evento" src="../iconos/docente3.png">
    Docentes
  </div>
</a>

<!-- Link para ver la lista de estudiantes -->
<a class="titulo_perfil pointer" href="estudiantes.php">
  <div class="medio azul" >
  <img class="tipo-evento" src="../iconos/estudiante.png">
    Estudiantes
  </div>
</a>

<!-- Link para ver la lista de acudientes -->
<a class="titulo_perfil pointer" href="acudientes.php">
  <div class="medio azul" >
  <img class="tipo-evento" src="../iconos/acudiente.png">
    Acudientes
  </div>
</a>

</div>




<center>
  <div class="form-check form-check-inline">
  <input class="invisible" type="button" >
  </div>
  </center>


  </body>
</html>


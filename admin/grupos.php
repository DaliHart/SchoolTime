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
<?php
	$query="SELECT * FROM tbl_jornada";
	$resultado=$conexion->query($query);
	while ($row=$resultado->fetch_assoc()){
    
  ?>


<a class="titulo_perfil pointer" href="<?php echo $conj_grupos?>?id=<?php echo $row['id_jornada']?>">
  <div class="medio" >
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
  
    <?php echo $row['descripcion_j'];
    ?>
  </div>
</a>


<?php
  }
  ?>

<a class="titulo_perfil pointer" href="docentes.php">
  <div class="medio" >
  <img class="tipo-evento" src="../iconos/docente3.png">
    Docentes
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


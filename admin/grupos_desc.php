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

<?php
  $codigo=$_REQUEST['id'];
	$query="SELECT * FROM tbl_grupo WHERE codigo_g='$codigo'";
  $resultado=$conexion->query($query);
  $row=$resultado->fetch_assoc();
  ?>

<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <div class="row no-gutters">
  <div class="col-md-3">
  <img class="cuadro_grupo">
  <?php echo $row['grado_g']?>°<?php echo $row['grupo_g']?>
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
    <tr>
      <th scope="col">Nombres</th>
      <th>Apellidos</th>
      <th>Rol</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  
  <!-- Listar Docentes -->
  <?php
	$queryDoc="SELECT * FROM tbl_docente WHERE codigo_g='$codigo'";
	$resultadoDoc=$conexion->query($queryDoc);
	while ($rowDoc=$resultadoDoc->fetch_assoc()){
  ?>
  <tbody>
    <tr>
    <th scope="col"> <?php echo $rowDoc['nombre_doc']?> </th>
     <td> <?php echo $rowDoc['apellido_doc']?> </td>
     <th>Docente</th>
     
<!--      <td>
     <button type="button" class="btn btn-primary btn-icon-2">
      <a  href="../php/actualizar.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
      <img class="icon" src="../svg/view.png"></a></button>
     </td>
     <td>
     <button type="button" class="btn btn-primary btn-icon-2">
      <a  href="../php/actualizar.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
      <img class="icon" src="../svg/edit.svg"></a></button>
     </td> -->
    </tr>
    <?php
}
?>

<!-- Listar Estudiantes -->
<?php
	$queryE="SELECT * FROM tbl_estudiante WHERE codigo_g='$codigo'";
	$resultadoE=$conexion->query($queryE);
	while ($rowE=$resultadoE->fetch_assoc()){
  ?>
  <tbody>
    <tr>
    <th scope="col"> <?php echo $rowE['nombre_e']?> </th>
     <td> <?php echo $rowE['apellido_e']?> </td>
     <th>Estudiante</th>
     
<!--      <td>
     <button type="button" class="btn btn-primary btn-icon-2">
      <a  href="../php/actualizar.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
      <img class="icon" src="../svg/view.png"></a></button>
     </td>
     <td>
     <button type="button" class="btn btn-primary btn-icon-2">
      <a  href="../php/actualizar.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
      <img class="icon" src="../svg/edit.svg"></a></button>
     </td> -->
    </tr>
    <?php
}
?>

<!-- Listar Acudientes -->
<?php
	$queryA="SELECT * FROM tbl_acudiente WHERE codigo_g='$codigo'";
	$resultadoA=$conexion->query($queryA);
	while ($rowA=$resultadoA->fetch_assoc()){
  ?>
  <tbody>
    <tr>
    <th scope="col"> <?php echo $rowA['nombre_acu']?> </th>
     <td> <?php echo $rowA['apellido_acu']?> </td>
     <th>Acudiente</th>
     
<!--      <td>
     <button type="button" class="btn btn-primary btn-icon-2">
      <a  href="../php/actualizar.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
      <img class="icon" src="../svg/view.png"></a></button>
     </td>
     <td>
     <button type="button" class="btn btn-primary btn-icon-2">
      <a  href="../php/actualizar.php?id=<?php echo $row['codigo_g']?>" style="color: white; text-decoration: none; ">
      <img class="icon" src="../svg/edit.svg"></a></button>
     </td> -->
    </tr>
    <?php
}
?>

    
  </tbody>
</table>  
</div>

    
  </div>
</div>








</div>
  





<center>
  <div class="form-check form-check-inline">
  <input class="btn_ok" type="button" onclick="window.location.href = '<?php echo $n_grupo?>';">
  </div>
  </center>


  </body>
</html>
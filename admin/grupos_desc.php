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

<?php
/* Variable requerida cogido del grupo */
  $codigo=$_REQUEST['id'];
  /* Consulta para acceder a los datos del grupo */
	$query="SELECT * FROM tbl_grupo WHERE codigo_g='$codigo'";
  $resultado=$conexion->query($query);
  $row=$resultado->fetch_assoc();
  ?>


<div class="center-90">
<div class="titulo_perfil default">
  <div class="medio">
  <div class="row no-gutters">
  <div class="col-md-3">
  <!-- Muestra del ícono grupo y nombre del grupo  -->
  <img class="tipo-evento" src="../iconos/grupo.png">
  <?php echo $row['grado_g']?>°<?php echo $row['grupo_g']?>
  </div>
  <div class="col-md-9">
  <div class="form-group">
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
     
     <td>
     <!-- Link para actualizar datos del docente -->
      <a  href="actualizar_doc.php?id=<?php echo $rowDoc['id_docente']?>" style="color: white; text-decoration: none; ">
     <button type="button" class="btn btn-primary btn-icon-2">
      <img class="icon" src="../svg/edit.svg"></button></a>
     </td>
     <td>

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

     <td>

     <!-- Link para actualizar datos de estudiante -->
      <a  href="actualizar_est.php?id=<?php echo $rowE['id_estudiante']?>" style="color: white; text-decoration: none; ">
     <button type="button" class="btn btn-primary btn-icon-2">
      <img class="icon" src="../svg/edit.svg"></button></a>
     </td>
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
     

     <td>
     <!-- Link para actualizar los datos del acudiente --> 
      <a  href="actualizar_acu.php?id=<?php echo $rowA['id_acudiente']?>" style="color: white; text-decoration: none; ">
     <button type="button" class="btn btn-primary btn-icon-2">
      <img class="icon" src="../svg/edit.svg"></button></a>
     </td>
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
<!-- Botón con acceso a la creación de un nuevo integrante, sea Docente, Estudiante o Acudiente -->
  <div class="form-check form-check-inline">
  <input class="btn_ok  large" type="button" onclick="window.location.href = '<?php echo $n_integrante?>';" value="Nuevo Integrante">
  </div>
  </center>


  </body>
</html>
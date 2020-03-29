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
  <div class="col-md-3">
  <img class="tipo-evento" src="../iconos/docente3.png">
  Docentes
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
      <th>Grupo</th>
      <th></th>
      <th></th>
    </tr>
  </thead>
  
  <!-- Listar Docentes -->
  <?php
	$queryDoc="SELECT * FROM tbl_docente ORDER BY nombre_doc";
	$resultadoDoc=$conexion->query($queryDoc);
	while ($rowDoc=$resultadoDoc->fetch_assoc()){
  ?>
  <tbody>
    <tr>
    <th scope="col"> <?php echo $rowDoc['nombre_doc']?> </th>
     <td> <?php echo $rowDoc['apellido_doc']?> </td>
     <?php
     $codigo = $rowDoc['codigo_g'];
     $query="SELECT * FROM tbl_grupo WHERE codigo_g='$codigo'";
     $resultadoG=$conexion->query($query);
     $rowG=$resultadoG->fetch_assoc();
     ?>
     <th><?php if($rowG['grado_g']!=null){

      echo $rowG['grado_g'];?>°<?php echo $rowG['grupo_g'];
      
      }?></th>
     
     
     <td>
     <button type="button" class="btn btn-primary btn-icon-2">
      <a  href="actualizar_doc.php?id=<?php echo $rowDoc['id_docente']?>" style="color: white; text-decoration: none; ">
      <img class="icon" src="../svg/edit.svg"></a></button>
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
  





<!-- <center>
  <div class="form-check form-check-inline">
  <input class="btn_ok" type="button" onclick="window.location.href = '<?php echo $n_grupo?>';">
  </div>
  </center> -->


  </body>
</html>
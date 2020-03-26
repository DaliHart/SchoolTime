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
    


  </head>
  <body >
    
<?php

    $titulo="eventos";
    echo EventosModerador($titulo);
    
    $id_evento_actual="";
    ?>
    <br>
    <br>
    <br>
    <br>
    
  

    <div class="container">
      <div class="row">

  
  <?php
	$query="SELECT * FROM tbl_evento order by id_evento desc";
	$resultado=$conexion->query($query);
	while ($row=$resultado->fetch_assoc()){
    $id_evento_actual = $row['id_evento'];
  ?>



  <div class="col-sm">
            <div class="card evento" onclick="lig(4)">
    <div class="row no-gutters">
      <div class="col-md-4">
        <?php if($row['id_tipo']=="00B"){
          ?>
          <img class="tipo-evento" src="../svg/cambio.svg">
          <?php

        }elseif($row['id_tipo']=="00C"){
          ?>
          <img class="tipo-evento" src="../svg/reunion.svg">
          <?php

        }else{
          ?>
          <img class="tipo-evento" src="../svg/fiesta.svg">
<?php
        }?>
        
      </div>
      <!-- <div class="col-md-1">
      </div> -->
      <div class="col-md-8">
        
          <div class=" titulo_perfil large"><?php echo $row['titulo_e']?></div>
  
       
    </div>
  </div>
 <!--  <p class="titulo_perfil"><?php echo $row['titulo_e']?></p> -->
  <table class="table">
  <thead>
    <tr>
      <th  scope="col">Descripción</th>
      <td class="st_ryde"><?php echo $row['descripcion_e']?></td>
    </tr>
  </thead>
  <tbody>
    <tr>
    <th scope="col">Fecha</th>
    <?php 
    $consultaFecha="SELECT * FROM tbl_evento as evento INNER JOIN tbl_fecha_evento as fecha ON evento.id_fecha=fecha.id_fecha where evento.id_evento='$id_evento_actual'";
	$result=$conexion->query($consultaFecha);
	while ($rowF=$result->fetch_assoc()){
  ?>
     <td class="st_ryde"><?php echo $rowF['fecha_evento']?></td>
     <?php
     }
     ?>
    </tr>
    <tr>
    <th scope="col">Hora</th>
    <?php 
    $consultaFecha="SELECT * FROM tbl_evento as evento INNER JOIN tbl_hora_evento as hora ON evento.id_horas=hora.id_horas  where evento.id_evento='$id_evento_actual'";
	$result=$conexion->query($consultaFecha);
	while ($rowH=$result->fetch_assoc()){
  ?>
    <td class="st_ryde"><?php echo $rowH['hora_evento']?></td>
    <?php
  }
    ?>
</tr>
<tr>
    <th scope="col">Dirigido a</th>
    <td class="st_ryde">
    <?php
    $consultaDirigido="SELECT * FROM tbl_eventoxgrupo as exg INNER JOIN tbl_evento as evento ON exg.id_evento=evento.id_evento INNER JOIN tbl_grupo as grupo ON exg.codigo_g=grupo.codigo_g WHERE exg.id_evento='$id_evento_actual' ORDER BY grupo.grado_g";
  $resulta=$conexion->query($consultaDirigido);
  $count=1;
	while ($rowD=$resulta->fetch_assoc()){
    ?>
    <?php

    if($rowD['grado_g']!=null){
      if($count==1){
        if($rowD['estudiante'] == "1"){
          echo " Estudiantes ";
        }
        if($rowD['acudiente'] == "1"){
          echo " Acudientes ";
        }
        if($rowD['docente'] == "1"){
          echo " Docentes ";
        }
  
        echo " de ";
  
      }
      $count++;
  
      echo $rowD['grado_g']."°".$rowD['grupo_g'];

    }elseif($rowD['codigo_g']=="DOCENTES"){
      echo "Docentes sin dirección.";
    }
    


    
    ?>
     <?php
     }
     ?>
  </td>
  
</tr>
<tr>
<td >

<button type="button" class="btn btn-danger btn_icon">
    <a href="../php/eliminar.php?id_evento=<?php echo $row['id_evento']?>" style="color: white; text-decoration: none; " onclick="return confir();">
    <img class="icon" src="../svg/delete.svg"></a></button>

</td>
<td >



<button type="button" class="btn btn-primary btn_icon edit2 ">
  <a href="actualizar_evento_mod.php?id=<?php echo $row['id_evento']?>" style="color: white; text-decoration: none;">
  <img class="icon" src="../svg/edit.svg"></a></button>

  </td >
 
  

</tr>

	
  </tbody>
</table>

</div>
</div>
<?php
  }
?>

</div>
</div>


    


















    

    

    
 <center>


  <div class="form-check form-check-inline">
  <input class="btn_ok large" type="button" onclick="window.location.href = 'nuevo_evento_mod.php';" value="Nuevo Evento">
  </div>
  </center>


</div>
</div>

</div>

  </body>
</html>
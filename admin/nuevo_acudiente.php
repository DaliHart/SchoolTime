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
    echo Eventos($titulo);?>
    <br>
    <br>
    <br>
    <br>
    

    <div class="center-90">


      <div class="medio">
      <!-- Formulario con los datos necesarios para añadir un nuevo acudiente -->
 <img class="tipo-evento default" src="../iconos/nuevo.png">
    <a class="titulo_perfil default">Nuevo Acudiente</a>
    <form action="../php/crear_acudiente.php" method="post">
    <input type="text" class="titulo_evento margin-1 " name="id_acu" autocomplete="off" placeholder="Número de identificación" required>
    <div class="linea_azul"></div>
    <input type="text" class="titulo_evento margin-1 " name="nombre_acu" autocomplete="off" placeholder="Nombres" required>
    <div class="linea_azul"></div>
    <input type="text" class="titulo_evento margin-1 " name="apellido_acu" autocomplete="off" placeholder="Apellidos" required>
    <div class="linea_azul"></div>
    <input type="email" class="titulo_evento margin-1 " name="correo_acu" autocomplete="off" placeholder="Correo Electrónico" required>
    <div class="linea_azul"></div>
    <input type="password" class="titulo_evento margin-1 " name="contrasena_acu" placeholder="Contraseña" required>
    <div class="linea_azul"></div>
    <input type="password" class="titulo_evento margin-1 " name="contrasena2_acu" placeholder="Confirmar Contraseña" required>
    <div class="linea_azul"></div>
    <br>
    <!-- Lista de grupos disponibles -->
    <select name="grupo_acu" class="form-control" required>
    <option value="">Grupo sin seleccionar</option>
    <?php
	$queryG="SELECT * FROM tbl_grupo ORDER BY grado_g";
	$resultadoG=$conexion->query($queryG);
	while ($rowG=$resultadoG->fetch_assoc()){

    /* Si el codigo del grupo es diferente de 'DOCENTES' se mostrará,
    este grupo es solo válido para los docentes */
    if($rowG['codigo_g']!="DOCENTES"){
    ?>
       <option value="<?php echo $rowG['codigo_g']?>" ><?php 
       echo $rowG['grado_g']."°".$rowG['grupo_g'];?></option>
    <?php
    }
  }
    ?>   
</select>
    <br>
</div>


</div>

 <center>
  <div class="form-check form-check-inline">
  <!-- Botón para crear -->
  <input class="btn_aceptar large" type="submit" name="crear" value="Crear">
  </div>
  </center>
</form>

</div>
</div>

</div>

  </body>
</html>
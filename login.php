<?php
session_start();
$_SESSION['usuario']="";
?>


<!doctype html>
<html>
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>SchoolTime</title>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link  rel="icon" type="image/png" tallas="16x16" href="logo.png"> 
    <link rel='shortcut icon' href='iconos/ST2.ico' />
  </head>
  <body>
    <script src="js/jquery-3.3.1.slim.min.js"></script>
    <script src="js/popper.min.js"></script>
    <script src="js/bootstrap.min.js" ></script>
    <script src="https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js"></script>


<li class="nav-item">
    <input class="atras" type="button" onclick="history.back()" name="volver atrás" value="volver atrás">
  </li>

<div class="jumbotron_none">
  <div class="container">
    <h1 class="display-4">   </h1>
    <p class="lead">     </p>
<center class="mx-auto" style="width: 250px;">
<img src="svg/LOGO_blanco.svg" class="card-img-top" alt="..." style="width: 80%;">
</center>


</div>
</div>


<form action="php/ingresar.php" method="post">
<div class="center">
  <h1></h1>
  <div class="form-group">
    <input type="text" class="input" id="formGroupExampleInput" placeholder="Usuario" name="usuario" autocomplete="off" required>
  </div>
  <div class="form-group">
    <input type="password" class="input" id="exampleInputPassword1" placeholder="Contraseña" name="contrasena" required>
  </div>
  
  <button type="submit" class="btn_st_blue" value="ingresar" name="ingresar" >Iniciar Sesión</button>
</div>
</form>

<center>
  <div class="form-check form-check-inline">
  <input class="invisible" type="button" >
  </div>
  </center>

  </body>
</html>


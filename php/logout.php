<?php
/* Destruir la sesión y redirigir al login */
session_start();
session_destroy();
header ("Location: ../login.php");
?>
<?php

    
    $rol="rol";
    $eventos="eventos.php";
    $eventos_mod="eventos_mod.php";
    $n_evento="nuevo_evento.php";
    $grupos="grupos.php";
    $perfil="perfil.php";
    $perfil_mod="perfil_mod.php";
    $conj_grupos="conj_grupos.php";
    $n_grupo="nuevo_grupo.php";
    $moderadores="moderadores.php";
    $n_moderador="nuevo_moderador.php";
    $n_evento_mod="nuevo_evento_mod.php";
    $cambiar_contra="contrasena.php";
    $login="login.php";
   
    

    function Eventos($titulo){
        Global $eventos;
        Global $grupos;
        Global $perfil;


        echo "<div class='blue'>";
        echo "<ul class='nav nav-pills mb-3 justify-content-center'>";
        echo "<li class='nav-item'>";
        echo "<input class='atras' type='button' onclick='history.back()' name='volver atrás' value='volver atrás'>";
        echo "</li>";
        echo "<li class='nav-item'>";
        if($titulo=="eventos"){
            echo "<a class='nav-link active large st_ryde' href='".$eventos."'>Eventos</a>";
        }else{
            echo "<a class='nav-link large white st_ryde' href='".$eventos."'>Eventos</a>";
            
        }
        echo "</li>";
        echo "<li class='nav-item'>";

        if($titulo=="grupos"){
            echo "<a class='nav-link active large st_ryde' href='".$grupos."'>Grupos</a>";
        }else{
            echo "<a class='nav-link large white st_ryde' href='".$grupos."'>Grupos</a>";
        }
        echo " </li>";
        echo "<li class='nav-item'>";
        if($titulo=="perfil"){
            echo "<a class='nav-link active large white st_ryde' href='".$perfil."'>Perfil</a>";

        }else{
            echo "<a class='nav-link large white st_ryde' href='".$perfil."'>Perfil</a>";
        }
        
        echo "</li>";
        echo "</ul>";
        echo "</div>";

    };

    function EventosModerador($titulo){
        Global $eventos_mod;
        Global $perfil_mod;

        echo "<div class='blue'>";
        echo "<ul class='nav nav-pills mb-3 justify-content-center'>";
        echo "<li class='nav-item'>";
        echo "<input class='atras' type='button' onclick='history.back()' name='volver atrás' value='volver atrás'>";
        echo "</li>";
        echo "<li class='nav-item'>";
        if($titulo=="eventos"){
            echo "<a class='nav-link active large st_ryde' href='".$eventos_mod."'>Eventos</a>";
        }else{
            echo "<a class='nav-link large white st_ryde' href='".$eventos_mod."'>Eventos</a>";
            
        }
        echo "</li>";
        
        echo "<li class='nav-item'>";
        if($titulo=="perfil"){
            echo "<a class='nav-link active large white st_ryde' href='".$perfil_mod."'>Perfil</a>";

        }else{
            echo "<a class='nav-link large white st_ryde' href='".$perfil_mod."'>Perfil</a>";
        }
        
        echo "</li>";
        echo "</ul>";
        echo "</div>";

    };

    function Links($title){
        echo "<meta charset='utf-8'>";
        echo "<meta name='viewport' content='width=device-width, initial-scale=1, shrink-to-fit=no'>";
        echo "<title>".$title."</title>";
        
        echo "<link rel='shortcut icon' href='../iconos/ST2.ico' />";
        echo "<link rel='stylesheet' href='../css/bootstrap.min.css'>";
        echo "<link rel='stylesheet' type='text/css' href='../css/style.css'>";
        echo "<link  rel='icon' type='image/png' tallas='16x16' href='logo.png'>";
        echo "<script src='../js/jquery-3.3.1.slim.min.js'></script>";
        echo "<script src='../js/popper.min.js'></script>";
        echo "<script src='../js/bootstrap.min.js' ></script>";
        echo "<script src='https://unpkg.com/ionicons@4.5.10-0/dist/ionicons.js'></script>";
        echo "<link rel='stylesheet' href='../sweetalert/docs/assets/css/app.css'>";
        echo "<script src='../sweetalert/docs/assets/sweetalert/sweetalert.min.js'></script>";
        echo "<script src='../js/confir.js'></script>";

        

    }


    
    
    

    
    
    
    



?>
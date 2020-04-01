B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=9.801
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: true
	#IncludeTitle: false
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim est As Int = 0
	Dim hecho As Timer
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private ScrollView1 As ScrollView
	Private retroceder As Label
	Private txtnombreEstudiante As EditText
	Private txtidentificacion As EditText
	Private txtmatricula As EditText
	Private txtcodigogrupo As EditText
	Private txtcontrasenaEstudiante As EditText
	Private txtconfirmaEstudiante As EditText
	Private btnregistroEstudiante As Button
	Private Panel2 As Panel
	Private fondo As Panel
	Private cerrarCodigo As Label
	Private opcioncodigo As Label
	Private txtapellidoEstudiante As EditText
	Private txtcorreoEstudiante As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("registroEstudiante")
	ScrollView1.Panel.LoadLayout("contenidoEstudiante")
	ScrollView1.Panel.Height = 80%y
	Panel2.Visible = False
	fondo.Visible= False
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub opcioninicioEstudiante_Click
	StartActivity(inicioEstudiante)
	Activity.Finish
End Sub

Sub retroceder_Click
	StartActivity(inicioEstudiante)
	Activity.Finish
End Sub

Sub txtnombreEstudiante_TextChanged (Old As String, New As String)
	If New.Length >= 40 Then
		MsgboxAsync("El nombre no puede sobrepasar los 40 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtidentificacion_TextChanged (Old As String, New As String)
	If New.Length >= 10 Then
		MsgboxAsync("La identificación no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtmatricula_TextChanged (Old As String, New As String)
	If New.Length >= 10 Then
		MsgboxAsync("La matrícula no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcodigogrupo_TextChanged (Old As String, New As String)
	If New.Length >= 10 Then
		MsgboxAsync("El código del grupo no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcontrasenaEstudiante_TextChanged (Old As String, New As String)
	If New.Length >= 10 Then
		MsgboxAsync("La contraseña no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtconfirmaEstudiante_TextChanged (Old As String, New As String)
	If New.Length >= 10 Then
		MsgboxAsync("La confirmación de la contraseña no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtapellidoEstudiante_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("El apellido no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcorreoEstudiante_TextChanged (Old As String, New As String)
	If New.Length >= 50 Then
		MsgboxAsync("El correo no puede sobrepasar los 50 caracteres","ATENCIÓN")
	End If
End Sub

Sub btnregistroEstudiante_Click
	If txtnombreEstudiante.Text<>"" And txtidentificacion.Text<>"" And txtmatricula.Text<>"" And txtcodigogrupo.Text<>"" And txtcontrasenaEstudiante.Text<>"" And txtconfirmaEstudiante.Text<>"" And txtcorreoEstudiante.Text<>"" And txtapellidoEstudiante.Text<>"" Then
		If txtcontrasenaEstudiante.Text = txtconfirmaEstudiante.Text Then
			If txtcorreoEstudiante.Text.Contains("@") Then
				If txtcorreoEstudiante.Text.Contains(".") Then
					If txtcorreoEstudiante.Text.Contains(" ")Then
						ToastMessageShow("El correo no debe contener espacios", False)
						txtcorreoEstudiante.Text=""
					Else
						Dim ApiAddress As String = "http://192.168.1.5/schooltime1.php"
						Dim job As HttpJob
						job.Initialize("", Me)
						job.PostString(ApiAddress,"INSERT INTO tbl_estudiante(id_estudiante,nombre_e,apellido_e,matricula_e,correo_e, contrasena_e,codigo_g) VALUES ('"&txtidentificacion.Text&"','"&txtnombreEstudiante.Text&"','"&txtapellidoEstudiante.Text&"','"&txtmatricula.Text&"','"&txtcorreoEstudiante.Text&"','"&txtcontrasenaEstudiante.Text&"','"&txtcodigogrupo.Text&"')")
					End If
				Else
					ToastMessageShow("Correo inválido: @", False)
					txtcorreoEstudiante.Text=""
				End If
			Else
				ToastMessageShow("Correo inválido: @", False)
				txtcorreoEstudiante.Text=""
			End If
		Else 
			MsgboxAsync("Las contraseñas no coinciden","ERROR DE CONFIRMACIÓN")
		End If
	Else
		MsgboxAsync("Todos los campos son requeridos para el registro","ATENCIÓN")
	End If
End Sub

Sub JobDone(Job As HttpJob)
	If Job.Success Then
		Log("OK, operacion con éxito")
		MsgboxAsync("Su registro ha sido exitoso","AVISO")
		hecho.Initialize("hecho", 2000)
		hecho.Enabled= True
	Else
		Log(Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub

Sub hecho_Tick
	StartActivity(ingresoEstudiante)
	Activity.Finish
	hecho.Enabled= False
End Sub

Sub opcioncodigo_Click
	If est = 0 Then
		Panel2.Visible= True
		fondo.Visible=True
		btnregistroEstudiante.Visible= False
		est = 1
	End If
End Sub

Sub cerrarCodigo_Click
	If est = 1 Then
		Panel2.Visible= False
		fondo.Visible= False
		btnregistroEstudiante.Visible= True
		est = 0
	End If
End Sub
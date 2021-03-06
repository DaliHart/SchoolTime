﻿B4A=true
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
	Dim doc As Int = 0
	Dim hecho As Timer
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private ScrollView1 As ScrollView
	Private retroceder As Label
	Private btnregistroAcudiente As Button
	Private txtnombreAcudiente As EditText
	Private txtcedulaAcudiente As EditText
	Private txtcorreoAcudiente As EditText
	Private txtcodigoAcuente As EditText
	Private txtcontrasenaAcudiente As EditText
	Private txtconfirmaAcudiente As EditText
	Private opcioncodigo As Label
	Private cerrarCodigo As Label
	Private txtapellidoAcudiente As EditText
	Private fondo As Panel
	Private Panel2 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("registroAcudiente")
	ScrollView1.Panel.LoadLayout("contenidoacudiente")
	ScrollView1.Panel.Height = 80%y
	Panel2.Visible = False
	fondo.Visible= False
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub opcioninicioAcudiente_Click
	StartActivity(inicioAcudiente)
	Activity.Finish
End Sub

Sub retroceder_Click
	StartActivity(inicioAcudiente)
	Activity.Finish
End Sub

Sub txtnombreAcudiente_TextChanged (Old As String, New As String)
	If New.Length >= 40 Then
		MsgboxAsync("El nombre no puede sobrepasar los 40 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcedulaAcudiente_TextChanged (Old As String, New As String)
	If New.Length >= 10 Then
		MsgboxAsync("La cédula no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcorreoAcudiente_TextChanged (Old As String, New As String)
	If New.Length >= 50 Then
		MsgboxAsync("El correo no puede sobrepasar los 50 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcodigoAcuente_TextChanged (Old As String, New As String)
	If New.Length >= 10 Then
		MsgboxAsync("El código de grupo no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcontrasenaAcudiente_TextChanged (Old As String, New As String)
	If New.Length >= 10 Then
		MsgboxAsync("La contraseña no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtconfirmaAcudiente_TextChanged (Old As String, New As String)
	If New.Length >= 10 Then
		MsgboxAsync("La confirmación de la contraseña no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtapellidoAcudiente_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("El apellido no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub btnregistroAcudiente_Click
	If txtnombreAcudiente.Text<>"" And txtcedulaAcudiente.Text<>"" And txtcodigoAcuente.Text<>"" And txtcorreoAcudiente.Text<>"" And txtcontrasenaAcudiente.Text<>"" And txtconfirmaAcudiente.Text<>"" Then
		If txtcontrasenaAcudiente.Text = txtconfirmaAcudiente.Text Then
			If txtcorreoAcudiente.Text.Contains("@") Then
				If txtcorreoAcudiente.Text.Contains(".") Then
					If txtcorreoAcudiente.Text.Contains(" ") Then
						ToastMessageShow("El correo no debe contener espacios", False)
						txtcorreoAcudiente.Text=""
					Else
						Dim ApiAddress As String = "http://192.168.1.5/schooltime1.php"
						Dim job As HttpJob
						job.Initialize("", Me)
						job.PostString(ApiAddress,"INSERT INTO tbl_acudiente(id_acudiente,nombre_acu,apellido_acu,correo_acu,contrasena_acu,codigo_g) VALUES ('"&txtcedulaAcudiente.Text&"','"&txtnombreAcudiente.Text&"','"&txtapellidoAcudiente.Text&"','"&txtcorreoAcudiente.Text&"','"&txtcontrasenaAcudiente.Text&"','"&txtcodigoAcuente.Text&"')")
					End If
				Else
					ToastMessageShow("Correo inválido: .", False)
					txtcorreoAcudiente.Text=""
				End If
			Else
				ToastMessageShow("Correo inválido: @", False)
				txtcorreoAcudiente.Text=""
			End If
		Else
			MsgboxAsync("Las contraseñas deben coincidir","ATENCIÓN")
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
	StartActivity(ingreso)
	Activity.Finish
	hecho.Enabled= False
End Sub

Sub opcioncodigo_Click
	If doc = 0 Then
		Panel2.Visible= True
		fondo.Visible=True
		btnregistroAcudiente.Visible= False
		doc = 1
	End If
End Sub

Sub cerrarCodigo_Click
	If doc = 1 Then
		Panel2.Visible= False
		fondo.Visible=False
		btnregistroAcudiente.Visible= True
		doc = 0
	End If
End Sub
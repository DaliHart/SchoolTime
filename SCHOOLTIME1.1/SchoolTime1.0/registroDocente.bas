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
	Dim hecho As Timer
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private ScrollView1 As ScrollView
	Dim Label1 As Label
	Private retroceder As Label
	Private btnregistrardocente As Button
	Private txtnombredocente As EditText
	Private txtceduladocente As EditText
	Private txtcorreodocente As EditText
	Private txtcondocente As EditText
	Private txtconfirmaciondocente As EditText
	Private txtapellidodocente As EditText
	Private txtcodigodocente As EditText
	Private opcioncodigo As Label
	Private fondo As Panel
	Private Panel2 As Panel
	Private cerrarCodigo As Label
	Dim doc As Int = 0
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("registroDocente")
	ScrollView1.Panel.LoadLayout("contenidoDocente")
	ScrollView1.Panel.Height = 80%y
	Panel2.Visible = False
	fondo.Visible= False
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub opcioninicioDocente_Click
	StartActivity(inicioDocente)
	Activity.Finish
End Sub

Sub retroceder_Click
	StartActivity(inicioDocente)
	Activity.Finish
End Sub

Sub txtnombredocente_TextChanged (Old As String, New As String)
	If New.Length >= 40 Then
		MsgboxAsync("El nombre no puede sobrepasar los 40 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtceduladocente_TextChanged (Old As String, New As String)
	If New.Length > 10 Then
		MsgboxAsync("La cédula no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcorreodocente_TextChanged (Old As String, New As String)
	If New.Length >= 50 Then
		MsgboxAsync("El correo no puede sobrepasar los 50 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcondocente_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("La contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtconfirmaciondocente_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("La confirmación de la contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtcodigodocente_TextChanged (Old As String, New As String)
	If New.Length > 10 Then
		MsgboxAsync("El código no puede sobrepasar los 10 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtapellidodocente_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("El apellido no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub
Sub btnregistrardocente_Click
	If txtnombredocente.Text<>"" And txtceduladocente.Text<>"" And txtcorreodocente.Text<>"" And txtcondocente.Text<>"" And txtconfirmaciondocente.Text<>"" And txtapellidodocente.Text<>"" Then
		If txtcondocente.Text = txtconfirmaciondocente.Text Then
			If txtcorreodocente.Text.Contains("@") Then
				If txtcorreodocente.Text.Contains(".") Then
					If txtcorreodocente.Text.Contains(" ") Then
						ToastMessageShow("El correo no debe contener espacios", False)
						txtcorreodocente.Text=""
					Else
						Dim ApiAddress As String = "http://192.168.1.5/schooltime1.php"
						Dim job As HttpJob
						job.Initialize("", Me)
						job.PostString(ApiAddress,"INSERT INTO tbl_docente(id_docente,nombre_doc,apellido_doc,correo_doc,contrasena_doc,codigo_g ) VALUES ('"&txtceduladocente.Text&"','"&txtnombredocente.Text&"','"&txtapellidodocente.Text&"','"&txtcorreodocente.Text&"','"&txtcondocente.Text&"','"&txtcodigodocente.Text&"')")
					End If
				Else
					ToastMessageShow("Correo inválido: .", False)
					txtcorreodocente.Text=""
				End If
			Else
				ToastMessageShow("Correo inválido: @", False)
				txtcorreodocente.Text=""
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
	StartActivity(ingresoDocente)
	Activity.Finish
	hecho.Enabled= False
End Sub

Sub opcioncodigo_Click
	If doc = 0 Then
		Panel2.Visible= True
		fondo.Visible=True
		btnregistrardocente.Visible= False
		doc = 1
	End If
End Sub

Sub cerrarCodigo_Click
	If doc = 1 Then
		Panel2.Visible= False
		fondo.Visible= False
		btnregistrardocente.Visible= True
		doc = 0
	End If
End Sub
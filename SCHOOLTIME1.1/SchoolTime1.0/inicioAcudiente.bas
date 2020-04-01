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

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private btniniciaracudinte As Button
	Private opcionregistro As Label
	Private retroceder As Label
	Private txtContrasenaacudiente As EditText
	Private txtcorreoacudiente As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("iniciarr")
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub txtcorreoacudiente_TextChanged (Old As String, New As String)
	If New.Length >= 49 Then
		MsgboxAsync("El correo no puede sobrepasar los 40 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtContrasenaacudiente_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("La contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub retroceder_Click
	StartActivity(perfiles)
	Activity.Finish
End Sub

Sub opcionregistro_Click
	StartActivity(registroAcudiente)
	Activity.Finish
End Sub

Sub btniniciaracudinte_Click
	If txtcorreoacudiente.Text <> "" And txtContrasenaacudiente.Text <> "" Then
		Dim ApiAddress As String = "http://192.168.1.5/schooltime1.php"
		Dim job As HttpJob
		job.Initialize("usuario_existe", Me)
		job.PostString(ApiAddress,"SELECT * FROM tbl_acudiente where correo_acu= '" & txtcorreoacudiente.Text & "'and contrasena_acu='"&txtContrasenaacudiente.Text&"'")
	Else
		MsgboxAsync("Todos los campos son necesarios para el ingreso", "ATENCIÓN")
	End If
End Sub

Sub JobDone(Job As HttpJob)
	If Job.Success Then
		Dim res As String
		res = Job.GetString
		Dim parser As JSONParser
		parser.Initialize(res)
		If Job.JobName= "usuario_existe" Then
			Dim usuarios As List
			usuarios = parser.NextArray
			If usuarios.Size > 0 Then
				StartActivity(ingreso)
				Activity.Finish
			Else
				MsgboxAsync("El usuario no se encuentra registrado, por favor intentelo de nuevo","ATENCIÓN")
				txtcorreoacudiente.Text= ""
				txtContrasenaacudiente.Text= ""
			End If
		End If
	Else
		Log(Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub
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

	Private opcionregistro As Label
	Private retroceder As Label
	Private txtcorreoEstudiante As EditText
	Private btninicioEstudiante As Button
	Private txtcontrasenaEstudiante As EditText
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("inicioEstudiante")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub opcionregistro_Click
	StartActivity(registroEstudiante)
	Activity.Finish
End Sub

Sub retroceder_Click
	StartActivity(perfiles)
	Activity.Finish
End Sub

Sub txtcorreoEstudiante_TextChanged (Old As String, New As String)
	If New.Length >= 50 Then
		MsgboxAsync("El correo no puede sobrepasar los 10 caracteres", "ATENCIÓN")
		End If
End Sub

Sub txtcontrasenaEstudiante_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("La contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub btninicioEstudiante_Click
	If txtcorreoEstudiante.Text<>"" And txtcontrasenaEstudiante.Text<>"" Then
		Dim ApiAddress As String = "http://192.168.1.3/schooltime1.php"
		Dim job As HttpJob
		job.Initialize("usuario_existe", Me)
		job.PostString(ApiAddress,"SELECT * FROM tblregistroestudiante where correoEstudiante= '" & txtcorreoEstudiante.Text & "'and contrasenaEstudiante='"&txtcontrasenaEstudiante.Text&"'")
	Else
		MsgboxAsync("Todos los campos son requertidos para el ingreso","ATENCIÓN")
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
				StartActivity(ingresoEstudiante)
				Activity.Finish
			Else
				MsgboxAsync("El usuario no se encuentra registrado, por favor intentelo de nuevo","ATENCIÓN")
				txtcorreoEstudiante.Text = ""
				txtcontrasenaEstudiante.Text = ""
			End If
		End If
	Else
		Log(Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub
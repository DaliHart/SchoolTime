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
	Private txtcorreodococente As EditText
	Private txtContrasenadocente As EditText
	Private btniniciardococente As Button
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("inicioDocente")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub opcionregistro_Click
	StartActivity(registroDocente)
	Activity.Finish
End Sub

Sub retroceder_Click
	StartActivity(perfiles)
	Activity.Finish
End Sub

Sub txtcorreodococente_TextChanged (Old As String, New As String)
	If New.Length >= 49 Then
		MsgboxAsync("El correo no puede sobrepasar los 40 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtContrasenadocente_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("La contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub btniniciardococente_Click
	If txtcorreodococente.Text <> "" And txtContrasenadocente.Text <> "" Then
<<<<<<< HEAD:SCHOOLTIME1.1/SchoolTime1.0/inicioDocente.bas
		Dim ApiAddress As String = "http://192.168.1.5/schooltime1.php"
=======
		Dim ApiAddress As String = "http://192.168.1.2/schooltime1.php"
>>>>>>> 472d7e1bb737852601b93ef0dfa36302ce8af10a:SCHOOLTIME1.0/SchoolTime1.0/inicioDocente.bas
		Dim job As HttpJob
		job.Initialize("usuario_existe", Me)
		job.PostString(ApiAddress,"SELECT * FROM tbl_docente where correo_doc= '" & txtcorreodococente.Text & "'and contrasena_doc='"&txtContrasenadocente.Text&"'")
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
				StartActivity(ingresoDocente)
				Activity.Finish
			Else
				MsgboxAsync("El usuario no se encuentra registrado, por favor intentelo de nuevo","ATENCIÓN")
				txtcorreodococente.Text= ""
				txtContrasenadocente.Text= ""
			End If
		End If
	Else
		Log(Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub

'	Dim Job As HttpJob
'	Job.Initialize("",Me)
'	Job.Download("http://192.168.1.5/schooltime.php?act=evento")
'	Wait For JobDone (Job As HttpJob)
'	If Job.Success Then
'		Dim titu,tipo,dec As String
'		Dim parser As JSONParser
'		parser.Initialize(Job.GetString)
'		Dim root As List
'		root = parser.NextArray
'		For i= 0 To root.Size -1
'			Dim user As Map
'			user = root.Get(i)
'			titu = user.Get("titulo")
'			tipo = user.Get("tipo")
'			dec = user.Get("descripcion")
'			Log("Titulo evento: "&titu&", tipo de evento: "&tipo&", descripcion"&dec)
'		Next
'	Else
'		Log("Error: "&Job.ErrorMessage)
'	End If
B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Activity
Version=9.801
@EndOfDesignText@
#Region  Activity Attributes 
	#FullScreen: True
	#IncludeTitle: False
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim estado As Int=0
	Dim titulo,descripcion,fecha,hora,tipo,tipo1,tipo2,codigoE,desc1,desc2 As String
	Dim eventos As Int = 0
	Dim event As Int = 0
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private TabHost1 As TabHost
	Private inicio As Panel
	Private Panel1 As Panel
	Private btncambioE As Button
	Private retroceder As Label
	Private txtconactE As EditText
	Private txtconfconE As EditText
	Private txtconnuvE As EditText
	Private btncambiarestudiante As Button
	Private btncerrarestudiante As Button
	Private Anuncio As Label
	Private cambio1E As ImageView
	Private cambio2E As ImageView
	Private celebracion1E As ImageView
	Private celebracion2E As ImageView
	Private evento1E As Panel
	Private evento2E As Panel
	Private fecha1E As Label
	Private fecha2E As Label
	Private hora1E As Label
	Private hora2E As Label
	Private reunion1E As ImageView
	Private reunion2E As ImageView
	Private titulo1E As Label
	Private titulo2E As Label
	Private cambio11E As ImageView
	Private cambio22E As ImageView
	Private celebracion11E As ImageView
	Private celebracion22E As ImageView
	Private contraseñaE As EditText
	Private Datos As Panel
	Private desc11E As Label
	Private descripcion22E As Label
	Private EnviarE As Button
	Private evento11E As Panel
	Private evento22E As Panel
	Private fecha11E As Label
	Private fecha22E As Label
	Private hora11E As Label
	Private hora22E As Label
	Private reunion11E As ImageView
	Private reunion22E As ImageView
	Private titulo11E As Label
	Private titulo22E As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ingresoEstudiante")
	TabHost1.AddTab("EVENTOS","eventoE")
	TabHost1.AddTab("PERFIL","perfilE")
	Panel1.Visible=False
	inicio.Visible=True
	evento1E.Visible=False
	evento2E.Visible=False
	evento11E.Visible=False
	evento22E.Visible=False
	Anuncio.Visible=False
	eventos = 0
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub txtconnuvE_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("La nueva contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtconfconE_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("La confirmación de la contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub btncambioE_Click
	If txtconactE.Text<>"" And txtconnuvE.Text<>"" And txtconfconE.Text<>"" Then
		If txtconnuvE.Text = txtconfconE.Text Then
			Dim ApiAddress As String = "http://192.168.1.3/schooltime1.php"
			Dim job As HttpJob
			job.Initialize("", Me)
			job.PostString(ApiAddress,"UPDATE tblregistroestudiante SET contrasenaEstudiante='"&txtconnuvE.Text&"' WHERE contrasenaEstudiante='"&txtconactE.Text&"'")
		Else
			MsgboxAsync("Las contraseñas deben coincidir","ATENCIÓN")
		End If
	Else
		MsgboxAsync("Todos los campos son requeridos para el cambio","ATENCIÓN")
	End If
End Sub

Sub JobDone(Job As HttpJob)
	If Job.Success Then
		Log("OK, se actualizó correctamente")
		MsgboxAsync("Su contraseña se actualizó con éxito","AVISO")
		txtconactE.Text=""
		txtconnuvE.Text=""
		txtconfconE.Text=""
		Panel1.Visible=False
		inicio.Visible=False
		estado=0
	Else
		Log(Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub

Sub retroceder_Click
	If estado = 1 Then
		Panel1.Visible = False
		inicio.Visible = False
		estado = 0
	End If
End Sub

Sub btncerrarestudiante_Click
	StartActivity(perfiles)
	Activity.Finish
End Sub

Sub btncambiarestudiante_Click
	If estado = 0 Then
		Panel1.Visible = True
		inicio.Visible = True
		estado = 1
	End If
End Sub

Sub inicio_Click
	If event = 1 Then
		inicio.Visible = False
		evento22E.Visible = False
		evento11E.Visible = False
		event = 0
	End If
End Sub

Sub evento1E_Click
	If event = 0 Then
		inicio.Visible = True
		evento11E.Visible = True
		titulo11E.Text = titulo1E.Text
		fecha11E.Text = fecha1E.Text
		hora11E.Text = hora1E.Text
		desc11E.Text = desc1
		If tipo1 = "Celebracion" Then
			celebracion11E.Visible = True
			cambio11E.Visible = False
			reunion11E.Visible = False
		Else
			If tipo1 = "Reunion" Then
				celebracion11E.Visible = False
				cambio11E.Visible = False
				reunion11E.Visible = True
			Else
				If tipo1 = "Cambio" Then
					celebracion11E.Visible = False
					cambio11E.Visible = True
					reunion11E.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub evento2E_Click
	If event = 0 Then
		inicio.Visible = True
		evento22E.Visible = True
		titulo22E.Text = titulo2E.Text
		fecha22E.Text = fecha2E.Text
		hora22E.Text = hora2E.Text
		descripcion22E.Text = desc2
		If tipo2 = "Celebracion" Then
			celebracion22E.Visible = True
			cambio22E.Visible = False
			reunion22E.Visible = False
		Else
			If tipo2 = "Reunion" Then
				celebracion22E.Visible = False
				cambio22E.Visible = False
				reunion22E.Visible = True
			Else
				If tipo2 = "Cambio" Then
					celebracion22E.Visible = False
					cambio22E.Visible = True
					reunion22E.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub EnviarE_Click
	If contraseñaE.Text <> "" Then
		Try
			Dim ApiAddress As String = "http://192.168.1.3/schooltime.php"
			Dim js As HttpJob
			js.Initialize("",Me)
			js.Download2(ApiAddress,Array As String ("act","cedula","pin",contraseñaE.Text,"tabla","tblregistroestudiante","codigo","codigoGrupo","cedula","identificacionEstudiante"))
			Wait For(js) JobDone(js As HttpJob)
			If js.Success Then
				Dim res As String
				res = js.GetString' Esto no se debe hacer, tu serber no esta enviando los datos limpios
				res = res.Replace("null","")
				Dim parser As JSONParser
				parser.Initialize(res)
				If (res.Length >0) Then
					Dim tabla As List
					tabla = parser.NextArray
					Log(tabla)
					Dim fila As Map
					For i=0 To tabla.Size-1
						fila= tabla.Get(i)
						codigoE = fila.Get("codigoGrupo")
					Next
				End If
			Else
				Log(js.ErrorMessage)
			End If
		Catch
			Log(LastException)
		End Try
		inicio.Visible =False
		Datos.Visible = False
	Else
		MsgboxAsync("Necesitas este campo para el ingreso","AVISO")
	End If
	remoreE
End Sub

Sub remoreE
	If eventos = 0 Then
		Anuncio.Visible = True
	Else
		Anuncio.Visible = False
	End If
	Try
		Dim ApiAddress As String = "http://192.168.1.3/schooltime.php"
		Dim js As HttpJob
		js.Initialize("",Me)
		js.Download2(ApiAddress,Array As String ("act","evento","codigo",codigoE))
		Wait For(js) JobDone(js As HttpJob)
		If js.Success Then
			Dim res As String
			res = js.GetString' Esto no se debe hacer, tu serber no esta enviando los datos limpios
			res = res.Replace("null","")
			Dim parser As JSONParser
			parser.Initialize(res)
			If (res.Length >0) Then
				eventos = 1
				If eventos = 1 Then
					evento1E.Visible = True
				End If
				Dim tabla As List
				tabla = parser.NextArray
				Log(tabla)
				Dim fila As Map
				For i=0 To tabla.Size-1
					fila= tabla.Get(i)
					titulo = fila.Get("titulo")
					tipo = fila.Get("tipo")
					fecha = fila.Get("fecha")
					hora = fila.Get("hora")
					descripcion = fila.Get("descripcion")
					If eventos =1 Then
						Anuncio.Visible = False
						evento2E.Visible = False
						titulo1E.Text = titulo
						fecha1E.Text = fecha
						tipo1 = tipo
						hora1E.Text = hora
						desc1 = descripcion
						If tipo1 = "Celebracion" Then
							celebracion1E.Visible = True
							cambio1E.Visible = False
							reunion1E.Visible = False
						Else
							If tipo1 = "Cambio" Then
								celebracion1E.Visible = False
								cambio1E.Visible = True
								reunion1E.Visible = False
							Else
								If tipo1 = "Reunion" Then
									celebracion1E.Visible = False
									cambio1E.Visible = False
									reunion1E.Visible = True
								End If
							End If
						End If
					Else
						If eventos =2 Then
							Anuncio.Visible = False
							evento2E.Visible = True
							titulo2E.Text = titulo
							fecha2E.Text = fecha
							tipo2 = tipo
							hora2E.Text = hora
							desc2 = descripcion
							If tipo2 = "Celebracion" Then
								celebracion2E.Visible = True
								cambio2E.Visible = False
								reunion2E.Visible = False
							Else
								If tipo2 = "Cambio" Then
									celebracion2E.Visible = False
									cambio2E.Visible = True
									reunion2E.Visible = False
								Else
									If tipo2 = "Reunion" Then
										celebracion2E.Visible = False
										cambio2E.Visible = False
										reunion2E.Visible = True
									End If
								End If
							End If
						End If
					End If
					eventos = eventos  + 1
				Next
			End If
		Else
			Log(js.ErrorMessage)
		End If
	Catch
		Log(LastException)
	End Try
End Sub

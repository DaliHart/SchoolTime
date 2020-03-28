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
	Dim estado As Int=0
	Dim titulo,descripcion,fecha,hora,tipo,tipo1,tipo2,codigo,desc1,desc2 As String
	Dim eventos As Int = 0
	Dim event As Int = 0
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private TabHost1 As TabHost
	Private btncambiaracudiente As Button
	Private btncerraracudiente As Button
	Private inicio As Panel
	Private cerrar As Label
	Private txtconact As EditText
	Private txtconnuv As EditText
	Private txtconfcon As EditText
	Private Panel1 As Panel
	Private btncambio As Button
	Private Anuncio As Label
	Private cambio1A As ImageView
	Private cambio2A As ImageView
	Private celebracion1A As ImageView
	Private celebracion2A As ImageView
	Private evento1A As Panel
	Private evento2A As Panel
	Private fecha1A As Label
	Private fecha2A As Label
	Private hora1A As Label
	Private hora2A As Label
	Private reunion1A As ImageView
	Private reunion2A As ImageView
	Private titulo1A As Label
	Private titulo2A As Label
	Private cambio11A As ImageView
	Private cambio22A As ImageView
	Private celebracion11A As ImageView
	Private celebracion22A As ImageView
	Private contraseñaA As EditText
	Private Datos As Panel
	Private desc11A As Label
	Private desc22A As Label
	Private EnviarA As Button
	Private evento11A As Panel
	Private fecha11A As Label
	Private fecha22A As Label
	Private hora11A As Label
	Private hora22A As Label
	Private reunion11A As ImageView
	Private reunion22A As ImageView
	Private titulo11A As Label
	Private titulo22A As Label
	Private evento22A As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ingreso")
	TabHost1.AddTab("EVENTOS","evento")
	TabHost1.AddTab("PERFIL","perfil")
	Panel1.Visible = False
	inicio.Visible = True
	evento1A.Visible=False
	evento2A.Visible=False
	evento11A.Visible=False
	evento22A.Visible=False
	Anuncio.Visible=False
	eventos = 0
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub btncambiaracudiente_Click
	If estado = 0 Then
		Panel1.Visible = True
		inicio.Visible = True
		estado = 1
	End If
End Sub

Sub btncerraracudiente_Click
	StartActivity(perfiles)
	Activity.Finish
End Sub

Sub cerrar_Click
	If estado = 1 Then
		Panel1.Visible = False
		inicio.Visible = False
		estado = 0
	End If
End Sub

Sub inicio_Click
	If event = 1 Then
		inicio.Visible = False
		evento22A.Visible = False
		evento11A.Visible = False
		event = 0
	End If
End Sub

Sub txtconnuv_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("La nueva contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtconfcon_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub btncambio_Click
	If txtconact.Text<>"" And txtconnuv.Text<>"" And txtconfcon.Text<>"" Then
		If txtconnuv.Text = txtconfcon.Text Then
			Dim ApiAddress As String = "http://192.168.1.3/schooltime1.php"
			Dim job As HttpJob
			job.Initialize("", Me)
			job.PostString(ApiAddress,"UPDATE tblregistroacudiente SET contrasenaAcudiente='"&txtconnuv.Text&"' WHERE contrasenaAcudiente='"&txtconact.Text&"'")
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
		txtconact.Text=""
		txtconnuv.Text=""
		txtconfcon.Text=""
		Panel1.Visible=False
		inicio.Visible=False
		estado=0
	Else
		Log(Job.ErrorMessage)
		ToastMessageShow("Error: " & Job.ErrorMessage, True)
	End If
	Job.Release
End Sub


Sub evento2A_Click
	If event = 0 Then
		inicio.Visible = True
		evento22A.Visible = True
		titulo22A.Text = titulo2A.Text
		fecha22A.Text = fecha2A.Text
		hora22A.Text = hora2A.Text
		desc22A.Text = desc2
		If tipo2 = "Celebracion" Then
			celebracion22A.Visible = True
			cambio22A.Visible = False
			reunion22A.Visible = False
		Else
			If tipo2 = "Reunion" Then
				celebracion22A.Visible = False
				cambio22A.Visible = False
				reunion22A.Visible = True
			Else
				If tipo2 = "Cambio" Then
					celebracion22A.Visible = False
					cambio22A.Visible = True
					reunion22A.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub evento1A_Click
	If event = 0 Then
		inicio.Visible = True
		evento11A.Visible = True
		titulo11A.Text = titulo1A.Text
		fecha11A.Text = fecha1A.Text
		hora11A.Text = hora1A.Text
		desc11A.Text = desc1
		If tipo1 = "Celebracion" Then
			celebracion11A.Visible = True
			cambio11A.Visible = False
			reunion11A.Visible = False
		Else
			If tipo1 = "Reunion" Then
				celebracion11A.Visible = False
				cambio11A.Visible = False
				reunion11A.Visible = True
			Else
				If tipo1 = "Cambio" Then
					celebracion11A.Visible = False
					cambio11A.Visible = True
					reunion11A.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub EnviarA_Click
	If contraseñaA.Text <> "" Then
		Try
			Dim ApiAddress As String = "http://192.168.1.3/schooltime.php"
			Dim js As HttpJob
			js.Initialize("",Me)
			js.Download2(ApiAddress,Array As String ("act","cedula","pin",contraseñaA.Text,"tabla","tblregistroacudiente","codigo","codigoAcudiente","cedula","cedulaAcudiente"))
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
						codigo = fila.Get("codigoAcudiente")
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
	remoreA
End Sub

Sub remoreA
	If eventos = 0 Then
		Anuncio.Visible = True
	Else
		Anuncio.Visible = False
	End If
	Try
		Dim ApiAddress As String = "http://192.168.1.3/schooltime.php"
		Dim js As HttpJob
		js.Initialize("",Me)
		js.Download2(ApiAddress,Array As String ("act","evento","codigo",codigo))
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
					evento1A.Visible = True
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
						evento2A.Visible = False
						titulo1A.Text = titulo
						fecha1A.Text = fecha
						tipo1 = tipo
						hora1A.Text = hora
						desc1 = descripcion
						If tipo1 = "Celebracion" Then
							celebracion1A.Visible = True
							cambio1A.Visible = False
							reunion1A.Visible = False
						Else
							If tipo1 = "Cambio" Then
								celebracion1A.Visible = False
								cambio1A.Visible = True
								reunion1A.Visible = False
							Else
								If tipo1 = "Reunion" Then
									celebracion1A.Visible = False
									cambio1A.Visible = False
									reunion1A.Visible = True
								End If
							End If
						End If
					Else
						If eventos =2 Then
							Anuncio.Visible = False
							evento2A.Visible = True
							titulo2A.Text = titulo
							fecha2A.Text = fecha
							tipo2 = tipo
							hora2A.Text = hora
							desc2 = descripcion
							If tipo2 = "Celebracion" Then
								celebracion2A.Visible = True
								cambio2A.Visible = False
								reunion2A.Visible = False
							Else
								If tipo2 = "Cambio" Then
									celebracion2A.Visible = False
									cambio2A.Visible = True
									reunion2A.Visible = False
								Else
									If tipo2 = "Reunion" Then
										celebracion2A.Visible = False
										cambio2A.Visible = False
										reunion2A.Visible = True
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
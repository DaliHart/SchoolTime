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
	Dim titulo,descripcion,fecha,hora,tipo,tipo1,tipo2,tipo3,tipo4,codigoE,desc1,desc2,desc3,desc4,c As String
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
	Private cambio3E As ImageView
	Private celebracion3E As ImageView
	Private evento3E As Panel
	Private fecha3E As Label
	Private hora3E As Label
	Private reunion3E As ImageView
	Private titulo3E As Label
	Private cambio33E As ImageView
	Private celebracion33E As ImageView
	Private descripcion33E As Label
	Private evento33E As Panel
	Private fecha33E As Label
	Private hora33E As Label
	Private reunion33E As ImageView
	Private titulo33E As Label
	Private cambio4E As ImageView
	Private celebracion4E As ImageView
	Private evento4E As Panel
	Private fecha4E As Label
	Private hora4E As Label
	Private reunion4E As ImageView
	Private titulo4E As Label
	Private cambio44E As ImageView
	Private celebracion44E As ImageView
	Private descripcion44E As Label
	Private evento44E As Panel
	Private fecha44E As Label
	Private hora44E As Label
	Private reunion44E As ImageView
	Private titulo44E As Label
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
	evento3E.Visible=False
	evento4E.Visible=False
	evento11E.Visible=False
	evento22E.Visible=False
	evento33E.Visible=False
	evento44E.Visible=False
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
			Dim ApiAddress As String = "http://192.168.1.5/schooltime1.php"
			Dim job As HttpJob
			job.Initialize("", Me)
			job.PostString(ApiAddress,"UPDATE tbl_estudiante SET contrasena_e='"&txtconnuvE.Text&"' WHERE contrasena_e='"&txtconactE.Text&"'")
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
		evento44E.Visible= False
		evento33E.Visible= False
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
		If tipo1 = "Celebración" Then
			celebracion11E.Visible = True
			cambio11E.Visible = False
			reunion11E.Visible = False
		Else
			If tipo1 = "Reunión" Then
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
		If tipo2 = "Celebración" Then
			celebracion22E.Visible = True
			cambio22E.Visible = False
			reunion22E.Visible = False
		Else
			If tipo2 = "Reunión" Then
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

Sub evento3E_Click
	If event = 0 Then
		inicio.Visible = True
		evento33E.Visible = True
		titulo33E.Text = titulo3E.Text
		fecha33E.Text = fecha3E.Text
		hora33E.Text = hora3E.Text
		descripcion33E.Text = desc3
		If tipo3 = "Celebración" Then
			celebracion33E.Visible = True
			cambio33E.Visible = False
			reunion33E.Visible = False
		Else
			If tipo3 = "Reunión" Then
				celebracion33E.Visible = False
				cambio33E.Visible = False
				reunion33E.Visible = True
			Else
				If tipo3 = "Cambio" Then
					celebracion33E.Visible = False
					cambio33E.Visible = True
					reunion33E.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub evento4E_Click
	If event = 0 Then
		inicio.Visible = True
		evento44E.Visible = True
		titulo44E.Text = titulo4E.Text
		fecha44E.Text = fecha4E.Text
		hora44E.Text = hora4E.Text
		descripcion44E.Text = desc4
		If tipo4 = "Celebración" Then
			celebracion44E.Visible = True
			cambio44E.Visible = False
			reunion44E.Visible = False
		Else
			If tipo4 = "Reunión" Then
				celebracion44E.Visible = False
				cambio44E.Visible = False
				reunion44E.Visible = True
			Else
				If tipo4 = "Cambio" Then
					celebracion44E.Visible = False
					cambio44E.Visible = True
					reunion44E.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub EnviarE_Click
	If contraseñaE.Text <> "" Then
		Try
			Dim ApiAddress As String = "http://192.168.1.5/schooltime.php"
			Dim js As HttpJob
			js.Initialize("",Me)
			js.Download2(ApiAddress,Array As String ("act","cedula","pin",contraseñaE.Text,"tabla","tbl_estudiante","codigo","codigo_g","cedula","id_estudiante"))
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
						codigoE = fila.Get("codigo_g")
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

Sub CreateNotificationChannel(ImportanceLevel As Int)
	Dim p As Phone
	If p.SdkVersion >= 26 Then
		Dim ctxt As JavaObject
		ctxt.InitializeContext
		Dim channelId As String = "channel_"& ImportanceLevel
		Dim channel As JavaObject
		channel.InitializeNewInstance("android.app.NotificationChannel",Array(channelId, Application.LabelName, ImportanceLevel))
		channel.RunMethod("setShowBadge",Array(False))
		
		Dim manager As JavaObject = ctxt.RunMethod("getSystemService", Array("notification"))
		manager.RunMethod("createNotificationChannel",Array(channel))
		
	End If
End Sub

Sub remoreE
	If eventos = 0 Then
		Anuncio.Visible = True
	Else
		Anuncio.Visible = False
	End If
	Try
		Dim ApiAddress As String = "http://192.168.1.5/schooltime.php"
		Dim js As HttpJob
		js.Initialize("",Me)
		js.Download2(ApiAddress,Array As String ("act","evento","codigo",codigoE,"quien","estudiante"))
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
					titulo = fila.Get("titulo_e")
					descripcion = fila.Get("descripcion_e")
					c = fila.Get("codigo_g")
					fecha = fila.Get("fecha_evento")
					hora = fila.Get("hora_evento")
					tipo = fila.Get("id_tipo")
					If eventos =1 Then
						tipo1 = tipo
						If tipo1 = "00A" Then
							tipo1 = "Celebración"
						Else
							If tipo1 = "00B" Then
								tipo1 = "Cambio"
							Else
								If tipo1 = "00C" Then
									tipo1 = "Reunión"
								End If
							End If
						End If
						Dim n As Notification
						CreateNotificationChannel(n.IMPORTANCE_HIGH)
						n.Initialize2(n.IMPORTANCE_HIGH)
						n.Icon ="icon"
						n.SetInfo(tipo1,"Se llevará acabo el "&fecha,Main)
						n.Notify(1)
						Anuncio.Visible = False
						evento2E.Visible = False
						titulo1E.Text = titulo
						fecha1E.Text = fecha
						hora1E.Text = hora
						desc1 = descripcion
						If tipo1 = "Celebración" Then
							celebracion1E.Visible = True
							cambio1E.Visible = False
							reunion1E.Visible = False
						Else
							If tipo1 = "Cambio" Then
								celebracion1E.Visible = False
								cambio1E.Visible = True
								reunion1E.Visible = False
							Else
								If tipo1 = "Reunión" Then
									celebracion1E.Visible = False
									cambio1E.Visible = False
									reunion1E.Visible = True
								End If
							End If
						End If
					Else
						If eventos =2 Then
							tipo2 = tipo
							If tipo2 = "00A" Then
								tipo2 = "Celebración"
							Else
								If tipo2 = "00B" Then
									tipo2 = "Cambio"
								Else
									If tipo2 = "00C" Then
										tipo2 = "Reunión"
									End If
								End If
							End If
							Dim n2 As Notification
							CreateNotificationChannel(n.IMPORTANCE_HIGH)
							n2.Initialize2(n.IMPORTANCE_HIGH)
							n2.Icon ="icon"
							n2.SetInfo(tipo2,"Se llevará acabo el "&fecha,Main)
							n2.Notify(2)
							Anuncio.Visible = False
							evento2E.Visible = True
							titulo2E.Text = titulo
							fecha2E.Text = fecha
							hora2E.Text = hora
							desc2 = descripcion
							If tipo2 = "Celebración" Then
								celebracion2E.Visible = True
								cambio2E.Visible = False
								reunion2E.Visible = False
							Else
								If tipo2 = "Cambio" Then
									celebracion2E.Visible = False
									cambio2E.Visible = True
									reunion2E.Visible = False
								Else
									If tipo2 = "Reunión" Then
										celebracion2E.Visible = False
										cambio2E.Visible = False
										reunion2E.Visible = True
									End If
								End If
							End If
						End If
						If eventos =3 Then
							tipo3 = tipo
							If tipo3 = "00A" Then
								tipo3 = "Celebración"
							Else
								If tipo3 = "00B" Then
									tipo3 = "Cambio"
								Else
									If tipo3 = "00C" Then
										tipo3 = "Reunión"
									End If
								End If
							End If
							Dim n3 As Notification
							CreateNotificationChannel(n.IMPORTANCE_HIGH)
							n3.Initialize2(n.IMPORTANCE_HIGH)
							n3.Icon ="icon"
							n3.SetInfo(tipo3,"Se llevará acabo el "&fecha,Main)
							n3.Notify(3)
							Anuncio.Visible = False
							evento3E.Visible = True
							titulo3E.Text = titulo
							fecha3E.Text = fecha
							hora3E.Text = hora
							desc3 = descripcion
							If tipo3 = "Celebración" Then
								celebracion3E.Visible = True
								cambio3E.Visible = False
								reunion3E.Visible = False
							Else
								If tipo3 = "Cambio" Then
									celebracion3E.Visible = False
									cambio3E.Visible = True
									reunion3E.Visible = False
								Else
									If tipo3 = "Reunión" Then
										celebracion3E.Visible = False
										cambio3E.Visible = False
										reunion3E.Visible = True
									End If
								End If
							End If
						End If
						If eventos = 4 Then
							tipo4 = tipo
							If tipo4 = "00A" Then
								tipo4 = "Celebración"
							Else
								If tipo4 = "00B" Then
									tipo4 = "Cambio"
								Else
									If tipo4 = "00C" Then
										tipo4 = "Reunión"
									End If
								End If
							End If
							Dim n4 As Notification
							CreateNotificationChannel(n.IMPORTANCE_HIGH)
							n4.Initialize2(n.IMPORTANCE_HIGH)
							n4.Icon ="icon"
							n4.SetInfo(tipo4,"Se llevará acabo el "&fecha,Main)
							n4.Notify(4)
							Anuncio.Visible = False
							evento4E.Visible = True
							titulo4E.Text = titulo
							fecha4E.Text = fecha
							hora4E.Text = hora
							desc4 = descripcion
							If tipo4 = "Celebración" Then
								celebracion4E.Visible = True
								cambio4E.Visible = False
								reunion4E.Visible = False
							Else
								If tipo4 = "Cambio" Then
									celebracion4E.Visible = False
									cambio4E.Visible = True
									reunion4E.Visible = False
								Else
									If tipo4 = "Reunión" Then
										celebracion4E.Visible = False
										cambio4E.Visible = False
										reunion4E.Visible = True
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
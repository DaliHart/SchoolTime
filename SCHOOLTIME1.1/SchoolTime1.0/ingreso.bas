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
	Dim titulo,descripcion,fecha,hora,tipo,tipo1,tipo2,tipo3,tipo4,c,codigo,desc1,desc2,desc3,desc4 As String
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
	Private cambio3A As ImageView
	Private cambio4A As ImageView
	Private celebracion3A As ImageView
	Private celebracion4A As ImageView
	Private evento3A As Panel
	Private evento4A As Panel
	Private fecha3A As Label
	Private fecha4A As Label
	Private hora3A As Label
	Private hora4A As Label
	Private reunion3A As ImageView
	Private reunion4A As ImageView
	Private titulo3A As Label
	Private titulo4A As Label
	Private cambio33A As ImageView
	Private cambio44A As ImageView
	Private celebracion33A As ImageView
	Private celebracion44A As ImageView
	Private descripcion33A As Label
	Private descripcion44A As Label
	Private evento33A As Panel
	Private evento44A As Panel
	Private fecha33A As Label
	Private fecha44A As Label
	Private hora33A As Label
	Private hora44A As Label
	Private reunion33A As ImageView
	Private reunion44A As ImageView
	Private titulo33A As Label
	Private titulo44A As Label
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
	evento3A.Visible=False
	evento4A.Visible=False
	evento11A.Visible=False
	evento22A.Visible=False
	evento33A.Visible= False
	evento44A.Visible= False
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
		evento44A.Visible=False
		evento33A.Visible=False
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
			Dim ApiAddress As String = "http://192.168.1.5/schooltime1.php"
			Dim job As HttpJob
			job.Initialize("", Me)
			job.PostString(ApiAddress,"UPDATE tbl_acudiente SET contrasena_acu='"&txtconnuv.Text&"' WHERE contrasena_acu='"&txtconact.Text&"'")
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
		If tipo2 = "Celebración" Then
			celebracion22A.Visible = True
			cambio22A.Visible = False
			reunion22A.Visible = False
		Else
			If tipo2 = "Reunión" Then
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
		If tipo1 = "Celebración" Then
			celebracion11A.Visible = True
			cambio11A.Visible = False
			reunion11A.Visible = False
		Else
			If tipo1 = "Reunión" Then
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

Sub evento3A_Click
	If event = 0 Then
		inicio.Visible = True
		evento33A.Visible = True
		titulo33A.Text = titulo3A.Text
		fecha33A.Text = fecha3A.Text
		hora33A.Text = hora3A.Text
		descripcion33A.Text = desc3
		If tipo3 = "Celebración" Then
			celebracion33A.Visible = True
			cambio33A.Visible = False
			reunion33A.Visible = False
		Else
			If tipo3 = "Reunión" Then
				celebracion33A.Visible = False
				cambio33A.Visible = False
				reunion33A.Visible = True
			Else
				If tipo3 = "Cambio" Then
					celebracion33A.Visible = False
					cambio33A.Visible = True
					reunion33A.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub evento4E_Click
	If event = 0 Then
		inicio.Visible = True
		evento44A.Visible = True
		titulo44A.Text = titulo4A.Text
		fecha44A.Text = fecha4A.Text
		hora44A.Text = hora4A.Text
		descripcion44A.Text = desc4
		If tipo4 = "Celebración" Then
			celebracion44A.Visible = True
			cambio44A.Visible = False
			reunion44A.Visible = False
		Else
			If tipo4 = "Reunión" Then
				celebracion44A.Visible = False
				cambio44A.Visible = False
				reunion44A.Visible = True
			Else
				If tipo4 = "Cambio" Then
					celebracion44A.Visible = False
					cambio44A.Visible = True
					reunion44A.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub EnviarA_Click
	If contraseñaA.Text <> "" Then
		Try
			Dim ApiAddress As String = "http://192.168.1.5/schooltime.php"
			Dim js As HttpJob
			js.Initialize("",Me)
			js.Download2(ApiAddress,Array As String ("act","cedula","pin",contraseñaA.Text,"tabla","tbl_acudiente","codigo","codigo_g","cedula","id_acudiente"))
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
						codigo = fila.Get("codigo_g")
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

Sub remoreA
	If eventos = 0 Then
		Anuncio.Visible = True
	Else
		Anuncio.Visible = False
	End If
	Try
		Dim ApiAddress As String = "http://192.168.1.5/schooltime.php"
		Dim js As HttpJob
		js.Initialize("",Me)
		js.Download2(ApiAddress,Array As String ("act","evento","codigo",codigo,"quien","acudiente"))
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
					titulo = fila.Get("titulo_e")
					descripcion = fila.Get("descripcion_e")
					c= fila.Get("codigo_g")
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
						evento1A.Visible = true
						titulo1A.Text = titulo
						fecha1A.Text = fecha
						hora1A.Text = hora
						desc1 = descripcion
						If tipo1 = "Celebración" Then
							celebracion1A.Visible = True
							cambio1A.Visible = False
							reunion1A.Visible = False
						Else
							If tipo1 = "Cambio" Then
								celebracion1A.Visible = False
								cambio1A.Visible = True
								reunion1A.Visible = False
							Else
								If tipo1 = "Reunión" Then
									celebracion1A.Visible = False
									cambio1A.Visible = False
									reunion1A.Visible = True
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
							evento2A.Visible = True
							titulo2A.Text = titulo
							fecha2A.Text = fecha
							hora2A.Text = hora
							desc2 = descripcion
							If tipo2 = "Celebración" Then
								celebracion2A.Visible = True
								cambio2A.Visible = False
								reunion2A.Visible = False
							Else
								If tipo2 = "Cambio" Then
									celebracion2A.Visible = False
									cambio2A.Visible = True
									reunion2A.Visible = False
								Else
									If tipo2 = "Reunión" Then
										celebracion2A.Visible = False
										cambio2A.Visible = False
										reunion2A.Visible = True
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
							evento3A.Visible = True
							titulo3A.Text = titulo
							fecha3A.Text = fecha
							hora3A.Text = hora
							desc3 = descripcion
							If tipo3 = "Celebración" Then
								celebracion3A.Visible = True
								cambio3A.Visible = False
								reunion3A.Visible = False
							Else
								If tipo3 = "Cambio" Then
									celebracion3A.Visible = False
									cambio3A.Visible = True
									reunion3A.Visible = False
								Else
									If tipo3 = "Reunión" Then
										celebracion3A.Visible = False
										cambio3A.Visible = False
										reunion3A.Visible = True
									End If
								End If
							End If
						End If
						If eventos =4 Then
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
							evento4A.Visible = True
							titulo4A.Text = titulo
							fecha4A.Text = fecha
							hora4A.Text = hora
							desc4 = descripcion
							If tipo4 = "Celebración" Then
								celebracion4A.Visible = True
								cambio4A.Visible = False
								reunion4A.Visible = False
							Else
								If tipo4 = "Cambio" Then
									celebracion4A.Visible = False
									cambio4A.Visible = True
									reunion4A.Visible = False
								Else
									If tipo4 = "Reunión" Then
										celebracion4A.Visible = False
										cambio4A.Visible = False
										reunion4A.Visible = True
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
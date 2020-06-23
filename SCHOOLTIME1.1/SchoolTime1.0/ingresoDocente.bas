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
	Dim event As Int = 0
	Dim tit,fec,tip,hor,des,desc11,desc2,tipo3,tipo4,codigo,c As String
	Dim tipo2 As String
	Dim eventos As Int = 0
	Dim estado As Int = 0
	Dim desc3,desc4 As String
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private TabHost1 As TabHost
	Private btncambiardocente As Button
	Private btncerrardocente As Button
	Private Panel1 As Panel
	Private inicio As Panel
	Private retroceder As Label
	Private txtconnuv As EditText
	Private btncambio As Button
	Private txtconact As EditText
	Private txtconfcon As EditText
	Private evento1 As Panel
	Private fecha As Label
	Private titulo As Label
	Private cambio As ImageView
	Private celebracion As ImageView
	Private reunion As ImageView
	Dim tipo As String
	Private hora As Label
	Private icono1 As ImageView
	Private titulo1 As Label
	Private fecha1 As Label
	Private desc1 As Label
	Private hora1 As Label
	Private icono1R As ImageView
	Private icono1C As ImageView
	Private evento11 As Panel
	Private Anuncio As Label
	Private evento2 As Panel
	Private cambio2 As ImageView
	Private celebracion2 As ImageView
	Private reunion2 As ImageView
	Private titulo2 As Label
	Private fecha2 As Label
	Private hora2 As Label
	Private cambio22 As ImageView
	Private celebracion22 As ImageView
	Private descripcion22 As Label
	Private evento22 As Panel
	Private fecha22 As Label
	Private hora22 As Label
	Private reunion22 As ImageView
	Private titulo22 As Label
	Private Datos As Panel
	Private contraseñaD As EditText
	Private Enviar As Button
	Private cambio3 As ImageView
	Private celebracion3 As ImageView
	Private evento3 As Panel
	Private fecha3 As Label
	Private hora3 As Label
	Private reunion3 As ImageView
	Private titulo3 As Label
	Private cambio33 As ImageView
	Private celebracion33 As ImageView
	Private descripcion33 As Label
	Private evento33 As Panel
	Private fecha33 As Label
	Private hora33 As Label
	Private reunion33 As ImageView
	Private titulo33 As Label
	Private cambio4 As ImageView
	Private celebracion4 As ImageView
	Private evento4 As Panel
	Private fecha4 As Label
	Private hora4 As Label
	Private reunion4 As ImageView
	Private titulo4 As Label
	Private reunion44 As ImageView
	Private cambio44 As ImageView
	Private celebracion44 As ImageView
	Private descripcion44 As Label
	Private fecha44 As Label
	Private hora44 As Label
	Private titulo44 As Label
	Private evento44 As Panel
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ingresoDocente")
	TabHost1.AddTab("EVENTOS","eventoDocente")
	TabHost1.AddTab("PERFIL","perfilDocente")
	inicio.Visible = True
	Panel1.Visible =False
	evento11.Visible = False
	evento22.Visible= False
	evento33.Visible=False
	evento3.Visible=False
	evento2.Visible= False
	evento1.Visible=False
	evento4.Visible=False
	evento44.Visible=False
	Anuncio.Visible= True
	eventos = 0
End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub btncambiardocente_Click
	If estado = 0 Then
		Panel1.Visible = True
		inicio.Visible = True
		estado = 1
	End If
End Sub

Sub btncerrardocente_Click
	StartActivity(perfiles)
	Activity.Finish
End Sub

Sub retroceder_Click
	If estado = 1 Then
		Panel1.Visible = False
		inicio.Visible = False
		estado = 0
	End If
End Sub

Sub txtconfcon_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("La nueva contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub txtconact_TextChanged (Old As String, New As String)
	If New.Length >= 20 Then
		MsgboxAsync("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres","ATENCIÓN")
	End If
End Sub

Sub btncambio_Click
	If txtconact.Text<>"" And txtconnuv.Text<>"" And txtconfcon.Text<>"" Then
		If txtconnuv.Text = txtconfcon.Text Then
			Dim ApiAddress As String = "http://192.168.1.1/schooltime1.php"
			Dim job As HttpJob
			job.Initialize("", Me)
			job.PostString(ApiAddress,"UPDATE tbl_docente SET contrasena_doc='"&txtconnuv.Text&"' WHERE contrasena_doc='"&txtconact.Text&"'")
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

Sub evento1_Click
	If event = 0 Then
		inicio.Visible = True
		evento11.Visible = True
		titulo1.Text = titulo.Text
		fecha1.Text = fecha.Text
		hora1.Text = hora.Text
		desc1.Text = desc11
		If tipo = "Celebración" Then
			icono1.Visible = True
			icono1C.Visible = False
			icono1R.Visible = False
		Else
			If tipo = "Reunión" Then
				icono1.Visible = False
				icono1C.Visible = False
				icono1R.Visible = True
			Else
				If tipo = "Cambio" Then
					icono1.Visible = False
					icono1C.Visible = True
					icono1R.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub inicio_Click
	If event = 1 Then
		inicio.Visible = False
		evento11.Visible = False
		evento22.Visible = False
		evento33.Visible = False
		evento44.Visible = False
		event = 0
	End If
End Sub

Sub evento2_Click
	If event = 0 Then
		inicio.Visible = True
		evento22.Visible = True
		titulo22.Text = titulo2.Text
		fecha22.Text = fecha2.Text
		hora22.Text = hora2.Text
		descripcion22.Text = desc2
		If tipo2 = "Celebración" Then
			celebracion22.Visible = True
			cambio22.Visible = False
			reunion22.Visible = False
		Else
			If tipo2 = "Reunión" Then
				celebracion22.Visible = False
				cambio22.Visible = False
				reunion22.Visible = True
			Else
				If tipo2 = "Cambio" Then
					celebracion22.Visible = False
					cambio22.Visible = True
					reunion22.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub evento3_Click
	If event = 0 Then
		inicio.Visible = True
		evento33.Visible = True
		titulo33.Text = titulo3.Text
		fecha33.Text = fecha3.Text
		hora33.Text = hora3.Text
		descripcion33.Text = desc3
		If tipo3 = "Celebración" Then
			celebracion33.Visible = True
			cambio33.Visible = False
			reunion33.Visible = False
		Else
			If tipo3 = "Reunión" Then
				celebracion33.Visible = False
				cambio33.Visible = False
				reunion33.Visible = True
			Else
				If tipo3 = "Cambio" Then
					celebracion33.Visible = False
					cambio33.Visible = True
					reunion33.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub evento4_Click
	If event = 0 Then
		inicio.Visible = True
		evento44.Visible = True
		titulo44.Text = titulo4.Text
		fecha44.Text = fecha4.Text
		hora44.Text = hora4.Text
		descripcion44.Text = desc4
		If tipo4 = "Celebración" Then
			celebracion44.Visible = True
			cambio44.Visible = False
			reunion44.Visible = False
		Else
			If tipo4 = "Reunión" Then
				celebracion44.Visible = False
				cambio44.Visible = False
				reunion44.Visible = True
			Else
				If tipo4 = "Cambio" Then
					celebracion44.Visible = False
					cambio44.Visible = True
					reunion44.Visible = False
				End If
			End If
		End If
		event = 1
	End If
End Sub

Sub Enviar_Click
	If contraseñaD.Text <> "" Then
		Try
			Dim ApiAddress As String = "http://192.168.1.1/schooltime.php"
			Dim js As HttpJob
			js.Initialize("",Me)
			js.Download2(ApiAddress,Array As String ("act","cedula","pin",contraseñaD.Text,"tabla","tbl_docente","codigo","codigo_g","cedula","id_docente"))
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
	remore
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

Sub remore
	If eventos = 0 Then
		Anuncio.Visible = True
	Else
		Anuncio.Visible = False
	End If
	Try
		Dim ApiAddress As String = "http://192.168.1.1/schooltime.php"
		Dim js As HttpJob
		js.Initialize("",Me)
		js.Download2(ApiAddress,Array As String ("act","evento","codigo",codigo,"quien","docente"))
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
					evento1.Visible = True
				End If
				Dim tabla As List
				tabla = parser.NextArray
				Log(tabla)
				Dim fila As Map
				For i=0 To tabla.Size-1
					fila= tabla.Get(i)
					tit = fila.Get("titulo_e")
					des = fila.Get("descripcion_e")
					c = fila.Get("codigo_g")
					fec = fila.Get("fecha_evento")
					hor = fila.Get("hora_evento")
					tip = fila.Get("id_tipo")
					If eventos =1 Then
						tipo = tip
						If tipo = "00A" Then
							tipo = "Celebración"
						Else
							If tipo = "00B" Then
								tipo = "Cambio"
							Else
								If tipo = "00C" Then
									tipo = "Reunión"
								End If
							End If
						End If
						Dim n As Notification
						CreateNotificationChannel(n.IMPORTANCE_HIGH)
						n.Initialize2(n.IMPORTANCE_HIGH)
						n.Icon ="icon"
						n.SetInfo(tipo,"Se llevará acabo el "&fec,Main)
						n.Notify(1)
						Anuncio.Visible = False
						evento2.Visible = False
						titulo.Text = tit
						fecha.Text = fec
						hora.Text = hor
						desc11 = des
						If tipo = "Celebración" Then
							celebracion.Visible = True
							cambio.Visible = False
							reunion.Visible = False
						Else
							If tipo = "Cambio" Then
								celebracion.Visible = False
								cambio.Visible = True
								reunion.Visible = False
							Else
								If tipo = "Reunión" Then
									celebracion.Visible = False
									cambio.Visible = False
									reunion.Visible = True
								End If
							End If
						End If
					Else
						If eventos =2 Then
							tipo2 = tip
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
							Dim n1 As Notification
							CreateNotificationChannel(n.IMPORTANCE_HIGH)
							n1.Initialize2(n.IMPORTANCE_HIGH)
							n1.Icon ="icon"
							n1.SetInfo(tipo2,"Se llevará acabo el "&fec,Main)
							n1.Notify(2)
							Anuncio.Visible = False
							evento2.Visible = True
							titulo2.Text = tit
							fecha2.Text = fec
							hora2.Text = hor
							desc2 = des
							If tipo2 = "Celebración" Then
								celebracion2.Visible = True
								cambio2.Visible = False
								reunion2.Visible = False
							Else
								If tipo2 = "Cambio" Then
									celebracion2.Visible = False
									cambio2.Visible = True
									reunion2.Visible = False
								Else
									If tipo2 = "Reunión" Then
										celebracion2.Visible = False
										cambio2.Visible = False
										reunion2.Visible = True
									End If
								End If
							End If
						End If
						If eventos =3 Then
							tipo3 = tip
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
							n3.SetInfo(tipo3,"Se llevará acabo el "&fec,Main)
							n3.Notify(3)
							Anuncio.Visible = False
							evento3.Visible = True
							titulo3.Text = tit
							fecha3.Text = fec
							hora3.Text = hor
							desc3 = des
							If tipo3 = "Celebración" Then
								celebracion3.Visible = True
								cambio3.Visible = False
								reunion3.Visible = False
							Else
								If tipo3 = "Cambio" Then
									celebracion3.Visible = False
									cambio3.Visible = True
									reunion3.Visible = False
								Else
									If tipo3 = "Reunión" Then
										celebracion3.Visible = False
										cambio3.Visible = False
										reunion3.Visible = True
									End If
								End If
							End If
						End If
						If eventos =4 Then
							tipo4 = tip
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
							n4.SetInfo(tipo4,"Se llevará acabo el "&fec,Main)
							n4.Notify(4)
							Anuncio.Visible = False
							evento4.Visible = True
							titulo4.Text = tit
							fecha4.Text = fec
							hora4.Text = hor
							desc4 = des
							If tipo4 = "Celebración" Then
								celebracion4.Visible = True
								cambio4.Visible = False
								reunion4.Visible = False
							Else
								If tipo4 = "Cambio" Then
									celebracion4.Visible = False
									cambio4.Visible = True
									reunion4.Visible = False
								Else
									If tipo4 = "Reunión" Then
										celebracion4.Visible = False
										cambio4.Visible = False
										reunion4.Visible = True
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
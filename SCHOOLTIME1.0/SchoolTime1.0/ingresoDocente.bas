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
	Dim tit,fec,tip,hor,des,desc11,desc2,codigo As String
	Dim tipo2 As String
	Dim eventos As Int = 0
End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.
	Private TabHost1 As TabHost
	Private btncambiardocente As Button
	Private btncerrardocente As Button
	Private Panel1 As Panel
	Dim estado As Int = 0
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
	Dim notifica As Notification
	Dim fechaComplet As String
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("ingresoDocente")
	TabHost1.AddTab("EVENTOS","eventoDocente")
	TabHost1.AddTab("PERFIL","perfilDocente")
	Panel1.Visible = False
	inicio.Visible = True
	evento11.Visible = False
	evento22.Visible= False
	evento2.Visible= False
	evento1.Visible=False
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
			Dim ApiAddress As String = "http://192.168.1.3/schooltime1.php"
			Dim job As HttpJob
			job.Initialize("", Me)
			job.PostString(ApiAddress,"UPDATE tblregistrodocente SET contrasenaDocente='"&txtconnuv.Text&"' WHERE contrasenaDocente='"&txtconact.Text&"'")
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
		If tipo = "Celebracion" Then
			icono1.Visible = True
			icono1C.Visible = False
			icono1R.Visible = False
		Else
			If tipo = "Reunion" Then
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
		If tipo2 = "Celebracion" Then
			celebracion22.Visible = True
			cambio22.Visible = False
			reunion22.Visible = False
		Else
			If tipo2 = "Reunion" Then
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

Sub Enviar_Click
	If contraseñaD.Text <> "" Then
		Try
			Dim ApiAddress As String = "http://192.168.1.3/schooltime.php"
			Dim js As HttpJob
			js.Initialize("",Me)
			js.Download2(ApiAddress,Array As String ("act","cedula","pin",contraseñaD.Text,"tabla","tblregistrodocente","codigo","codigoDocente","cedula","cedulaDocente"))
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
						codigo = fila.Get("codigoDocente")
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
					evento1.Visible = True
				End If
				Dim tabla As List
				tabla = parser.NextArray
				Log(tabla)
				Dim fila As Map
				For i=0 To tabla.Size-1
					fila= tabla.Get(i)
					tit = fila.Get("titulo")
					tip = fila.Get("tipo")
					fec = fila.Get("fecha")
					hor = fila.Get("hora")
					des = fila.Get("descripcion")
					If eventos =1 Then
						Dim n As Notification
						CreateNotificationChannel(n.IMPORTANCE_HIGH)
						n.Initialize2(n.IMPORTANCE_HIGH)
						n.Icon ="icon"
						n.SetInfo(tip,"Se llevará acabo el "&fec,Main)
						n.Notify(1)
						Anuncio.Visible = False
						evento2.Visible = False
						titulo.Text = tit
						fecha.Text = fec
						tipo = tip
						hora.Text = hor
						desc11 = des
						If tipo = "Celebracion" Then
							celebracion.Visible = True
							cambio.Visible = False
							reunion.Visible = False
						Else
							If tipo = "Cambio" Then
								celebracion.Visible = False
								cambio.Visible = True
								reunion.Visible = False
							Else
								If tipo = "Reunion" Then
									celebracion.Visible = False
									cambio.Visible = False
									reunion.Visible = True
								End If
							End If
						End If
					Else
						If eventos =2 Then
							Dim n1 As Notification
							CreateNotificationChannel(n.IMPORTANCE_HIGH)
							n1.Initialize2(n.IMPORTANCE_HIGH)
							n1.Icon ="icon"
							n1.SetInfo(tip,"Se llevará acabo el "&fec,Main)
							n1.Notify(2)
							Anuncio.Visible = False
							evento2.Visible = True
							titulo2.Text = tit
							fecha2.Text = fec
							tipo2 = tip
							hora2.Text = hor
							desc2 = des
							If tipo2 = "Celebracion" Then
								celebracion2.Visible = True
								cambio2.Visible = False
								reunion2.Visible = False
							Else
								If tipo2 = "Cambio" Then
									celebracion2.Visible = False
									cambio2.Visible = True
									reunion2.Visible = False
								Else
									If tipo2 = "Reunion" Then
										celebracion2.Visible = False
										cambio2.Visible = False
										reunion2.Visible = True
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
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

End Sub

Sub Globals
	'These global variables will be redeclared each time the activity is created.
	'These variables can only be accessed from this module.

	Private btnregresarestudiante As Button
	Private opcionregistro As Label
	Private retroceder As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("obtenerCodigo")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub btnregresarestudiante_Click
	StartActivity(inicioEstudiante)
	Activity.Finish
End Sub

Sub opcionregistro_Click
	StartActivity(registroEstudiante)
	Activity.Finish
End Sub

Sub retroceder_Click
	StartActivity(inicioEstudiante)
	Activity.Finish
End Sub
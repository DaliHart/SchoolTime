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

	Private btndocente As Button
	Private btnestudiante As Button
	Private btnacudiente As Button
	Private Label2 As Label
	Private Label1 As Label
	Private Label3 As Label
	Private retroceder As Label
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("perfiles")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub


Sub btndocente_Click
	StartActivity(inicioDocente)
	Activity.Finish
End Sub

Sub btnestudiante_Click
	StartActivity(inicioEstudiante)
	Activity.Finish
End Sub

Sub btnacudiente_Click
	StartActivity(inicioAcudiente)
	Activity.Finish
End Sub

Sub retroceder_Click
	StartActivity(Main)
	Activity.Finish
End Sub
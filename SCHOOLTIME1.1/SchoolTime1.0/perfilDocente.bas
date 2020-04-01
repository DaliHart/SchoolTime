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

	Private btncambiardocente As Button
	Private btncerrardocente As Button
	Dim timer As Timer
End Sub

Sub Activity_Create(FirstTime As Boolean)
	'Do not forget to load the layout file created with the visual designer. For example:
	Activity.LoadLayout("perfilDocente")

End Sub

Sub Activity_Resume

End Sub

Sub Activity_Pause (UserClosed As Boolean)

End Sub

Sub btncerrardocente_Click
	timer.Initialize("timer", 1000)
	timer.Enabled= True
	StartActivity(perfiles)
	Activity.Finish
	timer.Enabled= False
End Sub

Sub btncambiardocente_Click
	
End Sub
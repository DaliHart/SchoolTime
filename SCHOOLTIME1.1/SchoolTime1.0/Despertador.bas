B4A=true
Group=Default Group
ModulesStructureVersion=1
Type=Service
Version=9.801
@EndOfDesignText@
#Region  Service Attributes 
	#StartAtBoot: False
	
#End Region

Sub Process_Globals
	'These global variables will be declared once when the application starts.
	'These variables can be accessed from all modules.
	Dim mp As MediaPlayer
End Sub

Sub Service_Create

End Sub

Sub Service_Start (StartingIntent As Intent)
	mp.Initialize()  'Initialize Mediaplayer
	Service_Destroy

End Sub

Sub Service_Destroy
	StopService("")     'Stop this service
	CancelScheduledService("")   'Cancel this service
End Sub

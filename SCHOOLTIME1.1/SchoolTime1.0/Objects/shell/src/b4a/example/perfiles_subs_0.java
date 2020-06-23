package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class perfiles_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (perfiles) ","perfiles",7,perfiles.mostCurrent.activityBA,perfiles.mostCurrent,25);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.perfiles.remoteMe.runUserSub(false, "perfiles","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 25;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 27;BA.debugLine="Activity.LoadLayout(\"perfiles\")";
Debug.ShouldStop(67108864);
perfiles.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("perfiles")),perfiles.mostCurrent.activityBA);
 BA.debugLineNum = 29;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (perfiles) ","perfiles",7,perfiles.mostCurrent.activityBA,perfiles.mostCurrent,35);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.perfiles.remoteMe.runUserSub(false, "perfiles","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 35;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4);
 BA.debugLineNum = 37;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (perfiles) ","perfiles",7,perfiles.mostCurrent.activityBA,perfiles.mostCurrent,31);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.perfiles.remoteMe.runUserSub(false, "perfiles","activity_resume");}
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 33;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnacudiente_click() throws Exception{
try {
		Debug.PushSubsStack("btnacudiente_Click (perfiles) ","perfiles",7,perfiles.mostCurrent.activityBA,perfiles.mostCurrent,50);
if (RapidSub.canDelegate("btnacudiente_click")) { return b4a.example.perfiles.remoteMe.runUserSub(false, "perfiles","btnacudiente_click");}
 BA.debugLineNum = 50;BA.debugLine="Sub btnacudiente_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="StartActivity(inicioAcudiente)";
Debug.ShouldStop(262144);
perfiles.mostCurrent.__c.runVoidMethod ("StartActivity",perfiles.processBA,(Object)((perfiles.mostCurrent._inicioacudiente.getObject())));
 BA.debugLineNum = 52;BA.debugLine="Activity.Finish";
Debug.ShouldStop(524288);
perfiles.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 53;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btndocente_click() throws Exception{
try {
		Debug.PushSubsStack("btndocente_Click (perfiles) ","perfiles",7,perfiles.mostCurrent.activityBA,perfiles.mostCurrent,40);
if (RapidSub.canDelegate("btndocente_click")) { return b4a.example.perfiles.remoteMe.runUserSub(false, "perfiles","btndocente_click");}
 BA.debugLineNum = 40;BA.debugLine="Sub btndocente_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 41;BA.debugLine="StartActivity(inicioDocente)";
Debug.ShouldStop(256);
perfiles.mostCurrent.__c.runVoidMethod ("StartActivity",perfiles.processBA,(Object)((perfiles.mostCurrent._iniciodocente.getObject())));
 BA.debugLineNum = 42;BA.debugLine="Activity.Finish";
Debug.ShouldStop(512);
perfiles.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 43;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnestudiante_click() throws Exception{
try {
		Debug.PushSubsStack("btnestudiante_Click (perfiles) ","perfiles",7,perfiles.mostCurrent.activityBA,perfiles.mostCurrent,45);
if (RapidSub.canDelegate("btnestudiante_click")) { return b4a.example.perfiles.remoteMe.runUserSub(false, "perfiles","btnestudiante_click");}
 BA.debugLineNum = 45;BA.debugLine="Sub btnestudiante_Click";
Debug.ShouldStop(4096);
 BA.debugLineNum = 46;BA.debugLine="StartActivity(inicioEstudiante)";
Debug.ShouldStop(8192);
perfiles.mostCurrent.__c.runVoidMethod ("StartActivity",perfiles.processBA,(Object)((perfiles.mostCurrent._inicioestudiante.getObject())));
 BA.debugLineNum = 47;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16384);
perfiles.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 48;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 12;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private btndocente As Button";
perfiles.mostCurrent._btndocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private btnestudiante As Button";
perfiles.mostCurrent._btnestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private btnacudiente As Button";
perfiles.mostCurrent._btnacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private Label2 As Label";
perfiles.mostCurrent._label2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private Label1 As Label";
perfiles.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private Label3 As Label";
perfiles.mostCurrent._label3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private retroceder As Label";
perfiles.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _retroceder_click() throws Exception{
try {
		Debug.PushSubsStack("retroceder_Click (perfiles) ","perfiles",7,perfiles.mostCurrent.activityBA,perfiles.mostCurrent,55);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.perfiles.remoteMe.runUserSub(false, "perfiles","retroceder_click");}
 BA.debugLineNum = 55;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="StartActivity(Main)";
Debug.ShouldStop(8388608);
perfiles.mostCurrent.__c.runVoidMethod ("StartActivity",perfiles.processBA,(Object)((perfiles.mostCurrent._main.getObject())));
 BA.debugLineNum = 57;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
perfiles.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 58;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
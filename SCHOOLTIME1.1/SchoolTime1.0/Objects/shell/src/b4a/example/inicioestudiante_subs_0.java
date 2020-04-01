package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class inicioestudiante_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (inicioestudiante) ","inicioestudiante",8,inicioestudiante.mostCurrent.activityBA,inicioestudiante.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.inicioestudiante.remoteMe.runUserSub(false, "inicioestudiante","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"inicioEstudiante\")";
Debug.ShouldStop(16777216);
inicioestudiante.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("inicioEstudiante")),inicioestudiante.mostCurrent.activityBA);
 BA.debugLineNum = 27;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("Activity_Pause (inicioestudiante) ","inicioestudiante",8,inicioestudiante.mostCurrent.activityBA,inicioestudiante.mostCurrent,33);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.inicioestudiante.remoteMe.runUserSub(false, "inicioestudiante","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("Activity_Resume (inicioestudiante) ","inicioestudiante",8,inicioestudiante.mostCurrent.activityBA,inicioestudiante.mostCurrent,29);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.inicioestudiante.remoteMe.runUserSub(false, "inicioestudiante","activity_resume");}
 BA.debugLineNum = 29;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 31;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btninicioestudiante_click() throws Exception{
try {
		Debug.PushSubsStack("btninicioEstudiante_Click (inicioestudiante) ","inicioestudiante",8,inicioestudiante.mostCurrent.activityBA,inicioestudiante.mostCurrent,59);
if (RapidSub.canDelegate("btninicioestudiante_click")) { return b4a.example.inicioestudiante.remoteMe.runUserSub(false, "inicioestudiante","btninicioestudiante_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 59;BA.debugLine="Sub btninicioEstudiante_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="If txtcorreoEstudiante.Text<>\"\" And txtcontrasena";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("!",inicioestudiante.mostCurrent._txtcorreoestudiante.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",inicioestudiante.mostCurrent._txtcontrasenaestudiante.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 61;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/s";
Debug.ShouldStop(268435456);
_apiaddress = BA.ObjectToString("http://192.168.1.5/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 62;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(536870912);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 63;BA.debugLine="job.Initialize(\"usuario_existe\", Me)";
Debug.ShouldStop(1073741824);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,inicioestudiante.processBA,(Object)(BA.ObjectToString("usuario_existe")),(Object)(inicioestudiante.getObject()));
 BA.debugLineNum = 64;BA.debugLine="job.PostString(ApiAddress,\"SELECT * FROM tbl_est";
Debug.ShouldStop(-2147483648);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tbl_estudiante where correo_e= '"),inicioestudiante.mostCurrent._txtcorreoestudiante.runMethod(true,"getText"),RemoteObject.createImmutable("'and contrasena_e='"),inicioestudiante.mostCurrent._txtcontrasenaestudiante.runMethod(true,"getText"),RemoteObject.createImmutable("'"))));
 }else {
 BA.debugLineNum = 66;BA.debugLine="MsgboxAsync(\"Todos los campos son requertidos pa";
Debug.ShouldStop(2);
inicioestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son requertidos para el ingreso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),inicioestudiante.processBA);
 };
 BA.debugLineNum = 68;BA.debugLine="End Sub";
Debug.ShouldStop(8);
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
 //BA.debugLineNum = 16;BA.debugLine="Private opcionregistro As Label";
inicioestudiante.mostCurrent._opcionregistro = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private retroceder As Label";
inicioestudiante.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private txtcorreoEstudiante As EditText";
inicioestudiante.mostCurrent._txtcorreoestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private btninicioEstudiante As Button";
inicioestudiante.mostCurrent._btninicioestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private txtcontrasenaEstudiante As EditText";
inicioestudiante.mostCurrent._txtcontrasenaestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (inicioestudiante) ","inicioestudiante",8,inicioestudiante.mostCurrent.activityBA,inicioestudiante.mostCurrent,70);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.inicioestudiante.remoteMe.runUserSub(false, "inicioestudiante","jobdone", _job);}
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _usuarios = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 70;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(32);
 BA.debugLineNum = 71;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(64);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 72;BA.debugLine="Dim res As String";
Debug.ShouldStop(128);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 73;BA.debugLine="res = Job.GetString";
Debug.ShouldStop(256);
_res = _job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 74;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(512);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 75;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(1024);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 76;BA.debugLine="If Job.JobName= \"usuario_existe\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("usuario_existe"))) { 
 BA.debugLineNum = 77;BA.debugLine="Dim usuarios As List";
Debug.ShouldStop(4096);
_usuarios = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("usuarios", _usuarios);
 BA.debugLineNum = 78;BA.debugLine="usuarios = parser.NextArray";
Debug.ShouldStop(8192);
_usuarios = _parser.runMethod(false,"NextArray");Debug.locals.put("usuarios", _usuarios);
 BA.debugLineNum = 79;BA.debugLine="If usuarios.Size > 0 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean(">",_usuarios.runMethod(true,"getSize"),BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 80;BA.debugLine="StartActivity(ingresoEstudiante)";
Debug.ShouldStop(32768);
inicioestudiante.mostCurrent.__c.runVoidMethod ("StartActivity",inicioestudiante.processBA,(Object)((inicioestudiante.mostCurrent._ingresoestudiante.getObject())));
 BA.debugLineNum = 81;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
inicioestudiante.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 83;BA.debugLine="MsgboxAsync(\"El usuario no se encuentra regist";
Debug.ShouldStop(262144);
inicioestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El usuario no se encuentra registrado, por favor intentelo de nuevo")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),inicioestudiante.processBA);
 BA.debugLineNum = 84;BA.debugLine="txtcorreoEstudiante.Text = \"\"";
Debug.ShouldStop(524288);
inicioestudiante.mostCurrent._txtcorreoestudiante.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 85;BA.debugLine="txtcontrasenaEstudiante.Text = \"\"";
Debug.ShouldStop(1048576);
inicioestudiante.mostCurrent._txtcontrasenaestudiante.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 };
 }else {
 BA.debugLineNum = 89;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(16777216);
inicioestudiante.mostCurrent.__c.runVoidMethod ("LogImpl","27208979",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 90;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(33554432);
inicioestudiante.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(inicioestudiante.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 92;BA.debugLine="Job.Release";
Debug.ShouldStop(134217728);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 93;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _opcionregistro_click() throws Exception{
try {
		Debug.PushSubsStack("opcionregistro_Click (inicioestudiante) ","inicioestudiante",8,inicioestudiante.mostCurrent.activityBA,inicioestudiante.mostCurrent,37);
if (RapidSub.canDelegate("opcionregistro_click")) { return b4a.example.inicioestudiante.remoteMe.runUserSub(false, "inicioestudiante","opcionregistro_click");}
 BA.debugLineNum = 37;BA.debugLine="Sub opcionregistro_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="StartActivity(registroEstudiante)";
Debug.ShouldStop(32);
inicioestudiante.mostCurrent.__c.runVoidMethod ("StartActivity",inicioestudiante.processBA,(Object)((inicioestudiante.mostCurrent._registroestudiante.getObject())));
 BA.debugLineNum = 39;BA.debugLine="Activity.Finish";
Debug.ShouldStop(64);
inicioestudiante.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 40;BA.debugLine="End Sub";
Debug.ShouldStop(128);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _retroceder_click() throws Exception{
try {
		Debug.PushSubsStack("retroceder_Click (inicioestudiante) ","inicioestudiante",8,inicioestudiante.mostCurrent.activityBA,inicioestudiante.mostCurrent,42);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.inicioestudiante.remoteMe.runUserSub(false, "inicioestudiante","retroceder_click");}
 BA.debugLineNum = 42;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="StartActivity(perfiles)";
Debug.ShouldStop(1024);
inicioestudiante.mostCurrent.__c.runVoidMethod ("StartActivity",inicioestudiante.processBA,(Object)((inicioestudiante.mostCurrent._perfiles.getObject())));
 BA.debugLineNum = 44;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2048);
inicioestudiante.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 45;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtcontrasenaestudiante_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcontrasenaEstudiante_TextChanged (inicioestudiante) ","inicioestudiante",8,inicioestudiante.mostCurrent.activityBA,inicioestudiante.mostCurrent,53);
if (RapidSub.canDelegate("txtcontrasenaestudiante_textchanged")) { return b4a.example.inicioestudiante.remoteMe.runUserSub(false, "inicioestudiante","txtcontrasenaestudiante_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 53;BA.debugLine="Sub txtcontrasenaEstudiante_TextChanged (Old As St";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 55;BA.debugLine="MsgboxAsync(\"La contraseña no puede sobrepasar l";
Debug.ShouldStop(4194304);
inicioestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),inicioestudiante.processBA);
 };
 BA.debugLineNum = 57;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtcorreoestudiante_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcorreoEstudiante_TextChanged (inicioestudiante) ","inicioestudiante",8,inicioestudiante.mostCurrent.activityBA,inicioestudiante.mostCurrent,47);
if (RapidSub.canDelegate("txtcorreoestudiante_textchanged")) { return b4a.example.inicioestudiante.remoteMe.runUserSub(false, "inicioestudiante","txtcorreoestudiante_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 47;BA.debugLine="Sub txtcorreoEstudiante_TextChanged (Old As String";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="If New.Length >= 50 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 50))) { 
 BA.debugLineNum = 49;BA.debugLine="MsgboxAsync(\"El correo no puede sobrepasar los 1";
Debug.ShouldStop(65536);
inicioestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El correo no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),inicioestudiante.processBA);
 };
 BA.debugLineNum = 51;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
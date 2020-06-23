package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class inicioacudiente_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (inicioacudiente) ","inicioacudiente",4,inicioacudiente.mostCurrent.activityBA,inicioacudiente.mostCurrent,22);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.inicioacudiente.remoteMe.runUserSub(false, "inicioacudiente","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 22;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 24;BA.debugLine="Activity.LoadLayout(\"iniciarr\")";
Debug.ShouldStop(8388608);
inicioacudiente.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("iniciarr")),inicioacudiente.mostCurrent.activityBA);
 BA.debugLineNum = 25;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Pause (inicioacudiente) ","inicioacudiente",4,inicioacudiente.mostCurrent.activityBA,inicioacudiente.mostCurrent,31);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.inicioacudiente.remoteMe.runUserSub(false, "inicioacudiente","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 31;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (inicioacudiente) ","inicioacudiente",4,inicioacudiente.mostCurrent.activityBA,inicioacudiente.mostCurrent,27);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.inicioacudiente.remoteMe.runUserSub(false, "inicioacudiente","activity_resume");}
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(67108864);
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
public static RemoteObject  _btniniciaracudinte_click() throws Exception{
try {
		Debug.PushSubsStack("btniniciaracudinte_Click (inicioacudiente) ","inicioacudiente",4,inicioacudiente.mostCurrent.activityBA,inicioacudiente.mostCurrent,57);
if (RapidSub.canDelegate("btniniciaracudinte_click")) { return b4a.example.inicioacudiente.remoteMe.runUserSub(false, "inicioacudiente","btniniciaracudinte_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 57;BA.debugLine="Sub btniniciaracudinte_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 58;BA.debugLine="If txtcorreoacudiente.Text <> \"\" And txtContrasen";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("!",inicioacudiente.mostCurrent._txtcorreoacudiente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",inicioacudiente.mostCurrent._txtcontrasenaacudiente.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 59;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/s";
Debug.ShouldStop(67108864);
_apiaddress = BA.ObjectToString("http://192.168.1.5/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 60;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(134217728);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 61;BA.debugLine="job.Initialize(\"usuario_existe\", Me)";
Debug.ShouldStop(268435456);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,inicioacudiente.processBA,(Object)(BA.ObjectToString("usuario_existe")),(Object)(inicioacudiente.getObject()));
 BA.debugLineNum = 62;BA.debugLine="job.PostString(ApiAddress,\"SELECT * FROM tbl_acu";
Debug.ShouldStop(536870912);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tbl_acudiente where correo_acu= '"),inicioacudiente.mostCurrent._txtcorreoacudiente.runMethod(true,"getText"),RemoteObject.createImmutable("'and contrasena_acu='"),inicioacudiente.mostCurrent._txtcontrasenaacudiente.runMethod(true,"getText"),RemoteObject.createImmutable("'"))));
 }else {
 BA.debugLineNum = 64;BA.debugLine="MsgboxAsync(\"Todos los campos son necesarios par";
Debug.ShouldStop(-2147483648);
inicioacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son necesarios para el ingreso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),inicioacudiente.processBA);
 };
 BA.debugLineNum = 66;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
 //BA.debugLineNum = 15;BA.debugLine="Private btniniciaracudinte As Button";
inicioacudiente.mostCurrent._btniniciaracudinte = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private opcionregistro As Label";
inicioacudiente.mostCurrent._opcionregistro = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private retroceder As Label";
inicioacudiente.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private txtContrasenaacudiente As EditText";
inicioacudiente.mostCurrent._txtcontrasenaacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txtcorreoacudiente As EditText";
inicioacudiente.mostCurrent._txtcorreoacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (inicioacudiente) ","inicioacudiente",4,inicioacudiente.mostCurrent.activityBA,inicioacudiente.mostCurrent,68);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.inicioacudiente.remoteMe.runUserSub(false, "inicioacudiente","jobdone", _job);}
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _usuarios = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 68;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(8);
 BA.debugLineNum = 69;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(16);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 70;BA.debugLine="Dim res As String";
Debug.ShouldStop(32);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 71;BA.debugLine="res = Job.GetString";
Debug.ShouldStop(64);
_res = _job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 72;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(128);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 73;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(256);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 74;BA.debugLine="If Job.JobName= \"usuario_existe\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("usuario_existe"))) { 
 BA.debugLineNum = 75;BA.debugLine="Dim usuarios As List";
Debug.ShouldStop(1024);
_usuarios = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("usuarios", _usuarios);
 BA.debugLineNum = 76;BA.debugLine="usuarios = parser.NextArray";
Debug.ShouldStop(2048);
_usuarios = _parser.runMethod(false,"NextArray");Debug.locals.put("usuarios", _usuarios);
 BA.debugLineNum = 77;BA.debugLine="If usuarios.Size > 0 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean(">",_usuarios.runMethod(true,"getSize"),BA.numberCast(int.class, 0))) { 
 BA.debugLineNum = 78;BA.debugLine="StartActivity(ingreso)";
Debug.ShouldStop(8192);
inicioacudiente.mostCurrent.__c.runVoidMethod ("StartActivity",inicioacudiente.processBA,(Object)((inicioacudiente.mostCurrent._ingreso.getObject())));
 BA.debugLineNum = 79;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16384);
inicioacudiente.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 81;BA.debugLine="MsgboxAsync(\"El usuario no se encuentra regist";
Debug.ShouldStop(65536);
inicioacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El usuario no se encuentra registrado, por favor intentelo de nuevo")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),inicioacudiente.processBA);
 BA.debugLineNum = 82;BA.debugLine="txtcorreoacudiente.Text= \"\"";
Debug.ShouldStop(131072);
inicioacudiente.mostCurrent._txtcorreoacudiente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 83;BA.debugLine="txtContrasenaacudiente.Text= \"\"";
Debug.ShouldStop(262144);
inicioacudiente.mostCurrent._txtcontrasenaacudiente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 };
 }else {
 BA.debugLineNum = 87;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(4194304);
inicioacudiente.mostCurrent.__c.runVoidMethod ("LogImpl","07667731",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 88;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(8388608);
inicioacudiente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(inicioacudiente.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 90;BA.debugLine="Job.Release";
Debug.ShouldStop(33554432);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 91;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("opcionregistro_Click (inicioacudiente) ","inicioacudiente",4,inicioacudiente.mostCurrent.activityBA,inicioacudiente.mostCurrent,52);
if (RapidSub.canDelegate("opcionregistro_click")) { return b4a.example.inicioacudiente.remoteMe.runUserSub(false, "inicioacudiente","opcionregistro_click");}
 BA.debugLineNum = 52;BA.debugLine="Sub opcionregistro_Click";
Debug.ShouldStop(524288);
 BA.debugLineNum = 53;BA.debugLine="StartActivity(registroAcudiente)";
Debug.ShouldStop(1048576);
inicioacudiente.mostCurrent.__c.runVoidMethod ("StartActivity",inicioacudiente.processBA,(Object)((inicioacudiente.mostCurrent._registroacudiente.getObject())));
 BA.debugLineNum = 54;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2097152);
inicioacudiente.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 55;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("retroceder_Click (inicioacudiente) ","inicioacudiente",4,inicioacudiente.mostCurrent.activityBA,inicioacudiente.mostCurrent,47);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.inicioacudiente.remoteMe.runUserSub(false, "inicioacudiente","retroceder_click");}
 BA.debugLineNum = 47;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="StartActivity(perfiles)";
Debug.ShouldStop(32768);
inicioacudiente.mostCurrent.__c.runVoidMethod ("StartActivity",inicioacudiente.processBA,(Object)((inicioacudiente.mostCurrent._perfiles.getObject())));
 BA.debugLineNum = 49;BA.debugLine="Activity.Finish";
Debug.ShouldStop(65536);
inicioacudiente.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 50;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtcontrasenaacudiente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtContrasenaacudiente_TextChanged (inicioacudiente) ","inicioacudiente",4,inicioacudiente.mostCurrent.activityBA,inicioacudiente.mostCurrent,41);
if (RapidSub.canDelegate("txtcontrasenaacudiente_textchanged")) { return b4a.example.inicioacudiente.remoteMe.runUserSub(false, "inicioacudiente","txtcontrasenaacudiente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 41;BA.debugLine="Sub txtContrasenaacudiente_TextChanged (Old As Str";
Debug.ShouldStop(256);
 BA.debugLineNum = 42;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 20))) { 
 BA.debugLineNum = 43;BA.debugLine="MsgboxAsync(\"La contraseña no puede sobrepasar l";
Debug.ShouldStop(1024);
inicioacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),inicioacudiente.processBA);
 };
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
public static RemoteObject  _txtcorreoacudiente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcorreoacudiente_TextChanged (inicioacudiente) ","inicioacudiente",4,inicioacudiente.mostCurrent.activityBA,inicioacudiente.mostCurrent,35);
if (RapidSub.canDelegate("txtcorreoacudiente_textchanged")) { return b4a.example.inicioacudiente.remoteMe.runUserSub(false, "inicioacudiente","txtcorreoacudiente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 35;BA.debugLine="Sub txtcorreoacudiente_TextChanged (Old As String,";
Debug.ShouldStop(4);
 BA.debugLineNum = 36;BA.debugLine="If New.Length >= 49 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 49))) { 
 BA.debugLineNum = 37;BA.debugLine="MsgboxAsync(\"El correo no puede sobrepasar los 4";
Debug.ShouldStop(16);
inicioacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El correo no puede sobrepasar los 40 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),inicioacudiente.processBA);
 };
 BA.debugLineNum = 39;BA.debugLine="End Sub";
Debug.ShouldStop(64);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class iniciodocente_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (iniciodocente) ","iniciodocente",5,iniciodocente.mostCurrent.activityBA,iniciodocente.mostCurrent,23);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.iniciodocente.remoteMe.runUserSub(false, "iniciodocente","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 23;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 25;BA.debugLine="Activity.LoadLayout(\"inicioDocente\")";
Debug.ShouldStop(16777216);
iniciodocente.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("inicioDocente")),iniciodocente.mostCurrent.activityBA);
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
		Debug.PushSubsStack("Activity_Pause (iniciodocente) ","iniciodocente",5,iniciodocente.mostCurrent.activityBA,iniciodocente.mostCurrent,33);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.iniciodocente.remoteMe.runUserSub(false, "iniciodocente","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (iniciodocente) ","iniciodocente",5,iniciodocente.mostCurrent.activityBA,iniciodocente.mostCurrent,29);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.iniciodocente.remoteMe.runUserSub(false, "iniciodocente","activity_resume");}
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
public static RemoteObject  _btniniciardococente_click() throws Exception{
try {
		Debug.PushSubsStack("btniniciardococente_Click (iniciodocente) ","iniciodocente",5,iniciodocente.mostCurrent.activityBA,iniciodocente.mostCurrent,59);
if (RapidSub.canDelegate("btniniciardococente_click")) { return b4a.example.iniciodocente.remoteMe.runUserSub(false, "iniciodocente","btniniciardococente_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 59;BA.debugLine="Sub btniniciardococente_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="If txtcorreodococente.Text <> \"\" And txtContrasen";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("!",iniciodocente.mostCurrent._txtcorreodococente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",iniciodocente.mostCurrent._txtcontrasenadocente.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 62;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/s";
Debug.ShouldStop(536870912);
_apiaddress = BA.ObjectToString("http://192.168.1.1/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 66;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(2);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 67;BA.debugLine="job.Initialize(\"usuario_existe\", Me)";
Debug.ShouldStop(4);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,iniciodocente.processBA,(Object)(BA.ObjectToString("usuario_existe")),(Object)(iniciodocente.getObject()));
 BA.debugLineNum = 68;BA.debugLine="job.PostString(ApiAddress,\"SELECT * FROM tbl_doc";
Debug.ShouldStop(8);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("SELECT * FROM tbl_docente where correo_doc= '"),iniciodocente.mostCurrent._txtcorreodococente.runMethod(true,"getText"),RemoteObject.createImmutable("'and contrasena_doc='"),iniciodocente.mostCurrent._txtcontrasenadocente.runMethod(true,"getText"),RemoteObject.createImmutable("'"))));
 }else {
 BA.debugLineNum = 70;BA.debugLine="MsgboxAsync(\"Todos los campos son necesarios par";
Debug.ShouldStop(32);
iniciodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son necesarios para el ingreso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),iniciodocente.processBA);
 };
 BA.debugLineNum = 72;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
iniciodocente.mostCurrent._opcionregistro = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private retroceder As Label";
iniciodocente.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private txtcorreodococente As EditText";
iniciodocente.mostCurrent._txtcorreodococente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txtContrasenadocente As EditText";
iniciodocente.mostCurrent._txtcontrasenadocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private btniniciardococente As Button";
iniciodocente.mostCurrent._btniniciardococente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (iniciodocente) ","iniciodocente",5,iniciodocente.mostCurrent.activityBA,iniciodocente.mostCurrent,74);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.iniciodocente.remoteMe.runUserSub(false, "iniciodocente","jobdone", _job);}
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _usuarios = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
Debug.locals.put("Job", _job);
 BA.debugLineNum = 74;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(512);
 BA.debugLineNum = 75;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(1024);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 76;BA.debugLine="Dim res As String";
Debug.ShouldStop(2048);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 77;BA.debugLine="res = Job.GetString";
Debug.ShouldStop(4096);
_res = _job.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 78;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8192);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 79;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(16384);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 80;BA.debugLine="If Job.JobName= \"usuario_existe\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",_job.getField(true,"_jobname" /*RemoteObject*/ ),BA.ObjectToString("usuario_existe"))) { 
 BA.debugLineNum = 81;BA.debugLine="Dim usuarios As List";
Debug.ShouldStop(65536);
_usuarios = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("usuarios", _usuarios);
 BA.debugLineNum = 82;BA.debugLine="usuarios = parser.NextArray";
Debug.ShouldStop(131072);
_usuarios = _parser.runMethod(false,"NextArray");Debug.locals.put("usuarios", _usuarios);
 BA.debugLineNum = 83;BA.debugLine="If usuarios.Size > 0 Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean(">",_usuarios.runMethod(true,"getSize"),BA.numberCast(int.class, 0))) { 
 BA.debugLineNum = 84;BA.debugLine="StartActivity(ingresoDocente)";
Debug.ShouldStop(524288);
iniciodocente.mostCurrent.__c.runVoidMethod ("StartActivity",iniciodocente.processBA,(Object)((iniciodocente.mostCurrent._ingresodocente.getObject())));
 BA.debugLineNum = 85;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1048576);
iniciodocente.mostCurrent._activity.runVoidMethod ("Finish");
 }else {
 BA.debugLineNum = 87;BA.debugLine="MsgboxAsync(\"El usuario no se encuentra regist";
Debug.ShouldStop(4194304);
iniciodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El usuario no se encuentra registrado, por favor intentelo de nuevo")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),iniciodocente.processBA);
 BA.debugLineNum = 88;BA.debugLine="txtcorreodococente.Text= \"\"";
Debug.ShouldStop(8388608);
iniciodocente.mostCurrent._txtcorreodococente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 89;BA.debugLine="txtContrasenadocente.Text= \"\"";
Debug.ShouldStop(16777216);
iniciodocente.mostCurrent._txtcontrasenadocente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 };
 }else {
 BA.debugLineNum = 93;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(268435456);
iniciodocente.mostCurrent.__c.runVoidMethod ("LogImpl","08388627",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 94;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(536870912);
iniciodocente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(iniciodocente.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 96;BA.debugLine="Job.Release";
Debug.ShouldStop(-2147483648);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 97;BA.debugLine="End Sub";
Debug.ShouldStop(1);
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
		Debug.PushSubsStack("opcionregistro_Click (iniciodocente) ","iniciodocente",5,iniciodocente.mostCurrent.activityBA,iniciodocente.mostCurrent,37);
if (RapidSub.canDelegate("opcionregistro_click")) { return b4a.example.iniciodocente.remoteMe.runUserSub(false, "iniciodocente","opcionregistro_click");}
 BA.debugLineNum = 37;BA.debugLine="Sub opcionregistro_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 38;BA.debugLine="StartActivity(registroDocente)";
Debug.ShouldStop(32);
iniciodocente.mostCurrent.__c.runVoidMethod ("StartActivity",iniciodocente.processBA,(Object)((iniciodocente.mostCurrent._registrodocente.getObject())));
 BA.debugLineNum = 39;BA.debugLine="Activity.Finish";
Debug.ShouldStop(64);
iniciodocente.mostCurrent._activity.runVoidMethod ("Finish");
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
		Debug.PushSubsStack("retroceder_Click (iniciodocente) ","iniciodocente",5,iniciodocente.mostCurrent.activityBA,iniciodocente.mostCurrent,42);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.iniciodocente.remoteMe.runUserSub(false, "iniciodocente","retroceder_click");}
 BA.debugLineNum = 42;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(512);
 BA.debugLineNum = 43;BA.debugLine="StartActivity(perfiles)";
Debug.ShouldStop(1024);
iniciodocente.mostCurrent.__c.runVoidMethod ("StartActivity",iniciodocente.processBA,(Object)((iniciodocente.mostCurrent._perfiles.getObject())));
 BA.debugLineNum = 44;BA.debugLine="Activity.Finish";
Debug.ShouldStop(2048);
iniciodocente.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _txtcontrasenadocente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtContrasenadocente_TextChanged (iniciodocente) ","iniciodocente",5,iniciodocente.mostCurrent.activityBA,iniciodocente.mostCurrent,53);
if (RapidSub.canDelegate("txtcontrasenadocente_textchanged")) { return b4a.example.iniciodocente.remoteMe.runUserSub(false, "iniciodocente","txtcontrasenadocente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 53;BA.debugLine="Sub txtContrasenadocente_TextChanged (Old As Strin";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 54;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 20))) { 
 BA.debugLineNum = 55;BA.debugLine="MsgboxAsync(\"La contraseña no puede sobrepasar l";
Debug.ShouldStop(4194304);
iniciodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),iniciodocente.processBA);
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
public static RemoteObject  _txtcorreodococente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcorreodococente_TextChanged (iniciodocente) ","iniciodocente",5,iniciodocente.mostCurrent.activityBA,iniciodocente.mostCurrent,47);
if (RapidSub.canDelegate("txtcorreodococente_textchanged")) { return b4a.example.iniciodocente.remoteMe.runUserSub(false, "iniciodocente","txtcorreodococente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 47;BA.debugLine="Sub txtcorreodococente_TextChanged (Old As String,";
Debug.ShouldStop(16384);
 BA.debugLineNum = 48;BA.debugLine="If New.Length >= 49 Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 49))) { 
 BA.debugLineNum = 49;BA.debugLine="MsgboxAsync(\"El correo no puede sobrepasar los 4";
Debug.ShouldStop(65536);
iniciodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El correo no puede sobrepasar los 40 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),iniciodocente.processBA);
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
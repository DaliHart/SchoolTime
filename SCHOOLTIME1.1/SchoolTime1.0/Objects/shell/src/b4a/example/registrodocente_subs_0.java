package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registrodocente_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,33);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"registroDocente\")";
Debug.ShouldStop(4);
registrodocente.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("registroDocente")),registrodocente.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="ScrollView1.Panel.LoadLayout(\"contenidoDocente\")";
Debug.ShouldStop(8);
registrodocente.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("contenidoDocente")),registrodocente.mostCurrent.activityBA);
 BA.debugLineNum = 37;BA.debugLine="ScrollView1.Panel.Height = 80%y";
Debug.ShouldStop(16);
registrodocente.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",registrodocente.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 80)),registrodocente.mostCurrent.activityBA));
 BA.debugLineNum = 38;BA.debugLine="Panel2.Visible = False";
Debug.ShouldStop(32);
registrodocente.mostCurrent._panel2.runMethod(true,"setVisible",registrodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 39;BA.debugLine="fondo.Visible= False";
Debug.ShouldStop(64);
registrodocente.mostCurrent._fondo.runMethod(true,"setVisible",registrodocente.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,46);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 46;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8192);
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,42);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","activity_resume");}
 BA.debugLineNum = 42;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(512);
 BA.debugLineNum = 44;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btnregistrardocente_click() throws Exception{
try {
		Debug.PushSubsStack("btnregistrardocente_Click (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,101);
if (RapidSub.canDelegate("btnregistrardocente_click")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","btnregistrardocente_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 101;BA.debugLine="Sub btnregistrardocente_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="If txtnombredocente.Text<>\"\" And txtceduladocente";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("!",registrodocente.mostCurrent._txtnombredocente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registrodocente.mostCurrent._txtceduladocente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registrodocente.mostCurrent._txtcorreodocente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registrodocente.mostCurrent._txtcondocente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registrodocente.mostCurrent._txtconfirmaciondocente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registrodocente.mostCurrent._txtapellidodocente.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 103;BA.debugLine="If txtcondocente.Text = txtconfirmaciondocente.T";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",registrodocente.mostCurrent._txtcondocente.runMethod(true,"getText"),registrodocente.mostCurrent._txtconfirmaciondocente.runMethod(true,"getText"))) { 
 BA.debugLineNum = 104;BA.debugLine="If txtcorreodocente.Text.Contains(\"@\") Then";
Debug.ShouldStop(128);
if (registrodocente.mostCurrent._txtcorreodocente.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("@"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 105;BA.debugLine="If txtcorreodocente.Text.Contains(\".\") Then";
Debug.ShouldStop(256);
if (registrodocente.mostCurrent._txtcorreodocente.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("."))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 106;BA.debugLine="If txtcorreodocente.Text.Contains(\" \") Then";
Debug.ShouldStop(512);
if (registrodocente.mostCurrent._txtcorreodocente.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable(" "))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 107;BA.debugLine="ToastMessageShow(\"El correo no debe contener";
Debug.ShouldStop(1024);
registrodocente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("El correo no debe contener espacios")),(Object)(registrodocente.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 108;BA.debugLine="txtcorreodocente.Text=\"\"";
Debug.ShouldStop(2048);
registrodocente.mostCurrent._txtcorreodocente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 }else {
 BA.debugLineNum = 110;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1";
Debug.ShouldStop(8192);
_apiaddress = BA.ObjectToString("http://192.168.1.1/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 111;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(16384);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 112;BA.debugLine="job.Initialize(\"\", Me)";
Debug.ShouldStop(32768);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,registrodocente.processBA,(Object)(BA.ObjectToString("")),(Object)(registrodocente.getObject()));
 BA.debugLineNum = 113;BA.debugLine="job.PostString(ApiAddress,\"INSERT INTO tbl_d";
Debug.ShouldStop(65536);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO tbl_docente(id_docente,nombre_doc,apellido_doc,correo_doc,contrasena_doc,codigo_g ) VALUES ('"),registrodocente.mostCurrent._txtceduladocente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registrodocente.mostCurrent._txtnombredocente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registrodocente.mostCurrent._txtapellidodocente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registrodocente.mostCurrent._txtcorreodocente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registrodocente.mostCurrent._txtcondocente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registrodocente.mostCurrent._txtcodigodocente.runMethod(true,"getText"),RemoteObject.createImmutable("')"))));
 };
 }else {
 BA.debugLineNum = 116;BA.debugLine="ToastMessageShow(\"Correo inválido: .\", False)";
Debug.ShouldStop(524288);
registrodocente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo inválido: .")),(Object)(registrodocente.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 117;BA.debugLine="txtcorreodocente.Text=\"\"";
Debug.ShouldStop(1048576);
registrodocente.mostCurrent._txtcorreodocente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 }else {
 BA.debugLineNum = 120;BA.debugLine="ToastMessageShow(\"Correo inválido: @\", False)";
Debug.ShouldStop(8388608);
registrodocente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo inválido: @")),(Object)(registrodocente.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 121;BA.debugLine="txtcorreodocente.Text=\"\"";
Debug.ShouldStop(16777216);
registrodocente.mostCurrent._txtcorreodocente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 }else {
 BA.debugLineNum = 124;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
Debug.ShouldStop(134217728);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Las contraseñas deben coincidir")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registrodocente.processBA);
 };
 }else {
 BA.debugLineNum = 127;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
Debug.ShouldStop(1073741824);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son requeridos para el registro")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registrodocente.processBA);
 };
 BA.debugLineNum = 129;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cerrarcodigo_click() throws Exception{
try {
		Debug.PushSubsStack("cerrarCodigo_Click (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,159);
if (RapidSub.canDelegate("cerrarcodigo_click")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","cerrarcodigo_click");}
 BA.debugLineNum = 159;BA.debugLine="Sub cerrarCodigo_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="If doc = 1 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",registrodocente._doc,BA.numberCast(int.class, 1))) { 
 BA.debugLineNum = 161;BA.debugLine="Panel2.Visible= False";
Debug.ShouldStop(1);
registrodocente.mostCurrent._panel2.runMethod(true,"setVisible",registrodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 162;BA.debugLine="fondo.Visible= False";
Debug.ShouldStop(2);
registrodocente.mostCurrent._fondo.runMethod(true,"setVisible",registrodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 163;BA.debugLine="btnregistrardocente.Visible= True";
Debug.ShouldStop(4);
registrodocente.mostCurrent._btnregistrardocente.runMethod(true,"setVisible",registrodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 164;BA.debugLine="doc = 0";
Debug.ShouldStop(8);
registrodocente._doc = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 166;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
 //BA.debugLineNum = 15;BA.debugLine="Private ScrollView1 As ScrollView";
registrodocente.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Dim Label1 As Label";
registrodocente.mostCurrent._label1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private retroceder As Label";
registrodocente.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private btnregistrardocente As Button";
registrodocente.mostCurrent._btnregistrardocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txtnombredocente As EditText";
registrodocente.mostCurrent._txtnombredocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private txtceduladocente As EditText";
registrodocente.mostCurrent._txtceduladocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private txtcorreodocente As EditText";
registrodocente.mostCurrent._txtcorreodocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private txtcondocente As EditText";
registrodocente.mostCurrent._txtcondocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private txtconfirmaciondocente As EditText";
registrodocente.mostCurrent._txtconfirmaciondocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private txtapellidodocente As EditText";
registrodocente.mostCurrent._txtapellidodocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private txtcodigodocente As EditText";
registrodocente.mostCurrent._txtcodigodocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private opcioncodigo As Label";
registrodocente.mostCurrent._opcioncodigo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private fondo As Panel";
registrodocente.mostCurrent._fondo = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Panel2 As Panel";
registrodocente.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private cerrarCodigo As Label";
registrodocente.mostCurrent._cerrarcodigo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Dim doc As Int = 0";
registrodocente._doc = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _hecho_tick() throws Exception{
try {
		Debug.PushSubsStack("hecho_Tick (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,144);
if (RapidSub.canDelegate("hecho_tick")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","hecho_tick");}
 BA.debugLineNum = 144;BA.debugLine="Sub hecho_Tick";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="StartActivity(ingresoDocente)";
Debug.ShouldStop(65536);
registrodocente.mostCurrent.__c.runVoidMethod ("StartActivity",registrodocente.processBA,(Object)((registrodocente.mostCurrent._ingresodocente.getObject())));
 BA.debugLineNum = 146;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
registrodocente.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 147;BA.debugLine="hecho.Enabled= False";
Debug.ShouldStop(262144);
registrodocente._hecho.runMethod(true,"setEnabled",registrodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 148;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,131);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 131;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(8);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 133;BA.debugLine="Log(\"OK, operacion con éxito\")";
Debug.ShouldStop(16);
registrodocente.mostCurrent.__c.runVoidMethod ("LogImpl","011993090",RemoteObject.createImmutable("OK, operacion con éxito"),0);
 BA.debugLineNum = 134;BA.debugLine="MsgboxAsync(\"Su registro ha sido exitoso\",\"AVISO";
Debug.ShouldStop(32);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Su registro ha sido exitoso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),registrodocente.processBA);
 BA.debugLineNum = 135;BA.debugLine="hecho.Initialize(\"hecho\", 2000)";
Debug.ShouldStop(64);
registrodocente._hecho.runVoidMethod ("Initialize",registrodocente.processBA,(Object)(BA.ObjectToString("hecho")),(Object)(BA.numberCast(long.class, 2000)));
 BA.debugLineNum = 136;BA.debugLine="hecho.Enabled= True";
Debug.ShouldStop(128);
registrodocente._hecho.runMethod(true,"setEnabled",registrodocente.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 138;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(512);
registrodocente.mostCurrent.__c.runVoidMethod ("LogImpl","011993095",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 139;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(1024);
registrodocente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(registrodocente.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 141;BA.debugLine="Job.Release";
Debug.ShouldStop(4096);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 142;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _opcioncodigo_click() throws Exception{
try {
		Debug.PushSubsStack("opcioncodigo_Click (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,150);
if (RapidSub.canDelegate("opcioncodigo_click")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","opcioncodigo_click");}
 BA.debugLineNum = 150;BA.debugLine="Sub opcioncodigo_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 151;BA.debugLine="If doc = 0 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",registrodocente._doc,BA.numberCast(int.class, 0))) { 
 BA.debugLineNum = 152;BA.debugLine="Panel2.Visible= True";
Debug.ShouldStop(8388608);
registrodocente.mostCurrent._panel2.runMethod(true,"setVisible",registrodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 153;BA.debugLine="fondo.Visible=True";
Debug.ShouldStop(16777216);
registrodocente.mostCurrent._fondo.runMethod(true,"setVisible",registrodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 154;BA.debugLine="btnregistrardocente.Visible= False";
Debug.ShouldStop(33554432);
registrodocente.mostCurrent._btnregistrardocente.runMethod(true,"setVisible",registrodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 155;BA.debugLine="doc = 1";
Debug.ShouldStop(67108864);
registrodocente._doc = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 157;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _opcioniniciodocente_click() throws Exception{
try {
		Debug.PushSubsStack("opcioninicioDocente_Click (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,50);
if (RapidSub.canDelegate("opcioniniciodocente_click")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","opcioniniciodocente_click");}
 BA.debugLineNum = 50;BA.debugLine="Sub opcioninicioDocente_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="StartActivity(inicioDocente)";
Debug.ShouldStop(262144);
registrodocente.mostCurrent.__c.runVoidMethod ("StartActivity",registrodocente.processBA,(Object)((registrodocente.mostCurrent._iniciodocente.getObject())));
 BA.debugLineNum = 52;BA.debugLine="Activity.Finish";
Debug.ShouldStop(524288);
registrodocente.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim hecho As Timer";
registrodocente._hecho = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 10;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _retroceder_click() throws Exception{
try {
		Debug.PushSubsStack("retroceder_Click (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,55);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","retroceder_click");}
 BA.debugLineNum = 55;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="StartActivity(inicioDocente)";
Debug.ShouldStop(8388608);
registrodocente.mostCurrent.__c.runVoidMethod ("StartActivity",registrodocente.processBA,(Object)((registrodocente.mostCurrent._iniciodocente.getObject())));
 BA.debugLineNum = 57;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
registrodocente.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _txtapellidodocente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtapellidodocente_TextChanged (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,96);
if (RapidSub.canDelegate("txtapellidodocente_textchanged")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","txtapellidodocente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 96;BA.debugLine="Sub txtapellidodocente_TextChanged (Old As String,";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 20))) { 
 BA.debugLineNum = 98;BA.debugLine="MsgboxAsync(\"El apellido no puede sobrepasar los";
Debug.ShouldStop(2);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El apellido no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registrodocente.processBA);
 };
 BA.debugLineNum = 100;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtceduladocente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtceduladocente_TextChanged (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,66);
if (RapidSub.canDelegate("txtceduladocente_textchanged")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","txtceduladocente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 66;BA.debugLine="Sub txtceduladocente_TextChanged (Old As String, N";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="If New.Length > 10 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(int.class, 10))) { 
 BA.debugLineNum = 68;BA.debugLine="MsgboxAsync(\"La cédula no puede sobrepasar los 1";
Debug.ShouldStop(8);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La cédula no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registrodocente.processBA);
 };
 BA.debugLineNum = 70;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtcodigodocente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcodigodocente_TextChanged (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,90);
if (RapidSub.canDelegate("txtcodigodocente_textchanged")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","txtcodigodocente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 90;BA.debugLine="Sub txtcodigodocente_TextChanged (Old As String, N";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="If New.Length > 10 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean(">",_new.runMethod(true,"length"),BA.numberCast(int.class, 10))) { 
 BA.debugLineNum = 92;BA.debugLine="MsgboxAsync(\"El código no puede sobrepasar los 1";
Debug.ShouldStop(134217728);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El código no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registrodocente.processBA);
 };
 BA.debugLineNum = 94;BA.debugLine="End Sub";
Debug.ShouldStop(536870912);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtcondocente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcondocente_TextChanged (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,78);
if (RapidSub.canDelegate("txtcondocente_textchanged")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","txtcondocente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 78;BA.debugLine="Sub txtcondocente_TextChanged (Old As String, New";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 20))) { 
 BA.debugLineNum = 80;BA.debugLine="MsgboxAsync(\"La contraseña no puede sobrepasar l";
Debug.ShouldStop(32768);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registrodocente.processBA);
 };
 BA.debugLineNum = 82;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtconfirmaciondocente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconfirmaciondocente_TextChanged (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,84);
if (RapidSub.canDelegate("txtconfirmaciondocente_textchanged")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","txtconfirmaciondocente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 84;BA.debugLine="Sub txtconfirmaciondocente_TextChanged (Old As Str";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 20))) { 
 BA.debugLineNum = 86;BA.debugLine="MsgboxAsync(\"La confirmación de la contraseña no";
Debug.ShouldStop(2097152);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La confirmación de la contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registrodocente.processBA);
 };
 BA.debugLineNum = 88;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtcorreodocente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcorreodocente_TextChanged (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,72);
if (RapidSub.canDelegate("txtcorreodocente_textchanged")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","txtcorreodocente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 72;BA.debugLine="Sub txtcorreodocente_TextChanged (Old As String, N";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="If New.Length >= 50 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 50))) { 
 BA.debugLineNum = 74;BA.debugLine="MsgboxAsync(\"El correo no puede sobrepasar los 5";
Debug.ShouldStop(512);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El correo no puede sobrepasar los 50 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registrodocente.processBA);
 };
 BA.debugLineNum = 76;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtnombredocente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtnombredocente_TextChanged (registrodocente) ","registrodocente",9,registrodocente.mostCurrent.activityBA,registrodocente.mostCurrent,60);
if (RapidSub.canDelegate("txtnombredocente_textchanged")) { return b4a.example.registrodocente.remoteMe.runUserSub(false, "registrodocente","txtnombredocente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 60;BA.debugLine="Sub txtnombredocente_TextChanged (Old As String, N";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="If New.Length >= 40 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 40))) { 
 BA.debugLineNum = 62;BA.debugLine="MsgboxAsync(\"El nombre no puede sobrepasar los 4";
Debug.ShouldStop(536870912);
registrodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El nombre no puede sobrepasar los 40 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registrodocente.processBA);
 };
 BA.debugLineNum = 64;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
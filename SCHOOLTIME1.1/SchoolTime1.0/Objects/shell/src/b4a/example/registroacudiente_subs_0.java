package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registroacudiente_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,32);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 32;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 34;BA.debugLine="Activity.LoadLayout(\"registroAcudiente\")";
Debug.ShouldStop(2);
registroacudiente.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("registroAcudiente")),registroacudiente.mostCurrent.activityBA);
 BA.debugLineNum = 35;BA.debugLine="ScrollView1.Panel.LoadLayout(\"contenidoacudiente\"";
Debug.ShouldStop(4);
registroacudiente.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("contenidoacudiente")),registroacudiente.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="ScrollView1.Panel.Height = 80%y";
Debug.ShouldStop(8);
registroacudiente.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",registroacudiente.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 80)),registroacudiente.mostCurrent.activityBA));
 BA.debugLineNum = 37;BA.debugLine="Panel2.Visible = False";
Debug.ShouldStop(16);
registroacudiente.mostCurrent._panel2.runMethod(true,"setVisible",registroacudiente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 38;BA.debugLine="fondo.Visible= False";
Debug.ShouldStop(32);
registroacudiente.mostCurrent._fondo.runMethod(true,"setVisible",registroacudiente.mostCurrent.__c.getField(true,"False"));
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,45);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 45;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4096);
 BA.debugLineNum = 47;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Resume (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,41);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","activity_resume");}
 BA.debugLineNum = 41;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(256);
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
public static RemoteObject  _btnregistroacudiente_click() throws Exception{
try {
		Debug.PushSubsStack("btnregistroAcudiente_Click (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,101);
if (RapidSub.canDelegate("btnregistroacudiente_click")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","btnregistroacudiente_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 101;BA.debugLine="Sub btnregistroAcudiente_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 102;BA.debugLine="If txtnombreAcudiente.Text<>\"\" And txtcedulaAcudi";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("!",registroacudiente.mostCurrent._txtnombreacudiente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroacudiente.mostCurrent._txtcedulaacudiente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroacudiente.mostCurrent._txtcodigoacuente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroacudiente.mostCurrent._txtcorreoacudiente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroacudiente.mostCurrent._txtcontrasenaacudiente.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroacudiente.mostCurrent._txtconfirmaacudiente.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 103;BA.debugLine="If txtcontrasenaAcudiente.Text = txtconfirmaAcud";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",registroacudiente.mostCurrent._txtcontrasenaacudiente.runMethod(true,"getText"),registroacudiente.mostCurrent._txtconfirmaacudiente.runMethod(true,"getText"))) { 
 BA.debugLineNum = 104;BA.debugLine="If txtcorreoAcudiente.Text.Contains(\"@\") Then";
Debug.ShouldStop(128);
if (registroacudiente.mostCurrent._txtcorreoacudiente.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("@"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 105;BA.debugLine="If txtcorreoAcudiente.Text.Contains(\".\") Then";
Debug.ShouldStop(256);
if (registroacudiente.mostCurrent._txtcorreoacudiente.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("."))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 106;BA.debugLine="If txtcorreoAcudiente.Text.Contains(\" \") Then";
Debug.ShouldStop(512);
if (registroacudiente.mostCurrent._txtcorreoacudiente.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable(" "))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 107;BA.debugLine="ToastMessageShow(\"El correo no debe contener";
Debug.ShouldStop(1024);
registroacudiente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("El correo no debe contener espacios")),(Object)(registroacudiente.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 108;BA.debugLine="txtcorreoAcudiente.Text=\"\"";
Debug.ShouldStop(2048);
registroacudiente.mostCurrent._txtcorreoacudiente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 }else {
 BA.debugLineNum = 110;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1";
Debug.ShouldStop(8192);
_apiaddress = BA.ObjectToString("http://192.168.1.5/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 111;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(16384);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 112;BA.debugLine="job.Initialize(\"\", Me)";
Debug.ShouldStop(32768);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,registroacudiente.processBA,(Object)(BA.ObjectToString("")),(Object)(registroacudiente.getObject()));
 BA.debugLineNum = 113;BA.debugLine="job.PostString(ApiAddress,\"INSERT INTO tbl_a";
Debug.ShouldStop(65536);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO tbl_acudiente(id_acudiente,nombre_acu,apellido_acu,correo_acu,contrasena_acu,codigo_g) VALUES ('"),registroacudiente.mostCurrent._txtcedulaacudiente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroacudiente.mostCurrent._txtnombreacudiente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroacudiente.mostCurrent._txtapellidoacudiente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroacudiente.mostCurrent._txtcorreoacudiente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroacudiente.mostCurrent._txtcontrasenaacudiente.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroacudiente.mostCurrent._txtcodigoacuente.runMethod(true,"getText"),RemoteObject.createImmutable("')"))));
 };
 }else {
 BA.debugLineNum = 116;BA.debugLine="ToastMessageShow(\"Correo inválido: .\", False)";
Debug.ShouldStop(524288);
registroacudiente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo inválido: .")),(Object)(registroacudiente.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 117;BA.debugLine="txtcorreoAcudiente.Text=\"\"";
Debug.ShouldStop(1048576);
registroacudiente.mostCurrent._txtcorreoacudiente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 }else {
 BA.debugLineNum = 120;BA.debugLine="ToastMessageShow(\"Correo inválido: @\", False)";
Debug.ShouldStop(8388608);
registroacudiente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo inválido: @")),(Object)(registroacudiente.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 121;BA.debugLine="txtcorreoAcudiente.Text=\"\"";
Debug.ShouldStop(16777216);
registroacudiente.mostCurrent._txtcorreoacudiente.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 }else {
 BA.debugLineNum = 124;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
Debug.ShouldStop(134217728);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Las contraseñas deben coincidir")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroacudiente.processBA);
 };
 }else {
 BA.debugLineNum = 127;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
Debug.ShouldStop(1073741824);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son requeridos para el registro")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroacudiente.processBA);
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
		Debug.PushSubsStack("cerrarCodigo_Click (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,159);
if (RapidSub.canDelegate("cerrarcodigo_click")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","cerrarcodigo_click");}
 BA.debugLineNum = 159;BA.debugLine="Sub cerrarCodigo_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="If doc = 1 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",registroacudiente._doc,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 161;BA.debugLine="Panel2.Visible= False";
Debug.ShouldStop(1);
registroacudiente.mostCurrent._panel2.runMethod(true,"setVisible",registroacudiente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 162;BA.debugLine="fondo.Visible=False";
Debug.ShouldStop(2);
registroacudiente.mostCurrent._fondo.runMethod(true,"setVisible",registroacudiente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 163;BA.debugLine="btnregistroAcudiente.Visible= True";
Debug.ShouldStop(4);
registroacudiente.mostCurrent._btnregistroacudiente.runMethod(true,"setVisible",registroacudiente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 164;BA.debugLine="doc = 0";
Debug.ShouldStop(8);
registroacudiente._doc = BA.numberCast(int.class, 0);
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
 //BA.debugLineNum = 13;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 16;BA.debugLine="Private ScrollView1 As ScrollView";
registroacudiente.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private retroceder As Label";
registroacudiente.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private btnregistroAcudiente As Button";
registroacudiente.mostCurrent._btnregistroacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txtnombreAcudiente As EditText";
registroacudiente.mostCurrent._txtnombreacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private txtcedulaAcudiente As EditText";
registroacudiente.mostCurrent._txtcedulaacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private txtcorreoAcudiente As EditText";
registroacudiente.mostCurrent._txtcorreoacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private txtcodigoAcuente As EditText";
registroacudiente.mostCurrent._txtcodigoacuente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private txtcontrasenaAcudiente As EditText";
registroacudiente.mostCurrent._txtcontrasenaacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private txtconfirmaAcudiente As EditText";
registroacudiente.mostCurrent._txtconfirmaacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private opcioncodigo As Label";
registroacudiente.mostCurrent._opcioncodigo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private cerrarCodigo As Label";
registroacudiente.mostCurrent._cerrarcodigo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private txtapellidoAcudiente As EditText";
registroacudiente.mostCurrent._txtapellidoacudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private fondo As Panel";
registroacudiente.mostCurrent._fondo = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private Panel2 As Panel";
registroacudiente.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _hecho_tick() throws Exception{
try {
		Debug.PushSubsStack("hecho_Tick (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,144);
if (RapidSub.canDelegate("hecho_tick")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","hecho_tick");}
 BA.debugLineNum = 144;BA.debugLine="Sub hecho_Tick";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="StartActivity(ingreso)";
Debug.ShouldStop(65536);
registroacudiente.mostCurrent.__c.runVoidMethod ("StartActivity",registroacudiente.processBA,(Object)((registroacudiente.mostCurrent._ingreso.getObject())));
 BA.debugLineNum = 146;BA.debugLine="Activity.Finish";
Debug.ShouldStop(131072);
registroacudiente.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 147;BA.debugLine="hecho.Enabled= False";
Debug.ShouldStop(262144);
registroacudiente._hecho.runMethod(true,"setEnabled",registroacudiente.mostCurrent.__c.getField(true,"False"));
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
		Debug.PushSubsStack("JobDone (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,131);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 131;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(8);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 133;BA.debugLine="Log(\"OK, operacion con éxito\")";
Debug.ShouldStop(16);
registroacudiente.mostCurrent.__c.runVoidMethod ("LogImpl","28257538",RemoteObject.createImmutable("OK, operacion con éxito"),0);
 BA.debugLineNum = 134;BA.debugLine="MsgboxAsync(\"Su registro ha sido exitoso\",\"AVISO";
Debug.ShouldStop(32);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Su registro ha sido exitoso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),registroacudiente.processBA);
 BA.debugLineNum = 135;BA.debugLine="hecho.Initialize(\"hecho\", 2000)";
Debug.ShouldStop(64);
registroacudiente._hecho.runVoidMethod ("Initialize",registroacudiente.processBA,(Object)(BA.ObjectToString("hecho")),(Object)(BA.numberCast(long.class, 2000)));
 BA.debugLineNum = 136;BA.debugLine="hecho.Enabled= True";
Debug.ShouldStop(128);
registroacudiente._hecho.runMethod(true,"setEnabled",registroacudiente.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 138;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(512);
registroacudiente.mostCurrent.__c.runVoidMethod ("LogImpl","28257543",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 139;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(1024);
registroacudiente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(registroacudiente.mostCurrent.__c.getField(true,"True")));
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
		Debug.PushSubsStack("opcioncodigo_Click (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,150);
if (RapidSub.canDelegate("opcioncodigo_click")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","opcioncodigo_click");}
 BA.debugLineNum = 150;BA.debugLine="Sub opcioncodigo_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 151;BA.debugLine="If doc = 0 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",registroacudiente._doc,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 152;BA.debugLine="Panel2.Visible= True";
Debug.ShouldStop(8388608);
registroacudiente.mostCurrent._panel2.runMethod(true,"setVisible",registroacudiente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 153;BA.debugLine="fondo.Visible=True";
Debug.ShouldStop(16777216);
registroacudiente.mostCurrent._fondo.runMethod(true,"setVisible",registroacudiente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 154;BA.debugLine="btnregistroAcudiente.Visible= False";
Debug.ShouldStop(33554432);
registroacudiente.mostCurrent._btnregistroacudiente.runMethod(true,"setVisible",registroacudiente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 155;BA.debugLine="doc = 1";
Debug.ShouldStop(67108864);
registroacudiente._doc = BA.numberCast(int.class, 1);
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
public static RemoteObject  _opcioninicioacudiente_click() throws Exception{
try {
		Debug.PushSubsStack("opcioninicioAcudiente_Click (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,49);
if (RapidSub.canDelegate("opcioninicioacudiente_click")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","opcioninicioacudiente_click");}
 BA.debugLineNum = 49;BA.debugLine="Sub opcioninicioAcudiente_Click";
Debug.ShouldStop(65536);
 BA.debugLineNum = 50;BA.debugLine="StartActivity(inicioAcudiente)";
Debug.ShouldStop(131072);
registroacudiente.mostCurrent.__c.runVoidMethod ("StartActivity",registroacudiente.processBA,(Object)((registroacudiente.mostCurrent._inicioacudiente.getObject())));
 BA.debugLineNum = 51;BA.debugLine="Activity.Finish";
Debug.ShouldStop(262144);
registroacudiente.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 52;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim doc As Int = 0";
registroacudiente._doc = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 10;BA.debugLine="Dim hecho As Timer";
registroacudiente._hecho = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _retroceder_click() throws Exception{
try {
		Debug.PushSubsStack("retroceder_Click (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,54);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","retroceder_click");}
 BA.debugLineNum = 54;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 55;BA.debugLine="StartActivity(inicioAcudiente)";
Debug.ShouldStop(4194304);
registroacudiente.mostCurrent.__c.runVoidMethod ("StartActivity",registroacudiente.processBA,(Object)((registroacudiente.mostCurrent._inicioacudiente.getObject())));
 BA.debugLineNum = 56;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8388608);
registroacudiente.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _txtapellidoacudiente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtapellidoAcudiente_TextChanged (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,95);
if (RapidSub.canDelegate("txtapellidoacudiente_textchanged")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","txtapellidoacudiente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 95;BA.debugLine="Sub txtapellidoAcudiente_TextChanged (Old As Strin";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 97;BA.debugLine="MsgboxAsync(\"El apellido no puede sobrepasar los";
Debug.ShouldStop(1);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El apellido no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroacudiente.processBA);
 };
 BA.debugLineNum = 99;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtcedulaacudiente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcedulaAcudiente_TextChanged (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,65);
if (RapidSub.canDelegate("txtcedulaacudiente_textchanged")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","txtcedulaacudiente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 65;BA.debugLine="Sub txtcedulaAcudiente_TextChanged (Old As String,";
Debug.ShouldStop(1);
 BA.debugLineNum = 66;BA.debugLine="If New.Length >= 10 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 10))) { 
 BA.debugLineNum = 67;BA.debugLine="MsgboxAsync(\"La cédula no puede sobrepasar los 1";
Debug.ShouldStop(4);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La cédula no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroacudiente.processBA);
 };
 BA.debugLineNum = 69;BA.debugLine="End Sub";
Debug.ShouldStop(16);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtcodigoacuente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcodigoAcuente_TextChanged (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,77);
if (RapidSub.canDelegate("txtcodigoacuente_textchanged")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","txtcodigoacuente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 77;BA.debugLine="Sub txtcodigoAcuente_TextChanged (Old As String, N";
Debug.ShouldStop(4096);
 BA.debugLineNum = 78;BA.debugLine="If New.Length >= 10 Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 10))) { 
 BA.debugLineNum = 79;BA.debugLine="MsgboxAsync(\"El código de grupo no puede sobrepa";
Debug.ShouldStop(16384);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El código de grupo no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroacudiente.processBA);
 };
 BA.debugLineNum = 81;BA.debugLine="End Sub";
Debug.ShouldStop(65536);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtconfirmaacudiente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconfirmaAcudiente_TextChanged (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,89);
if (RapidSub.canDelegate("txtconfirmaacudiente_textchanged")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","txtconfirmaacudiente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 89;BA.debugLine="Sub txtconfirmaAcudiente_TextChanged (Old As Strin";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 90;BA.debugLine="If New.Length >= 10 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 10))) { 
 BA.debugLineNum = 91;BA.debugLine="MsgboxAsync(\"La confirmación de la contraseña no";
Debug.ShouldStop(67108864);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La confirmación de la contraseña no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroacudiente.processBA);
 };
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
public static RemoteObject  _txtcontrasenaacudiente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcontrasenaAcudiente_TextChanged (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,83);
if (RapidSub.canDelegate("txtcontrasenaacudiente_textchanged")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","txtcontrasenaacudiente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 83;BA.debugLine="Sub txtcontrasenaAcudiente_TextChanged (Old As Str";
Debug.ShouldStop(262144);
 BA.debugLineNum = 84;BA.debugLine="If New.Length >= 10 Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 10))) { 
 BA.debugLineNum = 85;BA.debugLine="MsgboxAsync(\"La contraseña no puede sobrepasar l";
Debug.ShouldStop(1048576);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La contraseña no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroacudiente.processBA);
 };
 BA.debugLineNum = 87;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("txtcorreoAcudiente_TextChanged (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,71);
if (RapidSub.canDelegate("txtcorreoacudiente_textchanged")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","txtcorreoacudiente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 71;BA.debugLine="Sub txtcorreoAcudiente_TextChanged (Old As String,";
Debug.ShouldStop(64);
 BA.debugLineNum = 72;BA.debugLine="If New.Length >= 50 Then";
Debug.ShouldStop(128);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 50))) { 
 BA.debugLineNum = 73;BA.debugLine="MsgboxAsync(\"El correo no puede sobrepasar los 5";
Debug.ShouldStop(256);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El correo no puede sobrepasar los 50 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroacudiente.processBA);
 };
 BA.debugLineNum = 75;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtnombreacudiente_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtnombreAcudiente_TextChanged (registroacudiente) ","registroacudiente",9,registroacudiente.mostCurrent.activityBA,registroacudiente.mostCurrent,59);
if (RapidSub.canDelegate("txtnombreacudiente_textchanged")) { return b4a.example.registroacudiente.remoteMe.runUserSub(false, "registroacudiente","txtnombreacudiente_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 59;BA.debugLine="Sub txtnombreAcudiente_TextChanged (Old As String,";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 60;BA.debugLine="If New.Length >= 40 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 40))) { 
 BA.debugLineNum = 61;BA.debugLine="MsgboxAsync(\"El nombre no puede sobrepasar los 4";
Debug.ShouldStop(268435456);
registroacudiente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El nombre no puede sobrepasar los 40 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroacudiente.processBA);
 };
 BA.debugLineNum = 63;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
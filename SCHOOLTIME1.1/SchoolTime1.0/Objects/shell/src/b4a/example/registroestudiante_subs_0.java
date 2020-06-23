package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class registroestudiante_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,33);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 33;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 35;BA.debugLine="Activity.LoadLayout(\"registroEstudiante\")";
Debug.ShouldStop(4);
registroestudiante.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("registroEstudiante")),registroestudiante.mostCurrent.activityBA);
 BA.debugLineNum = 36;BA.debugLine="ScrollView1.Panel.LoadLayout(\"contenidoEstudiante";
Debug.ShouldStop(8);
registroestudiante.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("contenidoEstudiante")),registroestudiante.mostCurrent.activityBA);
 BA.debugLineNum = 37;BA.debugLine="ScrollView1.Panel.Height = 80%y";
Debug.ShouldStop(16);
registroestudiante.mostCurrent._scrollview1.runMethod(false,"getPanel").runMethod(true,"setHeight",registroestudiante.mostCurrent.__c.runMethod(true,"PerYToCurrent",(Object)(BA.numberCast(float.class, 80)),registroestudiante.mostCurrent.activityBA));
 BA.debugLineNum = 38;BA.debugLine="Panel2.Visible = False";
Debug.ShouldStop(32);
registroestudiante.mostCurrent._panel2.runMethod(true,"setVisible",registroestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 39;BA.debugLine="fondo.Visible= False";
Debug.ShouldStop(64);
registroestudiante.mostCurrent._fondo.runMethod(true,"setVisible",registroestudiante.mostCurrent.__c.getField(true,"False"));
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
		Debug.PushSubsStack("Activity_Pause (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,46);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,42);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","activity_resume");}
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
public static RemoteObject  _btnregistroestudiante_click() throws Exception{
try {
		Debug.PushSubsStack("btnregistroEstudiante_Click (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,108);
if (RapidSub.canDelegate("btnregistroestudiante_click")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","btnregistroestudiante_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 108;BA.debugLine="Sub btnregistroEstudiante_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="If txtnombreEstudiante.Text<>\"\" And txtidentifica";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("!",registroestudiante.mostCurrent._txtnombreestudiante.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroestudiante.mostCurrent._txtidentificacion.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroestudiante.mostCurrent._txtmatricula.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroestudiante.mostCurrent._txtcodigogrupo.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroestudiante.mostCurrent._txtcontrasenaestudiante.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroestudiante.mostCurrent._txtconfirmaestudiante.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroestudiante.mostCurrent._txtcorreoestudiante.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",registroestudiante.mostCurrent._txtapellidoestudiante.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 110;BA.debugLine="If txtcontrasenaEstudiante.Text = txtconfirmaEst";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",registroestudiante.mostCurrent._txtcontrasenaestudiante.runMethod(true,"getText"),registroestudiante.mostCurrent._txtconfirmaestudiante.runMethod(true,"getText"))) { 
 BA.debugLineNum = 111;BA.debugLine="If txtcorreoEstudiante.Text.Contains(\"@\") Then";
Debug.ShouldStop(16384);
if (registroestudiante.mostCurrent._txtcorreoestudiante.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("@"))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 112;BA.debugLine="If txtcorreoEstudiante.Text.Contains(\".\") Then";
Debug.ShouldStop(32768);
if (registroestudiante.mostCurrent._txtcorreoestudiante.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable("."))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 113;BA.debugLine="If txtcorreoEstudiante.Text.Contains(\" \")Then";
Debug.ShouldStop(65536);
if (registroestudiante.mostCurrent._txtcorreoestudiante.runMethod(true,"getText").runMethod(true,"contains",(Object)(RemoteObject.createImmutable(" "))).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 114;BA.debugLine="ToastMessageShow(\"El correo no debe contener";
Debug.ShouldStop(131072);
registroestudiante.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("El correo no debe contener espacios")),(Object)(registroestudiante.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 115;BA.debugLine="txtcorreoEstudiante.Text=\"\"";
Debug.ShouldStop(262144);
registroestudiante.mostCurrent._txtcorreoestudiante.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 }else {
 BA.debugLineNum = 117;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1";
Debug.ShouldStop(1048576);
_apiaddress = BA.ObjectToString("http://192.168.1.5/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 118;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(2097152);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 119;BA.debugLine="job.Initialize(\"\", Me)";
Debug.ShouldStop(4194304);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,registroestudiante.processBA,(Object)(BA.ObjectToString("")),(Object)(registroestudiante.getObject()));
 BA.debugLineNum = 120;BA.debugLine="job.PostString(ApiAddress,\"INSERT INTO tbl_e";
Debug.ShouldStop(8388608);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("INSERT INTO tbl_estudiante(id_estudiante,nombre_e,apellido_e,matricula_e,correo_e, contrasena_e,codigo_g) VALUES ('"),registroestudiante.mostCurrent._txtidentificacion.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroestudiante.mostCurrent._txtnombreestudiante.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroestudiante.mostCurrent._txtapellidoestudiante.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroestudiante.mostCurrent._txtmatricula.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroestudiante.mostCurrent._txtcorreoestudiante.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroestudiante.mostCurrent._txtcontrasenaestudiante.runMethod(true,"getText"),RemoteObject.createImmutable("','"),registroestudiante.mostCurrent._txtcodigogrupo.runMethod(true,"getText"),RemoteObject.createImmutable("')"))));
 };
 }else {
 BA.debugLineNum = 123;BA.debugLine="ToastMessageShow(\"Correo inválido: @\", False)";
Debug.ShouldStop(67108864);
registroestudiante.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo inválido: @")),(Object)(registroestudiante.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 124;BA.debugLine="txtcorreoEstudiante.Text=\"\"";
Debug.ShouldStop(134217728);
registroestudiante.mostCurrent._txtcorreoestudiante.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 }else {
 BA.debugLineNum = 127;BA.debugLine="ToastMessageShow(\"Correo inválido: @\", False)";
Debug.ShouldStop(1073741824);
registroestudiante.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence("Correo inválido: @")),(Object)(registroestudiante.mostCurrent.__c.getField(true,"False")));
 BA.debugLineNum = 128;BA.debugLine="txtcorreoEstudiante.Text=\"\"";
Debug.ShouldStop(-2147483648);
registroestudiante.mostCurrent._txtcorreoestudiante.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 };
 }else {
 BA.debugLineNum = 131;BA.debugLine="MsgboxAsync(\"Las contraseñas no coinciden\",\"ERR";
Debug.ShouldStop(4);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Las contraseñas no coinciden")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ERROR DE CONFIRMACIÓN"))),registroestudiante.processBA);
 };
 }else {
 BA.debugLineNum = 134;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
Debug.ShouldStop(32);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son requeridos para el registro")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroestudiante.processBA);
 };
 BA.debugLineNum = 136;BA.debugLine="End Sub";
Debug.ShouldStop(128);
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
		Debug.PushSubsStack("cerrarCodigo_Click (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,166);
if (RapidSub.canDelegate("cerrarcodigo_click")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","cerrarcodigo_click");}
 BA.debugLineNum = 166;BA.debugLine="Sub cerrarCodigo_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 167;BA.debugLine="If est = 1 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",registroestudiante._est,BA.numberCast(int.class, 1))) { 
 BA.debugLineNum = 168;BA.debugLine="Panel2.Visible= False";
Debug.ShouldStop(128);
registroestudiante.mostCurrent._panel2.runMethod(true,"setVisible",registroestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 169;BA.debugLine="fondo.Visible= False";
Debug.ShouldStop(256);
registroestudiante.mostCurrent._fondo.runMethod(true,"setVisible",registroestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 170;BA.debugLine="btnregistroEstudiante.Visible= True";
Debug.ShouldStop(512);
registroestudiante.mostCurrent._btnregistroestudiante.runMethod(true,"setVisible",registroestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 171;BA.debugLine="est = 0";
Debug.ShouldStop(1024);
registroestudiante._est = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 173;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
registroestudiante.mostCurrent._scrollview1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ScrollViewWrapper");
 //BA.debugLineNum = 17;BA.debugLine="Private retroceder As Label";
registroestudiante.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 18;BA.debugLine="Private txtnombreEstudiante As EditText";
registroestudiante.mostCurrent._txtnombreestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private txtidentificacion As EditText";
registroestudiante.mostCurrent._txtidentificacion = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private txtmatricula As EditText";
registroestudiante.mostCurrent._txtmatricula = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private txtcodigogrupo As EditText";
registroestudiante.mostCurrent._txtcodigogrupo = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private txtcontrasenaEstudiante As EditText";
registroestudiante.mostCurrent._txtcontrasenaestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private txtconfirmaEstudiante As EditText";
registroestudiante.mostCurrent._txtconfirmaestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private btnregistroEstudiante As Button";
registroestudiante.mostCurrent._btnregistroestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private Panel2 As Panel";
registroestudiante.mostCurrent._panel2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private fondo As Panel";
registroestudiante.mostCurrent._fondo = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private cerrarCodigo As Label";
registroestudiante.mostCurrent._cerrarcodigo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private opcioncodigo As Label";
registroestudiante.mostCurrent._opcioncodigo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private txtapellidoEstudiante As EditText";
registroestudiante.mostCurrent._txtapellidoestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private txtcorreoEstudiante As EditText";
registroestudiante.mostCurrent._txtcorreoestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 31;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _hecho_tick() throws Exception{
try {
		Debug.PushSubsStack("hecho_Tick (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,151);
if (RapidSub.canDelegate("hecho_tick")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","hecho_tick");}
 BA.debugLineNum = 151;BA.debugLine="Sub hecho_Tick";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="StartActivity(ingresoEstudiante)";
Debug.ShouldStop(8388608);
registroestudiante.mostCurrent.__c.runVoidMethod ("StartActivity",registroestudiante.processBA,(Object)((registroestudiante.mostCurrent._ingresoestudiante.getObject())));
 BA.debugLineNum = 153;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
registroestudiante.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 154;BA.debugLine="hecho.Enabled= False";
Debug.ShouldStop(33554432);
registroestudiante._hecho.runMethod(true,"setEnabled",registroestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 155;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
		Debug.PushSubsStack("JobDone (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,138);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 138;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(512);
 BA.debugLineNum = 139;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(1024);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 140;BA.debugLine="Log(\"OK, operacion con éxito\")";
Debug.ShouldStop(2048);
registroestudiante.mostCurrent.__c.runVoidMethod ("LogImpl","013303810",RemoteObject.createImmutable("OK, operacion con éxito"),0);
 BA.debugLineNum = 141;BA.debugLine="MsgboxAsync(\"Su registro ha sido exitoso\",\"AVISO";
Debug.ShouldStop(4096);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Su registro ha sido exitoso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),registroestudiante.processBA);
 BA.debugLineNum = 142;BA.debugLine="hecho.Initialize(\"hecho\", 2000)";
Debug.ShouldStop(8192);
registroestudiante._hecho.runVoidMethod ("Initialize",registroestudiante.processBA,(Object)(BA.ObjectToString("hecho")),(Object)(BA.numberCast(long.class, 2000)));
 BA.debugLineNum = 143;BA.debugLine="hecho.Enabled= True";
Debug.ShouldStop(16384);
registroestudiante._hecho.runMethod(true,"setEnabled",registroestudiante.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 145;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(65536);
registroestudiante.mostCurrent.__c.runVoidMethod ("LogImpl","013303815",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 146;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(131072);
registroestudiante.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(registroestudiante.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 148;BA.debugLine="Job.Release";
Debug.ShouldStop(524288);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 149;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("opcioncodigo_Click (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,157);
if (RapidSub.canDelegate("opcioncodigo_click")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","opcioncodigo_click");}
 BA.debugLineNum = 157;BA.debugLine="Sub opcioncodigo_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="If est = 0 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",registroestudiante._est,BA.numberCast(int.class, 0))) { 
 BA.debugLineNum = 159;BA.debugLine="Panel2.Visible= True";
Debug.ShouldStop(1073741824);
registroestudiante.mostCurrent._panel2.runMethod(true,"setVisible",registroestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 160;BA.debugLine="fondo.Visible=True";
Debug.ShouldStop(-2147483648);
registroestudiante.mostCurrent._fondo.runMethod(true,"setVisible",registroestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 161;BA.debugLine="btnregistroEstudiante.Visible= False";
Debug.ShouldStop(1);
registroestudiante.mostCurrent._btnregistroestudiante.runMethod(true,"setVisible",registroestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 162;BA.debugLine="est = 1";
Debug.ShouldStop(2);
registroestudiante._est = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 164;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _opcioninicioestudiante_click() throws Exception{
try {
		Debug.PushSubsStack("opcioninicioEstudiante_Click (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,50);
if (RapidSub.canDelegate("opcioninicioestudiante_click")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","opcioninicioestudiante_click");}
 BA.debugLineNum = 50;BA.debugLine="Sub opcioninicioEstudiante_Click";
Debug.ShouldStop(131072);
 BA.debugLineNum = 51;BA.debugLine="StartActivity(inicioEstudiante)";
Debug.ShouldStop(262144);
registroestudiante.mostCurrent.__c.runVoidMethod ("StartActivity",registroestudiante.processBA,(Object)((registroestudiante.mostCurrent._inicioestudiante.getObject())));
 BA.debugLineNum = 52;BA.debugLine="Activity.Finish";
Debug.ShouldStop(524288);
registroestudiante.mostCurrent._activity.runVoidMethod ("Finish");
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
 //BA.debugLineNum = 9;BA.debugLine="Dim est As Int = 0";
registroestudiante._est = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 10;BA.debugLine="Dim hecho As Timer";
registroestudiante._hecho = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 11;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _retroceder_click() throws Exception{
try {
		Debug.PushSubsStack("retroceder_Click (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,55);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","retroceder_click");}
 BA.debugLineNum = 55;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 56;BA.debugLine="StartActivity(inicioEstudiante)";
Debug.ShouldStop(8388608);
registroestudiante.mostCurrent.__c.runVoidMethod ("StartActivity",registroestudiante.processBA,(Object)((registroestudiante.mostCurrent._inicioestudiante.getObject())));
 BA.debugLineNum = 57;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16777216);
registroestudiante.mostCurrent._activity.runVoidMethod ("Finish");
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
public static RemoteObject  _txtapellidoestudiante_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtapellidoEstudiante_TextChanged (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,96);
if (RapidSub.canDelegate("txtapellidoestudiante_textchanged")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","txtapellidoestudiante_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 96;BA.debugLine="Sub txtapellidoEstudiante_TextChanged (Old As Stri";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 97;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 20))) { 
 BA.debugLineNum = 98;BA.debugLine="MsgboxAsync(\"El apellido no puede sobrepasar los";
Debug.ShouldStop(2);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El apellido no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroestudiante.processBA);
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
public static RemoteObject  _txtcodigogrupo_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcodigogrupo_TextChanged (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,78);
if (RapidSub.canDelegate("txtcodigogrupo_textchanged")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","txtcodigogrupo_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 78;BA.debugLine="Sub txtcodigogrupo_TextChanged (Old As String, New";
Debug.ShouldStop(8192);
 BA.debugLineNum = 79;BA.debugLine="If New.Length >= 10 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 10))) { 
 BA.debugLineNum = 80;BA.debugLine="MsgboxAsync(\"El código del grupo no puede sobrep";
Debug.ShouldStop(32768);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El código del grupo no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroestudiante.processBA);
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
public static RemoteObject  _txtconfirmaestudiante_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconfirmaEstudiante_TextChanged (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,90);
if (RapidSub.canDelegate("txtconfirmaestudiante_textchanged")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","txtconfirmaestudiante_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 90;BA.debugLine="Sub txtconfirmaEstudiante_TextChanged (Old As Stri";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 91;BA.debugLine="If New.Length >= 10 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 10))) { 
 BA.debugLineNum = 92;BA.debugLine="MsgboxAsync(\"La confirmación de la contraseña no";
Debug.ShouldStop(134217728);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La confirmación de la contraseña no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroestudiante.processBA);
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
public static RemoteObject  _txtcontrasenaestudiante_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcontrasenaEstudiante_TextChanged (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,84);
if (RapidSub.canDelegate("txtcontrasenaestudiante_textchanged")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","txtcontrasenaestudiante_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 84;BA.debugLine="Sub txtcontrasenaEstudiante_TextChanged (Old As St";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="If New.Length >= 10 Then";
Debug.ShouldStop(1048576);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 10))) { 
 BA.debugLineNum = 86;BA.debugLine="MsgboxAsync(\"La contraseña no puede sobrepasar l";
Debug.ShouldStop(2097152);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La contraseña no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroestudiante.processBA);
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
public static RemoteObject  _txtcorreoestudiante_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtcorreoEstudiante_TextChanged (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,102);
if (RapidSub.canDelegate("txtcorreoestudiante_textchanged")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","txtcorreoestudiante_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 102;BA.debugLine="Sub txtcorreoEstudiante_TextChanged (Old As String";
Debug.ShouldStop(32);
 BA.debugLineNum = 103;BA.debugLine="If New.Length >= 50 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 50))) { 
 BA.debugLineNum = 104;BA.debugLine="MsgboxAsync(\"El correo no puede sobrepasar los 5";
Debug.ShouldStop(128);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El correo no puede sobrepasar los 50 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroestudiante.processBA);
 };
 BA.debugLineNum = 106;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtidentificacion_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtidentificacion_TextChanged (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,66);
if (RapidSub.canDelegate("txtidentificacion_textchanged")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","txtidentificacion_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 66;BA.debugLine="Sub txtidentificacion_TextChanged (Old As String,";
Debug.ShouldStop(2);
 BA.debugLineNum = 67;BA.debugLine="If New.Length >= 10 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 10))) { 
 BA.debugLineNum = 68;BA.debugLine="MsgboxAsync(\"La identificación no puede sobrepas";
Debug.ShouldStop(8);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La identificación no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroestudiante.processBA);
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
public static RemoteObject  _txtmatricula_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtmatricula_TextChanged (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,72);
if (RapidSub.canDelegate("txtmatricula_textchanged")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","txtmatricula_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 72;BA.debugLine="Sub txtmatricula_TextChanged (Old As String, New A";
Debug.ShouldStop(128);
 BA.debugLineNum = 73;BA.debugLine="If New.Length >= 10 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 10))) { 
 BA.debugLineNum = 74;BA.debugLine="MsgboxAsync(\"La matrícula no puede sobrepasar lo";
Debug.ShouldStop(512);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La matrícula no puede sobrepasar los 10 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroestudiante.processBA);
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
public static RemoteObject  _txtnombreestudiante_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtnombreEstudiante_TextChanged (registroestudiante) ","registroestudiante",10,registroestudiante.mostCurrent.activityBA,registroestudiante.mostCurrent,60);
if (RapidSub.canDelegate("txtnombreestudiante_textchanged")) { return b4a.example.registroestudiante.remoteMe.runUserSub(false, "registroestudiante","txtnombreestudiante_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 60;BA.debugLine="Sub txtnombreEstudiante_TextChanged (Old As String";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 61;BA.debugLine="If New.Length >= 40 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 40))) { 
 BA.debugLineNum = 62;BA.debugLine="MsgboxAsync(\"El nombre no puede sobrepasar los 4";
Debug.ShouldStop(536870912);
registroestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("El nombre no puede sobrepasar los 40 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),registroestudiante.processBA);
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
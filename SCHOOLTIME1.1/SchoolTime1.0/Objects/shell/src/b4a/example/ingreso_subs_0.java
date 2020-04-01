package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ingreso_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,94);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 94;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 96;BA.debugLine="Activity.LoadLayout(\"ingreso\")";
Debug.ShouldStop(-2147483648);
ingreso.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ingreso")),ingreso.mostCurrent.activityBA);
 BA.debugLineNum = 97;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"evento\")";
Debug.ShouldStop(1);
ingreso.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingreso.mostCurrent.activityBA,(Object)(BA.ObjectToString("EVENTOS")),(Object)(RemoteObject.createImmutable("evento")));
 BA.debugLineNum = 98;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfil\")";
Debug.ShouldStop(2);
ingreso.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingreso.mostCurrent.activityBA,(Object)(BA.ObjectToString("PERFIL")),(Object)(RemoteObject.createImmutable("perfil")));
 BA.debugLineNum = 99;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(4);
ingreso.mostCurrent._panel1.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 100;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(8);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 101;BA.debugLine="evento1A.Visible=False";
Debug.ShouldStop(16);
ingreso.mostCurrent._evento1a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 102;BA.debugLine="evento2A.Visible=False";
Debug.ShouldStop(32);
ingreso.mostCurrent._evento2a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 103;BA.debugLine="evento3A.Visible=False";
Debug.ShouldStop(64);
ingreso.mostCurrent._evento3a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 104;BA.debugLine="evento4A.Visible=False";
Debug.ShouldStop(128);
ingreso.mostCurrent._evento4a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 105;BA.debugLine="evento11A.Visible=False";
Debug.ShouldStop(256);
ingreso.mostCurrent._evento11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 106;BA.debugLine="evento22A.Visible=False";
Debug.ShouldStop(512);
ingreso.mostCurrent._evento22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 107;BA.debugLine="evento33A.Visible= False";
Debug.ShouldStop(1024);
ingreso.mostCurrent._evento33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 108;BA.debugLine="evento44A.Visible= False";
Debug.ShouldStop(2048);
ingreso.mostCurrent._evento44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 109;BA.debugLine="Anuncio.Visible=False";
Debug.ShouldStop(4096);
ingreso.mostCurrent._anuncio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 110;BA.debugLine="eventos = 0";
Debug.ShouldStop(8192);
ingreso._eventos = BA.numberCast(int.class, 0);
 BA.debugLineNum = 111;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
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
		Debug.PushSubsStack("Activity_Pause (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,117);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 117;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 119;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("Activity_Resume (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,113);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","activity_resume");}
 BA.debugLineNum = 113;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(65536);
 BA.debugLineNum = 115;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncambiaracudiente_click() throws Exception{
try {
		Debug.PushSubsStack("btncambiaracudiente_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,121);
if (RapidSub.canDelegate("btncambiaracudiente_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","btncambiaracudiente_click");}
 BA.debugLineNum = 121;BA.debugLine="Sub btncambiaracudiente_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 122;BA.debugLine="If estado = 0 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",ingreso._estado,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 123;BA.debugLine="Panel1.Visible = True";
Debug.ShouldStop(67108864);
ingreso.mostCurrent._panel1.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 124;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(134217728);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 125;BA.debugLine="estado = 1";
Debug.ShouldStop(268435456);
ingreso._estado = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 127;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncambio_click() throws Exception{
try {
		Debug.PushSubsStack("btncambio_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,165);
if (RapidSub.canDelegate("btncambio_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","btncambio_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 165;BA.debugLine="Sub btncambio_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 166;BA.debugLine="If txtconact.Text<>\"\" And txtconnuv.Text<>\"\" And";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("!",ingreso.mostCurrent._txtconact.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingreso.mostCurrent._txtconnuv.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingreso.mostCurrent._txtconfcon.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 167;BA.debugLine="If txtconnuv.Text = txtconfcon.Text Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",ingreso.mostCurrent._txtconnuv.runMethod(true,"getText"),ingreso.mostCurrent._txtconfcon.runMethod(true,"getText"))) { 
 BA.debugLineNum = 168;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/";
Debug.ShouldStop(128);
_apiaddress = BA.ObjectToString("http://192.168.1.5/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 169;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(256);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 170;BA.debugLine="job.Initialize(\"\", Me)";
Debug.ShouldStop(512);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingreso.processBA,(Object)(BA.ObjectToString("")),(Object)(ingreso.getObject()));
 BA.debugLineNum = 171;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tbl_acudiente";
Debug.ShouldStop(1024);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tbl_acudiente SET contrasena_acu='"),ingreso.mostCurrent._txtconnuv.runMethod(true,"getText"),RemoteObject.createImmutable("' WHERE contrasena_acu='"),ingreso.mostCurrent._txtconact.runMethod(true,"getText"),RemoteObject.createImmutable("'"))));
 }else {
 BA.debugLineNum = 173;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
Debug.ShouldStop(4096);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Las contraseñas deben coincidir")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingreso.processBA);
 };
 }else {
 BA.debugLineNum = 176;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
Debug.ShouldStop(32768);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingreso.processBA);
 };
 BA.debugLineNum = 178;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncerraracudiente_click() throws Exception{
try {
		Debug.PushSubsStack("btncerraracudiente_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,129);
if (RapidSub.canDelegate("btncerraracudiente_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","btncerraracudiente_click");}
 BA.debugLineNum = 129;BA.debugLine="Sub btncerraracudiente_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 130;BA.debugLine="StartActivity(perfiles)";
Debug.ShouldStop(2);
ingreso.mostCurrent.__c.runVoidMethod ("StartActivity",ingreso.processBA,(Object)((ingreso.mostCurrent._perfiles.getObject())));
 BA.debugLineNum = 131;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4);
ingreso.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 132;BA.debugLine="End Sub";
Debug.ShouldStop(8);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _cerrar_click() throws Exception{
try {
		Debug.PushSubsStack("cerrar_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,134);
if (RapidSub.canDelegate("cerrar_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","cerrar_click");}
 BA.debugLineNum = 134;BA.debugLine="Sub cerrar_Click";
Debug.ShouldStop(32);
 BA.debugLineNum = 135;BA.debugLine="If estado = 1 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",ingreso._estado,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 136;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(128);
ingreso.mostCurrent._panel1.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 137;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(256);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 138;BA.debugLine="estado = 0";
Debug.ShouldStop(512);
ingreso._estado = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 140;BA.debugLine="End Sub";
Debug.ShouldStop(2048);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _createnotificationchannel(RemoteObject _importancelevel) throws Exception{
try {
		Debug.PushSubsStack("CreateNotificationChannel (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,351);
if (RapidSub.canDelegate("createnotificationchannel")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","createnotificationchannel", _importancelevel);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _ctxt = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _channelid = RemoteObject.createImmutable("");
RemoteObject _channel = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _manager = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("ImportanceLevel", _importancelevel);
 BA.debugLineNum = 351;BA.debugLine="Sub CreateNotificationChannel(ImportanceLevel As I";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 352;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(-2147483648);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 353;BA.debugLine="If p.SdkVersion >= 26 Then";
Debug.ShouldStop(1);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 26))) { 
 BA.debugLineNum = 354;BA.debugLine="Dim ctxt As JavaObject";
Debug.ShouldStop(2);
_ctxt = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("ctxt", _ctxt);
 BA.debugLineNum = 355;BA.debugLine="ctxt.InitializeContext";
Debug.ShouldStop(4);
_ctxt.runVoidMethod ("InitializeContext",ingreso.processBA);
 BA.debugLineNum = 356;BA.debugLine="Dim channelId As String = \"channel_\"& Importance";
Debug.ShouldStop(8);
_channelid = RemoteObject.concat(RemoteObject.createImmutable("channel_"),_importancelevel);Debug.locals.put("channelId", _channelid);Debug.locals.put("channelId", _channelid);
 BA.debugLineNum = 357;BA.debugLine="Dim channel As JavaObject";
Debug.ShouldStop(16);
_channel = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("channel", _channel);
 BA.debugLineNum = 358;BA.debugLine="channel.InitializeNewInstance(\"android.app.Notif";
Debug.ShouldStop(32);
_channel.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("android.app.NotificationChannel")),(Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_channelid),(ingreso.mostCurrent.__c.getField(false,"Application").runMethod(true,"getLabelName")),(_importancelevel)})));
 BA.debugLineNum = 359;BA.debugLine="channel.RunMethod(\"setShowBadge\",Array(False))";
Debug.ShouldStop(64);
_channel.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setShowBadge")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(ingreso.mostCurrent.__c.getField(true,"False"))})));
 BA.debugLineNum = 361;BA.debugLine="Dim manager As JavaObject = ctxt.RunMethod(\"getS";
Debug.ShouldStop(256);
_manager = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_manager.setObject(_ctxt.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getSystemService")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("notification"))}))));Debug.locals.put("manager", _manager);
 BA.debugLineNum = 362;BA.debugLine="manager.RunMethod(\"createNotificationChannel\",Ar";
Debug.ShouldStop(512);
_manager.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("createNotificationChannel")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_channel.getObject())})));
 };
 BA.debugLineNum = 365;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _enviara_click() throws Exception{
try {
		Debug.PushSubsStack("EnviarA_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,313);
if (RapidSub.canDelegate("enviara_click")) { b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","enviara_click"); return;}
ResumableSub_EnviarA_Click rsub = new ResumableSub_EnviarA_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_EnviarA_Click extends BA.ResumableSub {
public ResumableSub_EnviarA_Click(b4a.example.ingreso parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.ingreso parent;
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _js = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _tabla = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _fila = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
int step19;
int limit19;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("EnviarA_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,313);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 314;BA.debugLine="If contraseñaA.Text <> \"\" Then";
Debug.ShouldStop(33554432);
if (true) break;

case 1:
//if
this.state = 26;
if (RemoteObject.solveBoolean("!",parent.mostCurrent._contraseñaa.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 3;
}else {
this.state = 25;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 315;BA.debugLine="Try";
Debug.ShouldStop(67108864);
if (true) break;

case 4:
//try
this.state = 23;
this.catchState = 22;
this.state = 6;
if (true) break;

case 6:
//C
this.state = 7;
this.catchState = 22;
 BA.debugLineNum = 316;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/";
Debug.ShouldStop(134217728);
_apiaddress = BA.ObjectToString("http://192.168.1.5/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 317;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(268435456);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 318;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(536870912);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingreso.processBA,(Object)(BA.ObjectToString("")),(Object)(ingreso.getObject()));
 BA.debugLineNum = 319;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
Debug.ShouldStop(1073741824);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {10},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("cedula"),BA.ObjectToString("pin"),parent.mostCurrent._contraseñaa.runMethod(true,"getText"),BA.ObjectToString("tabla"),BA.ObjectToString("tbl_acudiente"),BA.ObjectToString("codigo"),BA.ObjectToString("codigo_g"),BA.ObjectToString("cedula"),RemoteObject.createImmutable("id_acudiente")})));
 BA.debugLineNum = 320;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingreso.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingreso", "enviara_click"), (_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 321;BA.debugLine="If js.Success Then";
Debug.ShouldStop(1);
if (true) break;

case 7:
//if
this.state = 20;
if (_js.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 9;
}else {
this.state = 19;
}if (true) break;

case 9:
//C
this.state = 10;
 BA.debugLineNum = 322;BA.debugLine="Dim res As String";
Debug.ShouldStop(2);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 323;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
Debug.ShouldStop(4);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 324;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(8);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 325;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(16);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 326;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(32);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 327;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(64);
if (true) break;

case 10:
//if
this.state = 17;
if ((RemoteObject.solveBoolean(">",_res.runMethod(true,"length"),BA.numberCast(double.class, 0)))) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 328;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(128);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 329;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(256);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 330;BA.debugLine="Log(tabla)";
Debug.ShouldStop(512);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","23670033",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 331;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(1024);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 332;BA.debugLine="For i=0 To tabla.Size-1";
Debug.ShouldStop(2048);
if (true) break;

case 13:
//for
this.state = 16;
step19 = 1;
limit19 = RemoteObject.solve(new RemoteObject[] {_tabla.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
this.state = 28;
if (true) break;

case 28:
//C
this.state = 16;
if ((step19 > 0 && _i <= limit19) || (step19 < 0 && _i >= limit19)) this.state = 15;
if (true) break;

case 29:
//C
this.state = 28;
_i = ((int)(0 + _i + step19)) ;
Debug.locals.put("i", _i);
if (true) break;

case 15:
//C
this.state = 29;
 BA.debugLineNum = 333;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(4096);
_fila.setObject(_tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 334;BA.debugLine="codigo = fila.Get(\"codigo_g\")";
Debug.ShouldStop(8192);
parent._codigo = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("codigo_g")))));
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
Debug.locals.put("i", _i);
;
 if (true) break;

case 17:
//C
this.state = 20;
;
 if (true) break;

case 19:
//C
this.state = 20;
 BA.debugLineNum = 338;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(131072);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","23670041",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 if (true) break;

case 20:
//C
this.state = 23;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 22:
//C
this.state = 23;
this.catchState = 0;
 BA.debugLineNum = 341;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","23670044",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingreso.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
 BA.debugLineNum = 343;BA.debugLine="inicio.Visible =False";
Debug.ShouldStop(4194304);
parent.mostCurrent._inicio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 344;BA.debugLine="Datos.Visible = False";
Debug.ShouldStop(8388608);
parent.mostCurrent._datos.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 25:
//C
this.state = 26;
 BA.debugLineNum = 346;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Necesitas este campo para el ingreso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingreso.processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
 BA.debugLineNum = 348;BA.debugLine="remoreA";
Debug.ShouldStop(134217728);
_remorea();
 BA.debugLineNum = 349;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",ingreso.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _evento1a_click() throws Exception{
try {
		Debug.PushSubsStack("evento1A_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,226);
if (RapidSub.canDelegate("evento1a_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","evento1a_click");}
 BA.debugLineNum = 226;BA.debugLine="Sub evento1A_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 227;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",ingreso._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 228;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(8);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 229;BA.debugLine="evento11A.Visible = True";
Debug.ShouldStop(16);
ingreso.mostCurrent._evento11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 230;BA.debugLine="titulo11A.Text = titulo1A.Text";
Debug.ShouldStop(32);
ingreso.mostCurrent._titulo11a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._titulo1a.runMethod(true,"getText")));
 BA.debugLineNum = 231;BA.debugLine="fecha11A.Text = fecha1A.Text";
Debug.ShouldStop(64);
ingreso.mostCurrent._fecha11a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._fecha1a.runMethod(true,"getText")));
 BA.debugLineNum = 232;BA.debugLine="hora11A.Text = hora1A.Text";
Debug.ShouldStop(128);
ingreso.mostCurrent._hora11a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._hora1a.runMethod(true,"getText")));
 BA.debugLineNum = 233;BA.debugLine="desc11A.Text = desc1";
Debug.ShouldStop(256);
ingreso.mostCurrent._desc11a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso._desc1));
 BA.debugLineNum = 234;BA.debugLine="If tipo1 = \"Celebración\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",ingreso._tipo1,BA.ObjectToString("Celebración"))) { 
 BA.debugLineNum = 235;BA.debugLine="celebracion11A.Visible = True";
Debug.ShouldStop(1024);
ingreso.mostCurrent._celebracion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 236;BA.debugLine="cambio11A.Visible = False";
Debug.ShouldStop(2048);
ingreso.mostCurrent._cambio11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 237;BA.debugLine="reunion11A.Visible = False";
Debug.ShouldStop(4096);
ingreso.mostCurrent._reunion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 239;BA.debugLine="If tipo1 = \"Reunión\" Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",ingreso._tipo1,BA.ObjectToString("Reunión"))) { 
 BA.debugLineNum = 240;BA.debugLine="celebracion11A.Visible = False";
Debug.ShouldStop(32768);
ingreso.mostCurrent._celebracion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 241;BA.debugLine="cambio11A.Visible = False";
Debug.ShouldStop(65536);
ingreso.mostCurrent._cambio11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 242;BA.debugLine="reunion11A.Visible = True";
Debug.ShouldStop(131072);
ingreso.mostCurrent._reunion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 244;BA.debugLine="If tipo1 = \"Cambio\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",ingreso._tipo1,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 245;BA.debugLine="celebracion11A.Visible = False";
Debug.ShouldStop(1048576);
ingreso.mostCurrent._celebracion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 246;BA.debugLine="cambio11A.Visible = True";
Debug.ShouldStop(2097152);
ingreso.mostCurrent._cambio11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 247;BA.debugLine="reunion11A.Visible = False";
Debug.ShouldStop(4194304);
ingreso.mostCurrent._reunion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 251;BA.debugLine="event = 1";
Debug.ShouldStop(67108864);
ingreso._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 253;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _evento2a_click() throws Exception{
try {
		Debug.PushSubsStack("evento2A_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,197);
if (RapidSub.canDelegate("evento2a_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","evento2a_click");}
 BA.debugLineNum = 197;BA.debugLine="Sub evento2A_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 198;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",ingreso._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 199;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(64);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 200;BA.debugLine="evento22A.Visible = True";
Debug.ShouldStop(128);
ingreso.mostCurrent._evento22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 201;BA.debugLine="titulo22A.Text = titulo2A.Text";
Debug.ShouldStop(256);
ingreso.mostCurrent._titulo22a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._titulo2a.runMethod(true,"getText")));
 BA.debugLineNum = 202;BA.debugLine="fecha22A.Text = fecha2A.Text";
Debug.ShouldStop(512);
ingreso.mostCurrent._fecha22a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._fecha2a.runMethod(true,"getText")));
 BA.debugLineNum = 203;BA.debugLine="hora22A.Text = hora2A.Text";
Debug.ShouldStop(1024);
ingreso.mostCurrent._hora22a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._hora2a.runMethod(true,"getText")));
 BA.debugLineNum = 204;BA.debugLine="desc22A.Text = desc2";
Debug.ShouldStop(2048);
ingreso.mostCurrent._desc22a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso._desc2));
 BA.debugLineNum = 205;BA.debugLine="If tipo2 = \"Celebración\" Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",ingreso._tipo2,BA.ObjectToString("Celebración"))) { 
 BA.debugLineNum = 206;BA.debugLine="celebracion22A.Visible = True";
Debug.ShouldStop(8192);
ingreso.mostCurrent._celebracion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 207;BA.debugLine="cambio22A.Visible = False";
Debug.ShouldStop(16384);
ingreso.mostCurrent._cambio22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 208;BA.debugLine="reunion22A.Visible = False";
Debug.ShouldStop(32768);
ingreso.mostCurrent._reunion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 210;BA.debugLine="If tipo2 = \"Reunión\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",ingreso._tipo2,BA.ObjectToString("Reunión"))) { 
 BA.debugLineNum = 211;BA.debugLine="celebracion22A.Visible = False";
Debug.ShouldStop(262144);
ingreso.mostCurrent._celebracion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 212;BA.debugLine="cambio22A.Visible = False";
Debug.ShouldStop(524288);
ingreso.mostCurrent._cambio22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 213;BA.debugLine="reunion22A.Visible = True";
Debug.ShouldStop(1048576);
ingreso.mostCurrent._reunion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 215;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",ingreso._tipo2,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 216;BA.debugLine="celebracion22A.Visible = False";
Debug.ShouldStop(8388608);
ingreso.mostCurrent._celebracion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 217;BA.debugLine="cambio22A.Visible = True";
Debug.ShouldStop(16777216);
ingreso.mostCurrent._cambio22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 218;BA.debugLine="reunion22A.Visible = False";
Debug.ShouldStop(33554432);
ingreso.mostCurrent._reunion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 222;BA.debugLine="event = 1";
Debug.ShouldStop(536870912);
ingreso._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 224;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _evento3a_click() throws Exception{
try {
		Debug.PushSubsStack("evento3A_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,255);
if (RapidSub.canDelegate("evento3a_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","evento3a_click");}
 BA.debugLineNum = 255;BA.debugLine="Sub evento3A_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 256;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",ingreso._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 257;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(1);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 258;BA.debugLine="evento33A.Visible = True";
Debug.ShouldStop(2);
ingreso.mostCurrent._evento33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 259;BA.debugLine="titulo33A.Text = titulo3A.Text";
Debug.ShouldStop(4);
ingreso.mostCurrent._titulo33a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._titulo3a.runMethod(true,"getText")));
 BA.debugLineNum = 260;BA.debugLine="fecha33A.Text = fecha3A.Text";
Debug.ShouldStop(8);
ingreso.mostCurrent._fecha33a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._fecha3a.runMethod(true,"getText")));
 BA.debugLineNum = 261;BA.debugLine="hora33A.Text = hora3A.Text";
Debug.ShouldStop(16);
ingreso.mostCurrent._hora33a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._hora3a.runMethod(true,"getText")));
 BA.debugLineNum = 262;BA.debugLine="descripcion33A.Text = desc3";
Debug.ShouldStop(32);
ingreso.mostCurrent._descripcion33a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso._desc3));
 BA.debugLineNum = 263;BA.debugLine="If tipo3 = \"Celebración\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",ingreso._tipo3,BA.ObjectToString("Celebración"))) { 
 BA.debugLineNum = 264;BA.debugLine="celebracion33A.Visible = True";
Debug.ShouldStop(128);
ingreso.mostCurrent._celebracion33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 265;BA.debugLine="cambio33A.Visible = False";
Debug.ShouldStop(256);
ingreso.mostCurrent._cambio33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 266;BA.debugLine="reunion33A.Visible = False";
Debug.ShouldStop(512);
ingreso.mostCurrent._reunion33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 268;BA.debugLine="If tipo3 = \"Reunión\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",ingreso._tipo3,BA.ObjectToString("Reunión"))) { 
 BA.debugLineNum = 269;BA.debugLine="celebracion33A.Visible = False";
Debug.ShouldStop(4096);
ingreso.mostCurrent._celebracion33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 270;BA.debugLine="cambio33A.Visible = False";
Debug.ShouldStop(8192);
ingreso.mostCurrent._cambio33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 271;BA.debugLine="reunion33A.Visible = True";
Debug.ShouldStop(16384);
ingreso.mostCurrent._reunion33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 273;BA.debugLine="If tipo3 = \"Cambio\" Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",ingreso._tipo3,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 274;BA.debugLine="celebracion33A.Visible = False";
Debug.ShouldStop(131072);
ingreso.mostCurrent._celebracion33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 275;BA.debugLine="cambio33A.Visible = True";
Debug.ShouldStop(262144);
ingreso.mostCurrent._cambio33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 276;BA.debugLine="reunion33A.Visible = False";
Debug.ShouldStop(524288);
ingreso.mostCurrent._reunion33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 280;BA.debugLine="event = 1";
Debug.ShouldStop(8388608);
ingreso._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 282;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _evento4e_click() throws Exception{
try {
		Debug.PushSubsStack("evento4E_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,284);
if (RapidSub.canDelegate("evento4e_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","evento4e_click");}
 BA.debugLineNum = 284;BA.debugLine="Sub evento4E_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 285;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",ingreso._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 286;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(536870912);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 287;BA.debugLine="evento44A.Visible = True";
Debug.ShouldStop(1073741824);
ingreso.mostCurrent._evento44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 288;BA.debugLine="titulo44A.Text = titulo4A.Text";
Debug.ShouldStop(-2147483648);
ingreso.mostCurrent._titulo44a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._titulo4a.runMethod(true,"getText")));
 BA.debugLineNum = 289;BA.debugLine="fecha44A.Text = fecha4A.Text";
Debug.ShouldStop(1);
ingreso.mostCurrent._fecha44a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._fecha4a.runMethod(true,"getText")));
 BA.debugLineNum = 290;BA.debugLine="hora44A.Text = hora4A.Text";
Debug.ShouldStop(2);
ingreso.mostCurrent._hora44a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._hora4a.runMethod(true,"getText")));
 BA.debugLineNum = 291;BA.debugLine="descripcion44A.Text = desc4";
Debug.ShouldStop(4);
ingreso.mostCurrent._descripcion44a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso._desc4));
 BA.debugLineNum = 292;BA.debugLine="If tipo4 = \"Celebración\" Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",ingreso._tipo4,BA.ObjectToString("Celebración"))) { 
 BA.debugLineNum = 293;BA.debugLine="celebracion44A.Visible = True";
Debug.ShouldStop(16);
ingreso.mostCurrent._celebracion44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 294;BA.debugLine="cambio44A.Visible = False";
Debug.ShouldStop(32);
ingreso.mostCurrent._cambio44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 295;BA.debugLine="reunion44A.Visible = False";
Debug.ShouldStop(64);
ingreso.mostCurrent._reunion44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 297;BA.debugLine="If tipo4 = \"Reunión\" Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",ingreso._tipo4,BA.ObjectToString("Reunión"))) { 
 BA.debugLineNum = 298;BA.debugLine="celebracion44A.Visible = False";
Debug.ShouldStop(512);
ingreso.mostCurrent._celebracion44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 299;BA.debugLine="cambio44A.Visible = False";
Debug.ShouldStop(1024);
ingreso.mostCurrent._cambio44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 300;BA.debugLine="reunion44A.Visible = True";
Debug.ShouldStop(2048);
ingreso.mostCurrent._reunion44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 302;BA.debugLine="If tipo4 = \"Cambio\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",ingreso._tipo4,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 303;BA.debugLine="celebracion44A.Visible = False";
Debug.ShouldStop(16384);
ingreso.mostCurrent._celebracion44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 304;BA.debugLine="cambio44A.Visible = True";
Debug.ShouldStop(32768);
ingreso.mostCurrent._cambio44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 305;BA.debugLine="reunion44A.Visible = False";
Debug.ShouldStop(65536);
ingreso.mostCurrent._reunion44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 309;BA.debugLine="event = 1";
Debug.ShouldStop(1048576);
ingreso._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 311;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 18;BA.debugLine="Private TabHost1 As TabHost";
ingreso.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private btncambiaracudiente As Button";
ingreso.mostCurrent._btncambiaracudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private btncerraracudiente As Button";
ingreso.mostCurrent._btncerraracudiente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private inicio As Panel";
ingreso.mostCurrent._inicio = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private cerrar As Label";
ingreso.mostCurrent._cerrar = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private txtconact As EditText";
ingreso.mostCurrent._txtconact = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private txtconnuv As EditText";
ingreso.mostCurrent._txtconnuv = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private txtconfcon As EditText";
ingreso.mostCurrent._txtconfcon = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private Panel1 As Panel";
ingreso.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private btncambio As Button";
ingreso.mostCurrent._btncambio = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Anuncio As Label";
ingreso.mostCurrent._anuncio = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private cambio1A As ImageView";
ingreso.mostCurrent._cambio1a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private cambio2A As ImageView";
ingreso.mostCurrent._cambio2a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private celebracion1A As ImageView";
ingreso.mostCurrent._celebracion1a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private celebracion2A As ImageView";
ingreso.mostCurrent._celebracion2a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private evento1A As Panel";
ingreso.mostCurrent._evento1a = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private evento2A As Panel";
ingreso.mostCurrent._evento2a = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private fecha1A As Label";
ingreso.mostCurrent._fecha1a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private fecha2A As Label";
ingreso.mostCurrent._fecha2a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private hora1A As Label";
ingreso.mostCurrent._hora1a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private hora2A As Label";
ingreso.mostCurrent._hora2a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private reunion1A As ImageView";
ingreso.mostCurrent._reunion1a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private reunion2A As ImageView";
ingreso.mostCurrent._reunion2a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private titulo1A As Label";
ingreso.mostCurrent._titulo1a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private titulo2A As Label";
ingreso.mostCurrent._titulo2a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private cambio11A As ImageView";
ingreso.mostCurrent._cambio11a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private cambio22A As ImageView";
ingreso.mostCurrent._cambio22a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private celebracion11A As ImageView";
ingreso.mostCurrent._celebracion11a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private celebracion22A As ImageView";
ingreso.mostCurrent._celebracion22a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private contraseñaA As EditText";
ingreso.mostCurrent._contraseñaa = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private Datos As Panel";
ingreso.mostCurrent._datos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private desc11A As Label";
ingreso.mostCurrent._desc11a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private desc22A As Label";
ingreso.mostCurrent._desc22a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private EnviarA As Button";
ingreso.mostCurrent._enviara = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private evento11A As Panel";
ingreso.mostCurrent._evento11a = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private fecha11A As Label";
ingreso.mostCurrent._fecha11a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private fecha22A As Label";
ingreso.mostCurrent._fecha22a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private hora11A As Label";
ingreso.mostCurrent._hora11a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private hora22A As Label";
ingreso.mostCurrent._hora22a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private reunion11A As ImageView";
ingreso.mostCurrent._reunion11a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private reunion22A As ImageView";
ingreso.mostCurrent._reunion22a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private titulo11A As Label";
ingreso.mostCurrent._titulo11a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private titulo22A As Label";
ingreso.mostCurrent._titulo22a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private evento22A As Panel";
ingreso.mostCurrent._evento22a = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private cambio3A As ImageView";
ingreso.mostCurrent._cambio3a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private cambio4A As ImageView";
ingreso.mostCurrent._cambio4a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private celebracion3A As ImageView";
ingreso.mostCurrent._celebracion3a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Private celebracion4A As ImageView";
ingreso.mostCurrent._celebracion4a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private evento3A As Panel";
ingreso.mostCurrent._evento3a = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private evento4A As Panel";
ingreso.mostCurrent._evento4a = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Private fecha3A As Label";
ingreso.mostCurrent._fecha3a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private fecha4A As Label";
ingreso.mostCurrent._fecha4a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 70;BA.debugLine="Private hora3A As Label";
ingreso.mostCurrent._hora3a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Private hora4A As Label";
ingreso.mostCurrent._hora4a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Private reunion3A As ImageView";
ingreso.mostCurrent._reunion3a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 73;BA.debugLine="Private reunion4A As ImageView";
ingreso.mostCurrent._reunion4a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private titulo3A As Label";
ingreso.mostCurrent._titulo3a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 75;BA.debugLine="Private titulo4A As Label";
ingreso.mostCurrent._titulo4a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 76;BA.debugLine="Private cambio33A As ImageView";
ingreso.mostCurrent._cambio33a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 77;BA.debugLine="Private cambio44A As ImageView";
ingreso.mostCurrent._cambio44a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 78;BA.debugLine="Private celebracion33A As ImageView";
ingreso.mostCurrent._celebracion33a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 79;BA.debugLine="Private celebracion44A As ImageView";
ingreso.mostCurrent._celebracion44a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 80;BA.debugLine="Private descripcion33A As Label";
ingreso.mostCurrent._descripcion33a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 81;BA.debugLine="Private descripcion44A As Label";
ingreso.mostCurrent._descripcion44a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 82;BA.debugLine="Private evento33A As Panel";
ingreso.mostCurrent._evento33a = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 83;BA.debugLine="Private evento44A As Panel";
ingreso.mostCurrent._evento44a = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 84;BA.debugLine="Private fecha33A As Label";
ingreso.mostCurrent._fecha33a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 85;BA.debugLine="Private fecha44A As Label";
ingreso.mostCurrent._fecha44a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 86;BA.debugLine="Private hora33A As Label";
ingreso.mostCurrent._hora33a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 87;BA.debugLine="Private hora44A As Label";
ingreso.mostCurrent._hora44a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 88;BA.debugLine="Private reunion33A As ImageView";
ingreso.mostCurrent._reunion33a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 89;BA.debugLine="Private reunion44A As ImageView";
ingreso.mostCurrent._reunion44a = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 90;BA.debugLine="Private titulo33A As Label";
ingreso.mostCurrent._titulo33a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 91;BA.debugLine="Private titulo44A As Label";
ingreso.mostCurrent._titulo44a = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 92;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _inicio_click() throws Exception{
try {
		Debug.PushSubsStack("inicio_Click (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,142);
if (RapidSub.canDelegate("inicio_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","inicio_click");}
 BA.debugLineNum = 142;BA.debugLine="Sub inicio_Click";
Debug.ShouldStop(8192);
 BA.debugLineNum = 143;BA.debugLine="If event = 1 Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",ingreso._event,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 144;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(32768);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 145;BA.debugLine="evento44A.Visible=False";
Debug.ShouldStop(65536);
ingreso.mostCurrent._evento44a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 146;BA.debugLine="evento33A.Visible=False";
Debug.ShouldStop(131072);
ingreso.mostCurrent._evento33a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 147;BA.debugLine="evento22A.Visible = False";
Debug.ShouldStop(262144);
ingreso.mostCurrent._evento22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 148;BA.debugLine="evento11A.Visible = False";
Debug.ShouldStop(524288);
ingreso.mostCurrent._evento11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 149;BA.debugLine="event = 0";
Debug.ShouldStop(1048576);
ingreso._event = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 151;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("JobDone (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,180);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 180;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(524288);
 BA.debugLineNum = 181;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(1048576);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 182;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
Debug.ShouldStop(2097152);
ingreso.mostCurrent.__c.runVoidMethod ("LogImpl","23473410",RemoteObject.createImmutable("OK, se actualizó correctamente"),0);
 BA.debugLineNum = 183;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
Debug.ShouldStop(4194304);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingreso.processBA);
 BA.debugLineNum = 184;BA.debugLine="txtconact.Text=\"\"";
Debug.ShouldStop(8388608);
ingreso.mostCurrent._txtconact.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 185;BA.debugLine="txtconnuv.Text=\"\"";
Debug.ShouldStop(16777216);
ingreso.mostCurrent._txtconnuv.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 186;BA.debugLine="txtconfcon.Text=\"\"";
Debug.ShouldStop(33554432);
ingreso.mostCurrent._txtconfcon.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 187;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(67108864);
ingreso.mostCurrent._panel1.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 188;BA.debugLine="inicio.Visible=False";
Debug.ShouldStop(134217728);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 189;BA.debugLine="estado=0";
Debug.ShouldStop(268435456);
ingreso._estado = BA.numberCast(int.class, 0);
 }else {
 BA.debugLineNum = 191;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(1073741824);
ingreso.mostCurrent.__c.runVoidMethod ("LogImpl","23473419",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 192;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(-2147483648);
ingreso.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(ingreso.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 194;BA.debugLine="Job.Release";
Debug.ShouldStop(2);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 195;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim estado As Int=0";
ingreso._estado = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 10;BA.debugLine="Dim titulo,descripcion,fecha,hora,tipo,tipo1,tipo";
ingreso._titulo = RemoteObject.createImmutable("");
ingreso._descripcion = RemoteObject.createImmutable("");
ingreso._fecha = RemoteObject.createImmutable("");
ingreso._hora = RemoteObject.createImmutable("");
ingreso._tipo = RemoteObject.createImmutable("");
ingreso._tipo1 = RemoteObject.createImmutable("");
ingreso._tipo2 = RemoteObject.createImmutable("");
ingreso._tipo3 = RemoteObject.createImmutable("");
ingreso._tipo4 = RemoteObject.createImmutable("");
ingreso._c = RemoteObject.createImmutable("");
ingreso._codigo = RemoteObject.createImmutable("");
ingreso._desc1 = RemoteObject.createImmutable("");
ingreso._desc2 = RemoteObject.createImmutable("");
ingreso._desc3 = RemoteObject.createImmutable("");
ingreso._desc4 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Dim eventos As Int = 0";
ingreso._eventos = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 12;BA.debugLine="Dim event As Int = 0";
ingreso._event = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _remorea() throws Exception{
try {
		Debug.PushSubsStack("remoreA (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,367);
if (RapidSub.canDelegate("remorea")) { b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","remorea"); return;}
ResumableSub_remoreA rsub = new ResumableSub_remoreA(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_remoreA extends BA.ResumableSub {
public ResumableSub_remoreA(b4a.example.ingreso parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.ingreso parent;
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _js = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _tabla = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _fila = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
RemoteObject _n = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
RemoteObject _n2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
RemoteObject _n3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
RemoteObject _n4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
int step27;
int limit27;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("remoreA (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,367);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 368;BA.debugLine="If eventos = 0 Then";
Debug.ShouldStop(32768);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(double.class, 0))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 369;BA.debugLine="Anuncio.Visible = True";
Debug.ShouldStop(65536);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 371;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(262144);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;
;
 BA.debugLineNum = 373;BA.debugLine="Try";
Debug.ShouldStop(1048576);

case 6:
//try
this.state = 173;
this.catchState = 172;
this.state = 8;
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 172;
 BA.debugLineNum = 374;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/s";
Debug.ShouldStop(2097152);
_apiaddress = BA.ObjectToString("http://192.168.1.5/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 375;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(4194304);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 376;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(8388608);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingreso.processBA,(Object)(BA.ObjectToString("")),(Object)(ingreso.getObject()));
 BA.debugLineNum = 377;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
Debug.ShouldStop(16777216);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {6},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("evento"),BA.ObjectToString("codigo"),parent._codigo,BA.ObjectToString("quien"),RemoteObject.createImmutable("acudiente")})));
 BA.debugLineNum = 378;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingreso.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingreso", "remorea"), (_js));
this.state = 174;
return;
case 174:
//C
this.state = 9;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 379;BA.debugLine="If js.Success Then";
Debug.ShouldStop(67108864);
if (true) break;

case 9:
//if
this.state = 170;
if (_js.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 11;
}else {
this.state = 169;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 380;BA.debugLine="Dim res As String";
Debug.ShouldStop(134217728);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 381;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
Debug.ShouldStop(268435456);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 382;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(536870912);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 383;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(1073741824);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 384;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(-2147483648);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 385;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(1);
if (true) break;

case 12:
//if
this.state = 167;
if ((RemoteObject.solveBoolean(">",_res.runMethod(true,"length"),BA.numberCast(double.class, 0)))) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 386;BA.debugLine="eventos = 1";
Debug.ShouldStop(2);
parent._eventos = BA.numberCast(int.class, 1);
 BA.debugLineNum = 387;BA.debugLine="If eventos = 1 Then";
Debug.ShouldStop(4);
if (true) break;

case 15:
//if
this.state = 18;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(double.class, 1))) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 388;BA.debugLine="evento1A.Visible = True";
Debug.ShouldStop(8);
parent.mostCurrent._evento1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 18:
//C
this.state = 19;
;
 BA.debugLineNum = 390;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(32);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 391;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(64);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 392;BA.debugLine="Log(tabla)";
Debug.ShouldStop(128);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","23801113",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 393;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(256);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 394;BA.debugLine="For i=0 To tabla.Size-1";
Debug.ShouldStop(512);
if (true) break;

case 19:
//for
this.state = 166;
step27 = 1;
limit27 = RemoteObject.solve(new RemoteObject[] {_tabla.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
this.state = 175;
if (true) break;

case 175:
//C
this.state = 166;
if ((step27 > 0 && _i <= limit27) || (step27 < 0 && _i >= limit27)) this.state = 21;
if (true) break;

case 176:
//C
this.state = 175;
_i = ((int)(0 + _i + step27)) ;
Debug.locals.put("i", _i);
if (true) break;

case 21:
//C
this.state = 22;
 BA.debugLineNum = 395;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(1024);
_fila.setObject(_tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 396;BA.debugLine="titulo = fila.Get(\"titulo_e\")";
Debug.ShouldStop(2048);
parent._titulo = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("titulo_e")))));
 BA.debugLineNum = 397;BA.debugLine="descripcion = fila.Get(\"descripcion_e\")";
Debug.ShouldStop(4096);
parent._descripcion = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("descripcion_e")))));
 BA.debugLineNum = 398;BA.debugLine="c= fila.Get(\"codigo_g\")";
Debug.ShouldStop(8192);
parent._c = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("codigo_g")))));
 BA.debugLineNum = 399;BA.debugLine="fecha = fila.Get(\"fecha_evento\")";
Debug.ShouldStop(16384);
parent._fecha = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha_evento")))));
 BA.debugLineNum = 400;BA.debugLine="hora = fila.Get(\"hora_evento\")";
Debug.ShouldStop(32768);
parent._hora = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("hora_evento")))));
 BA.debugLineNum = 401;BA.debugLine="tipo = fila.Get(\"id_tipo\")";
Debug.ShouldStop(65536);
parent._tipo = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id_tipo")))));
 BA.debugLineNum = 402;BA.debugLine="If eventos =1 Then";
Debug.ShouldStop(131072);
if (true) break;

case 22:
//if
this.state = 165;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(double.class, 1))) { 
this.state = 24;
}else {
this.state = 58;
}if (true) break;

case 24:
//C
this.state = 25;
 BA.debugLineNum = 403;BA.debugLine="tipo1 = tipo";
Debug.ShouldStop(262144);
parent._tipo1 = parent._tipo;
 BA.debugLineNum = 404;BA.debugLine="If tipo1 = \"00A\" Then";
Debug.ShouldStop(524288);
if (true) break;

case 25:
//if
this.state = 40;
if (RemoteObject.solveBoolean("=",parent._tipo1,BA.ObjectToString("00A"))) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 40;
 BA.debugLineNum = 405;BA.debugLine="tipo1 = \"Celebración\"";
Debug.ShouldStop(1048576);
parent._tipo1 = BA.ObjectToString("Celebración");
 if (true) break;

case 29:
//C
this.state = 30;
 BA.debugLineNum = 407;BA.debugLine="If tipo1 = \"00B\" Then";
Debug.ShouldStop(4194304);
if (true) break;

case 30:
//if
this.state = 39;
if (RemoteObject.solveBoolean("=",parent._tipo1,BA.ObjectToString("00B"))) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 39;
 BA.debugLineNum = 408;BA.debugLine="tipo1 = \"Cambio\"";
Debug.ShouldStop(8388608);
parent._tipo1 = BA.ObjectToString("Cambio");
 if (true) break;

case 34:
//C
this.state = 35;
 BA.debugLineNum = 410;BA.debugLine="If tipo1 = \"00C\" Then";
Debug.ShouldStop(33554432);
if (true) break;

case 35:
//if
this.state = 38;
if (RemoteObject.solveBoolean("=",parent._tipo1,BA.ObjectToString("00C"))) { 
this.state = 37;
}if (true) break;

case 37:
//C
this.state = 38;
 BA.debugLineNum = 411;BA.debugLine="tipo1 = \"Reunión\"";
Debug.ShouldStop(67108864);
parent._tipo1 = BA.ObjectToString("Reunión");
 if (true) break;

case 38:
//C
this.state = 39;
;
 if (true) break;

case 39:
//C
this.state = 40;
;
 if (true) break;

case 40:
//C
this.state = 41;
;
 BA.debugLineNum = 415;BA.debugLine="Dim n As Notification";
Debug.ShouldStop(1073741824);
_n = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n", _n);
 BA.debugLineNum = 416;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(-2147483648);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 417;BA.debugLine="n.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(1);
_n.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 418;BA.debugLine="n.Icon =\"icon\"";
Debug.ShouldStop(2);
_n.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 419;BA.debugLine="n.SetInfo(tipo1,\"Se llevará acabo el \"&fecha";
Debug.ShouldStop(4);
_n.runVoidMethod ("SetInfoNew",ingreso.processBA,(Object)(BA.ObjectToCharSequence(parent._tipo1)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fecha))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 420;BA.debugLine="n.Notify(1)";
Debug.ShouldStop(8);
_n.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 421;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(16);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 422;BA.debugLine="evento1A.Visible = true";
Debug.ShouldStop(32);
parent.mostCurrent._evento1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 423;BA.debugLine="titulo1A.Text = titulo";
Debug.ShouldStop(64);
parent.mostCurrent._titulo1a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._titulo));
 BA.debugLineNum = 424;BA.debugLine="fecha1A.Text = fecha";
Debug.ShouldStop(128);
parent.mostCurrent._fecha1a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fecha));
 BA.debugLineNum = 425;BA.debugLine="hora1A.Text = hora";
Debug.ShouldStop(256);
parent.mostCurrent._hora1a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hora));
 BA.debugLineNum = 426;BA.debugLine="desc1 = descripcion";
Debug.ShouldStop(512);
parent._desc1 = parent._descripcion;
 BA.debugLineNum = 427;BA.debugLine="If tipo1 = \"Celebración\" Then";
Debug.ShouldStop(1024);
if (true) break;

case 41:
//if
this.state = 56;
if (RemoteObject.solveBoolean("=",parent._tipo1,BA.ObjectToString("Celebración"))) { 
this.state = 43;
}else {
this.state = 45;
}if (true) break;

case 43:
//C
this.state = 56;
 BA.debugLineNum = 428;BA.debugLine="celebracion1A.Visible = True";
Debug.ShouldStop(2048);
parent.mostCurrent._celebracion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 429;BA.debugLine="cambio1A.Visible = False";
Debug.ShouldStop(4096);
parent.mostCurrent._cambio1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 430;BA.debugLine="reunion1A.Visible = False";
Debug.ShouldStop(8192);
parent.mostCurrent._reunion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 45:
//C
this.state = 46;
 BA.debugLineNum = 432;BA.debugLine="If tipo1 = \"Cambio\" Then";
Debug.ShouldStop(32768);
if (true) break;

case 46:
//if
this.state = 55;
if (RemoteObject.solveBoolean("=",parent._tipo1,BA.ObjectToString("Cambio"))) { 
this.state = 48;
}else {
this.state = 50;
}if (true) break;

case 48:
//C
this.state = 55;
 BA.debugLineNum = 433;BA.debugLine="celebracion1A.Visible = False";
Debug.ShouldStop(65536);
parent.mostCurrent._celebracion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 434;BA.debugLine="cambio1A.Visible = True";
Debug.ShouldStop(131072);
parent.mostCurrent._cambio1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 435;BA.debugLine="reunion1A.Visible = False";
Debug.ShouldStop(262144);
parent.mostCurrent._reunion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 50:
//C
this.state = 51;
 BA.debugLineNum = 437;BA.debugLine="If tipo1 = \"Reunión\" Then";
Debug.ShouldStop(1048576);
if (true) break;

case 51:
//if
this.state = 54;
if (RemoteObject.solveBoolean("=",parent._tipo1,BA.ObjectToString("Reunión"))) { 
this.state = 53;
}if (true) break;

case 53:
//C
this.state = 54;
 BA.debugLineNum = 438;BA.debugLine="celebracion1A.Visible = False";
Debug.ShouldStop(2097152);
parent.mostCurrent._celebracion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 439;BA.debugLine="cambio1A.Visible = False";
Debug.ShouldStop(4194304);
parent.mostCurrent._cambio1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 440;BA.debugLine="reunion1A.Visible = True";
Debug.ShouldStop(8388608);
parent.mostCurrent._reunion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 54:
//C
this.state = 55;
;
 if (true) break;

case 55:
//C
this.state = 56;
;
 if (true) break;

case 56:
//C
this.state = 165;
;
 if (true) break;

case 58:
//C
this.state = 59;
 BA.debugLineNum = 445;BA.debugLine="If eventos =2 Then";
Debug.ShouldStop(268435456);
if (true) break;

case 59:
//if
this.state = 94;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(double.class, 2))) { 
this.state = 61;
}if (true) break;

case 61:
//C
this.state = 62;
 BA.debugLineNum = 446;BA.debugLine="tipo2 = tipo";
Debug.ShouldStop(536870912);
parent._tipo2 = parent._tipo;
 BA.debugLineNum = 447;BA.debugLine="If tipo2 = \"00A\" Then";
Debug.ShouldStop(1073741824);
if (true) break;

case 62:
//if
this.state = 77;
if (RemoteObject.solveBoolean("=",parent._tipo2,BA.ObjectToString("00A"))) { 
this.state = 64;
}else {
this.state = 66;
}if (true) break;

case 64:
//C
this.state = 77;
 BA.debugLineNum = 448;BA.debugLine="tipo2 = \"Celebración\"";
Debug.ShouldStop(-2147483648);
parent._tipo2 = BA.ObjectToString("Celebración");
 if (true) break;

case 66:
//C
this.state = 67;
 BA.debugLineNum = 450;BA.debugLine="If tipo2 = \"00B\" Then";
Debug.ShouldStop(2);
if (true) break;

case 67:
//if
this.state = 76;
if (RemoteObject.solveBoolean("=",parent._tipo2,BA.ObjectToString("00B"))) { 
this.state = 69;
}else {
this.state = 71;
}if (true) break;

case 69:
//C
this.state = 76;
 BA.debugLineNum = 451;BA.debugLine="tipo2 = \"Cambio\"";
Debug.ShouldStop(4);
parent._tipo2 = BA.ObjectToString("Cambio");
 if (true) break;

case 71:
//C
this.state = 72;
 BA.debugLineNum = 453;BA.debugLine="If tipo2 = \"00C\" Then";
Debug.ShouldStop(16);
if (true) break;

case 72:
//if
this.state = 75;
if (RemoteObject.solveBoolean("=",parent._tipo2,BA.ObjectToString("00C"))) { 
this.state = 74;
}if (true) break;

case 74:
//C
this.state = 75;
 BA.debugLineNum = 454;BA.debugLine="tipo2 = \"Reunión\"";
Debug.ShouldStop(32);
parent._tipo2 = BA.ObjectToString("Reunión");
 if (true) break;

case 75:
//C
this.state = 76;
;
 if (true) break;

case 76:
//C
this.state = 77;
;
 if (true) break;

case 77:
//C
this.state = 78;
;
 BA.debugLineNum = 458;BA.debugLine="Dim n2 As Notification";
Debug.ShouldStop(512);
_n2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n2", _n2);
 BA.debugLineNum = 459;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
Debug.ShouldStop(1024);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 460;BA.debugLine="n2.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(2048);
_n2.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 461;BA.debugLine="n2.Icon =\"icon\"";
Debug.ShouldStop(4096);
_n2.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 462;BA.debugLine="n2.SetInfo(tipo2,\"Se llevará acabo el \"&fec";
Debug.ShouldStop(8192);
_n2.runVoidMethod ("SetInfoNew",ingreso.processBA,(Object)(BA.ObjectToCharSequence(parent._tipo2)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fecha))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 463;BA.debugLine="n2.Notify(2)";
Debug.ShouldStop(16384);
_n2.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 464;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(32768);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 465;BA.debugLine="evento2A.Visible = True";
Debug.ShouldStop(65536);
parent.mostCurrent._evento2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 466;BA.debugLine="titulo2A.Text = titulo";
Debug.ShouldStop(131072);
parent.mostCurrent._titulo2a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._titulo));
 BA.debugLineNum = 467;BA.debugLine="fecha2A.Text = fecha";
Debug.ShouldStop(262144);
parent.mostCurrent._fecha2a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fecha));
 BA.debugLineNum = 468;BA.debugLine="hora2A.Text = hora";
Debug.ShouldStop(524288);
parent.mostCurrent._hora2a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hora));
 BA.debugLineNum = 469;BA.debugLine="desc2 = descripcion";
Debug.ShouldStop(1048576);
parent._desc2 = parent._descripcion;
 BA.debugLineNum = 470;BA.debugLine="If tipo2 = \"Celebración\" Then";
Debug.ShouldStop(2097152);
if (true) break;

case 78:
//if
this.state = 93;
if (RemoteObject.solveBoolean("=",parent._tipo2,BA.ObjectToString("Celebración"))) { 
this.state = 80;
}else {
this.state = 82;
}if (true) break;

case 80:
//C
this.state = 93;
 BA.debugLineNum = 471;BA.debugLine="celebracion2A.Visible = True";
Debug.ShouldStop(4194304);
parent.mostCurrent._celebracion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 472;BA.debugLine="cambio2A.Visible = False";
Debug.ShouldStop(8388608);
parent.mostCurrent._cambio2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 473;BA.debugLine="reunion2A.Visible = False";
Debug.ShouldStop(16777216);
parent.mostCurrent._reunion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 82:
//C
this.state = 83;
 BA.debugLineNum = 475;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(67108864);
if (true) break;

case 83:
//if
this.state = 92;
if (RemoteObject.solveBoolean("=",parent._tipo2,BA.ObjectToString("Cambio"))) { 
this.state = 85;
}else {
this.state = 87;
}if (true) break;

case 85:
//C
this.state = 92;
 BA.debugLineNum = 476;BA.debugLine="celebracion2A.Visible = False";
Debug.ShouldStop(134217728);
parent.mostCurrent._celebracion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 477;BA.debugLine="cambio2A.Visible = True";
Debug.ShouldStop(268435456);
parent.mostCurrent._cambio2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 478;BA.debugLine="reunion2A.Visible = False";
Debug.ShouldStop(536870912);
parent.mostCurrent._reunion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 87:
//C
this.state = 88;
 BA.debugLineNum = 480;BA.debugLine="If tipo2 = \"Reunión\" Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 88:
//if
this.state = 91;
if (RemoteObject.solveBoolean("=",parent._tipo2,BA.ObjectToString("Reunión"))) { 
this.state = 90;
}if (true) break;

case 90:
//C
this.state = 91;
 BA.debugLineNum = 481;BA.debugLine="celebracion2A.Visible = False";
Debug.ShouldStop(1);
parent.mostCurrent._celebracion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 482;BA.debugLine="cambio2A.Visible = False";
Debug.ShouldStop(2);
parent.mostCurrent._cambio2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 483;BA.debugLine="reunion2A.Visible = True";
Debug.ShouldStop(4);
parent.mostCurrent._reunion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 91:
//C
this.state = 92;
;
 if (true) break;

case 92:
//C
this.state = 93;
;
 if (true) break;

case 93:
//C
this.state = 94;
;
 if (true) break;
;
 BA.debugLineNum = 488;BA.debugLine="If eventos =3 Then";
Debug.ShouldStop(128);

case 94:
//if
this.state = 129;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(double.class, 3))) { 
this.state = 96;
}if (true) break;

case 96:
//C
this.state = 97;
 BA.debugLineNum = 489;BA.debugLine="tipo3 = tipo";
Debug.ShouldStop(256);
parent._tipo3 = parent._tipo;
 BA.debugLineNum = 490;BA.debugLine="If tipo3 = \"00A\" Then";
Debug.ShouldStop(512);
if (true) break;

case 97:
//if
this.state = 112;
if (RemoteObject.solveBoolean("=",parent._tipo3,BA.ObjectToString("00A"))) { 
this.state = 99;
}else {
this.state = 101;
}if (true) break;

case 99:
//C
this.state = 112;
 BA.debugLineNum = 491;BA.debugLine="tipo3 = \"Celebración\"";
Debug.ShouldStop(1024);
parent._tipo3 = BA.ObjectToString("Celebración");
 if (true) break;

case 101:
//C
this.state = 102;
 BA.debugLineNum = 493;BA.debugLine="If tipo3 = \"00B\" Then";
Debug.ShouldStop(4096);
if (true) break;

case 102:
//if
this.state = 111;
if (RemoteObject.solveBoolean("=",parent._tipo3,BA.ObjectToString("00B"))) { 
this.state = 104;
}else {
this.state = 106;
}if (true) break;

case 104:
//C
this.state = 111;
 BA.debugLineNum = 494;BA.debugLine="tipo3 = \"Cambio\"";
Debug.ShouldStop(8192);
parent._tipo3 = BA.ObjectToString("Cambio");
 if (true) break;

case 106:
//C
this.state = 107;
 BA.debugLineNum = 496;BA.debugLine="If tipo3 = \"00C\" Then";
Debug.ShouldStop(32768);
if (true) break;

case 107:
//if
this.state = 110;
if (RemoteObject.solveBoolean("=",parent._tipo3,BA.ObjectToString("00C"))) { 
this.state = 109;
}if (true) break;

case 109:
//C
this.state = 110;
 BA.debugLineNum = 497;BA.debugLine="tipo3 = \"Reunión\"";
Debug.ShouldStop(65536);
parent._tipo3 = BA.ObjectToString("Reunión");
 if (true) break;

case 110:
//C
this.state = 111;
;
 if (true) break;

case 111:
//C
this.state = 112;
;
 if (true) break;

case 112:
//C
this.state = 113;
;
 BA.debugLineNum = 501;BA.debugLine="Dim n3 As Notification";
Debug.ShouldStop(1048576);
_n3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n3", _n3);
 BA.debugLineNum = 502;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
Debug.ShouldStop(2097152);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 503;BA.debugLine="n3.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(4194304);
_n3.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 504;BA.debugLine="n3.Icon =\"icon\"";
Debug.ShouldStop(8388608);
_n3.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 505;BA.debugLine="n3.SetInfo(tipo3,\"Se llevará acabo el \"&fec";
Debug.ShouldStop(16777216);
_n3.runVoidMethod ("SetInfoNew",ingreso.processBA,(Object)(BA.ObjectToCharSequence(parent._tipo3)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fecha))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 506;BA.debugLine="n3.Notify(3)";
Debug.ShouldStop(33554432);
_n3.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 3)));
 BA.debugLineNum = 507;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(67108864);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 508;BA.debugLine="evento3A.Visible = True";
Debug.ShouldStop(134217728);
parent.mostCurrent._evento3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 509;BA.debugLine="titulo3A.Text = titulo";
Debug.ShouldStop(268435456);
parent.mostCurrent._titulo3a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._titulo));
 BA.debugLineNum = 510;BA.debugLine="fecha3A.Text = fecha";
Debug.ShouldStop(536870912);
parent.mostCurrent._fecha3a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fecha));
 BA.debugLineNum = 511;BA.debugLine="hora3A.Text = hora";
Debug.ShouldStop(1073741824);
parent.mostCurrent._hora3a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hora));
 BA.debugLineNum = 512;BA.debugLine="desc3 = descripcion";
Debug.ShouldStop(-2147483648);
parent._desc3 = parent._descripcion;
 BA.debugLineNum = 513;BA.debugLine="If tipo3 = \"Celebración\" Then";
Debug.ShouldStop(1);
if (true) break;

case 113:
//if
this.state = 128;
if (RemoteObject.solveBoolean("=",parent._tipo3,BA.ObjectToString("Celebración"))) { 
this.state = 115;
}else {
this.state = 117;
}if (true) break;

case 115:
//C
this.state = 128;
 BA.debugLineNum = 514;BA.debugLine="celebracion3A.Visible = True";
Debug.ShouldStop(2);
parent.mostCurrent._celebracion3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 515;BA.debugLine="cambio3A.Visible = False";
Debug.ShouldStop(4);
parent.mostCurrent._cambio3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 516;BA.debugLine="reunion3A.Visible = False";
Debug.ShouldStop(8);
parent.mostCurrent._reunion3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 117:
//C
this.state = 118;
 BA.debugLineNum = 518;BA.debugLine="If tipo3 = \"Cambio\" Then";
Debug.ShouldStop(32);
if (true) break;

case 118:
//if
this.state = 127;
if (RemoteObject.solveBoolean("=",parent._tipo3,BA.ObjectToString("Cambio"))) { 
this.state = 120;
}else {
this.state = 122;
}if (true) break;

case 120:
//C
this.state = 127;
 BA.debugLineNum = 519;BA.debugLine="celebracion3A.Visible = False";
Debug.ShouldStop(64);
parent.mostCurrent._celebracion3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 520;BA.debugLine="cambio3A.Visible = True";
Debug.ShouldStop(128);
parent.mostCurrent._cambio3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 521;BA.debugLine="reunion3A.Visible = False";
Debug.ShouldStop(256);
parent.mostCurrent._reunion3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 122:
//C
this.state = 123;
 BA.debugLineNum = 523;BA.debugLine="If tipo3 = \"Reunión\" Then";
Debug.ShouldStop(1024);
if (true) break;

case 123:
//if
this.state = 126;
if (RemoteObject.solveBoolean("=",parent._tipo3,BA.ObjectToString("Reunión"))) { 
this.state = 125;
}if (true) break;

case 125:
//C
this.state = 126;
 BA.debugLineNum = 524;BA.debugLine="celebracion3A.Visible = False";
Debug.ShouldStop(2048);
parent.mostCurrent._celebracion3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 525;BA.debugLine="cambio3A.Visible = False";
Debug.ShouldStop(4096);
parent.mostCurrent._cambio3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 526;BA.debugLine="reunion3A.Visible = True";
Debug.ShouldStop(8192);
parent.mostCurrent._reunion3a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 126:
//C
this.state = 127;
;
 if (true) break;

case 127:
//C
this.state = 128;
;
 if (true) break;

case 128:
//C
this.state = 129;
;
 if (true) break;
;
 BA.debugLineNum = 531;BA.debugLine="If eventos =4 Then";
Debug.ShouldStop(262144);

case 129:
//if
this.state = 164;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(double.class, 4))) { 
this.state = 131;
}if (true) break;

case 131:
//C
this.state = 132;
 BA.debugLineNum = 532;BA.debugLine="tipo4 = tipo";
Debug.ShouldStop(524288);
parent._tipo4 = parent._tipo;
 BA.debugLineNum = 533;BA.debugLine="If tipo4 = \"00A\" Then";
Debug.ShouldStop(1048576);
if (true) break;

case 132:
//if
this.state = 147;
if (RemoteObject.solveBoolean("=",parent._tipo4,BA.ObjectToString("00A"))) { 
this.state = 134;
}else {
this.state = 136;
}if (true) break;

case 134:
//C
this.state = 147;
 BA.debugLineNum = 534;BA.debugLine="tipo4 = \"Celebración\"";
Debug.ShouldStop(2097152);
parent._tipo4 = BA.ObjectToString("Celebración");
 if (true) break;

case 136:
//C
this.state = 137;
 BA.debugLineNum = 536;BA.debugLine="If tipo4 = \"00B\" Then";
Debug.ShouldStop(8388608);
if (true) break;

case 137:
//if
this.state = 146;
if (RemoteObject.solveBoolean("=",parent._tipo4,BA.ObjectToString("00B"))) { 
this.state = 139;
}else {
this.state = 141;
}if (true) break;

case 139:
//C
this.state = 146;
 BA.debugLineNum = 537;BA.debugLine="tipo4 = \"Cambio\"";
Debug.ShouldStop(16777216);
parent._tipo4 = BA.ObjectToString("Cambio");
 if (true) break;

case 141:
//C
this.state = 142;
 BA.debugLineNum = 539;BA.debugLine="If tipo4 = \"00C\" Then";
Debug.ShouldStop(67108864);
if (true) break;

case 142:
//if
this.state = 145;
if (RemoteObject.solveBoolean("=",parent._tipo4,BA.ObjectToString("00C"))) { 
this.state = 144;
}if (true) break;

case 144:
//C
this.state = 145;
 BA.debugLineNum = 540;BA.debugLine="tipo4 = \"Reunión\"";
Debug.ShouldStop(134217728);
parent._tipo4 = BA.ObjectToString("Reunión");
 if (true) break;

case 145:
//C
this.state = 146;
;
 if (true) break;

case 146:
//C
this.state = 147;
;
 if (true) break;

case 147:
//C
this.state = 148;
;
 BA.debugLineNum = 544;BA.debugLine="Dim n4 As Notification";
Debug.ShouldStop(-2147483648);
_n4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n4", _n4);
 BA.debugLineNum = 545;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
Debug.ShouldStop(1);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 546;BA.debugLine="n4.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(2);
_n4.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 547;BA.debugLine="n4.Icon =\"icon\"";
Debug.ShouldStop(4);
_n4.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 548;BA.debugLine="n4.SetInfo(tipo4,\"Se llevará acabo el \"&fec";
Debug.ShouldStop(8);
_n4.runVoidMethod ("SetInfoNew",ingreso.processBA,(Object)(BA.ObjectToCharSequence(parent._tipo4)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fecha))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 549;BA.debugLine="n4.Notify(4)";
Debug.ShouldStop(16);
_n4.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 550;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(32);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 551;BA.debugLine="evento4A.Visible = True";
Debug.ShouldStop(64);
parent.mostCurrent._evento4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 552;BA.debugLine="titulo4A.Text = titulo";
Debug.ShouldStop(128);
parent.mostCurrent._titulo4a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._titulo));
 BA.debugLineNum = 553;BA.debugLine="fecha4A.Text = fecha";
Debug.ShouldStop(256);
parent.mostCurrent._fecha4a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fecha));
 BA.debugLineNum = 554;BA.debugLine="hora4A.Text = hora";
Debug.ShouldStop(512);
parent.mostCurrent._hora4a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hora));
 BA.debugLineNum = 555;BA.debugLine="desc4 = descripcion";
Debug.ShouldStop(1024);
parent._desc4 = parent._descripcion;
 BA.debugLineNum = 556;BA.debugLine="If tipo4 = \"Celebración\" Then";
Debug.ShouldStop(2048);
if (true) break;

case 148:
//if
this.state = 163;
if (RemoteObject.solveBoolean("=",parent._tipo4,BA.ObjectToString("Celebración"))) { 
this.state = 150;
}else {
this.state = 152;
}if (true) break;

case 150:
//C
this.state = 163;
 BA.debugLineNum = 557;BA.debugLine="celebracion4A.Visible = True";
Debug.ShouldStop(4096);
parent.mostCurrent._celebracion4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 558;BA.debugLine="cambio4A.Visible = False";
Debug.ShouldStop(8192);
parent.mostCurrent._cambio4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 559;BA.debugLine="reunion4A.Visible = False";
Debug.ShouldStop(16384);
parent.mostCurrent._reunion4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 152:
//C
this.state = 153;
 BA.debugLineNum = 561;BA.debugLine="If tipo4 = \"Cambio\" Then";
Debug.ShouldStop(65536);
if (true) break;

case 153:
//if
this.state = 162;
if (RemoteObject.solveBoolean("=",parent._tipo4,BA.ObjectToString("Cambio"))) { 
this.state = 155;
}else {
this.state = 157;
}if (true) break;

case 155:
//C
this.state = 162;
 BA.debugLineNum = 562;BA.debugLine="celebracion4A.Visible = False";
Debug.ShouldStop(131072);
parent.mostCurrent._celebracion4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 563;BA.debugLine="cambio4A.Visible = True";
Debug.ShouldStop(262144);
parent.mostCurrent._cambio4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 564;BA.debugLine="reunion4A.Visible = False";
Debug.ShouldStop(524288);
parent.mostCurrent._reunion4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 157:
//C
this.state = 158;
 BA.debugLineNum = 566;BA.debugLine="If tipo4 = \"Reunión\" Then";
Debug.ShouldStop(2097152);
if (true) break;

case 158:
//if
this.state = 161;
if (RemoteObject.solveBoolean("=",parent._tipo4,BA.ObjectToString("Reunión"))) { 
this.state = 160;
}if (true) break;

case 160:
//C
this.state = 161;
 BA.debugLineNum = 567;BA.debugLine="celebracion4A.Visible = False";
Debug.ShouldStop(4194304);
parent.mostCurrent._celebracion4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 568;BA.debugLine="cambio4A.Visible = False";
Debug.ShouldStop(8388608);
parent.mostCurrent._cambio4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 569;BA.debugLine="reunion4A.Visible = True";
Debug.ShouldStop(16777216);
parent.mostCurrent._reunion4a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 161:
//C
this.state = 162;
;
 if (true) break;

case 162:
//C
this.state = 163;
;
 if (true) break;

case 163:
//C
this.state = 164;
;
 if (true) break;

case 164:
//C
this.state = 165;
;
 if (true) break;

case 165:
//C
this.state = 176;
;
 BA.debugLineNum = 575;BA.debugLine="eventos = eventos  + 1";
Debug.ShouldStop(1073741824);
parent._eventos = RemoteObject.solve(new RemoteObject[] {parent._eventos,RemoteObject.createImmutable(1)}, "+",1, 1);
 if (true) break;
if (true) break;

case 166:
//C
this.state = 167;
Debug.locals.put("i", _i);
;
 if (true) break;

case 167:
//C
this.state = 170;
;
 if (true) break;

case 169:
//C
this.state = 170;
 BA.debugLineNum = 579;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","23801300",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 if (true) break;

case 170:
//C
this.state = 173;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 172:
//C
this.state = 173;
this.catchState = 0;
 BA.debugLineNum = 582;BA.debugLine="Log(LastException)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","23801303",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingreso.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 173:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 584;BA.debugLine="End Sub";
Debug.ShouldStop(128);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",ingreso.processBA, e0.toString());}
            }
        }
    }
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
public static RemoteObject  _txtconfcon_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconfcon_TextChanged (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,159);
if (RapidSub.canDelegate("txtconfcon_textchanged")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","txtconfcon_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 159;BA.debugLine="Sub txtconfcon_TextChanged (Old As String, New As";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 160;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 161;BA.debugLine="MsgboxAsync(\"Laconfirmación de la contraseña no";
Debug.ShouldStop(1);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingreso.processBA);
 };
 BA.debugLineNum = 163;BA.debugLine="End Sub";
Debug.ShouldStop(4);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtconnuv_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconnuv_TextChanged (ingreso) ","ingreso",4,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,153);
if (RapidSub.canDelegate("txtconnuv_textchanged")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","txtconnuv_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 153;BA.debugLine="Sub txtconnuv_TextChanged (Old As String, New As S";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 154;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 155;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
Debug.ShouldStop(67108864);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingreso.processBA);
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
}
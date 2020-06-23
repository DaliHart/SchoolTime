package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ingresodocente_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,97);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 97;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(1);
 BA.debugLineNum = 99;BA.debugLine="Activity.LoadLayout(\"ingresoDocente\")";
Debug.ShouldStop(4);
ingresodocente.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ingresoDocente")),ingresodocente.mostCurrent.activityBA);
 BA.debugLineNum = 100;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"eventoDocente\")";
Debug.ShouldStop(8);
ingresodocente.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingresodocente.mostCurrent.activityBA,(Object)(BA.ObjectToString("EVENTOS")),(Object)(RemoteObject.createImmutable("eventoDocente")));
 BA.debugLineNum = 101;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfilDocente\")";
Debug.ShouldStop(16);
ingresodocente.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingresodocente.mostCurrent.activityBA,(Object)(BA.ObjectToString("PERFIL")),(Object)(RemoteObject.createImmutable("perfilDocente")));
 BA.debugLineNum = 102;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(32);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 103;BA.debugLine="Panel1.Visible =False";
Debug.ShouldStop(64);
ingresodocente.mostCurrent._panel1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 104;BA.debugLine="evento11.Visible = False";
Debug.ShouldStop(128);
ingresodocente.mostCurrent._evento11.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 105;BA.debugLine="evento22.Visible= False";
Debug.ShouldStop(256);
ingresodocente.mostCurrent._evento22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 106;BA.debugLine="evento33.Visible=False";
Debug.ShouldStop(512);
ingresodocente.mostCurrent._evento33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 107;BA.debugLine="evento3.Visible=False";
Debug.ShouldStop(1024);
ingresodocente.mostCurrent._evento3.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 108;BA.debugLine="evento2.Visible= False";
Debug.ShouldStop(2048);
ingresodocente.mostCurrent._evento2.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 109;BA.debugLine="evento1.Visible=False";
Debug.ShouldStop(4096);
ingresodocente.mostCurrent._evento1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 110;BA.debugLine="evento4.Visible=False";
Debug.ShouldStop(8192);
ingresodocente.mostCurrent._evento4.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 111;BA.debugLine="evento44.Visible=False";
Debug.ShouldStop(16384);
ingresodocente.mostCurrent._evento44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 112;BA.debugLine="Anuncio.Visible= True";
Debug.ShouldStop(32768);
ingresodocente.mostCurrent._anuncio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 113;BA.debugLine="eventos = 0";
Debug.ShouldStop(65536);
ingresodocente._eventos = BA.numberCast(int.class, 0);
 BA.debugLineNum = 114;BA.debugLine="End Sub";
Debug.ShouldStop(131072);
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
		Debug.PushSubsStack("Activity_Pause (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,120);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 120;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 122;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("Activity_Resume (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,116);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","activity_resume");}
 BA.debugLineNum = 116;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(524288);
 BA.debugLineNum = 118;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncambiardocente_click() throws Exception{
try {
		Debug.PushSubsStack("btncambiardocente_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,124);
if (RapidSub.canDelegate("btncambiardocente_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","btncambiardocente_click");}
 BA.debugLineNum = 124;BA.debugLine="Sub btncambiardocente_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="If estado = 0 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",ingresodocente._estado,BA.numberCast(int.class, 0))) { 
 BA.debugLineNum = 126;BA.debugLine="Panel1.Visible = True";
Debug.ShouldStop(536870912);
ingresodocente.mostCurrent._panel1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 127;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(1073741824);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 128;BA.debugLine="estado = 1";
Debug.ShouldStop(-2147483648);
ingresodocente._estado = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 130;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("btncambio_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,157);
if (RapidSub.canDelegate("btncambio_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","btncambio_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 157;BA.debugLine="Sub btncambio_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 158;BA.debugLine="If txtconact.Text<>\"\" And txtconnuv.Text<>\"\" And";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("!",ingresodocente.mostCurrent._txtconact.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingresodocente.mostCurrent._txtconnuv.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingresodocente.mostCurrent._txtconfcon.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 159;BA.debugLine="If txtconnuv.Text = txtconfcon.Text Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",ingresodocente.mostCurrent._txtconnuv.runMethod(true,"getText"),ingresodocente.mostCurrent._txtconfcon.runMethod(true,"getText"))) { 
 BA.debugLineNum = 160;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/";
Debug.ShouldStop(-2147483648);
_apiaddress = BA.ObjectToString("http://192.168.1.1/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 161;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(1);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 162;BA.debugLine="job.Initialize(\"\", Me)";
Debug.ShouldStop(2);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingresodocente.processBA,(Object)(BA.ObjectToString("")),(Object)(ingresodocente.getObject()));
 BA.debugLineNum = 163;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tbl_docente S";
Debug.ShouldStop(4);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tbl_docente SET contrasena_doc='"),ingresodocente.mostCurrent._txtconnuv.runMethod(true,"getText"),RemoteObject.createImmutable("' WHERE contrasena_doc='"),ingresodocente.mostCurrent._txtconact.runMethod(true,"getText"),RemoteObject.createImmutable("'"))));
 }else {
 BA.debugLineNum = 165;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
Debug.ShouldStop(16);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Las contraseñas deben coincidir")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresodocente.processBA);
 };
 }else {
 BA.debugLineNum = 168;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
Debug.ShouldStop(128);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresodocente.processBA);
 };
 BA.debugLineNum = 170;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncerrardocente_click() throws Exception{
try {
		Debug.PushSubsStack("btncerrardocente_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,132);
if (RapidSub.canDelegate("btncerrardocente_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","btncerrardocente_click");}
 BA.debugLineNum = 132;BA.debugLine="Sub btncerrardocente_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 133;BA.debugLine="StartActivity(perfiles)";
Debug.ShouldStop(16);
ingresodocente.mostCurrent.__c.runVoidMethod ("StartActivity",ingresodocente.processBA,(Object)((ingresodocente.mostCurrent._perfiles.getObject())));
 BA.debugLineNum = 134;BA.debugLine="Activity.Finish";
Debug.ShouldStop(32);
ingresodocente.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 135;BA.debugLine="End Sub";
Debug.ShouldStop(64);
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
		Debug.PushSubsStack("CreateNotificationChannel (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,354);
if (RapidSub.canDelegate("createnotificationchannel")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","createnotificationchannel", _importancelevel);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _ctxt = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _channelid = RemoteObject.createImmutable("");
RemoteObject _channel = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _manager = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("ImportanceLevel", _importancelevel);
 BA.debugLineNum = 354;BA.debugLine="Sub CreateNotificationChannel(ImportanceLevel As I";
Debug.ShouldStop(2);
 BA.debugLineNum = 355;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(4);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 356;BA.debugLine="If p.SdkVersion >= 26 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(int.class, 26))) { 
 BA.debugLineNum = 357;BA.debugLine="Dim ctxt As JavaObject";
Debug.ShouldStop(16);
_ctxt = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("ctxt", _ctxt);
 BA.debugLineNum = 358;BA.debugLine="ctxt.InitializeContext";
Debug.ShouldStop(32);
_ctxt.runVoidMethod ("InitializeContext",ingresodocente.processBA);
 BA.debugLineNum = 359;BA.debugLine="Dim channelId As String = \"channel_\"& Importance";
Debug.ShouldStop(64);
_channelid = RemoteObject.concat(RemoteObject.createImmutable("channel_"),_importancelevel);Debug.locals.put("channelId", _channelid);Debug.locals.put("channelId", _channelid);
 BA.debugLineNum = 360;BA.debugLine="Dim channel As JavaObject";
Debug.ShouldStop(128);
_channel = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("channel", _channel);
 BA.debugLineNum = 361;BA.debugLine="channel.InitializeNewInstance(\"android.app.Notif";
Debug.ShouldStop(256);
_channel.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("android.app.NotificationChannel")),(Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_channelid),(ingresodocente.mostCurrent.__c.getField(false,"Application").runMethod(true,"getLabelName")),(_importancelevel)})));
 BA.debugLineNum = 362;BA.debugLine="channel.RunMethod(\"setShowBadge\",Array(False))";
Debug.ShouldStop(512);
_channel.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setShowBadge")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(ingresodocente.mostCurrent.__c.getField(true,"False"))})));
 BA.debugLineNum = 364;BA.debugLine="Dim manager As JavaObject = ctxt.RunMethod(\"getS";
Debug.ShouldStop(2048);
_manager = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_manager = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4j.object.JavaObject"), _ctxt.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getSystemService")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("notification"))}))));Debug.locals.put("manager", _manager);
 BA.debugLineNum = 365;BA.debugLine="manager.RunMethod(\"createNotificationChannel\",Ar";
Debug.ShouldStop(4096);
_manager.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("createNotificationChannel")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_channel.getObject())})));
 };
 BA.debugLineNum = 368;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static void  _enviar_click() throws Exception{
try {
		Debug.PushSubsStack("Enviar_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,316);
if (RapidSub.canDelegate("enviar_click")) { b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","enviar_click"); return;}
ResumableSub_Enviar_Click rsub = new ResumableSub_Enviar_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_Enviar_Click extends BA.ResumableSub {
public ResumableSub_Enviar_Click(b4a.example.ingresodocente parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.ingresodocente parent;
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
		Debug.PushSubsStack("Enviar_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,316);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 317;BA.debugLine="If contraseñaD.Text <> \"\" Then";
Debug.ShouldStop(268435456);
if (true) break;

case 1:
//if
this.state = 26;
if (RemoteObject.solveBoolean("!",parent.mostCurrent._contraseñad.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 3;
}else {
this.state = 25;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 318;BA.debugLine="Try";
Debug.ShouldStop(536870912);
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
 BA.debugLineNum = 319;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/";
Debug.ShouldStop(1073741824);
_apiaddress = BA.ObjectToString("http://192.168.1.1/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 320;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(-2147483648);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 321;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(1);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingresodocente.processBA,(Object)(BA.ObjectToString("")),(Object)(ingresodocente.getObject()));
 BA.debugLineNum = 322;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
Debug.ShouldStop(2);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {10},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("cedula"),BA.ObjectToString("pin"),parent.mostCurrent._contraseñad.runMethod(true,"getText"),BA.ObjectToString("tabla"),BA.ObjectToString("tbl_docente"),BA.ObjectToString("codigo"),BA.ObjectToString("codigo_g"),BA.ObjectToString("cedula"),RemoteObject.createImmutable("id_docente")})));
 BA.debugLineNum = 323;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingresodocente.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingresodocente", "enviar_click"), (_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 324;BA.debugLine="If js.Success Then";
Debug.ShouldStop(8);
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
 BA.debugLineNum = 325;BA.debugLine="Dim res As String";
Debug.ShouldStop(16);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 326;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
Debug.ShouldStop(32);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 327;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(64);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 328;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(128);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 329;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(256);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 330;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(512);
if (true) break;

case 10:
//if
this.state = 17;
if ((RemoteObject.solveBoolean(">",_res.runMethod(true,"length"),BA.numberCast(int.class, 0)))) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
 BA.debugLineNum = 331;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(1024);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 332;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(2048);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 333;BA.debugLine="Log(tabla)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","05505041",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 334;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(8192);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 335;BA.debugLine="For i=0 To tabla.Size-1";
Debug.ShouldStop(16384);
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
 BA.debugLineNum = 336;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(32768);
_fila = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 337;BA.debugLine="codigo = fila.Get(\"codigo_g\")";
Debug.ShouldStop(65536);
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
 BA.debugLineNum = 341;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","05505049",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
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
 BA.debugLineNum = 344;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","05505052",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingresodocente.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
 BA.debugLineNum = 346;BA.debugLine="inicio.Visible =False";
Debug.ShouldStop(33554432);
parent.mostCurrent._inicio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 347;BA.debugLine="Datos.Visible = False";
Debug.ShouldStop(67108864);
parent.mostCurrent._datos.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 25:
//C
this.state = 26;
 BA.debugLineNum = 349;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Necesitas este campo para el ingreso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingresodocente.processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
 BA.debugLineNum = 351;BA.debugLine="remore";
Debug.ShouldStop(1073741824);
_remore();
 BA.debugLineNum = 352;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",ingresodocente.processBA, e0.toString());}
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
public static RemoteObject  _evento1_click() throws Exception{
try {
		Debug.PushSubsStack("evento1_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,189);
if (RapidSub.canDelegate("evento1_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","evento1_click");}
 BA.debugLineNum = 189;BA.debugLine="Sub evento1_Click";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 190;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",ingresodocente._event,BA.numberCast(int.class, 0))) { 
 BA.debugLineNum = 191;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(1073741824);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 192;BA.debugLine="evento11.Visible = True";
Debug.ShouldStop(-2147483648);
ingresodocente.mostCurrent._evento11.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 193;BA.debugLine="titulo1.Text = titulo.Text";
Debug.ShouldStop(1);
ingresodocente.mostCurrent._titulo1.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._titulo.runMethod(true,"getText")));
 BA.debugLineNum = 194;BA.debugLine="fecha1.Text = fecha.Text";
Debug.ShouldStop(2);
ingresodocente.mostCurrent._fecha1.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._fecha.runMethod(true,"getText")));
 BA.debugLineNum = 195;BA.debugLine="hora1.Text = hora.Text";
Debug.ShouldStop(4);
ingresodocente.mostCurrent._hora1.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._hora.runMethod(true,"getText")));
 BA.debugLineNum = 196;BA.debugLine="desc1.Text = desc11";
Debug.ShouldStop(8);
ingresodocente.mostCurrent._desc1.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente._desc11));
 BA.debugLineNum = 197;BA.debugLine="If tipo = \"Celebración\" Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",ingresodocente.mostCurrent._tipo,BA.ObjectToString("Celebración"))) { 
 BA.debugLineNum = 198;BA.debugLine="icono1.Visible = True";
Debug.ShouldStop(32);
ingresodocente.mostCurrent._icono1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 199;BA.debugLine="icono1C.Visible = False";
Debug.ShouldStop(64);
ingresodocente.mostCurrent._icono1c.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 200;BA.debugLine="icono1R.Visible = False";
Debug.ShouldStop(128);
ingresodocente.mostCurrent._icono1r.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 202;BA.debugLine="If tipo = \"Reunión\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",ingresodocente.mostCurrent._tipo,BA.ObjectToString("Reunión"))) { 
 BA.debugLineNum = 203;BA.debugLine="icono1.Visible = False";
Debug.ShouldStop(1024);
ingresodocente.mostCurrent._icono1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 204;BA.debugLine="icono1C.Visible = False";
Debug.ShouldStop(2048);
ingresodocente.mostCurrent._icono1c.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 205;BA.debugLine="icono1R.Visible = True";
Debug.ShouldStop(4096);
ingresodocente.mostCurrent._icono1r.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 207;BA.debugLine="If tipo = \"Cambio\" Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",ingresodocente.mostCurrent._tipo,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 208;BA.debugLine="icono1.Visible = False";
Debug.ShouldStop(32768);
ingresodocente.mostCurrent._icono1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 209;BA.debugLine="icono1C.Visible = True";
Debug.ShouldStop(65536);
ingresodocente.mostCurrent._icono1c.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 210;BA.debugLine="icono1R.Visible = False";
Debug.ShouldStop(131072);
ingresodocente.mostCurrent._icono1r.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 214;BA.debugLine="event = 1";
Debug.ShouldStop(2097152);
ingresodocente._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 216;BA.debugLine="End Sub";
Debug.ShouldStop(8388608);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _evento2_click() throws Exception{
try {
		Debug.PushSubsStack("evento2_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,229);
if (RapidSub.canDelegate("evento2_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","evento2_click");}
 BA.debugLineNum = 229;BA.debugLine="Sub evento2_Click";
Debug.ShouldStop(16);
 BA.debugLineNum = 230;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",ingresodocente._event,BA.numberCast(int.class, 0))) { 
 BA.debugLineNum = 231;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(64);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 232;BA.debugLine="evento22.Visible = True";
Debug.ShouldStop(128);
ingresodocente.mostCurrent._evento22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 233;BA.debugLine="titulo22.Text = titulo2.Text";
Debug.ShouldStop(256);
ingresodocente.mostCurrent._titulo22.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._titulo2.runMethod(true,"getText")));
 BA.debugLineNum = 234;BA.debugLine="fecha22.Text = fecha2.Text";
Debug.ShouldStop(512);
ingresodocente.mostCurrent._fecha22.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._fecha2.runMethod(true,"getText")));
 BA.debugLineNum = 235;BA.debugLine="hora22.Text = hora2.Text";
Debug.ShouldStop(1024);
ingresodocente.mostCurrent._hora22.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._hora2.runMethod(true,"getText")));
 BA.debugLineNum = 236;BA.debugLine="descripcion22.Text = desc2";
Debug.ShouldStop(2048);
ingresodocente.mostCurrent._descripcion22.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente._desc2));
 BA.debugLineNum = 237;BA.debugLine="If tipo2 = \"Celebración\" Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo2,BA.ObjectToString("Celebración"))) { 
 BA.debugLineNum = 238;BA.debugLine="celebracion22.Visible = True";
Debug.ShouldStop(8192);
ingresodocente.mostCurrent._celebracion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 239;BA.debugLine="cambio22.Visible = False";
Debug.ShouldStop(16384);
ingresodocente.mostCurrent._cambio22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 240;BA.debugLine="reunion22.Visible = False";
Debug.ShouldStop(32768);
ingresodocente.mostCurrent._reunion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 242;BA.debugLine="If tipo2 = \"Reunión\" Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo2,BA.ObjectToString("Reunión"))) { 
 BA.debugLineNum = 243;BA.debugLine="celebracion22.Visible = False";
Debug.ShouldStop(262144);
ingresodocente.mostCurrent._celebracion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 244;BA.debugLine="cambio22.Visible = False";
Debug.ShouldStop(524288);
ingresodocente.mostCurrent._cambio22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 245;BA.debugLine="reunion22.Visible = True";
Debug.ShouldStop(1048576);
ingresodocente.mostCurrent._reunion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 247;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo2,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 248;BA.debugLine="celebracion22.Visible = False";
Debug.ShouldStop(8388608);
ingresodocente.mostCurrent._celebracion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 249;BA.debugLine="cambio22.Visible = True";
Debug.ShouldStop(16777216);
ingresodocente.mostCurrent._cambio22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 250;BA.debugLine="reunion22.Visible = False";
Debug.ShouldStop(33554432);
ingresodocente.mostCurrent._reunion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 254;BA.debugLine="event = 1";
Debug.ShouldStop(536870912);
ingresodocente._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 256;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _evento3_click() throws Exception{
try {
		Debug.PushSubsStack("evento3_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,258);
if (RapidSub.canDelegate("evento3_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","evento3_click");}
 BA.debugLineNum = 258;BA.debugLine="Sub evento3_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 259;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",ingresodocente._event,BA.numberCast(int.class, 0))) { 
 BA.debugLineNum = 260;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(8);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 261;BA.debugLine="evento33.Visible = True";
Debug.ShouldStop(16);
ingresodocente.mostCurrent._evento33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 262;BA.debugLine="titulo33.Text = titulo3.Text";
Debug.ShouldStop(32);
ingresodocente.mostCurrent._titulo33.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._titulo3.runMethod(true,"getText")));
 BA.debugLineNum = 263;BA.debugLine="fecha33.Text = fecha3.Text";
Debug.ShouldStop(64);
ingresodocente.mostCurrent._fecha33.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._fecha3.runMethod(true,"getText")));
 BA.debugLineNum = 264;BA.debugLine="hora33.Text = hora3.Text";
Debug.ShouldStop(128);
ingresodocente.mostCurrent._hora33.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._hora3.runMethod(true,"getText")));
 BA.debugLineNum = 265;BA.debugLine="descripcion33.Text = desc3";
Debug.ShouldStop(256);
ingresodocente.mostCurrent._descripcion33.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente._desc3));
 BA.debugLineNum = 266;BA.debugLine="If tipo3 = \"Celebración\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo3,BA.ObjectToString("Celebración"))) { 
 BA.debugLineNum = 267;BA.debugLine="celebracion33.Visible = True";
Debug.ShouldStop(1024);
ingresodocente.mostCurrent._celebracion33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 268;BA.debugLine="cambio33.Visible = False";
Debug.ShouldStop(2048);
ingresodocente.mostCurrent._cambio33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 269;BA.debugLine="reunion33.Visible = False";
Debug.ShouldStop(4096);
ingresodocente.mostCurrent._reunion33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 271;BA.debugLine="If tipo3 = \"Reunión\" Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo3,BA.ObjectToString("Reunión"))) { 
 BA.debugLineNum = 272;BA.debugLine="celebracion33.Visible = False";
Debug.ShouldStop(32768);
ingresodocente.mostCurrent._celebracion33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 273;BA.debugLine="cambio33.Visible = False";
Debug.ShouldStop(65536);
ingresodocente.mostCurrent._cambio33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 274;BA.debugLine="reunion33.Visible = True";
Debug.ShouldStop(131072);
ingresodocente.mostCurrent._reunion33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 276;BA.debugLine="If tipo3 = \"Cambio\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo3,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 277;BA.debugLine="celebracion33.Visible = False";
Debug.ShouldStop(1048576);
ingresodocente.mostCurrent._celebracion33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 278;BA.debugLine="cambio33.Visible = True";
Debug.ShouldStop(2097152);
ingresodocente.mostCurrent._cambio33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 279;BA.debugLine="reunion33.Visible = False";
Debug.ShouldStop(4194304);
ingresodocente.mostCurrent._reunion33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 283;BA.debugLine="event = 1";
Debug.ShouldStop(67108864);
ingresodocente._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 285;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _evento4_click() throws Exception{
try {
		Debug.PushSubsStack("evento4_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,287);
if (RapidSub.canDelegate("evento4_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","evento4_click");}
 BA.debugLineNum = 287;BA.debugLine="Sub evento4_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 288;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",ingresodocente._event,BA.numberCast(int.class, 0))) { 
 BA.debugLineNum = 289;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(1);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 290;BA.debugLine="evento44.Visible = True";
Debug.ShouldStop(2);
ingresodocente.mostCurrent._evento44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 291;BA.debugLine="titulo44.Text = titulo4.Text";
Debug.ShouldStop(4);
ingresodocente.mostCurrent._titulo44.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._titulo4.runMethod(true,"getText")));
 BA.debugLineNum = 292;BA.debugLine="fecha44.Text = fecha4.Text";
Debug.ShouldStop(8);
ingresodocente.mostCurrent._fecha44.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._fecha4.runMethod(true,"getText")));
 BA.debugLineNum = 293;BA.debugLine="hora44.Text = hora4.Text";
Debug.ShouldStop(16);
ingresodocente.mostCurrent._hora44.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._hora4.runMethod(true,"getText")));
 BA.debugLineNum = 294;BA.debugLine="descripcion44.Text = desc4";
Debug.ShouldStop(32);
ingresodocente.mostCurrent._descripcion44.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente._desc4));
 BA.debugLineNum = 295;BA.debugLine="If tipo4 = \"Celebración\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo4,BA.ObjectToString("Celebración"))) { 
 BA.debugLineNum = 296;BA.debugLine="celebracion44.Visible = True";
Debug.ShouldStop(128);
ingresodocente.mostCurrent._celebracion44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 297;BA.debugLine="cambio44.Visible = False";
Debug.ShouldStop(256);
ingresodocente.mostCurrent._cambio44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 298;BA.debugLine="reunion44.Visible = False";
Debug.ShouldStop(512);
ingresodocente.mostCurrent._reunion44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 300;BA.debugLine="If tipo4 = \"Reunión\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo4,BA.ObjectToString("Reunión"))) { 
 BA.debugLineNum = 301;BA.debugLine="celebracion44.Visible = False";
Debug.ShouldStop(4096);
ingresodocente.mostCurrent._celebracion44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 302;BA.debugLine="cambio44.Visible = False";
Debug.ShouldStop(8192);
ingresodocente.mostCurrent._cambio44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 303;BA.debugLine="reunion44.Visible = True";
Debug.ShouldStop(16384);
ingresodocente.mostCurrent._reunion44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 305;BA.debugLine="If tipo4 = \"Cambio\" Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo4,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 306;BA.debugLine="celebracion44.Visible = False";
Debug.ShouldStop(131072);
ingresodocente.mostCurrent._celebracion44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 307;BA.debugLine="cambio44.Visible = True";
Debug.ShouldStop(262144);
ingresodocente.mostCurrent._cambio44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 308;BA.debugLine="reunion44.Visible = False";
Debug.ShouldStop(524288);
ingresodocente.mostCurrent._reunion44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 312;BA.debugLine="event = 1";
Debug.ShouldStop(8388608);
ingresodocente._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 314;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 17;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 20;BA.debugLine="Private TabHost1 As TabHost";
ingresodocente.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private btncambiardocente As Button";
ingresodocente.mostCurrent._btncambiardocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private btncerrardocente As Button";
ingresodocente.mostCurrent._btncerrardocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private Panel1 As Panel";
ingresodocente.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private inicio As Panel";
ingresodocente.mostCurrent._inicio = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private retroceder As Label";
ingresodocente.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private txtconnuv As EditText";
ingresodocente.mostCurrent._txtconnuv = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private btncambio As Button";
ingresodocente.mostCurrent._btncambio = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private txtconact As EditText";
ingresodocente.mostCurrent._txtconact = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private txtconfcon As EditText";
ingresodocente.mostCurrent._txtconfcon = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private evento1 As Panel";
ingresodocente.mostCurrent._evento1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private fecha As Label";
ingresodocente.mostCurrent._fecha = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private titulo As Label";
ingresodocente.mostCurrent._titulo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private cambio As ImageView";
ingresodocente.mostCurrent._cambio = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private celebracion As ImageView";
ingresodocente.mostCurrent._celebracion = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private reunion As ImageView";
ingresodocente.mostCurrent._reunion = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Dim tipo As String";
ingresodocente.mostCurrent._tipo = RemoteObject.createImmutable("");
 //BA.debugLineNum = 37;BA.debugLine="Private hora As Label";
ingresodocente.mostCurrent._hora = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private icono1 As ImageView";
ingresodocente.mostCurrent._icono1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private titulo1 As Label";
ingresodocente.mostCurrent._titulo1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private fecha1 As Label";
ingresodocente.mostCurrent._fecha1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private desc1 As Label";
ingresodocente.mostCurrent._desc1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private hora1 As Label";
ingresodocente.mostCurrent._hora1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private icono1R As ImageView";
ingresodocente.mostCurrent._icono1r = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private icono1C As ImageView";
ingresodocente.mostCurrent._icono1c = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private evento11 As Panel";
ingresodocente.mostCurrent._evento11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private Anuncio As Label";
ingresodocente.mostCurrent._anuncio = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private evento2 As Panel";
ingresodocente.mostCurrent._evento2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private cambio2 As ImageView";
ingresodocente.mostCurrent._cambio2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private celebracion2 As ImageView";
ingresodocente.mostCurrent._celebracion2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private reunion2 As ImageView";
ingresodocente.mostCurrent._reunion2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private titulo2 As Label";
ingresodocente.mostCurrent._titulo2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private fecha2 As Label";
ingresodocente.mostCurrent._fecha2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private hora2 As Label";
ingresodocente.mostCurrent._hora2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private cambio22 As ImageView";
ingresodocente.mostCurrent._cambio22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private celebracion22 As ImageView";
ingresodocente.mostCurrent._celebracion22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private descripcion22 As Label";
ingresodocente.mostCurrent._descripcion22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private evento22 As Panel";
ingresodocente.mostCurrent._evento22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private fecha22 As Label";
ingresodocente.mostCurrent._fecha22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private hora22 As Label";
ingresodocente.mostCurrent._hora22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private reunion22 As ImageView";
ingresodocente.mostCurrent._reunion22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private titulo22 As Label";
ingresodocente.mostCurrent._titulo22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private Datos As Panel";
ingresodocente.mostCurrent._datos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private contraseñaD As EditText";
ingresodocente.mostCurrent._contraseñad = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Private Enviar As Button";
ingresodocente.mostCurrent._enviar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Private cambio3 As ImageView";
ingresodocente.mostCurrent._cambio3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 66;BA.debugLine="Private celebracion3 As ImageView";
ingresodocente.mostCurrent._celebracion3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 67;BA.debugLine="Private evento3 As Panel";
ingresodocente.mostCurrent._evento3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 68;BA.debugLine="Private fecha3 As Label";
ingresodocente.mostCurrent._fecha3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 69;BA.debugLine="Private hora3 As Label";
ingresodocente.mostCurrent._hora3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 70;BA.debugLine="Private reunion3 As ImageView";
ingresodocente.mostCurrent._reunion3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 71;BA.debugLine="Private titulo3 As Label";
ingresodocente.mostCurrent._titulo3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 72;BA.debugLine="Private cambio33 As ImageView";
ingresodocente.mostCurrent._cambio33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 73;BA.debugLine="Private celebracion33 As ImageView";
ingresodocente.mostCurrent._celebracion33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 74;BA.debugLine="Private descripcion33 As Label";
ingresodocente.mostCurrent._descripcion33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 75;BA.debugLine="Private evento33 As Panel";
ingresodocente.mostCurrent._evento33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 76;BA.debugLine="Private fecha33 As Label";
ingresodocente.mostCurrent._fecha33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 77;BA.debugLine="Private hora33 As Label";
ingresodocente.mostCurrent._hora33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 78;BA.debugLine="Private reunion33 As ImageView";
ingresodocente.mostCurrent._reunion33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 79;BA.debugLine="Private titulo33 As Label";
ingresodocente.mostCurrent._titulo33 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 80;BA.debugLine="Private cambio4 As ImageView";
ingresodocente.mostCurrent._cambio4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 81;BA.debugLine="Private celebracion4 As ImageView";
ingresodocente.mostCurrent._celebracion4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 82;BA.debugLine="Private evento4 As Panel";
ingresodocente.mostCurrent._evento4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 83;BA.debugLine="Private fecha4 As Label";
ingresodocente.mostCurrent._fecha4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 84;BA.debugLine="Private hora4 As Label";
ingresodocente.mostCurrent._hora4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 85;BA.debugLine="Private reunion4 As ImageView";
ingresodocente.mostCurrent._reunion4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 86;BA.debugLine="Private titulo4 As Label";
ingresodocente.mostCurrent._titulo4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 87;BA.debugLine="Private reunion44 As ImageView";
ingresodocente.mostCurrent._reunion44 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 88;BA.debugLine="Private cambio44 As ImageView";
ingresodocente.mostCurrent._cambio44 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 89;BA.debugLine="Private celebracion44 As ImageView";
ingresodocente.mostCurrent._celebracion44 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 90;BA.debugLine="Private descripcion44 As Label";
ingresodocente.mostCurrent._descripcion44 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 91;BA.debugLine="Private fecha44 As Label";
ingresodocente.mostCurrent._fecha44 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 92;BA.debugLine="Private hora44 As Label";
ingresodocente.mostCurrent._hora44 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 93;BA.debugLine="Private titulo44 As Label";
ingresodocente.mostCurrent._titulo44 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 94;BA.debugLine="Private evento44 As Panel";
ingresodocente.mostCurrent._evento44 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 95;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _inicio_click() throws Exception{
try {
		Debug.PushSubsStack("inicio_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,218);
if (RapidSub.canDelegate("inicio_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","inicio_click");}
 BA.debugLineNum = 218;BA.debugLine="Sub inicio_Click";
Debug.ShouldStop(33554432);
 BA.debugLineNum = 219;BA.debugLine="If event = 1 Then";
Debug.ShouldStop(67108864);
if (RemoteObject.solveBoolean("=",ingresodocente._event,BA.numberCast(int.class, 1))) { 
 BA.debugLineNum = 220;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(134217728);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 221;BA.debugLine="evento11.Visible = False";
Debug.ShouldStop(268435456);
ingresodocente.mostCurrent._evento11.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 222;BA.debugLine="evento22.Visible = False";
Debug.ShouldStop(536870912);
ingresodocente.mostCurrent._evento22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 223;BA.debugLine="evento33.Visible = False";
Debug.ShouldStop(1073741824);
ingresodocente.mostCurrent._evento33.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 224;BA.debugLine="evento44.Visible = False";
Debug.ShouldStop(-2147483648);
ingresodocente.mostCurrent._evento44.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 225;BA.debugLine="event = 0";
Debug.ShouldStop(1);
ingresodocente._event = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 227;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("JobDone (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,172);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 172;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 173;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(4096);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 174;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
Debug.ShouldStop(8192);
ingresodocente.mostCurrent.__c.runVoidMethod ("LogImpl","05111810",RemoteObject.createImmutable("OK, se actualizó correctamente"),0);
 BA.debugLineNum = 175;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
Debug.ShouldStop(16384);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingresodocente.processBA);
 BA.debugLineNum = 176;BA.debugLine="txtconact.Text=\"\"";
Debug.ShouldStop(32768);
ingresodocente.mostCurrent._txtconact.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 177;BA.debugLine="txtconnuv.Text=\"\"";
Debug.ShouldStop(65536);
ingresodocente.mostCurrent._txtconnuv.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 178;BA.debugLine="txtconfcon.Text=\"\"";
Debug.ShouldStop(131072);
ingresodocente.mostCurrent._txtconfcon.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 179;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(262144);
ingresodocente.mostCurrent._panel1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 180;BA.debugLine="inicio.Visible=False";
Debug.ShouldStop(524288);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 181;BA.debugLine="estado=0";
Debug.ShouldStop(1048576);
ingresodocente._estado = BA.numberCast(int.class, 0);
 }else {
 BA.debugLineNum = 183;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(4194304);
ingresodocente.mostCurrent.__c.runVoidMethod ("LogImpl","05111819",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 184;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(8388608);
ingresodocente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(ingresodocente.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 186;BA.debugLine="Job.Release";
Debug.ShouldStop(33554432);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 187;BA.debugLine="End Sub";
Debug.ShouldStop(67108864);
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
 //BA.debugLineNum = 9;BA.debugLine="Dim event As Int = 0";
ingresodocente._event = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 10;BA.debugLine="Dim tit,fec,tip,hor,des,desc11,desc2,tipo3,tipo4,";
ingresodocente._tit = RemoteObject.createImmutable("");
ingresodocente._fec = RemoteObject.createImmutable("");
ingresodocente._tip = RemoteObject.createImmutable("");
ingresodocente._hor = RemoteObject.createImmutable("");
ingresodocente._des = RemoteObject.createImmutable("");
ingresodocente._desc11 = RemoteObject.createImmutable("");
ingresodocente._desc2 = RemoteObject.createImmutable("");
ingresodocente._tipo3 = RemoteObject.createImmutable("");
ingresodocente._tipo4 = RemoteObject.createImmutable("");
ingresodocente._codigo = RemoteObject.createImmutable("");
ingresodocente._c = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Dim tipo2 As String";
ingresodocente._tipo2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 12;BA.debugLine="Dim eventos As Int = 0";
ingresodocente._eventos = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 13;BA.debugLine="Dim estado As Int = 0";
ingresodocente._estado = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 14;BA.debugLine="Dim desc3,desc4 As String";
ingresodocente._desc3 = RemoteObject.createImmutable("");
ingresodocente._desc4 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 15;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _remore() throws Exception{
try {
		Debug.PushSubsStack("remore (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,370);
if (RapidSub.canDelegate("remore")) { b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","remore"); return;}
ResumableSub_remore rsub = new ResumableSub_remore(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_remore extends BA.ResumableSub {
public ResumableSub_remore(b4a.example.ingresodocente parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.ingresodocente parent;
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _js = RemoteObject.declareNull("b4a.example.httpjob");
RemoteObject _res = RemoteObject.createImmutable("");
RemoteObject _parser = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.JSONParser");
RemoteObject _tabla = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.List");
RemoteObject _fila = RemoteObject.declareNull("anywheresoftware.b4a.objects.collections.Map");
int _i = 0;
RemoteObject _n = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
RemoteObject _n1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
RemoteObject _n3 = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
RemoteObject _n4 = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
int step27;
int limit27;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("remore (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,370);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 371;BA.debugLine="If eventos = 0 Then";
Debug.ShouldStop(262144);
if (true) break;

case 1:
//if
this.state = 6;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(int.class, 0))) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
 BA.debugLineNum = 372;BA.debugLine="Anuncio.Visible = True";
Debug.ShouldStop(524288);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 374;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(2097152);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;
;
 BA.debugLineNum = 376;BA.debugLine="Try";
Debug.ShouldStop(8388608);

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
 BA.debugLineNum = 377;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/s";
Debug.ShouldStop(16777216);
_apiaddress = BA.ObjectToString("http://192.168.1.1/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 378;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(33554432);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 379;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(67108864);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingresodocente.processBA,(Object)(BA.ObjectToString("")),(Object)(ingresodocente.getObject()));
 BA.debugLineNum = 380;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
Debug.ShouldStop(134217728);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {6},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("evento"),BA.ObjectToString("codigo"),parent._codigo,BA.ObjectToString("quien"),RemoteObject.createImmutable("docente")})));
 BA.debugLineNum = 381;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingresodocente.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingresodocente", "remore"), (_js));
this.state = 174;
return;
case 174:
//C
this.state = 9;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 382;BA.debugLine="If js.Success Then";
Debug.ShouldStop(536870912);
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
 BA.debugLineNum = 383;BA.debugLine="Dim res As String";
Debug.ShouldStop(1073741824);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 384;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
Debug.ShouldStop(-2147483648);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 385;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(1);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 386;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(2);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 387;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(4);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 388;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(8);
if (true) break;

case 12:
//if
this.state = 167;
if ((RemoteObject.solveBoolean(">",_res.runMethod(true,"length"),BA.numberCast(int.class, 0)))) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 389;BA.debugLine="eventos = 1";
Debug.ShouldStop(16);
parent._eventos = BA.numberCast(int.class, 1);
 BA.debugLineNum = 390;BA.debugLine="If eventos = 1 Then";
Debug.ShouldStop(32);
if (true) break;

case 15:
//if
this.state = 18;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(int.class, 1))) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
 BA.debugLineNum = 391;BA.debugLine="evento1.Visible = True";
Debug.ShouldStop(64);
parent.mostCurrent._evento1.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 18:
//C
this.state = 19;
;
 BA.debugLineNum = 393;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(256);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 394;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(512);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 395;BA.debugLine="Log(tabla)";
Debug.ShouldStop(1024);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","05636121",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 396;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(2048);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 397;BA.debugLine="For i=0 To tabla.Size-1";
Debug.ShouldStop(4096);
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
 BA.debugLineNum = 398;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(8192);
_fila = RemoteObject.declareNull("anywheresoftware.b4a.AbsObjectWrapper").runMethod(false, "ConvertToWrapper", RemoteObject.createNew("anywheresoftware.b4a.objects.collections.Map"), _tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 399;BA.debugLine="tit = fila.Get(\"titulo_e\")";
Debug.ShouldStop(16384);
parent._tit = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("titulo_e")))));
 BA.debugLineNum = 400;BA.debugLine="des = fila.Get(\"descripcion_e\")";
Debug.ShouldStop(32768);
parent._des = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("descripcion_e")))));
 BA.debugLineNum = 401;BA.debugLine="c = fila.Get(\"codigo_g\")";
Debug.ShouldStop(65536);
parent._c = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("codigo_g")))));
 BA.debugLineNum = 402;BA.debugLine="fec = fila.Get(\"fecha_evento\")";
Debug.ShouldStop(131072);
parent._fec = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha_evento")))));
 BA.debugLineNum = 403;BA.debugLine="hor = fila.Get(\"hora_evento\")";
Debug.ShouldStop(262144);
parent._hor = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("hora_evento")))));
 BA.debugLineNum = 404;BA.debugLine="tip = fila.Get(\"id_tipo\")";
Debug.ShouldStop(524288);
parent._tip = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("id_tipo")))));
 BA.debugLineNum = 405;BA.debugLine="If eventos =1 Then";
Debug.ShouldStop(1048576);
if (true) break;

case 22:
//if
this.state = 165;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(int.class, 1))) { 
this.state = 24;
}else {
this.state = 58;
}if (true) break;

case 24:
//C
this.state = 25;
 BA.debugLineNum = 406;BA.debugLine="tipo = tip";
Debug.ShouldStop(2097152);
parent.mostCurrent._tipo = parent._tip;
 BA.debugLineNum = 407;BA.debugLine="If tipo = \"00A\" Then";
Debug.ShouldStop(4194304);
if (true) break;

case 25:
//if
this.state = 40;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._tipo,BA.ObjectToString("00A"))) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 40;
 BA.debugLineNum = 408;BA.debugLine="tipo = \"Celebración\"";
Debug.ShouldStop(8388608);
parent.mostCurrent._tipo = BA.ObjectToString("Celebración");
 if (true) break;

case 29:
//C
this.state = 30;
 BA.debugLineNum = 410;BA.debugLine="If tipo = \"00B\" Then";
Debug.ShouldStop(33554432);
if (true) break;

case 30:
//if
this.state = 39;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._tipo,BA.ObjectToString("00B"))) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 39;
 BA.debugLineNum = 411;BA.debugLine="tipo = \"Cambio\"";
Debug.ShouldStop(67108864);
parent.mostCurrent._tipo = BA.ObjectToString("Cambio");
 if (true) break;

case 34:
//C
this.state = 35;
 BA.debugLineNum = 413;BA.debugLine="If tipo = \"00C\" Then";
Debug.ShouldStop(268435456);
if (true) break;

case 35:
//if
this.state = 38;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._tipo,BA.ObjectToString("00C"))) { 
this.state = 37;
}if (true) break;

case 37:
//C
this.state = 38;
 BA.debugLineNum = 414;BA.debugLine="tipo = \"Reunión\"";
Debug.ShouldStop(536870912);
parent.mostCurrent._tipo = BA.ObjectToString("Reunión");
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
 BA.debugLineNum = 418;BA.debugLine="Dim n As Notification";
Debug.ShouldStop(2);
_n = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n", _n);
 BA.debugLineNum = 419;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(4);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 420;BA.debugLine="n.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(8);
_n.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 421;BA.debugLine="n.Icon =\"icon\"";
Debug.ShouldStop(16);
_n.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 422;BA.debugLine="n.SetInfo(tipo,\"Se llevará acabo el \"&fec,Ma";
Debug.ShouldStop(32);
_n.runVoidMethod ("SetInfoNew",ingresodocente.processBA,(Object)(BA.ObjectToCharSequence(parent.mostCurrent._tipo)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fec))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 423;BA.debugLine="n.Notify(1)";
Debug.ShouldStop(64);
_n.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 424;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(128);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 425;BA.debugLine="evento2.Visible = False";
Debug.ShouldStop(256);
parent.mostCurrent._evento2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 426;BA.debugLine="titulo.Text = tit";
Debug.ShouldStop(512);
parent.mostCurrent._titulo.runMethod(true,"setText",BA.ObjectToCharSequence(parent._tit));
 BA.debugLineNum = 427;BA.debugLine="fecha.Text = fec";
Debug.ShouldStop(1024);
parent.mostCurrent._fecha.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fec));
 BA.debugLineNum = 428;BA.debugLine="hora.Text = hor";
Debug.ShouldStop(2048);
parent.mostCurrent._hora.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hor));
 BA.debugLineNum = 429;BA.debugLine="desc11 = des";
Debug.ShouldStop(4096);
parent._desc11 = parent._des;
 BA.debugLineNum = 430;BA.debugLine="If tipo = \"Celebración\" Then";
Debug.ShouldStop(8192);
if (true) break;

case 41:
//if
this.state = 56;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._tipo,BA.ObjectToString("Celebración"))) { 
this.state = 43;
}else {
this.state = 45;
}if (true) break;

case 43:
//C
this.state = 56;
 BA.debugLineNum = 431;BA.debugLine="celebracion.Visible = True";
Debug.ShouldStop(16384);
parent.mostCurrent._celebracion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 432;BA.debugLine="cambio.Visible = False";
Debug.ShouldStop(32768);
parent.mostCurrent._cambio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 433;BA.debugLine="reunion.Visible = False";
Debug.ShouldStop(65536);
parent.mostCurrent._reunion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 45:
//C
this.state = 46;
 BA.debugLineNum = 435;BA.debugLine="If tipo = \"Cambio\" Then";
Debug.ShouldStop(262144);
if (true) break;

case 46:
//if
this.state = 55;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._tipo,BA.ObjectToString("Cambio"))) { 
this.state = 48;
}else {
this.state = 50;
}if (true) break;

case 48:
//C
this.state = 55;
 BA.debugLineNum = 436;BA.debugLine="celebracion.Visible = False";
Debug.ShouldStop(524288);
parent.mostCurrent._celebracion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 437;BA.debugLine="cambio.Visible = True";
Debug.ShouldStop(1048576);
parent.mostCurrent._cambio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 438;BA.debugLine="reunion.Visible = False";
Debug.ShouldStop(2097152);
parent.mostCurrent._reunion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 50:
//C
this.state = 51;
 BA.debugLineNum = 440;BA.debugLine="If tipo = \"Reunión\" Then";
Debug.ShouldStop(8388608);
if (true) break;

case 51:
//if
this.state = 54;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._tipo,BA.ObjectToString("Reunión"))) { 
this.state = 53;
}if (true) break;

case 53:
//C
this.state = 54;
 BA.debugLineNum = 441;BA.debugLine="celebracion.Visible = False";
Debug.ShouldStop(16777216);
parent.mostCurrent._celebracion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 442;BA.debugLine="cambio.Visible = False";
Debug.ShouldStop(33554432);
parent.mostCurrent._cambio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 443;BA.debugLine="reunion.Visible = True";
Debug.ShouldStop(67108864);
parent.mostCurrent._reunion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
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
 BA.debugLineNum = 448;BA.debugLine="If eventos =2 Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 59:
//if
this.state = 94;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(int.class, 2))) { 
this.state = 61;
}if (true) break;

case 61:
//C
this.state = 62;
 BA.debugLineNum = 449;BA.debugLine="tipo2 = tip";
Debug.ShouldStop(1);
parent._tipo2 = parent._tip;
 BA.debugLineNum = 450;BA.debugLine="If tipo2 = \"00A\" Then";
Debug.ShouldStop(2);
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
 BA.debugLineNum = 451;BA.debugLine="tipo2 = \"Celebración\"";
Debug.ShouldStop(4);
parent._tipo2 = BA.ObjectToString("Celebración");
 if (true) break;

case 66:
//C
this.state = 67;
 BA.debugLineNum = 453;BA.debugLine="If tipo2 = \"00B\" Then";
Debug.ShouldStop(16);
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
 BA.debugLineNum = 454;BA.debugLine="tipo2 = \"Cambio\"";
Debug.ShouldStop(32);
parent._tipo2 = BA.ObjectToString("Cambio");
 if (true) break;

case 71:
//C
this.state = 72;
 BA.debugLineNum = 456;BA.debugLine="If tipo2 = \"00C\" Then";
Debug.ShouldStop(128);
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
 BA.debugLineNum = 457;BA.debugLine="tipo2 = \"Reunión\"";
Debug.ShouldStop(256);
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
 BA.debugLineNum = 461;BA.debugLine="Dim n1 As Notification";
Debug.ShouldStop(4096);
_n1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n1", _n1);
 BA.debugLineNum = 462;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
Debug.ShouldStop(8192);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 463;BA.debugLine="n1.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(16384);
_n1.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 464;BA.debugLine="n1.Icon =\"icon\"";
Debug.ShouldStop(32768);
_n1.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 465;BA.debugLine="n1.SetInfo(tipo2,\"Se llevará acabo el \"&fec";
Debug.ShouldStop(65536);
_n1.runVoidMethod ("SetInfoNew",ingresodocente.processBA,(Object)(BA.ObjectToCharSequence(parent._tipo2)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fec))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 466;BA.debugLine="n1.Notify(2)";
Debug.ShouldStop(131072);
_n1.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 467;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(262144);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 468;BA.debugLine="evento2.Visible = True";
Debug.ShouldStop(524288);
parent.mostCurrent._evento2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 469;BA.debugLine="titulo2.Text = tit";
Debug.ShouldStop(1048576);
parent.mostCurrent._titulo2.runMethod(true,"setText",BA.ObjectToCharSequence(parent._tit));
 BA.debugLineNum = 470;BA.debugLine="fecha2.Text = fec";
Debug.ShouldStop(2097152);
parent.mostCurrent._fecha2.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fec));
 BA.debugLineNum = 471;BA.debugLine="hora2.Text = hor";
Debug.ShouldStop(4194304);
parent.mostCurrent._hora2.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hor));
 BA.debugLineNum = 472;BA.debugLine="desc2 = des";
Debug.ShouldStop(8388608);
parent._desc2 = parent._des;
 BA.debugLineNum = 473;BA.debugLine="If tipo2 = \"Celebración\" Then";
Debug.ShouldStop(16777216);
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
 BA.debugLineNum = 474;BA.debugLine="celebracion2.Visible = True";
Debug.ShouldStop(33554432);
parent.mostCurrent._celebracion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 475;BA.debugLine="cambio2.Visible = False";
Debug.ShouldStop(67108864);
parent.mostCurrent._cambio2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 476;BA.debugLine="reunion2.Visible = False";
Debug.ShouldStop(134217728);
parent.mostCurrent._reunion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 82:
//C
this.state = 83;
 BA.debugLineNum = 478;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(536870912);
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
 BA.debugLineNum = 479;BA.debugLine="celebracion2.Visible = False";
Debug.ShouldStop(1073741824);
parent.mostCurrent._celebracion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 480;BA.debugLine="cambio2.Visible = True";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._cambio2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 481;BA.debugLine="reunion2.Visible = False";
Debug.ShouldStop(1);
parent.mostCurrent._reunion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 87:
//C
this.state = 88;
 BA.debugLineNum = 483;BA.debugLine="If tipo2 = \"Reunión\" Then";
Debug.ShouldStop(4);
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
 BA.debugLineNum = 484;BA.debugLine="celebracion2.Visible = False";
Debug.ShouldStop(8);
parent.mostCurrent._celebracion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 485;BA.debugLine="cambio2.Visible = False";
Debug.ShouldStop(16);
parent.mostCurrent._cambio2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 486;BA.debugLine="reunion2.Visible = True";
Debug.ShouldStop(32);
parent.mostCurrent._reunion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
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
 BA.debugLineNum = 491;BA.debugLine="If eventos =3 Then";
Debug.ShouldStop(1024);

case 94:
//if
this.state = 129;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(int.class, 3))) { 
this.state = 96;
}if (true) break;

case 96:
//C
this.state = 97;
 BA.debugLineNum = 492;BA.debugLine="tipo3 = tip";
Debug.ShouldStop(2048);
parent._tipo3 = parent._tip;
 BA.debugLineNum = 493;BA.debugLine="If tipo3 = \"00A\" Then";
Debug.ShouldStop(4096);
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
 BA.debugLineNum = 494;BA.debugLine="tipo3 = \"Celebración\"";
Debug.ShouldStop(8192);
parent._tipo3 = BA.ObjectToString("Celebración");
 if (true) break;

case 101:
//C
this.state = 102;
 BA.debugLineNum = 496;BA.debugLine="If tipo3 = \"00B\" Then";
Debug.ShouldStop(32768);
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
 BA.debugLineNum = 497;BA.debugLine="tipo3 = \"Cambio\"";
Debug.ShouldStop(65536);
parent._tipo3 = BA.ObjectToString("Cambio");
 if (true) break;

case 106:
//C
this.state = 107;
 BA.debugLineNum = 499;BA.debugLine="If tipo3 = \"00C\" Then";
Debug.ShouldStop(262144);
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
 BA.debugLineNum = 500;BA.debugLine="tipo3 = \"Reunión\"";
Debug.ShouldStop(524288);
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
 BA.debugLineNum = 504;BA.debugLine="Dim n3 As Notification";
Debug.ShouldStop(8388608);
_n3 = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n3", _n3);
 BA.debugLineNum = 505;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
Debug.ShouldStop(16777216);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 506;BA.debugLine="n3.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(33554432);
_n3.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 507;BA.debugLine="n3.Icon =\"icon\"";
Debug.ShouldStop(67108864);
_n3.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 508;BA.debugLine="n3.SetInfo(tipo3,\"Se llevará acabo el \"&fec";
Debug.ShouldStop(134217728);
_n3.runVoidMethod ("SetInfoNew",ingresodocente.processBA,(Object)(BA.ObjectToCharSequence(parent._tipo3)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fec))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 509;BA.debugLine="n3.Notify(3)";
Debug.ShouldStop(268435456);
_n3.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 3)));
 BA.debugLineNum = 510;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(536870912);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 511;BA.debugLine="evento3.Visible = True";
Debug.ShouldStop(1073741824);
parent.mostCurrent._evento3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 512;BA.debugLine="titulo3.Text = tit";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._titulo3.runMethod(true,"setText",BA.ObjectToCharSequence(parent._tit));
 BA.debugLineNum = 513;BA.debugLine="fecha3.Text = fec";
Debug.ShouldStop(1);
parent.mostCurrent._fecha3.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fec));
 BA.debugLineNum = 514;BA.debugLine="hora3.Text = hor";
Debug.ShouldStop(2);
parent.mostCurrent._hora3.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hor));
 BA.debugLineNum = 515;BA.debugLine="desc3 = des";
Debug.ShouldStop(4);
parent._desc3 = parent._des;
 BA.debugLineNum = 516;BA.debugLine="If tipo3 = \"Celebración\" Then";
Debug.ShouldStop(8);
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
 BA.debugLineNum = 517;BA.debugLine="celebracion3.Visible = True";
Debug.ShouldStop(16);
parent.mostCurrent._celebracion3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 518;BA.debugLine="cambio3.Visible = False";
Debug.ShouldStop(32);
parent.mostCurrent._cambio3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 519;BA.debugLine="reunion3.Visible = False";
Debug.ShouldStop(64);
parent.mostCurrent._reunion3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 117:
//C
this.state = 118;
 BA.debugLineNum = 521;BA.debugLine="If tipo3 = \"Cambio\" Then";
Debug.ShouldStop(256);
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
 BA.debugLineNum = 522;BA.debugLine="celebracion3.Visible = False";
Debug.ShouldStop(512);
parent.mostCurrent._celebracion3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 523;BA.debugLine="cambio3.Visible = True";
Debug.ShouldStop(1024);
parent.mostCurrent._cambio3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 524;BA.debugLine="reunion3.Visible = False";
Debug.ShouldStop(2048);
parent.mostCurrent._reunion3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 122:
//C
this.state = 123;
 BA.debugLineNum = 526;BA.debugLine="If tipo3 = \"Reunión\" Then";
Debug.ShouldStop(8192);
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
 BA.debugLineNum = 527;BA.debugLine="celebracion3.Visible = False";
Debug.ShouldStop(16384);
parent.mostCurrent._celebracion3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 528;BA.debugLine="cambio3.Visible = False";
Debug.ShouldStop(32768);
parent.mostCurrent._cambio3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 529;BA.debugLine="reunion3.Visible = True";
Debug.ShouldStop(65536);
parent.mostCurrent._reunion3.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
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
 BA.debugLineNum = 534;BA.debugLine="If eventos =4 Then";
Debug.ShouldStop(2097152);

case 129:
//if
this.state = 164;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(int.class, 4))) { 
this.state = 131;
}if (true) break;

case 131:
//C
this.state = 132;
 BA.debugLineNum = 535;BA.debugLine="tipo4 = tip";
Debug.ShouldStop(4194304);
parent._tipo4 = parent._tip;
 BA.debugLineNum = 536;BA.debugLine="If tipo4 = \"00A\" Then";
Debug.ShouldStop(8388608);
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
 BA.debugLineNum = 537;BA.debugLine="tipo4 = \"Celebración\"";
Debug.ShouldStop(16777216);
parent._tipo4 = BA.ObjectToString("Celebración");
 if (true) break;

case 136:
//C
this.state = 137;
 BA.debugLineNum = 539;BA.debugLine="If tipo4 = \"00B\" Then";
Debug.ShouldStop(67108864);
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
 BA.debugLineNum = 540;BA.debugLine="tipo4 = \"Cambio\"";
Debug.ShouldStop(134217728);
parent._tipo4 = BA.ObjectToString("Cambio");
 if (true) break;

case 141:
//C
this.state = 142;
 BA.debugLineNum = 542;BA.debugLine="If tipo4 = \"00C\" Then";
Debug.ShouldStop(536870912);
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
 BA.debugLineNum = 543;BA.debugLine="tipo4 = \"Reunión\"";
Debug.ShouldStop(1073741824);
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
 BA.debugLineNum = 547;BA.debugLine="Dim n4 As Notification";
Debug.ShouldStop(4);
_n4 = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n4", _n4);
 BA.debugLineNum = 548;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
Debug.ShouldStop(8);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 549;BA.debugLine="n4.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(16);
_n4.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 550;BA.debugLine="n4.Icon =\"icon\"";
Debug.ShouldStop(32);
_n4.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 551;BA.debugLine="n4.SetInfo(tipo4,\"Se llevará acabo el \"&fec";
Debug.ShouldStop(64);
_n4.runVoidMethod ("SetInfoNew",ingresodocente.processBA,(Object)(BA.ObjectToCharSequence(parent._tipo4)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fec))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 552;BA.debugLine="n4.Notify(4)";
Debug.ShouldStop(128);
_n4.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 4)));
 BA.debugLineNum = 553;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(256);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 554;BA.debugLine="evento4.Visible = True";
Debug.ShouldStop(512);
parent.mostCurrent._evento4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 555;BA.debugLine="titulo4.Text = tit";
Debug.ShouldStop(1024);
parent.mostCurrent._titulo4.runMethod(true,"setText",BA.ObjectToCharSequence(parent._tit));
 BA.debugLineNum = 556;BA.debugLine="fecha4.Text = fec";
Debug.ShouldStop(2048);
parent.mostCurrent._fecha4.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fec));
 BA.debugLineNum = 557;BA.debugLine="hora4.Text = hor";
Debug.ShouldStop(4096);
parent.mostCurrent._hora4.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hor));
 BA.debugLineNum = 558;BA.debugLine="desc4 = des";
Debug.ShouldStop(8192);
parent._desc4 = parent._des;
 BA.debugLineNum = 559;BA.debugLine="If tipo4 = \"Celebración\" Then";
Debug.ShouldStop(16384);
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
 BA.debugLineNum = 560;BA.debugLine="celebracion4.Visible = True";
Debug.ShouldStop(32768);
parent.mostCurrent._celebracion4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 561;BA.debugLine="cambio4.Visible = False";
Debug.ShouldStop(65536);
parent.mostCurrent._cambio4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 562;BA.debugLine="reunion4.Visible = False";
Debug.ShouldStop(131072);
parent.mostCurrent._reunion4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 152:
//C
this.state = 153;
 BA.debugLineNum = 564;BA.debugLine="If tipo4 = \"Cambio\" Then";
Debug.ShouldStop(524288);
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
 BA.debugLineNum = 565;BA.debugLine="celebracion4.Visible = False";
Debug.ShouldStop(1048576);
parent.mostCurrent._celebracion4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 566;BA.debugLine="cambio4.Visible = True";
Debug.ShouldStop(2097152);
parent.mostCurrent._cambio4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 567;BA.debugLine="reunion4.Visible = False";
Debug.ShouldStop(4194304);
parent.mostCurrent._reunion4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 157:
//C
this.state = 158;
 BA.debugLineNum = 569;BA.debugLine="If tipo4 = \"Reunión\" Then";
Debug.ShouldStop(16777216);
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
 BA.debugLineNum = 570;BA.debugLine="celebracion4.Visible = False";
Debug.ShouldStop(33554432);
parent.mostCurrent._celebracion4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 571;BA.debugLine="cambio4.Visible = False";
Debug.ShouldStop(67108864);
parent.mostCurrent._cambio4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 572;BA.debugLine="reunion4.Visible = True";
Debug.ShouldStop(134217728);
parent.mostCurrent._reunion4.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
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
 BA.debugLineNum = 578;BA.debugLine="eventos = eventos  + 1";
Debug.ShouldStop(2);
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
 BA.debugLineNum = 582;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","05636308",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
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
 BA.debugLineNum = 585;BA.debugLine="Log(LastException)";
Debug.ShouldStop(256);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","05636311",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingresodocente.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 173:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 587;BA.debugLine="End Sub";
Debug.ShouldStop(1024);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",ingresodocente.processBA, e0.toString());}
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
public static RemoteObject  _retroceder_click() throws Exception{
try {
		Debug.PushSubsStack("retroceder_Click (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,137);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","retroceder_click");}
 BA.debugLineNum = 137;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(256);
 BA.debugLineNum = 138;BA.debugLine="If estado = 1 Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",ingresodocente._estado,BA.numberCast(int.class, 1))) { 
 BA.debugLineNum = 139;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(1024);
ingresodocente.mostCurrent._panel1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 140;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(2048);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 141;BA.debugLine="estado = 0";
Debug.ShouldStop(4096);
ingresodocente._estado = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 143;BA.debugLine="End Sub";
Debug.ShouldStop(16384);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _txtconact_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconact_TextChanged (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,151);
if (RapidSub.canDelegate("txtconact_textchanged")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","txtconact_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 151;BA.debugLine="Sub txtconact_TextChanged (Old As String, New As S";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 152;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 20))) { 
 BA.debugLineNum = 153;BA.debugLine="MsgboxAsync(\"Laconfirmación de la contraseña no";
Debug.ShouldStop(16777216);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresodocente.processBA);
 };
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
public static RemoteObject  _txtconfcon_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconfcon_TextChanged (ingresodocente) ","ingresodocente",2,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,145);
if (RapidSub.canDelegate("txtconfcon_textchanged")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","txtconfcon_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 145;BA.debugLine="Sub txtconfcon_TextChanged (Old As String, New As";
Debug.ShouldStop(65536);
 BA.debugLineNum = 146;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(131072);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(int.class, 20))) { 
 BA.debugLineNum = 147;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
Debug.ShouldStop(262144);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresodocente.processBA);
 };
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
}
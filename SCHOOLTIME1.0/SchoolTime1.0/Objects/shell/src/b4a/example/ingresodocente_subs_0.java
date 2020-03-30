package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ingresodocente_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,68);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 68;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(8);
 BA.debugLineNum = 70;BA.debugLine="Activity.LoadLayout(\"ingresoDocente\")";
Debug.ShouldStop(32);
ingresodocente.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ingresoDocente")),ingresodocente.mostCurrent.activityBA);
 BA.debugLineNum = 71;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"eventoDocente\")";
Debug.ShouldStop(64);
ingresodocente.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingresodocente.mostCurrent.activityBA,(Object)(BA.ObjectToString("EVENTOS")),(Object)(RemoteObject.createImmutable("eventoDocente")));
 BA.debugLineNum = 72;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfilDocente\")";
Debug.ShouldStop(128);
ingresodocente.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingresodocente.mostCurrent.activityBA,(Object)(BA.ObjectToString("PERFIL")),(Object)(RemoteObject.createImmutable("perfilDocente")));
 BA.debugLineNum = 73;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(256);
ingresodocente.mostCurrent._panel1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 74;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(512);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 75;BA.debugLine="evento11.Visible = False";
Debug.ShouldStop(1024);
ingresodocente.mostCurrent._evento11.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 76;BA.debugLine="evento22.Visible= False";
Debug.ShouldStop(2048);
ingresodocente.mostCurrent._evento22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 77;BA.debugLine="evento2.Visible= False";
Debug.ShouldStop(4096);
ingresodocente.mostCurrent._evento2.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 78;BA.debugLine="evento1.Visible=False";
Debug.ShouldStop(8192);
ingresodocente.mostCurrent._evento1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 79;BA.debugLine="Anuncio.Visible= True";
Debug.ShouldStop(16384);
ingresodocente.mostCurrent._anuncio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 80;BA.debugLine="eventos = 0";
Debug.ShouldStop(32768);
ingresodocente._eventos = BA.numberCast(int.class, 0);
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
public static RemoteObject  _activity_pause(RemoteObject _userclosed) throws Exception{
try {
		Debug.PushSubsStack("Activity_Pause (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,87);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 87;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 89;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
		Debug.PushSubsStack("Activity_Resume (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,83);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","activity_resume");}
 BA.debugLineNum = 83;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(262144);
 BA.debugLineNum = 85;BA.debugLine="End Sub";
Debug.ShouldStop(1048576);
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
		Debug.PushSubsStack("btncambiardocente_Click (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,91);
if (RapidSub.canDelegate("btncambiardocente_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","btncambiardocente_click");}
 BA.debugLineNum = 91;BA.debugLine="Sub btncambiardocente_Click";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 92;BA.debugLine="If estado = 0 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("=",ingresodocente._estado,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 93;BA.debugLine="Panel1.Visible = True";
Debug.ShouldStop(268435456);
ingresodocente.mostCurrent._panel1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 94;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(536870912);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 95;BA.debugLine="estado = 1";
Debug.ShouldStop(1073741824);
ingresodocente._estado = BA.numberCast(int.class, 1);
 };
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
public static RemoteObject  _btncambio_click() throws Exception{
try {
		Debug.PushSubsStack("btncambio_Click (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,124);
if (RapidSub.canDelegate("btncambio_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","btncambio_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 124;BA.debugLine="Sub btncambio_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 125;BA.debugLine="If txtconact.Text<>\"\" And txtconnuv.Text<>\"\" And";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("!",ingresodocente.mostCurrent._txtconact.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingresodocente.mostCurrent._txtconnuv.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingresodocente.mostCurrent._txtconfcon.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 126;BA.debugLine="If txtconnuv.Text = txtconfcon.Text Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("=",ingresodocente.mostCurrent._txtconnuv.runMethod(true,"getText"),ingresodocente.mostCurrent._txtconfcon.runMethod(true,"getText"))) { 
 BA.debugLineNum = 127;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
Debug.ShouldStop(1073741824);
_apiaddress = BA.ObjectToString("http://192.168.1.3/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 128;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(-2147483648);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 129;BA.debugLine="job.Initialize(\"\", Me)";
Debug.ShouldStop(1);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingresodocente.processBA,(Object)(BA.ObjectToString("")),(Object)(ingresodocente.getObject()));
 BA.debugLineNum = 130;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tblregistrodo";
Debug.ShouldStop(2);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tblregistrodocente SET contrasenaDocente='"),ingresodocente.mostCurrent._txtconnuv.runMethod(true,"getText"),RemoteObject.createImmutable("' WHERE contrasenaDocente='"),ingresodocente.mostCurrent._txtconact.runMethod(true,"getText"),RemoteObject.createImmutable("'"))));
 }else {
 BA.debugLineNum = 132;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
Debug.ShouldStop(8);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Las contraseñas deben coincidir")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresodocente.processBA);
 };
 }else {
 BA.debugLineNum = 135;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
Debug.ShouldStop(64);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresodocente.processBA);
 };
 BA.debugLineNum = 137;BA.debugLine="End Sub";
Debug.ShouldStop(256);
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
		Debug.PushSubsStack("btncerrardocente_Click (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,99);
if (RapidSub.canDelegate("btncerrardocente_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","btncerrardocente_click");}
 BA.debugLineNum = 99;BA.debugLine="Sub btncerrardocente_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="StartActivity(perfiles)";
Debug.ShouldStop(8);
ingresodocente.mostCurrent.__c.runVoidMethod ("StartActivity",ingresodocente.processBA,(Object)((ingresodocente.mostCurrent._perfiles.getObject())));
 BA.debugLineNum = 101;BA.debugLine="Activity.Finish";
Debug.ShouldStop(16);
ingresodocente.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 102;BA.debugLine="End Sub";
Debug.ShouldStop(32);
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
		Debug.PushSubsStack("CreateNotificationChannel (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,261);
if (RapidSub.canDelegate("createnotificationchannel")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","createnotificationchannel", _importancelevel);}
RemoteObject _p = RemoteObject.declareNull("anywheresoftware.b4a.phone.Phone");
RemoteObject _ctxt = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _channelid = RemoteObject.createImmutable("");
RemoteObject _channel = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
RemoteObject _manager = RemoteObject.declareNull("anywheresoftware.b4j.object.JavaObject");
Debug.locals.put("ImportanceLevel", _importancelevel);
 BA.debugLineNum = 261;BA.debugLine="Sub CreateNotificationChannel(ImportanceLevel As I";
Debug.ShouldStop(16);
 BA.debugLineNum = 262;BA.debugLine="Dim p As Phone";
Debug.ShouldStop(32);
_p = RemoteObject.createNew ("anywheresoftware.b4a.phone.Phone");Debug.locals.put("p", _p);
 BA.debugLineNum = 263;BA.debugLine="If p.SdkVersion >= 26 Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("g",_p.runMethod(true,"getSdkVersion"),BA.numberCast(double.class, 26))) { 
 BA.debugLineNum = 264;BA.debugLine="Dim ctxt As JavaObject";
Debug.ShouldStop(128);
_ctxt = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("ctxt", _ctxt);
 BA.debugLineNum = 265;BA.debugLine="ctxt.InitializeContext";
Debug.ShouldStop(256);
_ctxt.runVoidMethod ("InitializeContext",ingresodocente.processBA);
 BA.debugLineNum = 266;BA.debugLine="Dim channelId As String = \"channel_\"& Importance";
Debug.ShouldStop(512);
_channelid = RemoteObject.concat(RemoteObject.createImmutable("channel_"),_importancelevel);Debug.locals.put("channelId", _channelid);Debug.locals.put("channelId", _channelid);
 BA.debugLineNum = 267;BA.debugLine="Dim channel As JavaObject";
Debug.ShouldStop(1024);
_channel = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");Debug.locals.put("channel", _channel);
 BA.debugLineNum = 268;BA.debugLine="channel.InitializeNewInstance(\"android.app.Notif";
Debug.ShouldStop(2048);
_channel.runVoidMethod ("InitializeNewInstance",(Object)(BA.ObjectToString("android.app.NotificationChannel")),(Object)(RemoteObject.createNewArray("Object",new int[] {3},new Object[] {(_channelid),(ingresodocente.mostCurrent.__c.getField(false,"Application").runMethod(true,"getLabelName")),(_importancelevel)})));
 BA.debugLineNum = 269;BA.debugLine="channel.RunMethod(\"setShowBadge\",Array(False))";
Debug.ShouldStop(4096);
_channel.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("setShowBadge")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(ingresodocente.mostCurrent.__c.getField(true,"False"))})));
 BA.debugLineNum = 271;BA.debugLine="Dim manager As JavaObject = ctxt.RunMethod(\"getS";
Debug.ShouldStop(16384);
_manager = RemoteObject.createNew ("anywheresoftware.b4j.object.JavaObject");
_manager.setObject(_ctxt.runMethod(false,"RunMethod",(Object)(BA.ObjectToString("getSystemService")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(RemoteObject.createImmutable("notification"))}))));Debug.locals.put("manager", _manager);
 BA.debugLineNum = 272;BA.debugLine="manager.RunMethod(\"createNotificationChannel\",Ar";
Debug.ShouldStop(32768);
_manager.runVoidMethod ("RunMethod",(Object)(BA.ObjectToString("createNotificationChannel")),(Object)(RemoteObject.createNewArray("Object",new int[] {1},new Object[] {(_channel.getObject())})));
 };
 BA.debugLineNum = 275;BA.debugLine="End Sub";
Debug.ShouldStop(262144);
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
		Debug.PushSubsStack("Enviar_Click (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,223);
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
		Debug.PushSubsStack("Enviar_Click (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,223);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 224;BA.debugLine="If contraseñaD.Text <> \"\" Then";
Debug.ShouldStop(-2147483648);
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
 BA.debugLineNum = 225;BA.debugLine="Try";
Debug.ShouldStop(1);
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
 BA.debugLineNum = 226;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
Debug.ShouldStop(2);
_apiaddress = BA.ObjectToString("http://192.168.1.3/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 227;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(4);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 228;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(8);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingresodocente.processBA,(Object)(BA.ObjectToString("")),(Object)(ingresodocente.getObject()));
 BA.debugLineNum = 229;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
Debug.ShouldStop(16);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {10},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("cedula"),BA.ObjectToString("pin"),parent.mostCurrent._contraseñad.runMethod(true,"getText"),BA.ObjectToString("tabla"),BA.ObjectToString("tblregistrodocente"),BA.ObjectToString("codigo"),BA.ObjectToString("codigoDocente"),BA.ObjectToString("cedula"),RemoteObject.createImmutable("cedulaDocente")})));
 BA.debugLineNum = 230;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(32);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingresodocente.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingresodocente", "enviar_click"), (_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 231;BA.debugLine="If js.Success Then";
Debug.ShouldStop(64);
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
 BA.debugLineNum = 232;BA.debugLine="Dim res As String";
Debug.ShouldStop(128);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 233;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
Debug.ShouldStop(256);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 234;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(512);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 235;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(1024);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 236;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(2048);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 237;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(4096);
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
 BA.debugLineNum = 238;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(8192);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 239;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(16384);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 240;BA.debugLine="Log(tabla)";
Debug.ShouldStop(32768);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","74325393",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 241;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(65536);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 242;BA.debugLine="For i=0 To tabla.Size-1";
Debug.ShouldStop(131072);
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
 BA.debugLineNum = 243;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(262144);
_fila.setObject(_tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 244;BA.debugLine="codigo = fila.Get(\"codigoDocente\")";
Debug.ShouldStop(524288);
parent._codigo = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("codigoDocente")))));
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
 BA.debugLineNum = 248;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","74325401",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
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
 BA.debugLineNum = 251;BA.debugLine="Log(LastException)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","74325404",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingresodocente.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
 BA.debugLineNum = 253;BA.debugLine="inicio.Visible =False";
Debug.ShouldStop(268435456);
parent.mostCurrent._inicio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 254;BA.debugLine="Datos.Visible = False";
Debug.ShouldStop(536870912);
parent.mostCurrent._datos.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 25:
//C
this.state = 26;
 BA.debugLineNum = 256;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Necesitas este campo para el ingreso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingresodocente.processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
 BA.debugLineNum = 258;BA.debugLine="remore";
Debug.ShouldStop(2);
_remore();
 BA.debugLineNum = 259;BA.debugLine="End Sub";
Debug.ShouldStop(4);
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
		Debug.PushSubsStack("evento1_Click (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,156);
if (RapidSub.canDelegate("evento1_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","evento1_click");}
 BA.debugLineNum = 156;BA.debugLine="Sub evento1_Click";
Debug.ShouldStop(134217728);
 BA.debugLineNum = 157;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(268435456);
if (RemoteObject.solveBoolean("=",ingresodocente._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 158;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(536870912);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 159;BA.debugLine="evento11.Visible = True";
Debug.ShouldStop(1073741824);
ingresodocente.mostCurrent._evento11.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 160;BA.debugLine="titulo1.Text = titulo.Text";
Debug.ShouldStop(-2147483648);
ingresodocente.mostCurrent._titulo1.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._titulo.runMethod(true,"getText")));
 BA.debugLineNum = 161;BA.debugLine="fecha1.Text = fecha.Text";
Debug.ShouldStop(1);
ingresodocente.mostCurrent._fecha1.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._fecha.runMethod(true,"getText")));
 BA.debugLineNum = 162;BA.debugLine="hora1.Text = hora.Text";
Debug.ShouldStop(2);
ingresodocente.mostCurrent._hora1.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._hora.runMethod(true,"getText")));
 BA.debugLineNum = 163;BA.debugLine="desc1.Text = desc11";
Debug.ShouldStop(4);
ingresodocente.mostCurrent._desc1.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente._desc11));
 BA.debugLineNum = 164;BA.debugLine="If tipo = \"Celebracion\" Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",ingresodocente.mostCurrent._tipo,BA.ObjectToString("Celebracion"))) { 
 BA.debugLineNum = 165;BA.debugLine="icono1.Visible = True";
Debug.ShouldStop(16);
ingresodocente.mostCurrent._icono1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 166;BA.debugLine="icono1C.Visible = False";
Debug.ShouldStop(32);
ingresodocente.mostCurrent._icono1c.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 167;BA.debugLine="icono1R.Visible = False";
Debug.ShouldStop(64);
ingresodocente.mostCurrent._icono1r.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 169;BA.debugLine="If tipo = \"Reunion\" Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",ingresodocente.mostCurrent._tipo,BA.ObjectToString("Reunion"))) { 
 BA.debugLineNum = 170;BA.debugLine="icono1.Visible = False";
Debug.ShouldStop(512);
ingresodocente.mostCurrent._icono1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 171;BA.debugLine="icono1C.Visible = False";
Debug.ShouldStop(1024);
ingresodocente.mostCurrent._icono1c.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 172;BA.debugLine="icono1R.Visible = True";
Debug.ShouldStop(2048);
ingresodocente.mostCurrent._icono1r.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 174;BA.debugLine="If tipo = \"Cambio\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",ingresodocente.mostCurrent._tipo,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 175;BA.debugLine="icono1.Visible = False";
Debug.ShouldStop(16384);
ingresodocente.mostCurrent._icono1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 176;BA.debugLine="icono1C.Visible = True";
Debug.ShouldStop(32768);
ingresodocente.mostCurrent._icono1c.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 177;BA.debugLine="icono1R.Visible = False";
Debug.ShouldStop(65536);
ingresodocente.mostCurrent._icono1r.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 181;BA.debugLine="event = 1";
Debug.ShouldStop(1048576);
ingresodocente._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 183;BA.debugLine="End Sub";
Debug.ShouldStop(4194304);
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
		Debug.PushSubsStack("evento2_Click (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,194);
if (RapidSub.canDelegate("evento2_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","evento2_click");}
 BA.debugLineNum = 194;BA.debugLine="Sub evento2_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 195;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",ingresodocente._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 196;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(8);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 197;BA.debugLine="evento22.Visible = True";
Debug.ShouldStop(16);
ingresodocente.mostCurrent._evento22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 198;BA.debugLine="titulo22.Text = titulo2.Text";
Debug.ShouldStop(32);
ingresodocente.mostCurrent._titulo22.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._titulo2.runMethod(true,"getText")));
 BA.debugLineNum = 199;BA.debugLine="fecha22.Text = fecha2.Text";
Debug.ShouldStop(64);
ingresodocente.mostCurrent._fecha22.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._fecha2.runMethod(true,"getText")));
 BA.debugLineNum = 200;BA.debugLine="hora22.Text = hora2.Text";
Debug.ShouldStop(128);
ingresodocente.mostCurrent._hora22.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente.mostCurrent._hora2.runMethod(true,"getText")));
 BA.debugLineNum = 201;BA.debugLine="descripcion22.Text = desc2";
Debug.ShouldStop(256);
ingresodocente.mostCurrent._descripcion22.runMethod(true,"setText",BA.ObjectToCharSequence(ingresodocente._desc2));
 BA.debugLineNum = 202;BA.debugLine="If tipo2 = \"Celebracion\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo2,BA.ObjectToString("Celebracion"))) { 
 BA.debugLineNum = 203;BA.debugLine="celebracion22.Visible = True";
Debug.ShouldStop(1024);
ingresodocente.mostCurrent._celebracion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 204;BA.debugLine="cambio22.Visible = False";
Debug.ShouldStop(2048);
ingresodocente.mostCurrent._cambio22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 205;BA.debugLine="reunion22.Visible = False";
Debug.ShouldStop(4096);
ingresodocente.mostCurrent._reunion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 207;BA.debugLine="If tipo2 = \"Reunion\" Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo2,BA.ObjectToString("Reunion"))) { 
 BA.debugLineNum = 208;BA.debugLine="celebracion22.Visible = False";
Debug.ShouldStop(32768);
ingresodocente.mostCurrent._celebracion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 209;BA.debugLine="cambio22.Visible = False";
Debug.ShouldStop(65536);
ingresodocente.mostCurrent._cambio22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 210;BA.debugLine="reunion22.Visible = True";
Debug.ShouldStop(131072);
ingresodocente.mostCurrent._reunion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 212;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",ingresodocente._tipo2,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 213;BA.debugLine="celebracion22.Visible = False";
Debug.ShouldStop(1048576);
ingresodocente.mostCurrent._celebracion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 214;BA.debugLine="cambio22.Visible = True";
Debug.ShouldStop(2097152);
ingresodocente.mostCurrent._cambio22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 215;BA.debugLine="reunion22.Visible = False";
Debug.ShouldStop(4194304);
ingresodocente.mostCurrent._reunion22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 219;BA.debugLine="event = 1";
Debug.ShouldStop(67108864);
ingresodocente._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 221;BA.debugLine="End Sub";
Debug.ShouldStop(268435456);
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
ingresodocente.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private btncambiardocente As Button";
ingresodocente.mostCurrent._btncambiardocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private btncerrardocente As Button";
ingresodocente.mostCurrent._btncerrardocente = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private Panel1 As Panel";
ingresodocente.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Dim estado As Int = 0";
ingresodocente._estado = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 23;BA.debugLine="Private inicio As Panel";
ingresodocente.mostCurrent._inicio = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private retroceder As Label";
ingresodocente.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private txtconnuv As EditText";
ingresodocente.mostCurrent._txtconnuv = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private btncambio As Button";
ingresodocente.mostCurrent._btncambio = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private txtconact As EditText";
ingresodocente.mostCurrent._txtconact = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private txtconfcon As EditText";
ingresodocente.mostCurrent._txtconfcon = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private evento1 As Panel";
ingresodocente.mostCurrent._evento1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private fecha As Label";
ingresodocente.mostCurrent._fecha = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private titulo As Label";
ingresodocente.mostCurrent._titulo = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private cambio As ImageView";
ingresodocente.mostCurrent._cambio = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private celebracion As ImageView";
ingresodocente.mostCurrent._celebracion = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private reunion As ImageView";
ingresodocente.mostCurrent._reunion = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Dim tipo As String";
ingresodocente.mostCurrent._tipo = RemoteObject.createImmutable("");
 //BA.debugLineNum = 36;BA.debugLine="Private hora As Label";
ingresodocente.mostCurrent._hora = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private icono1 As ImageView";
ingresodocente.mostCurrent._icono1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private titulo1 As Label";
ingresodocente.mostCurrent._titulo1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private fecha1 As Label";
ingresodocente.mostCurrent._fecha1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private desc1 As Label";
ingresodocente.mostCurrent._desc1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private hora1 As Label";
ingresodocente.mostCurrent._hora1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private icono1R As ImageView";
ingresodocente.mostCurrent._icono1r = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private icono1C As ImageView";
ingresodocente.mostCurrent._icono1c = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private evento11 As Panel";
ingresodocente.mostCurrent._evento11 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private Anuncio As Label";
ingresodocente.mostCurrent._anuncio = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private evento2 As Panel";
ingresodocente.mostCurrent._evento2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private cambio2 As ImageView";
ingresodocente.mostCurrent._cambio2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private celebracion2 As ImageView";
ingresodocente.mostCurrent._celebracion2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private reunion2 As ImageView";
ingresodocente.mostCurrent._reunion2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private titulo2 As Label";
ingresodocente.mostCurrent._titulo2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private fecha2 As Label";
ingresodocente.mostCurrent._fecha2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private hora2 As Label";
ingresodocente.mostCurrent._hora2 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private cambio22 As ImageView";
ingresodocente.mostCurrent._cambio22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private celebracion22 As ImageView";
ingresodocente.mostCurrent._celebracion22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private descripcion22 As Label";
ingresodocente.mostCurrent._descripcion22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private evento22 As Panel";
ingresodocente.mostCurrent._evento22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private fecha22 As Label";
ingresodocente.mostCurrent._fecha22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private hora22 As Label";
ingresodocente.mostCurrent._hora22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private reunion22 As ImageView";
ingresodocente.mostCurrent._reunion22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private titulo22 As Label";
ingresodocente.mostCurrent._titulo22 = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private Datos As Panel";
ingresodocente.mostCurrent._datos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="Private contraseñaD As EditText";
ingresodocente.mostCurrent._contraseñad = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 63;BA.debugLine="Private Enviar As Button";
ingresodocente.mostCurrent._enviar = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 64;BA.debugLine="Dim notifica As Notification";
ingresodocente.mostCurrent._notifica = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");
 //BA.debugLineNum = 65;BA.debugLine="Dim fechaComplet As String";
ingresodocente.mostCurrent._fechacomplet = RemoteObject.createImmutable("");
 //BA.debugLineNum = 66;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _inicio_click() throws Exception{
try {
		Debug.PushSubsStack("inicio_Click (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,185);
if (RapidSub.canDelegate("inicio_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","inicio_click");}
 BA.debugLineNum = 185;BA.debugLine="Sub inicio_Click";
Debug.ShouldStop(16777216);
 BA.debugLineNum = 186;BA.debugLine="If event = 1 Then";
Debug.ShouldStop(33554432);
if (RemoteObject.solveBoolean("=",ingresodocente._event,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 187;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(67108864);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 188;BA.debugLine="evento11.Visible = False";
Debug.ShouldStop(134217728);
ingresodocente.mostCurrent._evento11.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 189;BA.debugLine="evento22.Visible = False";
Debug.ShouldStop(268435456);
ingresodocente.mostCurrent._evento22.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 190;BA.debugLine="event = 0";
Debug.ShouldStop(536870912);
ingresodocente._event = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 192;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("JobDone (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,139);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 139;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(2048);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 141;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
Debug.ShouldStop(4096);
ingresodocente.mostCurrent.__c.runVoidMethod ("LogImpl","74063234",RemoteObject.createImmutable("OK, se actualizó correctamente"),0);
 BA.debugLineNum = 142;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
Debug.ShouldStop(8192);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingresodocente.processBA);
 BA.debugLineNum = 143;BA.debugLine="txtconact.Text=\"\"";
Debug.ShouldStop(16384);
ingresodocente.mostCurrent._txtconact.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 144;BA.debugLine="txtconnuv.Text=\"\"";
Debug.ShouldStop(32768);
ingresodocente.mostCurrent._txtconnuv.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 145;BA.debugLine="txtconfcon.Text=\"\"";
Debug.ShouldStop(65536);
ingresodocente.mostCurrent._txtconfcon.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 146;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(131072);
ingresodocente.mostCurrent._panel1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 147;BA.debugLine="inicio.Visible=False";
Debug.ShouldStop(262144);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 148;BA.debugLine="estado=0";
Debug.ShouldStop(524288);
ingresodocente._estado = BA.numberCast(int.class, 0);
 }else {
 BA.debugLineNum = 150;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(2097152);
ingresodocente.mostCurrent.__c.runVoidMethod ("LogImpl","74063243",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 151;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(4194304);
ingresodocente.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(ingresodocente.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 153;BA.debugLine="Job.Release";
Debug.ShouldStop(16777216);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 154;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
 //BA.debugLineNum = 10;BA.debugLine="Dim tit,fec,tip,hor,des,desc11,desc2,codigo As St";
ingresodocente._tit = RemoteObject.createImmutable("");
ingresodocente._fec = RemoteObject.createImmutable("");
ingresodocente._tip = RemoteObject.createImmutable("");
ingresodocente._hor = RemoteObject.createImmutable("");
ingresodocente._des = RemoteObject.createImmutable("");
ingresodocente._desc11 = RemoteObject.createImmutable("");
ingresodocente._desc2 = RemoteObject.createImmutable("");
ingresodocente._codigo = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Dim tipo2 As String";
ingresodocente._tipo2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 12;BA.debugLine="Dim eventos As Int = 0";
ingresodocente._eventos = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _remore() throws Exception{
try {
		Debug.PushSubsStack("remore (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,276);
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
int step27;
int limit27;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("remore (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,276);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 277;BA.debugLine="If eventos = 0 Then";
Debug.ShouldStop(1048576);
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
 BA.debugLineNum = 278;BA.debugLine="Anuncio.Visible = True";
Debug.ShouldStop(2097152);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 280;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(8388608);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;
;
 BA.debugLineNum = 282;BA.debugLine="Try";
Debug.ShouldStop(33554432);

case 6:
//try
this.state = 71;
this.catchState = 70;
this.state = 8;
if (true) break;

case 8:
//C
this.state = 9;
this.catchState = 70;
 BA.debugLineNum = 283;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/s";
Debug.ShouldStop(67108864);
_apiaddress = BA.ObjectToString("http://192.168.1.3/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 284;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(134217728);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 285;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(268435456);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingresodocente.processBA,(Object)(BA.ObjectToString("")),(Object)(ingresodocente.getObject()));
 BA.debugLineNum = 286;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
Debug.ShouldStop(536870912);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("evento"),BA.ObjectToString("codigo"),parent._codigo})));
 BA.debugLineNum = 287;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingresodocente.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingresodocente", "remore"), (_js));
this.state = 72;
return;
case 72:
//C
this.state = 9;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 288;BA.debugLine="If js.Success Then";
Debug.ShouldStop(-2147483648);
if (true) break;

case 9:
//if
this.state = 68;
if (_js.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
this.state = 11;
}else {
this.state = 67;
}if (true) break;

case 11:
//C
this.state = 12;
 BA.debugLineNum = 289;BA.debugLine="Dim res As String";
Debug.ShouldStop(1);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 290;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
Debug.ShouldStop(2);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 291;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(4);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 292;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(8);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 293;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(16);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 294;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(32);
if (true) break;

case 12:
//if
this.state = 65;
if ((RemoteObject.solveBoolean(">",_res.runMethod(true,"length"),BA.numberCast(double.class, 0)))) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
 BA.debugLineNum = 295;BA.debugLine="eventos = 1";
Debug.ShouldStop(64);
parent._eventos = BA.numberCast(int.class, 1);
 BA.debugLineNum = 296;BA.debugLine="If eventos = 1 Then";
Debug.ShouldStop(128);
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
 BA.debugLineNum = 297;BA.debugLine="evento1.Visible = True";
Debug.ShouldStop(256);
parent.mostCurrent._evento1.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 18:
//C
this.state = 19;
;
 BA.debugLineNum = 299;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(1024);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 300;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(2048);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 301;BA.debugLine="Log(tabla)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","74456473",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 302;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(8192);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 303;BA.debugLine="For i=0 To tabla.Size-1";
Debug.ShouldStop(16384);
if (true) break;

case 19:
//for
this.state = 64;
step27 = 1;
limit27 = RemoteObject.solve(new RemoteObject[] {_tabla.runMethod(true,"getSize"),RemoteObject.createImmutable(1)}, "-",1, 1).<Integer>get().intValue();
_i = 0 ;
Debug.locals.put("i", _i);
this.state = 73;
if (true) break;

case 73:
//C
this.state = 64;
if ((step27 > 0 && _i <= limit27) || (step27 < 0 && _i >= limit27)) this.state = 21;
if (true) break;

case 74:
//C
this.state = 73;
_i = ((int)(0 + _i + step27)) ;
Debug.locals.put("i", _i);
if (true) break;

case 21:
//C
this.state = 22;
 BA.debugLineNum = 304;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(32768);
_fila.setObject(_tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 305;BA.debugLine="tit = fila.Get(\"titulo\")";
Debug.ShouldStop(65536);
parent._tit = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("titulo")))));
 BA.debugLineNum = 306;BA.debugLine="tip = fila.Get(\"tipo\")";
Debug.ShouldStop(131072);
parent._tip = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("tipo")))));
 BA.debugLineNum = 307;BA.debugLine="fec = fila.Get(\"fecha\")";
Debug.ShouldStop(262144);
parent._fec = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));
 BA.debugLineNum = 308;BA.debugLine="hor = fila.Get(\"hora\")";
Debug.ShouldStop(524288);
parent._hor = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("hora")))));
 BA.debugLineNum = 309;BA.debugLine="des = fila.Get(\"descripcion\")";
Debug.ShouldStop(1048576);
parent._des = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("descripcion")))));
 BA.debugLineNum = 310;BA.debugLine="If eventos =1 Then";
Debug.ShouldStop(2097152);
if (true) break;

case 22:
//if
this.state = 63;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(double.class, 1))) { 
this.state = 24;
}else {
this.state = 42;
}if (true) break;

case 24:
//C
this.state = 25;
 BA.debugLineNum = 311;BA.debugLine="Dim n As Notification";
Debug.ShouldStop(4194304);
_n = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n", _n);
 BA.debugLineNum = 312;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(8388608);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 313;BA.debugLine="n.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(16777216);
_n.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 314;BA.debugLine="n.Icon =\"icon\"";
Debug.ShouldStop(33554432);
_n.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 315;BA.debugLine="n.SetInfo(tip,\"Se llevará acabo el \"&fec,Mai";
Debug.ShouldStop(67108864);
_n.runVoidMethod ("SetInfoNew",ingresodocente.processBA,(Object)(BA.ObjectToCharSequence(parent._tip)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fec))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 316;BA.debugLine="n.Notify(1)";
Debug.ShouldStop(134217728);
_n.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 1)));
 BA.debugLineNum = 317;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(268435456);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 318;BA.debugLine="evento2.Visible = False";
Debug.ShouldStop(536870912);
parent.mostCurrent._evento2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 319;BA.debugLine="titulo.Text = tit";
Debug.ShouldStop(1073741824);
parent.mostCurrent._titulo.runMethod(true,"setText",BA.ObjectToCharSequence(parent._tit));
 BA.debugLineNum = 320;BA.debugLine="fecha.Text = fec";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._fecha.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fec));
 BA.debugLineNum = 321;BA.debugLine="tipo = tip";
Debug.ShouldStop(1);
parent.mostCurrent._tipo = parent._tip;
 BA.debugLineNum = 322;BA.debugLine="hora.Text = hor";
Debug.ShouldStop(2);
parent.mostCurrent._hora.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hor));
 BA.debugLineNum = 323;BA.debugLine="desc11 = des";
Debug.ShouldStop(4);
parent._desc11 = parent._des;
 BA.debugLineNum = 324;BA.debugLine="If tipo = \"Celebracion\" Then";
Debug.ShouldStop(8);
if (true) break;

case 25:
//if
this.state = 40;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._tipo,BA.ObjectToString("Celebracion"))) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 40;
 BA.debugLineNum = 325;BA.debugLine="celebracion.Visible = True";
Debug.ShouldStop(16);
parent.mostCurrent._celebracion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 326;BA.debugLine="cambio.Visible = False";
Debug.ShouldStop(32);
parent.mostCurrent._cambio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 327;BA.debugLine="reunion.Visible = False";
Debug.ShouldStop(64);
parent.mostCurrent._reunion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 29:
//C
this.state = 30;
 BA.debugLineNum = 329;BA.debugLine="If tipo = \"Cambio\" Then";
Debug.ShouldStop(256);
if (true) break;

case 30:
//if
this.state = 39;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._tipo,BA.ObjectToString("Cambio"))) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 39;
 BA.debugLineNum = 330;BA.debugLine="celebracion.Visible = False";
Debug.ShouldStop(512);
parent.mostCurrent._celebracion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 331;BA.debugLine="cambio.Visible = True";
Debug.ShouldStop(1024);
parent.mostCurrent._cambio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 332;BA.debugLine="reunion.Visible = False";
Debug.ShouldStop(2048);
parent.mostCurrent._reunion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 34:
//C
this.state = 35;
 BA.debugLineNum = 334;BA.debugLine="If tipo = \"Reunion\" Then";
Debug.ShouldStop(8192);
if (true) break;

case 35:
//if
this.state = 38;
if (RemoteObject.solveBoolean("=",parent.mostCurrent._tipo,BA.ObjectToString("Reunion"))) { 
this.state = 37;
}if (true) break;

case 37:
//C
this.state = 38;
 BA.debugLineNum = 335;BA.debugLine="celebracion.Visible = False";
Debug.ShouldStop(16384);
parent.mostCurrent._celebracion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 336;BA.debugLine="cambio.Visible = False";
Debug.ShouldStop(32768);
parent.mostCurrent._cambio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 337;BA.debugLine="reunion.Visible = True";
Debug.ShouldStop(65536);
parent.mostCurrent._reunion.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
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
this.state = 63;
;
 if (true) break;

case 42:
//C
this.state = 43;
 BA.debugLineNum = 342;BA.debugLine="If eventos =2 Then";
Debug.ShouldStop(2097152);
if (true) break;

case 43:
//if
this.state = 62;
if (RemoteObject.solveBoolean("=",parent._eventos,BA.numberCast(double.class, 2))) { 
this.state = 45;
}if (true) break;

case 45:
//C
this.state = 46;
 BA.debugLineNum = 343;BA.debugLine="Dim n1 As Notification";
Debug.ShouldStop(4194304);
_n1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.NotificationWrapper");Debug.locals.put("n1", _n1);
 BA.debugLineNum = 344;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
Debug.ShouldStop(8388608);
_createnotificationchannel(_n.getField(true,"IMPORTANCE_HIGH"));
 BA.debugLineNum = 345;BA.debugLine="n1.Initialize2(n.IMPORTANCE_HIGH)";
Debug.ShouldStop(16777216);
_n1.runVoidMethod ("Initialize2",(Object)(_n.getField(true,"IMPORTANCE_HIGH")));
 BA.debugLineNum = 346;BA.debugLine="n1.Icon =\"icon\"";
Debug.ShouldStop(33554432);
_n1.runVoidMethod ("setIcon",BA.ObjectToString("icon"));
 BA.debugLineNum = 347;BA.debugLine="n1.SetInfo(tip,\"Se llevará acabo el \"&fec,M";
Debug.ShouldStop(67108864);
_n1.runVoidMethod ("SetInfoNew",ingresodocente.processBA,(Object)(BA.ObjectToCharSequence(parent._tip)),(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Se llevará acabo el "),parent._fec))),(Object)((parent.mostCurrent._main.getObject())));
 BA.debugLineNum = 348;BA.debugLine="n1.Notify(2)";
Debug.ShouldStop(134217728);
_n1.runVoidMethod ("Notify",(Object)(BA.numberCast(int.class, 2)));
 BA.debugLineNum = 349;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(268435456);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 350;BA.debugLine="evento2.Visible = True";
Debug.ShouldStop(536870912);
parent.mostCurrent._evento2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 351;BA.debugLine="titulo2.Text = tit";
Debug.ShouldStop(1073741824);
parent.mostCurrent._titulo2.runMethod(true,"setText",BA.ObjectToCharSequence(parent._tit));
 BA.debugLineNum = 352;BA.debugLine="fecha2.Text = fec";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._fecha2.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fec));
 BA.debugLineNum = 353;BA.debugLine="tipo2 = tip";
Debug.ShouldStop(1);
parent._tipo2 = parent._tip;
 BA.debugLineNum = 354;BA.debugLine="hora2.Text = hor";
Debug.ShouldStop(2);
parent.mostCurrent._hora2.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hor));
 BA.debugLineNum = 355;BA.debugLine="desc2 = des";
Debug.ShouldStop(4);
parent._desc2 = parent._des;
 BA.debugLineNum = 356;BA.debugLine="If tipo2 = \"Celebracion\" Then";
Debug.ShouldStop(8);
if (true) break;

case 46:
//if
this.state = 61;
if (RemoteObject.solveBoolean("=",parent._tipo2,BA.ObjectToString("Celebracion"))) { 
this.state = 48;
}else {
this.state = 50;
}if (true) break;

case 48:
//C
this.state = 61;
 BA.debugLineNum = 357;BA.debugLine="celebracion2.Visible = True";
Debug.ShouldStop(16);
parent.mostCurrent._celebracion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 358;BA.debugLine="cambio2.Visible = False";
Debug.ShouldStop(32);
parent.mostCurrent._cambio2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 359;BA.debugLine="reunion2.Visible = False";
Debug.ShouldStop(64);
parent.mostCurrent._reunion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 50:
//C
this.state = 51;
 BA.debugLineNum = 361;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(256);
if (true) break;

case 51:
//if
this.state = 60;
if (RemoteObject.solveBoolean("=",parent._tipo2,BA.ObjectToString("Cambio"))) { 
this.state = 53;
}else {
this.state = 55;
}if (true) break;

case 53:
//C
this.state = 60;
 BA.debugLineNum = 362;BA.debugLine="celebracion2.Visible = False";
Debug.ShouldStop(512);
parent.mostCurrent._celebracion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 363;BA.debugLine="cambio2.Visible = True";
Debug.ShouldStop(1024);
parent.mostCurrent._cambio2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 364;BA.debugLine="reunion2.Visible = False";
Debug.ShouldStop(2048);
parent.mostCurrent._reunion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 55:
//C
this.state = 56;
 BA.debugLineNum = 366;BA.debugLine="If tipo2 = \"Reunion\" Then";
Debug.ShouldStop(8192);
if (true) break;

case 56:
//if
this.state = 59;
if (RemoteObject.solveBoolean("=",parent._tipo2,BA.ObjectToString("Reunion"))) { 
this.state = 58;
}if (true) break;

case 58:
//C
this.state = 59;
 BA.debugLineNum = 367;BA.debugLine="celebracion2.Visible = False";
Debug.ShouldStop(16384);
parent.mostCurrent._celebracion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 368;BA.debugLine="cambio2.Visible = False";
Debug.ShouldStop(32768);
parent.mostCurrent._cambio2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 369;BA.debugLine="reunion2.Visible = True";
Debug.ShouldStop(65536);
parent.mostCurrent._reunion2.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 59:
//C
this.state = 60;
;
 if (true) break;

case 60:
//C
this.state = 61;
;
 if (true) break;

case 61:
//C
this.state = 62;
;
 if (true) break;

case 62:
//C
this.state = 63;
;
 if (true) break;

case 63:
//C
this.state = 74;
;
 BA.debugLineNum = 375;BA.debugLine="eventos = eventos  + 1";
Debug.ShouldStop(4194304);
parent._eventos = RemoteObject.solve(new RemoteObject[] {parent._eventos,RemoteObject.createImmutable(1)}, "+",1, 1);
 if (true) break;
if (true) break;

case 64:
//C
this.state = 65;
Debug.locals.put("i", _i);
;
 if (true) break;

case 65:
//C
this.state = 68;
;
 if (true) break;

case 67:
//C
this.state = 68;
 BA.debugLineNum = 379;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","74456551",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 if (true) break;

case 68:
//C
this.state = 71;
;
 Debug.CheckDeviceExceptions();
if (true) break;

case 70:
//C
this.state = 71;
this.catchState = 0;
 BA.debugLineNum = 382;BA.debugLine="Log(LastException)";
Debug.ShouldStop(536870912);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","74456554",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingresodocente.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 71:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 384;BA.debugLine="End Sub";
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
public static RemoteObject  _retroceder_click() throws Exception{
try {
		Debug.PushSubsStack("retroceder_Click (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,104);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","retroceder_click");}
 BA.debugLineNum = 104;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(128);
 BA.debugLineNum = 105;BA.debugLine="If estado = 1 Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",ingresodocente._estado,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 106;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(512);
ingresodocente.mostCurrent._panel1.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 107;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(1024);
ingresodocente.mostCurrent._inicio.runMethod(true,"setVisible",ingresodocente.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 108;BA.debugLine="estado = 0";
Debug.ShouldStop(2048);
ingresodocente._estado = BA.numberCast(int.class, 0);
 };
 BA.debugLineNum = 110;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("txtconact_TextChanged (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,118);
if (RapidSub.canDelegate("txtconact_textchanged")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","txtconact_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 118;BA.debugLine="Sub txtconact_TextChanged (Old As String, New As S";
Debug.ShouldStop(2097152);
 BA.debugLineNum = 119;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(4194304);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 120;BA.debugLine="MsgboxAsync(\"Laconfirmación de la contraseña no";
Debug.ShouldStop(8388608);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresodocente.processBA);
 };
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
public static RemoteObject  _txtconfcon_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconfcon_TextChanged (ingresodocente) ","ingresodocente",5,ingresodocente.mostCurrent.activityBA,ingresodocente.mostCurrent,112);
if (RapidSub.canDelegate("txtconfcon_textchanged")) { return b4a.example.ingresodocente.remoteMe.runUserSub(false, "ingresodocente","txtconfcon_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 112;BA.debugLine="Sub txtconfcon_TextChanged (Old As String, New As";
Debug.ShouldStop(32768);
 BA.debugLineNum = 113;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 114;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
Debug.ShouldStop(131072);
ingresodocente.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresodocente.processBA);
 };
 BA.debugLineNum = 116;BA.debugLine="End Sub";
Debug.ShouldStop(524288);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
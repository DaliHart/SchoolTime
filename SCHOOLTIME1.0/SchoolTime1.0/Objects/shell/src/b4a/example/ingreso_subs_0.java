package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ingreso_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,64);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="Activity.LoadLayout(\"ingreso\")";
Debug.ShouldStop(2);
ingreso.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ingreso")),ingreso.mostCurrent.activityBA);
 BA.debugLineNum = 67;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"evento\")";
Debug.ShouldStop(4);
ingreso.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingreso.mostCurrent.activityBA,(Object)(BA.ObjectToString("EVENTOS")),(Object)(RemoteObject.createImmutable("evento")));
 BA.debugLineNum = 68;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfil\")";
Debug.ShouldStop(8);
ingreso.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingreso.mostCurrent.activityBA,(Object)(BA.ObjectToString("PERFIL")),(Object)(RemoteObject.createImmutable("perfil")));
 BA.debugLineNum = 69;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(16);
ingreso.mostCurrent._panel1.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 70;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(32);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 71;BA.debugLine="evento1A.Visible=False";
Debug.ShouldStop(64);
ingreso.mostCurrent._evento1a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 72;BA.debugLine="evento2A.Visible=False";
Debug.ShouldStop(128);
ingreso.mostCurrent._evento2a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 73;BA.debugLine="evento11A.Visible=False";
Debug.ShouldStop(256);
ingreso.mostCurrent._evento11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 74;BA.debugLine="evento22A.Visible=False";
Debug.ShouldStop(512);
ingreso.mostCurrent._evento22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 75;BA.debugLine="Anuncio.Visible=False";
Debug.ShouldStop(1024);
ingreso.mostCurrent._anuncio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 76;BA.debugLine="eventos = 0";
Debug.ShouldStop(2048);
ingreso._eventos = BA.numberCast(int.class, 0);
 BA.debugLineNum = 77;BA.debugLine="End Sub";
Debug.ShouldStop(4096);
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
		Debug.PushSubsStack("Activity_Pause (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,83);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 83;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
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
public static RemoteObject  _activity_resume() throws Exception{
try {
		Debug.PushSubsStack("Activity_Resume (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,79);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","activity_resume");}
 BA.debugLineNum = 79;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(16384);
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
public static RemoteObject  _btncambiaracudiente_click() throws Exception{
try {
		Debug.PushSubsStack("btncambiaracudiente_Click (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,87);
if (RapidSub.canDelegate("btncambiaracudiente_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","btncambiaracudiente_click");}
 BA.debugLineNum = 87;BA.debugLine="Sub btncambiaracudiente_Click";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="If estado = 0 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("=",ingreso._estado,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 89;BA.debugLine="Panel1.Visible = True";
Debug.ShouldStop(16777216);
ingreso.mostCurrent._panel1.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 90;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(33554432);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 91;BA.debugLine="estado = 1";
Debug.ShouldStop(67108864);
ingreso._estado = BA.numberCast(int.class, 1);
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
public static RemoteObject  _btncambio_click() throws Exception{
try {
		Debug.PushSubsStack("btncambio_Click (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,129);
if (RapidSub.canDelegate("btncambio_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","btncambio_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 129;BA.debugLine="Sub btncambio_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 130;BA.debugLine="If txtconact.Text<>\"\" And txtconnuv.Text<>\"\" And";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("!",ingreso.mostCurrent._txtconact.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingreso.mostCurrent._txtconnuv.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingreso.mostCurrent._txtconfcon.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 131;BA.debugLine="If txtconnuv.Text = txtconfcon.Text Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",ingreso.mostCurrent._txtconnuv.runMethod(true,"getText"),ingreso.mostCurrent._txtconfcon.runMethod(true,"getText"))) { 
 BA.debugLineNum = 132;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
Debug.ShouldStop(8);
_apiaddress = BA.ObjectToString("http://192.168.1.3/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 133;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(16);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 134;BA.debugLine="job.Initialize(\"\", Me)";
Debug.ShouldStop(32);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingreso.processBA,(Object)(BA.ObjectToString("")),(Object)(ingreso.getObject()));
 BA.debugLineNum = 135;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tblregistroac";
Debug.ShouldStop(64);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tblregistroacudiente SET contrasenaAcudiente='"),ingreso.mostCurrent._txtconnuv.runMethod(true,"getText"),RemoteObject.createImmutable("' WHERE contrasenaAcudiente='"),ingreso.mostCurrent._txtconact.runMethod(true,"getText"),RemoteObject.createImmutable("'"))));
 }else {
 BA.debugLineNum = 137;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
Debug.ShouldStop(256);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Las contraseñas deben coincidir")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingreso.processBA);
 };
 }else {
 BA.debugLineNum = 140;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
Debug.ShouldStop(2048);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingreso.processBA);
 };
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
public static RemoteObject  _btncerraracudiente_click() throws Exception{
try {
		Debug.PushSubsStack("btncerraracudiente_Click (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,95);
if (RapidSub.canDelegate("btncerraracudiente_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","btncerraracudiente_click");}
 BA.debugLineNum = 95;BA.debugLine="Sub btncerraracudiente_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 96;BA.debugLine="StartActivity(perfiles)";
Debug.ShouldStop(-2147483648);
ingreso.mostCurrent.__c.runVoidMethod ("StartActivity",ingreso.processBA,(Object)((ingreso.mostCurrent._perfiles.getObject())));
 BA.debugLineNum = 97;BA.debugLine="Activity.Finish";
Debug.ShouldStop(1);
ingreso.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 98;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("cerrar_Click (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,100);
if (RapidSub.canDelegate("cerrar_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","cerrar_click");}
 BA.debugLineNum = 100;BA.debugLine="Sub cerrar_Click";
Debug.ShouldStop(8);
 BA.debugLineNum = 101;BA.debugLine="If estado = 1 Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",ingreso._estado,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 102;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(32);
ingreso.mostCurrent._panel1.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 103;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(64);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 104;BA.debugLine="estado = 0";
Debug.ShouldStop(128);
ingreso._estado = BA.numberCast(int.class, 0);
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
public static void  _enviara_click() throws Exception{
try {
		Debug.PushSubsStack("EnviarA_Click (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,220);
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
		Debug.PushSubsStack("EnviarA_Click (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,220);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 221;BA.debugLine="If contraseñaA.Text <> \"\" Then";
Debug.ShouldStop(268435456);
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
 BA.debugLineNum = 222;BA.debugLine="Try";
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
 BA.debugLineNum = 223;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
Debug.ShouldStop(1073741824);
_apiaddress = BA.ObjectToString("http://192.168.1.3/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 224;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(-2147483648);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 225;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(1);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingreso.processBA,(Object)(BA.ObjectToString("")),(Object)(ingreso.getObject()));
 BA.debugLineNum = 226;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
Debug.ShouldStop(2);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {10},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("cedula"),BA.ObjectToString("pin"),parent.mostCurrent._contraseñaa.runMethod(true,"getText"),BA.ObjectToString("tabla"),BA.ObjectToString("tblregistroacudiente"),BA.ObjectToString("codigo"),BA.ObjectToString("codigoAcudiente"),BA.ObjectToString("cedula"),RemoteObject.createImmutable("cedulaAcudiente")})));
 BA.debugLineNum = 227;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(4);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingreso.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingreso", "enviara_click"), (_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 228;BA.debugLine="If js.Success Then";
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
 BA.debugLineNum = 229;BA.debugLine="Dim res As String";
Debug.ShouldStop(16);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 230;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
Debug.ShouldStop(32);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 231;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(64);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 232;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(128);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 233;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(256);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 234;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(512);
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
 BA.debugLineNum = 235;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(1024);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 236;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(2048);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 237;BA.debugLine="Log(tabla)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","75505041",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 238;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(8192);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 239;BA.debugLine="For i=0 To tabla.Size-1";
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
 BA.debugLineNum = 240;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(32768);
_fila.setObject(_tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 241;BA.debugLine="codigo = fila.Get(\"codigoAcudiente\")";
Debug.ShouldStop(65536);
parent._codigo = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("codigoAcudiente")))));
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
 BA.debugLineNum = 245;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(1048576);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","75505049",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
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
 BA.debugLineNum = 248;BA.debugLine="Log(LastException)";
Debug.ShouldStop(8388608);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","75505052",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingreso.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
 BA.debugLineNum = 250;BA.debugLine="inicio.Visible =False";
Debug.ShouldStop(33554432);
parent.mostCurrent._inicio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 251;BA.debugLine="Datos.Visible = False";
Debug.ShouldStop(67108864);
parent.mostCurrent._datos.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 25:
//C
this.state = 26;
 BA.debugLineNum = 253;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Necesitas este campo para el ingreso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingreso.processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
 BA.debugLineNum = 255;BA.debugLine="remoreA";
Debug.ShouldStop(1073741824);
_remorea();
 BA.debugLineNum = 256;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("evento1A_Click (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,191);
if (RapidSub.canDelegate("evento1a_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","evento1a_click");}
 BA.debugLineNum = 191;BA.debugLine="Sub evento1A_Click";
Debug.ShouldStop(1073741824);
 BA.debugLineNum = 192;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(-2147483648);
if (RemoteObject.solveBoolean("=",ingreso._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 193;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(1);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 194;BA.debugLine="evento11A.Visible = True";
Debug.ShouldStop(2);
ingreso.mostCurrent._evento11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 195;BA.debugLine="titulo11A.Text = titulo1A.Text";
Debug.ShouldStop(4);
ingreso.mostCurrent._titulo11a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._titulo1a.runMethod(true,"getText")));
 BA.debugLineNum = 196;BA.debugLine="fecha11A.Text = fecha1A.Text";
Debug.ShouldStop(8);
ingreso.mostCurrent._fecha11a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._fecha1a.runMethod(true,"getText")));
 BA.debugLineNum = 197;BA.debugLine="hora11A.Text = hora1A.Text";
Debug.ShouldStop(16);
ingreso.mostCurrent._hora11a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._hora1a.runMethod(true,"getText")));
 BA.debugLineNum = 198;BA.debugLine="desc11A.Text = desc1";
Debug.ShouldStop(32);
ingreso.mostCurrent._desc11a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso._desc1));
 BA.debugLineNum = 199;BA.debugLine="If tipo1 = \"Celebracion\" Then";
Debug.ShouldStop(64);
if (RemoteObject.solveBoolean("=",ingreso._tipo1,BA.ObjectToString("Celebracion"))) { 
 BA.debugLineNum = 200;BA.debugLine="celebracion11A.Visible = True";
Debug.ShouldStop(128);
ingreso.mostCurrent._celebracion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 201;BA.debugLine="cambio11A.Visible = False";
Debug.ShouldStop(256);
ingreso.mostCurrent._cambio11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 202;BA.debugLine="reunion11A.Visible = False";
Debug.ShouldStop(512);
ingreso.mostCurrent._reunion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 204;BA.debugLine="If tipo1 = \"Reunion\" Then";
Debug.ShouldStop(2048);
if (RemoteObject.solveBoolean("=",ingreso._tipo1,BA.ObjectToString("Reunion"))) { 
 BA.debugLineNum = 205;BA.debugLine="celebracion11A.Visible = False";
Debug.ShouldStop(4096);
ingreso.mostCurrent._celebracion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 206;BA.debugLine="cambio11A.Visible = False";
Debug.ShouldStop(8192);
ingreso.mostCurrent._cambio11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 207;BA.debugLine="reunion11A.Visible = True";
Debug.ShouldStop(16384);
ingreso.mostCurrent._reunion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 209;BA.debugLine="If tipo1 = \"Cambio\" Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",ingreso._tipo1,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 210;BA.debugLine="celebracion11A.Visible = False";
Debug.ShouldStop(131072);
ingreso.mostCurrent._celebracion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 211;BA.debugLine="cambio11A.Visible = True";
Debug.ShouldStop(262144);
ingreso.mostCurrent._cambio11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 212;BA.debugLine="reunion11A.Visible = False";
Debug.ShouldStop(524288);
ingreso.mostCurrent._reunion11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 216;BA.debugLine="event = 1";
Debug.ShouldStop(8388608);
ingreso._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 218;BA.debugLine="End Sub";
Debug.ShouldStop(33554432);
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
		Debug.PushSubsStack("evento2A_Click (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,162);
if (RapidSub.canDelegate("evento2a_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","evento2a_click");}
 BA.debugLineNum = 162;BA.debugLine="Sub evento2A_Click";
Debug.ShouldStop(2);
 BA.debugLineNum = 163;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",ingreso._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 164;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(8);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 165;BA.debugLine="evento22A.Visible = True";
Debug.ShouldStop(16);
ingreso.mostCurrent._evento22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 166;BA.debugLine="titulo22A.Text = titulo2A.Text";
Debug.ShouldStop(32);
ingreso.mostCurrent._titulo22a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._titulo2a.runMethod(true,"getText")));
 BA.debugLineNum = 167;BA.debugLine="fecha22A.Text = fecha2A.Text";
Debug.ShouldStop(64);
ingreso.mostCurrent._fecha22a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._fecha2a.runMethod(true,"getText")));
 BA.debugLineNum = 168;BA.debugLine="hora22A.Text = hora2A.Text";
Debug.ShouldStop(128);
ingreso.mostCurrent._hora22a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso.mostCurrent._hora2a.runMethod(true,"getText")));
 BA.debugLineNum = 169;BA.debugLine="desc22A.Text = desc2";
Debug.ShouldStop(256);
ingreso.mostCurrent._desc22a.runMethod(true,"setText",BA.ObjectToCharSequence(ingreso._desc2));
 BA.debugLineNum = 170;BA.debugLine="If tipo2 = \"Celebracion\" Then";
Debug.ShouldStop(512);
if (RemoteObject.solveBoolean("=",ingreso._tipo2,BA.ObjectToString("Celebracion"))) { 
 BA.debugLineNum = 171;BA.debugLine="celebracion22A.Visible = True";
Debug.ShouldStop(1024);
ingreso.mostCurrent._celebracion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 172;BA.debugLine="cambio22A.Visible = False";
Debug.ShouldStop(2048);
ingreso.mostCurrent._cambio22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 173;BA.debugLine="reunion22A.Visible = False";
Debug.ShouldStop(4096);
ingreso.mostCurrent._reunion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 175;BA.debugLine="If tipo2 = \"Reunion\" Then";
Debug.ShouldStop(16384);
if (RemoteObject.solveBoolean("=",ingreso._tipo2,BA.ObjectToString("Reunion"))) { 
 BA.debugLineNum = 176;BA.debugLine="celebracion22A.Visible = False";
Debug.ShouldStop(32768);
ingreso.mostCurrent._celebracion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 177;BA.debugLine="cambio22A.Visible = False";
Debug.ShouldStop(65536);
ingreso.mostCurrent._cambio22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 178;BA.debugLine="reunion22A.Visible = True";
Debug.ShouldStop(131072);
ingreso.mostCurrent._reunion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 180;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(524288);
if (RemoteObject.solveBoolean("=",ingreso._tipo2,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 181;BA.debugLine="celebracion22A.Visible = False";
Debug.ShouldStop(1048576);
ingreso.mostCurrent._celebracion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 182;BA.debugLine="cambio22A.Visible = True";
Debug.ShouldStop(2097152);
ingreso.mostCurrent._cambio22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 183;BA.debugLine="reunion22A.Visible = False";
Debug.ShouldStop(4194304);
ingreso.mostCurrent._reunion22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 187;BA.debugLine="event = 1";
Debug.ShouldStop(67108864);
ingreso._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 189;BA.debugLine="End Sub";
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
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _inicio_click() throws Exception{
try {
		Debug.PushSubsStack("inicio_Click (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,108);
if (RapidSub.canDelegate("inicio_click")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","inicio_click");}
 BA.debugLineNum = 108;BA.debugLine="Sub inicio_Click";
Debug.ShouldStop(2048);
 BA.debugLineNum = 109;BA.debugLine="If event = 1 Then";
Debug.ShouldStop(4096);
if (RemoteObject.solveBoolean("=",ingreso._event,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 110;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(8192);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 111;BA.debugLine="evento22A.Visible = False";
Debug.ShouldStop(16384);
ingreso.mostCurrent._evento22a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 112;BA.debugLine="evento11A.Visible = False";
Debug.ShouldStop(32768);
ingreso.mostCurrent._evento11a.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 113;BA.debugLine="event = 0";
Debug.ShouldStop(65536);
ingreso._event = BA.numberCast(int.class, 0);
 };
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
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,144);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 144;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(65536);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 146;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
Debug.ShouldStop(131072);
ingreso.mostCurrent.__c.runVoidMethod ("LogImpl","75308418",RemoteObject.createImmutable("OK, se actualizó correctamente"),0);
 BA.debugLineNum = 147;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
Debug.ShouldStop(262144);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingreso.processBA);
 BA.debugLineNum = 148;BA.debugLine="txtconact.Text=\"\"";
Debug.ShouldStop(524288);
ingreso.mostCurrent._txtconact.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 149;BA.debugLine="txtconnuv.Text=\"\"";
Debug.ShouldStop(1048576);
ingreso.mostCurrent._txtconnuv.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 150;BA.debugLine="txtconfcon.Text=\"\"";
Debug.ShouldStop(2097152);
ingreso.mostCurrent._txtconfcon.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 151;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(4194304);
ingreso.mostCurrent._panel1.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 152;BA.debugLine="inicio.Visible=False";
Debug.ShouldStop(8388608);
ingreso.mostCurrent._inicio.runMethod(true,"setVisible",ingreso.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 153;BA.debugLine="estado=0";
Debug.ShouldStop(16777216);
ingreso._estado = BA.numberCast(int.class, 0);
 }else {
 BA.debugLineNum = 155;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(67108864);
ingreso.mostCurrent.__c.runVoidMethod ("LogImpl","75308427",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 156;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(134217728);
ingreso.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(ingreso.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 158;BA.debugLine="Job.Release";
Debug.ShouldStop(536870912);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
 BA.debugLineNum = 159;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
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
ingreso._codigo = RemoteObject.createImmutable("");
ingreso._desc1 = RemoteObject.createImmutable("");
ingreso._desc2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Dim eventos As Int = 0";
ingreso._eventos = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 12;BA.debugLine="Dim event As Int = 0";
ingreso._event = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _remorea() throws Exception{
try {
		Debug.PushSubsStack("remoreA (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,258);
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
int step27;
int limit27;

@Override
public void resume(BA ba, RemoteObject result) throws Exception{
try {
		Debug.PushSubsStack("remoreA (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,258);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 259;BA.debugLine="If eventos = 0 Then";
Debug.ShouldStop(4);
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
 BA.debugLineNum = 260;BA.debugLine="Anuncio.Visible = True";
Debug.ShouldStop(8);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 262;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(32);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;
;
 BA.debugLineNum = 264;BA.debugLine="Try";
Debug.ShouldStop(128);

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
 BA.debugLineNum = 265;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/s";
Debug.ShouldStop(256);
_apiaddress = BA.ObjectToString("http://192.168.1.3/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 266;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(512);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 267;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(1024);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingreso.processBA,(Object)(BA.ObjectToString("")),(Object)(ingreso.getObject()));
 BA.debugLineNum = 268;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
Debug.ShouldStop(2048);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("evento"),BA.ObjectToString("codigo"),parent._codigo})));
 BA.debugLineNum = 269;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(4096);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingreso.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingreso", "remorea"), (_js));
this.state = 72;
return;
case 72:
//C
this.state = 9;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 270;BA.debugLine="If js.Success Then";
Debug.ShouldStop(8192);
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
 BA.debugLineNum = 271;BA.debugLine="Dim res As String";
Debug.ShouldStop(16384);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 272;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
Debug.ShouldStop(32768);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 273;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(65536);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 274;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(131072);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 275;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(262144);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 276;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(524288);
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
 BA.debugLineNum = 277;BA.debugLine="eventos = 1";
Debug.ShouldStop(1048576);
parent._eventos = BA.numberCast(int.class, 1);
 BA.debugLineNum = 278;BA.debugLine="If eventos = 1 Then";
Debug.ShouldStop(2097152);
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
 BA.debugLineNum = 279;BA.debugLine="evento1A.Visible = True";
Debug.ShouldStop(4194304);
parent.mostCurrent._evento1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 18:
//C
this.state = 19;
;
 BA.debugLineNum = 281;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(16777216);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 282;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(33554432);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 283;BA.debugLine="Log(tabla)";
Debug.ShouldStop(67108864);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","75570585",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 284;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(134217728);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 285;BA.debugLine="For i=0 To tabla.Size-1";
Debug.ShouldStop(268435456);
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
 BA.debugLineNum = 286;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(536870912);
_fila.setObject(_tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 287;BA.debugLine="titulo = fila.Get(\"titulo\")";
Debug.ShouldStop(1073741824);
parent._titulo = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("titulo")))));
 BA.debugLineNum = 288;BA.debugLine="tipo = fila.Get(\"tipo\")";
Debug.ShouldStop(-2147483648);
parent._tipo = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("tipo")))));
 BA.debugLineNum = 289;BA.debugLine="fecha = fila.Get(\"fecha\")";
Debug.ShouldStop(1);
parent._fecha = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));
 BA.debugLineNum = 290;BA.debugLine="hora = fila.Get(\"hora\")";
Debug.ShouldStop(2);
parent._hora = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("hora")))));
 BA.debugLineNum = 291;BA.debugLine="descripcion = fila.Get(\"descripcion\")";
Debug.ShouldStop(4);
parent._descripcion = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("descripcion")))));
 BA.debugLineNum = 292;BA.debugLine="If eventos =1 Then";
Debug.ShouldStop(8);
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
 BA.debugLineNum = 293;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(16);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 294;BA.debugLine="evento2A.Visible = False";
Debug.ShouldStop(32);
parent.mostCurrent._evento2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 295;BA.debugLine="titulo1A.Text = titulo";
Debug.ShouldStop(64);
parent.mostCurrent._titulo1a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._titulo));
 BA.debugLineNum = 296;BA.debugLine="fecha1A.Text = fecha";
Debug.ShouldStop(128);
parent.mostCurrent._fecha1a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fecha));
 BA.debugLineNum = 297;BA.debugLine="tipo1 = tipo";
Debug.ShouldStop(256);
parent._tipo1 = parent._tipo;
 BA.debugLineNum = 298;BA.debugLine="hora1A.Text = hora";
Debug.ShouldStop(512);
parent.mostCurrent._hora1a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hora));
 BA.debugLineNum = 299;BA.debugLine="desc1 = descripcion";
Debug.ShouldStop(1024);
parent._desc1 = parent._descripcion;
 BA.debugLineNum = 300;BA.debugLine="If tipo1 = \"Celebracion\" Then";
Debug.ShouldStop(2048);
if (true) break;

case 25:
//if
this.state = 40;
if (RemoteObject.solveBoolean("=",parent._tipo1,BA.ObjectToString("Celebracion"))) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 40;
 BA.debugLineNum = 301;BA.debugLine="celebracion1A.Visible = True";
Debug.ShouldStop(4096);
parent.mostCurrent._celebracion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 302;BA.debugLine="cambio1A.Visible = False";
Debug.ShouldStop(8192);
parent.mostCurrent._cambio1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 303;BA.debugLine="reunion1A.Visible = False";
Debug.ShouldStop(16384);
parent.mostCurrent._reunion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 29:
//C
this.state = 30;
 BA.debugLineNum = 305;BA.debugLine="If tipo1 = \"Cambio\" Then";
Debug.ShouldStop(65536);
if (true) break;

case 30:
//if
this.state = 39;
if (RemoteObject.solveBoolean("=",parent._tipo1,BA.ObjectToString("Cambio"))) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 39;
 BA.debugLineNum = 306;BA.debugLine="celebracion1A.Visible = False";
Debug.ShouldStop(131072);
parent.mostCurrent._celebracion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 307;BA.debugLine="cambio1A.Visible = True";
Debug.ShouldStop(262144);
parent.mostCurrent._cambio1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 308;BA.debugLine="reunion1A.Visible = False";
Debug.ShouldStop(524288);
parent.mostCurrent._reunion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 34:
//C
this.state = 35;
 BA.debugLineNum = 310;BA.debugLine="If tipo1 = \"Reunion\" Then";
Debug.ShouldStop(2097152);
if (true) break;

case 35:
//if
this.state = 38;
if (RemoteObject.solveBoolean("=",parent._tipo1,BA.ObjectToString("Reunion"))) { 
this.state = 37;
}if (true) break;

case 37:
//C
this.state = 38;
 BA.debugLineNum = 311;BA.debugLine="celebracion1A.Visible = False";
Debug.ShouldStop(4194304);
parent.mostCurrent._celebracion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 312;BA.debugLine="cambio1A.Visible = False";
Debug.ShouldStop(8388608);
parent.mostCurrent._cambio1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 313;BA.debugLine="reunion1A.Visible = True";
Debug.ShouldStop(16777216);
parent.mostCurrent._reunion1a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
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
 BA.debugLineNum = 318;BA.debugLine="If eventos =2 Then";
Debug.ShouldStop(536870912);
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
 BA.debugLineNum = 319;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(1073741824);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 320;BA.debugLine="evento2A.Visible = True";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._evento2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 321;BA.debugLine="titulo2A.Text = titulo";
Debug.ShouldStop(1);
parent.mostCurrent._titulo2a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._titulo));
 BA.debugLineNum = 322;BA.debugLine="fecha2A.Text = fecha";
Debug.ShouldStop(2);
parent.mostCurrent._fecha2a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fecha));
 BA.debugLineNum = 323;BA.debugLine="tipo2 = tipo";
Debug.ShouldStop(4);
parent._tipo2 = parent._tipo;
 BA.debugLineNum = 324;BA.debugLine="hora2A.Text = hora";
Debug.ShouldStop(8);
parent.mostCurrent._hora2a.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hora));
 BA.debugLineNum = 325;BA.debugLine="desc2 = descripcion";
Debug.ShouldStop(16);
parent._desc2 = parent._descripcion;
 BA.debugLineNum = 326;BA.debugLine="If tipo2 = \"Celebracion\" Then";
Debug.ShouldStop(32);
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
 BA.debugLineNum = 327;BA.debugLine="celebracion2A.Visible = True";
Debug.ShouldStop(64);
parent.mostCurrent._celebracion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 328;BA.debugLine="cambio2A.Visible = False";
Debug.ShouldStop(128);
parent.mostCurrent._cambio2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 329;BA.debugLine="reunion2A.Visible = False";
Debug.ShouldStop(256);
parent.mostCurrent._reunion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 50:
//C
this.state = 51;
 BA.debugLineNum = 331;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(1024);
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
 BA.debugLineNum = 332;BA.debugLine="celebracion2A.Visible = False";
Debug.ShouldStop(2048);
parent.mostCurrent._celebracion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 333;BA.debugLine="cambio2A.Visible = True";
Debug.ShouldStop(4096);
parent.mostCurrent._cambio2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 334;BA.debugLine="reunion2A.Visible = False";
Debug.ShouldStop(8192);
parent.mostCurrent._reunion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 55:
//C
this.state = 56;
 BA.debugLineNum = 336;BA.debugLine="If tipo2 = \"Reunion\" Then";
Debug.ShouldStop(32768);
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
 BA.debugLineNum = 337;BA.debugLine="celebracion2A.Visible = False";
Debug.ShouldStop(65536);
parent.mostCurrent._celebracion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 338;BA.debugLine="cambio2A.Visible = False";
Debug.ShouldStop(131072);
parent.mostCurrent._cambio2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 339;BA.debugLine="reunion2A.Visible = True";
Debug.ShouldStop(262144);
parent.mostCurrent._reunion2a.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
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
 BA.debugLineNum = 345;BA.debugLine="eventos = eventos  + 1";
Debug.ShouldStop(16777216);
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
 BA.debugLineNum = 349;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(268435456);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","75570651",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
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
 BA.debugLineNum = 352;BA.debugLine="Log(LastException)";
Debug.ShouldStop(-2147483648);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","75570654",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingreso.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 71:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 354;BA.debugLine="End Sub";
Debug.ShouldStop(2);
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
		Debug.PushSubsStack("txtconfcon_TextChanged (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,123);
if (RapidSub.canDelegate("txtconfcon_textchanged")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","txtconfcon_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 123;BA.debugLine="Sub txtconfcon_TextChanged (Old As String, New As";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 124;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 125;BA.debugLine="MsgboxAsync(\"Laconfirmación de la contraseña no";
Debug.ShouldStop(268435456);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingreso.processBA);
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
public static RemoteObject  _txtconnuv_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconnuv_TextChanged (ingreso) ","ingreso",6,ingreso.mostCurrent.activityBA,ingreso.mostCurrent,117);
if (RapidSub.canDelegate("txtconnuv_textchanged")) { return b4a.example.ingreso.remoteMe.runUserSub(false, "ingreso","txtconnuv_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 117;BA.debugLine="Sub txtconnuv_TextChanged (Old As String, New As S";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 118;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(2097152);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 119;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
Debug.ShouldStop(4194304);
ingreso.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingreso.processBA);
 };
 BA.debugLineNum = 121;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
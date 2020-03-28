package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class ingresoestudiante_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,64);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 64;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(-2147483648);
 BA.debugLineNum = 66;BA.debugLine="Activity.LoadLayout(\"ingresoEstudiante\")";
Debug.ShouldStop(2);
ingresoestudiante.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("ingresoEstudiante")),ingresoestudiante.mostCurrent.activityBA);
 BA.debugLineNum = 67;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"eventoE\")";
Debug.ShouldStop(4);
ingresoestudiante.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingresoestudiante.mostCurrent.activityBA,(Object)(BA.ObjectToString("EVENTOS")),(Object)(RemoteObject.createImmutable("eventoE")));
 BA.debugLineNum = 68;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfilE\")";
Debug.ShouldStop(8);
ingresoestudiante.mostCurrent._tabhost1.runVoidMethodAndSync ("AddTab",ingresoestudiante.mostCurrent.activityBA,(Object)(BA.ObjectToString("PERFIL")),(Object)(RemoteObject.createImmutable("perfilE")));
 BA.debugLineNum = 69;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(16);
ingresoestudiante.mostCurrent._panel1.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 70;BA.debugLine="inicio.Visible=True";
Debug.ShouldStop(32);
ingresoestudiante.mostCurrent._inicio.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 71;BA.debugLine="evento1E.Visible=False";
Debug.ShouldStop(64);
ingresoestudiante.mostCurrent._evento1e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 72;BA.debugLine="evento2E.Visible=False";
Debug.ShouldStop(128);
ingresoestudiante.mostCurrent._evento2e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 73;BA.debugLine="evento11E.Visible=False";
Debug.ShouldStop(256);
ingresoestudiante.mostCurrent._evento11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 74;BA.debugLine="evento22E.Visible=False";
Debug.ShouldStop(512);
ingresoestudiante.mostCurrent._evento22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 75;BA.debugLine="Anuncio.Visible=False";
Debug.ShouldStop(1024);
ingresoestudiante.mostCurrent._anuncio.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 76;BA.debugLine="eventos = 0";
Debug.ShouldStop(2048);
ingresoestudiante._eventos = BA.numberCast(int.class, 0);
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
		Debug.PushSubsStack("Activity_Pause (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,83);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","activity_pause", _userclosed);}
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
		Debug.PushSubsStack("Activity_Resume (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,79);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","activity_resume");}
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
public static RemoteObject  _btncambiarestudiante_click() throws Exception{
try {
		Debug.PushSubsStack("btncambiarestudiante_Click (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,144);
if (RapidSub.canDelegate("btncambiarestudiante_click")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","btncambiarestudiante_click");}
 BA.debugLineNum = 144;BA.debugLine="Sub btncambiarestudiante_Click";
Debug.ShouldStop(32768);
 BA.debugLineNum = 145;BA.debugLine="If estado = 0 Then";
Debug.ShouldStop(65536);
if (RemoteObject.solveBoolean("=",ingresoestudiante._estado,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 146;BA.debugLine="Panel1.Visible = True";
Debug.ShouldStop(131072);
ingresoestudiante.mostCurrent._panel1.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 147;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(262144);
ingresoestudiante.mostCurrent._inicio.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 148;BA.debugLine="estado = 1";
Debug.ShouldStop(524288);
ingresoestudiante._estado = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 150;BA.debugLine="End Sub";
Debug.ShouldStop(2097152);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncambioe_click() throws Exception{
try {
		Debug.PushSubsStack("btncambioE_Click (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,99);
if (RapidSub.canDelegate("btncambioe_click")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","btncambioe_click");}
RemoteObject _apiaddress = RemoteObject.createImmutable("");
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
 BA.debugLineNum = 99;BA.debugLine="Sub btncambioE_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 100;BA.debugLine="If txtconactE.Text<>\"\" And txtconnuvE.Text<>\"\" An";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("!",ingresoestudiante.mostCurrent._txtconacte.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingresoestudiante.mostCurrent._txtconnuve.runMethod(true,"getText"),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",ingresoestudiante.mostCurrent._txtconfcone.runMethod(true,"getText"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 101;BA.debugLine="If txtconnuvE.Text = txtconfconE.Text Then";
Debug.ShouldStop(16);
if (RemoteObject.solveBoolean("=",ingresoestudiante.mostCurrent._txtconnuve.runMethod(true,"getText"),ingresoestudiante.mostCurrent._txtconfcone.runMethod(true,"getText"))) { 
 BA.debugLineNum = 102;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
Debug.ShouldStop(32);
_apiaddress = BA.ObjectToString("http://192.168.1.3/schooltime1.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 103;BA.debugLine="Dim job As HttpJob";
Debug.ShouldStop(64);
_job = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("job", _job);
 BA.debugLineNum = 104;BA.debugLine="job.Initialize(\"\", Me)";
Debug.ShouldStop(128);
_job.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingresoestudiante.processBA,(Object)(BA.ObjectToString("")),(Object)(ingresoestudiante.getObject()));
 BA.debugLineNum = 105;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tblregistroes";
Debug.ShouldStop(256);
_job.runClassMethod (b4a.example.httpjob.class, "_poststring" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.concat(RemoteObject.createImmutable("UPDATE tblregistroestudiante SET contrasenaEstudiante='"),ingresoestudiante.mostCurrent._txtconnuve.runMethod(true,"getText"),RemoteObject.createImmutable("' WHERE contrasenaEstudiante='"),ingresoestudiante.mostCurrent._txtconacte.runMethod(true,"getText"),RemoteObject.createImmutable("'"))));
 }else {
 BA.debugLineNum = 107;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
Debug.ShouldStop(1024);
ingresoestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Las contraseñas deben coincidir")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresoestudiante.processBA);
 };
 }else {
 BA.debugLineNum = 110;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
Debug.ShouldStop(8192);
ingresoestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresoestudiante.processBA);
 };
 BA.debugLineNum = 112;BA.debugLine="End Sub";
Debug.ShouldStop(32768);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _btncerrarestudiante_click() throws Exception{
try {
		Debug.PushSubsStack("btncerrarestudiante_Click (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,139);
if (RapidSub.canDelegate("btncerrarestudiante_click")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","btncerrarestudiante_click");}
 BA.debugLineNum = 139;BA.debugLine="Sub btncerrarestudiante_Click";
Debug.ShouldStop(1024);
 BA.debugLineNum = 140;BA.debugLine="StartActivity(perfiles)";
Debug.ShouldStop(2048);
ingresoestudiante.mostCurrent.__c.runVoidMethod ("StartActivity",ingresoestudiante.processBA,(Object)((ingresoestudiante.mostCurrent._perfiles.getObject())));
 BA.debugLineNum = 141;BA.debugLine="Activity.Finish";
Debug.ShouldStop(4096);
ingresoestudiante.mostCurrent._activity.runVoidMethod ("Finish");
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
public static void  _enviare_click() throws Exception{
try {
		Debug.PushSubsStack("EnviarE_Click (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,219);
if (RapidSub.canDelegate("enviare_click")) { b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","enviare_click"); return;}
ResumableSub_EnviarE_Click rsub = new ResumableSub_EnviarE_Click(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_EnviarE_Click extends BA.ResumableSub {
public ResumableSub_EnviarE_Click(b4a.example.ingresoestudiante parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.ingresoestudiante parent;
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
		Debug.PushSubsStack("EnviarE_Click (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,219);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 220;BA.debugLine="If contraseñaE.Text <> \"\" Then";
Debug.ShouldStop(134217728);
if (true) break;

case 1:
//if
this.state = 26;
if (RemoteObject.solveBoolean("!",parent.mostCurrent._contraseñae.runMethod(true,"getText"),BA.ObjectToString(""))) { 
this.state = 3;
}else {
this.state = 25;
}if (true) break;

case 3:
//C
this.state = 4;
 BA.debugLineNum = 221;BA.debugLine="Try";
Debug.ShouldStop(268435456);
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
 BA.debugLineNum = 222;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
Debug.ShouldStop(536870912);
_apiaddress = BA.ObjectToString("http://192.168.1.3/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 223;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(1073741824);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 224;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(-2147483648);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingresoestudiante.processBA,(Object)(BA.ObjectToString("")),(Object)(ingresoestudiante.getObject()));
 BA.debugLineNum = 225;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
Debug.ShouldStop(1);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {10},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("cedula"),BA.ObjectToString("pin"),parent.mostCurrent._contraseñae.runMethod(true,"getText"),BA.ObjectToString("tabla"),BA.ObjectToString("tblregistroestudiante"),BA.ObjectToString("codigo"),BA.ObjectToString("codigoGrupo"),BA.ObjectToString("cedula"),RemoteObject.createImmutable("identificacionEstudiante")})));
 BA.debugLineNum = 226;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(2);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingresoestudiante.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingresoestudiante", "enviare_click"), (_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 227;BA.debugLine="If js.Success Then";
Debug.ShouldStop(4);
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
 BA.debugLineNum = 228;BA.debugLine="Dim res As String";
Debug.ShouldStop(8);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 229;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
Debug.ShouldStop(16);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 230;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(32);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 231;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(64);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 232;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(128);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 233;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(256);
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
 BA.debugLineNum = 234;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(512);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 235;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(1024);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 236;BA.debugLine="Log(tabla)";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","56619153",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 237;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(4096);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 238;BA.debugLine="For i=0 To tabla.Size-1";
Debug.ShouldStop(8192);
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
 BA.debugLineNum = 239;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(16384);
_fila.setObject(_tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 240;BA.debugLine="codigoE = fila.Get(\"codigoGrupo\")";
Debug.ShouldStop(32768);
parent._codigoe = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("codigoGrupo")))));
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
 BA.debugLineNum = 244;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(524288);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","56619161",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
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
 BA.debugLineNum = 247;BA.debugLine="Log(LastException)";
Debug.ShouldStop(4194304);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","56619164",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingresoestudiante.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
 BA.debugLineNum = 249;BA.debugLine="inicio.Visible =False";
Debug.ShouldStop(16777216);
parent.mostCurrent._inicio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 250;BA.debugLine="Datos.Visible = False";
Debug.ShouldStop(33554432);
parent.mostCurrent._datos.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 25:
//C
this.state = 26;
 BA.debugLineNum = 252;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Necesitas este campo para el ingreso")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingresoestudiante.processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
 BA.debugLineNum = 254;BA.debugLine="remoreE";
Debug.ShouldStop(536870912);
_remoree();
 BA.debugLineNum = 255;BA.debugLine="End Sub";
Debug.ShouldStop(1073741824);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",ingresoestudiante.processBA, e0.toString());}
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
public static RemoteObject  _evento1e_click() throws Exception{
try {
		Debug.PushSubsStack("evento1E_Click (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,161);
if (RapidSub.canDelegate("evento1e_click")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","evento1e_click");}
 BA.debugLineNum = 161;BA.debugLine="Sub evento1E_Click";
Debug.ShouldStop(1);
 BA.debugLineNum = 162;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(2);
if (RemoteObject.solveBoolean("=",ingresoestudiante._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 163;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(4);
ingresoestudiante.mostCurrent._inicio.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 164;BA.debugLine="evento11E.Visible = True";
Debug.ShouldStop(8);
ingresoestudiante.mostCurrent._evento11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 165;BA.debugLine="titulo11E.Text = titulo1E.Text";
Debug.ShouldStop(16);
ingresoestudiante.mostCurrent._titulo11e.runMethod(true,"setText",BA.ObjectToCharSequence(ingresoestudiante.mostCurrent._titulo1e.runMethod(true,"getText")));
 BA.debugLineNum = 166;BA.debugLine="fecha11E.Text = fecha1E.Text";
Debug.ShouldStop(32);
ingresoestudiante.mostCurrent._fecha11e.runMethod(true,"setText",BA.ObjectToCharSequence(ingresoestudiante.mostCurrent._fecha1e.runMethod(true,"getText")));
 BA.debugLineNum = 167;BA.debugLine="hora11E.Text = hora1E.Text";
Debug.ShouldStop(64);
ingresoestudiante.mostCurrent._hora11e.runMethod(true,"setText",BA.ObjectToCharSequence(ingresoestudiante.mostCurrent._hora1e.runMethod(true,"getText")));
 BA.debugLineNum = 168;BA.debugLine="desc11E.Text = desc1";
Debug.ShouldStop(128);
ingresoestudiante.mostCurrent._desc11e.runMethod(true,"setText",BA.ObjectToCharSequence(ingresoestudiante._desc1));
 BA.debugLineNum = 169;BA.debugLine="If tipo1 = \"Celebracion\" Then";
Debug.ShouldStop(256);
if (RemoteObject.solveBoolean("=",ingresoestudiante._tipo1,BA.ObjectToString("Celebracion"))) { 
 BA.debugLineNum = 170;BA.debugLine="celebracion11E.Visible = True";
Debug.ShouldStop(512);
ingresoestudiante.mostCurrent._celebracion11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 171;BA.debugLine="cambio11E.Visible = False";
Debug.ShouldStop(1024);
ingresoestudiante.mostCurrent._cambio11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 172;BA.debugLine="reunion11E.Visible = False";
Debug.ShouldStop(2048);
ingresoestudiante.mostCurrent._reunion11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 174;BA.debugLine="If tipo1 = \"Reunion\" Then";
Debug.ShouldStop(8192);
if (RemoteObject.solveBoolean("=",ingresoestudiante._tipo1,BA.ObjectToString("Reunion"))) { 
 BA.debugLineNum = 175;BA.debugLine="celebracion11E.Visible = False";
Debug.ShouldStop(16384);
ingresoestudiante.mostCurrent._celebracion11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 176;BA.debugLine="cambio11E.Visible = False";
Debug.ShouldStop(32768);
ingresoestudiante.mostCurrent._cambio11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 177;BA.debugLine="reunion11E.Visible = True";
Debug.ShouldStop(65536);
ingresoestudiante.mostCurrent._reunion11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 179;BA.debugLine="If tipo1 = \"Cambio\" Then";
Debug.ShouldStop(262144);
if (RemoteObject.solveBoolean("=",ingresoestudiante._tipo1,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 180;BA.debugLine="celebracion11E.Visible = False";
Debug.ShouldStop(524288);
ingresoestudiante.mostCurrent._celebracion11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 181;BA.debugLine="cambio11E.Visible = True";
Debug.ShouldStop(1048576);
ingresoestudiante.mostCurrent._cambio11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 182;BA.debugLine="reunion11E.Visible = False";
Debug.ShouldStop(2097152);
ingresoestudiante.mostCurrent._reunion11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 186;BA.debugLine="event = 1";
Debug.ShouldStop(33554432);
ingresoestudiante._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 188;BA.debugLine="End Sub";
Debug.ShouldStop(134217728);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _evento2e_click() throws Exception{
try {
		Debug.PushSubsStack("evento2E_Click (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,190);
if (RapidSub.canDelegate("evento2e_click")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","evento2e_click");}
 BA.debugLineNum = 190;BA.debugLine="Sub evento2E_Click";
Debug.ShouldStop(536870912);
 BA.debugLineNum = 191;BA.debugLine="If event = 0 Then";
Debug.ShouldStop(1073741824);
if (RemoteObject.solveBoolean("=",ingresoestudiante._event,BA.numberCast(double.class, 0))) { 
 BA.debugLineNum = 192;BA.debugLine="inicio.Visible = True";
Debug.ShouldStop(-2147483648);
ingresoestudiante.mostCurrent._inicio.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 193;BA.debugLine="evento22E.Visible = True";
Debug.ShouldStop(1);
ingresoestudiante.mostCurrent._evento22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 194;BA.debugLine="titulo22E.Text = titulo2E.Text";
Debug.ShouldStop(2);
ingresoestudiante.mostCurrent._titulo22e.runMethod(true,"setText",BA.ObjectToCharSequence(ingresoestudiante.mostCurrent._titulo2e.runMethod(true,"getText")));
 BA.debugLineNum = 195;BA.debugLine="fecha22E.Text = fecha2E.Text";
Debug.ShouldStop(4);
ingresoestudiante.mostCurrent._fecha22e.runMethod(true,"setText",BA.ObjectToCharSequence(ingresoestudiante.mostCurrent._fecha2e.runMethod(true,"getText")));
 BA.debugLineNum = 196;BA.debugLine="hora22E.Text = hora2E.Text";
Debug.ShouldStop(8);
ingresoestudiante.mostCurrent._hora22e.runMethod(true,"setText",BA.ObjectToCharSequence(ingresoestudiante.mostCurrent._hora2e.runMethod(true,"getText")));
 BA.debugLineNum = 197;BA.debugLine="descripcion22E.Text = desc2";
Debug.ShouldStop(16);
ingresoestudiante.mostCurrent._descripcion22e.runMethod(true,"setText",BA.ObjectToCharSequence(ingresoestudiante._desc2));
 BA.debugLineNum = 198;BA.debugLine="If tipo2 = \"Celebracion\" Then";
Debug.ShouldStop(32);
if (RemoteObject.solveBoolean("=",ingresoestudiante._tipo2,BA.ObjectToString("Celebracion"))) { 
 BA.debugLineNum = 199;BA.debugLine="celebracion22E.Visible = True";
Debug.ShouldStop(64);
ingresoestudiante.mostCurrent._celebracion22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 200;BA.debugLine="cambio22E.Visible = False";
Debug.ShouldStop(128);
ingresoestudiante.mostCurrent._cambio22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 201;BA.debugLine="reunion22E.Visible = False";
Debug.ShouldStop(256);
ingresoestudiante.mostCurrent._reunion22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 }else {
 BA.debugLineNum = 203;BA.debugLine="If tipo2 = \"Reunion\" Then";
Debug.ShouldStop(1024);
if (RemoteObject.solveBoolean("=",ingresoestudiante._tipo2,BA.ObjectToString("Reunion"))) { 
 BA.debugLineNum = 204;BA.debugLine="celebracion22E.Visible = False";
Debug.ShouldStop(2048);
ingresoestudiante.mostCurrent._celebracion22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 205;BA.debugLine="cambio22E.Visible = False";
Debug.ShouldStop(4096);
ingresoestudiante.mostCurrent._cambio22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 206;BA.debugLine="reunion22E.Visible = True";
Debug.ShouldStop(8192);
ingresoestudiante.mostCurrent._reunion22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 }else {
 BA.debugLineNum = 208;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(32768);
if (RemoteObject.solveBoolean("=",ingresoestudiante._tipo2,BA.ObjectToString("Cambio"))) { 
 BA.debugLineNum = 209;BA.debugLine="celebracion22E.Visible = False";
Debug.ShouldStop(65536);
ingresoestudiante.mostCurrent._celebracion22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 210;BA.debugLine="cambio22E.Visible = True";
Debug.ShouldStop(131072);
ingresoestudiante.mostCurrent._cambio22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 211;BA.debugLine="reunion22E.Visible = False";
Debug.ShouldStop(262144);
ingresoestudiante.mostCurrent._reunion22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 };
 };
 };
 BA.debugLineNum = 215;BA.debugLine="event = 1";
Debug.ShouldStop(4194304);
ingresoestudiante._event = BA.numberCast(int.class, 1);
 };
 BA.debugLineNum = 217;BA.debugLine="End Sub";
Debug.ShouldStop(16777216);
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
ingresoestudiante.mostCurrent._tabhost1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.TabHostWrapper");
 //BA.debugLineNum = 19;BA.debugLine="Private inicio As Panel";
ingresoestudiante.mostCurrent._inicio = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 20;BA.debugLine="Private Panel1 As Panel";
ingresoestudiante.mostCurrent._panel1 = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 21;BA.debugLine="Private btncambioE As Button";
ingresoestudiante.mostCurrent._btncambioe = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 22;BA.debugLine="Private retroceder As Label";
ingresoestudiante.mostCurrent._retroceder = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 23;BA.debugLine="Private txtconactE As EditText";
ingresoestudiante.mostCurrent._txtconacte = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 24;BA.debugLine="Private txtconfconE As EditText";
ingresoestudiante.mostCurrent._txtconfcone = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 25;BA.debugLine="Private txtconnuvE As EditText";
ingresoestudiante.mostCurrent._txtconnuve = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 26;BA.debugLine="Private btncambiarestudiante As Button";
ingresoestudiante.mostCurrent._btncambiarestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 27;BA.debugLine="Private btncerrarestudiante As Button";
ingresoestudiante.mostCurrent._btncerrarestudiante = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 28;BA.debugLine="Private Anuncio As Label";
ingresoestudiante.mostCurrent._anuncio = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 29;BA.debugLine="Private cambio1E As ImageView";
ingresoestudiante.mostCurrent._cambio1e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 30;BA.debugLine="Private cambio2E As ImageView";
ingresoestudiante.mostCurrent._cambio2e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 31;BA.debugLine="Private celebracion1E As ImageView";
ingresoestudiante.mostCurrent._celebracion1e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 32;BA.debugLine="Private celebracion2E As ImageView";
ingresoestudiante.mostCurrent._celebracion2e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 33;BA.debugLine="Private evento1E As Panel";
ingresoestudiante.mostCurrent._evento1e = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 34;BA.debugLine="Private evento2E As Panel";
ingresoestudiante.mostCurrent._evento2e = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 35;BA.debugLine="Private fecha1E As Label";
ingresoestudiante.mostCurrent._fecha1e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 36;BA.debugLine="Private fecha2E As Label";
ingresoestudiante.mostCurrent._fecha2e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 37;BA.debugLine="Private hora1E As Label";
ingresoestudiante.mostCurrent._hora1e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 38;BA.debugLine="Private hora2E As Label";
ingresoestudiante.mostCurrent._hora2e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 39;BA.debugLine="Private reunion1E As ImageView";
ingresoestudiante.mostCurrent._reunion1e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 40;BA.debugLine="Private reunion2E As ImageView";
ingresoestudiante.mostCurrent._reunion2e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 41;BA.debugLine="Private titulo1E As Label";
ingresoestudiante.mostCurrent._titulo1e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 42;BA.debugLine="Private titulo2E As Label";
ingresoestudiante.mostCurrent._titulo2e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 43;BA.debugLine="Private cambio11E As ImageView";
ingresoestudiante.mostCurrent._cambio11e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 44;BA.debugLine="Private cambio22E As ImageView";
ingresoestudiante.mostCurrent._cambio22e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 45;BA.debugLine="Private celebracion11E As ImageView";
ingresoestudiante.mostCurrent._celebracion11e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 46;BA.debugLine="Private celebracion22E As ImageView";
ingresoestudiante.mostCurrent._celebracion22e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 47;BA.debugLine="Private contraseñaE As EditText";
ingresoestudiante.mostCurrent._contraseñae = RemoteObject.createNew ("anywheresoftware.b4a.objects.EditTextWrapper");
 //BA.debugLineNum = 48;BA.debugLine="Private Datos As Panel";
ingresoestudiante.mostCurrent._datos = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 49;BA.debugLine="Private desc11E As Label";
ingresoestudiante.mostCurrent._desc11e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 50;BA.debugLine="Private descripcion22E As Label";
ingresoestudiante.mostCurrent._descripcion22e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 51;BA.debugLine="Private EnviarE As Button";
ingresoestudiante.mostCurrent._enviare = RemoteObject.createNew ("anywheresoftware.b4a.objects.ButtonWrapper");
 //BA.debugLineNum = 52;BA.debugLine="Private evento11E As Panel";
ingresoestudiante.mostCurrent._evento11e = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 53;BA.debugLine="Private evento22E As Panel";
ingresoestudiante.mostCurrent._evento22e = RemoteObject.createNew ("anywheresoftware.b4a.objects.PanelWrapper");
 //BA.debugLineNum = 54;BA.debugLine="Private fecha11E As Label";
ingresoestudiante.mostCurrent._fecha11e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 55;BA.debugLine="Private fecha22E As Label";
ingresoestudiante.mostCurrent._fecha22e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 56;BA.debugLine="Private hora11E As Label";
ingresoestudiante.mostCurrent._hora11e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 57;BA.debugLine="Private hora22E As Label";
ingresoestudiante.mostCurrent._hora22e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 58;BA.debugLine="Private reunion11E As ImageView";
ingresoestudiante.mostCurrent._reunion11e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 59;BA.debugLine="Private reunion22E As ImageView";
ingresoestudiante.mostCurrent._reunion22e = RemoteObject.createNew ("anywheresoftware.b4a.objects.ImageViewWrapper");
 //BA.debugLineNum = 60;BA.debugLine="Private titulo11E As Label";
ingresoestudiante.mostCurrent._titulo11e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 61;BA.debugLine="Private titulo22E As Label";
ingresoestudiante.mostCurrent._titulo22e = RemoteObject.createNew ("anywheresoftware.b4a.objects.LabelWrapper");
 //BA.debugLineNum = 62;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _inicio_click() throws Exception{
try {
		Debug.PushSubsStack("inicio_Click (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,152);
if (RapidSub.canDelegate("inicio_click")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","inicio_click");}
 BA.debugLineNum = 152;BA.debugLine="Sub inicio_Click";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 153;BA.debugLine="If event = 1 Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",ingresoestudiante._event,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 154;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(33554432);
ingresoestudiante.mostCurrent._inicio.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 155;BA.debugLine="evento22E.Visible = False";
Debug.ShouldStop(67108864);
ingresoestudiante.mostCurrent._evento22e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 156;BA.debugLine="evento11E.Visible = False";
Debug.ShouldStop(134217728);
ingresoestudiante.mostCurrent._evento11e.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 157;BA.debugLine="event = 0";
Debug.ShouldStop(268435456);
ingresoestudiante._event = BA.numberCast(int.class, 0);
 };
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
public static RemoteObject  _jobdone(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("JobDone (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,114);
if (RapidSub.canDelegate("jobdone")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","jobdone", _job);}
Debug.locals.put("Job", _job);
 BA.debugLineNum = 114;BA.debugLine="Sub JobDone(Job As HttpJob)";
Debug.ShouldStop(131072);
 BA.debugLineNum = 115;BA.debugLine="If Job.Success Then";
Debug.ShouldStop(262144);
if (_job.getField(true,"_success" /*RemoteObject*/ ).<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 116;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
Debug.ShouldStop(524288);
ingresoestudiante.mostCurrent.__c.runVoidMethod ("LogImpl","56160386",RemoteObject.createImmutable("OK, se actualizó correctamente"),0);
 BA.debugLineNum = 117;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
Debug.ShouldStop(1048576);
ingresoestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("AVISO"))),ingresoestudiante.processBA);
 BA.debugLineNum = 118;BA.debugLine="txtconactE.Text=\"\"";
Debug.ShouldStop(2097152);
ingresoestudiante.mostCurrent._txtconacte.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 119;BA.debugLine="txtconnuvE.Text=\"\"";
Debug.ShouldStop(4194304);
ingresoestudiante.mostCurrent._txtconnuve.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 120;BA.debugLine="txtconfconE.Text=\"\"";
Debug.ShouldStop(8388608);
ingresoestudiante.mostCurrent._txtconfcone.runMethodAndSync(true,"setText",BA.ObjectToCharSequence(""));
 BA.debugLineNum = 121;BA.debugLine="Panel1.Visible=False";
Debug.ShouldStop(16777216);
ingresoestudiante.mostCurrent._panel1.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 122;BA.debugLine="inicio.Visible=False";
Debug.ShouldStop(33554432);
ingresoestudiante.mostCurrent._inicio.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 123;BA.debugLine="estado=0";
Debug.ShouldStop(67108864);
ingresoestudiante._estado = BA.numberCast(int.class, 0);
 }else {
 BA.debugLineNum = 125;BA.debugLine="Log(Job.ErrorMessage)";
Debug.ShouldStop(268435456);
ingresoestudiante.mostCurrent.__c.runVoidMethod ("LogImpl","56160395",_job.getField(true,"_errormessage" /*RemoteObject*/ ),0);
 BA.debugLineNum = 126;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
Debug.ShouldStop(536870912);
ingresoestudiante.mostCurrent.__c.runVoidMethod ("ToastMessageShow",(Object)(BA.ObjectToCharSequence(RemoteObject.concat(RemoteObject.createImmutable("Error: "),_job.getField(true,"_errormessage" /*RemoteObject*/ )))),(Object)(ingresoestudiante.mostCurrent.__c.getField(true,"True")));
 };
 BA.debugLineNum = 128;BA.debugLine="Job.Release";
Debug.ShouldStop(-2147483648);
_job.runClassMethod (b4a.example.httpjob.class, "_release" /*RemoteObject*/ );
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
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 6;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 9;BA.debugLine="Dim estado As Int=0";
ingresoestudiante._estado = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 10;BA.debugLine="Dim titulo,descripcion,fecha,hora,tipo,tipo1,tipo";
ingresoestudiante._titulo = RemoteObject.createImmutable("");
ingresoestudiante._descripcion = RemoteObject.createImmutable("");
ingresoestudiante._fecha = RemoteObject.createImmutable("");
ingresoestudiante._hora = RemoteObject.createImmutable("");
ingresoestudiante._tipo = RemoteObject.createImmutable("");
ingresoestudiante._tipo1 = RemoteObject.createImmutable("");
ingresoestudiante._tipo2 = RemoteObject.createImmutable("");
ingresoestudiante._codigoe = RemoteObject.createImmutable("");
ingresoestudiante._desc1 = RemoteObject.createImmutable("");
ingresoestudiante._desc2 = RemoteObject.createImmutable("");
 //BA.debugLineNum = 11;BA.debugLine="Dim eventos As Int = 0";
ingresoestudiante._eventos = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 12;BA.debugLine="Dim event As Int = 0";
ingresoestudiante._event = BA.numberCast(int.class, 0);
 //BA.debugLineNum = 13;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static void  _remoree() throws Exception{
try {
		Debug.PushSubsStack("remoreE (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,257);
if (RapidSub.canDelegate("remoree")) { b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","remoree"); return;}
ResumableSub_remoreE rsub = new ResumableSub_remoreE(null);
rsub.resume(null, null);
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static class ResumableSub_remoreE extends BA.ResumableSub {
public ResumableSub_remoreE(b4a.example.ingresoestudiante parent) {
this.parent = parent;
}
java.util.LinkedHashMap<String, Object> rsLocals = new java.util.LinkedHashMap<String, Object>();
b4a.example.ingresoestudiante parent;
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
		Debug.PushSubsStack("remoreE (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,257);
Debug.locals = rsLocals;Debug.currentSubFrame.locals = rsLocals;

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
 BA.debugLineNum = 258;BA.debugLine="If eventos = 0 Then";
Debug.ShouldStop(2);
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
 BA.debugLineNum = 259;BA.debugLine="Anuncio.Visible = True";
Debug.ShouldStop(4);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 5:
//C
this.state = 6;
 BA.debugLineNum = 261;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(16);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;
;
 BA.debugLineNum = 263;BA.debugLine="Try";
Debug.ShouldStop(64);

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
 BA.debugLineNum = 264;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/s";
Debug.ShouldStop(128);
_apiaddress = BA.ObjectToString("http://192.168.1.3/schooltime.php");Debug.locals.put("ApiAddress", _apiaddress);Debug.locals.put("ApiAddress", _apiaddress);
 BA.debugLineNum = 265;BA.debugLine="Dim js As HttpJob";
Debug.ShouldStop(256);
_js = RemoteObject.createNew ("b4a.example.httpjob");Debug.locals.put("js", _js);
 BA.debugLineNum = 266;BA.debugLine="js.Initialize(\"\",Me)";
Debug.ShouldStop(512);
_js.runClassMethod (b4a.example.httpjob.class, "_initialize" /*RemoteObject*/ ,ingresoestudiante.processBA,(Object)(BA.ObjectToString("")),(Object)(ingresoestudiante.getObject()));
 BA.debugLineNum = 267;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
Debug.ShouldStop(1024);
_js.runClassMethod (b4a.example.httpjob.class, "_download2" /*RemoteObject*/ ,(Object)(_apiaddress),(Object)(RemoteObject.createNewArray("String",new int[] {4},new Object[] {BA.ObjectToString("act"),BA.ObjectToString("evento"),BA.ObjectToString("codigo"),parent._codigoe})));
 BA.debugLineNum = 268;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
Debug.ShouldStop(2048);
parent.mostCurrent.__c.runVoidMethod ("WaitFor","jobdone", ingresoestudiante.processBA, anywheresoftware.b4a.pc.PCResumableSub.createDebugResumeSub(this, "ingresoestudiante", "remoree"), (_js));
this.state = 72;
return;
case 72:
//C
this.state = 9;
_js = (RemoteObject) result.getArrayElement(false,RemoteObject.createImmutable(0));Debug.locals.put("js", _js);
;
 BA.debugLineNum = 269;BA.debugLine="If js.Success Then";
Debug.ShouldStop(4096);
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
 BA.debugLineNum = 270;BA.debugLine="Dim res As String";
Debug.ShouldStop(8192);
_res = RemoteObject.createImmutable("");Debug.locals.put("res", _res);
 BA.debugLineNum = 271;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
Debug.ShouldStop(16384);
_res = _js.runClassMethod (b4a.example.httpjob.class, "_getstring" /*RemoteObject*/ );Debug.locals.put("res", _res);
 BA.debugLineNum = 272;BA.debugLine="res = res.Replace(\"null\",\"\")";
Debug.ShouldStop(32768);
_res = _res.runMethod(true,"replace",(Object)(BA.ObjectToString("null")),(Object)(RemoteObject.createImmutable("")));Debug.locals.put("res", _res);
 BA.debugLineNum = 273;BA.debugLine="Dim parser As JSONParser";
Debug.ShouldStop(65536);
_parser = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.JSONParser");Debug.locals.put("parser", _parser);
 BA.debugLineNum = 274;BA.debugLine="parser.Initialize(res)";
Debug.ShouldStop(131072);
_parser.runVoidMethod ("Initialize",(Object)(_res));
 BA.debugLineNum = 275;BA.debugLine="If (res.Length >0) Then";
Debug.ShouldStop(262144);
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
 BA.debugLineNum = 276;BA.debugLine="eventos = 1";
Debug.ShouldStop(524288);
parent._eventos = BA.numberCast(int.class, 1);
 BA.debugLineNum = 277;BA.debugLine="If eventos = 1 Then";
Debug.ShouldStop(1048576);
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
 BA.debugLineNum = 278;BA.debugLine="evento1E.Visible = True";
Debug.ShouldStop(2097152);
parent.mostCurrent._evento1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 if (true) break;

case 18:
//C
this.state = 19;
;
 BA.debugLineNum = 280;BA.debugLine="Dim tabla As List";
Debug.ShouldStop(8388608);
_tabla = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.List");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 281;BA.debugLine="tabla = parser.NextArray";
Debug.ShouldStop(16777216);
_tabla = _parser.runMethod(false,"NextArray");Debug.locals.put("tabla", _tabla);
 BA.debugLineNum = 282;BA.debugLine="Log(tabla)";
Debug.ShouldStop(33554432);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","56684697",BA.ObjectToString(_tabla),0);
 BA.debugLineNum = 283;BA.debugLine="Dim fila As Map";
Debug.ShouldStop(67108864);
_fila = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");Debug.locals.put("fila", _fila);
 BA.debugLineNum = 284;BA.debugLine="For i=0 To tabla.Size-1";
Debug.ShouldStop(134217728);
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
 BA.debugLineNum = 285;BA.debugLine="fila= tabla.Get(i)";
Debug.ShouldStop(268435456);
_fila.setObject(_tabla.runMethod(false,"Get",(Object)(BA.numberCast(int.class, _i))));
 BA.debugLineNum = 286;BA.debugLine="titulo = fila.Get(\"titulo\")";
Debug.ShouldStop(536870912);
parent._titulo = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("titulo")))));
 BA.debugLineNum = 287;BA.debugLine="tipo = fila.Get(\"tipo\")";
Debug.ShouldStop(1073741824);
parent._tipo = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("tipo")))));
 BA.debugLineNum = 288;BA.debugLine="fecha = fila.Get(\"fecha\")";
Debug.ShouldStop(-2147483648);
parent._fecha = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("fecha")))));
 BA.debugLineNum = 289;BA.debugLine="hora = fila.Get(\"hora\")";
Debug.ShouldStop(1);
parent._hora = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("hora")))));
 BA.debugLineNum = 290;BA.debugLine="descripcion = fila.Get(\"descripcion\")";
Debug.ShouldStop(2);
parent._descripcion = BA.ObjectToString(_fila.runMethod(false,"Get",(Object)((RemoteObject.createImmutable("descripcion")))));
 BA.debugLineNum = 291;BA.debugLine="If eventos =1 Then";
Debug.ShouldStop(4);
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
 BA.debugLineNum = 292;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(8);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 293;BA.debugLine="evento2E.Visible = False";
Debug.ShouldStop(16);
parent.mostCurrent._evento2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 294;BA.debugLine="titulo1E.Text = titulo";
Debug.ShouldStop(32);
parent.mostCurrent._titulo1e.runMethod(true,"setText",BA.ObjectToCharSequence(parent._titulo));
 BA.debugLineNum = 295;BA.debugLine="fecha1E.Text = fecha";
Debug.ShouldStop(64);
parent.mostCurrent._fecha1e.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fecha));
 BA.debugLineNum = 296;BA.debugLine="tipo1 = tipo";
Debug.ShouldStop(128);
parent._tipo1 = parent._tipo;
 BA.debugLineNum = 297;BA.debugLine="hora1E.Text = hora";
Debug.ShouldStop(256);
parent.mostCurrent._hora1e.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hora));
 BA.debugLineNum = 298;BA.debugLine="desc1 = descripcion";
Debug.ShouldStop(512);
parent._desc1 = parent._descripcion;
 BA.debugLineNum = 299;BA.debugLine="If tipo1 = \"Celebracion\" Then";
Debug.ShouldStop(1024);
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
 BA.debugLineNum = 300;BA.debugLine="celebracion1E.Visible = True";
Debug.ShouldStop(2048);
parent.mostCurrent._celebracion1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 301;BA.debugLine="cambio1E.Visible = False";
Debug.ShouldStop(4096);
parent.mostCurrent._cambio1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 302;BA.debugLine="reunion1E.Visible = False";
Debug.ShouldStop(8192);
parent.mostCurrent._reunion1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 29:
//C
this.state = 30;
 BA.debugLineNum = 304;BA.debugLine="If tipo1 = \"Cambio\" Then";
Debug.ShouldStop(32768);
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
 BA.debugLineNum = 305;BA.debugLine="celebracion1E.Visible = False";
Debug.ShouldStop(65536);
parent.mostCurrent._celebracion1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 306;BA.debugLine="cambio1E.Visible = True";
Debug.ShouldStop(131072);
parent.mostCurrent._cambio1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 307;BA.debugLine="reunion1E.Visible = False";
Debug.ShouldStop(262144);
parent.mostCurrent._reunion1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 34:
//C
this.state = 35;
 BA.debugLineNum = 309;BA.debugLine="If tipo1 = \"Reunion\" Then";
Debug.ShouldStop(1048576);
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
 BA.debugLineNum = 310;BA.debugLine="celebracion1E.Visible = False";
Debug.ShouldStop(2097152);
parent.mostCurrent._celebracion1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 311;BA.debugLine="cambio1E.Visible = False";
Debug.ShouldStop(4194304);
parent.mostCurrent._cambio1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 312;BA.debugLine="reunion1E.Visible = True";
Debug.ShouldStop(8388608);
parent.mostCurrent._reunion1e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
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
 BA.debugLineNum = 317;BA.debugLine="If eventos =2 Then";
Debug.ShouldStop(268435456);
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
 BA.debugLineNum = 318;BA.debugLine="Anuncio.Visible = False";
Debug.ShouldStop(536870912);
parent.mostCurrent._anuncio.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 319;BA.debugLine="evento2E.Visible = True";
Debug.ShouldStop(1073741824);
parent.mostCurrent._evento2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 320;BA.debugLine="titulo2E.Text = titulo";
Debug.ShouldStop(-2147483648);
parent.mostCurrent._titulo2e.runMethod(true,"setText",BA.ObjectToCharSequence(parent._titulo));
 BA.debugLineNum = 321;BA.debugLine="fecha2E.Text = fecha";
Debug.ShouldStop(1);
parent.mostCurrent._fecha2e.runMethod(true,"setText",BA.ObjectToCharSequence(parent._fecha));
 BA.debugLineNum = 322;BA.debugLine="tipo2 = tipo";
Debug.ShouldStop(2);
parent._tipo2 = parent._tipo;
 BA.debugLineNum = 323;BA.debugLine="hora2E.Text = hora";
Debug.ShouldStop(4);
parent.mostCurrent._hora2e.runMethod(true,"setText",BA.ObjectToCharSequence(parent._hora));
 BA.debugLineNum = 324;BA.debugLine="desc2 = descripcion";
Debug.ShouldStop(8);
parent._desc2 = parent._descripcion;
 BA.debugLineNum = 325;BA.debugLine="If tipo2 = \"Celebracion\" Then";
Debug.ShouldStop(16);
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
 BA.debugLineNum = 326;BA.debugLine="celebracion2E.Visible = True";
Debug.ShouldStop(32);
parent.mostCurrent._celebracion2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 327;BA.debugLine="cambio2E.Visible = False";
Debug.ShouldStop(64);
parent.mostCurrent._cambio2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 328;BA.debugLine="reunion2E.Visible = False";
Debug.ShouldStop(128);
parent.mostCurrent._reunion2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 50:
//C
this.state = 51;
 BA.debugLineNum = 330;BA.debugLine="If tipo2 = \"Cambio\" Then";
Debug.ShouldStop(512);
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
 BA.debugLineNum = 331;BA.debugLine="celebracion2E.Visible = False";
Debug.ShouldStop(1024);
parent.mostCurrent._celebracion2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 332;BA.debugLine="cambio2E.Visible = True";
Debug.ShouldStop(2048);
parent.mostCurrent._cambio2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 333;BA.debugLine="reunion2E.Visible = False";
Debug.ShouldStop(4096);
parent.mostCurrent._reunion2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 if (true) break;

case 55:
//C
this.state = 56;
 BA.debugLineNum = 335;BA.debugLine="If tipo2 = \"Reunion\" Then";
Debug.ShouldStop(16384);
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
 BA.debugLineNum = 336;BA.debugLine="celebracion2E.Visible = False";
Debug.ShouldStop(32768);
parent.mostCurrent._celebracion2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 337;BA.debugLine="cambio2E.Visible = False";
Debug.ShouldStop(65536);
parent.mostCurrent._cambio2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 338;BA.debugLine="reunion2E.Visible = True";
Debug.ShouldStop(131072);
parent.mostCurrent._reunion2e.runMethod(true,"setVisible",parent.mostCurrent.__c.getField(true,"True"));
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
 BA.debugLineNum = 344;BA.debugLine="eventos = eventos  + 1";
Debug.ShouldStop(8388608);
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
 BA.debugLineNum = 348;BA.debugLine="Log(js.ErrorMessage)";
Debug.ShouldStop(134217728);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","56684763",_js.getField(true,"_errormessage" /*RemoteObject*/ ),0);
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
 BA.debugLineNum = 351;BA.debugLine="Log(LastException)";
Debug.ShouldStop(1073741824);
parent.mostCurrent.__c.runVoidMethod ("LogImpl","56684766",BA.ObjectToString(parent.mostCurrent.__c.runMethod(false,"LastException",ingresoestudiante.mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 71:
//C
this.state = -1;
this.catchState = 0;
;
 BA.debugLineNum = 353;BA.debugLine="End Sub";
Debug.ShouldStop(1);
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
BA.rdebugUtils.runVoidMethod("setLastException",ingresoestudiante.processBA, e0.toString());}
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
		Debug.PushSubsStack("retroceder_Click (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,131);
if (RapidSub.canDelegate("retroceder_click")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","retroceder_click");}
 BA.debugLineNum = 131;BA.debugLine="Sub retroceder_Click";
Debug.ShouldStop(4);
 BA.debugLineNum = 132;BA.debugLine="If estado = 1 Then";
Debug.ShouldStop(8);
if (RemoteObject.solveBoolean("=",ingresoestudiante._estado,BA.numberCast(double.class, 1))) { 
 BA.debugLineNum = 133;BA.debugLine="Panel1.Visible = False";
Debug.ShouldStop(16);
ingresoestudiante.mostCurrent._panel1.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 134;BA.debugLine="inicio.Visible = False";
Debug.ShouldStop(32);
ingresoestudiante.mostCurrent._inicio.runMethod(true,"setVisible",ingresoestudiante.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 135;BA.debugLine="estado = 0";
Debug.ShouldStop(64);
ingresoestudiante._estado = BA.numberCast(int.class, 0);
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
public static RemoteObject  _txtconfcone_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconfconE_TextChanged (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,93);
if (RapidSub.canDelegate("txtconfcone_textchanged")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","txtconfcone_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 93;BA.debugLine="Sub txtconfconE_TextChanged (Old As String, New As";
Debug.ShouldStop(268435456);
 BA.debugLineNum = 94;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(536870912);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 95;BA.debugLine="MsgboxAsync(\"La confirmación de la contraseña no";
Debug.ShouldStop(1073741824);
ingresoestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La confirmación de la contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresoestudiante.processBA);
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
public static RemoteObject  _txtconnuve_textchanged(RemoteObject _old,RemoteObject _new) throws Exception{
try {
		Debug.PushSubsStack("txtconnuvE_TextChanged (ingresoestudiante) ","ingresoestudiante",7,ingresoestudiante.mostCurrent.activityBA,ingresoestudiante.mostCurrent,87);
if (RapidSub.canDelegate("txtconnuve_textchanged")) { return b4a.example.ingresoestudiante.remoteMe.runUserSub(false, "ingresoestudiante","txtconnuve_textchanged", _old, _new);}
Debug.locals.put("Old", _old);
Debug.locals.put("New", _new);
 BA.debugLineNum = 87;BA.debugLine="Sub txtconnuvE_TextChanged (Old As String, New As";
Debug.ShouldStop(4194304);
 BA.debugLineNum = 88;BA.debugLine="If New.Length >= 20 Then";
Debug.ShouldStop(8388608);
if (RemoteObject.solveBoolean("g",_new.runMethod(true,"length"),BA.numberCast(double.class, 20))) { 
 BA.debugLineNum = 89;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
Debug.ShouldStop(16777216);
ingresoestudiante.mostCurrent.__c.runVoidMethod ("MsgboxAsync",(Object)(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres")),(Object)(BA.ObjectToCharSequence(RemoteObject.createImmutable("ATENCIÓN"))),ingresoestudiante.processBA);
 };
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
}
package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class main_subs_0 {


public static RemoteObject  _activity_create(RemoteObject _firsttime) throws Exception{
try {
		Debug.PushSubsStack("Activity_Create (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,27);
if (RapidSub.canDelegate("activity_create")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_create", _firsttime);}
Debug.locals.put("FirstTime", _firsttime);
 BA.debugLineNum = 27;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
Debug.ShouldStop(67108864);
 BA.debugLineNum = 29;BA.debugLine="Activity.LoadLayout(\"inicio\")";
Debug.ShouldStop(268435456);
main.mostCurrent._activity.runMethodAndSync(false,"LoadLayout",(Object)(RemoteObject.createImmutable("inicio")),main.mostCurrent.activityBA);
 BA.debugLineNum = 30;BA.debugLine="tiempo.Initialize(\"tiempo\", 2000)";
Debug.ShouldStop(536870912);
main._tiempo.runVoidMethod ("Initialize",main.processBA,(Object)(BA.ObjectToString("tiempo")),(Object)(BA.numberCast(long.class, 2000)));
 BA.debugLineNum = 31;BA.debugLine="tiempo.Enabled= True";
Debug.ShouldStop(1073741824);
main._tiempo.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"True"));
 BA.debugLineNum = 32;BA.debugLine="End Sub";
Debug.ShouldStop(-2147483648);
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
		Debug.PushSubsStack("Activity_Pause (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,44);
if (RapidSub.canDelegate("activity_pause")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_pause", _userclosed);}
Debug.locals.put("UserClosed", _userclosed);
 BA.debugLineNum = 44;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
Debug.ShouldStop(2048);
 BA.debugLineNum = 46;BA.debugLine="End Sub";
Debug.ShouldStop(8192);
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
		Debug.PushSubsStack("Activity_Resume (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,40);
if (RapidSub.canDelegate("activity_resume")) { return b4a.example.main.remoteMe.runUserSub(false, "main","activity_resume");}
 BA.debugLineNum = 40;BA.debugLine="Sub Activity_Resume";
Debug.ShouldStop(128);
 BA.debugLineNum = 42;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _globals() throws Exception{
 //BA.debugLineNum = 21;BA.debugLine="Sub Globals";
 //BA.debugLineNum = 25;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}

public static void initializeProcessGlobals() {
    
    if (main.processGlobalsRun == false) {
	    main.processGlobalsRun = true;
		try {
		        main_subs_0._process_globals();
starter_subs_0._process_globals();
perfiles_subs_0._process_globals();
ingresodocente_subs_0._process_globals();
ingreso_subs_0._process_globals();
ingresoestudiante_subs_0._process_globals();
inicioacudiente_subs_0._process_globals();
iniciodocente_subs_0._process_globals();
inicioestudiante_subs_0._process_globals();
registroacudiente_subs_0._process_globals();
registrodocente_subs_0._process_globals();
registroestudiante_subs_0._process_globals();
httputils2service_subs_0._process_globals();
main.myClass = BA.getDeviceClass ("b4a.example.main");
starter.myClass = BA.getDeviceClass ("b4a.example.starter");
perfiles.myClass = BA.getDeviceClass ("b4a.example.perfiles");
ingresodocente.myClass = BA.getDeviceClass ("b4a.example.ingresodocente");
ingreso.myClass = BA.getDeviceClass ("b4a.example.ingreso");
ingresoestudiante.myClass = BA.getDeviceClass ("b4a.example.ingresoestudiante");
inicioacudiente.myClass = BA.getDeviceClass ("b4a.example.inicioacudiente");
iniciodocente.myClass = BA.getDeviceClass ("b4a.example.iniciodocente");
inicioestudiante.myClass = BA.getDeviceClass ("b4a.example.inicioestudiante");
registroacudiente.myClass = BA.getDeviceClass ("b4a.example.registroacudiente");
registrodocente.myClass = BA.getDeviceClass ("b4a.example.registrodocente");
registroestudiante.myClass = BA.getDeviceClass ("b4a.example.registroestudiante");
httputils2service.myClass = BA.getDeviceClass ("b4a.example.httputils2service");
httpjob.myClass = BA.getDeviceClass ("b4a.example.httpjob");
		
        } catch (Exception e) {
			throw new RuntimeException(e);
		}
    }
}public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 15;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 18;BA.debugLine="Dim tiempo As Timer";
main._tiempo = RemoteObject.createNew ("anywheresoftware.b4a.objects.Timer");
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _tiempo_tick() throws Exception{
try {
		Debug.PushSubsStack("tiempo_Tick (main) ","main",0,main.mostCurrent.activityBA,main.mostCurrent,34);
if (RapidSub.canDelegate("tiempo_tick")) { return b4a.example.main.remoteMe.runUserSub(false, "main","tiempo_tick");}
 BA.debugLineNum = 34;BA.debugLine="Sub tiempo_Tick";
Debug.ShouldStop(2);
 BA.debugLineNum = 35;BA.debugLine="StartActivity(perfiles)";
Debug.ShouldStop(4);
main.mostCurrent.__c.runVoidMethod ("StartActivity",main.processBA,(Object)((main.mostCurrent._perfiles.getObject())));
 BA.debugLineNum = 36;BA.debugLine="Activity.Finish";
Debug.ShouldStop(8);
main.mostCurrent._activity.runVoidMethod ("Finish");
 BA.debugLineNum = 37;BA.debugLine="tiempo.Enabled= False";
Debug.ShouldStop(16);
main._tiempo.runMethod(true,"setEnabled",main.mostCurrent.__c.getField(true,"False"));
 BA.debugLineNum = 38;BA.debugLine="End Sub";
Debug.ShouldStop(32);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
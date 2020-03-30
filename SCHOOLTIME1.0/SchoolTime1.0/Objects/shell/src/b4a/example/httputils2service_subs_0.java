package b4a.example;

import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.*;

public class httputils2service_subs_0 {


public static RemoteObject  _completejob(RemoteObject _taskid,RemoteObject _success,RemoteObject _errormessage) throws Exception{
try {
		Debug.PushSubsStack("CompleteJob (httputils2service) ","httputils2service",12,httputils2service.processBA,httputils2service.mostCurrent,109);
if (RapidSub.canDelegate("completejob")) { return b4a.example.httputils2service.remoteMe.runUserSub(false, "httputils2service","completejob", _taskid, _success, _errormessage);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("TaskId", _taskid);
Debug.locals.put("success", _success);
Debug.locals.put("errorMessage", _errormessage);
 BA.debugLineNum = 109;BA.debugLine="Sub CompleteJob(TaskId As Int, success As Boolean,";
Debug.ShouldStop(4096);
 BA.debugLineNum = 113;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
Debug.ShouldStop(65536);
_job = (httputils2service._taskidtojob.runMethod(false,"Get",(Object)((_taskid))));Debug.locals.put("job", _job);Debug.locals.put("job", _job);
 BA.debugLineNum = 114;BA.debugLine="TaskIdToJob.Remove(TaskId)";
Debug.ShouldStop(131072);
httputils2service._taskidtojob.runVoidMethod ("Remove",(Object)((_taskid)));
 BA.debugLineNum = 115;BA.debugLine="job.success = success";
Debug.ShouldStop(262144);
_job.setField ("_success" /*RemoteObject*/ ,_success);
 BA.debugLineNum = 116;BA.debugLine="job.errorMessage = errorMessage";
Debug.ShouldStop(524288);
_job.setField ("_errormessage" /*RemoteObject*/ ,_errormessage);
 BA.debugLineNum = 118;BA.debugLine="job.Complete(TaskId)";
Debug.ShouldStop(2097152);
_job.runClassMethod (b4a.example.httpjob.class, "_complete" /*RemoteObject*/ ,(Object)(_taskid));
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
public static RemoteObject  _hc_responseerror(RemoteObject _response,RemoteObject _reason,RemoteObject _statuscode,RemoteObject _taskid) throws Exception{
try {
		Debug.PushSubsStack("hc_ResponseError (httputils2service) ","httputils2service",12,httputils2service.processBA,httputils2service.mostCurrent,84);
if (RapidSub.canDelegate("hc_responseerror")) { return b4a.example.httputils2service.remoteMe.runUserSub(false, "httputils2service","hc_responseerror", _response, _reason, _statuscode, _taskid);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("Response", _response);
Debug.locals.put("Reason", _reason);
Debug.locals.put("StatusCode", _statuscode);
Debug.locals.put("TaskId", _taskid);
 BA.debugLineNum = 84;BA.debugLine="Sub hc_ResponseError (Response As OkHttpResponse,";
Debug.ShouldStop(524288);
 BA.debugLineNum = 85;BA.debugLine="Log($\"ResponseError. Reason: ${Reason}, Response:";
Debug.ShouldStop(1048576);
httputils2service.mostCurrent.__c.runVoidMethod ("LogImpl","711141121",(RemoteObject.concat(RemoteObject.createImmutable("ResponseError. Reason: "),httputils2service.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_reason))),RemoteObject.createImmutable(", Response: "),httputils2service.mostCurrent.__c.runMethod(true,"SmartStringFormatter",(Object)(BA.ObjectToString("")),(Object)((_response.runMethod(true,"getErrorResponse")))),RemoteObject.createImmutable(""))),0);
 BA.debugLineNum = 86;BA.debugLine="Response.Release";
Debug.ShouldStop(2097152);
_response.runVoidMethod ("Release");
 BA.debugLineNum = 87;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
Debug.ShouldStop(4194304);
_job = (httputils2service._taskidtojob.runMethod(false,"Get",(Object)((_taskid))));Debug.locals.put("job", _job);Debug.locals.put("job", _job);
 BA.debugLineNum = 88;BA.debugLine="job.Response = Response";
Debug.ShouldStop(8388608);
_job.setField ("_response" /*RemoteObject*/ ,_response);
 BA.debugLineNum = 89;BA.debugLine="If Response.ErrorResponse <> \"\" Then";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("!",_response.runMethod(true,"getErrorResponse"),BA.ObjectToString(""))) { 
 BA.debugLineNum = 90;BA.debugLine="CompleteJob(TaskId, False, Response.ErrorRespons";
Debug.ShouldStop(33554432);
_completejob(_taskid,httputils2service.mostCurrent.__c.getField(true,"False"),_response.runMethod(true,"getErrorResponse"));
 }else {
 BA.debugLineNum = 92;BA.debugLine="CompleteJob(TaskId, False, Reason)";
Debug.ShouldStop(134217728);
_completejob(_taskid,httputils2service.mostCurrent.__c.getField(true,"False"),_reason);
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
public static RemoteObject  _hc_responsesuccess(RemoteObject _response,RemoteObject _taskid) throws Exception{
try {
		Debug.PushSubsStack("hc_ResponseSuccess (httputils2service) ","httputils2service",12,httputils2service.processBA,httputils2service.mostCurrent,69);
if (RapidSub.canDelegate("hc_responsesuccess")) { return b4a.example.httputils2service.remoteMe.runUserSub(false, "httputils2service","hc_responsesuccess", _response, _taskid);}
RemoteObject _job = RemoteObject.declareNull("b4a.example.httpjob");
Debug.locals.put("Response", _response);
Debug.locals.put("TaskId", _taskid);
 BA.debugLineNum = 69;BA.debugLine="Sub hc_ResponseSuccess (Response As OkHttpResponse";
Debug.ShouldStop(16);
 BA.debugLineNum = 70;BA.debugLine="Dim job As HttpJob = TaskIdToJob.Get(TaskId)";
Debug.ShouldStop(32);
_job = (httputils2service._taskidtojob.runMethod(false,"Get",(Object)((_taskid))));Debug.locals.put("job", _job);Debug.locals.put("job", _job);
 BA.debugLineNum = 71;BA.debugLine="job.Response = Response";
Debug.ShouldStop(64);
_job.setField ("_response" /*RemoteObject*/ ,_response);
 BA.debugLineNum = 72;BA.debugLine="Response.GetAsynchronously(\"response\", File.OpenO";
Debug.ShouldStop(128);
_response.runVoidMethod ("GetAsynchronously",httputils2service.processBA,(Object)(BA.ObjectToString("response")),(Object)((httputils2service.mostCurrent.__c.getField(false,"File").runMethod(false,"OpenOutput",(Object)(httputils2service._tempfolder),(Object)(BA.NumberToString(_taskid)),(Object)(httputils2service.mostCurrent.__c.getField(true,"False"))).getObject())),(Object)(httputils2service.mostCurrent.__c.getField(true,"True")),(Object)(_taskid));
 BA.debugLineNum = 74;BA.debugLine="End Sub";
Debug.ShouldStop(512);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
public static RemoteObject  _process_globals() throws Exception{
 //BA.debugLineNum = 2;BA.debugLine="Sub Process_Globals";
 //BA.debugLineNum = 11;BA.debugLine="Private hc As OkHttpClient";
httputils2service._hc = RemoteObject.createNew ("anywheresoftware.b4h.okhttp.OkHttpClientWrapper");
 //BA.debugLineNum = 16;BA.debugLine="Private TaskIdToJob As Map";
httputils2service._taskidtojob = RemoteObject.createNew ("anywheresoftware.b4a.objects.collections.Map");
 //BA.debugLineNum = 17;BA.debugLine="Public TempFolder As String";
httputils2service._tempfolder = RemoteObject.createImmutable("");
 //BA.debugLineNum = 18;BA.debugLine="Private taskCounter As Int";
httputils2service._taskcounter = RemoteObject.createImmutable(0);
 //BA.debugLineNum = 19;BA.debugLine="End Sub";
return RemoteObject.createImmutable("");
}
public static RemoteObject  _response_streamfinish(RemoteObject _success,RemoteObject _taskid) throws Exception{
try {
		Debug.PushSubsStack("Response_StreamFinish (httputils2service) ","httputils2service",12,httputils2service.processBA,httputils2service.mostCurrent,76);
if (RapidSub.canDelegate("response_streamfinish")) { return b4a.example.httputils2service.remoteMe.runUserSub(false, "httputils2service","response_streamfinish", _success, _taskid);}
Debug.locals.put("Success", _success);
Debug.locals.put("TaskId", _taskid);
 BA.debugLineNum = 76;BA.debugLine="Private Sub Response_StreamFinish (Success As Bool";
Debug.ShouldStop(2048);
 BA.debugLineNum = 77;BA.debugLine="If Success Then";
Debug.ShouldStop(4096);
if (_success.<Boolean>get().booleanValue()) { 
 BA.debugLineNum = 78;BA.debugLine="CompleteJob(TaskId, Success, \"\")";
Debug.ShouldStop(8192);
_completejob(_taskid,_success,RemoteObject.createImmutable(""));
 }else {
 BA.debugLineNum = 80;BA.debugLine="CompleteJob(TaskId, Success, LastException.Messa";
Debug.ShouldStop(32768);
_completejob(_taskid,_success,httputils2service.mostCurrent.__c.runMethod(false,"LastException",httputils2service.processBA).runMethod(true,"getMessage"));
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
public static RemoteObject  _service_create() throws Exception{
try {
		Debug.PushSubsStack("Service_Create (httputils2service) ","httputils2service",12,httputils2service.processBA,httputils2service.mostCurrent,21);
if (RapidSub.canDelegate("service_create")) { return b4a.example.httputils2service.remoteMe.runUserSub(false, "httputils2service","service_create");}
 BA.debugLineNum = 21;BA.debugLine="Sub Service_Create";
Debug.ShouldStop(1048576);
 BA.debugLineNum = 23;BA.debugLine="TempFolder = File.DirInternalCache";
Debug.ShouldStop(4194304);
httputils2service._tempfolder = httputils2service.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternalCache");
 BA.debugLineNum = 24;BA.debugLine="Try";
Debug.ShouldStop(8388608);
try { BA.debugLineNum = 25;BA.debugLine="File.WriteString(TempFolder, \"~test.test\", \"test";
Debug.ShouldStop(16777216);
httputils2service.mostCurrent.__c.getField(false,"File").runVoidMethod ("WriteString",(Object)(httputils2service._tempfolder),(Object)(BA.ObjectToString("~test.test")),(Object)(RemoteObject.createImmutable("test")));
 BA.debugLineNum = 26;BA.debugLine="File.Delete(TempFolder, \"~test.test\")";
Debug.ShouldStop(33554432);
httputils2service.mostCurrent.__c.getField(false,"File").runVoidMethod ("Delete",(Object)(httputils2service._tempfolder),(Object)(RemoteObject.createImmutable("~test.test")));
 Debug.CheckDeviceExceptions();
} 
       catch (Exception e6) {
			BA.rdebugUtils.runVoidMethod("setLastException",httputils2service.processBA, e6.toString()); BA.debugLineNum = 28;BA.debugLine="Log(LastException)";
Debug.ShouldStop(134217728);
httputils2service.mostCurrent.__c.runVoidMethod ("LogImpl","710747911",BA.ObjectToString(httputils2service.mostCurrent.__c.runMethod(false,"LastException",httputils2service.processBA)),0);
 BA.debugLineNum = 29;BA.debugLine="Log(\"Switching to File.DirInternal\")";
Debug.ShouldStop(268435456);
httputils2service.mostCurrent.__c.runVoidMethod ("LogImpl","710747912",RemoteObject.createImmutable("Switching to File.DirInternal"),0);
 BA.debugLineNum = 30;BA.debugLine="TempFolder = File.DirInternal";
Debug.ShouldStop(536870912);
httputils2service._tempfolder = httputils2service.mostCurrent.__c.getField(false,"File").runMethod(true,"getDirInternal");
 };
 BA.debugLineNum = 35;BA.debugLine="If hc.IsInitialized = False Then";
Debug.ShouldStop(4);
if (RemoteObject.solveBoolean("=",httputils2service._hc.runMethod(true,"IsInitialized"),httputils2service.mostCurrent.__c.getField(true,"False"))) { 
 BA.debugLineNum = 40;BA.debugLine="hc.Initialize(\"hc\")";
Debug.ShouldStop(128);
httputils2service._hc.runVoidMethod ("Initialize",(Object)(RemoteObject.createImmutable("hc")));
 };
 BA.debugLineNum = 43;BA.debugLine="TaskIdToJob.Initialize";
Debug.ShouldStop(1024);
httputils2service._taskidtojob.runVoidMethod ("Initialize");
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
public static RemoteObject  _service_destroy() throws Exception{
try {
		Debug.PushSubsStack("Service_Destroy (httputils2service) ","httputils2service",12,httputils2service.processBA,httputils2service.mostCurrent,50);
if (RapidSub.canDelegate("service_destroy")) { return b4a.example.httputils2service.remoteMe.runUserSub(false, "httputils2service","service_destroy");}
 BA.debugLineNum = 50;BA.debugLine="Sub Service_Destroy";
Debug.ShouldStop(131072);
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
public static RemoteObject  _service_start(RemoteObject _startingintent) throws Exception{
try {
		Debug.PushSubsStack("Service_Start (httputils2service) ","httputils2service",12,httputils2service.processBA,httputils2service.mostCurrent,46);
if (RapidSub.canDelegate("service_start")) { return b4a.example.httputils2service.remoteMe.runUserSub(false, "httputils2service","service_start", _startingintent);}
Debug.locals.put("StartingIntent", _startingintent);
 BA.debugLineNum = 46;BA.debugLine="Sub Service_Start (StartingIntent As Intent)";
Debug.ShouldStop(8192);
 BA.debugLineNum = 47;BA.debugLine="Service.StopAutomaticForeground";
Debug.ShouldStop(16384);
httputils2service.mostCurrent._service.runVoidMethod ("StopAutomaticForeground");
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
public static RemoteObject  _submitjob(RemoteObject _job) throws Exception{
try {
		Debug.PushSubsStack("SubmitJob (httputils2service) ","httputils2service",12,httputils2service.processBA,httputils2service.mostCurrent,56);
if (RapidSub.canDelegate("submitjob")) { return b4a.example.httputils2service.remoteMe.runUserSub(false, "httputils2service","submitjob", _job);}
Debug.locals.put("job", _job);
 BA.debugLineNum = 56;BA.debugLine="Public Sub SubmitJob(job As HttpJob)";
Debug.ShouldStop(8388608);
 BA.debugLineNum = 57;BA.debugLine="If TaskIdToJob.IsInitialized = False Then Service";
Debug.ShouldStop(16777216);
if (RemoteObject.solveBoolean("=",httputils2service._taskidtojob.runMethod(true,"IsInitialized"),httputils2service.mostCurrent.__c.getField(true,"False"))) { 
_service_create();};
 BA.debugLineNum = 58;BA.debugLine="taskCounter = taskCounter + 1";
Debug.ShouldStop(33554432);
httputils2service._taskcounter = RemoteObject.solve(new RemoteObject[] {httputils2service._taskcounter,RemoteObject.createImmutable(1)}, "+",1, 1);
 BA.debugLineNum = 59;BA.debugLine="TaskIdToJob.Put(taskCounter, job)";
Debug.ShouldStop(67108864);
httputils2service._taskidtojob.runVoidMethod ("Put",(Object)((httputils2service._taskcounter)),(Object)((_job)));
 BA.debugLineNum = 60;BA.debugLine="If job.Username <> \"\" And job.Password <> \"\" Then";
Debug.ShouldStop(134217728);
if (RemoteObject.solveBoolean("!",_job.getField(true,"_username" /*RemoteObject*/ ),BA.ObjectToString("")) && RemoteObject.solveBoolean("!",_job.getField(true,"_password" /*RemoteObject*/ ),BA.ObjectToString(""))) { 
 BA.debugLineNum = 61;BA.debugLine="hc.ExecuteCredentials(job.GetRequest, taskCounte";
Debug.ShouldStop(268435456);
httputils2service._hc.runVoidMethod ("ExecuteCredentials",httputils2service.processBA,(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ )),(Object)(httputils2service._taskcounter),(Object)(_job.getField(true,"_username" /*RemoteObject*/ )),(Object)(_job.getField(true,"_password" /*RemoteObject*/ )));
 }else {
 BA.debugLineNum = 63;BA.debugLine="hc.Execute(job.GetRequest, taskCounter)";
Debug.ShouldStop(1073741824);
httputils2service._hc.runVoidMethod ("Execute",httputils2service.processBA,(Object)(_job.runClassMethod (b4a.example.httpjob.class, "_getrequest" /*RemoteObject*/ )),(Object)(httputils2service._taskcounter));
 };
 BA.debugLineNum = 65;BA.debugLine="End Sub";
Debug.ShouldStop(1);
return RemoteObject.createImmutable("");
}
catch (Exception e) {
			throw Debug.ErrorCaught(e);
		} 
finally {
			Debug.PopSubsStack();
		}}
}
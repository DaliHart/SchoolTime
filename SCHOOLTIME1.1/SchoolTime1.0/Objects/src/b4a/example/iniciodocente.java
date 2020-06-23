package b4a.example;


import anywheresoftware.b4a.B4AMenuItem;
import android.app.Activity;
import android.os.Bundle;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.BALayout;
import anywheresoftware.b4a.B4AActivity;
import anywheresoftware.b4a.ObjectWrapper;
import anywheresoftware.b4a.objects.ActivityWrapper;
import java.lang.reflect.InvocationTargetException;
import anywheresoftware.b4a.B4AUncaughtException;
import anywheresoftware.b4a.debug.*;
import java.lang.ref.WeakReference;

public class iniciodocente extends Activity implements B4AActivity{
	public static iniciodocente mostCurrent;
	static boolean afterFirstLayout;
	static boolean isFirst = true;
    private static boolean processGlobalsRun = false;
	BALayout layout;
	public static BA processBA;
	BA activityBA;
    ActivityWrapper _activity;
    java.util.ArrayList<B4AMenuItem> menuItems;
	public static final boolean fullScreen = true;
	public static final boolean includeTitle = false;
    public static WeakReference<Activity> previousOne;
    public static boolean dontPause;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.iniciodocente");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (iniciodocente).");
				p.finish();
			}
		}
        processBA.setActivityPaused(true);
        processBA.runHook("oncreate", this, null);
		if (!includeTitle) {
        	this.getWindow().requestFeature(android.view.Window.FEATURE_NO_TITLE);
        }
        if (fullScreen) {
        	getWindow().setFlags(android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN,   
        			android.view.WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
		
        processBA.sharedProcessBA.activityBA = null;
		layout = new BALayout(this);
		setContentView(layout);
		afterFirstLayout = false;
        WaitForLayout wl = new WaitForLayout();
        if (anywheresoftware.b4a.objects.ServiceHelper.StarterHelper.startFromActivity(this, processBA, wl, false))
		    BA.handler.postDelayed(wl, 5);

	}
	static class WaitForLayout implements Runnable {
		public void run() {
			if (afterFirstLayout)
				return;
			if (mostCurrent == null)
				return;
            
			if (mostCurrent.layout.getWidth() == 0) {
				BA.handler.postDelayed(this, 5);
				return;
			}
			mostCurrent.layout.getLayoutParams().height = mostCurrent.layout.getHeight();
			mostCurrent.layout.getLayoutParams().width = mostCurrent.layout.getWidth();
			afterFirstLayout = true;
			mostCurrent.afterFirstLayout();
		}
	}
	private void afterFirstLayout() {
        if (this != mostCurrent)
			return;
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.iniciodocente");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.iniciodocente", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (iniciodocente) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (iniciodocente) Resume **");
        processBA.raiseEvent(null, "activity_resume");
        if (android.os.Build.VERSION.SDK_INT >= 11) {
			try {
				android.app.Activity.class.getMethod("invalidateOptionsMenu").invoke(this,(Object[]) null);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	public void addMenuItem(B4AMenuItem item) {
		if (menuItems == null)
			menuItems = new java.util.ArrayList<B4AMenuItem>();
		menuItems.add(item);
	}
	@Override
	public boolean onCreateOptionsMenu(android.view.Menu menu) {
		super.onCreateOptionsMenu(menu);
        try {
            if (processBA.subExists("activity_actionbarhomeclick")) {
                Class.forName("android.app.ActionBar").getMethod("setHomeButtonEnabled", boolean.class).invoke(
                    getClass().getMethod("getActionBar").invoke(this), true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (processBA.runHook("oncreateoptionsmenu", this, new Object[] {menu}))
            return true;
		if (menuItems == null)
			return false;
		for (B4AMenuItem bmi : menuItems) {
			android.view.MenuItem mi = menu.add(bmi.title);
			if (bmi.drawable != null)
				mi.setIcon(bmi.drawable);
            if (android.os.Build.VERSION.SDK_INT >= 11) {
				try {
                    if (bmi.addToBar) {
				        android.view.MenuItem.class.getMethod("setShowAsAction", int.class).invoke(mi, 1);
                    }
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			mi.setOnMenuItemClickListener(new B4AMenuItemsClickListener(bmi.eventName.toLowerCase(BA.cul)));
		}
        
		return true;
	}   
 @Override
 public boolean onOptionsItemSelected(android.view.MenuItem item) {
    if (item.getItemId() == 16908332) {
        processBA.raiseEvent(null, "activity_actionbarhomeclick");
        return true;
    }
    else
        return super.onOptionsItemSelected(item); 
}
@Override
 public boolean onPrepareOptionsMenu(android.view.Menu menu) {
    super.onPrepareOptionsMenu(menu);
    processBA.runHook("onprepareoptionsmenu", this, new Object[] {menu});
    return true;
    
 }
 protected void onStart() {
    super.onStart();
    processBA.runHook("onstart", this, null);
}
 protected void onStop() {
    super.onStop();
    processBA.runHook("onstop", this, null);
}
    public void onWindowFocusChanged(boolean hasFocus) {
       super.onWindowFocusChanged(hasFocus);
       if (processBA.subExists("activity_windowfocuschanged"))
           processBA.raiseEvent2(null, true, "activity_windowfocuschanged", false, hasFocus);
    }
	private class B4AMenuItemsClickListener implements android.view.MenuItem.OnMenuItemClickListener {
		private final String eventName;
		public B4AMenuItemsClickListener(String eventName) {
			this.eventName = eventName;
		}
		public boolean onMenuItemClick(android.view.MenuItem item) {
			processBA.raiseEventFromUI(item.getTitle(), eventName + "_click");
			return true;
		}
	}
    public static Class<?> getObject() {
		return iniciodocente.class;
	}
    private Boolean onKeySubExist = null;
    private Boolean onKeyUpSubExist = null;
	@Override
	public boolean onKeyDown(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeydown", this, new Object[] {keyCode, event}))
            return true;
		if (onKeySubExist == null)
			onKeySubExist = processBA.subExists("activity_keypress");
		if (onKeySubExist) {
			if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK &&
					android.os.Build.VERSION.SDK_INT >= 18) {
				HandleKeyDelayed hk = new HandleKeyDelayed();
				hk.kc = keyCode;
				BA.handler.post(hk);
				return true;
			}
			else {
				boolean res = new HandleKeyDelayed().runDirectly(keyCode);
				if (res)
					return true;
			}
		}
		return super.onKeyDown(keyCode, event);
	}
	private class HandleKeyDelayed implements Runnable {
		int kc;
		public void run() {
			runDirectly(kc);
		}
		public boolean runDirectly(int keyCode) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keypress", false, keyCode);
			if (res == null || res == true) {
                return true;
            }
            else if (keyCode == anywheresoftware.b4a.keywords.constants.KeyCodes.KEYCODE_BACK) {
				finish();
				return true;
			}
            return false;
		}
		
	}
    @Override
	public boolean onKeyUp(int keyCode, android.view.KeyEvent event) {
        if (processBA.runHook("onkeyup", this, new Object[] {keyCode, event}))
            return true;
		if (onKeyUpSubExist == null)
			onKeyUpSubExist = processBA.subExists("activity_keyup");
		if (onKeyUpSubExist) {
			Boolean res =  (Boolean)processBA.raiseEvent2(_activity, false, "activity_keyup", false, keyCode);
			if (res == null || res == true)
				return true;
		}
		return super.onKeyUp(keyCode, event);
	}
	@Override
	public void onNewIntent(android.content.Intent intent) {
        super.onNewIntent(intent);
		this.setIntent(intent);
        processBA.runHook("onnewintent", this, new Object[] {intent});
	}
    @Override 
	public void onPause() {
		super.onPause();
        if (_activity == null)
            return;
        if (this != mostCurrent)
			return;
		anywheresoftware.b4a.Msgbox.dismiss(true);
        if (!dontPause)
            BA.LogInfo("** Activity (iniciodocente) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (iniciodocente) Pause event (activity is not paused). **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        if (!dontPause) {
            processBA.setActivityPaused(true);
            mostCurrent = null;
        }

        if (!activityBA.activity.isFinishing())
			previousOne = new WeakReference<Activity>(this);
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        processBA.runHook("onpause", this, null);
	}

	@Override
	public void onDestroy() {
        super.onDestroy();
		previousOne = null;
        processBA.runHook("ondestroy", this, null);
	}
    @Override 
	public void onResume() {
		super.onResume();
        mostCurrent = this;
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (activityBA != null) { //will be null during activity create (which waits for AfterLayout).
        	ResumeMessage rm = new ResumeMessage(mostCurrent);
        	BA.handler.post(rm);
        }
        processBA.runHook("onresume", this, null);
	}
    private static class ResumeMessage implements Runnable {
    	private final WeakReference<Activity> activity;
    	public ResumeMessage(Activity activity) {
    		this.activity = new WeakReference<Activity>(activity);
    	}
		public void run() {
            iniciodocente mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (iniciodocente) Resume **");
            if (mc != mostCurrent)
                return;
		    processBA.raiseEvent(mc._activity, "activity_resume", (Object[])null);
		}
    }
	@Override
	protected void onActivityResult(int requestCode, int resultCode,
	      android.content.Intent data) {
		processBA.onActivityResult(requestCode, resultCode, data);
        processBA.runHook("onactivityresult", this, new Object[] {requestCode, resultCode});
	}
	private static void initializeGlobals() {
		processBA.raiseEvent2(null, true, "globals", false, (Object[])null);
	}
    public void onRequestPermissionsResult(int requestCode,
        String permissions[], int[] grantResults) {
        for (int i = 0;i < permissions.length;i++) {
            Object[] o = new Object[] {permissions[i], grantResults[i] == 0};
            processBA.raiseEventFromDifferentThread(null,null, 0, "activity_permissionresult", true, o);
        }
            
    }



public static void initializeProcessGlobals() {
             try {
                Class.forName(BA.applicationContext.getPackageName() + ".main").getMethod("initializeProcessGlobals").invoke(null, null);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
}
public anywheresoftware.b4a.keywords.Common __c = null;
public anywheresoftware.b4a.objects.LabelWrapper _opcionregistro = null;
public anywheresoftware.b4a.objects.LabelWrapper _retroceder = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcorreodococente = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcontrasenadocente = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btniniciardococente = null;
public b4a.example.main _main = null;
public b4a.example.ingreso _ingreso = null;
public b4a.example.ingresodocente _ingresodocente = null;
public b4a.example.ingresoestudiante _ingresoestudiante = null;
public b4a.example.inicioacudiente _inicioacudiente = null;
public b4a.example.inicioestudiante _inicioestudiante = null;
public b4a.example.perfiles _perfiles = null;
public b4a.example.registroacudiente _registroacudiente = null;
public b4a.example.registrodocente _registrodocente = null;
public b4a.example.registroestudiante _registroestudiante = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="iniciodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=7864320;
 //BA.debugLineNum = 7864320;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=7864322;
 //BA.debugLineNum = 7864322;BA.debugLine="Activity.LoadLayout(\"inicioDocente\")";
mostCurrent._activity.LoadLayout("inicioDocente",mostCurrent.activityBA);
RDebugUtils.currentLine=7864324;
 //BA.debugLineNum = 7864324;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="iniciodocente";
RDebugUtils.currentLine=7995392;
 //BA.debugLineNum = 7995392;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=7995394;
 //BA.debugLineNum = 7995394;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="iniciodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=7929856;
 //BA.debugLineNum = 7929856;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=7929858;
 //BA.debugLineNum = 7929858;BA.debugLine="End Sub";
return "";
}
public static String  _btniniciardococente_click() throws Exception{
RDebugUtils.currentModule="iniciodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btniniciardococente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btniniciardococente_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Sub btniniciardococente_Click";
RDebugUtils.currentLine=8323073;
 //BA.debugLineNum = 8323073;BA.debugLine="If txtcorreodococente.Text <> \"\" And txtContrasen";
if ((mostCurrent._txtcorreodococente.getText()).equals("") == false && (mostCurrent._txtcontrasenadocente.getText()).equals("") == false) { 
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/s";
_apiaddress = "http://192.168.1.1/schooltime1.php";
RDebugUtils.currentLine=8323079;
 //BA.debugLineNum = 8323079;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=8323080;
 //BA.debugLineNum = 8323080;BA.debugLine="job.Initialize(\"usuario_existe\", Me)";
_job._initialize /*String*/ (null,processBA,"usuario_existe",iniciodocente.getObject());
RDebugUtils.currentLine=8323081;
 //BA.debugLineNum = 8323081;BA.debugLine="job.PostString(ApiAddress,\"SELECT * FROM tbl_doc";
_job._poststring /*String*/ (null,_apiaddress,"SELECT * FROM tbl_docente where correo_doc= '"+mostCurrent._txtcorreodococente.getText()+"'and contrasena_doc='"+mostCurrent._txtcontrasenadocente.getText()+"'");
 }else {
RDebugUtils.currentLine=8323083;
 //BA.debugLineNum = 8323083;BA.debugLine="MsgboxAsync(\"Todos los campos son necesarios par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son necesarios para el ingreso"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=8323085;
 //BA.debugLineNum = 8323085;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="iniciodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _usuarios = null;
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=8388609;
 //BA.debugLineNum = 8388609;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=8388611;
 //BA.debugLineNum = 8388611;BA.debugLine="res = Job.GetString";
_res = _job._getstring /*String*/ (null);
RDebugUtils.currentLine=8388612;
 //BA.debugLineNum = 8388612;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=8388613;
 //BA.debugLineNum = 8388613;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=8388614;
 //BA.debugLineNum = 8388614;BA.debugLine="If Job.JobName= \"usuario_existe\" Then";
if ((_job._jobname /*String*/ ).equals("usuario_existe")) { 
RDebugUtils.currentLine=8388615;
 //BA.debugLineNum = 8388615;BA.debugLine="Dim usuarios As List";
_usuarios = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=8388616;
 //BA.debugLineNum = 8388616;BA.debugLine="usuarios = parser.NextArray";
_usuarios = _parser.NextArray();
RDebugUtils.currentLine=8388617;
 //BA.debugLineNum = 8388617;BA.debugLine="If usuarios.Size > 0 Then";
if (_usuarios.getSize()>0) { 
RDebugUtils.currentLine=8388618;
 //BA.debugLineNum = 8388618;BA.debugLine="StartActivity(ingresoDocente)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ingresodocente.getObject()));
RDebugUtils.currentLine=8388619;
 //BA.debugLineNum = 8388619;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
RDebugUtils.currentLine=8388621;
 //BA.debugLineNum = 8388621;BA.debugLine="MsgboxAsync(\"El usuario no se encuentra regist";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El usuario no se encuentra registrado, por favor intentelo de nuevo"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
RDebugUtils.currentLine=8388622;
 //BA.debugLineNum = 8388622;BA.debugLine="txtcorreodococente.Text= \"\"";
mostCurrent._txtcorreodococente.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=8388623;
 //BA.debugLineNum = 8388623;BA.debugLine="txtContrasenadocente.Text= \"\"";
mostCurrent._txtcontrasenadocente.setText(BA.ObjectToCharSequence(""));
 };
 };
 }else {
RDebugUtils.currentLine=8388627;
 //BA.debugLineNum = 8388627;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("08388627",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=8388628;
 //BA.debugLineNum = 8388628;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=8388630;
 //BA.debugLineNum = 8388630;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=8388631;
 //BA.debugLineNum = 8388631;BA.debugLine="End Sub";
return "";
}
public static String  _opcionregistro_click() throws Exception{
RDebugUtils.currentModule="iniciodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "opcionregistro_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "opcionregistro_click", null));}
RDebugUtils.currentLine=8060928;
 //BA.debugLineNum = 8060928;BA.debugLine="Sub opcionregistro_Click";
RDebugUtils.currentLine=8060929;
 //BA.debugLineNum = 8060929;BA.debugLine="StartActivity(registroDocente)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._registrodocente.getObject()));
RDebugUtils.currentLine=8060930;
 //BA.debugLineNum = 8060930;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=8060931;
 //BA.debugLineNum = 8060931;BA.debugLine="End Sub";
return "";
}
public static String  _retroceder_click() throws Exception{
RDebugUtils.currentModule="iniciodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "retroceder_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "retroceder_click", null));}
RDebugUtils.currentLine=8126464;
 //BA.debugLineNum = 8126464;BA.debugLine="Sub retroceder_Click";
RDebugUtils.currentLine=8126465;
 //BA.debugLineNum = 8126465;BA.debugLine="StartActivity(perfiles)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._perfiles.getObject()));
RDebugUtils.currentLine=8126466;
 //BA.debugLineNum = 8126466;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=8126467;
 //BA.debugLineNum = 8126467;BA.debugLine="End Sub";
return "";
}
public static String  _txtcontrasenadocente_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="iniciodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcontrasenadocente_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtcontrasenadocente_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8257536;
 //BA.debugLineNum = 8257536;BA.debugLine="Sub txtContrasenadocente_TextChanged (Old As Strin";
RDebugUtils.currentLine=8257537;
 //BA.debugLineNum = 8257537;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=8257538;
 //BA.debugLineNum = 8257538;BA.debugLine="MsgboxAsync(\"La contraseña no puede sobrepasar l";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=8257540;
 //BA.debugLineNum = 8257540;BA.debugLine="End Sub";
return "";
}
public static String  _txtcorreodococente_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="iniciodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcorreodococente_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtcorreodococente_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8192000;
 //BA.debugLineNum = 8192000;BA.debugLine="Sub txtcorreodococente_TextChanged (Old As String,";
RDebugUtils.currentLine=8192001;
 //BA.debugLineNum = 8192001;BA.debugLine="If New.Length >= 49 Then";
if (_new.length()>=49) { 
RDebugUtils.currentLine=8192002;
 //BA.debugLineNum = 8192002;BA.debugLine="MsgboxAsync(\"El correo no puede sobrepasar los 4";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El correo no puede sobrepasar los 40 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=8192004;
 //BA.debugLineNum = 8192004;BA.debugLine="End Sub";
return "";
}
}
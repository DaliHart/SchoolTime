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

public class registroacudiente extends Activity implements B4AActivity{
	public static registroacudiente mostCurrent;
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

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        mostCurrent = this;
		if (processBA == null) {
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.registroacudiente");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registroacudiente).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.registroacudiente");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.registroacudiente", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registroacudiente) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registroacudiente) Resume **");
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
		return registroacudiente.class;
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
        BA.LogInfo("** Activity (registroacudiente) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        if (mostCurrent != null)
            processBA.raiseEvent2(_activity, true, "activity_pause", false, activityBA.activity.isFinishing());		
        processBA.setActivityPaused(true);
        mostCurrent = null;
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
            registroacudiente mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registroacudiente) Resume **");
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
public static int _doc = 0;
public static anywheresoftware.b4a.objects.Timer _hecho = null;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _retroceder = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnregistroacudiente = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtnombreacudiente = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcedulaacudiente = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcorreoacudiente = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcodigoacuente = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcontrasenaacudiente = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconfirmaacudiente = null;
public anywheresoftware.b4a.objects.LabelWrapper _opcioncodigo = null;
public anywheresoftware.b4a.objects.LabelWrapper _cerrarcodigo = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtapellidoacudiente = null;
public anywheresoftware.b4a.objects.PanelWrapper _fondo = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.perfiles _perfiles = null;
public b4a.example.iniciodocente _iniciodocente = null;
public b4a.example.registrodocente _registrodocente = null;
public b4a.example.ingresodocente _ingresodocente = null;
public b4a.example.ingreso _ingreso = null;
public b4a.example.ingresoestudiante _ingresoestudiante = null;
public b4a.example.inicioacudiente _inicioacudiente = null;
public b4a.example.inicioestudiante _inicioestudiante = null;
public b4a.example.registroestudiante _registroestudiante = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=8323072;
 //BA.debugLineNum = 8323072;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=8323074;
 //BA.debugLineNum = 8323074;BA.debugLine="Activity.LoadLayout(\"registroAcudiente\")";
mostCurrent._activity.LoadLayout("registroAcudiente",mostCurrent.activityBA);
RDebugUtils.currentLine=8323075;
 //BA.debugLineNum = 8323075;BA.debugLine="ScrollView1.Panel.LoadLayout(\"contenidoacudiente\"";
mostCurrent._scrollview1.getPanel().LoadLayout("contenidoacudiente",mostCurrent.activityBA);
RDebugUtils.currentLine=8323076;
 //BA.debugLineNum = 8323076;BA.debugLine="ScrollView1.Panel.Height = 80%y";
mostCurrent._scrollview1.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
RDebugUtils.currentLine=8323077;
 //BA.debugLineNum = 8323077;BA.debugLine="Panel2.Visible = False";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8323078;
 //BA.debugLineNum = 8323078;BA.debugLine="fondo.Visible= False";
mostCurrent._fondo.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=8323079;
 //BA.debugLineNum = 8323079;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registroacudiente";
RDebugUtils.currentLine=8454144;
 //BA.debugLineNum = 8454144;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=8454146;
 //BA.debugLineNum = 8454146;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=8388608;
 //BA.debugLineNum = 8388608;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=8388610;
 //BA.debugLineNum = 8388610;BA.debugLine="End Sub";
return "";
}
public static String  _btnregistroacudiente_click() throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnregistroacudiente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnregistroacudiente_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=9109504;
 //BA.debugLineNum = 9109504;BA.debugLine="Sub btnregistroAcudiente_Click";
RDebugUtils.currentLine=9109505;
 //BA.debugLineNum = 9109505;BA.debugLine="If txtnombreAcudiente.Text<>\"\" And txtcedulaAcudi";
if ((mostCurrent._txtnombreacudiente.getText()).equals("") == false && (mostCurrent._txtcedulaacudiente.getText()).equals("") == false && (mostCurrent._txtcodigoacuente.getText()).equals("") == false && (mostCurrent._txtcorreoacudiente.getText()).equals("") == false && (mostCurrent._txtcontrasenaacudiente.getText()).equals("") == false && (mostCurrent._txtconfirmaacudiente.getText()).equals("") == false) { 
RDebugUtils.currentLine=9109506;
 //BA.debugLineNum = 9109506;BA.debugLine="If txtcontrasenaAcudiente.Text = txtconfirmaAcud";
if ((mostCurrent._txtcontrasenaacudiente.getText()).equals(mostCurrent._txtconfirmaacudiente.getText())) { 
RDebugUtils.currentLine=9109507;
 //BA.debugLineNum = 9109507;BA.debugLine="If txtcorreoAcudiente.Text.Contains(\"@\") Then";
if (mostCurrent._txtcorreoacudiente.getText().contains("@")) { 
RDebugUtils.currentLine=9109508;
 //BA.debugLineNum = 9109508;BA.debugLine="If txtcorreoAcudiente.Text.Contains(\".\") Then";
if (mostCurrent._txtcorreoacudiente.getText().contains(".")) { 
RDebugUtils.currentLine=9109509;
 //BA.debugLineNum = 9109509;BA.debugLine="If txtcorreoAcudiente.Text.Contains(\" \") Then";
if (mostCurrent._txtcorreoacudiente.getText().contains(" ")) { 
RDebugUtils.currentLine=9109510;
 //BA.debugLineNum = 9109510;BA.debugLine="ToastMessageShow(\"El correo no debe contener";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("El correo no debe contener espacios"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9109511;
 //BA.debugLineNum = 9109511;BA.debugLine="txtcorreoAcudiente.Text=\"\"";
mostCurrent._txtcorreoacudiente.setText(BA.ObjectToCharSequence(""));
 }else {
RDebugUtils.currentLine=9109513;
 //BA.debugLineNum = 9109513;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1";
_apiaddress = "http://192.168.1.3/schooltime1.php";
RDebugUtils.currentLine=9109514;
 //BA.debugLineNum = 9109514;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=9109515;
 //BA.debugLineNum = 9109515;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",registroacudiente.getObject());
RDebugUtils.currentLine=9109516;
 //BA.debugLineNum = 9109516;BA.debugLine="job.PostString(ApiAddress,\"INSERT INTO tblre";
_job._poststring /*String*/ (null,_apiaddress,"INSERT INTO tblregistroacudiente(nombreAcudiente, apellidoAcudiente, cedulaAcudiente, codigoAcudiente, correoAcudiente, contrasenaAcudiente) VALUES ('"+mostCurrent._txtnombreacudiente.getText()+"','"+mostCurrent._txtapellidoacudiente.getText()+"','"+mostCurrent._txtcedulaacudiente.getText()+"','"+mostCurrent._txtcodigoacuente.getText()+"','"+mostCurrent._txtcorreoacudiente.getText()+"','"+mostCurrent._txtcontrasenaacudiente.getText()+"')");
 };
 }else {
RDebugUtils.currentLine=9109519;
 //BA.debugLineNum = 9109519;BA.debugLine="ToastMessageShow(\"Correo inválido: .\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Correo inválido: ."),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9109520;
 //BA.debugLineNum = 9109520;BA.debugLine="txtcorreoAcudiente.Text=\"\"";
mostCurrent._txtcorreoacudiente.setText(BA.ObjectToCharSequence(""));
 };
 }else {
RDebugUtils.currentLine=9109523;
 //BA.debugLineNum = 9109523;BA.debugLine="ToastMessageShow(\"Correo inválido: @\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Correo inválido: @"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9109524;
 //BA.debugLineNum = 9109524;BA.debugLine="txtcorreoAcudiente.Text=\"\"";
mostCurrent._txtcorreoacudiente.setText(BA.ObjectToCharSequence(""));
 };
 }else {
RDebugUtils.currentLine=9109527;
 //BA.debugLineNum = 9109527;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Las contraseñas deben coincidir"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
 }else {
RDebugUtils.currentLine=9109530;
 //BA.debugLineNum = 9109530;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son requeridos para el registro"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=9109532;
 //BA.debugLineNum = 9109532;BA.debugLine="End Sub";
return "";
}
public static String  _cerrarcodigo_click() throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cerrarcodigo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cerrarcodigo_click", null));}
RDebugUtils.currentLine=9371648;
 //BA.debugLineNum = 9371648;BA.debugLine="Sub cerrarCodigo_Click";
RDebugUtils.currentLine=9371649;
 //BA.debugLineNum = 9371649;BA.debugLine="If doc = 1 Then";
if (_doc==1) { 
RDebugUtils.currentLine=9371650;
 //BA.debugLineNum = 9371650;BA.debugLine="Panel2.Visible= False";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9371651;
 //BA.debugLineNum = 9371651;BA.debugLine="fondo.Visible=False";
mostCurrent._fondo.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9371652;
 //BA.debugLineNum = 9371652;BA.debugLine="btnregistroAcudiente.Visible= True";
mostCurrent._btnregistroacudiente.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=9371653;
 //BA.debugLineNum = 9371653;BA.debugLine="doc = 0";
_doc = (int) (0);
 };
RDebugUtils.currentLine=9371655;
 //BA.debugLineNum = 9371655;BA.debugLine="End Sub";
return "";
}
public static String  _hecho_tick() throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "hecho_tick", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "hecho_tick", null));}
RDebugUtils.currentLine=9240576;
 //BA.debugLineNum = 9240576;BA.debugLine="Sub hecho_Tick";
RDebugUtils.currentLine=9240577;
 //BA.debugLineNum = 9240577;BA.debugLine="StartActivity(ingreso)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ingreso.getObject()));
RDebugUtils.currentLine=9240578;
 //BA.debugLineNum = 9240578;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=9240579;
 //BA.debugLineNum = 9240579;BA.debugLine="hecho.Enabled= False";
_hecho.setEnabled(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9240580;
 //BA.debugLineNum = 9240580;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=9175040;
 //BA.debugLineNum = 9175040;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=9175041;
 //BA.debugLineNum = 9175041;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=9175042;
 //BA.debugLineNum = 9175042;BA.debugLine="Log(\"OK, operacion con éxito\")";
anywheresoftware.b4a.keywords.Common.LogImpl("59175042","OK, operacion con éxito",0);
RDebugUtils.currentLine=9175043;
 //BA.debugLineNum = 9175043;BA.debugLine="MsgboxAsync(\"Su registro ha sido exitoso\",\"AVISO";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su registro ha sido exitoso"),BA.ObjectToCharSequence("AVISO"),processBA);
RDebugUtils.currentLine=9175044;
 //BA.debugLineNum = 9175044;BA.debugLine="hecho.Initialize(\"hecho\", 2000)";
_hecho.Initialize(processBA,"hecho",(long) (2000));
RDebugUtils.currentLine=9175045;
 //BA.debugLineNum = 9175045;BA.debugLine="hecho.Enabled= True";
_hecho.setEnabled(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=9175047;
 //BA.debugLineNum = 9175047;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("59175047",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=9175048;
 //BA.debugLineNum = 9175048;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=9175050;
 //BA.debugLineNum = 9175050;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=9175051;
 //BA.debugLineNum = 9175051;BA.debugLine="End Sub";
return "";
}
public static String  _opcioncodigo_click() throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "opcioncodigo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "opcioncodigo_click", null));}
RDebugUtils.currentLine=9306112;
 //BA.debugLineNum = 9306112;BA.debugLine="Sub opcioncodigo_Click";
RDebugUtils.currentLine=9306113;
 //BA.debugLineNum = 9306113;BA.debugLine="If doc = 0 Then";
if (_doc==0) { 
RDebugUtils.currentLine=9306114;
 //BA.debugLineNum = 9306114;BA.debugLine="Panel2.Visible= True";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=9306115;
 //BA.debugLineNum = 9306115;BA.debugLine="fondo.Visible=True";
mostCurrent._fondo.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=9306116;
 //BA.debugLineNum = 9306116;BA.debugLine="btnregistroAcudiente.Visible= False";
mostCurrent._btnregistroacudiente.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9306117;
 //BA.debugLineNum = 9306117;BA.debugLine="doc = 1";
_doc = (int) (1);
 };
RDebugUtils.currentLine=9306119;
 //BA.debugLineNum = 9306119;BA.debugLine="End Sub";
return "";
}
public static String  _opcioninicioacudiente_click() throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "opcioninicioacudiente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "opcioninicioacudiente_click", null));}
RDebugUtils.currentLine=8519680;
 //BA.debugLineNum = 8519680;BA.debugLine="Sub opcioninicioAcudiente_Click";
RDebugUtils.currentLine=8519681;
 //BA.debugLineNum = 8519681;BA.debugLine="StartActivity(inicioAcudiente)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._inicioacudiente.getObject()));
RDebugUtils.currentLine=8519682;
 //BA.debugLineNum = 8519682;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=8519683;
 //BA.debugLineNum = 8519683;BA.debugLine="End Sub";
return "";
}
public static String  _retroceder_click() throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "retroceder_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "retroceder_click", null));}
RDebugUtils.currentLine=8585216;
 //BA.debugLineNum = 8585216;BA.debugLine="Sub retroceder_Click";
RDebugUtils.currentLine=8585217;
 //BA.debugLineNum = 8585217;BA.debugLine="StartActivity(inicioAcudiente)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._inicioacudiente.getObject()));
RDebugUtils.currentLine=8585218;
 //BA.debugLineNum = 8585218;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=8585219;
 //BA.debugLineNum = 8585219;BA.debugLine="End Sub";
return "";
}
public static String  _txtapellidoacudiente_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtapellidoacudiente_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtapellidoacudiente_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=9043968;
 //BA.debugLineNum = 9043968;BA.debugLine="Sub txtapellidoAcudiente_TextChanged (Old As Strin";
RDebugUtils.currentLine=9043969;
 //BA.debugLineNum = 9043969;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=9043970;
 //BA.debugLineNum = 9043970;BA.debugLine="MsgboxAsync(\"El apellido no puede sobrepasar los";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El apellido no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=9043972;
 //BA.debugLineNum = 9043972;BA.debugLine="End Sub";
return "";
}
public static String  _txtcedulaacudiente_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcedulaacudiente_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtcedulaacudiente_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8716288;
 //BA.debugLineNum = 8716288;BA.debugLine="Sub txtcedulaAcudiente_TextChanged (Old As String,";
RDebugUtils.currentLine=8716289;
 //BA.debugLineNum = 8716289;BA.debugLine="If New.Length >= 10 Then";
if (_new.length()>=10) { 
RDebugUtils.currentLine=8716290;
 //BA.debugLineNum = 8716290;BA.debugLine="MsgboxAsync(\"La cédula no puede sobrepasar los 1";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La cédula no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=8716292;
 //BA.debugLineNum = 8716292;BA.debugLine="End Sub";
return "";
}
public static String  _txtcodigoacuente_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcodigoacuente_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtcodigoacuente_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8847360;
 //BA.debugLineNum = 8847360;BA.debugLine="Sub txtcodigoAcuente_TextChanged (Old As String, N";
RDebugUtils.currentLine=8847361;
 //BA.debugLineNum = 8847361;BA.debugLine="If New.Length >= 10 Then";
if (_new.length()>=10) { 
RDebugUtils.currentLine=8847362;
 //BA.debugLineNum = 8847362;BA.debugLine="MsgboxAsync(\"El código de grupo no puede sobrepa";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El código de grupo no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=8847364;
 //BA.debugLineNum = 8847364;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfirmaacudiente_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfirmaacudiente_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfirmaacudiente_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8978432;
 //BA.debugLineNum = 8978432;BA.debugLine="Sub txtconfirmaAcudiente_TextChanged (Old As Strin";
RDebugUtils.currentLine=8978433;
 //BA.debugLineNum = 8978433;BA.debugLine="If New.Length >= 10 Then";
if (_new.length()>=10) { 
RDebugUtils.currentLine=8978434;
 //BA.debugLineNum = 8978434;BA.debugLine="MsgboxAsync(\"La confirmación de la contraseña no";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La confirmación de la contraseña no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=8978436;
 //BA.debugLineNum = 8978436;BA.debugLine="End Sub";
return "";
}
public static String  _txtcontrasenaacudiente_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcontrasenaacudiente_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtcontrasenaacudiente_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8912896;
 //BA.debugLineNum = 8912896;BA.debugLine="Sub txtcontrasenaAcudiente_TextChanged (Old As Str";
RDebugUtils.currentLine=8912897;
 //BA.debugLineNum = 8912897;BA.debugLine="If New.Length >= 10 Then";
if (_new.length()>=10) { 
RDebugUtils.currentLine=8912898;
 //BA.debugLineNum = 8912898;BA.debugLine="MsgboxAsync(\"La contraseña no puede sobrepasar l";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La contraseña no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=8912900;
 //BA.debugLineNum = 8912900;BA.debugLine="End Sub";
return "";
}
public static String  _txtcorreoacudiente_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcorreoacudiente_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtcorreoacudiente_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8781824;
 //BA.debugLineNum = 8781824;BA.debugLine="Sub txtcorreoAcudiente_TextChanged (Old As String,";
RDebugUtils.currentLine=8781825;
 //BA.debugLineNum = 8781825;BA.debugLine="If New.Length >= 50 Then";
if (_new.length()>=50) { 
RDebugUtils.currentLine=8781826;
 //BA.debugLineNum = 8781826;BA.debugLine="MsgboxAsync(\"El correo no puede sobrepasar los 5";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El correo no puede sobrepasar los 50 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=8781828;
 //BA.debugLineNum = 8781828;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombreacudiente_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroacudiente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombreacudiente_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombreacudiente_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=8650752;
 //BA.debugLineNum = 8650752;BA.debugLine="Sub txtnombreAcudiente_TextChanged (Old As String,";
RDebugUtils.currentLine=8650753;
 //BA.debugLineNum = 8650753;BA.debugLine="If New.Length >= 40 Then";
if (_new.length()>=40) { 
RDebugUtils.currentLine=8650754;
 //BA.debugLineNum = 8650754;BA.debugLine="MsgboxAsync(\"El nombre no puede sobrepasar los 4";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El nombre no puede sobrepasar los 40 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=8650756;
 //BA.debugLineNum = 8650756;BA.debugLine="End Sub";
return "";
}
}
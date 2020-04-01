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

public class registroestudiante extends Activity implements B4AActivity{
	public static registroestudiante mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.registroestudiante");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (registroestudiante).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.registroestudiante");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.registroestudiante", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (registroestudiante) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (registroestudiante) Resume **");
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
		return registroestudiante.class;
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
        BA.LogInfo("** Activity (registroestudiante) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            registroestudiante mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (registroestudiante) Resume **");
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
public static int _est = 0;
public anywheresoftware.b4a.objects.ScrollViewWrapper _scrollview1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _retroceder = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtnombreestudiante = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtidentificacion = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtmatricula = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcodigogrupo = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcontrasenaestudiante = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconfirmaestudiante = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btnregistroestudiante = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel2 = null;
public anywheresoftware.b4a.objects.PanelWrapper _fondo = null;
public anywheresoftware.b4a.objects.LabelWrapper _cerrarcodigo = null;
public anywheresoftware.b4a.objects.LabelWrapper _opcioncodigo = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtapellidoestudiante = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtcorreoestudiante = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.perfiles _perfiles = null;
public b4a.example.ingresodocente _ingresodocente = null;
public b4a.example.ingreso _ingreso = null;
public b4a.example.ingresoestudiante _ingresoestudiante = null;
public b4a.example.inicioacudiente _inicioacudiente = null;
public b4a.example.iniciodocente _iniciodocente = null;
public b4a.example.inicioestudiante _inicioestudiante = null;
public b4a.example.registroacudiente _registroacudiente = null;
public b4a.example.registrodocente _registrodocente = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=9895936;
 //BA.debugLineNum = 9895936;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=9895938;
 //BA.debugLineNum = 9895938;BA.debugLine="Activity.LoadLayout(\"registroEstudiante\")";
mostCurrent._activity.LoadLayout("registroEstudiante",mostCurrent.activityBA);
RDebugUtils.currentLine=9895939;
 //BA.debugLineNum = 9895939;BA.debugLine="ScrollView1.Panel.LoadLayout(\"contenidoEstudiante";
mostCurrent._scrollview1.getPanel().LoadLayout("contenidoEstudiante",mostCurrent.activityBA);
RDebugUtils.currentLine=9895940;
 //BA.debugLineNum = 9895940;BA.debugLine="ScrollView1.Panel.Height = 80%y";
mostCurrent._scrollview1.getPanel().setHeight(anywheresoftware.b4a.keywords.Common.PerYToCurrent((float) (80),mostCurrent.activityBA));
RDebugUtils.currentLine=9895941;
 //BA.debugLineNum = 9895941;BA.debugLine="Panel2.Visible = False";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9895942;
 //BA.debugLineNum = 9895942;BA.debugLine="fondo.Visible= False";
mostCurrent._fondo.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=9895943;
 //BA.debugLineNum = 9895943;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="registroestudiante";
RDebugUtils.currentLine=10027008;
 //BA.debugLineNum = 10027008;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=10027010;
 //BA.debugLineNum = 10027010;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=9961472;
 //BA.debugLineNum = 9961472;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=9961474;
 //BA.debugLineNum = 9961474;BA.debugLine="End Sub";
return "";
}
public static String  _btnregistroestudiante_click() throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btnregistroestudiante_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btnregistroestudiante_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=10747904;
 //BA.debugLineNum = 10747904;BA.debugLine="Sub btnregistroEstudiante_Click";
RDebugUtils.currentLine=10747905;
 //BA.debugLineNum = 10747905;BA.debugLine="If txtnombreEstudiante.Text<>\"\" And txtidentifica";
if ((mostCurrent._txtnombreestudiante.getText()).equals("") == false && (mostCurrent._txtidentificacion.getText()).equals("") == false && (mostCurrent._txtmatricula.getText()).equals("") == false && (mostCurrent._txtcodigogrupo.getText()).equals("") == false && (mostCurrent._txtcontrasenaestudiante.getText()).equals("") == false && (mostCurrent._txtconfirmaestudiante.getText()).equals("") == false && (mostCurrent._txtcorreoestudiante.getText()).equals("") == false && (mostCurrent._txtapellidoestudiante.getText()).equals("") == false) { 
RDebugUtils.currentLine=10747906;
 //BA.debugLineNum = 10747906;BA.debugLine="If txtcontrasenaEstudiante.Text = txtconfirmaEst";
if ((mostCurrent._txtcontrasenaestudiante.getText()).equals(mostCurrent._txtconfirmaestudiante.getText())) { 
RDebugUtils.currentLine=10747907;
 //BA.debugLineNum = 10747907;BA.debugLine="If txtcorreoEstudiante.Text.Contains(\"@\") Then";
if (mostCurrent._txtcorreoestudiante.getText().contains("@")) { 
RDebugUtils.currentLine=10747908;
 //BA.debugLineNum = 10747908;BA.debugLine="If txtcorreoEstudiante.Text.Contains(\".\") Then";
if (mostCurrent._txtcorreoestudiante.getText().contains(".")) { 
RDebugUtils.currentLine=10747909;
 //BA.debugLineNum = 10747909;BA.debugLine="If txtcorreoEstudiante.Text.Contains(\" \")Then";
if (mostCurrent._txtcorreoestudiante.getText().contains(" ")) { 
RDebugUtils.currentLine=10747910;
 //BA.debugLineNum = 10747910;BA.debugLine="ToastMessageShow(\"El correo no debe contener";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("El correo no debe contener espacios"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10747911;
 //BA.debugLineNum = 10747911;BA.debugLine="txtcorreoEstudiante.Text=\"\"";
mostCurrent._txtcorreoestudiante.setText(BA.ObjectToCharSequence(""));
 }else {
RDebugUtils.currentLine=10747913;
 //BA.debugLineNum = 10747913;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1";
_apiaddress = "http://192.168.1.5/schooltime1.php";
RDebugUtils.currentLine=10747914;
 //BA.debugLineNum = 10747914;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=10747915;
 //BA.debugLineNum = 10747915;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",registroestudiante.getObject());
RDebugUtils.currentLine=10747916;
 //BA.debugLineNum = 10747916;BA.debugLine="job.PostString(ApiAddress,\"INSERT INTO tbl_e";
_job._poststring /*String*/ (null,_apiaddress,"INSERT INTO tbl_estudiante(id_estudiante,nombre_e,apellido_e,matricula_e,correo_e, contrasena_e,codigo_g) VALUES ('"+mostCurrent._txtidentificacion.getText()+"','"+mostCurrent._txtnombreestudiante.getText()+"','"+mostCurrent._txtapellidoestudiante.getText()+"','"+mostCurrent._txtmatricula.getText()+"','"+mostCurrent._txtcorreoestudiante.getText()+"','"+mostCurrent._txtcontrasenaestudiante.getText()+"','"+mostCurrent._txtcodigogrupo.getText()+"')");
 };
 }else {
RDebugUtils.currentLine=10747919;
 //BA.debugLineNum = 10747919;BA.debugLine="ToastMessageShow(\"Correo inválido: @\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Correo inválido: @"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10747920;
 //BA.debugLineNum = 10747920;BA.debugLine="txtcorreoEstudiante.Text=\"\"";
mostCurrent._txtcorreoestudiante.setText(BA.ObjectToCharSequence(""));
 };
 }else {
RDebugUtils.currentLine=10747923;
 //BA.debugLineNum = 10747923;BA.debugLine="ToastMessageShow(\"Correo inválido: @\", False)";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Correo inválido: @"),anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10747924;
 //BA.debugLineNum = 10747924;BA.debugLine="txtcorreoEstudiante.Text=\"\"";
mostCurrent._txtcorreoestudiante.setText(BA.ObjectToCharSequence(""));
 };
 }else {
RDebugUtils.currentLine=10747927;
 //BA.debugLineNum = 10747927;BA.debugLine="MsgboxAsync(\"Las contraseñas no coinciden\",\"ERR";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Las contraseñas no coinciden"),BA.ObjectToCharSequence("ERROR DE CONFIRMACIÓN"),processBA);
 };
 }else {
RDebugUtils.currentLine=10747930;
 //BA.debugLineNum = 10747930;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son requeridos para el registro"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=10747932;
 //BA.debugLineNum = 10747932;BA.debugLine="End Sub";
return "";
}
public static String  _cerrarcodigo_click() throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cerrarcodigo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cerrarcodigo_click", null));}
RDebugUtils.currentLine=10944512;
 //BA.debugLineNum = 10944512;BA.debugLine="Sub cerrarCodigo_Click";
RDebugUtils.currentLine=10944513;
 //BA.debugLineNum = 10944513;BA.debugLine="If est = 1 Then";
if (_est==1) { 
RDebugUtils.currentLine=10944514;
 //BA.debugLineNum = 10944514;BA.debugLine="Panel2.Visible= False";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10944515;
 //BA.debugLineNum = 10944515;BA.debugLine="fondo.Visible= False";
mostCurrent._fondo.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10944516;
 //BA.debugLineNum = 10944516;BA.debugLine="btnregistroEstudiante.Visible= True";
mostCurrent._btnregistroestudiante.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=10944517;
 //BA.debugLineNum = 10944517;BA.debugLine="est = 0";
_est = (int) (0);
 };
RDebugUtils.currentLine=10944519;
 //BA.debugLineNum = 10944519;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=10813440;
 //BA.debugLineNum = 10813440;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=10813441;
 //BA.debugLineNum = 10813441;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=10813442;
 //BA.debugLineNum = 10813442;BA.debugLine="Log(\"OK, operacion con éxito\")";
anywheresoftware.b4a.keywords.Common.LogImpl("210813442","OK, operacion con éxito",0);
RDebugUtils.currentLine=10813443;
 //BA.debugLineNum = 10813443;BA.debugLine="MsgboxAsync(\"Su registro ha sido exitoso\",\"AVISO";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su registro ha sido exitoso"),BA.ObjectToCharSequence("AVISO"),processBA);
RDebugUtils.currentLine=10813444;
 //BA.debugLineNum = 10813444;BA.debugLine="StartActivity(ingresoEstudiante)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._ingresoestudiante.getObject()));
RDebugUtils.currentLine=10813445;
 //BA.debugLineNum = 10813445;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
 }else {
RDebugUtils.currentLine=10813447;
 //BA.debugLineNum = 10813447;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("210813447",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=10813448;
 //BA.debugLineNum = 10813448;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=10813450;
 //BA.debugLineNum = 10813450;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=10813451;
 //BA.debugLineNum = 10813451;BA.debugLine="End Sub";
return "";
}
public static String  _opcioncodigo_click() throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "opcioncodigo_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "opcioncodigo_click", null));}
RDebugUtils.currentLine=10878976;
 //BA.debugLineNum = 10878976;BA.debugLine="Sub opcioncodigo_Click";
RDebugUtils.currentLine=10878977;
 //BA.debugLineNum = 10878977;BA.debugLine="If est = 0 Then";
if (_est==0) { 
RDebugUtils.currentLine=10878978;
 //BA.debugLineNum = 10878978;BA.debugLine="Panel2.Visible= True";
mostCurrent._panel2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=10878979;
 //BA.debugLineNum = 10878979;BA.debugLine="fondo.Visible=True";
mostCurrent._fondo.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=10878980;
 //BA.debugLineNum = 10878980;BA.debugLine="btnregistroEstudiante.Visible= False";
mostCurrent._btnregistroestudiante.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=10878981;
 //BA.debugLineNum = 10878981;BA.debugLine="est = 1";
_est = (int) (1);
 };
RDebugUtils.currentLine=10878983;
 //BA.debugLineNum = 10878983;BA.debugLine="End Sub";
return "";
}
public static String  _opcioninicioestudiante_click() throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "opcioninicioestudiante_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "opcioninicioestudiante_click", null));}
RDebugUtils.currentLine=10092544;
 //BA.debugLineNum = 10092544;BA.debugLine="Sub opcioninicioEstudiante_Click";
RDebugUtils.currentLine=10092545;
 //BA.debugLineNum = 10092545;BA.debugLine="StartActivity(inicioEstudiante)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._inicioestudiante.getObject()));
RDebugUtils.currentLine=10092546;
 //BA.debugLineNum = 10092546;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=10092547;
 //BA.debugLineNum = 10092547;BA.debugLine="End Sub";
return "";
}
public static String  _retroceder_click() throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "retroceder_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "retroceder_click", null));}
RDebugUtils.currentLine=10158080;
 //BA.debugLineNum = 10158080;BA.debugLine="Sub retroceder_Click";
RDebugUtils.currentLine=10158081;
 //BA.debugLineNum = 10158081;BA.debugLine="StartActivity(inicioEstudiante)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._inicioestudiante.getObject()));
RDebugUtils.currentLine=10158082;
 //BA.debugLineNum = 10158082;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=10158083;
 //BA.debugLineNum = 10158083;BA.debugLine="End Sub";
return "";
}
public static String  _txtapellidoestudiante_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtapellidoestudiante_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtapellidoestudiante_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=10616832;
 //BA.debugLineNum = 10616832;BA.debugLine="Sub txtapellidoEstudiante_TextChanged (Old As Stri";
RDebugUtils.currentLine=10616833;
 //BA.debugLineNum = 10616833;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=10616834;
 //BA.debugLineNum = 10616834;BA.debugLine="MsgboxAsync(\"El apellido no puede sobrepasar los";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El apellido no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=10616836;
 //BA.debugLineNum = 10616836;BA.debugLine="End Sub";
return "";
}
public static String  _txtcodigogrupo_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcodigogrupo_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtcodigogrupo_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=10420224;
 //BA.debugLineNum = 10420224;BA.debugLine="Sub txtcodigogrupo_TextChanged (Old As String, New";
RDebugUtils.currentLine=10420225;
 //BA.debugLineNum = 10420225;BA.debugLine="If New.Length >= 10 Then";
if (_new.length()>=10) { 
RDebugUtils.currentLine=10420226;
 //BA.debugLineNum = 10420226;BA.debugLine="MsgboxAsync(\"El código del grupo no puede sobrep";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El código del grupo no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=10420228;
 //BA.debugLineNum = 10420228;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfirmaestudiante_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfirmaestudiante_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfirmaestudiante_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=10551296;
 //BA.debugLineNum = 10551296;BA.debugLine="Sub txtconfirmaEstudiante_TextChanged (Old As Stri";
RDebugUtils.currentLine=10551297;
 //BA.debugLineNum = 10551297;BA.debugLine="If New.Length >= 10 Then";
if (_new.length()>=10) { 
RDebugUtils.currentLine=10551298;
 //BA.debugLineNum = 10551298;BA.debugLine="MsgboxAsync(\"La confirmación de la contraseña no";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La confirmación de la contraseña no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=10551300;
 //BA.debugLineNum = 10551300;BA.debugLine="End Sub";
return "";
}
public static String  _txtcontrasenaestudiante_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcontrasenaestudiante_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtcontrasenaestudiante_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=10485760;
 //BA.debugLineNum = 10485760;BA.debugLine="Sub txtcontrasenaEstudiante_TextChanged (Old As St";
RDebugUtils.currentLine=10485761;
 //BA.debugLineNum = 10485761;BA.debugLine="If New.Length >= 10 Then";
if (_new.length()>=10) { 
RDebugUtils.currentLine=10485762;
 //BA.debugLineNum = 10485762;BA.debugLine="MsgboxAsync(\"La contraseña no puede sobrepasar l";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La contraseña no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=10485764;
 //BA.debugLineNum = 10485764;BA.debugLine="End Sub";
return "";
}
public static String  _txtcorreoestudiante_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtcorreoestudiante_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtcorreoestudiante_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=10682368;
 //BA.debugLineNum = 10682368;BA.debugLine="Sub txtcorreoEstudiante_TextChanged (Old As String";
RDebugUtils.currentLine=10682369;
 //BA.debugLineNum = 10682369;BA.debugLine="If New.Length >= 50 Then";
if (_new.length()>=50) { 
RDebugUtils.currentLine=10682370;
 //BA.debugLineNum = 10682370;BA.debugLine="MsgboxAsync(\"El correo no puede sobrepasar los 5";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El correo no puede sobrepasar los 50 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=10682372;
 //BA.debugLineNum = 10682372;BA.debugLine="End Sub";
return "";
}
public static String  _txtidentificacion_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtidentificacion_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtidentificacion_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=10289152;
 //BA.debugLineNum = 10289152;BA.debugLine="Sub txtidentificacion_TextChanged (Old As String,";
RDebugUtils.currentLine=10289153;
 //BA.debugLineNum = 10289153;BA.debugLine="If New.Length >= 10 Then";
if (_new.length()>=10) { 
RDebugUtils.currentLine=10289154;
 //BA.debugLineNum = 10289154;BA.debugLine="MsgboxAsync(\"La identificación no puede sobrepas";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La identificación no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=10289156;
 //BA.debugLineNum = 10289156;BA.debugLine="End Sub";
return "";
}
public static String  _txtmatricula_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtmatricula_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtmatricula_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=10354688;
 //BA.debugLineNum = 10354688;BA.debugLine="Sub txtmatricula_TextChanged (Old As String, New A";
RDebugUtils.currentLine=10354689;
 //BA.debugLineNum = 10354689;BA.debugLine="If New.Length >= 10 Then";
if (_new.length()>=10) { 
RDebugUtils.currentLine=10354690;
 //BA.debugLineNum = 10354690;BA.debugLine="MsgboxAsync(\"La matrícula no puede sobrepasar lo";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La matrícula no puede sobrepasar los 10 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=10354692;
 //BA.debugLineNum = 10354692;BA.debugLine="End Sub";
return "";
}
public static String  _txtnombreestudiante_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="registroestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtnombreestudiante_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtnombreestudiante_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=10223616;
 //BA.debugLineNum = 10223616;BA.debugLine="Sub txtnombreEstudiante_TextChanged (Old As String";
RDebugUtils.currentLine=10223617;
 //BA.debugLineNum = 10223617;BA.debugLine="If New.Length >= 40 Then";
if (_new.length()>=40) { 
RDebugUtils.currentLine=10223618;
 //BA.debugLineNum = 10223618;BA.debugLine="MsgboxAsync(\"El nombre no puede sobrepasar los 4";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("El nombre no puede sobrepasar los 40 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=10223620;
 //BA.debugLineNum = 10223620;BA.debugLine="End Sub";
return "";
}
}
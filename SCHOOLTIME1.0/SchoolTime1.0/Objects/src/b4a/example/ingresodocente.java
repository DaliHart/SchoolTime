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

public class ingresodocente extends Activity implements B4AActivity{
	public static ingresodocente mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.ingresodocente");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (ingresodocente).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.ingresodocente");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.ingresodocente", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (ingresodocente) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (ingresodocente) Resume **");
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
		return ingresodocente.class;
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
        BA.LogInfo("** Activity (ingresodocente) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            ingresodocente mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (ingresodocente) Resume **");
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
public static int _event = 0;
public static String _tit = "";
public static String _fec = "";
public static String _tip = "";
public static String _hor = "";
public static String _des = "";
public static String _desc11 = "";
public static String _desc2 = "";
public static String _codigo = "";
public static String _tipo2 = "";
public static int _eventos = 0;
public anywheresoftware.b4a.objects.TabHostWrapper _tabhost1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncambiardocente = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncerrardocente = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public static int _estado = 0;
public anywheresoftware.b4a.objects.PanelWrapper _inicio = null;
public anywheresoftware.b4a.objects.LabelWrapper _retroceder = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconnuv = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncambio = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconact = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconfcon = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion = null;
public static String _tipo = "";
public anywheresoftware.b4a.objects.LabelWrapper _hora = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _icono1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _desc1 = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora1 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _icono1r = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _icono1c = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento11 = null;
public anywheresoftware.b4a.objects.LabelWrapper _anuncio = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha2 = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora2 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio22 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion22 = null;
public anywheresoftware.b4a.objects.LabelWrapper _descripcion22 = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento22 = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha22 = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora22 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion22 = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo22 = null;
public anywheresoftware.b4a.objects.PanelWrapper _datos = null;
public anywheresoftware.b4a.objects.EditTextWrapper _contraseñad = null;
public anywheresoftware.b4a.objects.ButtonWrapper _enviar = null;
public anywheresoftware.b4a.objects.NotificationWrapper _notifica = null;
public static String _fechacomplet = "";
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.perfiles _perfiles = null;
public b4a.example.iniciodocente _iniciodocente = null;
public b4a.example.registrodocente _registrodocente = null;
public b4a.example.ingreso _ingreso = null;
public b4a.example.ingresoestudiante _ingresoestudiante = null;
public b4a.example.inicioacudiente _inicioacudiente = null;
public b4a.example.inicioestudiante _inicioestudiante = null;
public b4a.example.registroacudiente _registroacudiente = null;
public b4a.example.registroestudiante _registroestudiante = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Activity.LoadLayout(\"ingresoDocente\")";
mostCurrent._activity.LoadLayout("ingresoDocente",mostCurrent.activityBA);
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"eventoDocente\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"EVENTOS","eventoDocente");
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfilDocente\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"PERFIL","perfilDocente");
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="evento11.Visible = False";
mostCurrent._evento11.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="evento22.Visible= False";
mostCurrent._evento22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="evento2.Visible= False";
mostCurrent._evento2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473418;
 //BA.debugLineNum = 3473418;BA.debugLine="evento1.Visible=False";
mostCurrent._evento1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473419;
 //BA.debugLineNum = 3473419;BA.debugLine="Anuncio.Visible= True";
mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3473420;
 //BA.debugLineNum = 3473420;BA.debugLine="eventos = 0";
_eventos = (int) (0);
RDebugUtils.currentLine=3473421;
 //BA.debugLineNum = 3473421;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ingresodocente";
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="End Sub";
return "";
}
public static String  _btncambiardocente_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambiardocente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambiardocente_click", null));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub btncambiardocente_Click";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="If estado = 0 Then";
if (_estado==0) { 
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Panel1.Visible = True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="estado = 1";
_estado = (int) (1);
 };
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="End Sub";
return "";
}
public static String  _btncambio_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambio_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub btncambio_Click";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="If txtconact.Text<>\"\" And txtconnuv.Text<>\"\" And";
if ((mostCurrent._txtconact.getText()).equals("") == false && (mostCurrent._txtconnuv.getText()).equals("") == false && (mostCurrent._txtconfcon.getText()).equals("") == false) { 
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="If txtconnuv.Text = txtconfcon.Text Then";
if ((mostCurrent._txtconnuv.getText()).equals(mostCurrent._txtconfcon.getText())) { 
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
_apiaddress = "http://192.168.1.3/schooltime1.php";
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",ingresodocente.getObject());
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tblregistrodo";
_job._poststring /*String*/ (null,_apiaddress,"UPDATE tblregistrodocente SET contrasenaDocente='"+mostCurrent._txtconnuv.getText()+"' WHERE contrasenaDocente='"+mostCurrent._txtconact.getText()+"'");
 }else {
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Las contraseñas deben coincidir"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
 }else {
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=3997709;
 //BA.debugLineNum = 3997709;BA.debugLine="End Sub";
return "";
}
public static String  _btncerrardocente_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncerrardocente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncerrardocente_click", null));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub btncerrardocente_Click";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="StartActivity(perfiles)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._perfiles.getObject()));
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="End Sub";
return "";
}
public static String  _createnotificationchannel(int _importancelevel) throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createnotificationchannel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "createnotificationchannel", new Object[] {_importancelevel}));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _ctxt = null;
String _channelid = "";
anywheresoftware.b4j.object.JavaObject _channel = null;
anywheresoftware.b4j.object.JavaObject _manager = null;
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub CreateNotificationChannel(ImportanceLevel As I";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="If p.SdkVersion >= 26 Then";
if (_p.getSdkVersion()>=26) { 
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(processBA);
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="Dim channelId As String = \"channel_\"& Importance";
_channelid = "channel_"+BA.NumberToString(_importancelevel);
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="Dim channel As JavaObject";
_channel = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="channel.InitializeNewInstance(\"android.app.Notif";
_channel.InitializeNewInstance("android.app.NotificationChannel",new Object[]{(Object)(_channelid),(Object)(anywheresoftware.b4a.keywords.Common.Application.getLabelName()),(Object)(_importancelevel)});
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="channel.RunMethod(\"setShowBadge\",Array(False))";
_channel.RunMethod("setShowBadge",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.False)});
RDebugUtils.currentLine=4390922;
 //BA.debugLineNum = 4390922;BA.debugLine="Dim manager As JavaObject = ctxt.RunMethod(\"getS";
_manager = new anywheresoftware.b4j.object.JavaObject();
_manager.setObject((java.lang.Object)(_ctxt.RunMethod("getSystemService",new Object[]{(Object)("notification")})));
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="manager.RunMethod(\"createNotificationChannel\",Ar";
_manager.RunMethod("createNotificationChannel",new Object[]{(Object)(_channel.getObject())});
 };
RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="End Sub";
return "";
}
public static void  _enviar_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "enviar_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "enviar_click", null); return;}
ResumableSub_Enviar_Click rsub = new ResumableSub_Enviar_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_Enviar_Click extends BA.ResumableSub {
public ResumableSub_Enviar_Click(b4a.example.ingresodocente parent) {
this.parent = parent;
}
b4a.example.ingresodocente parent;
String _apiaddress = "";
b4a.example.httpjob _js = null;
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _tabla = null;
anywheresoftware.b4a.objects.collections.Map _fila = null;
int _i = 0;
int step19;
int limit19;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="ingresodocente";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="If contraseñaD.Text <> \"\" Then";
if (true) break;

case 1:
//if
this.state = 26;
if ((parent.mostCurrent._contraseñad.getText()).equals("") == false) { 
this.state = 3;
}else {
this.state = 25;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Try";
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
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
_apiaddress = "http://192.168.1.3/schooltime.php";
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingresodocente.getObject());
RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","cedula","pin",parent.mostCurrent._contraseñad.getText(),"tabla","tblregistrodocente","codigo","codigoDocente","cedula","cedulaDocente"});
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingresodocente", "enviar_click"), (Object)(_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="If js.Success Then";
if (true) break;

case 7:
//if
this.state = 20;
if (_js._success /*boolean*/ ) { 
this.state = 9;
}else {
this.state = 19;
}if (true) break;

case 9:
//C
this.state = 10;
RDebugUtils.currentLine=4325385;
 //BA.debugLineNum = 4325385;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=4325387;
 //BA.debugLineNum = 4325387;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=4325390;
 //BA.debugLineNum = 4325390;BA.debugLine="If (res.Length >0) Then";
if (true) break;

case 10:
//if
this.state = 17;
if ((_res.length()>0)) { 
this.state = 12;
}if (true) break;

case 12:
//C
this.state = 13;
RDebugUtils.currentLine=4325391;
 //BA.debugLineNum = 4325391;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4325392;
 //BA.debugLineNum = 4325392;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=4325393;
 //BA.debugLineNum = 4325393;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("74325393",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=4325394;
 //BA.debugLineNum = 4325394;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4325395;
 //BA.debugLineNum = 4325395;BA.debugLine="For i=0 To tabla.Size-1";
if (true) break;

case 13:
//for
this.state = 16;
step19 = 1;
limit19 = (int) (_tabla.getSize()-1);
_i = (int) (0) ;
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
if (true) break;

case 15:
//C
this.state = 29;
RDebugUtils.currentLine=4325396;
 //BA.debugLineNum = 4325396;BA.debugLine="fila= tabla.Get(i)";
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=4325397;
 //BA.debugLineNum = 4325397;BA.debugLine="codigo = fila.Get(\"codigoDocente\")";
parent._codigo = BA.ObjectToString(_fila.Get((Object)("codigoDocente")));
 if (true) break;
if (true) break;

case 16:
//C
this.state = 17;
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
RDebugUtils.currentLine=4325401;
 //BA.debugLineNum = 4325401;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("74325401",_js._errormessage /*String*/ ,0);
 if (true) break;

case 20:
//C
this.state = 23;
;
 if (true) break;

case 22:
//C
this.state = 23;
this.catchState = 0;
RDebugUtils.currentLine=4325404;
 //BA.debugLineNum = 4325404;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("74325404",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
RDebugUtils.currentLine=4325406;
 //BA.debugLineNum = 4325406;BA.debugLine="inicio.Visible =False";
parent.mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325407;
 //BA.debugLineNum = 4325407;BA.debugLine="Datos.Visible = False";
parent.mostCurrent._datos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 25:
//C
this.state = 26;
RDebugUtils.currentLine=4325409;
 //BA.debugLineNum = 4325409;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Necesitas este campo para el ingreso"),BA.ObjectToCharSequence("AVISO"),processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
RDebugUtils.currentLine=4325411;
 //BA.debugLineNum = 4325411;BA.debugLine="remore";
_remore();
RDebugUtils.currentLine=4325412;
 //BA.debugLineNum = 4325412;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static void  _remore() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "remore", false))
	 {Debug.delegate(mostCurrent.activityBA, "remore", null); return;}
ResumableSub_remore rsub = new ResumableSub_remore(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_remore extends BA.ResumableSub {
public ResumableSub_remore(b4a.example.ingresodocente parent) {
this.parent = parent;
}
b4a.example.ingresodocente parent;
String _apiaddress = "";
b4a.example.httpjob _js = null;
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _tabla = null;
anywheresoftware.b4a.objects.collections.Map _fila = null;
int _i = 0;
anywheresoftware.b4a.objects.NotificationWrapper _n = null;
anywheresoftware.b4a.objects.NotificationWrapper _n1 = null;
int step27;
int limit27;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="ingresodocente";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="If eventos = 0 Then";
if (true) break;

case 1:
//if
this.state = 6;
if (parent._eventos==0) { 
this.state = 3;
}else {
this.state = 5;
}if (true) break;

case 3:
//C
this.state = 6;
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="Anuncio.Visible = True";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
;
RDebugUtils.currentLine=4456454;
 //BA.debugLineNum = 4456454;BA.debugLine="Try";

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
RDebugUtils.currentLine=4456455;
 //BA.debugLineNum = 4456455;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/s";
_apiaddress = "http://192.168.1.3/schooltime.php";
RDebugUtils.currentLine=4456456;
 //BA.debugLineNum = 4456456;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=4456457;
 //BA.debugLineNum = 4456457;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingresodocente.getObject());
RDebugUtils.currentLine=4456458;
 //BA.debugLineNum = 4456458;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","evento","codigo",parent._codigo});
RDebugUtils.currentLine=4456459;
 //BA.debugLineNum = 4456459;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingresodocente", "remore"), (Object)(_js));
this.state = 72;
return;
case 72:
//C
this.state = 9;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=4456460;
 //BA.debugLineNum = 4456460;BA.debugLine="If js.Success Then";
if (true) break;

case 9:
//if
this.state = 68;
if (_js._success /*boolean*/ ) { 
this.state = 11;
}else {
this.state = 67;
}if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=4456461;
 //BA.debugLineNum = 4456461;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=4456462;
 //BA.debugLineNum = 4456462;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=4456463;
 //BA.debugLineNum = 4456463;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=4456464;
 //BA.debugLineNum = 4456464;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4456465;
 //BA.debugLineNum = 4456465;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=4456466;
 //BA.debugLineNum = 4456466;BA.debugLine="If (res.Length >0) Then";
if (true) break;

case 12:
//if
this.state = 65;
if ((_res.length()>0)) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=4456467;
 //BA.debugLineNum = 4456467;BA.debugLine="eventos = 1";
parent._eventos = (int) (1);
RDebugUtils.currentLine=4456468;
 //BA.debugLineNum = 4456468;BA.debugLine="If eventos = 1 Then";
if (true) break;

case 15:
//if
this.state = 18;
if (parent._eventos==1) { 
this.state = 17;
}if (true) break;

case 17:
//C
this.state = 18;
RDebugUtils.currentLine=4456469;
 //BA.debugLineNum = 4456469;BA.debugLine="evento1.Visible = True";
parent.mostCurrent._evento1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 18:
//C
this.state = 19;
;
RDebugUtils.currentLine=4456471;
 //BA.debugLineNum = 4456471;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4456472;
 //BA.debugLineNum = 4456472;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=4456473;
 //BA.debugLineNum = 4456473;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("74456473",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=4456474;
 //BA.debugLineNum = 4456474;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4456475;
 //BA.debugLineNum = 4456475;BA.debugLine="For i=0 To tabla.Size-1";
if (true) break;

case 19:
//for
this.state = 64;
step27 = 1;
limit27 = (int) (_tabla.getSize()-1);
_i = (int) (0) ;
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
if (true) break;

case 21:
//C
this.state = 22;
RDebugUtils.currentLine=4456476;
 //BA.debugLineNum = 4456476;BA.debugLine="fila= tabla.Get(i)";
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=4456477;
 //BA.debugLineNum = 4456477;BA.debugLine="tit = fila.Get(\"titulo\")";
parent._tit = BA.ObjectToString(_fila.Get((Object)("titulo")));
RDebugUtils.currentLine=4456478;
 //BA.debugLineNum = 4456478;BA.debugLine="tip = fila.Get(\"tipo\")";
parent._tip = BA.ObjectToString(_fila.Get((Object)("tipo")));
RDebugUtils.currentLine=4456479;
 //BA.debugLineNum = 4456479;BA.debugLine="fec = fila.Get(\"fecha\")";
parent._fec = BA.ObjectToString(_fila.Get((Object)("fecha")));
RDebugUtils.currentLine=4456480;
 //BA.debugLineNum = 4456480;BA.debugLine="hor = fila.Get(\"hora\")";
parent._hor = BA.ObjectToString(_fila.Get((Object)("hora")));
RDebugUtils.currentLine=4456481;
 //BA.debugLineNum = 4456481;BA.debugLine="des = fila.Get(\"descripcion\")";
parent._des = BA.ObjectToString(_fila.Get((Object)("descripcion")));
RDebugUtils.currentLine=4456482;
 //BA.debugLineNum = 4456482;BA.debugLine="If eventos =1 Then";
if (true) break;

case 22:
//if
this.state = 63;
if (parent._eventos==1) { 
this.state = 24;
}else {
this.state = 42;
}if (true) break;

case 24:
//C
this.state = 25;
RDebugUtils.currentLine=4456483;
 //BA.debugLineNum = 4456483;BA.debugLine="Dim n As Notification";
_n = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=4456484;
 //BA.debugLineNum = 4456484;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH)";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4456485;
 //BA.debugLineNum = 4456485;BA.debugLine="n.Initialize2(n.IMPORTANCE_HIGH)";
_n.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4456486;
 //BA.debugLineNum = 4456486;BA.debugLine="n.Icon =\"icon\"";
_n.setIcon("icon");
RDebugUtils.currentLine=4456487;
 //BA.debugLineNum = 4456487;BA.debugLine="n.SetInfo(tip,\"Se llevará acabo el \"&fec,Mai";
_n.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tip),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fec),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=4456488;
 //BA.debugLineNum = 4456488;BA.debugLine="n.Notify(1)";
_n.Notify((int) (1));
RDebugUtils.currentLine=4456489;
 //BA.debugLineNum = 4456489;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456490;
 //BA.debugLineNum = 4456490;BA.debugLine="evento2.Visible = False";
parent.mostCurrent._evento2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456491;
 //BA.debugLineNum = 4456491;BA.debugLine="titulo.Text = tit";
parent.mostCurrent._titulo.setText(BA.ObjectToCharSequence(parent._tit));
RDebugUtils.currentLine=4456492;
 //BA.debugLineNum = 4456492;BA.debugLine="fecha.Text = fec";
parent.mostCurrent._fecha.setText(BA.ObjectToCharSequence(parent._fec));
RDebugUtils.currentLine=4456493;
 //BA.debugLineNum = 4456493;BA.debugLine="tipo = tip";
parent.mostCurrent._tipo = parent._tip;
RDebugUtils.currentLine=4456494;
 //BA.debugLineNum = 4456494;BA.debugLine="hora.Text = hor";
parent.mostCurrent._hora.setText(BA.ObjectToCharSequence(parent._hor));
RDebugUtils.currentLine=4456495;
 //BA.debugLineNum = 4456495;BA.debugLine="desc11 = des";
parent._desc11 = parent._des;
RDebugUtils.currentLine=4456496;
 //BA.debugLineNum = 4456496;BA.debugLine="If tipo = \"Celebracion\" Then";
if (true) break;

case 25:
//if
this.state = 40;
if ((parent.mostCurrent._tipo).equals("Celebracion")) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 40;
RDebugUtils.currentLine=4456497;
 //BA.debugLineNum = 4456497;BA.debugLine="celebracion.Visible = True";
parent.mostCurrent._celebracion.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4456498;
 //BA.debugLineNum = 4456498;BA.debugLine="cambio.Visible = False";
parent.mostCurrent._cambio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456499;
 //BA.debugLineNum = 4456499;BA.debugLine="reunion.Visible = False";
parent.mostCurrent._reunion.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 29:
//C
this.state = 30;
RDebugUtils.currentLine=4456501;
 //BA.debugLineNum = 4456501;BA.debugLine="If tipo = \"Cambio\" Then";
if (true) break;

case 30:
//if
this.state = 39;
if ((parent.mostCurrent._tipo).equals("Cambio")) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 39;
RDebugUtils.currentLine=4456502;
 //BA.debugLineNum = 4456502;BA.debugLine="celebracion.Visible = False";
parent.mostCurrent._celebracion.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456503;
 //BA.debugLineNum = 4456503;BA.debugLine="cambio.Visible = True";
parent.mostCurrent._cambio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4456504;
 //BA.debugLineNum = 4456504;BA.debugLine="reunion.Visible = False";
parent.mostCurrent._reunion.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 34:
//C
this.state = 35;
RDebugUtils.currentLine=4456506;
 //BA.debugLineNum = 4456506;BA.debugLine="If tipo = \"Reunion\" Then";
if (true) break;

case 35:
//if
this.state = 38;
if ((parent.mostCurrent._tipo).equals("Reunion")) { 
this.state = 37;
}if (true) break;

case 37:
//C
this.state = 38;
RDebugUtils.currentLine=4456507;
 //BA.debugLineNum = 4456507;BA.debugLine="celebracion.Visible = False";
parent.mostCurrent._celebracion.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456508;
 //BA.debugLineNum = 4456508;BA.debugLine="cambio.Visible = False";
parent.mostCurrent._cambio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456509;
 //BA.debugLineNum = 4456509;BA.debugLine="reunion.Visible = True";
parent.mostCurrent._reunion.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=4456514;
 //BA.debugLineNum = 4456514;BA.debugLine="If eventos =2 Then";
if (true) break;

case 43:
//if
this.state = 62;
if (parent._eventos==2) { 
this.state = 45;
}if (true) break;

case 45:
//C
this.state = 46;
RDebugUtils.currentLine=4456515;
 //BA.debugLineNum = 4456515;BA.debugLine="Dim n1 As Notification";
_n1 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=4456516;
 //BA.debugLineNum = 4456516;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4456517;
 //BA.debugLineNum = 4456517;BA.debugLine="n1.Initialize2(n.IMPORTANCE_HIGH)";
_n1.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4456518;
 //BA.debugLineNum = 4456518;BA.debugLine="n1.Icon =\"icon\"";
_n1.setIcon("icon");
RDebugUtils.currentLine=4456519;
 //BA.debugLineNum = 4456519;BA.debugLine="n1.SetInfo(tip,\"Se llevará acabo el \"&fec,M";
_n1.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tip),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fec),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=4456520;
 //BA.debugLineNum = 4456520;BA.debugLine="n1.Notify(2)";
_n1.Notify((int) (2));
RDebugUtils.currentLine=4456521;
 //BA.debugLineNum = 4456521;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456522;
 //BA.debugLineNum = 4456522;BA.debugLine="evento2.Visible = True";
parent.mostCurrent._evento2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4456523;
 //BA.debugLineNum = 4456523;BA.debugLine="titulo2.Text = tit";
parent.mostCurrent._titulo2.setText(BA.ObjectToCharSequence(parent._tit));
RDebugUtils.currentLine=4456524;
 //BA.debugLineNum = 4456524;BA.debugLine="fecha2.Text = fec";
parent.mostCurrent._fecha2.setText(BA.ObjectToCharSequence(parent._fec));
RDebugUtils.currentLine=4456525;
 //BA.debugLineNum = 4456525;BA.debugLine="tipo2 = tip";
parent._tipo2 = parent._tip;
RDebugUtils.currentLine=4456526;
 //BA.debugLineNum = 4456526;BA.debugLine="hora2.Text = hor";
parent.mostCurrent._hora2.setText(BA.ObjectToCharSequence(parent._hor));
RDebugUtils.currentLine=4456527;
 //BA.debugLineNum = 4456527;BA.debugLine="desc2 = des";
parent._desc2 = parent._des;
RDebugUtils.currentLine=4456528;
 //BA.debugLineNum = 4456528;BA.debugLine="If tipo2 = \"Celebracion\" Then";
if (true) break;

case 46:
//if
this.state = 61;
if ((parent._tipo2).equals("Celebracion")) { 
this.state = 48;
}else {
this.state = 50;
}if (true) break;

case 48:
//C
this.state = 61;
RDebugUtils.currentLine=4456529;
 //BA.debugLineNum = 4456529;BA.debugLine="celebracion2.Visible = True";
parent.mostCurrent._celebracion2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4456530;
 //BA.debugLineNum = 4456530;BA.debugLine="cambio2.Visible = False";
parent.mostCurrent._cambio2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456531;
 //BA.debugLineNum = 4456531;BA.debugLine="reunion2.Visible = False";
parent.mostCurrent._reunion2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 50:
//C
this.state = 51;
RDebugUtils.currentLine=4456533;
 //BA.debugLineNum = 4456533;BA.debugLine="If tipo2 = \"Cambio\" Then";
if (true) break;

case 51:
//if
this.state = 60;
if ((parent._tipo2).equals("Cambio")) { 
this.state = 53;
}else {
this.state = 55;
}if (true) break;

case 53:
//C
this.state = 60;
RDebugUtils.currentLine=4456534;
 //BA.debugLineNum = 4456534;BA.debugLine="celebracion2.Visible = False";
parent.mostCurrent._celebracion2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456535;
 //BA.debugLineNum = 4456535;BA.debugLine="cambio2.Visible = True";
parent.mostCurrent._cambio2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4456536;
 //BA.debugLineNum = 4456536;BA.debugLine="reunion2.Visible = False";
parent.mostCurrent._reunion2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 55:
//C
this.state = 56;
RDebugUtils.currentLine=4456538;
 //BA.debugLineNum = 4456538;BA.debugLine="If tipo2 = \"Reunion\" Then";
if (true) break;

case 56:
//if
this.state = 59;
if ((parent._tipo2).equals("Reunion")) { 
this.state = 58;
}if (true) break;

case 58:
//C
this.state = 59;
RDebugUtils.currentLine=4456539;
 //BA.debugLineNum = 4456539;BA.debugLine="celebracion2.Visible = False";
parent.mostCurrent._celebracion2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456540;
 //BA.debugLineNum = 4456540;BA.debugLine="cambio2.Visible = False";
parent.mostCurrent._cambio2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456541;
 //BA.debugLineNum = 4456541;BA.debugLine="reunion2.Visible = True";
parent.mostCurrent._reunion2.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=4456547;
 //BA.debugLineNum = 4456547;BA.debugLine="eventos = eventos  + 1";
parent._eventos = (int) (parent._eventos+1);
 if (true) break;
if (true) break;

case 64:
//C
this.state = 65;
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
RDebugUtils.currentLine=4456551;
 //BA.debugLineNum = 4456551;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("74456551",_js._errormessage /*String*/ ,0);
 if (true) break;

case 68:
//C
this.state = 71;
;
 if (true) break;

case 70:
//C
this.state = 71;
this.catchState = 0;
RDebugUtils.currentLine=4456554;
 //BA.debugLineNum = 4456554;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("74456554",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 71:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=4456556;
 //BA.debugLineNum = 4456556;BA.debugLine="End Sub";
if (true) break;
}} 
       catch (Exception e0) {
			
if (catchState == 0)
    throw e0;
else {
    state = catchState;
processBA.setLastException(e0);}
            }
        }
    }
}
public static String  _evento1_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento1_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento1_click", null));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub evento1_Click";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="evento11.Visible = True";
mostCurrent._evento11.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="titulo1.Text = titulo.Text";
mostCurrent._titulo1.setText(BA.ObjectToCharSequence(mostCurrent._titulo.getText()));
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="fecha1.Text = fecha.Text";
mostCurrent._fecha1.setText(BA.ObjectToCharSequence(mostCurrent._fecha.getText()));
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="hora1.Text = hora.Text";
mostCurrent._hora1.setText(BA.ObjectToCharSequence(mostCurrent._hora.getText()));
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="desc1.Text = desc11";
mostCurrent._desc1.setText(BA.ObjectToCharSequence(_desc11));
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="If tipo = \"Celebracion\" Then";
if ((mostCurrent._tipo).equals("Celebracion")) { 
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="icono1.Visible = True";
mostCurrent._icono1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="icono1C.Visible = False";
mostCurrent._icono1c.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="icono1R.Visible = False";
mostCurrent._icono1r.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="If tipo = \"Reunion\" Then";
if ((mostCurrent._tipo).equals("Reunion")) { 
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="icono1.Visible = False";
mostCurrent._icono1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="icono1C.Visible = False";
mostCurrent._icono1c.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="icono1R.Visible = True";
mostCurrent._icono1r.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4128786;
 //BA.debugLineNum = 4128786;BA.debugLine="If tipo = \"Cambio\" Then";
if ((mostCurrent._tipo).equals("Cambio")) { 
RDebugUtils.currentLine=4128787;
 //BA.debugLineNum = 4128787;BA.debugLine="icono1.Visible = False";
mostCurrent._icono1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128788;
 //BA.debugLineNum = 4128788;BA.debugLine="icono1C.Visible = True";
mostCurrent._icono1c.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128789;
 //BA.debugLineNum = 4128789;BA.debugLine="icono1R.Visible = False";
mostCurrent._icono1r.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=4128793;
 //BA.debugLineNum = 4128793;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=4128795;
 //BA.debugLineNum = 4128795;BA.debugLine="End Sub";
return "";
}
public static String  _evento2_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento2_click", null));}
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub evento2_Click";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="evento22.Visible = True";
mostCurrent._evento22.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="titulo22.Text = titulo2.Text";
mostCurrent._titulo22.setText(BA.ObjectToCharSequence(mostCurrent._titulo2.getText()));
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="fecha22.Text = fecha2.Text";
mostCurrent._fecha22.setText(BA.ObjectToCharSequence(mostCurrent._fecha2.getText()));
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="hora22.Text = hora2.Text";
mostCurrent._hora22.setText(BA.ObjectToCharSequence(mostCurrent._hora2.getText()));
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="descripcion22.Text = desc2";
mostCurrent._descripcion22.setText(BA.ObjectToCharSequence(_desc2));
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="If tipo2 = \"Celebracion\" Then";
if ((_tipo2).equals("Celebracion")) { 
RDebugUtils.currentLine=4259849;
 //BA.debugLineNum = 4259849;BA.debugLine="celebracion22.Visible = True";
mostCurrent._celebracion22.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="cambio22.Visible = False";
mostCurrent._cambio22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259851;
 //BA.debugLineNum = 4259851;BA.debugLine="reunion22.Visible = False";
mostCurrent._reunion22.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4259853;
 //BA.debugLineNum = 4259853;BA.debugLine="If tipo2 = \"Reunion\" Then";
if ((_tipo2).equals("Reunion")) { 
RDebugUtils.currentLine=4259854;
 //BA.debugLineNum = 4259854;BA.debugLine="celebracion22.Visible = False";
mostCurrent._celebracion22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259855;
 //BA.debugLineNum = 4259855;BA.debugLine="cambio22.Visible = False";
mostCurrent._cambio22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259856;
 //BA.debugLineNum = 4259856;BA.debugLine="reunion22.Visible = True";
mostCurrent._reunion22.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4259858;
 //BA.debugLineNum = 4259858;BA.debugLine="If tipo2 = \"Cambio\" Then";
if ((_tipo2).equals("Cambio")) { 
RDebugUtils.currentLine=4259859;
 //BA.debugLineNum = 4259859;BA.debugLine="celebracion22.Visible = False";
mostCurrent._celebracion22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4259860;
 //BA.debugLineNum = 4259860;BA.debugLine="cambio22.Visible = True";
mostCurrent._cambio22.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4259861;
 //BA.debugLineNum = 4259861;BA.debugLine="reunion22.Visible = False";
mostCurrent._reunion22.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=4259865;
 //BA.debugLineNum = 4259865;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=4259867;
 //BA.debugLineNum = 4259867;BA.debugLine="End Sub";
return "";
}
public static String  _inicio_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inicio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "inicio_click", null));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub inicio_Click";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="If event = 1 Then";
if (_event==1) { 
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="evento11.Visible = False";
mostCurrent._evento11.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="evento22.Visible = False";
mostCurrent._evento22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="event = 0";
_event = (int) (0);
 };
RDebugUtils.currentLine=4194311;
 //BA.debugLineNum = 4194311;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
anywheresoftware.b4a.keywords.Common.LogImpl("74063234","OK, se actualizó correctamente",0);
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito"),BA.ObjectToCharSequence("AVISO"),processBA);
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="txtconact.Text=\"\"";
mostCurrent._txtconact.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="txtconnuv.Text=\"\"";
mostCurrent._txtconnuv.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="txtconfcon.Text=\"\"";
mostCurrent._txtconfcon.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="inicio.Visible=False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4063241;
 //BA.debugLineNum = 4063241;BA.debugLine="estado=0";
_estado = (int) (0);
 }else {
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("74063243",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=4063244;
 //BA.debugLineNum = 4063244;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4063246;
 //BA.debugLineNum = 4063246;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=4063247;
 //BA.debugLineNum = 4063247;BA.debugLine="End Sub";
return "";
}
public static String  _retroceder_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "retroceder_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "retroceder_click", null));}
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub retroceder_Click";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="If estado = 1 Then";
if (_estado==1) { 
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="estado = 0";
_estado = (int) (0);
 };
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="End Sub";
return "";
}
public static String  _txtconact_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconact_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconact_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub txtconact_TextChanged (Old As String, New As S";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="MsgboxAsync(\"Laconfirmación de la contraseña no";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfcon_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfcon_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfcon_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub txtconfcon_TextChanged (Old As String, New As";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="End Sub";
return "";
}
}
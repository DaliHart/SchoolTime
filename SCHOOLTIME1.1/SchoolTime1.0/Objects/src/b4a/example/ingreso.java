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

public class ingreso extends Activity implements B4AActivity{
	public static ingreso mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.ingreso");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (ingreso).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.ingreso");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.ingreso", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (ingreso) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (ingreso) Resume **");
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
		return ingreso.class;
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
        BA.LogInfo("** Activity (ingreso) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            ingreso mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (ingreso) Resume **");
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
public static int _estado = 0;
public static String _titulo = "";
public static String _descripcion = "";
public static String _fecha = "";
public static String _hora = "";
public static String _tipo = "";
public static String _tipo1 = "";
public static String _tipo2 = "";
public static String _tipo3 = "";
public static String _tipo4 = "";
public static String _c = "";
public static String _codigo = "";
public static String _desc1 = "";
public static String _desc2 = "";
public static String _desc3 = "";
public static String _desc4 = "";
public static int _eventos = 0;
public static int _event = 0;
public anywheresoftware.b4a.objects.TabHostWrapper _tabhost1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncambiaracudiente = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncerraracudiente = null;
public anywheresoftware.b4a.objects.PanelWrapper _inicio = null;
public anywheresoftware.b4a.objects.LabelWrapper _cerrar = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconact = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconnuv = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconfcon = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncambio = null;
public anywheresoftware.b4a.objects.LabelWrapper _anuncio = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio1a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio2a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion1a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion2a = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento1a = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento2a = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha1a = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha2a = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora1a = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora2a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion1a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion2a = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo1a = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo2a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio11a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio22a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion11a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion22a = null;
public anywheresoftware.b4a.objects.EditTextWrapper _contraseñaa = null;
public anywheresoftware.b4a.objects.PanelWrapper _datos = null;
public anywheresoftware.b4a.objects.LabelWrapper _desc11a = null;
public anywheresoftware.b4a.objects.LabelWrapper _desc22a = null;
public anywheresoftware.b4a.objects.ButtonWrapper _enviara = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento11a = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha11a = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha22a = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora11a = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora22a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion11a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion22a = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo11a = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo22a = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento22a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio3a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio4a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion3a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion4a = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento3a = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento4a = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha3a = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha4a = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora3a = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora4a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion3a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion4a = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo3a = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo4a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio33a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio44a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion33a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion44a = null;
public anywheresoftware.b4a.objects.LabelWrapper _descripcion33a = null;
public anywheresoftware.b4a.objects.LabelWrapper _descripcion44a = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento33a = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento44a = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha33a = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha44a = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora33a = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora44a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion33a = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion44a = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo33a = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo44a = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.perfiles _perfiles = null;
public b4a.example.ingresodocente _ingresodocente = null;
public b4a.example.ingresoestudiante _ingresoestudiante = null;
public b4a.example.inicioacudiente _inicioacudiente = null;
public b4a.example.iniciodocente _iniciodocente = null;
public b4a.example.inicioestudiante _inicioestudiante = null;
public b4a.example.registroacudiente _registroacudiente = null;
public b4a.example.registrodocente _registrodocente = null;
public b4a.example.registroestudiante _registroestudiante = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=2818048;
 //BA.debugLineNum = 2818048;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=2818050;
 //BA.debugLineNum = 2818050;BA.debugLine="Activity.LoadLayout(\"ingreso\")";
mostCurrent._activity.LoadLayout("ingreso",mostCurrent.activityBA);
RDebugUtils.currentLine=2818051;
 //BA.debugLineNum = 2818051;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"evento\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"EVENTOS","evento");
RDebugUtils.currentLine=2818052;
 //BA.debugLineNum = 2818052;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfil\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"PERFIL","perfil");
RDebugUtils.currentLine=2818053;
 //BA.debugLineNum = 2818053;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818054;
 //BA.debugLineNum = 2818054;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=2818055;
 //BA.debugLineNum = 2818055;BA.debugLine="evento1A.Visible=False";
mostCurrent._evento1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818056;
 //BA.debugLineNum = 2818056;BA.debugLine="evento2A.Visible=False";
mostCurrent._evento2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818057;
 //BA.debugLineNum = 2818057;BA.debugLine="evento3A.Visible=False";
mostCurrent._evento3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818058;
 //BA.debugLineNum = 2818058;BA.debugLine="evento4A.Visible=False";
mostCurrent._evento4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818059;
 //BA.debugLineNum = 2818059;BA.debugLine="evento11A.Visible=False";
mostCurrent._evento11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818060;
 //BA.debugLineNum = 2818060;BA.debugLine="evento22A.Visible=False";
mostCurrent._evento22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818061;
 //BA.debugLineNum = 2818061;BA.debugLine="evento33A.Visible= False";
mostCurrent._evento33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818062;
 //BA.debugLineNum = 2818062;BA.debugLine="evento44A.Visible= False";
mostCurrent._evento44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818063;
 //BA.debugLineNum = 2818063;BA.debugLine="Anuncio.Visible=False";
mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=2818064;
 //BA.debugLineNum = 2818064;BA.debugLine="eventos = 0";
_eventos = (int) (0);
RDebugUtils.currentLine=2818065;
 //BA.debugLineNum = 2818065;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ingreso";
RDebugUtils.currentLine=2949120;
 //BA.debugLineNum = 2949120;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=2949122;
 //BA.debugLineNum = 2949122;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=2883584;
 //BA.debugLineNum = 2883584;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=2883586;
 //BA.debugLineNum = 2883586;BA.debugLine="End Sub";
return "";
}
public static String  _btncambiaracudiente_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambiaracudiente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambiaracudiente_click", null));}
RDebugUtils.currentLine=3014656;
 //BA.debugLineNum = 3014656;BA.debugLine="Sub btncambiaracudiente_Click";
RDebugUtils.currentLine=3014657;
 //BA.debugLineNum = 3014657;BA.debugLine="If estado = 0 Then";
if (_estado==0) { 
RDebugUtils.currentLine=3014658;
 //BA.debugLineNum = 3014658;BA.debugLine="Panel1.Visible = True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3014659;
 //BA.debugLineNum = 3014659;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3014660;
 //BA.debugLineNum = 3014660;BA.debugLine="estado = 1";
_estado = (int) (1);
 };
RDebugUtils.currentLine=3014662;
 //BA.debugLineNum = 3014662;BA.debugLine="End Sub";
return "";
}
public static String  _btncambio_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambio_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub btncambio_Click";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="If txtconact.Text<>\"\" And txtconnuv.Text<>\"\" And";
if ((mostCurrent._txtconact.getText()).equals("") == false && (mostCurrent._txtconnuv.getText()).equals("") == false && (mostCurrent._txtconfcon.getText()).equals("") == false) { 
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="If txtconnuv.Text = txtconfcon.Text Then";
if ((mostCurrent._txtconnuv.getText()).equals(mostCurrent._txtconfcon.getText())) { 
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/";
_apiaddress = "http://192.168.1.5/schooltime1.php";
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=3407877;
 //BA.debugLineNum = 3407877;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",ingreso.getObject());
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tbl_acudiente";
_job._poststring /*String*/ (null,_apiaddress,"UPDATE tbl_acudiente SET contrasena_acu='"+mostCurrent._txtconnuv.getText()+"' WHERE contrasena_acu='"+mostCurrent._txtconact.getText()+"'");
 }else {
RDebugUtils.currentLine=3407880;
 //BA.debugLineNum = 3407880;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Las contraseñas deben coincidir"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
 }else {
RDebugUtils.currentLine=3407883;
 //BA.debugLineNum = 3407883;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=3407885;
 //BA.debugLineNum = 3407885;BA.debugLine="End Sub";
return "";
}
public static String  _btncerraracudiente_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncerraracudiente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncerraracudiente_click", null));}
RDebugUtils.currentLine=3080192;
 //BA.debugLineNum = 3080192;BA.debugLine="Sub btncerraracudiente_Click";
RDebugUtils.currentLine=3080193;
 //BA.debugLineNum = 3080193;BA.debugLine="StartActivity(perfiles)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._perfiles.getObject()));
RDebugUtils.currentLine=3080194;
 //BA.debugLineNum = 3080194;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3080195;
 //BA.debugLineNum = 3080195;BA.debugLine="End Sub";
return "";
}
public static String  _cerrar_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cerrar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cerrar_click", null));}
RDebugUtils.currentLine=3145728;
 //BA.debugLineNum = 3145728;BA.debugLine="Sub cerrar_Click";
RDebugUtils.currentLine=3145729;
 //BA.debugLineNum = 3145729;BA.debugLine="If estado = 1 Then";
if (_estado==1) { 
RDebugUtils.currentLine=3145730;
 //BA.debugLineNum = 3145730;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3145731;
 //BA.debugLineNum = 3145731;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3145732;
 //BA.debugLineNum = 3145732;BA.debugLine="estado = 0";
_estado = (int) (0);
 };
RDebugUtils.currentLine=3145734;
 //BA.debugLineNum = 3145734;BA.debugLine="End Sub";
return "";
}
public static String  _createnotificationchannel(int _importancelevel) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createnotificationchannel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "createnotificationchannel", new Object[] {_importancelevel}));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _ctxt = null;
String _channelid = "";
anywheresoftware.b4j.object.JavaObject _channel = null;
anywheresoftware.b4j.object.JavaObject _manager = null;
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub CreateNotificationChannel(ImportanceLevel As I";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="If p.SdkVersion >= 26 Then";
if (_p.getSdkVersion()>=26) { 
RDebugUtils.currentLine=3735555;
 //BA.debugLineNum = 3735555;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(processBA);
RDebugUtils.currentLine=3735557;
 //BA.debugLineNum = 3735557;BA.debugLine="Dim channelId As String = \"channel_\"& Importance";
_channelid = "channel_"+BA.NumberToString(_importancelevel);
RDebugUtils.currentLine=3735558;
 //BA.debugLineNum = 3735558;BA.debugLine="Dim channel As JavaObject";
_channel = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=3735559;
 //BA.debugLineNum = 3735559;BA.debugLine="channel.InitializeNewInstance(\"android.app.Notif";
_channel.InitializeNewInstance("android.app.NotificationChannel",new Object[]{(Object)(_channelid),(Object)(anywheresoftware.b4a.keywords.Common.Application.getLabelName()),(Object)(_importancelevel)});
RDebugUtils.currentLine=3735560;
 //BA.debugLineNum = 3735560;BA.debugLine="channel.RunMethod(\"setShowBadge\",Array(False))";
_channel.RunMethod("setShowBadge",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.False)});
RDebugUtils.currentLine=3735562;
 //BA.debugLineNum = 3735562;BA.debugLine="Dim manager As JavaObject = ctxt.RunMethod(\"getS";
_manager = new anywheresoftware.b4j.object.JavaObject();
_manager.setObject((java.lang.Object)(_ctxt.RunMethod("getSystemService",new Object[]{(Object)("notification")})));
RDebugUtils.currentLine=3735563;
 //BA.debugLineNum = 3735563;BA.debugLine="manager.RunMethod(\"createNotificationChannel\",Ar";
_manager.RunMethod("createNotificationChannel",new Object[]{(Object)(_channel.getObject())});
 };
RDebugUtils.currentLine=3735566;
 //BA.debugLineNum = 3735566;BA.debugLine="End Sub";
return "";
}
public static void  _enviara_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "enviara_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "enviara_click", null); return;}
ResumableSub_EnviarA_Click rsub = new ResumableSub_EnviarA_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_EnviarA_Click extends BA.ResumableSub {
public ResumableSub_EnviarA_Click(b4a.example.ingreso parent) {
this.parent = parent;
}
b4a.example.ingreso parent;
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
RDebugUtils.currentModule="ingreso";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="If contraseñaA.Text <> \"\" Then";
if (true) break;

case 1:
//if
this.state = 26;
if ((parent.mostCurrent._contraseñaa.getText()).equals("") == false) { 
this.state = 3;
}else {
this.state = 25;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="Try";
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
RDebugUtils.currentLine=3670019;
 //BA.debugLineNum = 3670019;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/";
_apiaddress = "http://192.168.1.5/schooltime.php";
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=3670021;
 //BA.debugLineNum = 3670021;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingreso.getObject());
RDebugUtils.currentLine=3670022;
 //BA.debugLineNum = 3670022;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","cedula","pin",parent.mostCurrent._contraseñaa.getText(),"tabla","tbl_acudiente","codigo","codigo_g","cedula","id_acudiente"});
RDebugUtils.currentLine=3670023;
 //BA.debugLineNum = 3670023;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingreso", "enviara_click"), (Object)(_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=3670024;
 //BA.debugLineNum = 3670024;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=3670025;
 //BA.debugLineNum = 3670025;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=3670026;
 //BA.debugLineNum = 3670026;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=3670027;
 //BA.debugLineNum = 3670027;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=3670028;
 //BA.debugLineNum = 3670028;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3670029;
 //BA.debugLineNum = 3670029;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=3670030;
 //BA.debugLineNum = 3670030;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=3670031;
 //BA.debugLineNum = 3670031;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3670032;
 //BA.debugLineNum = 3670032;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=3670033;
 //BA.debugLineNum = 3670033;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("23670033",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=3670034;
 //BA.debugLineNum = 3670034;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=3670035;
 //BA.debugLineNum = 3670035;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=3670036;
 //BA.debugLineNum = 3670036;BA.debugLine="fila= tabla.Get(i)";
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=3670037;
 //BA.debugLineNum = 3670037;BA.debugLine="codigo = fila.Get(\"codigo_g\")";
parent._codigo = BA.ObjectToString(_fila.Get((Object)("codigo_g")));
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
RDebugUtils.currentLine=3670041;
 //BA.debugLineNum = 3670041;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("23670041",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=3670044;
 //BA.debugLineNum = 3670044;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("23670044",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
RDebugUtils.currentLine=3670046;
 //BA.debugLineNum = 3670046;BA.debugLine="inicio.Visible =False";
parent.mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3670047;
 //BA.debugLineNum = 3670047;BA.debugLine="Datos.Visible = False";
parent.mostCurrent._datos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 25:
//C
this.state = 26;
RDebugUtils.currentLine=3670049;
 //BA.debugLineNum = 3670049;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Necesitas este campo para el ingreso"),BA.ObjectToCharSequence("AVISO"),processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
RDebugUtils.currentLine=3670051;
 //BA.debugLineNum = 3670051;BA.debugLine="remoreA";
_remorea();
RDebugUtils.currentLine=3670052;
 //BA.debugLineNum = 3670052;BA.debugLine="End Sub";
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
public static void  _remorea() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "remorea", false))
	 {Debug.delegate(mostCurrent.activityBA, "remorea", null); return;}
ResumableSub_remoreA rsub = new ResumableSub_remoreA(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_remoreA extends BA.ResumableSub {
public ResumableSub_remoreA(b4a.example.ingreso parent) {
this.parent = parent;
}
b4a.example.ingreso parent;
String _apiaddress = "";
b4a.example.httpjob _js = null;
String _res = "";
anywheresoftware.b4a.objects.collections.JSONParser _parser = null;
anywheresoftware.b4a.objects.collections.List _tabla = null;
anywheresoftware.b4a.objects.collections.Map _fila = null;
int _i = 0;
anywheresoftware.b4a.objects.NotificationWrapper _n = null;
anywheresoftware.b4a.objects.NotificationWrapper _n2 = null;
anywheresoftware.b4a.objects.NotificationWrapper _n3 = null;
anywheresoftware.b4a.objects.NotificationWrapper _n4 = null;
int step27;
int limit27;

@Override
public void resume(BA ba, Object[] result) throws Exception{
RDebugUtils.currentModule="ingreso";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="If eventos = 0 Then";
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
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="Anuncio.Visible = True";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
;
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="Try";

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
RDebugUtils.currentLine=3801095;
 //BA.debugLineNum = 3801095;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/s";
_apiaddress = "http://192.168.1.5/schooltime.php";
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=3801097;
 //BA.debugLineNum = 3801097;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingreso.getObject());
RDebugUtils.currentLine=3801098;
 //BA.debugLineNum = 3801098;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","evento","codigo",parent._codigo,"quien","acudiente"});
RDebugUtils.currentLine=3801099;
 //BA.debugLineNum = 3801099;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingreso", "remorea"), (Object)(_js));
this.state = 174;
return;
case 174:
//C
this.state = 9;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=3801100;
 //BA.debugLineNum = 3801100;BA.debugLine="If js.Success Then";
if (true) break;

case 9:
//if
this.state = 170;
if (_js._success /*boolean*/ ) { 
this.state = 11;
}else {
this.state = 169;
}if (true) break;

case 11:
//C
this.state = 12;
RDebugUtils.currentLine=3801101;
 //BA.debugLineNum = 3801101;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=3801102;
 //BA.debugLineNum = 3801102;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=3801103;
 //BA.debugLineNum = 3801103;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=3801104;
 //BA.debugLineNum = 3801104;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=3801105;
 //BA.debugLineNum = 3801105;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=3801106;
 //BA.debugLineNum = 3801106;BA.debugLine="If (res.Length >0) Then";
if (true) break;

case 12:
//if
this.state = 167;
if ((_res.length()>0)) { 
this.state = 14;
}if (true) break;

case 14:
//C
this.state = 15;
RDebugUtils.currentLine=3801107;
 //BA.debugLineNum = 3801107;BA.debugLine="eventos = 1";
parent._eventos = (int) (1);
RDebugUtils.currentLine=3801108;
 //BA.debugLineNum = 3801108;BA.debugLine="If eventos = 1 Then";
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
RDebugUtils.currentLine=3801109;
 //BA.debugLineNum = 3801109;BA.debugLine="evento1A.Visible = True";
parent.mostCurrent._evento1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 18:
//C
this.state = 19;
;
RDebugUtils.currentLine=3801111;
 //BA.debugLineNum = 3801111;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=3801112;
 //BA.debugLineNum = 3801112;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=3801113;
 //BA.debugLineNum = 3801113;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("23801113",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=3801114;
 //BA.debugLineNum = 3801114;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=3801115;
 //BA.debugLineNum = 3801115;BA.debugLine="For i=0 To tabla.Size-1";
if (true) break;

case 19:
//for
this.state = 166;
step27 = 1;
limit27 = (int) (_tabla.getSize()-1);
_i = (int) (0) ;
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
if (true) break;

case 21:
//C
this.state = 22;
RDebugUtils.currentLine=3801116;
 //BA.debugLineNum = 3801116;BA.debugLine="fila= tabla.Get(i)";
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=3801117;
 //BA.debugLineNum = 3801117;BA.debugLine="titulo = fila.Get(\"titulo_e\")";
parent._titulo = BA.ObjectToString(_fila.Get((Object)("titulo_e")));
RDebugUtils.currentLine=3801118;
 //BA.debugLineNum = 3801118;BA.debugLine="descripcion = fila.Get(\"descripcion_e\")";
parent._descripcion = BA.ObjectToString(_fila.Get((Object)("descripcion_e")));
RDebugUtils.currentLine=3801119;
 //BA.debugLineNum = 3801119;BA.debugLine="c= fila.Get(\"codigo_g\")";
parent._c = BA.ObjectToString(_fila.Get((Object)("codigo_g")));
RDebugUtils.currentLine=3801120;
 //BA.debugLineNum = 3801120;BA.debugLine="fecha = fila.Get(\"fecha_evento\")";
parent._fecha = BA.ObjectToString(_fila.Get((Object)("fecha_evento")));
RDebugUtils.currentLine=3801121;
 //BA.debugLineNum = 3801121;BA.debugLine="hora = fila.Get(\"hora_evento\")";
parent._hora = BA.ObjectToString(_fila.Get((Object)("hora_evento")));
RDebugUtils.currentLine=3801122;
 //BA.debugLineNum = 3801122;BA.debugLine="tipo = fila.Get(\"id_tipo\")";
parent._tipo = BA.ObjectToString(_fila.Get((Object)("id_tipo")));
RDebugUtils.currentLine=3801123;
 //BA.debugLineNum = 3801123;BA.debugLine="If eventos =1 Then";
if (true) break;

case 22:
//if
this.state = 165;
if (parent._eventos==1) { 
this.state = 24;
}else {
this.state = 58;
}if (true) break;

case 24:
//C
this.state = 25;
RDebugUtils.currentLine=3801124;
 //BA.debugLineNum = 3801124;BA.debugLine="tipo1 = tipo";
parent._tipo1 = parent._tipo;
RDebugUtils.currentLine=3801125;
 //BA.debugLineNum = 3801125;BA.debugLine="If tipo1 = \"00A\" Then";
if (true) break;

case 25:
//if
this.state = 40;
if ((parent._tipo1).equals("00A")) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 40;
RDebugUtils.currentLine=3801126;
 //BA.debugLineNum = 3801126;BA.debugLine="tipo1 = \"Celebración\"";
parent._tipo1 = "Celebración";
 if (true) break;

case 29:
//C
this.state = 30;
RDebugUtils.currentLine=3801128;
 //BA.debugLineNum = 3801128;BA.debugLine="If tipo1 = \"00B\" Then";
if (true) break;

case 30:
//if
this.state = 39;
if ((parent._tipo1).equals("00B")) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 39;
RDebugUtils.currentLine=3801129;
 //BA.debugLineNum = 3801129;BA.debugLine="tipo1 = \"Cambio\"";
parent._tipo1 = "Cambio";
 if (true) break;

case 34:
//C
this.state = 35;
RDebugUtils.currentLine=3801131;
 //BA.debugLineNum = 3801131;BA.debugLine="If tipo1 = \"00C\" Then";
if (true) break;

case 35:
//if
this.state = 38;
if ((parent._tipo1).equals("00C")) { 
this.state = 37;
}if (true) break;

case 37:
//C
this.state = 38;
RDebugUtils.currentLine=3801132;
 //BA.debugLineNum = 3801132;BA.debugLine="tipo1 = \"Reunión\"";
parent._tipo1 = "Reunión";
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
RDebugUtils.currentLine=3801136;
 //BA.debugLineNum = 3801136;BA.debugLine="Dim n As Notification";
_n = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=3801137;
 //BA.debugLineNum = 3801137;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH)";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=3801138;
 //BA.debugLineNum = 3801138;BA.debugLine="n.Initialize2(n.IMPORTANCE_HIGH)";
_n.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=3801139;
 //BA.debugLineNum = 3801139;BA.debugLine="n.Icon =\"icon\"";
_n.setIcon("icon");
RDebugUtils.currentLine=3801140;
 //BA.debugLineNum = 3801140;BA.debugLine="n.SetInfo(tipo1,\"Se llevará acabo el \"&fecha";
_n.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo1),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=3801141;
 //BA.debugLineNum = 3801141;BA.debugLine="n.Notify(1)";
_n.Notify((int) (1));
RDebugUtils.currentLine=3801142;
 //BA.debugLineNum = 3801142;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801143;
 //BA.debugLineNum = 3801143;BA.debugLine="evento1A.Visible = true";
parent.mostCurrent._evento1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801144;
 //BA.debugLineNum = 3801144;BA.debugLine="titulo1A.Text = titulo";
parent.mostCurrent._titulo1a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=3801145;
 //BA.debugLineNum = 3801145;BA.debugLine="fecha1A.Text = fecha";
parent.mostCurrent._fecha1a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=3801146;
 //BA.debugLineNum = 3801146;BA.debugLine="hora1A.Text = hora";
parent.mostCurrent._hora1a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=3801147;
 //BA.debugLineNum = 3801147;BA.debugLine="desc1 = descripcion";
parent._desc1 = parent._descripcion;
RDebugUtils.currentLine=3801148;
 //BA.debugLineNum = 3801148;BA.debugLine="If tipo1 = \"Celebración\" Then";
if (true) break;

case 41:
//if
this.state = 56;
if ((parent._tipo1).equals("Celebración")) { 
this.state = 43;
}else {
this.state = 45;
}if (true) break;

case 43:
//C
this.state = 56;
RDebugUtils.currentLine=3801149;
 //BA.debugLineNum = 3801149;BA.debugLine="celebracion1A.Visible = True";
parent.mostCurrent._celebracion1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801150;
 //BA.debugLineNum = 3801150;BA.debugLine="cambio1A.Visible = False";
parent.mostCurrent._cambio1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801151;
 //BA.debugLineNum = 3801151;BA.debugLine="reunion1A.Visible = False";
parent.mostCurrent._reunion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 45:
//C
this.state = 46;
RDebugUtils.currentLine=3801153;
 //BA.debugLineNum = 3801153;BA.debugLine="If tipo1 = \"Cambio\" Then";
if (true) break;

case 46:
//if
this.state = 55;
if ((parent._tipo1).equals("Cambio")) { 
this.state = 48;
}else {
this.state = 50;
}if (true) break;

case 48:
//C
this.state = 55;
RDebugUtils.currentLine=3801154;
 //BA.debugLineNum = 3801154;BA.debugLine="celebracion1A.Visible = False";
parent.mostCurrent._celebracion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801155;
 //BA.debugLineNum = 3801155;BA.debugLine="cambio1A.Visible = True";
parent.mostCurrent._cambio1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801156;
 //BA.debugLineNum = 3801156;BA.debugLine="reunion1A.Visible = False";
parent.mostCurrent._reunion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 50:
//C
this.state = 51;
RDebugUtils.currentLine=3801158;
 //BA.debugLineNum = 3801158;BA.debugLine="If tipo1 = \"Reunión\" Then";
if (true) break;

case 51:
//if
this.state = 54;
if ((parent._tipo1).equals("Reunión")) { 
this.state = 53;
}if (true) break;

case 53:
//C
this.state = 54;
RDebugUtils.currentLine=3801159;
 //BA.debugLineNum = 3801159;BA.debugLine="celebracion1A.Visible = False";
parent.mostCurrent._celebracion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801160;
 //BA.debugLineNum = 3801160;BA.debugLine="cambio1A.Visible = False";
parent.mostCurrent._cambio1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801161;
 //BA.debugLineNum = 3801161;BA.debugLine="reunion1A.Visible = True";
parent.mostCurrent._reunion1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=3801166;
 //BA.debugLineNum = 3801166;BA.debugLine="If eventos =2 Then";
if (true) break;

case 59:
//if
this.state = 94;
if (parent._eventos==2) { 
this.state = 61;
}if (true) break;

case 61:
//C
this.state = 62;
RDebugUtils.currentLine=3801167;
 //BA.debugLineNum = 3801167;BA.debugLine="tipo2 = tipo";
parent._tipo2 = parent._tipo;
RDebugUtils.currentLine=3801168;
 //BA.debugLineNum = 3801168;BA.debugLine="If tipo2 = \"00A\" Then";
if (true) break;

case 62:
//if
this.state = 77;
if ((parent._tipo2).equals("00A")) { 
this.state = 64;
}else {
this.state = 66;
}if (true) break;

case 64:
//C
this.state = 77;
RDebugUtils.currentLine=3801169;
 //BA.debugLineNum = 3801169;BA.debugLine="tipo2 = \"Celebración\"";
parent._tipo2 = "Celebración";
 if (true) break;

case 66:
//C
this.state = 67;
RDebugUtils.currentLine=3801171;
 //BA.debugLineNum = 3801171;BA.debugLine="If tipo2 = \"00B\" Then";
if (true) break;

case 67:
//if
this.state = 76;
if ((parent._tipo2).equals("00B")) { 
this.state = 69;
}else {
this.state = 71;
}if (true) break;

case 69:
//C
this.state = 76;
RDebugUtils.currentLine=3801172;
 //BA.debugLineNum = 3801172;BA.debugLine="tipo2 = \"Cambio\"";
parent._tipo2 = "Cambio";
 if (true) break;

case 71:
//C
this.state = 72;
RDebugUtils.currentLine=3801174;
 //BA.debugLineNum = 3801174;BA.debugLine="If tipo2 = \"00C\" Then";
if (true) break;

case 72:
//if
this.state = 75;
if ((parent._tipo2).equals("00C")) { 
this.state = 74;
}if (true) break;

case 74:
//C
this.state = 75;
RDebugUtils.currentLine=3801175;
 //BA.debugLineNum = 3801175;BA.debugLine="tipo2 = \"Reunión\"";
parent._tipo2 = "Reunión";
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
RDebugUtils.currentLine=3801179;
 //BA.debugLineNum = 3801179;BA.debugLine="Dim n2 As Notification";
_n2 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=3801180;
 //BA.debugLineNum = 3801180;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=3801181;
 //BA.debugLineNum = 3801181;BA.debugLine="n2.Initialize2(n.IMPORTANCE_HIGH)";
_n2.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=3801182;
 //BA.debugLineNum = 3801182;BA.debugLine="n2.Icon =\"icon\"";
_n2.setIcon("icon");
RDebugUtils.currentLine=3801183;
 //BA.debugLineNum = 3801183;BA.debugLine="n2.SetInfo(tipo2,\"Se llevará acabo el \"&fec";
_n2.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo2),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=3801184;
 //BA.debugLineNum = 3801184;BA.debugLine="n2.Notify(2)";
_n2.Notify((int) (2));
RDebugUtils.currentLine=3801185;
 //BA.debugLineNum = 3801185;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801186;
 //BA.debugLineNum = 3801186;BA.debugLine="evento2A.Visible = True";
parent.mostCurrent._evento2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801187;
 //BA.debugLineNum = 3801187;BA.debugLine="titulo2A.Text = titulo";
parent.mostCurrent._titulo2a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=3801188;
 //BA.debugLineNum = 3801188;BA.debugLine="fecha2A.Text = fecha";
parent.mostCurrent._fecha2a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=3801189;
 //BA.debugLineNum = 3801189;BA.debugLine="hora2A.Text = hora";
parent.mostCurrent._hora2a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=3801190;
 //BA.debugLineNum = 3801190;BA.debugLine="desc2 = descripcion";
parent._desc2 = parent._descripcion;
RDebugUtils.currentLine=3801191;
 //BA.debugLineNum = 3801191;BA.debugLine="If tipo2 = \"Celebración\" Then";
if (true) break;

case 78:
//if
this.state = 93;
if ((parent._tipo2).equals("Celebración")) { 
this.state = 80;
}else {
this.state = 82;
}if (true) break;

case 80:
//C
this.state = 93;
RDebugUtils.currentLine=3801192;
 //BA.debugLineNum = 3801192;BA.debugLine="celebracion2A.Visible = True";
parent.mostCurrent._celebracion2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801193;
 //BA.debugLineNum = 3801193;BA.debugLine="cambio2A.Visible = False";
parent.mostCurrent._cambio2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801194;
 //BA.debugLineNum = 3801194;BA.debugLine="reunion2A.Visible = False";
parent.mostCurrent._reunion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 82:
//C
this.state = 83;
RDebugUtils.currentLine=3801196;
 //BA.debugLineNum = 3801196;BA.debugLine="If tipo2 = \"Cambio\" Then";
if (true) break;

case 83:
//if
this.state = 92;
if ((parent._tipo2).equals("Cambio")) { 
this.state = 85;
}else {
this.state = 87;
}if (true) break;

case 85:
//C
this.state = 92;
RDebugUtils.currentLine=3801197;
 //BA.debugLineNum = 3801197;BA.debugLine="celebracion2A.Visible = False";
parent.mostCurrent._celebracion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801198;
 //BA.debugLineNum = 3801198;BA.debugLine="cambio2A.Visible = True";
parent.mostCurrent._cambio2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801199;
 //BA.debugLineNum = 3801199;BA.debugLine="reunion2A.Visible = False";
parent.mostCurrent._reunion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 87:
//C
this.state = 88;
RDebugUtils.currentLine=3801201;
 //BA.debugLineNum = 3801201;BA.debugLine="If tipo2 = \"Reunión\" Then";
if (true) break;

case 88:
//if
this.state = 91;
if ((parent._tipo2).equals("Reunión")) { 
this.state = 90;
}if (true) break;

case 90:
//C
this.state = 91;
RDebugUtils.currentLine=3801202;
 //BA.debugLineNum = 3801202;BA.debugLine="celebracion2A.Visible = False";
parent.mostCurrent._celebracion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801203;
 //BA.debugLineNum = 3801203;BA.debugLine="cambio2A.Visible = False";
parent.mostCurrent._cambio2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801204;
 //BA.debugLineNum = 3801204;BA.debugLine="reunion2A.Visible = True";
parent.mostCurrent._reunion2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=3801209;
 //BA.debugLineNum = 3801209;BA.debugLine="If eventos =3 Then";

case 94:
//if
this.state = 129;
if (parent._eventos==3) { 
this.state = 96;
}if (true) break;

case 96:
//C
this.state = 97;
RDebugUtils.currentLine=3801210;
 //BA.debugLineNum = 3801210;BA.debugLine="tipo3 = tipo";
parent._tipo3 = parent._tipo;
RDebugUtils.currentLine=3801211;
 //BA.debugLineNum = 3801211;BA.debugLine="If tipo3 = \"00A\" Then";
if (true) break;

case 97:
//if
this.state = 112;
if ((parent._tipo3).equals("00A")) { 
this.state = 99;
}else {
this.state = 101;
}if (true) break;

case 99:
//C
this.state = 112;
RDebugUtils.currentLine=3801212;
 //BA.debugLineNum = 3801212;BA.debugLine="tipo3 = \"Celebración\"";
parent._tipo3 = "Celebración";
 if (true) break;

case 101:
//C
this.state = 102;
RDebugUtils.currentLine=3801214;
 //BA.debugLineNum = 3801214;BA.debugLine="If tipo3 = \"00B\" Then";
if (true) break;

case 102:
//if
this.state = 111;
if ((parent._tipo3).equals("00B")) { 
this.state = 104;
}else {
this.state = 106;
}if (true) break;

case 104:
//C
this.state = 111;
RDebugUtils.currentLine=3801215;
 //BA.debugLineNum = 3801215;BA.debugLine="tipo3 = \"Cambio\"";
parent._tipo3 = "Cambio";
 if (true) break;

case 106:
//C
this.state = 107;
RDebugUtils.currentLine=3801217;
 //BA.debugLineNum = 3801217;BA.debugLine="If tipo3 = \"00C\" Then";
if (true) break;

case 107:
//if
this.state = 110;
if ((parent._tipo3).equals("00C")) { 
this.state = 109;
}if (true) break;

case 109:
//C
this.state = 110;
RDebugUtils.currentLine=3801218;
 //BA.debugLineNum = 3801218;BA.debugLine="tipo3 = \"Reunión\"";
parent._tipo3 = "Reunión";
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
RDebugUtils.currentLine=3801222;
 //BA.debugLineNum = 3801222;BA.debugLine="Dim n3 As Notification";
_n3 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=3801223;
 //BA.debugLineNum = 3801223;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=3801224;
 //BA.debugLineNum = 3801224;BA.debugLine="n3.Initialize2(n.IMPORTANCE_HIGH)";
_n3.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=3801225;
 //BA.debugLineNum = 3801225;BA.debugLine="n3.Icon =\"icon\"";
_n3.setIcon("icon");
RDebugUtils.currentLine=3801226;
 //BA.debugLineNum = 3801226;BA.debugLine="n3.SetInfo(tipo3,\"Se llevará acabo el \"&fec";
_n3.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo3),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=3801227;
 //BA.debugLineNum = 3801227;BA.debugLine="n3.Notify(3)";
_n3.Notify((int) (3));
RDebugUtils.currentLine=3801228;
 //BA.debugLineNum = 3801228;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801229;
 //BA.debugLineNum = 3801229;BA.debugLine="evento3A.Visible = True";
parent.mostCurrent._evento3a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801230;
 //BA.debugLineNum = 3801230;BA.debugLine="titulo3A.Text = titulo";
parent.mostCurrent._titulo3a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=3801231;
 //BA.debugLineNum = 3801231;BA.debugLine="fecha3A.Text = fecha";
parent.mostCurrent._fecha3a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=3801232;
 //BA.debugLineNum = 3801232;BA.debugLine="hora3A.Text = hora";
parent.mostCurrent._hora3a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=3801233;
 //BA.debugLineNum = 3801233;BA.debugLine="desc3 = descripcion";
parent._desc3 = parent._descripcion;
RDebugUtils.currentLine=3801234;
 //BA.debugLineNum = 3801234;BA.debugLine="If tipo3 = \"Celebración\" Then";
if (true) break;

case 113:
//if
this.state = 128;
if ((parent._tipo3).equals("Celebración")) { 
this.state = 115;
}else {
this.state = 117;
}if (true) break;

case 115:
//C
this.state = 128;
RDebugUtils.currentLine=3801235;
 //BA.debugLineNum = 3801235;BA.debugLine="celebracion3A.Visible = True";
parent.mostCurrent._celebracion3a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801236;
 //BA.debugLineNum = 3801236;BA.debugLine="cambio3A.Visible = False";
parent.mostCurrent._cambio3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801237;
 //BA.debugLineNum = 3801237;BA.debugLine="reunion3A.Visible = False";
parent.mostCurrent._reunion3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 117:
//C
this.state = 118;
RDebugUtils.currentLine=3801239;
 //BA.debugLineNum = 3801239;BA.debugLine="If tipo3 = \"Cambio\" Then";
if (true) break;

case 118:
//if
this.state = 127;
if ((parent._tipo3).equals("Cambio")) { 
this.state = 120;
}else {
this.state = 122;
}if (true) break;

case 120:
//C
this.state = 127;
RDebugUtils.currentLine=3801240;
 //BA.debugLineNum = 3801240;BA.debugLine="celebracion3A.Visible = False";
parent.mostCurrent._celebracion3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801241;
 //BA.debugLineNum = 3801241;BA.debugLine="cambio3A.Visible = True";
parent.mostCurrent._cambio3a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801242;
 //BA.debugLineNum = 3801242;BA.debugLine="reunion3A.Visible = False";
parent.mostCurrent._reunion3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 122:
//C
this.state = 123;
RDebugUtils.currentLine=3801244;
 //BA.debugLineNum = 3801244;BA.debugLine="If tipo3 = \"Reunión\" Then";
if (true) break;

case 123:
//if
this.state = 126;
if ((parent._tipo3).equals("Reunión")) { 
this.state = 125;
}if (true) break;

case 125:
//C
this.state = 126;
RDebugUtils.currentLine=3801245;
 //BA.debugLineNum = 3801245;BA.debugLine="celebracion3A.Visible = False";
parent.mostCurrent._celebracion3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801246;
 //BA.debugLineNum = 3801246;BA.debugLine="cambio3A.Visible = False";
parent.mostCurrent._cambio3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801247;
 //BA.debugLineNum = 3801247;BA.debugLine="reunion3A.Visible = True";
parent.mostCurrent._reunion3a.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=3801252;
 //BA.debugLineNum = 3801252;BA.debugLine="If eventos =4 Then";

case 129:
//if
this.state = 164;
if (parent._eventos==4) { 
this.state = 131;
}if (true) break;

case 131:
//C
this.state = 132;
RDebugUtils.currentLine=3801253;
 //BA.debugLineNum = 3801253;BA.debugLine="tipo4 = tipo";
parent._tipo4 = parent._tipo;
RDebugUtils.currentLine=3801254;
 //BA.debugLineNum = 3801254;BA.debugLine="If tipo4 = \"00A\" Then";
if (true) break;

case 132:
//if
this.state = 147;
if ((parent._tipo4).equals("00A")) { 
this.state = 134;
}else {
this.state = 136;
}if (true) break;

case 134:
//C
this.state = 147;
RDebugUtils.currentLine=3801255;
 //BA.debugLineNum = 3801255;BA.debugLine="tipo4 = \"Celebración\"";
parent._tipo4 = "Celebración";
 if (true) break;

case 136:
//C
this.state = 137;
RDebugUtils.currentLine=3801257;
 //BA.debugLineNum = 3801257;BA.debugLine="If tipo4 = \"00B\" Then";
if (true) break;

case 137:
//if
this.state = 146;
if ((parent._tipo4).equals("00B")) { 
this.state = 139;
}else {
this.state = 141;
}if (true) break;

case 139:
//C
this.state = 146;
RDebugUtils.currentLine=3801258;
 //BA.debugLineNum = 3801258;BA.debugLine="tipo4 = \"Cambio\"";
parent._tipo4 = "Cambio";
 if (true) break;

case 141:
//C
this.state = 142;
RDebugUtils.currentLine=3801260;
 //BA.debugLineNum = 3801260;BA.debugLine="If tipo4 = \"00C\" Then";
if (true) break;

case 142:
//if
this.state = 145;
if ((parent._tipo4).equals("00C")) { 
this.state = 144;
}if (true) break;

case 144:
//C
this.state = 145;
RDebugUtils.currentLine=3801261;
 //BA.debugLineNum = 3801261;BA.debugLine="tipo4 = \"Reunión\"";
parent._tipo4 = "Reunión";
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
RDebugUtils.currentLine=3801265;
 //BA.debugLineNum = 3801265;BA.debugLine="Dim n4 As Notification";
_n4 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=3801266;
 //BA.debugLineNum = 3801266;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=3801267;
 //BA.debugLineNum = 3801267;BA.debugLine="n4.Initialize2(n.IMPORTANCE_HIGH)";
_n4.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=3801268;
 //BA.debugLineNum = 3801268;BA.debugLine="n4.Icon =\"icon\"";
_n4.setIcon("icon");
RDebugUtils.currentLine=3801269;
 //BA.debugLineNum = 3801269;BA.debugLine="n4.SetInfo(tipo4,\"Se llevará acabo el \"&fec";
_n4.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo4),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=3801270;
 //BA.debugLineNum = 3801270;BA.debugLine="n4.Notify(4)";
_n4.Notify((int) (4));
RDebugUtils.currentLine=3801271;
 //BA.debugLineNum = 3801271;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801272;
 //BA.debugLineNum = 3801272;BA.debugLine="evento4A.Visible = True";
parent.mostCurrent._evento4a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801273;
 //BA.debugLineNum = 3801273;BA.debugLine="titulo4A.Text = titulo";
parent.mostCurrent._titulo4a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=3801274;
 //BA.debugLineNum = 3801274;BA.debugLine="fecha4A.Text = fecha";
parent.mostCurrent._fecha4a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=3801275;
 //BA.debugLineNum = 3801275;BA.debugLine="hora4A.Text = hora";
parent.mostCurrent._hora4a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=3801276;
 //BA.debugLineNum = 3801276;BA.debugLine="desc4 = descripcion";
parent._desc4 = parent._descripcion;
RDebugUtils.currentLine=3801277;
 //BA.debugLineNum = 3801277;BA.debugLine="If tipo4 = \"Celebración\" Then";
if (true) break;

case 148:
//if
this.state = 163;
if ((parent._tipo4).equals("Celebración")) { 
this.state = 150;
}else {
this.state = 152;
}if (true) break;

case 150:
//C
this.state = 163;
RDebugUtils.currentLine=3801278;
 //BA.debugLineNum = 3801278;BA.debugLine="celebracion4A.Visible = True";
parent.mostCurrent._celebracion4a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801279;
 //BA.debugLineNum = 3801279;BA.debugLine="cambio4A.Visible = False";
parent.mostCurrent._cambio4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801280;
 //BA.debugLineNum = 3801280;BA.debugLine="reunion4A.Visible = False";
parent.mostCurrent._reunion4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 152:
//C
this.state = 153;
RDebugUtils.currentLine=3801282;
 //BA.debugLineNum = 3801282;BA.debugLine="If tipo4 = \"Cambio\" Then";
if (true) break;

case 153:
//if
this.state = 162;
if ((parent._tipo4).equals("Cambio")) { 
this.state = 155;
}else {
this.state = 157;
}if (true) break;

case 155:
//C
this.state = 162;
RDebugUtils.currentLine=3801283;
 //BA.debugLineNum = 3801283;BA.debugLine="celebracion4A.Visible = False";
parent.mostCurrent._celebracion4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801284;
 //BA.debugLineNum = 3801284;BA.debugLine="cambio4A.Visible = True";
parent.mostCurrent._cambio4a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3801285;
 //BA.debugLineNum = 3801285;BA.debugLine="reunion4A.Visible = False";
parent.mostCurrent._reunion4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 157:
//C
this.state = 158;
RDebugUtils.currentLine=3801287;
 //BA.debugLineNum = 3801287;BA.debugLine="If tipo4 = \"Reunión\" Then";
if (true) break;

case 158:
//if
this.state = 161;
if ((parent._tipo4).equals("Reunión")) { 
this.state = 160;
}if (true) break;

case 160:
//C
this.state = 161;
RDebugUtils.currentLine=3801288;
 //BA.debugLineNum = 3801288;BA.debugLine="celebracion4A.Visible = False";
parent.mostCurrent._celebracion4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801289;
 //BA.debugLineNum = 3801289;BA.debugLine="cambio4A.Visible = False";
parent.mostCurrent._cambio4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3801290;
 //BA.debugLineNum = 3801290;BA.debugLine="reunion4A.Visible = True";
parent.mostCurrent._reunion4a.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=3801296;
 //BA.debugLineNum = 3801296;BA.debugLine="eventos = eventos  + 1";
parent._eventos = (int) (parent._eventos+1);
 if (true) break;
if (true) break;

case 166:
//C
this.state = 167;
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
RDebugUtils.currentLine=3801300;
 //BA.debugLineNum = 3801300;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("23801300",_js._errormessage /*String*/ ,0);
 if (true) break;

case 170:
//C
this.state = 173;
;
 if (true) break;

case 172:
//C
this.state = 173;
this.catchState = 0;
RDebugUtils.currentLine=3801303;
 //BA.debugLineNum = 3801303;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("23801303",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 173:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=3801305;
 //BA.debugLineNum = 3801305;BA.debugLine="End Sub";
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
public static String  _evento1a_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento1a_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento1a_click", null));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub evento1A_Click";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="evento11A.Visible = True";
mostCurrent._evento11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="titulo11A.Text = titulo1A.Text";
mostCurrent._titulo11a.setText(BA.ObjectToCharSequence(mostCurrent._titulo1a.getText()));
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="fecha11A.Text = fecha1A.Text";
mostCurrent._fecha11a.setText(BA.ObjectToCharSequence(mostCurrent._fecha1a.getText()));
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="hora11A.Text = hora1A.Text";
mostCurrent._hora11a.setText(BA.ObjectToCharSequence(mostCurrent._hora1a.getText()));
RDebugUtils.currentLine=3604487;
 //BA.debugLineNum = 3604487;BA.debugLine="desc11A.Text = desc1";
mostCurrent._desc11a.setText(BA.ObjectToCharSequence(_desc1));
RDebugUtils.currentLine=3604488;
 //BA.debugLineNum = 3604488;BA.debugLine="If tipo1 = \"Celebración\" Then";
if ((_tipo1).equals("Celebración")) { 
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="celebracion11A.Visible = True";
mostCurrent._celebracion11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3604490;
 //BA.debugLineNum = 3604490;BA.debugLine="cambio11A.Visible = False";
mostCurrent._cambio11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604491;
 //BA.debugLineNum = 3604491;BA.debugLine="reunion11A.Visible = False";
mostCurrent._reunion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=3604493;
 //BA.debugLineNum = 3604493;BA.debugLine="If tipo1 = \"Reunión\" Then";
if ((_tipo1).equals("Reunión")) { 
RDebugUtils.currentLine=3604494;
 //BA.debugLineNum = 3604494;BA.debugLine="celebracion11A.Visible = False";
mostCurrent._celebracion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604495;
 //BA.debugLineNum = 3604495;BA.debugLine="cambio11A.Visible = False";
mostCurrent._cambio11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604496;
 //BA.debugLineNum = 3604496;BA.debugLine="reunion11A.Visible = True";
mostCurrent._reunion11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=3604498;
 //BA.debugLineNum = 3604498;BA.debugLine="If tipo1 = \"Cambio\" Then";
if ((_tipo1).equals("Cambio")) { 
RDebugUtils.currentLine=3604499;
 //BA.debugLineNum = 3604499;BA.debugLine="celebracion11A.Visible = False";
mostCurrent._celebracion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604500;
 //BA.debugLineNum = 3604500;BA.debugLine="cambio11A.Visible = True";
mostCurrent._cambio11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3604501;
 //BA.debugLineNum = 3604501;BA.debugLine="reunion11A.Visible = False";
mostCurrent._reunion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=3604505;
 //BA.debugLineNum = 3604505;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=3604507;
 //BA.debugLineNum = 3604507;BA.debugLine="End Sub";
return "";
}
public static String  _evento2a_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento2a_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento2a_click", null));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub evento2A_Click";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="evento22A.Visible = True";
mostCurrent._evento22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="titulo22A.Text = titulo2A.Text";
mostCurrent._titulo22a.setText(BA.ObjectToCharSequence(mostCurrent._titulo2a.getText()));
RDebugUtils.currentLine=3538949;
 //BA.debugLineNum = 3538949;BA.debugLine="fecha22A.Text = fecha2A.Text";
mostCurrent._fecha22a.setText(BA.ObjectToCharSequence(mostCurrent._fecha2a.getText()));
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="hora22A.Text = hora2A.Text";
mostCurrent._hora22a.setText(BA.ObjectToCharSequence(mostCurrent._hora2a.getText()));
RDebugUtils.currentLine=3538951;
 //BA.debugLineNum = 3538951;BA.debugLine="desc22A.Text = desc2";
mostCurrent._desc22a.setText(BA.ObjectToCharSequence(_desc2));
RDebugUtils.currentLine=3538952;
 //BA.debugLineNum = 3538952;BA.debugLine="If tipo2 = \"Celebración\" Then";
if ((_tipo2).equals("Celebración")) { 
RDebugUtils.currentLine=3538953;
 //BA.debugLineNum = 3538953;BA.debugLine="celebracion22A.Visible = True";
mostCurrent._celebracion22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538954;
 //BA.debugLineNum = 3538954;BA.debugLine="cambio22A.Visible = False";
mostCurrent._cambio22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538955;
 //BA.debugLineNum = 3538955;BA.debugLine="reunion22A.Visible = False";
mostCurrent._reunion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=3538957;
 //BA.debugLineNum = 3538957;BA.debugLine="If tipo2 = \"Reunión\" Then";
if ((_tipo2).equals("Reunión")) { 
RDebugUtils.currentLine=3538958;
 //BA.debugLineNum = 3538958;BA.debugLine="celebracion22A.Visible = False";
mostCurrent._celebracion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538959;
 //BA.debugLineNum = 3538959;BA.debugLine="cambio22A.Visible = False";
mostCurrent._cambio22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538960;
 //BA.debugLineNum = 3538960;BA.debugLine="reunion22A.Visible = True";
mostCurrent._reunion22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=3538962;
 //BA.debugLineNum = 3538962;BA.debugLine="If tipo2 = \"Cambio\" Then";
if ((_tipo2).equals("Cambio")) { 
RDebugUtils.currentLine=3538963;
 //BA.debugLineNum = 3538963;BA.debugLine="celebracion22A.Visible = False";
mostCurrent._celebracion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538964;
 //BA.debugLineNum = 3538964;BA.debugLine="cambio22A.Visible = True";
mostCurrent._cambio22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3538965;
 //BA.debugLineNum = 3538965;BA.debugLine="reunion22A.Visible = False";
mostCurrent._reunion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=3538969;
 //BA.debugLineNum = 3538969;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=3538971;
 //BA.debugLineNum = 3538971;BA.debugLine="End Sub";
return "";
}
public static String  _evento3a_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento3a_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento3a_click", null));}
RDebugUtils.currentLine=13565952;
 //BA.debugLineNum = 13565952;BA.debugLine="Sub evento3A_Click";
RDebugUtils.currentLine=13565953;
 //BA.debugLineNum = 13565953;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=13565954;
 //BA.debugLineNum = 13565954;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13565955;
 //BA.debugLineNum = 13565955;BA.debugLine="evento33A.Visible = True";
mostCurrent._evento33a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13565956;
 //BA.debugLineNum = 13565956;BA.debugLine="titulo33A.Text = titulo3A.Text";
mostCurrent._titulo33a.setText(BA.ObjectToCharSequence(mostCurrent._titulo3a.getText()));
RDebugUtils.currentLine=13565957;
 //BA.debugLineNum = 13565957;BA.debugLine="fecha33A.Text = fecha3A.Text";
mostCurrent._fecha33a.setText(BA.ObjectToCharSequence(mostCurrent._fecha3a.getText()));
RDebugUtils.currentLine=13565958;
 //BA.debugLineNum = 13565958;BA.debugLine="hora33A.Text = hora3A.Text";
mostCurrent._hora33a.setText(BA.ObjectToCharSequence(mostCurrent._hora3a.getText()));
RDebugUtils.currentLine=13565959;
 //BA.debugLineNum = 13565959;BA.debugLine="descripcion33A.Text = desc3";
mostCurrent._descripcion33a.setText(BA.ObjectToCharSequence(_desc3));
RDebugUtils.currentLine=13565960;
 //BA.debugLineNum = 13565960;BA.debugLine="If tipo3 = \"Celebración\" Then";
if ((_tipo3).equals("Celebración")) { 
RDebugUtils.currentLine=13565961;
 //BA.debugLineNum = 13565961;BA.debugLine="celebracion33A.Visible = True";
mostCurrent._celebracion33a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13565962;
 //BA.debugLineNum = 13565962;BA.debugLine="cambio33A.Visible = False";
mostCurrent._cambio33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13565963;
 //BA.debugLineNum = 13565963;BA.debugLine="reunion33A.Visible = False";
mostCurrent._reunion33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=13565965;
 //BA.debugLineNum = 13565965;BA.debugLine="If tipo3 = \"Reunión\" Then";
if ((_tipo3).equals("Reunión")) { 
RDebugUtils.currentLine=13565966;
 //BA.debugLineNum = 13565966;BA.debugLine="celebracion33A.Visible = False";
mostCurrent._celebracion33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13565967;
 //BA.debugLineNum = 13565967;BA.debugLine="cambio33A.Visible = False";
mostCurrent._cambio33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13565968;
 //BA.debugLineNum = 13565968;BA.debugLine="reunion33A.Visible = True";
mostCurrent._reunion33a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=13565970;
 //BA.debugLineNum = 13565970;BA.debugLine="If tipo3 = \"Cambio\" Then";
if ((_tipo3).equals("Cambio")) { 
RDebugUtils.currentLine=13565971;
 //BA.debugLineNum = 13565971;BA.debugLine="celebracion33A.Visible = False";
mostCurrent._celebracion33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13565972;
 //BA.debugLineNum = 13565972;BA.debugLine="cambio33A.Visible = True";
mostCurrent._cambio33a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13565973;
 //BA.debugLineNum = 13565973;BA.debugLine="reunion33A.Visible = False";
mostCurrent._reunion33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=13565977;
 //BA.debugLineNum = 13565977;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=13565979;
 //BA.debugLineNum = 13565979;BA.debugLine="End Sub";
return "";
}
public static String  _evento4e_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento4e_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento4e_click", null));}
RDebugUtils.currentLine=13697024;
 //BA.debugLineNum = 13697024;BA.debugLine="Sub evento4E_Click";
RDebugUtils.currentLine=13697025;
 //BA.debugLineNum = 13697025;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=13697026;
 //BA.debugLineNum = 13697026;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13697027;
 //BA.debugLineNum = 13697027;BA.debugLine="evento44A.Visible = True";
mostCurrent._evento44a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13697028;
 //BA.debugLineNum = 13697028;BA.debugLine="titulo44A.Text = titulo4A.Text";
mostCurrent._titulo44a.setText(BA.ObjectToCharSequence(mostCurrent._titulo4a.getText()));
RDebugUtils.currentLine=13697029;
 //BA.debugLineNum = 13697029;BA.debugLine="fecha44A.Text = fecha4A.Text";
mostCurrent._fecha44a.setText(BA.ObjectToCharSequence(mostCurrent._fecha4a.getText()));
RDebugUtils.currentLine=13697030;
 //BA.debugLineNum = 13697030;BA.debugLine="hora44A.Text = hora4A.Text";
mostCurrent._hora44a.setText(BA.ObjectToCharSequence(mostCurrent._hora4a.getText()));
RDebugUtils.currentLine=13697031;
 //BA.debugLineNum = 13697031;BA.debugLine="descripcion44A.Text = desc4";
mostCurrent._descripcion44a.setText(BA.ObjectToCharSequence(_desc4));
RDebugUtils.currentLine=13697032;
 //BA.debugLineNum = 13697032;BA.debugLine="If tipo4 = \"Celebración\" Then";
if ((_tipo4).equals("Celebración")) { 
RDebugUtils.currentLine=13697033;
 //BA.debugLineNum = 13697033;BA.debugLine="celebracion44A.Visible = True";
mostCurrent._celebracion44a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13697034;
 //BA.debugLineNum = 13697034;BA.debugLine="cambio44A.Visible = False";
mostCurrent._cambio44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13697035;
 //BA.debugLineNum = 13697035;BA.debugLine="reunion44A.Visible = False";
mostCurrent._reunion44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=13697037;
 //BA.debugLineNum = 13697037;BA.debugLine="If tipo4 = \"Reunión\" Then";
if ((_tipo4).equals("Reunión")) { 
RDebugUtils.currentLine=13697038;
 //BA.debugLineNum = 13697038;BA.debugLine="celebracion44A.Visible = False";
mostCurrent._celebracion44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13697039;
 //BA.debugLineNum = 13697039;BA.debugLine="cambio44A.Visible = False";
mostCurrent._cambio44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13697040;
 //BA.debugLineNum = 13697040;BA.debugLine="reunion44A.Visible = True";
mostCurrent._reunion44a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=13697042;
 //BA.debugLineNum = 13697042;BA.debugLine="If tipo4 = \"Cambio\" Then";
if ((_tipo4).equals("Cambio")) { 
RDebugUtils.currentLine=13697043;
 //BA.debugLineNum = 13697043;BA.debugLine="celebracion44A.Visible = False";
mostCurrent._celebracion44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13697044;
 //BA.debugLineNum = 13697044;BA.debugLine="cambio44A.Visible = True";
mostCurrent._cambio44a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13697045;
 //BA.debugLineNum = 13697045;BA.debugLine="reunion44A.Visible = False";
mostCurrent._reunion44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=13697049;
 //BA.debugLineNum = 13697049;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=13697051;
 //BA.debugLineNum = 13697051;BA.debugLine="End Sub";
return "";
}
public static String  _inicio_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inicio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "inicio_click", null));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub inicio_Click";
RDebugUtils.currentLine=3211265;
 //BA.debugLineNum = 3211265;BA.debugLine="If event = 1 Then";
if (_event==1) { 
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="evento44A.Visible=False";
mostCurrent._evento44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="evento33A.Visible=False";
mostCurrent._evento33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="evento22A.Visible = False";
mostCurrent._evento22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="evento11A.Visible = False";
mostCurrent._evento11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="event = 0";
_event = (int) (0);
 };
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
anywheresoftware.b4a.keywords.Common.LogImpl("23473410","OK, se actualizó correctamente",0);
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito"),BA.ObjectToCharSequence("AVISO"),processBA);
RDebugUtils.currentLine=3473412;
 //BA.debugLineNum = 3473412;BA.debugLine="txtconact.Text=\"\"";
mostCurrent._txtconact.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3473413;
 //BA.debugLineNum = 3473413;BA.debugLine="txtconnuv.Text=\"\"";
mostCurrent._txtconnuv.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3473414;
 //BA.debugLineNum = 3473414;BA.debugLine="txtconfcon.Text=\"\"";
mostCurrent._txtconfcon.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3473415;
 //BA.debugLineNum = 3473415;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473416;
 //BA.debugLineNum = 3473416;BA.debugLine="inicio.Visible=False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3473417;
 //BA.debugLineNum = 3473417;BA.debugLine="estado=0";
_estado = (int) (0);
 }else {
RDebugUtils.currentLine=3473419;
 //BA.debugLineNum = 3473419;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("23473419",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=3473420;
 //BA.debugLineNum = 3473420;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3473422;
 //BA.debugLineNum = 3473422;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=3473423;
 //BA.debugLineNum = 3473423;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfcon_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfcon_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfcon_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub txtconfcon_TextChanged (Old As String, New As";
RDebugUtils.currentLine=3342337;
 //BA.debugLineNum = 3342337;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="MsgboxAsync(\"Laconfirmación de la contraseña no";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=3342340;
 //BA.debugLineNum = 3342340;BA.debugLine="End Sub";
return "";
}
public static String  _txtconnuv_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconnuv_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconnuv_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub txtconnuv_TextChanged (Old As String, New As S";
RDebugUtils.currentLine=3276801;
 //BA.debugLineNum = 3276801;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=3276804;
 //BA.debugLineNum = 3276804;BA.debugLine="End Sub";
return "";
}
}
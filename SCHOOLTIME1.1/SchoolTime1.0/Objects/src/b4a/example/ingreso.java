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
    public static boolean dontPause;

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
        if (!dontPause)
            BA.LogInfo("** Activity (ingreso) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (ingreso) Pause event (activity is not paused). **");
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
public b4a.example.ingresodocente _ingresodocente = null;
public b4a.example.ingresoestudiante _ingresoestudiante = null;
public b4a.example.inicioacudiente _inicioacudiente = null;
public b4a.example.iniciodocente _iniciodocente = null;
public b4a.example.inicioestudiante _inicioestudiante = null;
public b4a.example.perfiles _perfiles = null;
public b4a.example.registroacudiente _registroacudiente = null;
public b4a.example.registrodocente _registrodocente = null;
public b4a.example.registroestudiante _registroestudiante = null;
public b4a.example.starter _starter = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3211264;
 //BA.debugLineNum = 3211264;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3211266;
 //BA.debugLineNum = 3211266;BA.debugLine="Activity.LoadLayout(\"ingreso\")";
mostCurrent._activity.LoadLayout("ingreso",mostCurrent.activityBA);
RDebugUtils.currentLine=3211267;
 //BA.debugLineNum = 3211267;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"evento\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"EVENTOS","evento");
RDebugUtils.currentLine=3211268;
 //BA.debugLineNum = 3211268;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfil\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"PERFIL","perfil");
RDebugUtils.currentLine=3211269;
 //BA.debugLineNum = 3211269;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211270;
 //BA.debugLineNum = 3211270;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3211271;
 //BA.debugLineNum = 3211271;BA.debugLine="evento1A.Visible=False";
mostCurrent._evento1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211272;
 //BA.debugLineNum = 3211272;BA.debugLine="evento2A.Visible=False";
mostCurrent._evento2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211273;
 //BA.debugLineNum = 3211273;BA.debugLine="evento3A.Visible=False";
mostCurrent._evento3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211274;
 //BA.debugLineNum = 3211274;BA.debugLine="evento4A.Visible=False";
mostCurrent._evento4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211275;
 //BA.debugLineNum = 3211275;BA.debugLine="evento11A.Visible=False";
mostCurrent._evento11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211276;
 //BA.debugLineNum = 3211276;BA.debugLine="evento22A.Visible=False";
mostCurrent._evento22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211277;
 //BA.debugLineNum = 3211277;BA.debugLine="evento33A.Visible= False";
mostCurrent._evento33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211278;
 //BA.debugLineNum = 3211278;BA.debugLine="evento44A.Visible= False";
mostCurrent._evento44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211279;
 //BA.debugLineNum = 3211279;BA.debugLine="Anuncio.Visible=False";
mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3211280;
 //BA.debugLineNum = 3211280;BA.debugLine="eventos = 0";
_eventos = (int) (0);
RDebugUtils.currentLine=3211281;
 //BA.debugLineNum = 3211281;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ingreso";
RDebugUtils.currentLine=3342336;
 //BA.debugLineNum = 3342336;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=3342338;
 //BA.debugLineNum = 3342338;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=3276800;
 //BA.debugLineNum = 3276800;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=3276802;
 //BA.debugLineNum = 3276802;BA.debugLine="End Sub";
return "";
}
public static String  _btncambiaracudiente_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambiaracudiente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambiaracudiente_click", null));}
RDebugUtils.currentLine=3407872;
 //BA.debugLineNum = 3407872;BA.debugLine="Sub btncambiaracudiente_Click";
RDebugUtils.currentLine=3407873;
 //BA.debugLineNum = 3407873;BA.debugLine="If estado = 0 Then";
if (_estado==0) { 
RDebugUtils.currentLine=3407874;
 //BA.debugLineNum = 3407874;BA.debugLine="Panel1.Visible = True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3407875;
 //BA.debugLineNum = 3407875;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3407876;
 //BA.debugLineNum = 3407876;BA.debugLine="estado = 1";
_estado = (int) (1);
 };
RDebugUtils.currentLine=3407878;
 //BA.debugLineNum = 3407878;BA.debugLine="End Sub";
return "";
}
public static String  _btncambio_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambio_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=3801088;
 //BA.debugLineNum = 3801088;BA.debugLine="Sub btncambio_Click";
RDebugUtils.currentLine=3801089;
 //BA.debugLineNum = 3801089;BA.debugLine="If txtconact.Text<>\"\" And txtconnuv.Text<>\"\" And";
if ((mostCurrent._txtconact.getText()).equals("") == false && (mostCurrent._txtconnuv.getText()).equals("") == false && (mostCurrent._txtconfcon.getText()).equals("") == false) { 
RDebugUtils.currentLine=3801090;
 //BA.debugLineNum = 3801090;BA.debugLine="If txtconnuv.Text = txtconfcon.Text Then";
if ((mostCurrent._txtconnuv.getText()).equals(mostCurrent._txtconfcon.getText())) { 
RDebugUtils.currentLine=3801091;
 //BA.debugLineNum = 3801091;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/";
_apiaddress = "http://192.168.1.1/schooltime1.php";
RDebugUtils.currentLine=3801092;
 //BA.debugLineNum = 3801092;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=3801093;
 //BA.debugLineNum = 3801093;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",ingreso.getObject());
RDebugUtils.currentLine=3801094;
 //BA.debugLineNum = 3801094;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tbl_acudiente";
_job._poststring /*String*/ (null,_apiaddress,"UPDATE tbl_acudiente SET contrasena_acu='"+mostCurrent._txtconnuv.getText()+"' WHERE contrasena_acu='"+mostCurrent._txtconact.getText()+"'");
 }else {
RDebugUtils.currentLine=3801096;
 //BA.debugLineNum = 3801096;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Las contraseñas deben coincidir"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
 }else {
RDebugUtils.currentLine=3801099;
 //BA.debugLineNum = 3801099;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=3801101;
 //BA.debugLineNum = 3801101;BA.debugLine="End Sub";
return "";
}
public static String  _btncerraracudiente_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncerraracudiente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncerraracudiente_click", null));}
RDebugUtils.currentLine=3473408;
 //BA.debugLineNum = 3473408;BA.debugLine="Sub btncerraracudiente_Click";
RDebugUtils.currentLine=3473409;
 //BA.debugLineNum = 3473409;BA.debugLine="StartActivity(perfiles)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._perfiles.getObject()));
RDebugUtils.currentLine=3473410;
 //BA.debugLineNum = 3473410;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=3473411;
 //BA.debugLineNum = 3473411;BA.debugLine="End Sub";
return "";
}
public static String  _cerrar_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cerrar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cerrar_click", null));}
RDebugUtils.currentLine=3538944;
 //BA.debugLineNum = 3538944;BA.debugLine="Sub cerrar_Click";
RDebugUtils.currentLine=3538945;
 //BA.debugLineNum = 3538945;BA.debugLine="If estado = 1 Then";
if (_estado==1) { 
RDebugUtils.currentLine=3538946;
 //BA.debugLineNum = 3538946;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538947;
 //BA.debugLineNum = 3538947;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3538948;
 //BA.debugLineNum = 3538948;BA.debugLine="estado = 0";
_estado = (int) (0);
 };
RDebugUtils.currentLine=3538950;
 //BA.debugLineNum = 3538950;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub CreateNotificationChannel(ImportanceLevel As I";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="If p.SdkVersion >= 26 Then";
if (_p.getSdkVersion()>=26) { 
RDebugUtils.currentLine=4259843;
 //BA.debugLineNum = 4259843;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(processBA);
RDebugUtils.currentLine=4259845;
 //BA.debugLineNum = 4259845;BA.debugLine="Dim channelId As String = \"channel_\"& Importance";
_channelid = "channel_"+BA.NumberToString(_importancelevel);
RDebugUtils.currentLine=4259846;
 //BA.debugLineNum = 4259846;BA.debugLine="Dim channel As JavaObject";
_channel = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4259847;
 //BA.debugLineNum = 4259847;BA.debugLine="channel.InitializeNewInstance(\"android.app.Notif";
_channel.InitializeNewInstance("android.app.NotificationChannel",new Object[]{(Object)(_channelid),(Object)(anywheresoftware.b4a.keywords.Common.Application.getLabelName()),(Object)(_importancelevel)});
RDebugUtils.currentLine=4259848;
 //BA.debugLineNum = 4259848;BA.debugLine="channel.RunMethod(\"setShowBadge\",Array(False))";
_channel.RunMethod("setShowBadge",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.False)});
RDebugUtils.currentLine=4259850;
 //BA.debugLineNum = 4259850;BA.debugLine="Dim manager As JavaObject = ctxt.RunMethod(\"getS";
_manager = new anywheresoftware.b4j.object.JavaObject();
_manager = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_ctxt.RunMethod("getSystemService",new Object[]{(Object)("notification")})));
RDebugUtils.currentLine=4259851;
 //BA.debugLineNum = 4259851;BA.debugLine="manager.RunMethod(\"createNotificationChannel\",Ar";
_manager.RunMethod("createNotificationChannel",new Object[]{(Object)(_channel.getObject())});
 };
RDebugUtils.currentLine=4259854;
 //BA.debugLineNum = 4259854;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="If contraseñaA.Text <> \"\" Then";
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
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="Try";
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
RDebugUtils.currentLine=4194307;
 //BA.debugLineNum = 4194307;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/";
_apiaddress = "http://192.168.1.1/schooltime.php";
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=4194309;
 //BA.debugLineNum = 4194309;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingreso.getObject());
RDebugUtils.currentLine=4194310;
 //BA.debugLineNum = 4194310;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","cedula","pin",parent.mostCurrent._contraseñaa.getText(),"tabla","tbl_acudiente","codigo","codigo_g","cedula","id_acudiente"});
RDebugUtils.currentLine=4194311;
 //BA.debugLineNum = 4194311;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingreso", "enviara_click"), (Object)(_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=4194312;
 //BA.debugLineNum = 4194312;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=4194313;
 //BA.debugLineNum = 4194313;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=4194314;
 //BA.debugLineNum = 4194314;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=4194315;
 //BA.debugLineNum = 4194315;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=4194316;
 //BA.debugLineNum = 4194316;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4194317;
 //BA.debugLineNum = 4194317;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=4194318;
 //BA.debugLineNum = 4194318;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=4194319;
 //BA.debugLineNum = 4194319;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4194320;
 //BA.debugLineNum = 4194320;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=4194321;
 //BA.debugLineNum = 4194321;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("04194321",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=4194322;
 //BA.debugLineNum = 4194322;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4194323;
 //BA.debugLineNum = 4194323;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=4194324;
 //BA.debugLineNum = 4194324;BA.debugLine="fila= tabla.Get(i)";
_fila = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=4194325;
 //BA.debugLineNum = 4194325;BA.debugLine="codigo = fila.Get(\"codigo_g\")";
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
RDebugUtils.currentLine=4194329;
 //BA.debugLineNum = 4194329;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("04194329",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=4194332;
 //BA.debugLineNum = 4194332;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("04194332",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
RDebugUtils.currentLine=4194334;
 //BA.debugLineNum = 4194334;BA.debugLine="inicio.Visible =False";
parent.mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4194335;
 //BA.debugLineNum = 4194335;BA.debugLine="Datos.Visible = False";
parent.mostCurrent._datos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 25:
//C
this.state = 26;
RDebugUtils.currentLine=4194337;
 //BA.debugLineNum = 4194337;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Necesitas este campo para el ingreso"),BA.ObjectToCharSequence("AVISO"),processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
RDebugUtils.currentLine=4194339;
 //BA.debugLineNum = 4194339;BA.debugLine="remoreA";
_remorea();
RDebugUtils.currentLine=4194340;
 //BA.debugLineNum = 4194340;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="If eventos = 0 Then";
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
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="Anuncio.Visible = True";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
;
RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="Try";

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
RDebugUtils.currentLine=4325383;
 //BA.debugLineNum = 4325383;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/s";
_apiaddress = "http://192.168.1.1/schooltime.php";
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=4325385;
 //BA.debugLineNum = 4325385;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingreso.getObject());
RDebugUtils.currentLine=4325386;
 //BA.debugLineNum = 4325386;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","evento","codigo",parent._codigo,"quien","acudiente"});
RDebugUtils.currentLine=4325387;
 //BA.debugLineNum = 4325387;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingreso", "remorea"), (Object)(_js));
this.state = 174;
return;
case 174:
//C
this.state = 9;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=4325388;
 //BA.debugLineNum = 4325388;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=4325390;
 //BA.debugLineNum = 4325390;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=4325391;
 //BA.debugLineNum = 4325391;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=4325392;
 //BA.debugLineNum = 4325392;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4325393;
 //BA.debugLineNum = 4325393;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=4325394;
 //BA.debugLineNum = 4325394;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=4325395;
 //BA.debugLineNum = 4325395;BA.debugLine="eventos = 1";
parent._eventos = (int) (1);
RDebugUtils.currentLine=4325396;
 //BA.debugLineNum = 4325396;BA.debugLine="If eventos = 1 Then";
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
RDebugUtils.currentLine=4325397;
 //BA.debugLineNum = 4325397;BA.debugLine="evento1A.Visible = True";
parent.mostCurrent._evento1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 18:
//C
this.state = 19;
;
RDebugUtils.currentLine=4325399;
 //BA.debugLineNum = 4325399;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4325400;
 //BA.debugLineNum = 4325400;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=4325401;
 //BA.debugLineNum = 4325401;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("04325401",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=4325402;
 //BA.debugLineNum = 4325402;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4325403;
 //BA.debugLineNum = 4325403;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=4325404;
 //BA.debugLineNum = 4325404;BA.debugLine="fila= tabla.Get(i)";
_fila = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=4325405;
 //BA.debugLineNum = 4325405;BA.debugLine="titulo = fila.Get(\"titulo_e\")";
parent._titulo = BA.ObjectToString(_fila.Get((Object)("titulo_e")));
RDebugUtils.currentLine=4325406;
 //BA.debugLineNum = 4325406;BA.debugLine="descripcion = fila.Get(\"descripcion_e\")";
parent._descripcion = BA.ObjectToString(_fila.Get((Object)("descripcion_e")));
RDebugUtils.currentLine=4325407;
 //BA.debugLineNum = 4325407;BA.debugLine="c= fila.Get(\"codigo_g\")";
parent._c = BA.ObjectToString(_fila.Get((Object)("codigo_g")));
RDebugUtils.currentLine=4325408;
 //BA.debugLineNum = 4325408;BA.debugLine="fecha = fila.Get(\"fecha_evento\")";
parent._fecha = BA.ObjectToString(_fila.Get((Object)("fecha_evento")));
RDebugUtils.currentLine=4325409;
 //BA.debugLineNum = 4325409;BA.debugLine="hora = fila.Get(\"hora_evento\")";
parent._hora = BA.ObjectToString(_fila.Get((Object)("hora_evento")));
RDebugUtils.currentLine=4325410;
 //BA.debugLineNum = 4325410;BA.debugLine="tipo = fila.Get(\"id_tipo\")";
parent._tipo = BA.ObjectToString(_fila.Get((Object)("id_tipo")));
RDebugUtils.currentLine=4325411;
 //BA.debugLineNum = 4325411;BA.debugLine="If eventos =1 Then";
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
RDebugUtils.currentLine=4325412;
 //BA.debugLineNum = 4325412;BA.debugLine="tipo1 = tipo";
parent._tipo1 = parent._tipo;
RDebugUtils.currentLine=4325413;
 //BA.debugLineNum = 4325413;BA.debugLine="If tipo1 = \"00A\" Then";
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
RDebugUtils.currentLine=4325414;
 //BA.debugLineNum = 4325414;BA.debugLine="tipo1 = \"Celebración\"";
parent._tipo1 = "Celebración";
 if (true) break;

case 29:
//C
this.state = 30;
RDebugUtils.currentLine=4325416;
 //BA.debugLineNum = 4325416;BA.debugLine="If tipo1 = \"00B\" Then";
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
RDebugUtils.currentLine=4325417;
 //BA.debugLineNum = 4325417;BA.debugLine="tipo1 = \"Cambio\"";
parent._tipo1 = "Cambio";
 if (true) break;

case 34:
//C
this.state = 35;
RDebugUtils.currentLine=4325419;
 //BA.debugLineNum = 4325419;BA.debugLine="If tipo1 = \"00C\" Then";
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
RDebugUtils.currentLine=4325420;
 //BA.debugLineNum = 4325420;BA.debugLine="tipo1 = \"Reunión\"";
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
RDebugUtils.currentLine=4325424;
 //BA.debugLineNum = 4325424;BA.debugLine="Dim n As Notification";
_n = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=4325425;
 //BA.debugLineNum = 4325425;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH)";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4325426;
 //BA.debugLineNum = 4325426;BA.debugLine="n.Initialize2(n.IMPORTANCE_HIGH)";
_n.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4325427;
 //BA.debugLineNum = 4325427;BA.debugLine="n.Icon =\"icon\"";
_n.setIcon("icon");
RDebugUtils.currentLine=4325428;
 //BA.debugLineNum = 4325428;BA.debugLine="n.SetInfo(tipo1,\"Se llevará acabo el \"&fecha";
_n.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo1),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=4325429;
 //BA.debugLineNum = 4325429;BA.debugLine="n.Notify(1)";
_n.Notify((int) (1));
RDebugUtils.currentLine=4325430;
 //BA.debugLineNum = 4325430;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325431;
 //BA.debugLineNum = 4325431;BA.debugLine="evento1A.Visible = True";
parent.mostCurrent._evento1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325432;
 //BA.debugLineNum = 4325432;BA.debugLine="titulo1A.Text = titulo";
parent.mostCurrent._titulo1a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=4325433;
 //BA.debugLineNum = 4325433;BA.debugLine="fecha1A.Text = fecha";
parent.mostCurrent._fecha1a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=4325434;
 //BA.debugLineNum = 4325434;BA.debugLine="hora1A.Text = hora";
parent.mostCurrent._hora1a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=4325435;
 //BA.debugLineNum = 4325435;BA.debugLine="desc1 = descripcion";
parent._desc1 = parent._descripcion;
RDebugUtils.currentLine=4325436;
 //BA.debugLineNum = 4325436;BA.debugLine="If tipo1 = \"Celebración\" Then";
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
RDebugUtils.currentLine=4325437;
 //BA.debugLineNum = 4325437;BA.debugLine="celebracion1A.Visible = True";
parent.mostCurrent._celebracion1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325438;
 //BA.debugLineNum = 4325438;BA.debugLine="cambio1A.Visible = False";
parent.mostCurrent._cambio1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325439;
 //BA.debugLineNum = 4325439;BA.debugLine="reunion1A.Visible = False";
parent.mostCurrent._reunion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 45:
//C
this.state = 46;
RDebugUtils.currentLine=4325441;
 //BA.debugLineNum = 4325441;BA.debugLine="If tipo1 = \"Cambio\" Then";
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
RDebugUtils.currentLine=4325442;
 //BA.debugLineNum = 4325442;BA.debugLine="celebracion1A.Visible = False";
parent.mostCurrent._celebracion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325443;
 //BA.debugLineNum = 4325443;BA.debugLine="cambio1A.Visible = True";
parent.mostCurrent._cambio1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325444;
 //BA.debugLineNum = 4325444;BA.debugLine="reunion1A.Visible = False";
parent.mostCurrent._reunion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 50:
//C
this.state = 51;
RDebugUtils.currentLine=4325446;
 //BA.debugLineNum = 4325446;BA.debugLine="If tipo1 = \"Reunión\" Then";
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
RDebugUtils.currentLine=4325447;
 //BA.debugLineNum = 4325447;BA.debugLine="celebracion1A.Visible = False";
parent.mostCurrent._celebracion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325448;
 //BA.debugLineNum = 4325448;BA.debugLine="cambio1A.Visible = False";
parent.mostCurrent._cambio1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325449;
 //BA.debugLineNum = 4325449;BA.debugLine="reunion1A.Visible = True";
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
RDebugUtils.currentLine=4325454;
 //BA.debugLineNum = 4325454;BA.debugLine="If eventos =2 Then";
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
RDebugUtils.currentLine=4325455;
 //BA.debugLineNum = 4325455;BA.debugLine="tipo2 = tipo";
parent._tipo2 = parent._tipo;
RDebugUtils.currentLine=4325456;
 //BA.debugLineNum = 4325456;BA.debugLine="If tipo2 = \"00A\" Then";
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
RDebugUtils.currentLine=4325457;
 //BA.debugLineNum = 4325457;BA.debugLine="tipo2 = \"Celebración\"";
parent._tipo2 = "Celebración";
 if (true) break;

case 66:
//C
this.state = 67;
RDebugUtils.currentLine=4325459;
 //BA.debugLineNum = 4325459;BA.debugLine="If tipo2 = \"00B\" Then";
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
RDebugUtils.currentLine=4325460;
 //BA.debugLineNum = 4325460;BA.debugLine="tipo2 = \"Cambio\"";
parent._tipo2 = "Cambio";
 if (true) break;

case 71:
//C
this.state = 72;
RDebugUtils.currentLine=4325462;
 //BA.debugLineNum = 4325462;BA.debugLine="If tipo2 = \"00C\" Then";
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
RDebugUtils.currentLine=4325463;
 //BA.debugLineNum = 4325463;BA.debugLine="tipo2 = \"Reunión\"";
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
RDebugUtils.currentLine=4325467;
 //BA.debugLineNum = 4325467;BA.debugLine="Dim n2 As Notification";
_n2 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=4325468;
 //BA.debugLineNum = 4325468;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4325469;
 //BA.debugLineNum = 4325469;BA.debugLine="n2.Initialize2(n.IMPORTANCE_HIGH)";
_n2.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4325470;
 //BA.debugLineNum = 4325470;BA.debugLine="n2.Icon =\"icon\"";
_n2.setIcon("icon");
RDebugUtils.currentLine=4325471;
 //BA.debugLineNum = 4325471;BA.debugLine="n2.SetInfo(tipo2,\"Se llevará acabo el \"&fec";
_n2.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo2),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=4325472;
 //BA.debugLineNum = 4325472;BA.debugLine="n2.Notify(2)";
_n2.Notify((int) (2));
RDebugUtils.currentLine=4325473;
 //BA.debugLineNum = 4325473;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325474;
 //BA.debugLineNum = 4325474;BA.debugLine="evento2A.Visible = True";
parent.mostCurrent._evento2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325475;
 //BA.debugLineNum = 4325475;BA.debugLine="titulo2A.Text = titulo";
parent.mostCurrent._titulo2a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=4325476;
 //BA.debugLineNum = 4325476;BA.debugLine="fecha2A.Text = fecha";
parent.mostCurrent._fecha2a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=4325477;
 //BA.debugLineNum = 4325477;BA.debugLine="hora2A.Text = hora";
parent.mostCurrent._hora2a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=4325478;
 //BA.debugLineNum = 4325478;BA.debugLine="desc2 = descripcion";
parent._desc2 = parent._descripcion;
RDebugUtils.currentLine=4325479;
 //BA.debugLineNum = 4325479;BA.debugLine="If tipo2 = \"Celebración\" Then";
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
RDebugUtils.currentLine=4325480;
 //BA.debugLineNum = 4325480;BA.debugLine="celebracion2A.Visible = True";
parent.mostCurrent._celebracion2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325481;
 //BA.debugLineNum = 4325481;BA.debugLine="cambio2A.Visible = False";
parent.mostCurrent._cambio2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325482;
 //BA.debugLineNum = 4325482;BA.debugLine="reunion2A.Visible = False";
parent.mostCurrent._reunion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 82:
//C
this.state = 83;
RDebugUtils.currentLine=4325484;
 //BA.debugLineNum = 4325484;BA.debugLine="If tipo2 = \"Cambio\" Then";
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
RDebugUtils.currentLine=4325485;
 //BA.debugLineNum = 4325485;BA.debugLine="celebracion2A.Visible = False";
parent.mostCurrent._celebracion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325486;
 //BA.debugLineNum = 4325486;BA.debugLine="cambio2A.Visible = True";
parent.mostCurrent._cambio2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325487;
 //BA.debugLineNum = 4325487;BA.debugLine="reunion2A.Visible = False";
parent.mostCurrent._reunion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 87:
//C
this.state = 88;
RDebugUtils.currentLine=4325489;
 //BA.debugLineNum = 4325489;BA.debugLine="If tipo2 = \"Reunión\" Then";
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
RDebugUtils.currentLine=4325490;
 //BA.debugLineNum = 4325490;BA.debugLine="celebracion2A.Visible = False";
parent.mostCurrent._celebracion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325491;
 //BA.debugLineNum = 4325491;BA.debugLine="cambio2A.Visible = False";
parent.mostCurrent._cambio2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325492;
 //BA.debugLineNum = 4325492;BA.debugLine="reunion2A.Visible = True";
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
RDebugUtils.currentLine=4325497;
 //BA.debugLineNum = 4325497;BA.debugLine="If eventos =3 Then";

case 94:
//if
this.state = 129;
if (parent._eventos==3) { 
this.state = 96;
}if (true) break;

case 96:
//C
this.state = 97;
RDebugUtils.currentLine=4325498;
 //BA.debugLineNum = 4325498;BA.debugLine="tipo3 = tipo";
parent._tipo3 = parent._tipo;
RDebugUtils.currentLine=4325499;
 //BA.debugLineNum = 4325499;BA.debugLine="If tipo3 = \"00A\" Then";
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
RDebugUtils.currentLine=4325500;
 //BA.debugLineNum = 4325500;BA.debugLine="tipo3 = \"Celebración\"";
parent._tipo3 = "Celebración";
 if (true) break;

case 101:
//C
this.state = 102;
RDebugUtils.currentLine=4325502;
 //BA.debugLineNum = 4325502;BA.debugLine="If tipo3 = \"00B\" Then";
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
RDebugUtils.currentLine=4325503;
 //BA.debugLineNum = 4325503;BA.debugLine="tipo3 = \"Cambio\"";
parent._tipo3 = "Cambio";
 if (true) break;

case 106:
//C
this.state = 107;
RDebugUtils.currentLine=4325505;
 //BA.debugLineNum = 4325505;BA.debugLine="If tipo3 = \"00C\" Then";
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
RDebugUtils.currentLine=4325506;
 //BA.debugLineNum = 4325506;BA.debugLine="tipo3 = \"Reunión\"";
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
RDebugUtils.currentLine=4325510;
 //BA.debugLineNum = 4325510;BA.debugLine="Dim n3 As Notification";
_n3 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=4325511;
 //BA.debugLineNum = 4325511;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4325512;
 //BA.debugLineNum = 4325512;BA.debugLine="n3.Initialize2(n.IMPORTANCE_HIGH)";
_n3.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4325513;
 //BA.debugLineNum = 4325513;BA.debugLine="n3.Icon =\"icon\"";
_n3.setIcon("icon");
RDebugUtils.currentLine=4325514;
 //BA.debugLineNum = 4325514;BA.debugLine="n3.SetInfo(tipo3,\"Se llevará acabo el \"&fec";
_n3.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo3),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=4325515;
 //BA.debugLineNum = 4325515;BA.debugLine="n3.Notify(3)";
_n3.Notify((int) (3));
RDebugUtils.currentLine=4325516;
 //BA.debugLineNum = 4325516;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325517;
 //BA.debugLineNum = 4325517;BA.debugLine="evento3A.Visible = True";
parent.mostCurrent._evento3a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325518;
 //BA.debugLineNum = 4325518;BA.debugLine="titulo3A.Text = titulo";
parent.mostCurrent._titulo3a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=4325519;
 //BA.debugLineNum = 4325519;BA.debugLine="fecha3A.Text = fecha";
parent.mostCurrent._fecha3a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=4325520;
 //BA.debugLineNum = 4325520;BA.debugLine="hora3A.Text = hora";
parent.mostCurrent._hora3a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=4325521;
 //BA.debugLineNum = 4325521;BA.debugLine="desc3 = descripcion";
parent._desc3 = parent._descripcion;
RDebugUtils.currentLine=4325522;
 //BA.debugLineNum = 4325522;BA.debugLine="If tipo3 = \"Celebración\" Then";
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
RDebugUtils.currentLine=4325523;
 //BA.debugLineNum = 4325523;BA.debugLine="celebracion3A.Visible = True";
parent.mostCurrent._celebracion3a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325524;
 //BA.debugLineNum = 4325524;BA.debugLine="cambio3A.Visible = False";
parent.mostCurrent._cambio3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325525;
 //BA.debugLineNum = 4325525;BA.debugLine="reunion3A.Visible = False";
parent.mostCurrent._reunion3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 117:
//C
this.state = 118;
RDebugUtils.currentLine=4325527;
 //BA.debugLineNum = 4325527;BA.debugLine="If tipo3 = \"Cambio\" Then";
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
RDebugUtils.currentLine=4325528;
 //BA.debugLineNum = 4325528;BA.debugLine="celebracion3A.Visible = False";
parent.mostCurrent._celebracion3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325529;
 //BA.debugLineNum = 4325529;BA.debugLine="cambio3A.Visible = True";
parent.mostCurrent._cambio3a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325530;
 //BA.debugLineNum = 4325530;BA.debugLine="reunion3A.Visible = False";
parent.mostCurrent._reunion3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 122:
//C
this.state = 123;
RDebugUtils.currentLine=4325532;
 //BA.debugLineNum = 4325532;BA.debugLine="If tipo3 = \"Reunión\" Then";
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
RDebugUtils.currentLine=4325533;
 //BA.debugLineNum = 4325533;BA.debugLine="celebracion3A.Visible = False";
parent.mostCurrent._celebracion3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325534;
 //BA.debugLineNum = 4325534;BA.debugLine="cambio3A.Visible = False";
parent.mostCurrent._cambio3a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325535;
 //BA.debugLineNum = 4325535;BA.debugLine="reunion3A.Visible = True";
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
RDebugUtils.currentLine=4325540;
 //BA.debugLineNum = 4325540;BA.debugLine="If eventos =4 Then";

case 129:
//if
this.state = 164;
if (parent._eventos==4) { 
this.state = 131;
}if (true) break;

case 131:
//C
this.state = 132;
RDebugUtils.currentLine=4325541;
 //BA.debugLineNum = 4325541;BA.debugLine="tipo4 = tipo";
parent._tipo4 = parent._tipo;
RDebugUtils.currentLine=4325542;
 //BA.debugLineNum = 4325542;BA.debugLine="If tipo4 = \"00A\" Then";
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
RDebugUtils.currentLine=4325543;
 //BA.debugLineNum = 4325543;BA.debugLine="tipo4 = \"Celebración\"";
parent._tipo4 = "Celebración";
 if (true) break;

case 136:
//C
this.state = 137;
RDebugUtils.currentLine=4325545;
 //BA.debugLineNum = 4325545;BA.debugLine="If tipo4 = \"00B\" Then";
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
RDebugUtils.currentLine=4325546;
 //BA.debugLineNum = 4325546;BA.debugLine="tipo4 = \"Cambio\"";
parent._tipo4 = "Cambio";
 if (true) break;

case 141:
//C
this.state = 142;
RDebugUtils.currentLine=4325548;
 //BA.debugLineNum = 4325548;BA.debugLine="If tipo4 = \"00C\" Then";
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
RDebugUtils.currentLine=4325549;
 //BA.debugLineNum = 4325549;BA.debugLine="tipo4 = \"Reunión\"";
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
RDebugUtils.currentLine=4325553;
 //BA.debugLineNum = 4325553;BA.debugLine="Dim n4 As Notification";
_n4 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=4325554;
 //BA.debugLineNum = 4325554;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4325555;
 //BA.debugLineNum = 4325555;BA.debugLine="n4.Initialize2(n.IMPORTANCE_HIGH)";
_n4.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=4325556;
 //BA.debugLineNum = 4325556;BA.debugLine="n4.Icon =\"icon\"";
_n4.setIcon("icon");
RDebugUtils.currentLine=4325557;
 //BA.debugLineNum = 4325557;BA.debugLine="n4.SetInfo(tipo4,\"Se llevará acabo el \"&fec";
_n4.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo4),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=4325558;
 //BA.debugLineNum = 4325558;BA.debugLine="n4.Notify(4)";
_n4.Notify((int) (4));
RDebugUtils.currentLine=4325559;
 //BA.debugLineNum = 4325559;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325560;
 //BA.debugLineNum = 4325560;BA.debugLine="evento4A.Visible = True";
parent.mostCurrent._evento4a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325561;
 //BA.debugLineNum = 4325561;BA.debugLine="titulo4A.Text = titulo";
parent.mostCurrent._titulo4a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=4325562;
 //BA.debugLineNum = 4325562;BA.debugLine="fecha4A.Text = fecha";
parent.mostCurrent._fecha4a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=4325563;
 //BA.debugLineNum = 4325563;BA.debugLine="hora4A.Text = hora";
parent.mostCurrent._hora4a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=4325564;
 //BA.debugLineNum = 4325564;BA.debugLine="desc4 = descripcion";
parent._desc4 = parent._descripcion;
RDebugUtils.currentLine=4325565;
 //BA.debugLineNum = 4325565;BA.debugLine="If tipo4 = \"Celebración\" Then";
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
RDebugUtils.currentLine=4325566;
 //BA.debugLineNum = 4325566;BA.debugLine="celebracion4A.Visible = True";
parent.mostCurrent._celebracion4a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325567;
 //BA.debugLineNum = 4325567;BA.debugLine="cambio4A.Visible = False";
parent.mostCurrent._cambio4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325568;
 //BA.debugLineNum = 4325568;BA.debugLine="reunion4A.Visible = False";
parent.mostCurrent._reunion4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 152:
//C
this.state = 153;
RDebugUtils.currentLine=4325570;
 //BA.debugLineNum = 4325570;BA.debugLine="If tipo4 = \"Cambio\" Then";
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
RDebugUtils.currentLine=4325571;
 //BA.debugLineNum = 4325571;BA.debugLine="celebracion4A.Visible = False";
parent.mostCurrent._celebracion4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325572;
 //BA.debugLineNum = 4325572;BA.debugLine="cambio4A.Visible = True";
parent.mostCurrent._cambio4a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4325573;
 //BA.debugLineNum = 4325573;BA.debugLine="reunion4A.Visible = False";
parent.mostCurrent._reunion4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 157:
//C
this.state = 158;
RDebugUtils.currentLine=4325575;
 //BA.debugLineNum = 4325575;BA.debugLine="If tipo4 = \"Reunión\" Then";
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
RDebugUtils.currentLine=4325576;
 //BA.debugLineNum = 4325576;BA.debugLine="celebracion4A.Visible = False";
parent.mostCurrent._celebracion4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325577;
 //BA.debugLineNum = 4325577;BA.debugLine="cambio4A.Visible = False";
parent.mostCurrent._cambio4a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4325578;
 //BA.debugLineNum = 4325578;BA.debugLine="reunion4A.Visible = True";
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
RDebugUtils.currentLine=4325584;
 //BA.debugLineNum = 4325584;BA.debugLine="eventos = eventos  + 1";
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
RDebugUtils.currentLine=4325588;
 //BA.debugLineNum = 4325588;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("04325588",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=4325591;
 //BA.debugLineNum = 4325591;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("04325591",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 173:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=4325593;
 //BA.debugLineNum = 4325593;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub evento1A_Click";
RDebugUtils.currentLine=3997697;
 //BA.debugLineNum = 3997697;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="evento11A.Visible = True";
mostCurrent._evento11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="titulo11A.Text = titulo1A.Text";
mostCurrent._titulo11a.setText(BA.ObjectToCharSequence(mostCurrent._titulo1a.getText()));
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="fecha11A.Text = fecha1A.Text";
mostCurrent._fecha11a.setText(BA.ObjectToCharSequence(mostCurrent._fecha1a.getText()));
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="hora11A.Text = hora1A.Text";
mostCurrent._hora11a.setText(BA.ObjectToCharSequence(mostCurrent._hora1a.getText()));
RDebugUtils.currentLine=3997703;
 //BA.debugLineNum = 3997703;BA.debugLine="desc11A.Text = desc1";
mostCurrent._desc11a.setText(BA.ObjectToCharSequence(_desc1));
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="If tipo1 = \"Celebración\" Then";
if ((_tipo1).equals("Celebración")) { 
RDebugUtils.currentLine=3997705;
 //BA.debugLineNum = 3997705;BA.debugLine="celebracion11A.Visible = True";
mostCurrent._celebracion11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3997706;
 //BA.debugLineNum = 3997706;BA.debugLine="cambio11A.Visible = False";
mostCurrent._cambio11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="reunion11A.Visible = False";
mostCurrent._reunion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=3997709;
 //BA.debugLineNum = 3997709;BA.debugLine="If tipo1 = \"Reunión\" Then";
if ((_tipo1).equals("Reunión")) { 
RDebugUtils.currentLine=3997710;
 //BA.debugLineNum = 3997710;BA.debugLine="celebracion11A.Visible = False";
mostCurrent._celebracion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997711;
 //BA.debugLineNum = 3997711;BA.debugLine="cambio11A.Visible = False";
mostCurrent._cambio11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997712;
 //BA.debugLineNum = 3997712;BA.debugLine="reunion11A.Visible = True";
mostCurrent._reunion11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=3997714;
 //BA.debugLineNum = 3997714;BA.debugLine="If tipo1 = \"Cambio\" Then";
if ((_tipo1).equals("Cambio")) { 
RDebugUtils.currentLine=3997715;
 //BA.debugLineNum = 3997715;BA.debugLine="celebracion11A.Visible = False";
mostCurrent._celebracion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997716;
 //BA.debugLineNum = 3997716;BA.debugLine="cambio11A.Visible = True";
mostCurrent._cambio11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3997717;
 //BA.debugLineNum = 3997717;BA.debugLine="reunion11A.Visible = False";
mostCurrent._reunion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=3997721;
 //BA.debugLineNum = 3997721;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=3997723;
 //BA.debugLineNum = 3997723;BA.debugLine="End Sub";
return "";
}
public static String  _evento2a_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento2a_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento2a_click", null));}
RDebugUtils.currentLine=3932160;
 //BA.debugLineNum = 3932160;BA.debugLine="Sub evento2A_Click";
RDebugUtils.currentLine=3932161;
 //BA.debugLineNum = 3932161;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=3932162;
 //BA.debugLineNum = 3932162;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3932163;
 //BA.debugLineNum = 3932163;BA.debugLine="evento22A.Visible = True";
mostCurrent._evento22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3932164;
 //BA.debugLineNum = 3932164;BA.debugLine="titulo22A.Text = titulo2A.Text";
mostCurrent._titulo22a.setText(BA.ObjectToCharSequence(mostCurrent._titulo2a.getText()));
RDebugUtils.currentLine=3932165;
 //BA.debugLineNum = 3932165;BA.debugLine="fecha22A.Text = fecha2A.Text";
mostCurrent._fecha22a.setText(BA.ObjectToCharSequence(mostCurrent._fecha2a.getText()));
RDebugUtils.currentLine=3932166;
 //BA.debugLineNum = 3932166;BA.debugLine="hora22A.Text = hora2A.Text";
mostCurrent._hora22a.setText(BA.ObjectToCharSequence(mostCurrent._hora2a.getText()));
RDebugUtils.currentLine=3932167;
 //BA.debugLineNum = 3932167;BA.debugLine="desc22A.Text = desc2";
mostCurrent._desc22a.setText(BA.ObjectToCharSequence(_desc2));
RDebugUtils.currentLine=3932168;
 //BA.debugLineNum = 3932168;BA.debugLine="If tipo2 = \"Celebración\" Then";
if ((_tipo2).equals("Celebración")) { 
RDebugUtils.currentLine=3932169;
 //BA.debugLineNum = 3932169;BA.debugLine="celebracion22A.Visible = True";
mostCurrent._celebracion22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3932170;
 //BA.debugLineNum = 3932170;BA.debugLine="cambio22A.Visible = False";
mostCurrent._cambio22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3932171;
 //BA.debugLineNum = 3932171;BA.debugLine="reunion22A.Visible = False";
mostCurrent._reunion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=3932173;
 //BA.debugLineNum = 3932173;BA.debugLine="If tipo2 = \"Reunión\" Then";
if ((_tipo2).equals("Reunión")) { 
RDebugUtils.currentLine=3932174;
 //BA.debugLineNum = 3932174;BA.debugLine="celebracion22A.Visible = False";
mostCurrent._celebracion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3932175;
 //BA.debugLineNum = 3932175;BA.debugLine="cambio22A.Visible = False";
mostCurrent._cambio22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3932176;
 //BA.debugLineNum = 3932176;BA.debugLine="reunion22A.Visible = True";
mostCurrent._reunion22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=3932178;
 //BA.debugLineNum = 3932178;BA.debugLine="If tipo2 = \"Cambio\" Then";
if ((_tipo2).equals("Cambio")) { 
RDebugUtils.currentLine=3932179;
 //BA.debugLineNum = 3932179;BA.debugLine="celebracion22A.Visible = False";
mostCurrent._celebracion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3932180;
 //BA.debugLineNum = 3932180;BA.debugLine="cambio22A.Visible = True";
mostCurrent._cambio22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3932181;
 //BA.debugLineNum = 3932181;BA.debugLine="reunion22A.Visible = False";
mostCurrent._reunion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=3932185;
 //BA.debugLineNum = 3932185;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=3932187;
 //BA.debugLineNum = 3932187;BA.debugLine="End Sub";
return "";
}
public static String  _evento3a_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento3a_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento3a_click", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub evento3A_Click";
RDebugUtils.currentLine=4063233;
 //BA.debugLineNum = 4063233;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063235;
 //BA.debugLineNum = 4063235;BA.debugLine="evento33A.Visible = True";
mostCurrent._evento33a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063236;
 //BA.debugLineNum = 4063236;BA.debugLine="titulo33A.Text = titulo3A.Text";
mostCurrent._titulo33a.setText(BA.ObjectToCharSequence(mostCurrent._titulo3a.getText()));
RDebugUtils.currentLine=4063237;
 //BA.debugLineNum = 4063237;BA.debugLine="fecha33A.Text = fecha3A.Text";
mostCurrent._fecha33a.setText(BA.ObjectToCharSequence(mostCurrent._fecha3a.getText()));
RDebugUtils.currentLine=4063238;
 //BA.debugLineNum = 4063238;BA.debugLine="hora33A.Text = hora3A.Text";
mostCurrent._hora33a.setText(BA.ObjectToCharSequence(mostCurrent._hora3a.getText()));
RDebugUtils.currentLine=4063239;
 //BA.debugLineNum = 4063239;BA.debugLine="descripcion33A.Text = desc3";
mostCurrent._descripcion33a.setText(BA.ObjectToCharSequence(_desc3));
RDebugUtils.currentLine=4063240;
 //BA.debugLineNum = 4063240;BA.debugLine="If tipo3 = \"Celebración\" Then";
if ((_tipo3).equals("Celebración")) { 
RDebugUtils.currentLine=4063241;
 //BA.debugLineNum = 4063241;BA.debugLine="celebracion33A.Visible = True";
mostCurrent._celebracion33a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063242;
 //BA.debugLineNum = 4063242;BA.debugLine="cambio33A.Visible = False";
mostCurrent._cambio33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4063243;
 //BA.debugLineNum = 4063243;BA.debugLine="reunion33A.Visible = False";
mostCurrent._reunion33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4063245;
 //BA.debugLineNum = 4063245;BA.debugLine="If tipo3 = \"Reunión\" Then";
if ((_tipo3).equals("Reunión")) { 
RDebugUtils.currentLine=4063246;
 //BA.debugLineNum = 4063246;BA.debugLine="celebracion33A.Visible = False";
mostCurrent._celebracion33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4063247;
 //BA.debugLineNum = 4063247;BA.debugLine="cambio33A.Visible = False";
mostCurrent._cambio33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4063248;
 //BA.debugLineNum = 4063248;BA.debugLine="reunion33A.Visible = True";
mostCurrent._reunion33a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4063250;
 //BA.debugLineNum = 4063250;BA.debugLine="If tipo3 = \"Cambio\" Then";
if ((_tipo3).equals("Cambio")) { 
RDebugUtils.currentLine=4063251;
 //BA.debugLineNum = 4063251;BA.debugLine="celebracion33A.Visible = False";
mostCurrent._celebracion33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4063252;
 //BA.debugLineNum = 4063252;BA.debugLine="cambio33A.Visible = True";
mostCurrent._cambio33a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4063253;
 //BA.debugLineNum = 4063253;BA.debugLine="reunion33A.Visible = False";
mostCurrent._reunion33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=4063257;
 //BA.debugLineNum = 4063257;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=4063259;
 //BA.debugLineNum = 4063259;BA.debugLine="End Sub";
return "";
}
public static String  _evento4e_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento4e_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento4e_click", null));}
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub evento4E_Click";
RDebugUtils.currentLine=4128769;
 //BA.debugLineNum = 4128769;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128771;
 //BA.debugLineNum = 4128771;BA.debugLine="evento44A.Visible = True";
mostCurrent._evento44a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128772;
 //BA.debugLineNum = 4128772;BA.debugLine="titulo44A.Text = titulo4A.Text";
mostCurrent._titulo44a.setText(BA.ObjectToCharSequence(mostCurrent._titulo4a.getText()));
RDebugUtils.currentLine=4128773;
 //BA.debugLineNum = 4128773;BA.debugLine="fecha44A.Text = fecha4A.Text";
mostCurrent._fecha44a.setText(BA.ObjectToCharSequence(mostCurrent._fecha4a.getText()));
RDebugUtils.currentLine=4128774;
 //BA.debugLineNum = 4128774;BA.debugLine="hora44A.Text = hora4A.Text";
mostCurrent._hora44a.setText(BA.ObjectToCharSequence(mostCurrent._hora4a.getText()));
RDebugUtils.currentLine=4128775;
 //BA.debugLineNum = 4128775;BA.debugLine="descripcion44A.Text = desc4";
mostCurrent._descripcion44a.setText(BA.ObjectToCharSequence(_desc4));
RDebugUtils.currentLine=4128776;
 //BA.debugLineNum = 4128776;BA.debugLine="If tipo4 = \"Celebración\" Then";
if ((_tipo4).equals("Celebración")) { 
RDebugUtils.currentLine=4128777;
 //BA.debugLineNum = 4128777;BA.debugLine="celebracion44A.Visible = True";
mostCurrent._celebracion44a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128778;
 //BA.debugLineNum = 4128778;BA.debugLine="cambio44A.Visible = False";
mostCurrent._cambio44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128779;
 //BA.debugLineNum = 4128779;BA.debugLine="reunion44A.Visible = False";
mostCurrent._reunion44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4128781;
 //BA.debugLineNum = 4128781;BA.debugLine="If tipo4 = \"Reunión\" Then";
if ((_tipo4).equals("Reunión")) { 
RDebugUtils.currentLine=4128782;
 //BA.debugLineNum = 4128782;BA.debugLine="celebracion44A.Visible = False";
mostCurrent._celebracion44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128783;
 //BA.debugLineNum = 4128783;BA.debugLine="cambio44A.Visible = False";
mostCurrent._cambio44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128784;
 //BA.debugLineNum = 4128784;BA.debugLine="reunion44A.Visible = True";
mostCurrent._reunion44a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4128786;
 //BA.debugLineNum = 4128786;BA.debugLine="If tipo4 = \"Cambio\" Then";
if ((_tipo4).equals("Cambio")) { 
RDebugUtils.currentLine=4128787;
 //BA.debugLineNum = 4128787;BA.debugLine="celebracion44A.Visible = False";
mostCurrent._celebracion44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4128788;
 //BA.debugLineNum = 4128788;BA.debugLine="cambio44A.Visible = True";
mostCurrent._cambio44a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4128789;
 //BA.debugLineNum = 4128789;BA.debugLine="reunion44A.Visible = False";
mostCurrent._reunion44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
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
public static String  _inicio_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inicio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "inicio_click", null));}
RDebugUtils.currentLine=3604480;
 //BA.debugLineNum = 3604480;BA.debugLine="Sub inicio_Click";
RDebugUtils.currentLine=3604481;
 //BA.debugLineNum = 3604481;BA.debugLine="If event = 1 Then";
if (_event==1) { 
RDebugUtils.currentLine=3604482;
 //BA.debugLineNum = 3604482;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604483;
 //BA.debugLineNum = 3604483;BA.debugLine="evento44A.Visible=False";
mostCurrent._evento44a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604484;
 //BA.debugLineNum = 3604484;BA.debugLine="evento33A.Visible=False";
mostCurrent._evento33a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604485;
 //BA.debugLineNum = 3604485;BA.debugLine="evento22A.Visible = False";
mostCurrent._evento22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604486;
 //BA.debugLineNum = 3604486;BA.debugLine="evento11A.Visible = False";
mostCurrent._evento11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3604487;
 //BA.debugLineNum = 3604487;BA.debugLine="event = 0";
_event = (int) (0);
 };
RDebugUtils.currentLine=3604489;
 //BA.debugLineNum = 3604489;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=3866624;
 //BA.debugLineNum = 3866624;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=3866625;
 //BA.debugLineNum = 3866625;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=3866626;
 //BA.debugLineNum = 3866626;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
anywheresoftware.b4a.keywords.Common.LogImpl("03866626","OK, se actualizó correctamente",0);
RDebugUtils.currentLine=3866627;
 //BA.debugLineNum = 3866627;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito"),BA.ObjectToCharSequence("AVISO"),processBA);
RDebugUtils.currentLine=3866628;
 //BA.debugLineNum = 3866628;BA.debugLine="txtconact.Text=\"\"";
mostCurrent._txtconact.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3866629;
 //BA.debugLineNum = 3866629;BA.debugLine="txtconnuv.Text=\"\"";
mostCurrent._txtconnuv.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3866630;
 //BA.debugLineNum = 3866630;BA.debugLine="txtconfcon.Text=\"\"";
mostCurrent._txtconfcon.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=3866631;
 //BA.debugLineNum = 3866631;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866632;
 //BA.debugLineNum = 3866632;BA.debugLine="inicio.Visible=False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3866633;
 //BA.debugLineNum = 3866633;BA.debugLine="estado=0";
_estado = (int) (0);
 }else {
RDebugUtils.currentLine=3866635;
 //BA.debugLineNum = 3866635;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("03866635",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=3866636;
 //BA.debugLineNum = 3866636;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=3866638;
 //BA.debugLineNum = 3866638;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=3866639;
 //BA.debugLineNum = 3866639;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfcon_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfcon_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfcon_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=3735552;
 //BA.debugLineNum = 3735552;BA.debugLine="Sub txtconfcon_TextChanged (Old As String, New As";
RDebugUtils.currentLine=3735553;
 //BA.debugLineNum = 3735553;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=3735554;
 //BA.debugLineNum = 3735554;BA.debugLine="MsgboxAsync(\"Laconfirmación de la contraseña no";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=3735556;
 //BA.debugLineNum = 3735556;BA.debugLine="End Sub";
return "";
}
public static String  _txtconnuv_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconnuv_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconnuv_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=3670016;
 //BA.debugLineNum = 3670016;BA.debugLine="Sub txtconnuv_TextChanged (Old As String, New As S";
RDebugUtils.currentLine=3670017;
 //BA.debugLineNum = 3670017;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=3670018;
 //BA.debugLineNum = 3670018;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=3670020;
 //BA.debugLineNum = 3670020;BA.debugLine="End Sub";
return "";
}
}
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
    public static boolean dontPause;

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
        if (!dontPause)
            BA.LogInfo("** Activity (ingresodocente) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
        else
            BA.LogInfo("** Activity (ingresodocente) Pause event (activity is not paused). **");
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
public static String _tipo3 = "";
public static String _tipo4 = "";
public static String _codigo = "";
public static String _c = "";
public static String _tipo2 = "";
public static int _eventos = 0;
public static int _estado = 0;
public static String _desc3 = "";
public static String _desc4 = "";
public anywheresoftware.b4a.objects.TabHostWrapper _tabhost1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncambiardocente = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncerrardocente = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
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
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion3 = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion3 = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo3 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio33 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion33 = null;
public anywheresoftware.b4a.objects.LabelWrapper _descripcion33 = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento33 = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha33 = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora33 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion33 = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo33 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion4 = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion4 = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo4 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion44 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio44 = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion44 = null;
public anywheresoftware.b4a.objects.LabelWrapper _descripcion44 = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha44 = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora44 = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo44 = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento44 = null;
public b4a.example.main _main = null;
public b4a.example.ingreso _ingreso = null;
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
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="Activity.LoadLayout(\"ingresoDocente\")";
mostCurrent._activity.LoadLayout("ingresoDocente",mostCurrent.activityBA);
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"eventoDocente\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"EVENTOS","eventoDocente");
RDebugUtils.currentLine=4521988;
 //BA.debugLineNum = 4521988;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfilDocente\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"PERFIL","perfilDocente");
RDebugUtils.currentLine=4521989;
 //BA.debugLineNum = 4521989;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4521990;
 //BA.debugLineNum = 4521990;BA.debugLine="Panel1.Visible =False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521991;
 //BA.debugLineNum = 4521991;BA.debugLine="evento11.Visible = False";
mostCurrent._evento11.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521992;
 //BA.debugLineNum = 4521992;BA.debugLine="evento22.Visible= False";
mostCurrent._evento22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521993;
 //BA.debugLineNum = 4521993;BA.debugLine="evento33.Visible=False";
mostCurrent._evento33.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521994;
 //BA.debugLineNum = 4521994;BA.debugLine="evento3.Visible=False";
mostCurrent._evento3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521995;
 //BA.debugLineNum = 4521995;BA.debugLine="evento2.Visible= False";
mostCurrent._evento2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521996;
 //BA.debugLineNum = 4521996;BA.debugLine="evento1.Visible=False";
mostCurrent._evento1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521997;
 //BA.debugLineNum = 4521997;BA.debugLine="evento4.Visible=False";
mostCurrent._evento4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521998;
 //BA.debugLineNum = 4521998;BA.debugLine="evento44.Visible=False";
mostCurrent._evento44.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4521999;
 //BA.debugLineNum = 4521999;BA.debugLine="Anuncio.Visible= True";
mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4522000;
 //BA.debugLineNum = 4522000;BA.debugLine="eventos = 0";
_eventos = (int) (0);
RDebugUtils.currentLine=4522001;
 //BA.debugLineNum = 4522001;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ingresodocente";
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="End Sub";
return "";
}
public static String  _btncambiardocente_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambiardocente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambiardocente_click", null));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub btncambiardocente_Click";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="If estado = 0 Then";
if (_estado==0) { 
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="Panel1.Visible = True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="estado = 1";
_estado = (int) (1);
 };
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="End Sub";
return "";
}
public static String  _btncambio_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambio_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub btncambio_Click";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="If txtconact.Text<>\"\" And txtconnuv.Text<>\"\" And";
if ((mostCurrent._txtconact.getText()).equals("") == false && (mostCurrent._txtconnuv.getText()).equals("") == false && (mostCurrent._txtconfcon.getText()).equals("") == false) { 
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="If txtconnuv.Text = txtconfcon.Text Then";
if ((mostCurrent._txtconnuv.getText()).equals(mostCurrent._txtconfcon.getText())) { 
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/";
_apiaddress = "http://192.168.1.1/schooltime1.php";
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=5046277;
 //BA.debugLineNum = 5046277;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",ingresodocente.getObject());
RDebugUtils.currentLine=5046278;
 //BA.debugLineNum = 5046278;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tbl_docente S";
_job._poststring /*String*/ (null,_apiaddress,"UPDATE tbl_docente SET contrasena_doc='"+mostCurrent._txtconnuv.getText()+"' WHERE contrasena_doc='"+mostCurrent._txtconact.getText()+"'");
 }else {
RDebugUtils.currentLine=5046280;
 //BA.debugLineNum = 5046280;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Las contraseñas deben coincidir"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
 }else {
RDebugUtils.currentLine=5046283;
 //BA.debugLineNum = 5046283;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=5046285;
 //BA.debugLineNum = 5046285;BA.debugLine="End Sub";
return "";
}
public static String  _btncerrardocente_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncerrardocente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncerrardocente_click", null));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub btncerrardocente_Click";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="StartActivity(perfiles)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._perfiles.getObject()));
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5570560;
 //BA.debugLineNum = 5570560;BA.debugLine="Sub CreateNotificationChannel(ImportanceLevel As I";
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="If p.SdkVersion >= 26 Then";
if (_p.getSdkVersion()>=26) { 
RDebugUtils.currentLine=5570563;
 //BA.debugLineNum = 5570563;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(processBA);
RDebugUtils.currentLine=5570565;
 //BA.debugLineNum = 5570565;BA.debugLine="Dim channelId As String = \"channel_\"& Importance";
_channelid = "channel_"+BA.NumberToString(_importancelevel);
RDebugUtils.currentLine=5570566;
 //BA.debugLineNum = 5570566;BA.debugLine="Dim channel As JavaObject";
_channel = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=5570567;
 //BA.debugLineNum = 5570567;BA.debugLine="channel.InitializeNewInstance(\"android.app.Notif";
_channel.InitializeNewInstance("android.app.NotificationChannel",new Object[]{(Object)(_channelid),(Object)(anywheresoftware.b4a.keywords.Common.Application.getLabelName()),(Object)(_importancelevel)});
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="channel.RunMethod(\"setShowBadge\",Array(False))";
_channel.RunMethod("setShowBadge",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.False)});
RDebugUtils.currentLine=5570570;
 //BA.debugLineNum = 5570570;BA.debugLine="Dim manager As JavaObject = ctxt.RunMethod(\"getS";
_manager = new anywheresoftware.b4j.object.JavaObject();
_manager = (anywheresoftware.b4j.object.JavaObject) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4j.object.JavaObject(), (java.lang.Object)(_ctxt.RunMethod("getSystemService",new Object[]{(Object)("notification")})));
RDebugUtils.currentLine=5570571;
 //BA.debugLineNum = 5570571;BA.debugLine="manager.RunMethod(\"createNotificationChannel\",Ar";
_manager.RunMethod("createNotificationChannel",new Object[]{(Object)(_channel.getObject())});
 };
RDebugUtils.currentLine=5570574;
 //BA.debugLineNum = 5570574;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="If contraseñaD.Text <> \"\" Then";
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
RDebugUtils.currentLine=5505026;
 //BA.debugLineNum = 5505026;BA.debugLine="Try";
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
RDebugUtils.currentLine=5505027;
 //BA.debugLineNum = 5505027;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/";
_apiaddress = "http://192.168.1.1/schooltime.php";
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingresodocente.getObject());
RDebugUtils.currentLine=5505030;
 //BA.debugLineNum = 5505030;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","cedula","pin",parent.mostCurrent._contraseñad.getText(),"tabla","tbl_docente","codigo","codigo_g","cedula","id_docente"});
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingresodocente", "enviar_click"), (Object)(_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=5505032;
 //BA.debugLineNum = 5505032;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=5505033;
 //BA.debugLineNum = 5505033;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=5505034;
 //BA.debugLineNum = 5505034;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=5505035;
 //BA.debugLineNum = 5505035;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=5505036;
 //BA.debugLineNum = 5505036;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=5505037;
 //BA.debugLineNum = 5505037;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=5505038;
 //BA.debugLineNum = 5505038;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=5505039;
 //BA.debugLineNum = 5505039;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5505040;
 //BA.debugLineNum = 5505040;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=5505041;
 //BA.debugLineNum = 5505041;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("05505041",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=5505042;
 //BA.debugLineNum = 5505042;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=5505043;
 //BA.debugLineNum = 5505043;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=5505044;
 //BA.debugLineNum = 5505044;BA.debugLine="fila= tabla.Get(i)";
_fila = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=5505045;
 //BA.debugLineNum = 5505045;BA.debugLine="codigo = fila.Get(\"codigo_g\")";
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
RDebugUtils.currentLine=5505049;
 //BA.debugLineNum = 5505049;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("05505049",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=5505052;
 //BA.debugLineNum = 5505052;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("05505052",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
RDebugUtils.currentLine=5505054;
 //BA.debugLineNum = 5505054;BA.debugLine="inicio.Visible =False";
parent.mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5505055;
 //BA.debugLineNum = 5505055;BA.debugLine="Datos.Visible = False";
parent.mostCurrent._datos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 25:
//C
this.state = 26;
RDebugUtils.currentLine=5505057;
 //BA.debugLineNum = 5505057;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Necesitas este campo para el ingreso"),BA.ObjectToCharSequence("AVISO"),processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
RDebugUtils.currentLine=5505059;
 //BA.debugLineNum = 5505059;BA.debugLine="remore";
_remore();
RDebugUtils.currentLine=5505060;
 //BA.debugLineNum = 5505060;BA.debugLine="End Sub";
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
anywheresoftware.b4a.objects.NotificationWrapper _n3 = null;
anywheresoftware.b4a.objects.NotificationWrapper _n4 = null;
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
RDebugUtils.currentLine=5636097;
 //BA.debugLineNum = 5636097;BA.debugLine="If eventos = 0 Then";
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
RDebugUtils.currentLine=5636098;
 //BA.debugLineNum = 5636098;BA.debugLine="Anuncio.Visible = True";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=5636100;
 //BA.debugLineNum = 5636100;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
;
RDebugUtils.currentLine=5636102;
 //BA.debugLineNum = 5636102;BA.debugLine="Try";

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
RDebugUtils.currentLine=5636103;
 //BA.debugLineNum = 5636103;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.1/s";
_apiaddress = "http://192.168.1.1/schooltime.php";
RDebugUtils.currentLine=5636104;
 //BA.debugLineNum = 5636104;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=5636105;
 //BA.debugLineNum = 5636105;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingresodocente.getObject());
RDebugUtils.currentLine=5636106;
 //BA.debugLineNum = 5636106;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","evento","codigo",parent._codigo,"quien","docente"});
RDebugUtils.currentLine=5636107;
 //BA.debugLineNum = 5636107;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingresodocente", "remore"), (Object)(_js));
this.state = 174;
return;
case 174:
//C
this.state = 9;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=5636108;
 //BA.debugLineNum = 5636108;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=5636109;
 //BA.debugLineNum = 5636109;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=5636110;
 //BA.debugLineNum = 5636110;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=5636111;
 //BA.debugLineNum = 5636111;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=5636112;
 //BA.debugLineNum = 5636112;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=5636113;
 //BA.debugLineNum = 5636113;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=5636114;
 //BA.debugLineNum = 5636114;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=5636115;
 //BA.debugLineNum = 5636115;BA.debugLine="eventos = 1";
parent._eventos = (int) (1);
RDebugUtils.currentLine=5636116;
 //BA.debugLineNum = 5636116;BA.debugLine="If eventos = 1 Then";
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
RDebugUtils.currentLine=5636117;
 //BA.debugLineNum = 5636117;BA.debugLine="evento1.Visible = True";
parent.mostCurrent._evento1.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 18:
//C
this.state = 19;
;
RDebugUtils.currentLine=5636119;
 //BA.debugLineNum = 5636119;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5636120;
 //BA.debugLineNum = 5636120;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=5636121;
 //BA.debugLineNum = 5636121;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("05636121",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=5636122;
 //BA.debugLineNum = 5636122;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=5636123;
 //BA.debugLineNum = 5636123;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=5636124;
 //BA.debugLineNum = 5636124;BA.debugLine="fila= tabla.Get(i)";
_fila = (anywheresoftware.b4a.objects.collections.Map) anywheresoftware.b4a.AbsObjectWrapper.ConvertToWrapper(new anywheresoftware.b4a.objects.collections.Map(), (anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=5636125;
 //BA.debugLineNum = 5636125;BA.debugLine="tit = fila.Get(\"titulo_e\")";
parent._tit = BA.ObjectToString(_fila.Get((Object)("titulo_e")));
RDebugUtils.currentLine=5636126;
 //BA.debugLineNum = 5636126;BA.debugLine="des = fila.Get(\"descripcion_e\")";
parent._des = BA.ObjectToString(_fila.Get((Object)("descripcion_e")));
RDebugUtils.currentLine=5636127;
 //BA.debugLineNum = 5636127;BA.debugLine="c = fila.Get(\"codigo_g\")";
parent._c = BA.ObjectToString(_fila.Get((Object)("codigo_g")));
RDebugUtils.currentLine=5636128;
 //BA.debugLineNum = 5636128;BA.debugLine="fec = fila.Get(\"fecha_evento\")";
parent._fec = BA.ObjectToString(_fila.Get((Object)("fecha_evento")));
RDebugUtils.currentLine=5636129;
 //BA.debugLineNum = 5636129;BA.debugLine="hor = fila.Get(\"hora_evento\")";
parent._hor = BA.ObjectToString(_fila.Get((Object)("hora_evento")));
RDebugUtils.currentLine=5636130;
 //BA.debugLineNum = 5636130;BA.debugLine="tip = fila.Get(\"id_tipo\")";
parent._tip = BA.ObjectToString(_fila.Get((Object)("id_tipo")));
RDebugUtils.currentLine=5636131;
 //BA.debugLineNum = 5636131;BA.debugLine="If eventos =1 Then";
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
RDebugUtils.currentLine=5636132;
 //BA.debugLineNum = 5636132;BA.debugLine="tipo = tip";
parent.mostCurrent._tipo = parent._tip;
RDebugUtils.currentLine=5636133;
 //BA.debugLineNum = 5636133;BA.debugLine="If tipo = \"00A\" Then";
if (true) break;

case 25:
//if
this.state = 40;
if ((parent.mostCurrent._tipo).equals("00A")) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 40;
RDebugUtils.currentLine=5636134;
 //BA.debugLineNum = 5636134;BA.debugLine="tipo = \"Celebración\"";
parent.mostCurrent._tipo = "Celebración";
 if (true) break;

case 29:
//C
this.state = 30;
RDebugUtils.currentLine=5636136;
 //BA.debugLineNum = 5636136;BA.debugLine="If tipo = \"00B\" Then";
if (true) break;

case 30:
//if
this.state = 39;
if ((parent.mostCurrent._tipo).equals("00B")) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 39;
RDebugUtils.currentLine=5636137;
 //BA.debugLineNum = 5636137;BA.debugLine="tipo = \"Cambio\"";
parent.mostCurrent._tipo = "Cambio";
 if (true) break;

case 34:
//C
this.state = 35;
RDebugUtils.currentLine=5636139;
 //BA.debugLineNum = 5636139;BA.debugLine="If tipo = \"00C\" Then";
if (true) break;

case 35:
//if
this.state = 38;
if ((parent.mostCurrent._tipo).equals("00C")) { 
this.state = 37;
}if (true) break;

case 37:
//C
this.state = 38;
RDebugUtils.currentLine=5636140;
 //BA.debugLineNum = 5636140;BA.debugLine="tipo = \"Reunión\"";
parent.mostCurrent._tipo = "Reunión";
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
RDebugUtils.currentLine=5636144;
 //BA.debugLineNum = 5636144;BA.debugLine="Dim n As Notification";
_n = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=5636145;
 //BA.debugLineNum = 5636145;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH)";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5636146;
 //BA.debugLineNum = 5636146;BA.debugLine="n.Initialize2(n.IMPORTANCE_HIGH)";
_n.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5636147;
 //BA.debugLineNum = 5636147;BA.debugLine="n.Icon =\"icon\"";
_n.setIcon("icon");
RDebugUtils.currentLine=5636148;
 //BA.debugLineNum = 5636148;BA.debugLine="n.SetInfo(tipo,\"Se llevará acabo el \"&fec,Ma";
_n.SetInfoNew(processBA,BA.ObjectToCharSequence(parent.mostCurrent._tipo),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fec),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=5636149;
 //BA.debugLineNum = 5636149;BA.debugLine="n.Notify(1)";
_n.Notify((int) (1));
RDebugUtils.currentLine=5636150;
 //BA.debugLineNum = 5636150;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636151;
 //BA.debugLineNum = 5636151;BA.debugLine="evento2.Visible = False";
parent.mostCurrent._evento2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636152;
 //BA.debugLineNum = 5636152;BA.debugLine="titulo.Text = tit";
parent.mostCurrent._titulo.setText(BA.ObjectToCharSequence(parent._tit));
RDebugUtils.currentLine=5636153;
 //BA.debugLineNum = 5636153;BA.debugLine="fecha.Text = fec";
parent.mostCurrent._fecha.setText(BA.ObjectToCharSequence(parent._fec));
RDebugUtils.currentLine=5636154;
 //BA.debugLineNum = 5636154;BA.debugLine="hora.Text = hor";
parent.mostCurrent._hora.setText(BA.ObjectToCharSequence(parent._hor));
RDebugUtils.currentLine=5636155;
 //BA.debugLineNum = 5636155;BA.debugLine="desc11 = des";
parent._desc11 = parent._des;
RDebugUtils.currentLine=5636156;
 //BA.debugLineNum = 5636156;BA.debugLine="If tipo = \"Celebración\" Then";
if (true) break;

case 41:
//if
this.state = 56;
if ((parent.mostCurrent._tipo).equals("Celebración")) { 
this.state = 43;
}else {
this.state = 45;
}if (true) break;

case 43:
//C
this.state = 56;
RDebugUtils.currentLine=5636157;
 //BA.debugLineNum = 5636157;BA.debugLine="celebracion.Visible = True";
parent.mostCurrent._celebracion.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636158;
 //BA.debugLineNum = 5636158;BA.debugLine="cambio.Visible = False";
parent.mostCurrent._cambio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636159;
 //BA.debugLineNum = 5636159;BA.debugLine="reunion.Visible = False";
parent.mostCurrent._reunion.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 45:
//C
this.state = 46;
RDebugUtils.currentLine=5636161;
 //BA.debugLineNum = 5636161;BA.debugLine="If tipo = \"Cambio\" Then";
if (true) break;

case 46:
//if
this.state = 55;
if ((parent.mostCurrent._tipo).equals("Cambio")) { 
this.state = 48;
}else {
this.state = 50;
}if (true) break;

case 48:
//C
this.state = 55;
RDebugUtils.currentLine=5636162;
 //BA.debugLineNum = 5636162;BA.debugLine="celebracion.Visible = False";
parent.mostCurrent._celebracion.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636163;
 //BA.debugLineNum = 5636163;BA.debugLine="cambio.Visible = True";
parent.mostCurrent._cambio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636164;
 //BA.debugLineNum = 5636164;BA.debugLine="reunion.Visible = False";
parent.mostCurrent._reunion.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 50:
//C
this.state = 51;
RDebugUtils.currentLine=5636166;
 //BA.debugLineNum = 5636166;BA.debugLine="If tipo = \"Reunión\" Then";
if (true) break;

case 51:
//if
this.state = 54;
if ((parent.mostCurrent._tipo).equals("Reunión")) { 
this.state = 53;
}if (true) break;

case 53:
//C
this.state = 54;
RDebugUtils.currentLine=5636167;
 //BA.debugLineNum = 5636167;BA.debugLine="celebracion.Visible = False";
parent.mostCurrent._celebracion.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636168;
 //BA.debugLineNum = 5636168;BA.debugLine="cambio.Visible = False";
parent.mostCurrent._cambio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636169;
 //BA.debugLineNum = 5636169;BA.debugLine="reunion.Visible = True";
parent.mostCurrent._reunion.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5636174;
 //BA.debugLineNum = 5636174;BA.debugLine="If eventos =2 Then";
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
RDebugUtils.currentLine=5636175;
 //BA.debugLineNum = 5636175;BA.debugLine="tipo2 = tip";
parent._tipo2 = parent._tip;
RDebugUtils.currentLine=5636176;
 //BA.debugLineNum = 5636176;BA.debugLine="If tipo2 = \"00A\" Then";
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
RDebugUtils.currentLine=5636177;
 //BA.debugLineNum = 5636177;BA.debugLine="tipo2 = \"Celebración\"";
parent._tipo2 = "Celebración";
 if (true) break;

case 66:
//C
this.state = 67;
RDebugUtils.currentLine=5636179;
 //BA.debugLineNum = 5636179;BA.debugLine="If tipo2 = \"00B\" Then";
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
RDebugUtils.currentLine=5636180;
 //BA.debugLineNum = 5636180;BA.debugLine="tipo2 = \"Cambio\"";
parent._tipo2 = "Cambio";
 if (true) break;

case 71:
//C
this.state = 72;
RDebugUtils.currentLine=5636182;
 //BA.debugLineNum = 5636182;BA.debugLine="If tipo2 = \"00C\" Then";
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
RDebugUtils.currentLine=5636183;
 //BA.debugLineNum = 5636183;BA.debugLine="tipo2 = \"Reunión\"";
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
RDebugUtils.currentLine=5636187;
 //BA.debugLineNum = 5636187;BA.debugLine="Dim n1 As Notification";
_n1 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=5636188;
 //BA.debugLineNum = 5636188;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5636189;
 //BA.debugLineNum = 5636189;BA.debugLine="n1.Initialize2(n.IMPORTANCE_HIGH)";
_n1.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5636190;
 //BA.debugLineNum = 5636190;BA.debugLine="n1.Icon =\"icon\"";
_n1.setIcon("icon");
RDebugUtils.currentLine=5636191;
 //BA.debugLineNum = 5636191;BA.debugLine="n1.SetInfo(tipo2,\"Se llevará acabo el \"&fec";
_n1.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo2),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fec),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=5636192;
 //BA.debugLineNum = 5636192;BA.debugLine="n1.Notify(2)";
_n1.Notify((int) (2));
RDebugUtils.currentLine=5636193;
 //BA.debugLineNum = 5636193;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636194;
 //BA.debugLineNum = 5636194;BA.debugLine="evento2.Visible = True";
parent.mostCurrent._evento2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636195;
 //BA.debugLineNum = 5636195;BA.debugLine="titulo2.Text = tit";
parent.mostCurrent._titulo2.setText(BA.ObjectToCharSequence(parent._tit));
RDebugUtils.currentLine=5636196;
 //BA.debugLineNum = 5636196;BA.debugLine="fecha2.Text = fec";
parent.mostCurrent._fecha2.setText(BA.ObjectToCharSequence(parent._fec));
RDebugUtils.currentLine=5636197;
 //BA.debugLineNum = 5636197;BA.debugLine="hora2.Text = hor";
parent.mostCurrent._hora2.setText(BA.ObjectToCharSequence(parent._hor));
RDebugUtils.currentLine=5636198;
 //BA.debugLineNum = 5636198;BA.debugLine="desc2 = des";
parent._desc2 = parent._des;
RDebugUtils.currentLine=5636199;
 //BA.debugLineNum = 5636199;BA.debugLine="If tipo2 = \"Celebración\" Then";
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
RDebugUtils.currentLine=5636200;
 //BA.debugLineNum = 5636200;BA.debugLine="celebracion2.Visible = True";
parent.mostCurrent._celebracion2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636201;
 //BA.debugLineNum = 5636201;BA.debugLine="cambio2.Visible = False";
parent.mostCurrent._cambio2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636202;
 //BA.debugLineNum = 5636202;BA.debugLine="reunion2.Visible = False";
parent.mostCurrent._reunion2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 82:
//C
this.state = 83;
RDebugUtils.currentLine=5636204;
 //BA.debugLineNum = 5636204;BA.debugLine="If tipo2 = \"Cambio\" Then";
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
RDebugUtils.currentLine=5636205;
 //BA.debugLineNum = 5636205;BA.debugLine="celebracion2.Visible = False";
parent.mostCurrent._celebracion2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636206;
 //BA.debugLineNum = 5636206;BA.debugLine="cambio2.Visible = True";
parent.mostCurrent._cambio2.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636207;
 //BA.debugLineNum = 5636207;BA.debugLine="reunion2.Visible = False";
parent.mostCurrent._reunion2.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 87:
//C
this.state = 88;
RDebugUtils.currentLine=5636209;
 //BA.debugLineNum = 5636209;BA.debugLine="If tipo2 = \"Reunión\" Then";
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
RDebugUtils.currentLine=5636210;
 //BA.debugLineNum = 5636210;BA.debugLine="celebracion2.Visible = False";
parent.mostCurrent._celebracion2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636211;
 //BA.debugLineNum = 5636211;BA.debugLine="cambio2.Visible = False";
parent.mostCurrent._cambio2.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636212;
 //BA.debugLineNum = 5636212;BA.debugLine="reunion2.Visible = True";
parent.mostCurrent._reunion2.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5636217;
 //BA.debugLineNum = 5636217;BA.debugLine="If eventos =3 Then";

case 94:
//if
this.state = 129;
if (parent._eventos==3) { 
this.state = 96;
}if (true) break;

case 96:
//C
this.state = 97;
RDebugUtils.currentLine=5636218;
 //BA.debugLineNum = 5636218;BA.debugLine="tipo3 = tip";
parent._tipo3 = parent._tip;
RDebugUtils.currentLine=5636219;
 //BA.debugLineNum = 5636219;BA.debugLine="If tipo3 = \"00A\" Then";
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
RDebugUtils.currentLine=5636220;
 //BA.debugLineNum = 5636220;BA.debugLine="tipo3 = \"Celebración\"";
parent._tipo3 = "Celebración";
 if (true) break;

case 101:
//C
this.state = 102;
RDebugUtils.currentLine=5636222;
 //BA.debugLineNum = 5636222;BA.debugLine="If tipo3 = \"00B\" Then";
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
RDebugUtils.currentLine=5636223;
 //BA.debugLineNum = 5636223;BA.debugLine="tipo3 = \"Cambio\"";
parent._tipo3 = "Cambio";
 if (true) break;

case 106:
//C
this.state = 107;
RDebugUtils.currentLine=5636225;
 //BA.debugLineNum = 5636225;BA.debugLine="If tipo3 = \"00C\" Then";
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
RDebugUtils.currentLine=5636226;
 //BA.debugLineNum = 5636226;BA.debugLine="tipo3 = \"Reunión\"";
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
RDebugUtils.currentLine=5636230;
 //BA.debugLineNum = 5636230;BA.debugLine="Dim n3 As Notification";
_n3 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=5636231;
 //BA.debugLineNum = 5636231;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5636232;
 //BA.debugLineNum = 5636232;BA.debugLine="n3.Initialize2(n.IMPORTANCE_HIGH)";
_n3.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5636233;
 //BA.debugLineNum = 5636233;BA.debugLine="n3.Icon =\"icon\"";
_n3.setIcon("icon");
RDebugUtils.currentLine=5636234;
 //BA.debugLineNum = 5636234;BA.debugLine="n3.SetInfo(tipo3,\"Se llevará acabo el \"&fec";
_n3.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo3),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fec),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=5636235;
 //BA.debugLineNum = 5636235;BA.debugLine="n3.Notify(3)";
_n3.Notify((int) (3));
RDebugUtils.currentLine=5636236;
 //BA.debugLineNum = 5636236;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636237;
 //BA.debugLineNum = 5636237;BA.debugLine="evento3.Visible = True";
parent.mostCurrent._evento3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636238;
 //BA.debugLineNum = 5636238;BA.debugLine="titulo3.Text = tit";
parent.mostCurrent._titulo3.setText(BA.ObjectToCharSequence(parent._tit));
RDebugUtils.currentLine=5636239;
 //BA.debugLineNum = 5636239;BA.debugLine="fecha3.Text = fec";
parent.mostCurrent._fecha3.setText(BA.ObjectToCharSequence(parent._fec));
RDebugUtils.currentLine=5636240;
 //BA.debugLineNum = 5636240;BA.debugLine="hora3.Text = hor";
parent.mostCurrent._hora3.setText(BA.ObjectToCharSequence(parent._hor));
RDebugUtils.currentLine=5636241;
 //BA.debugLineNum = 5636241;BA.debugLine="desc3 = des";
parent._desc3 = parent._des;
RDebugUtils.currentLine=5636242;
 //BA.debugLineNum = 5636242;BA.debugLine="If tipo3 = \"Celebración\" Then";
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
RDebugUtils.currentLine=5636243;
 //BA.debugLineNum = 5636243;BA.debugLine="celebracion3.Visible = True";
parent.mostCurrent._celebracion3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636244;
 //BA.debugLineNum = 5636244;BA.debugLine="cambio3.Visible = False";
parent.mostCurrent._cambio3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636245;
 //BA.debugLineNum = 5636245;BA.debugLine="reunion3.Visible = False";
parent.mostCurrent._reunion3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 117:
//C
this.state = 118;
RDebugUtils.currentLine=5636247;
 //BA.debugLineNum = 5636247;BA.debugLine="If tipo3 = \"Cambio\" Then";
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
RDebugUtils.currentLine=5636248;
 //BA.debugLineNum = 5636248;BA.debugLine="celebracion3.Visible = False";
parent.mostCurrent._celebracion3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636249;
 //BA.debugLineNum = 5636249;BA.debugLine="cambio3.Visible = True";
parent.mostCurrent._cambio3.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636250;
 //BA.debugLineNum = 5636250;BA.debugLine="reunion3.Visible = False";
parent.mostCurrent._reunion3.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 122:
//C
this.state = 123;
RDebugUtils.currentLine=5636252;
 //BA.debugLineNum = 5636252;BA.debugLine="If tipo3 = \"Reunión\" Then";
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
RDebugUtils.currentLine=5636253;
 //BA.debugLineNum = 5636253;BA.debugLine="celebracion3.Visible = False";
parent.mostCurrent._celebracion3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636254;
 //BA.debugLineNum = 5636254;BA.debugLine="cambio3.Visible = False";
parent.mostCurrent._cambio3.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636255;
 //BA.debugLineNum = 5636255;BA.debugLine="reunion3.Visible = True";
parent.mostCurrent._reunion3.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5636260;
 //BA.debugLineNum = 5636260;BA.debugLine="If eventos =4 Then";

case 129:
//if
this.state = 164;
if (parent._eventos==4) { 
this.state = 131;
}if (true) break;

case 131:
//C
this.state = 132;
RDebugUtils.currentLine=5636261;
 //BA.debugLineNum = 5636261;BA.debugLine="tipo4 = tip";
parent._tipo4 = parent._tip;
RDebugUtils.currentLine=5636262;
 //BA.debugLineNum = 5636262;BA.debugLine="If tipo4 = \"00A\" Then";
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
RDebugUtils.currentLine=5636263;
 //BA.debugLineNum = 5636263;BA.debugLine="tipo4 = \"Celebración\"";
parent._tipo4 = "Celebración";
 if (true) break;

case 136:
//C
this.state = 137;
RDebugUtils.currentLine=5636265;
 //BA.debugLineNum = 5636265;BA.debugLine="If tipo4 = \"00B\" Then";
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
RDebugUtils.currentLine=5636266;
 //BA.debugLineNum = 5636266;BA.debugLine="tipo4 = \"Cambio\"";
parent._tipo4 = "Cambio";
 if (true) break;

case 141:
//C
this.state = 142;
RDebugUtils.currentLine=5636268;
 //BA.debugLineNum = 5636268;BA.debugLine="If tipo4 = \"00C\" Then";
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
RDebugUtils.currentLine=5636269;
 //BA.debugLineNum = 5636269;BA.debugLine="tipo4 = \"Reunión\"";
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
RDebugUtils.currentLine=5636273;
 //BA.debugLineNum = 5636273;BA.debugLine="Dim n4 As Notification";
_n4 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=5636274;
 //BA.debugLineNum = 5636274;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5636275;
 //BA.debugLineNum = 5636275;BA.debugLine="n4.Initialize2(n.IMPORTANCE_HIGH)";
_n4.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5636276;
 //BA.debugLineNum = 5636276;BA.debugLine="n4.Icon =\"icon\"";
_n4.setIcon("icon");
RDebugUtils.currentLine=5636277;
 //BA.debugLineNum = 5636277;BA.debugLine="n4.SetInfo(tipo4,\"Se llevará acabo el \"&fec";
_n4.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo4),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fec),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=5636278;
 //BA.debugLineNum = 5636278;BA.debugLine="n4.Notify(4)";
_n4.Notify((int) (4));
RDebugUtils.currentLine=5636279;
 //BA.debugLineNum = 5636279;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636280;
 //BA.debugLineNum = 5636280;BA.debugLine="evento4.Visible = True";
parent.mostCurrent._evento4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636281;
 //BA.debugLineNum = 5636281;BA.debugLine="titulo4.Text = tit";
parent.mostCurrent._titulo4.setText(BA.ObjectToCharSequence(parent._tit));
RDebugUtils.currentLine=5636282;
 //BA.debugLineNum = 5636282;BA.debugLine="fecha4.Text = fec";
parent.mostCurrent._fecha4.setText(BA.ObjectToCharSequence(parent._fec));
RDebugUtils.currentLine=5636283;
 //BA.debugLineNum = 5636283;BA.debugLine="hora4.Text = hor";
parent.mostCurrent._hora4.setText(BA.ObjectToCharSequence(parent._hor));
RDebugUtils.currentLine=5636284;
 //BA.debugLineNum = 5636284;BA.debugLine="desc4 = des";
parent._desc4 = parent._des;
RDebugUtils.currentLine=5636285;
 //BA.debugLineNum = 5636285;BA.debugLine="If tipo4 = \"Celebración\" Then";
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
RDebugUtils.currentLine=5636286;
 //BA.debugLineNum = 5636286;BA.debugLine="celebracion4.Visible = True";
parent.mostCurrent._celebracion4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636287;
 //BA.debugLineNum = 5636287;BA.debugLine="cambio4.Visible = False";
parent.mostCurrent._cambio4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636288;
 //BA.debugLineNum = 5636288;BA.debugLine="reunion4.Visible = False";
parent.mostCurrent._reunion4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 152:
//C
this.state = 153;
RDebugUtils.currentLine=5636290;
 //BA.debugLineNum = 5636290;BA.debugLine="If tipo4 = \"Cambio\" Then";
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
RDebugUtils.currentLine=5636291;
 //BA.debugLineNum = 5636291;BA.debugLine="celebracion4.Visible = False";
parent.mostCurrent._celebracion4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636292;
 //BA.debugLineNum = 5636292;BA.debugLine="cambio4.Visible = True";
parent.mostCurrent._cambio4.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5636293;
 //BA.debugLineNum = 5636293;BA.debugLine="reunion4.Visible = False";
parent.mostCurrent._reunion4.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 157:
//C
this.state = 158;
RDebugUtils.currentLine=5636295;
 //BA.debugLineNum = 5636295;BA.debugLine="If tipo4 = \"Reunión\" Then";
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
RDebugUtils.currentLine=5636296;
 //BA.debugLineNum = 5636296;BA.debugLine="celebracion4.Visible = False";
parent.mostCurrent._celebracion4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636297;
 //BA.debugLineNum = 5636297;BA.debugLine="cambio4.Visible = False";
parent.mostCurrent._cambio4.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5636298;
 //BA.debugLineNum = 5636298;BA.debugLine="reunion4.Visible = True";
parent.mostCurrent._reunion4.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5636304;
 //BA.debugLineNum = 5636304;BA.debugLine="eventos = eventos  + 1";
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
RDebugUtils.currentLine=5636308;
 //BA.debugLineNum = 5636308;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("05636308",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=5636311;
 //BA.debugLineNum = 5636311;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("05636311",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 173:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=5636313;
 //BA.debugLineNum = 5636313;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub evento1_Click";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5177347;
 //BA.debugLineNum = 5177347;BA.debugLine="evento11.Visible = True";
mostCurrent._evento11.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5177348;
 //BA.debugLineNum = 5177348;BA.debugLine="titulo1.Text = titulo.Text";
mostCurrent._titulo1.setText(BA.ObjectToCharSequence(mostCurrent._titulo.getText()));
RDebugUtils.currentLine=5177349;
 //BA.debugLineNum = 5177349;BA.debugLine="fecha1.Text = fecha.Text";
mostCurrent._fecha1.setText(BA.ObjectToCharSequence(mostCurrent._fecha.getText()));
RDebugUtils.currentLine=5177350;
 //BA.debugLineNum = 5177350;BA.debugLine="hora1.Text = hora.Text";
mostCurrent._hora1.setText(BA.ObjectToCharSequence(mostCurrent._hora.getText()));
RDebugUtils.currentLine=5177351;
 //BA.debugLineNum = 5177351;BA.debugLine="desc1.Text = desc11";
mostCurrent._desc1.setText(BA.ObjectToCharSequence(_desc11));
RDebugUtils.currentLine=5177352;
 //BA.debugLineNum = 5177352;BA.debugLine="If tipo = \"Celebración\" Then";
if ((mostCurrent._tipo).equals("Celebración")) { 
RDebugUtils.currentLine=5177353;
 //BA.debugLineNum = 5177353;BA.debugLine="icono1.Visible = True";
mostCurrent._icono1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5177354;
 //BA.debugLineNum = 5177354;BA.debugLine="icono1C.Visible = False";
mostCurrent._icono1c.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5177355;
 //BA.debugLineNum = 5177355;BA.debugLine="icono1R.Visible = False";
mostCurrent._icono1r.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=5177357;
 //BA.debugLineNum = 5177357;BA.debugLine="If tipo = \"Reunión\" Then";
if ((mostCurrent._tipo).equals("Reunión")) { 
RDebugUtils.currentLine=5177358;
 //BA.debugLineNum = 5177358;BA.debugLine="icono1.Visible = False";
mostCurrent._icono1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5177359;
 //BA.debugLineNum = 5177359;BA.debugLine="icono1C.Visible = False";
mostCurrent._icono1c.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5177360;
 //BA.debugLineNum = 5177360;BA.debugLine="icono1R.Visible = True";
mostCurrent._icono1r.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=5177362;
 //BA.debugLineNum = 5177362;BA.debugLine="If tipo = \"Cambio\" Then";
if ((mostCurrent._tipo).equals("Cambio")) { 
RDebugUtils.currentLine=5177363;
 //BA.debugLineNum = 5177363;BA.debugLine="icono1.Visible = False";
mostCurrent._icono1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5177364;
 //BA.debugLineNum = 5177364;BA.debugLine="icono1C.Visible = True";
mostCurrent._icono1c.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5177365;
 //BA.debugLineNum = 5177365;BA.debugLine="icono1R.Visible = False";
mostCurrent._icono1r.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=5177369;
 //BA.debugLineNum = 5177369;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=5177371;
 //BA.debugLineNum = 5177371;BA.debugLine="End Sub";
return "";
}
public static String  _evento2_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento2_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento2_click", null));}
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Sub evento2_Click";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="evento22.Visible = True";
mostCurrent._evento22.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5308420;
 //BA.debugLineNum = 5308420;BA.debugLine="titulo22.Text = titulo2.Text";
mostCurrent._titulo22.setText(BA.ObjectToCharSequence(mostCurrent._titulo2.getText()));
RDebugUtils.currentLine=5308421;
 //BA.debugLineNum = 5308421;BA.debugLine="fecha22.Text = fecha2.Text";
mostCurrent._fecha22.setText(BA.ObjectToCharSequence(mostCurrent._fecha2.getText()));
RDebugUtils.currentLine=5308422;
 //BA.debugLineNum = 5308422;BA.debugLine="hora22.Text = hora2.Text";
mostCurrent._hora22.setText(BA.ObjectToCharSequence(mostCurrent._hora2.getText()));
RDebugUtils.currentLine=5308423;
 //BA.debugLineNum = 5308423;BA.debugLine="descripcion22.Text = desc2";
mostCurrent._descripcion22.setText(BA.ObjectToCharSequence(_desc2));
RDebugUtils.currentLine=5308424;
 //BA.debugLineNum = 5308424;BA.debugLine="If tipo2 = \"Celebración\" Then";
if ((_tipo2).equals("Celebración")) { 
RDebugUtils.currentLine=5308425;
 //BA.debugLineNum = 5308425;BA.debugLine="celebracion22.Visible = True";
mostCurrent._celebracion22.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5308426;
 //BA.debugLineNum = 5308426;BA.debugLine="cambio22.Visible = False";
mostCurrent._cambio22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5308427;
 //BA.debugLineNum = 5308427;BA.debugLine="reunion22.Visible = False";
mostCurrent._reunion22.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=5308429;
 //BA.debugLineNum = 5308429;BA.debugLine="If tipo2 = \"Reunión\" Then";
if ((_tipo2).equals("Reunión")) { 
RDebugUtils.currentLine=5308430;
 //BA.debugLineNum = 5308430;BA.debugLine="celebracion22.Visible = False";
mostCurrent._celebracion22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5308431;
 //BA.debugLineNum = 5308431;BA.debugLine="cambio22.Visible = False";
mostCurrent._cambio22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5308432;
 //BA.debugLineNum = 5308432;BA.debugLine="reunion22.Visible = True";
mostCurrent._reunion22.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=5308434;
 //BA.debugLineNum = 5308434;BA.debugLine="If tipo2 = \"Cambio\" Then";
if ((_tipo2).equals("Cambio")) { 
RDebugUtils.currentLine=5308435;
 //BA.debugLineNum = 5308435;BA.debugLine="celebracion22.Visible = False";
mostCurrent._celebracion22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5308436;
 //BA.debugLineNum = 5308436;BA.debugLine="cambio22.Visible = True";
mostCurrent._cambio22.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5308437;
 //BA.debugLineNum = 5308437;BA.debugLine="reunion22.Visible = False";
mostCurrent._reunion22.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=5308441;
 //BA.debugLineNum = 5308441;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=5308443;
 //BA.debugLineNum = 5308443;BA.debugLine="End Sub";
return "";
}
public static String  _evento3_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento3_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento3_click", null));}
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub evento3_Click";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="evento33.Visible = True";
mostCurrent._evento33.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="titulo33.Text = titulo3.Text";
mostCurrent._titulo33.setText(BA.ObjectToCharSequence(mostCurrent._titulo3.getText()));
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="fecha33.Text = fecha3.Text";
mostCurrent._fecha33.setText(BA.ObjectToCharSequence(mostCurrent._fecha3.getText()));
RDebugUtils.currentLine=5373958;
 //BA.debugLineNum = 5373958;BA.debugLine="hora33.Text = hora3.Text";
mostCurrent._hora33.setText(BA.ObjectToCharSequence(mostCurrent._hora3.getText()));
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="descripcion33.Text = desc3";
mostCurrent._descripcion33.setText(BA.ObjectToCharSequence(_desc3));
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="If tipo3 = \"Celebración\" Then";
if ((_tipo3).equals("Celebración")) { 
RDebugUtils.currentLine=5373961;
 //BA.debugLineNum = 5373961;BA.debugLine="celebracion33.Visible = True";
mostCurrent._celebracion33.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5373962;
 //BA.debugLineNum = 5373962;BA.debugLine="cambio33.Visible = False";
mostCurrent._cambio33.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5373963;
 //BA.debugLineNum = 5373963;BA.debugLine="reunion33.Visible = False";
mostCurrent._reunion33.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=5373965;
 //BA.debugLineNum = 5373965;BA.debugLine="If tipo3 = \"Reunión\" Then";
if ((_tipo3).equals("Reunión")) { 
RDebugUtils.currentLine=5373966;
 //BA.debugLineNum = 5373966;BA.debugLine="celebracion33.Visible = False";
mostCurrent._celebracion33.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5373967;
 //BA.debugLineNum = 5373967;BA.debugLine="cambio33.Visible = False";
mostCurrent._cambio33.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5373968;
 //BA.debugLineNum = 5373968;BA.debugLine="reunion33.Visible = True";
mostCurrent._reunion33.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=5373970;
 //BA.debugLineNum = 5373970;BA.debugLine="If tipo3 = \"Cambio\" Then";
if ((_tipo3).equals("Cambio")) { 
RDebugUtils.currentLine=5373971;
 //BA.debugLineNum = 5373971;BA.debugLine="celebracion33.Visible = False";
mostCurrent._celebracion33.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5373972;
 //BA.debugLineNum = 5373972;BA.debugLine="cambio33.Visible = True";
mostCurrent._cambio33.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5373973;
 //BA.debugLineNum = 5373973;BA.debugLine="reunion33.Visible = False";
mostCurrent._reunion33.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=5373977;
 //BA.debugLineNum = 5373977;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=5373979;
 //BA.debugLineNum = 5373979;BA.debugLine="End Sub";
return "";
}
public static String  _evento4_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento4_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento4_click", null));}
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub evento4_Click";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="evento44.Visible = True";
mostCurrent._evento44.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="titulo44.Text = titulo4.Text";
mostCurrent._titulo44.setText(BA.ObjectToCharSequence(mostCurrent._titulo4.getText()));
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="fecha44.Text = fecha4.Text";
mostCurrent._fecha44.setText(BA.ObjectToCharSequence(mostCurrent._fecha4.getText()));
RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="hora44.Text = hora4.Text";
mostCurrent._hora44.setText(BA.ObjectToCharSequence(mostCurrent._hora4.getText()));
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="descripcion44.Text = desc4";
mostCurrent._descripcion44.setText(BA.ObjectToCharSequence(_desc4));
RDebugUtils.currentLine=5439496;
 //BA.debugLineNum = 5439496;BA.debugLine="If tipo4 = \"Celebración\" Then";
if ((_tipo4).equals("Celebración")) { 
RDebugUtils.currentLine=5439497;
 //BA.debugLineNum = 5439497;BA.debugLine="celebracion44.Visible = True";
mostCurrent._celebracion44.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439498;
 //BA.debugLineNum = 5439498;BA.debugLine="cambio44.Visible = False";
mostCurrent._cambio44.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439499;
 //BA.debugLineNum = 5439499;BA.debugLine="reunion44.Visible = False";
mostCurrent._reunion44.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=5439501;
 //BA.debugLineNum = 5439501;BA.debugLine="If tipo4 = \"Reunión\" Then";
if ((_tipo4).equals("Reunión")) { 
RDebugUtils.currentLine=5439502;
 //BA.debugLineNum = 5439502;BA.debugLine="celebracion44.Visible = False";
mostCurrent._celebracion44.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439503;
 //BA.debugLineNum = 5439503;BA.debugLine="cambio44.Visible = False";
mostCurrent._cambio44.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439504;
 //BA.debugLineNum = 5439504;BA.debugLine="reunion44.Visible = True";
mostCurrent._reunion44.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=5439506;
 //BA.debugLineNum = 5439506;BA.debugLine="If tipo4 = \"Cambio\" Then";
if ((_tipo4).equals("Cambio")) { 
RDebugUtils.currentLine=5439507;
 //BA.debugLineNum = 5439507;BA.debugLine="celebracion44.Visible = False";
mostCurrent._celebracion44.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439508;
 //BA.debugLineNum = 5439508;BA.debugLine="cambio44.Visible = True";
mostCurrent._cambio44.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439509;
 //BA.debugLineNum = 5439509;BA.debugLine="reunion44.Visible = False";
mostCurrent._reunion44.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=5439513;
 //BA.debugLineNum = 5439513;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=5439515;
 //BA.debugLineNum = 5439515;BA.debugLine="End Sub";
return "";
}
public static String  _inicio_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inicio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "inicio_click", null));}
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub inicio_Click";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="If event = 1 Then";
if (_event==1) { 
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="evento11.Visible = False";
mostCurrent._evento11.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5242884;
 //BA.debugLineNum = 5242884;BA.debugLine="evento22.Visible = False";
mostCurrent._evento22.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5242885;
 //BA.debugLineNum = 5242885;BA.debugLine="evento33.Visible = False";
mostCurrent._evento33.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5242886;
 //BA.debugLineNum = 5242886;BA.debugLine="evento44.Visible = False";
mostCurrent._evento44.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5242887;
 //BA.debugLineNum = 5242887;BA.debugLine="event = 0";
_event = (int) (0);
 };
RDebugUtils.currentLine=5242889;
 //BA.debugLineNum = 5242889;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
anywheresoftware.b4a.keywords.Common.LogImpl("05111810","OK, se actualizó correctamente",0);
RDebugUtils.currentLine=5111811;
 //BA.debugLineNum = 5111811;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito"),BA.ObjectToCharSequence("AVISO"),processBA);
RDebugUtils.currentLine=5111812;
 //BA.debugLineNum = 5111812;BA.debugLine="txtconact.Text=\"\"";
mostCurrent._txtconact.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=5111813;
 //BA.debugLineNum = 5111813;BA.debugLine="txtconnuv.Text=\"\"";
mostCurrent._txtconnuv.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=5111814;
 //BA.debugLineNum = 5111814;BA.debugLine="txtconfcon.Text=\"\"";
mostCurrent._txtconfcon.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=5111815;
 //BA.debugLineNum = 5111815;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5111816;
 //BA.debugLineNum = 5111816;BA.debugLine="inicio.Visible=False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5111817;
 //BA.debugLineNum = 5111817;BA.debugLine="estado=0";
_estado = (int) (0);
 }else {
RDebugUtils.currentLine=5111819;
 //BA.debugLineNum = 5111819;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("05111819",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=5111820;
 //BA.debugLineNum = 5111820;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5111822;
 //BA.debugLineNum = 5111822;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=5111823;
 //BA.debugLineNum = 5111823;BA.debugLine="End Sub";
return "";
}
public static String  _retroceder_click() throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "retroceder_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "retroceder_click", null));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub retroceder_Click";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="If estado = 1 Then";
if (_estado==1) { 
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="estado = 0";
_estado = (int) (0);
 };
RDebugUtils.currentLine=4849670;
 //BA.debugLineNum = 4849670;BA.debugLine="End Sub";
return "";
}
public static String  _txtconact_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconact_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconact_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub txtconact_TextChanged (Old As String, New As S";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="MsgboxAsync(\"Laconfirmación de la contraseña no";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfcon_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingresodocente";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfcon_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfcon_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub txtconfcon_TextChanged (Old As String, New As";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="End Sub";
return "";
}
}
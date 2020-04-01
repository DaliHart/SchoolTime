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

public class ingresoestudiante extends Activity implements B4AActivity{
	public static ingresoestudiante mostCurrent;
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
			processBA = new anywheresoftware.b4a.ShellBA(this.getApplicationContext(), null, null, "b4a.example", "b4a.example.ingresoestudiante");
			processBA.loadHtSubs(this.getClass());
	        float deviceScale = getApplicationContext().getResources().getDisplayMetrics().density;
	        BALayout.setDeviceScale(deviceScale);
            
		}
		else if (previousOne != null) {
			Activity p = previousOne.get();
			if (p != null && p != this) {
                BA.LogInfo("Killing previous instance (ingresoestudiante).");
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
		activityBA = new BA(this, layout, processBA, "b4a.example", "b4a.example.ingresoestudiante");
        
        processBA.sharedProcessBA.activityBA = new java.lang.ref.WeakReference<BA>(activityBA);
        anywheresoftware.b4a.objects.ViewWrapper.lastId = 0;
        _activity = new ActivityWrapper(activityBA, "activity");
        anywheresoftware.b4a.Msgbox.isDismissing = false;
        if (BA.isShellModeRuntimeCheck(processBA)) {
			if (isFirst)
				processBA.raiseEvent2(null, true, "SHELL", false);
			processBA.raiseEvent2(null, true, "CREATE", true, "b4a.example.ingresoestudiante", processBA, activityBA, _activity, anywheresoftware.b4a.keywords.Common.Density, mostCurrent);
			_activity.reinitializeForShell(activityBA, "activity");
		}
        initializeProcessGlobals();		
        initializeGlobals();
        
        BA.LogInfo("** Activity (ingresoestudiante) Create, isFirst = " + isFirst + " **");
        processBA.raiseEvent2(null, true, "activity_create", false, isFirst);
		isFirst = false;
		if (this != mostCurrent)
			return;
        processBA.setActivityPaused(false);
        BA.LogInfo("** Activity (ingresoestudiante) Resume **");
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
		return ingresoestudiante.class;
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
        BA.LogInfo("** Activity (ingresoestudiante) Pause, UserClosed = " + activityBA.activity.isFinishing() + " **");
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
            ingresoestudiante mc = mostCurrent;
			if (mc == null || mc != activity.get())
				return;
			processBA.setActivityPaused(false);
            BA.LogInfo("** Activity (ingresoestudiante) Resume **");
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
public static String _codigoe = "";
public static String _desc1 = "";
public static String _desc2 = "";
public static String _desc3 = "";
public static String _desc4 = "";
public static String _c = "";
public static int _eventos = 0;
public static int _event = 0;
public anywheresoftware.b4a.objects.TabHostWrapper _tabhost1 = null;
public anywheresoftware.b4a.objects.PanelWrapper _inicio = null;
public anywheresoftware.b4a.objects.PanelWrapper _panel1 = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncambioe = null;
public anywheresoftware.b4a.objects.LabelWrapper _retroceder = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconacte = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconfcone = null;
public anywheresoftware.b4a.objects.EditTextWrapper _txtconnuve = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncambiarestudiante = null;
public anywheresoftware.b4a.objects.ButtonWrapper _btncerrarestudiante = null;
public anywheresoftware.b4a.objects.LabelWrapper _anuncio = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio1e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio2e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion1e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion2e = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento1e = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento2e = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha1e = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha2e = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora1e = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora2e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion1e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion2e = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo1e = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo2e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio11e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio22e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion11e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion22e = null;
public anywheresoftware.b4a.objects.EditTextWrapper _contraseñae = null;
public anywheresoftware.b4a.objects.PanelWrapper _datos = null;
public anywheresoftware.b4a.objects.LabelWrapper _desc11e = null;
public anywheresoftware.b4a.objects.LabelWrapper _descripcion22e = null;
public anywheresoftware.b4a.objects.ButtonWrapper _enviare = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento11e = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento22e = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha11e = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha22e = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora11e = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora22e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion11e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion22e = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo11e = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo22e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio3e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion3e = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento3e = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha3e = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora3e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion3e = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo3e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio33e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion33e = null;
public anywheresoftware.b4a.objects.LabelWrapper _descripcion33e = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento33e = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha33e = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora33e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion33e = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo33e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio4e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion4e = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento4e = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha4e = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora4e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion4e = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo4e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _cambio44e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _celebracion44e = null;
public anywheresoftware.b4a.objects.LabelWrapper _descripcion44e = null;
public anywheresoftware.b4a.objects.PanelWrapper _evento44e = null;
public anywheresoftware.b4a.objects.LabelWrapper _fecha44e = null;
public anywheresoftware.b4a.objects.LabelWrapper _hora44e = null;
public anywheresoftware.b4a.objects.ImageViewWrapper _reunion44e = null;
public anywheresoftware.b4a.objects.LabelWrapper _titulo44e = null;
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.perfiles _perfiles = null;
public b4a.example.ingresodocente _ingresodocente = null;
public b4a.example.ingreso _ingreso = null;
public b4a.example.inicioacudiente _inicioacudiente = null;
public b4a.example.iniciodocente _iniciodocente = null;
public b4a.example.inicioestudiante _inicioestudiante = null;
public b4a.example.registroacudiente _registroacudiente = null;
public b4a.example.registrodocente _registrodocente = null;
public b4a.example.registroestudiante _registroestudiante = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=3997696;
 //BA.debugLineNum = 3997696;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=3997698;
 //BA.debugLineNum = 3997698;BA.debugLine="Activity.LoadLayout(\"ingresoEstudiante\")";
mostCurrent._activity.LoadLayout("ingresoEstudiante",mostCurrent.activityBA);
RDebugUtils.currentLine=3997699;
 //BA.debugLineNum = 3997699;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"eventoE\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"EVENTOS","eventoE");
RDebugUtils.currentLine=3997700;
 //BA.debugLineNum = 3997700;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfilE\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"PERFIL","perfilE");
RDebugUtils.currentLine=3997701;
 //BA.debugLineNum = 3997701;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997702;
 //BA.debugLineNum = 3997702;BA.debugLine="inicio.Visible=True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=3997703;
 //BA.debugLineNum = 3997703;BA.debugLine="evento1E.Visible=False";
mostCurrent._evento1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997704;
 //BA.debugLineNum = 3997704;BA.debugLine="evento2E.Visible=False";
mostCurrent._evento2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997705;
 //BA.debugLineNum = 3997705;BA.debugLine="evento3E.Visible=False";
mostCurrent._evento3e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997706;
 //BA.debugLineNum = 3997706;BA.debugLine="evento4E.Visible=False";
mostCurrent._evento4e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997707;
 //BA.debugLineNum = 3997707;BA.debugLine="evento11E.Visible=False";
mostCurrent._evento11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997708;
 //BA.debugLineNum = 3997708;BA.debugLine="evento22E.Visible=False";
mostCurrent._evento22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997709;
 //BA.debugLineNum = 3997709;BA.debugLine="evento33E.Visible=False";
mostCurrent._evento33e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997710;
 //BA.debugLineNum = 3997710;BA.debugLine="evento44E.Visible=False";
mostCurrent._evento44e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997711;
 //BA.debugLineNum = 3997711;BA.debugLine="Anuncio.Visible=False";
mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=3997712;
 //BA.debugLineNum = 3997712;BA.debugLine="eventos = 0";
_eventos = (int) (0);
RDebugUtils.currentLine=3997713;
 //BA.debugLineNum = 3997713;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
RDebugUtils.currentLine=4128768;
 //BA.debugLineNum = 4128768;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=4128770;
 //BA.debugLineNum = 4128770;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=4063232;
 //BA.debugLineNum = 4063232;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=4063234;
 //BA.debugLineNum = 4063234;BA.debugLine="End Sub";
return "";
}
public static String  _btncambiarestudiante_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambiarestudiante_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambiarestudiante_click", null));}
RDebugUtils.currentLine=4587520;
 //BA.debugLineNum = 4587520;BA.debugLine="Sub btncambiarestudiante_Click";
RDebugUtils.currentLine=4587521;
 //BA.debugLineNum = 4587521;BA.debugLine="If estado = 0 Then";
if (_estado==0) { 
RDebugUtils.currentLine=4587522;
 //BA.debugLineNum = 4587522;BA.debugLine="Panel1.Visible = True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4587523;
 //BA.debugLineNum = 4587523;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4587524;
 //BA.debugLineNum = 4587524;BA.debugLine="estado = 1";
_estado = (int) (1);
 };
RDebugUtils.currentLine=4587526;
 //BA.debugLineNum = 4587526;BA.debugLine="End Sub";
return "";
}
public static String  _btncambioe_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambioe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambioe_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=4325376;
 //BA.debugLineNum = 4325376;BA.debugLine="Sub btncambioE_Click";
RDebugUtils.currentLine=4325377;
 //BA.debugLineNum = 4325377;BA.debugLine="If txtconactE.Text<>\"\" And txtconnuvE.Text<>\"\" An";
if ((mostCurrent._txtconacte.getText()).equals("") == false && (mostCurrent._txtconnuve.getText()).equals("") == false && (mostCurrent._txtconfcone.getText()).equals("") == false) { 
RDebugUtils.currentLine=4325378;
 //BA.debugLineNum = 4325378;BA.debugLine="If txtconnuvE.Text = txtconfconE.Text Then";
if ((mostCurrent._txtconnuve.getText()).equals(mostCurrent._txtconfcone.getText())) { 
RDebugUtils.currentLine=4325379;
 //BA.debugLineNum = 4325379;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/";
_apiaddress = "http://192.168.1.5/schooltime1.php";
RDebugUtils.currentLine=4325380;
 //BA.debugLineNum = 4325380;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=4325381;
 //BA.debugLineNum = 4325381;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",ingresoestudiante.getObject());
RDebugUtils.currentLine=4325382;
 //BA.debugLineNum = 4325382;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tbl_estudiant";
_job._poststring /*String*/ (null,_apiaddress,"UPDATE tbl_estudiante SET contrasena_e='"+mostCurrent._txtconnuve.getText()+"' WHERE contrasena_e='"+mostCurrent._txtconacte.getText()+"'");
 }else {
RDebugUtils.currentLine=4325384;
 //BA.debugLineNum = 4325384;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Las contraseñas deben coincidir"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
 }else {
RDebugUtils.currentLine=4325387;
 //BA.debugLineNum = 4325387;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=4325389;
 //BA.debugLineNum = 4325389;BA.debugLine="End Sub";
return "";
}
public static String  _btncerrarestudiante_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncerrarestudiante_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncerrarestudiante_click", null));}
RDebugUtils.currentLine=4521984;
 //BA.debugLineNum = 4521984;BA.debugLine="Sub btncerrarestudiante_Click";
RDebugUtils.currentLine=4521985;
 //BA.debugLineNum = 4521985;BA.debugLine="StartActivity(perfiles)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._perfiles.getObject()));
RDebugUtils.currentLine=4521986;
 //BA.debugLineNum = 4521986;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4521987;
 //BA.debugLineNum = 4521987;BA.debugLine="End Sub";
return "";
}
public static String  _createnotificationchannel(int _importancelevel) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "createnotificationchannel", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "createnotificationchannel", new Object[] {_importancelevel}));}
anywheresoftware.b4a.phone.Phone _p = null;
anywheresoftware.b4j.object.JavaObject _ctxt = null;
String _channelid = "";
anywheresoftware.b4j.object.JavaObject _channel = null;
anywheresoftware.b4j.object.JavaObject _manager = null;
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub CreateNotificationChannel(ImportanceLevel As I";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="Dim p As Phone";
_p = new anywheresoftware.b4a.phone.Phone();
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="If p.SdkVersion >= 26 Then";
if (_p.getSdkVersion()>=26) { 
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="Dim ctxt As JavaObject";
_ctxt = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="ctxt.InitializeContext";
_ctxt.InitializeContext(processBA);
RDebugUtils.currentLine=4980741;
 //BA.debugLineNum = 4980741;BA.debugLine="Dim channelId As String = \"channel_\"& Importance";
_channelid = "channel_"+BA.NumberToString(_importancelevel);
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="Dim channel As JavaObject";
_channel = new anywheresoftware.b4j.object.JavaObject();
RDebugUtils.currentLine=4980743;
 //BA.debugLineNum = 4980743;BA.debugLine="channel.InitializeNewInstance(\"android.app.Notif";
_channel.InitializeNewInstance("android.app.NotificationChannel",new Object[]{(Object)(_channelid),(Object)(anywheresoftware.b4a.keywords.Common.Application.getLabelName()),(Object)(_importancelevel)});
RDebugUtils.currentLine=4980744;
 //BA.debugLineNum = 4980744;BA.debugLine="channel.RunMethod(\"setShowBadge\",Array(False))";
_channel.RunMethod("setShowBadge",new Object[]{(Object)(anywheresoftware.b4a.keywords.Common.False)});
RDebugUtils.currentLine=4980746;
 //BA.debugLineNum = 4980746;BA.debugLine="Dim manager As JavaObject = ctxt.RunMethod(\"getS";
_manager = new anywheresoftware.b4j.object.JavaObject();
_manager.setObject((java.lang.Object)(_ctxt.RunMethod("getSystemService",new Object[]{(Object)("notification")})));
RDebugUtils.currentLine=4980747;
 //BA.debugLineNum = 4980747;BA.debugLine="manager.RunMethod(\"createNotificationChannel\",Ar";
_manager.RunMethod("createNotificationChannel",new Object[]{(Object)(_channel.getObject())});
 };
RDebugUtils.currentLine=4980750;
 //BA.debugLineNum = 4980750;BA.debugLine="End Sub";
return "";
}
public static void  _enviare_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "enviare_click", false))
	 {Debug.delegate(mostCurrent.activityBA, "enviare_click", null); return;}
ResumableSub_EnviarE_Click rsub = new ResumableSub_EnviarE_Click(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_EnviarE_Click extends BA.ResumableSub {
public ResumableSub_EnviarE_Click(b4a.example.ingresoestudiante parent) {
this.parent = parent;
}
b4a.example.ingresoestudiante parent;
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
RDebugUtils.currentModule="ingresoestudiante";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="If contraseñaE.Text <> \"\" Then";
if (true) break;

case 1:
//if
this.state = 26;
if ((parent.mostCurrent._contraseñae.getText()).equals("") == false) { 
this.state = 3;
}else {
this.state = 25;
}if (true) break;

case 3:
//C
this.state = 4;
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="Try";
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
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/";
_apiaddress = "http://192.168.1.5/schooltime.php";
RDebugUtils.currentLine=4915204;
 //BA.debugLineNum = 4915204;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=4915205;
 //BA.debugLineNum = 4915205;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingresoestudiante.getObject());
RDebugUtils.currentLine=4915206;
 //BA.debugLineNum = 4915206;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","cedula","pin",parent.mostCurrent._contraseñae.getText(),"tabla","tbl_estudiante","codigo","codigo_g","cedula","id_estudiante"});
RDebugUtils.currentLine=4915207;
 //BA.debugLineNum = 4915207;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingresoestudiante", "enviare_click"), (Object)(_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=4915208;
 //BA.debugLineNum = 4915208;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=4915209;
 //BA.debugLineNum = 4915209;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=4915210;
 //BA.debugLineNum = 4915210;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=4915211;
 //BA.debugLineNum = 4915211;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=4915212;
 //BA.debugLineNum = 4915212;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=4915213;
 //BA.debugLineNum = 4915213;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=4915214;
 //BA.debugLineNum = 4915214;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=4915215;
 //BA.debugLineNum = 4915215;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=4915216;
 //BA.debugLineNum = 4915216;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=4915217;
 //BA.debugLineNum = 4915217;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("24915217",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=4915218;
 //BA.debugLineNum = 4915218;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=4915219;
 //BA.debugLineNum = 4915219;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=4915220;
 //BA.debugLineNum = 4915220;BA.debugLine="fila= tabla.Get(i)";
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=4915221;
 //BA.debugLineNum = 4915221;BA.debugLine="codigoE = fila.Get(\"codigo_g\")";
parent._codigoe = BA.ObjectToString(_fila.Get((Object)("codigo_g")));
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
RDebugUtils.currentLine=4915225;
 //BA.debugLineNum = 4915225;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("24915225",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=4915228;
 //BA.debugLineNum = 4915228;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("24915228",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
RDebugUtils.currentLine=4915230;
 //BA.debugLineNum = 4915230;BA.debugLine="inicio.Visible =False";
parent.mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4915231;
 //BA.debugLineNum = 4915231;BA.debugLine="Datos.Visible = False";
parent.mostCurrent._datos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 25:
//C
this.state = 26;
RDebugUtils.currentLine=4915233;
 //BA.debugLineNum = 4915233;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Necesitas este campo para el ingreso"),BA.ObjectToCharSequence("AVISO"),processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
RDebugUtils.currentLine=4915235;
 //BA.debugLineNum = 4915235;BA.debugLine="remoreE";
_remoree();
RDebugUtils.currentLine=4915236;
 //BA.debugLineNum = 4915236;BA.debugLine="End Sub";
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
public static void  _remoree() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "remoree", false))
	 {Debug.delegate(mostCurrent.activityBA, "remoree", null); return;}
ResumableSub_remoreE rsub = new ResumableSub_remoreE(null);
rsub.resume(processBA, null);
}
public static class ResumableSub_remoreE extends BA.ResumableSub {
public ResumableSub_remoreE(b4a.example.ingresoestudiante parent) {
this.parent = parent;
}
b4a.example.ingresoestudiante parent;
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
RDebugUtils.currentModule="ingresoestudiante";

    while (true) {
try {

        switch (state) {
            case -1:
return;

case 0:
//C
this.state = 1;
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="If eventos = 0 Then";
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
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="Anuncio.Visible = True";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
;
RDebugUtils.currentLine=5046278;
 //BA.debugLineNum = 5046278;BA.debugLine="Try";

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
RDebugUtils.currentLine=5046279;
 //BA.debugLineNum = 5046279;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.5/s";
_apiaddress = "http://192.168.1.5/schooltime.php";
RDebugUtils.currentLine=5046280;
 //BA.debugLineNum = 5046280;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=5046281;
 //BA.debugLineNum = 5046281;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingresoestudiante.getObject());
RDebugUtils.currentLine=5046282;
 //BA.debugLineNum = 5046282;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","evento","codigo",parent._codigoe,"quien","estudiante"});
RDebugUtils.currentLine=5046283;
 //BA.debugLineNum = 5046283;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingresoestudiante", "remoree"), (Object)(_js));
this.state = 174;
return;
case 174:
//C
this.state = 9;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=5046284;
 //BA.debugLineNum = 5046284;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=5046285;
 //BA.debugLineNum = 5046285;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=5046286;
 //BA.debugLineNum = 5046286;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=5046287;
 //BA.debugLineNum = 5046287;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=5046288;
 //BA.debugLineNum = 5046288;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=5046289;
 //BA.debugLineNum = 5046289;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=5046290;
 //BA.debugLineNum = 5046290;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=5046291;
 //BA.debugLineNum = 5046291;BA.debugLine="eventos = 1";
parent._eventos = (int) (1);
RDebugUtils.currentLine=5046292;
 //BA.debugLineNum = 5046292;BA.debugLine="If eventos = 1 Then";
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
RDebugUtils.currentLine=5046293;
 //BA.debugLineNum = 5046293;BA.debugLine="evento1E.Visible = True";
parent.mostCurrent._evento1e.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 18:
//C
this.state = 19;
;
RDebugUtils.currentLine=5046295;
 //BA.debugLineNum = 5046295;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5046296;
 //BA.debugLineNum = 5046296;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=5046297;
 //BA.debugLineNum = 5046297;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("25046297",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=5046298;
 //BA.debugLineNum = 5046298;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=5046299;
 //BA.debugLineNum = 5046299;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=5046300;
 //BA.debugLineNum = 5046300;BA.debugLine="fila= tabla.Get(i)";
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=5046301;
 //BA.debugLineNum = 5046301;BA.debugLine="titulo = fila.Get(\"titulo_e\")";
parent._titulo = BA.ObjectToString(_fila.Get((Object)("titulo_e")));
RDebugUtils.currentLine=5046302;
 //BA.debugLineNum = 5046302;BA.debugLine="descripcion = fila.Get(\"descripcion_e\")";
parent._descripcion = BA.ObjectToString(_fila.Get((Object)("descripcion_e")));
RDebugUtils.currentLine=5046303;
 //BA.debugLineNum = 5046303;BA.debugLine="c = fila.Get(\"codigo_g\")";
parent._c = BA.ObjectToString(_fila.Get((Object)("codigo_g")));
RDebugUtils.currentLine=5046304;
 //BA.debugLineNum = 5046304;BA.debugLine="fecha = fila.Get(\"fecha_evento\")";
parent._fecha = BA.ObjectToString(_fila.Get((Object)("fecha_evento")));
RDebugUtils.currentLine=5046305;
 //BA.debugLineNum = 5046305;BA.debugLine="hora = fila.Get(\"hora_evento\")";
parent._hora = BA.ObjectToString(_fila.Get((Object)("hora_evento")));
RDebugUtils.currentLine=5046306;
 //BA.debugLineNum = 5046306;BA.debugLine="tipo = fila.Get(\"id_tipo\")";
parent._tipo = BA.ObjectToString(_fila.Get((Object)("id_tipo")));
RDebugUtils.currentLine=5046307;
 //BA.debugLineNum = 5046307;BA.debugLine="If eventos =1 Then";
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
RDebugUtils.currentLine=5046308;
 //BA.debugLineNum = 5046308;BA.debugLine="tipo1 = tipo";
parent._tipo1 = parent._tipo;
RDebugUtils.currentLine=5046309;
 //BA.debugLineNum = 5046309;BA.debugLine="If tipo1 = \"00A\" Then";
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
RDebugUtils.currentLine=5046310;
 //BA.debugLineNum = 5046310;BA.debugLine="tipo1 = \"Celebración\"";
parent._tipo1 = "Celebración";
 if (true) break;

case 29:
//C
this.state = 30;
RDebugUtils.currentLine=5046312;
 //BA.debugLineNum = 5046312;BA.debugLine="If tipo1 = \"00B\" Then";
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
RDebugUtils.currentLine=5046313;
 //BA.debugLineNum = 5046313;BA.debugLine="tipo1 = \"Cambio\"";
parent._tipo1 = "Cambio";
 if (true) break;

case 34:
//C
this.state = 35;
RDebugUtils.currentLine=5046315;
 //BA.debugLineNum = 5046315;BA.debugLine="If tipo1 = \"00C\" Then";
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
RDebugUtils.currentLine=5046316;
 //BA.debugLineNum = 5046316;BA.debugLine="tipo1 = \"Reunión\"";
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
RDebugUtils.currentLine=5046320;
 //BA.debugLineNum = 5046320;BA.debugLine="Dim n As Notification";
_n = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=5046321;
 //BA.debugLineNum = 5046321;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH)";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5046322;
 //BA.debugLineNum = 5046322;BA.debugLine="n.Initialize2(n.IMPORTANCE_HIGH)";
_n.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5046323;
 //BA.debugLineNum = 5046323;BA.debugLine="n.Icon =\"icon\"";
_n.setIcon("icon");
RDebugUtils.currentLine=5046324;
 //BA.debugLineNum = 5046324;BA.debugLine="n.SetInfo(tipo1,\"Se llevará acabo el \"&fecha";
_n.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo1),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=5046325;
 //BA.debugLineNum = 5046325;BA.debugLine="n.Notify(1)";
_n.Notify((int) (1));
RDebugUtils.currentLine=5046326;
 //BA.debugLineNum = 5046326;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046327;
 //BA.debugLineNum = 5046327;BA.debugLine="evento2E.Visible = False";
parent.mostCurrent._evento2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046328;
 //BA.debugLineNum = 5046328;BA.debugLine="titulo1E.Text = titulo";
parent.mostCurrent._titulo1e.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=5046329;
 //BA.debugLineNum = 5046329;BA.debugLine="fecha1E.Text = fecha";
parent.mostCurrent._fecha1e.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=5046330;
 //BA.debugLineNum = 5046330;BA.debugLine="hora1E.Text = hora";
parent.mostCurrent._hora1e.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=5046331;
 //BA.debugLineNum = 5046331;BA.debugLine="desc1 = descripcion";
parent._desc1 = parent._descripcion;
RDebugUtils.currentLine=5046332;
 //BA.debugLineNum = 5046332;BA.debugLine="If tipo1 = \"Celebración\" Then";
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
RDebugUtils.currentLine=5046333;
 //BA.debugLineNum = 5046333;BA.debugLine="celebracion1E.Visible = True";
parent.mostCurrent._celebracion1e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046334;
 //BA.debugLineNum = 5046334;BA.debugLine="cambio1E.Visible = False";
parent.mostCurrent._cambio1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046335;
 //BA.debugLineNum = 5046335;BA.debugLine="reunion1E.Visible = False";
parent.mostCurrent._reunion1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 45:
//C
this.state = 46;
RDebugUtils.currentLine=5046337;
 //BA.debugLineNum = 5046337;BA.debugLine="If tipo1 = \"Cambio\" Then";
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
RDebugUtils.currentLine=5046338;
 //BA.debugLineNum = 5046338;BA.debugLine="celebracion1E.Visible = False";
parent.mostCurrent._celebracion1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046339;
 //BA.debugLineNum = 5046339;BA.debugLine="cambio1E.Visible = True";
parent.mostCurrent._cambio1e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046340;
 //BA.debugLineNum = 5046340;BA.debugLine="reunion1E.Visible = False";
parent.mostCurrent._reunion1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 50:
//C
this.state = 51;
RDebugUtils.currentLine=5046342;
 //BA.debugLineNum = 5046342;BA.debugLine="If tipo1 = \"Reunión\" Then";
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
RDebugUtils.currentLine=5046343;
 //BA.debugLineNum = 5046343;BA.debugLine="celebracion1E.Visible = False";
parent.mostCurrent._celebracion1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046344;
 //BA.debugLineNum = 5046344;BA.debugLine="cambio1E.Visible = False";
parent.mostCurrent._cambio1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046345;
 //BA.debugLineNum = 5046345;BA.debugLine="reunion1E.Visible = True";
parent.mostCurrent._reunion1e.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5046350;
 //BA.debugLineNum = 5046350;BA.debugLine="If eventos =2 Then";
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
RDebugUtils.currentLine=5046351;
 //BA.debugLineNum = 5046351;BA.debugLine="tipo2 = tipo";
parent._tipo2 = parent._tipo;
RDebugUtils.currentLine=5046352;
 //BA.debugLineNum = 5046352;BA.debugLine="If tipo2 = \"00A\" Then";
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
RDebugUtils.currentLine=5046353;
 //BA.debugLineNum = 5046353;BA.debugLine="tipo2 = \"Celebración\"";
parent._tipo2 = "Celebración";
 if (true) break;

case 66:
//C
this.state = 67;
RDebugUtils.currentLine=5046355;
 //BA.debugLineNum = 5046355;BA.debugLine="If tipo2 = \"00B\" Then";
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
RDebugUtils.currentLine=5046356;
 //BA.debugLineNum = 5046356;BA.debugLine="tipo2 = \"Cambio\"";
parent._tipo2 = "Cambio";
 if (true) break;

case 71:
//C
this.state = 72;
RDebugUtils.currentLine=5046358;
 //BA.debugLineNum = 5046358;BA.debugLine="If tipo2 = \"00C\" Then";
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
RDebugUtils.currentLine=5046359;
 //BA.debugLineNum = 5046359;BA.debugLine="tipo2 = \"Reunión\"";
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
RDebugUtils.currentLine=5046363;
 //BA.debugLineNum = 5046363;BA.debugLine="Dim n2 As Notification";
_n2 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=5046364;
 //BA.debugLineNum = 5046364;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5046365;
 //BA.debugLineNum = 5046365;BA.debugLine="n2.Initialize2(n.IMPORTANCE_HIGH)";
_n2.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5046366;
 //BA.debugLineNum = 5046366;BA.debugLine="n2.Icon =\"icon\"";
_n2.setIcon("icon");
RDebugUtils.currentLine=5046367;
 //BA.debugLineNum = 5046367;BA.debugLine="n2.SetInfo(tipo2,\"Se llevará acabo el \"&fec";
_n2.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo2),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=5046368;
 //BA.debugLineNum = 5046368;BA.debugLine="n2.Notify(2)";
_n2.Notify((int) (2));
RDebugUtils.currentLine=5046369;
 //BA.debugLineNum = 5046369;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046370;
 //BA.debugLineNum = 5046370;BA.debugLine="evento2E.Visible = True";
parent.mostCurrent._evento2e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046371;
 //BA.debugLineNum = 5046371;BA.debugLine="titulo2E.Text = titulo";
parent.mostCurrent._titulo2e.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=5046372;
 //BA.debugLineNum = 5046372;BA.debugLine="fecha2E.Text = fecha";
parent.mostCurrent._fecha2e.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=5046373;
 //BA.debugLineNum = 5046373;BA.debugLine="hora2E.Text = hora";
parent.mostCurrent._hora2e.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=5046374;
 //BA.debugLineNum = 5046374;BA.debugLine="desc2 = descripcion";
parent._desc2 = parent._descripcion;
RDebugUtils.currentLine=5046375;
 //BA.debugLineNum = 5046375;BA.debugLine="If tipo2 = \"Celebración\" Then";
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
RDebugUtils.currentLine=5046376;
 //BA.debugLineNum = 5046376;BA.debugLine="celebracion2E.Visible = True";
parent.mostCurrent._celebracion2e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046377;
 //BA.debugLineNum = 5046377;BA.debugLine="cambio2E.Visible = False";
parent.mostCurrent._cambio2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046378;
 //BA.debugLineNum = 5046378;BA.debugLine="reunion2E.Visible = False";
parent.mostCurrent._reunion2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 82:
//C
this.state = 83;
RDebugUtils.currentLine=5046380;
 //BA.debugLineNum = 5046380;BA.debugLine="If tipo2 = \"Cambio\" Then";
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
RDebugUtils.currentLine=5046381;
 //BA.debugLineNum = 5046381;BA.debugLine="celebracion2E.Visible = False";
parent.mostCurrent._celebracion2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046382;
 //BA.debugLineNum = 5046382;BA.debugLine="cambio2E.Visible = True";
parent.mostCurrent._cambio2e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046383;
 //BA.debugLineNum = 5046383;BA.debugLine="reunion2E.Visible = False";
parent.mostCurrent._reunion2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 87:
//C
this.state = 88;
RDebugUtils.currentLine=5046385;
 //BA.debugLineNum = 5046385;BA.debugLine="If tipo2 = \"Reunión\" Then";
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
RDebugUtils.currentLine=5046386;
 //BA.debugLineNum = 5046386;BA.debugLine="celebracion2E.Visible = False";
parent.mostCurrent._celebracion2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046387;
 //BA.debugLineNum = 5046387;BA.debugLine="cambio2E.Visible = False";
parent.mostCurrent._cambio2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046388;
 //BA.debugLineNum = 5046388;BA.debugLine="reunion2E.Visible = True";
parent.mostCurrent._reunion2e.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5046393;
 //BA.debugLineNum = 5046393;BA.debugLine="If eventos =3 Then";

case 94:
//if
this.state = 129;
if (parent._eventos==3) { 
this.state = 96;
}if (true) break;

case 96:
//C
this.state = 97;
RDebugUtils.currentLine=5046394;
 //BA.debugLineNum = 5046394;BA.debugLine="tipo3 = tipo";
parent._tipo3 = parent._tipo;
RDebugUtils.currentLine=5046395;
 //BA.debugLineNum = 5046395;BA.debugLine="If tipo3 = \"00A\" Then";
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
RDebugUtils.currentLine=5046396;
 //BA.debugLineNum = 5046396;BA.debugLine="tipo3 = \"Celebración\"";
parent._tipo3 = "Celebración";
 if (true) break;

case 101:
//C
this.state = 102;
RDebugUtils.currentLine=5046398;
 //BA.debugLineNum = 5046398;BA.debugLine="If tipo3 = \"00B\" Then";
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
RDebugUtils.currentLine=5046399;
 //BA.debugLineNum = 5046399;BA.debugLine="tipo3 = \"Cambio\"";
parent._tipo3 = "Cambio";
 if (true) break;

case 106:
//C
this.state = 107;
RDebugUtils.currentLine=5046401;
 //BA.debugLineNum = 5046401;BA.debugLine="If tipo3 = \"00C\" Then";
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
RDebugUtils.currentLine=5046402;
 //BA.debugLineNum = 5046402;BA.debugLine="tipo3 = \"Reunión\"";
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
RDebugUtils.currentLine=5046406;
 //BA.debugLineNum = 5046406;BA.debugLine="Dim n3 As Notification";
_n3 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=5046407;
 //BA.debugLineNum = 5046407;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5046408;
 //BA.debugLineNum = 5046408;BA.debugLine="n3.Initialize2(n.IMPORTANCE_HIGH)";
_n3.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5046409;
 //BA.debugLineNum = 5046409;BA.debugLine="n3.Icon =\"icon\"";
_n3.setIcon("icon");
RDebugUtils.currentLine=5046410;
 //BA.debugLineNum = 5046410;BA.debugLine="n3.SetInfo(tipo3,\"Se llevará acabo el \"&fec";
_n3.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo3),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=5046411;
 //BA.debugLineNum = 5046411;BA.debugLine="n3.Notify(3)";
_n3.Notify((int) (3));
RDebugUtils.currentLine=5046412;
 //BA.debugLineNum = 5046412;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046413;
 //BA.debugLineNum = 5046413;BA.debugLine="evento3E.Visible = True";
parent.mostCurrent._evento3e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046414;
 //BA.debugLineNum = 5046414;BA.debugLine="titulo3E.Text = titulo";
parent.mostCurrent._titulo3e.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=5046415;
 //BA.debugLineNum = 5046415;BA.debugLine="fecha3E.Text = fecha";
parent.mostCurrent._fecha3e.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=5046416;
 //BA.debugLineNum = 5046416;BA.debugLine="hora3E.Text = hora";
parent.mostCurrent._hora3e.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=5046417;
 //BA.debugLineNum = 5046417;BA.debugLine="desc3 = descripcion";
parent._desc3 = parent._descripcion;
RDebugUtils.currentLine=5046418;
 //BA.debugLineNum = 5046418;BA.debugLine="If tipo3 = \"Celebración\" Then";
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
RDebugUtils.currentLine=5046419;
 //BA.debugLineNum = 5046419;BA.debugLine="celebracion3E.Visible = True";
parent.mostCurrent._celebracion3e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046420;
 //BA.debugLineNum = 5046420;BA.debugLine="cambio3E.Visible = False";
parent.mostCurrent._cambio3e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046421;
 //BA.debugLineNum = 5046421;BA.debugLine="reunion3E.Visible = False";
parent.mostCurrent._reunion3e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 117:
//C
this.state = 118;
RDebugUtils.currentLine=5046423;
 //BA.debugLineNum = 5046423;BA.debugLine="If tipo3 = \"Cambio\" Then";
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
RDebugUtils.currentLine=5046424;
 //BA.debugLineNum = 5046424;BA.debugLine="celebracion3E.Visible = False";
parent.mostCurrent._celebracion3e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046425;
 //BA.debugLineNum = 5046425;BA.debugLine="cambio3E.Visible = True";
parent.mostCurrent._cambio3e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046426;
 //BA.debugLineNum = 5046426;BA.debugLine="reunion3E.Visible = False";
parent.mostCurrent._reunion3e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 122:
//C
this.state = 123;
RDebugUtils.currentLine=5046428;
 //BA.debugLineNum = 5046428;BA.debugLine="If tipo3 = \"Reunión\" Then";
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
RDebugUtils.currentLine=5046429;
 //BA.debugLineNum = 5046429;BA.debugLine="celebracion3E.Visible = False";
parent.mostCurrent._celebracion3e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046430;
 //BA.debugLineNum = 5046430;BA.debugLine="cambio3E.Visible = False";
parent.mostCurrent._cambio3e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046431;
 //BA.debugLineNum = 5046431;BA.debugLine="reunion3E.Visible = True";
parent.mostCurrent._reunion3e.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5046436;
 //BA.debugLineNum = 5046436;BA.debugLine="If eventos = 4 Then";

case 129:
//if
this.state = 164;
if (parent._eventos==4) { 
this.state = 131;
}if (true) break;

case 131:
//C
this.state = 132;
RDebugUtils.currentLine=5046437;
 //BA.debugLineNum = 5046437;BA.debugLine="tipo4 = tipo";
parent._tipo4 = parent._tipo;
RDebugUtils.currentLine=5046438;
 //BA.debugLineNum = 5046438;BA.debugLine="If tipo4 = \"00A\" Then";
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
RDebugUtils.currentLine=5046439;
 //BA.debugLineNum = 5046439;BA.debugLine="tipo4 = \"Celebración\"";
parent._tipo4 = "Celebración";
 if (true) break;

case 136:
//C
this.state = 137;
RDebugUtils.currentLine=5046441;
 //BA.debugLineNum = 5046441;BA.debugLine="If tipo4 = \"00B\" Then";
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
RDebugUtils.currentLine=5046442;
 //BA.debugLineNum = 5046442;BA.debugLine="tipo4 = \"Cambio\"";
parent._tipo4 = "Cambio";
 if (true) break;

case 141:
//C
this.state = 142;
RDebugUtils.currentLine=5046444;
 //BA.debugLineNum = 5046444;BA.debugLine="If tipo4 = \"00C\" Then";
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
RDebugUtils.currentLine=5046445;
 //BA.debugLineNum = 5046445;BA.debugLine="tipo4 = \"Reunión\"";
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
RDebugUtils.currentLine=5046449;
 //BA.debugLineNum = 5046449;BA.debugLine="Dim n4 As Notification";
_n4 = new anywheresoftware.b4a.objects.NotificationWrapper();
RDebugUtils.currentLine=5046450;
 //BA.debugLineNum = 5046450;BA.debugLine="CreateNotificationChannel(n.IMPORTANCE_HIGH";
_createnotificationchannel(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5046451;
 //BA.debugLineNum = 5046451;BA.debugLine="n4.Initialize2(n.IMPORTANCE_HIGH)";
_n4.Initialize2(_n.IMPORTANCE_HIGH);
RDebugUtils.currentLine=5046452;
 //BA.debugLineNum = 5046452;BA.debugLine="n4.Icon =\"icon\"";
_n4.setIcon("icon");
RDebugUtils.currentLine=5046453;
 //BA.debugLineNum = 5046453;BA.debugLine="n4.SetInfo(tipo4,\"Se llevará acabo el \"&fec";
_n4.SetInfoNew(processBA,BA.ObjectToCharSequence(parent._tipo4),BA.ObjectToCharSequence("Se llevará acabo el "+parent._fecha),(Object)(parent.mostCurrent._main.getObject()));
RDebugUtils.currentLine=5046454;
 //BA.debugLineNum = 5046454;BA.debugLine="n4.Notify(4)";
_n4.Notify((int) (4));
RDebugUtils.currentLine=5046455;
 //BA.debugLineNum = 5046455;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046456;
 //BA.debugLineNum = 5046456;BA.debugLine="evento4E.Visible = True";
parent.mostCurrent._evento4e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046457;
 //BA.debugLineNum = 5046457;BA.debugLine="titulo4E.Text = titulo";
parent.mostCurrent._titulo4e.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=5046458;
 //BA.debugLineNum = 5046458;BA.debugLine="fecha4E.Text = fecha";
parent.mostCurrent._fecha4e.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=5046459;
 //BA.debugLineNum = 5046459;BA.debugLine="hora4E.Text = hora";
parent.mostCurrent._hora4e.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=5046460;
 //BA.debugLineNum = 5046460;BA.debugLine="desc4 = descripcion";
parent._desc4 = parent._descripcion;
RDebugUtils.currentLine=5046461;
 //BA.debugLineNum = 5046461;BA.debugLine="If tipo4 = \"Celebración\" Then";
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
RDebugUtils.currentLine=5046462;
 //BA.debugLineNum = 5046462;BA.debugLine="celebracion4E.Visible = True";
parent.mostCurrent._celebracion4e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046463;
 //BA.debugLineNum = 5046463;BA.debugLine="cambio4E.Visible = False";
parent.mostCurrent._cambio4e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046464;
 //BA.debugLineNum = 5046464;BA.debugLine="reunion4E.Visible = False";
parent.mostCurrent._reunion4e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 152:
//C
this.state = 153;
RDebugUtils.currentLine=5046466;
 //BA.debugLineNum = 5046466;BA.debugLine="If tipo4 = \"Cambio\" Then";
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
RDebugUtils.currentLine=5046467;
 //BA.debugLineNum = 5046467;BA.debugLine="celebracion4E.Visible = False";
parent.mostCurrent._celebracion4e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046468;
 //BA.debugLineNum = 5046468;BA.debugLine="cambio4E.Visible = True";
parent.mostCurrent._cambio4e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5046469;
 //BA.debugLineNum = 5046469;BA.debugLine="reunion4E.Visible = False";
parent.mostCurrent._reunion4e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 157:
//C
this.state = 158;
RDebugUtils.currentLine=5046471;
 //BA.debugLineNum = 5046471;BA.debugLine="If tipo4 = \"Reunión\" Then";
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
RDebugUtils.currentLine=5046472;
 //BA.debugLineNum = 5046472;BA.debugLine="celebracion4E.Visible = False";
parent.mostCurrent._celebracion4e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046473;
 //BA.debugLineNum = 5046473;BA.debugLine="cambio4E.Visible = False";
parent.mostCurrent._cambio4e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046474;
 //BA.debugLineNum = 5046474;BA.debugLine="reunion4E.Visible = True";
parent.mostCurrent._reunion4e.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5046480;
 //BA.debugLineNum = 5046480;BA.debugLine="eventos = eventos  + 1";
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
RDebugUtils.currentLine=5046484;
 //BA.debugLineNum = 5046484;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("25046484",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=5046487;
 //BA.debugLineNum = 5046487;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("25046487",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 173:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=5046489;
 //BA.debugLineNum = 5046489;BA.debugLine="End Sub";
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
public static String  _evento1e_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento1e_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento1e_click", null));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub evento1E_Click";
RDebugUtils.currentLine=4718593;
 //BA.debugLineNum = 4718593;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718595;
 //BA.debugLineNum = 4718595;BA.debugLine="evento11E.Visible = True";
mostCurrent._evento11e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718596;
 //BA.debugLineNum = 4718596;BA.debugLine="titulo11E.Text = titulo1E.Text";
mostCurrent._titulo11e.setText(BA.ObjectToCharSequence(mostCurrent._titulo1e.getText()));
RDebugUtils.currentLine=4718597;
 //BA.debugLineNum = 4718597;BA.debugLine="fecha11E.Text = fecha1E.Text";
mostCurrent._fecha11e.setText(BA.ObjectToCharSequence(mostCurrent._fecha1e.getText()));
RDebugUtils.currentLine=4718598;
 //BA.debugLineNum = 4718598;BA.debugLine="hora11E.Text = hora1E.Text";
mostCurrent._hora11e.setText(BA.ObjectToCharSequence(mostCurrent._hora1e.getText()));
RDebugUtils.currentLine=4718599;
 //BA.debugLineNum = 4718599;BA.debugLine="desc11E.Text = desc1";
mostCurrent._desc11e.setText(BA.ObjectToCharSequence(_desc1));
RDebugUtils.currentLine=4718600;
 //BA.debugLineNum = 4718600;BA.debugLine="If tipo1 = \"Celebración\" Then";
if ((_tipo1).equals("Celebración")) { 
RDebugUtils.currentLine=4718601;
 //BA.debugLineNum = 4718601;BA.debugLine="celebracion11E.Visible = True";
mostCurrent._celebracion11e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718602;
 //BA.debugLineNum = 4718602;BA.debugLine="cambio11E.Visible = False";
mostCurrent._cambio11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4718603;
 //BA.debugLineNum = 4718603;BA.debugLine="reunion11E.Visible = False";
mostCurrent._reunion11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4718605;
 //BA.debugLineNum = 4718605;BA.debugLine="If tipo1 = \"Reunión\" Then";
if ((_tipo1).equals("Reunión")) { 
RDebugUtils.currentLine=4718606;
 //BA.debugLineNum = 4718606;BA.debugLine="celebracion11E.Visible = False";
mostCurrent._celebracion11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4718607;
 //BA.debugLineNum = 4718607;BA.debugLine="cambio11E.Visible = False";
mostCurrent._cambio11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4718608;
 //BA.debugLineNum = 4718608;BA.debugLine="reunion11E.Visible = True";
mostCurrent._reunion11e.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4718610;
 //BA.debugLineNum = 4718610;BA.debugLine="If tipo1 = \"Cambio\" Then";
if ((_tipo1).equals("Cambio")) { 
RDebugUtils.currentLine=4718611;
 //BA.debugLineNum = 4718611;BA.debugLine="celebracion11E.Visible = False";
mostCurrent._celebracion11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4718612;
 //BA.debugLineNum = 4718612;BA.debugLine="cambio11E.Visible = True";
mostCurrent._cambio11e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4718613;
 //BA.debugLineNum = 4718613;BA.debugLine="reunion11E.Visible = False";
mostCurrent._reunion11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=4718617;
 //BA.debugLineNum = 4718617;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=4718619;
 //BA.debugLineNum = 4718619;BA.debugLine="End Sub";
return "";
}
public static String  _evento2e_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento2e_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento2e_click", null));}
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub evento2E_Click";
RDebugUtils.currentLine=4784129;
 //BA.debugLineNum = 4784129;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4784131;
 //BA.debugLineNum = 4784131;BA.debugLine="evento22E.Visible = True";
mostCurrent._evento22e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4784132;
 //BA.debugLineNum = 4784132;BA.debugLine="titulo22E.Text = titulo2E.Text";
mostCurrent._titulo22e.setText(BA.ObjectToCharSequence(mostCurrent._titulo2e.getText()));
RDebugUtils.currentLine=4784133;
 //BA.debugLineNum = 4784133;BA.debugLine="fecha22E.Text = fecha2E.Text";
mostCurrent._fecha22e.setText(BA.ObjectToCharSequence(mostCurrent._fecha2e.getText()));
RDebugUtils.currentLine=4784134;
 //BA.debugLineNum = 4784134;BA.debugLine="hora22E.Text = hora2E.Text";
mostCurrent._hora22e.setText(BA.ObjectToCharSequence(mostCurrent._hora2e.getText()));
RDebugUtils.currentLine=4784135;
 //BA.debugLineNum = 4784135;BA.debugLine="descripcion22E.Text = desc2";
mostCurrent._descripcion22e.setText(BA.ObjectToCharSequence(_desc2));
RDebugUtils.currentLine=4784136;
 //BA.debugLineNum = 4784136;BA.debugLine="If tipo2 = \"Celebración\" Then";
if ((_tipo2).equals("Celebración")) { 
RDebugUtils.currentLine=4784137;
 //BA.debugLineNum = 4784137;BA.debugLine="celebracion22E.Visible = True";
mostCurrent._celebracion22e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4784138;
 //BA.debugLineNum = 4784138;BA.debugLine="cambio22E.Visible = False";
mostCurrent._cambio22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4784139;
 //BA.debugLineNum = 4784139;BA.debugLine="reunion22E.Visible = False";
mostCurrent._reunion22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4784141;
 //BA.debugLineNum = 4784141;BA.debugLine="If tipo2 = \"Reunión\" Then";
if ((_tipo2).equals("Reunión")) { 
RDebugUtils.currentLine=4784142;
 //BA.debugLineNum = 4784142;BA.debugLine="celebracion22E.Visible = False";
mostCurrent._celebracion22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4784143;
 //BA.debugLineNum = 4784143;BA.debugLine="cambio22E.Visible = False";
mostCurrent._cambio22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4784144;
 //BA.debugLineNum = 4784144;BA.debugLine="reunion22E.Visible = True";
mostCurrent._reunion22e.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4784146;
 //BA.debugLineNum = 4784146;BA.debugLine="If tipo2 = \"Cambio\" Then";
if ((_tipo2).equals("Cambio")) { 
RDebugUtils.currentLine=4784147;
 //BA.debugLineNum = 4784147;BA.debugLine="celebracion22E.Visible = False";
mostCurrent._celebracion22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4784148;
 //BA.debugLineNum = 4784148;BA.debugLine="cambio22E.Visible = True";
mostCurrent._cambio22e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4784149;
 //BA.debugLineNum = 4784149;BA.debugLine="reunion22E.Visible = False";
mostCurrent._reunion22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=4784153;
 //BA.debugLineNum = 4784153;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=4784155;
 //BA.debugLineNum = 4784155;BA.debugLine="End Sub";
return "";
}
public static String  _evento3e_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento3e_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento3e_click", null));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub evento3E_Click";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="evento33E.Visible = True";
mostCurrent._evento33e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="titulo33E.Text = titulo3E.Text";
mostCurrent._titulo33e.setText(BA.ObjectToCharSequence(mostCurrent._titulo3e.getText()));
RDebugUtils.currentLine=4849669;
 //BA.debugLineNum = 4849669;BA.debugLine="fecha33E.Text = fecha3E.Text";
mostCurrent._fecha33e.setText(BA.ObjectToCharSequence(mostCurrent._fecha3e.getText()));
RDebugUtils.currentLine=4849670;
 //BA.debugLineNum = 4849670;BA.debugLine="hora33E.Text = hora3E.Text";
mostCurrent._hora33e.setText(BA.ObjectToCharSequence(mostCurrent._hora3e.getText()));
RDebugUtils.currentLine=4849671;
 //BA.debugLineNum = 4849671;BA.debugLine="descripcion33E.Text = desc3";
mostCurrent._descripcion33e.setText(BA.ObjectToCharSequence(_desc3));
RDebugUtils.currentLine=4849672;
 //BA.debugLineNum = 4849672;BA.debugLine="If tipo3 = \"Celebración\" Then";
if ((_tipo3).equals("Celebración")) { 
RDebugUtils.currentLine=4849673;
 //BA.debugLineNum = 4849673;BA.debugLine="celebracion33E.Visible = True";
mostCurrent._celebracion33e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4849674;
 //BA.debugLineNum = 4849674;BA.debugLine="cambio33E.Visible = False";
mostCurrent._cambio33e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849675;
 //BA.debugLineNum = 4849675;BA.debugLine="reunion33E.Visible = False";
mostCurrent._reunion33e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=4849677;
 //BA.debugLineNum = 4849677;BA.debugLine="If tipo3 = \"Reunión\" Then";
if ((_tipo3).equals("Reunión")) { 
RDebugUtils.currentLine=4849678;
 //BA.debugLineNum = 4849678;BA.debugLine="celebracion33E.Visible = False";
mostCurrent._celebracion33e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849679;
 //BA.debugLineNum = 4849679;BA.debugLine="cambio33E.Visible = False";
mostCurrent._cambio33e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849680;
 //BA.debugLineNum = 4849680;BA.debugLine="reunion33E.Visible = True";
mostCurrent._reunion33e.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=4849682;
 //BA.debugLineNum = 4849682;BA.debugLine="If tipo3 = \"Cambio\" Then";
if ((_tipo3).equals("Cambio")) { 
RDebugUtils.currentLine=4849683;
 //BA.debugLineNum = 4849683;BA.debugLine="celebracion33E.Visible = False";
mostCurrent._celebracion33e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4849684;
 //BA.debugLineNum = 4849684;BA.debugLine="cambio33E.Visible = True";
mostCurrent._cambio33e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4849685;
 //BA.debugLineNum = 4849685;BA.debugLine="reunion33E.Visible = False";
mostCurrent._reunion33e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=4849689;
 //BA.debugLineNum = 4849689;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=4849691;
 //BA.debugLineNum = 4849691;BA.debugLine="End Sub";
return "";
}
public static String  _evento4e_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento4e_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento4e_click", null));}
RDebugUtils.currentLine=13434880;
 //BA.debugLineNum = 13434880;BA.debugLine="Sub evento4E_Click";
RDebugUtils.currentLine=13434881;
 //BA.debugLineNum = 13434881;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=13434882;
 //BA.debugLineNum = 13434882;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13434883;
 //BA.debugLineNum = 13434883;BA.debugLine="evento44E.Visible = True";
mostCurrent._evento44e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13434884;
 //BA.debugLineNum = 13434884;BA.debugLine="titulo44E.Text = titulo4E.Text";
mostCurrent._titulo44e.setText(BA.ObjectToCharSequence(mostCurrent._titulo4e.getText()));
RDebugUtils.currentLine=13434885;
 //BA.debugLineNum = 13434885;BA.debugLine="fecha44E.Text = fecha4E.Text";
mostCurrent._fecha44e.setText(BA.ObjectToCharSequence(mostCurrent._fecha4e.getText()));
RDebugUtils.currentLine=13434886;
 //BA.debugLineNum = 13434886;BA.debugLine="hora44E.Text = hora4E.Text";
mostCurrent._hora44e.setText(BA.ObjectToCharSequence(mostCurrent._hora4e.getText()));
RDebugUtils.currentLine=13434887;
 //BA.debugLineNum = 13434887;BA.debugLine="descripcion44E.Text = desc4";
mostCurrent._descripcion44e.setText(BA.ObjectToCharSequence(_desc4));
RDebugUtils.currentLine=13434888;
 //BA.debugLineNum = 13434888;BA.debugLine="If tipo4 = \"Celebración\" Then";
if ((_tipo4).equals("Celebración")) { 
RDebugUtils.currentLine=13434889;
 //BA.debugLineNum = 13434889;BA.debugLine="celebracion44E.Visible = True";
mostCurrent._celebracion44e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13434890;
 //BA.debugLineNum = 13434890;BA.debugLine="cambio44E.Visible = False";
mostCurrent._cambio44e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13434891;
 //BA.debugLineNum = 13434891;BA.debugLine="reunion44E.Visible = False";
mostCurrent._reunion44e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=13434893;
 //BA.debugLineNum = 13434893;BA.debugLine="If tipo4 = \"Reunión\" Then";
if ((_tipo4).equals("Reunión")) { 
RDebugUtils.currentLine=13434894;
 //BA.debugLineNum = 13434894;BA.debugLine="celebracion44E.Visible = False";
mostCurrent._celebracion44e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13434895;
 //BA.debugLineNum = 13434895;BA.debugLine="cambio44E.Visible = False";
mostCurrent._cambio44e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13434896;
 //BA.debugLineNum = 13434896;BA.debugLine="reunion44E.Visible = True";
mostCurrent._reunion44e.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=13434898;
 //BA.debugLineNum = 13434898;BA.debugLine="If tipo4 = \"Cambio\" Then";
if ((_tipo4).equals("Cambio")) { 
RDebugUtils.currentLine=13434899;
 //BA.debugLineNum = 13434899;BA.debugLine="celebracion44E.Visible = False";
mostCurrent._celebracion44e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=13434900;
 //BA.debugLineNum = 13434900;BA.debugLine="cambio44E.Visible = True";
mostCurrent._cambio44e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=13434901;
 //BA.debugLineNum = 13434901;BA.debugLine="reunion44E.Visible = False";
mostCurrent._reunion44e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=13434905;
 //BA.debugLineNum = 13434905;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=13434907;
 //BA.debugLineNum = 13434907;BA.debugLine="End Sub";
return "";
}
public static String  _inicio_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inicio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "inicio_click", null));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub inicio_Click";
RDebugUtils.currentLine=4653057;
 //BA.debugLineNum = 4653057;BA.debugLine="If event = 1 Then";
if (_event==1) { 
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="evento44E.Visible= False";
mostCurrent._evento44e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="evento33E.Visible= False";
mostCurrent._evento33e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="evento22E.Visible = False";
mostCurrent._evento22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653062;
 //BA.debugLineNum = 4653062;BA.debugLine="evento11E.Visible = False";
mostCurrent._evento11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653063;
 //BA.debugLineNum = 4653063;BA.debugLine="event = 0";
_event = (int) (0);
 };
RDebugUtils.currentLine=4653065;
 //BA.debugLineNum = 4653065;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=4390912;
 //BA.debugLineNum = 4390912;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=4390913;
 //BA.debugLineNum = 4390913;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=4390914;
 //BA.debugLineNum = 4390914;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
anywheresoftware.b4a.keywords.Common.LogImpl("24390914","OK, se actualizó correctamente",0);
RDebugUtils.currentLine=4390915;
 //BA.debugLineNum = 4390915;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito"),BA.ObjectToCharSequence("AVISO"),processBA);
RDebugUtils.currentLine=4390916;
 //BA.debugLineNum = 4390916;BA.debugLine="txtconactE.Text=\"\"";
mostCurrent._txtconacte.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4390917;
 //BA.debugLineNum = 4390917;BA.debugLine="txtconnuvE.Text=\"\"";
mostCurrent._txtconnuve.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4390918;
 //BA.debugLineNum = 4390918;BA.debugLine="txtconfconE.Text=\"\"";
mostCurrent._txtconfcone.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=4390919;
 //BA.debugLineNum = 4390919;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390920;
 //BA.debugLineNum = 4390920;BA.debugLine="inicio.Visible=False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4390921;
 //BA.debugLineNum = 4390921;BA.debugLine="estado=0";
_estado = (int) (0);
 }else {
RDebugUtils.currentLine=4390923;
 //BA.debugLineNum = 4390923;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("24390923",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=4390924;
 //BA.debugLineNum = 4390924;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=4390926;
 //BA.debugLineNum = 4390926;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=4390927;
 //BA.debugLineNum = 4390927;BA.debugLine="End Sub";
return "";
}
public static String  _retroceder_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "retroceder_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "retroceder_click", null));}
RDebugUtils.currentLine=4456448;
 //BA.debugLineNum = 4456448;BA.debugLine="Sub retroceder_Click";
RDebugUtils.currentLine=4456449;
 //BA.debugLineNum = 4456449;BA.debugLine="If estado = 1 Then";
if (_estado==1) { 
RDebugUtils.currentLine=4456450;
 //BA.debugLineNum = 4456450;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456451;
 //BA.debugLineNum = 4456451;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4456452;
 //BA.debugLineNum = 4456452;BA.debugLine="estado = 0";
_estado = (int) (0);
 };
RDebugUtils.currentLine=4456454;
 //BA.debugLineNum = 4456454;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfcone_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfcone_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfcone_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4259840;
 //BA.debugLineNum = 4259840;BA.debugLine="Sub txtconfconE_TextChanged (Old As String, New As";
RDebugUtils.currentLine=4259841;
 //BA.debugLineNum = 4259841;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=4259842;
 //BA.debugLineNum = 4259842;BA.debugLine="MsgboxAsync(\"La confirmación de la contraseña no";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La confirmación de la contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=4259844;
 //BA.debugLineNum = 4259844;BA.debugLine="End Sub";
return "";
}
public static String  _txtconnuve_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconnuve_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconnuve_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=4194304;
 //BA.debugLineNum = 4194304;BA.debugLine="Sub txtconnuvE_TextChanged (Old As String, New As";
RDebugUtils.currentLine=4194305;
 //BA.debugLineNum = 4194305;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=4194306;
 //BA.debugLineNum = 4194306;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=4194308;
 //BA.debugLineNum = 4194308;BA.debugLine="End Sub";
return "";
}
}
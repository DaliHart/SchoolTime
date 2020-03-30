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
public static String _codigoe = "";
public static String _desc1 = "";
public static String _desc2 = "";
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
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.perfiles _perfiles = null;
public b4a.example.iniciodocente _iniciodocente = null;
public b4a.example.registrodocente _registrodocente = null;
public b4a.example.ingresodocente _ingresodocente = null;
public b4a.example.ingreso _ingreso = null;
public b4a.example.inicioacudiente _inicioacudiente = null;
public b4a.example.inicioestudiante _inicioestudiante = null;
public b4a.example.registroacudiente _registroacudiente = null;
public b4a.example.registroestudiante _registroestudiante = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=5767168;
 //BA.debugLineNum = 5767168;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=5767170;
 //BA.debugLineNum = 5767170;BA.debugLine="Activity.LoadLayout(\"ingresoEstudiante\")";
mostCurrent._activity.LoadLayout("ingresoEstudiante",mostCurrent.activityBA);
RDebugUtils.currentLine=5767171;
 //BA.debugLineNum = 5767171;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"eventoE\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"EVENTOS","eventoE");
RDebugUtils.currentLine=5767172;
 //BA.debugLineNum = 5767172;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfilE\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"PERFIL","perfilE");
RDebugUtils.currentLine=5767173;
 //BA.debugLineNum = 5767173;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5767174;
 //BA.debugLineNum = 5767174;BA.debugLine="inicio.Visible=True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5767175;
 //BA.debugLineNum = 5767175;BA.debugLine="evento1E.Visible=False";
mostCurrent._evento1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5767176;
 //BA.debugLineNum = 5767176;BA.debugLine="evento2E.Visible=False";
mostCurrent._evento2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5767177;
 //BA.debugLineNum = 5767177;BA.debugLine="evento11E.Visible=False";
mostCurrent._evento11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5767178;
 //BA.debugLineNum = 5767178;BA.debugLine="evento22E.Visible=False";
mostCurrent._evento22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5767179;
 //BA.debugLineNum = 5767179;BA.debugLine="Anuncio.Visible=False";
mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5767180;
 //BA.debugLineNum = 5767180;BA.debugLine="eventos = 0";
_eventos = (int) (0);
RDebugUtils.currentLine=5767181;
 //BA.debugLineNum = 5767181;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
RDebugUtils.currentLine=5898240;
 //BA.debugLineNum = 5898240;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=5898242;
 //BA.debugLineNum = 5898242;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=5832704;
 //BA.debugLineNum = 5832704;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=5832706;
 //BA.debugLineNum = 5832706;BA.debugLine="End Sub";
return "";
}
public static String  _btncambiarestudiante_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambiarestudiante_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambiarestudiante_click", null));}
RDebugUtils.currentLine=6356992;
 //BA.debugLineNum = 6356992;BA.debugLine="Sub btncambiarestudiante_Click";
RDebugUtils.currentLine=6356993;
 //BA.debugLineNum = 6356993;BA.debugLine="If estado = 0 Then";
if (_estado==0) { 
RDebugUtils.currentLine=6356994;
 //BA.debugLineNum = 6356994;BA.debugLine="Panel1.Visible = True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6356995;
 //BA.debugLineNum = 6356995;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6356996;
 //BA.debugLineNum = 6356996;BA.debugLine="estado = 1";
_estado = (int) (1);
 };
RDebugUtils.currentLine=6356998;
 //BA.debugLineNum = 6356998;BA.debugLine="End Sub";
return "";
}
public static String  _btncambioe_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambioe_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambioe_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=6094848;
 //BA.debugLineNum = 6094848;BA.debugLine="Sub btncambioE_Click";
RDebugUtils.currentLine=6094849;
 //BA.debugLineNum = 6094849;BA.debugLine="If txtconactE.Text<>\"\" And txtconnuvE.Text<>\"\" An";
if ((mostCurrent._txtconacte.getText()).equals("") == false && (mostCurrent._txtconnuve.getText()).equals("") == false && (mostCurrent._txtconfcone.getText()).equals("") == false) { 
RDebugUtils.currentLine=6094850;
 //BA.debugLineNum = 6094850;BA.debugLine="If txtconnuvE.Text = txtconfconE.Text Then";
if ((mostCurrent._txtconnuve.getText()).equals(mostCurrent._txtconfcone.getText())) { 
RDebugUtils.currentLine=6094851;
 //BA.debugLineNum = 6094851;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
_apiaddress = "http://192.168.1.3/schooltime1.php";
RDebugUtils.currentLine=6094852;
 //BA.debugLineNum = 6094852;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=6094853;
 //BA.debugLineNum = 6094853;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",ingresoestudiante.getObject());
RDebugUtils.currentLine=6094854;
 //BA.debugLineNum = 6094854;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tblregistroes";
_job._poststring /*String*/ (null,_apiaddress,"UPDATE tblregistroestudiante SET contrasenaEstudiante='"+mostCurrent._txtconnuve.getText()+"' WHERE contrasenaEstudiante='"+mostCurrent._txtconacte.getText()+"'");
 }else {
RDebugUtils.currentLine=6094856;
 //BA.debugLineNum = 6094856;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Las contraseñas deben coincidir"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
 }else {
RDebugUtils.currentLine=6094859;
 //BA.debugLineNum = 6094859;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=6094861;
 //BA.debugLineNum = 6094861;BA.debugLine="End Sub";
return "";
}
public static String  _btncerrarestudiante_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncerrarestudiante_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncerrarestudiante_click", null));}
RDebugUtils.currentLine=6291456;
 //BA.debugLineNum = 6291456;BA.debugLine="Sub btncerrarestudiante_Click";
RDebugUtils.currentLine=6291457;
 //BA.debugLineNum = 6291457;BA.debugLine="StartActivity(perfiles)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._perfiles.getObject()));
RDebugUtils.currentLine=6291458;
 //BA.debugLineNum = 6291458;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=6291459;
 //BA.debugLineNum = 6291459;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=6619137;
 //BA.debugLineNum = 6619137;BA.debugLine="If contraseñaE.Text <> \"\" Then";
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
RDebugUtils.currentLine=6619138;
 //BA.debugLineNum = 6619138;BA.debugLine="Try";
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
RDebugUtils.currentLine=6619139;
 //BA.debugLineNum = 6619139;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
_apiaddress = "http://192.168.1.3/schooltime.php";
RDebugUtils.currentLine=6619140;
 //BA.debugLineNum = 6619140;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=6619141;
 //BA.debugLineNum = 6619141;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingresoestudiante.getObject());
RDebugUtils.currentLine=6619142;
 //BA.debugLineNum = 6619142;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","cedula","pin",parent.mostCurrent._contraseñae.getText(),"tabla","tblregistroestudiante","codigo","codigoGrupo","cedula","identificacionEstudiante"});
RDebugUtils.currentLine=6619143;
 //BA.debugLineNum = 6619143;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingresoestudiante", "enviare_click"), (Object)(_js));
this.state = 27;
return;
case 27:
//C
this.state = 7;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=6619144;
 //BA.debugLineNum = 6619144;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=6619145;
 //BA.debugLineNum = 6619145;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=6619146;
 //BA.debugLineNum = 6619146;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=6619147;
 //BA.debugLineNum = 6619147;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=6619148;
 //BA.debugLineNum = 6619148;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=6619149;
 //BA.debugLineNum = 6619149;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=6619150;
 //BA.debugLineNum = 6619150;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=6619151;
 //BA.debugLineNum = 6619151;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6619152;
 //BA.debugLineNum = 6619152;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=6619153;
 //BA.debugLineNum = 6619153;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("76619153",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=6619154;
 //BA.debugLineNum = 6619154;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=6619155;
 //BA.debugLineNum = 6619155;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=6619156;
 //BA.debugLineNum = 6619156;BA.debugLine="fila= tabla.Get(i)";
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=6619157;
 //BA.debugLineNum = 6619157;BA.debugLine="codigoE = fila.Get(\"codigoGrupo\")";
parent._codigoe = BA.ObjectToString(_fila.Get((Object)("codigoGrupo")));
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
RDebugUtils.currentLine=6619161;
 //BA.debugLineNum = 6619161;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("76619161",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=6619164;
 //BA.debugLineNum = 6619164;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("76619164",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 23:
//C
this.state = 26;
this.catchState = 0;
;
RDebugUtils.currentLine=6619166;
 //BA.debugLineNum = 6619166;BA.debugLine="inicio.Visible =False";
parent.mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6619167;
 //BA.debugLineNum = 6619167;BA.debugLine="Datos.Visible = False";
parent.mostCurrent._datos.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 25:
//C
this.state = 26;
RDebugUtils.currentLine=6619169;
 //BA.debugLineNum = 6619169;BA.debugLine="MsgboxAsync(\"Necesitas este campo para el ingres";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Necesitas este campo para el ingreso"),BA.ObjectToCharSequence("AVISO"),processBA);
 if (true) break;

case 26:
//C
this.state = -1;
;
RDebugUtils.currentLine=6619171;
 //BA.debugLineNum = 6619171;BA.debugLine="remoreE";
_remoree();
RDebugUtils.currentLine=6619172;
 //BA.debugLineNum = 6619172;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=6684673;
 //BA.debugLineNum = 6684673;BA.debugLine="If eventos = 0 Then";
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
RDebugUtils.currentLine=6684674;
 //BA.debugLineNum = 6684674;BA.debugLine="Anuncio.Visible = True";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=6684676;
 //BA.debugLineNum = 6684676;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
;
RDebugUtils.currentLine=6684678;
 //BA.debugLineNum = 6684678;BA.debugLine="Try";

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
RDebugUtils.currentLine=6684679;
 //BA.debugLineNum = 6684679;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/s";
_apiaddress = "http://192.168.1.3/schooltime.php";
RDebugUtils.currentLine=6684680;
 //BA.debugLineNum = 6684680;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=6684681;
 //BA.debugLineNum = 6684681;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingresoestudiante.getObject());
RDebugUtils.currentLine=6684682;
 //BA.debugLineNum = 6684682;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","evento","codigo",parent._codigoe});
RDebugUtils.currentLine=6684683;
 //BA.debugLineNum = 6684683;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingresoestudiante", "remoree"), (Object)(_js));
this.state = 72;
return;
case 72:
//C
this.state = 9;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=6684684;
 //BA.debugLineNum = 6684684;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=6684685;
 //BA.debugLineNum = 6684685;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=6684686;
 //BA.debugLineNum = 6684686;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=6684687;
 //BA.debugLineNum = 6684687;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=6684688;
 //BA.debugLineNum = 6684688;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=6684689;
 //BA.debugLineNum = 6684689;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=6684690;
 //BA.debugLineNum = 6684690;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=6684691;
 //BA.debugLineNum = 6684691;BA.debugLine="eventos = 1";
parent._eventos = (int) (1);
RDebugUtils.currentLine=6684692;
 //BA.debugLineNum = 6684692;BA.debugLine="If eventos = 1 Then";
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
RDebugUtils.currentLine=6684693;
 //BA.debugLineNum = 6684693;BA.debugLine="evento1E.Visible = True";
parent.mostCurrent._evento1e.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 18:
//C
this.state = 19;
;
RDebugUtils.currentLine=6684695;
 //BA.debugLineNum = 6684695;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=6684696;
 //BA.debugLineNum = 6684696;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=6684697;
 //BA.debugLineNum = 6684697;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("76684697",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=6684698;
 //BA.debugLineNum = 6684698;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=6684699;
 //BA.debugLineNum = 6684699;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=6684700;
 //BA.debugLineNum = 6684700;BA.debugLine="fila= tabla.Get(i)";
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=6684701;
 //BA.debugLineNum = 6684701;BA.debugLine="titulo = fila.Get(\"titulo\")";
parent._titulo = BA.ObjectToString(_fila.Get((Object)("titulo")));
RDebugUtils.currentLine=6684702;
 //BA.debugLineNum = 6684702;BA.debugLine="tipo = fila.Get(\"tipo\")";
parent._tipo = BA.ObjectToString(_fila.Get((Object)("tipo")));
RDebugUtils.currentLine=6684703;
 //BA.debugLineNum = 6684703;BA.debugLine="fecha = fila.Get(\"fecha\")";
parent._fecha = BA.ObjectToString(_fila.Get((Object)("fecha")));
RDebugUtils.currentLine=6684704;
 //BA.debugLineNum = 6684704;BA.debugLine="hora = fila.Get(\"hora\")";
parent._hora = BA.ObjectToString(_fila.Get((Object)("hora")));
RDebugUtils.currentLine=6684705;
 //BA.debugLineNum = 6684705;BA.debugLine="descripcion = fila.Get(\"descripcion\")";
parent._descripcion = BA.ObjectToString(_fila.Get((Object)("descripcion")));
RDebugUtils.currentLine=6684706;
 //BA.debugLineNum = 6684706;BA.debugLine="If eventos =1 Then";
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
RDebugUtils.currentLine=6684707;
 //BA.debugLineNum = 6684707;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684708;
 //BA.debugLineNum = 6684708;BA.debugLine="evento2E.Visible = False";
parent.mostCurrent._evento2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684709;
 //BA.debugLineNum = 6684709;BA.debugLine="titulo1E.Text = titulo";
parent.mostCurrent._titulo1e.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=6684710;
 //BA.debugLineNum = 6684710;BA.debugLine="fecha1E.Text = fecha";
parent.mostCurrent._fecha1e.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=6684711;
 //BA.debugLineNum = 6684711;BA.debugLine="tipo1 = tipo";
parent._tipo1 = parent._tipo;
RDebugUtils.currentLine=6684712;
 //BA.debugLineNum = 6684712;BA.debugLine="hora1E.Text = hora";
parent.mostCurrent._hora1e.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=6684713;
 //BA.debugLineNum = 6684713;BA.debugLine="desc1 = descripcion";
parent._desc1 = parent._descripcion;
RDebugUtils.currentLine=6684714;
 //BA.debugLineNum = 6684714;BA.debugLine="If tipo1 = \"Celebracion\" Then";
if (true) break;

case 25:
//if
this.state = 40;
if ((parent._tipo1).equals("Celebracion")) { 
this.state = 27;
}else {
this.state = 29;
}if (true) break;

case 27:
//C
this.state = 40;
RDebugUtils.currentLine=6684715;
 //BA.debugLineNum = 6684715;BA.debugLine="celebracion1E.Visible = True";
parent.mostCurrent._celebracion1e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6684716;
 //BA.debugLineNum = 6684716;BA.debugLine="cambio1E.Visible = False";
parent.mostCurrent._cambio1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684717;
 //BA.debugLineNum = 6684717;BA.debugLine="reunion1E.Visible = False";
parent.mostCurrent._reunion1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 29:
//C
this.state = 30;
RDebugUtils.currentLine=6684719;
 //BA.debugLineNum = 6684719;BA.debugLine="If tipo1 = \"Cambio\" Then";
if (true) break;

case 30:
//if
this.state = 39;
if ((parent._tipo1).equals("Cambio")) { 
this.state = 32;
}else {
this.state = 34;
}if (true) break;

case 32:
//C
this.state = 39;
RDebugUtils.currentLine=6684720;
 //BA.debugLineNum = 6684720;BA.debugLine="celebracion1E.Visible = False";
parent.mostCurrent._celebracion1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684721;
 //BA.debugLineNum = 6684721;BA.debugLine="cambio1E.Visible = True";
parent.mostCurrent._cambio1e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6684722;
 //BA.debugLineNum = 6684722;BA.debugLine="reunion1E.Visible = False";
parent.mostCurrent._reunion1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 34:
//C
this.state = 35;
RDebugUtils.currentLine=6684724;
 //BA.debugLineNum = 6684724;BA.debugLine="If tipo1 = \"Reunion\" Then";
if (true) break;

case 35:
//if
this.state = 38;
if ((parent._tipo1).equals("Reunion")) { 
this.state = 37;
}if (true) break;

case 37:
//C
this.state = 38;
RDebugUtils.currentLine=6684725;
 //BA.debugLineNum = 6684725;BA.debugLine="celebracion1E.Visible = False";
parent.mostCurrent._celebracion1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684726;
 //BA.debugLineNum = 6684726;BA.debugLine="cambio1E.Visible = False";
parent.mostCurrent._cambio1e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684727;
 //BA.debugLineNum = 6684727;BA.debugLine="reunion1E.Visible = True";
parent.mostCurrent._reunion1e.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=6684732;
 //BA.debugLineNum = 6684732;BA.debugLine="If eventos =2 Then";
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
RDebugUtils.currentLine=6684733;
 //BA.debugLineNum = 6684733;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684734;
 //BA.debugLineNum = 6684734;BA.debugLine="evento2E.Visible = True";
parent.mostCurrent._evento2e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6684735;
 //BA.debugLineNum = 6684735;BA.debugLine="titulo2E.Text = titulo";
parent.mostCurrent._titulo2e.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=6684736;
 //BA.debugLineNum = 6684736;BA.debugLine="fecha2E.Text = fecha";
parent.mostCurrent._fecha2e.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=6684737;
 //BA.debugLineNum = 6684737;BA.debugLine="tipo2 = tipo";
parent._tipo2 = parent._tipo;
RDebugUtils.currentLine=6684738;
 //BA.debugLineNum = 6684738;BA.debugLine="hora2E.Text = hora";
parent.mostCurrent._hora2e.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=6684739;
 //BA.debugLineNum = 6684739;BA.debugLine="desc2 = descripcion";
parent._desc2 = parent._descripcion;
RDebugUtils.currentLine=6684740;
 //BA.debugLineNum = 6684740;BA.debugLine="If tipo2 = \"Celebracion\" Then";
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
RDebugUtils.currentLine=6684741;
 //BA.debugLineNum = 6684741;BA.debugLine="celebracion2E.Visible = True";
parent.mostCurrent._celebracion2e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6684742;
 //BA.debugLineNum = 6684742;BA.debugLine="cambio2E.Visible = False";
parent.mostCurrent._cambio2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684743;
 //BA.debugLineNum = 6684743;BA.debugLine="reunion2E.Visible = False";
parent.mostCurrent._reunion2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 50:
//C
this.state = 51;
RDebugUtils.currentLine=6684745;
 //BA.debugLineNum = 6684745;BA.debugLine="If tipo2 = \"Cambio\" Then";
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
RDebugUtils.currentLine=6684746;
 //BA.debugLineNum = 6684746;BA.debugLine="celebracion2E.Visible = False";
parent.mostCurrent._celebracion2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684747;
 //BA.debugLineNum = 6684747;BA.debugLine="cambio2E.Visible = True";
parent.mostCurrent._cambio2e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6684748;
 //BA.debugLineNum = 6684748;BA.debugLine="reunion2E.Visible = False";
parent.mostCurrent._reunion2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 55:
//C
this.state = 56;
RDebugUtils.currentLine=6684750;
 //BA.debugLineNum = 6684750;BA.debugLine="If tipo2 = \"Reunion\" Then";
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
RDebugUtils.currentLine=6684751;
 //BA.debugLineNum = 6684751;BA.debugLine="celebracion2E.Visible = False";
parent.mostCurrent._celebracion2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684752;
 //BA.debugLineNum = 6684752;BA.debugLine="cambio2E.Visible = False";
parent.mostCurrent._cambio2e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6684753;
 //BA.debugLineNum = 6684753;BA.debugLine="reunion2E.Visible = True";
parent.mostCurrent._reunion2e.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=6684759;
 //BA.debugLineNum = 6684759;BA.debugLine="eventos = eventos  + 1";
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
RDebugUtils.currentLine=6684763;
 //BA.debugLineNum = 6684763;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("76684763",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=6684766;
 //BA.debugLineNum = 6684766;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("76684766",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 71:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=6684768;
 //BA.debugLineNum = 6684768;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=6488064;
 //BA.debugLineNum = 6488064;BA.debugLine="Sub evento1E_Click";
RDebugUtils.currentLine=6488065;
 //BA.debugLineNum = 6488065;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=6488066;
 //BA.debugLineNum = 6488066;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6488067;
 //BA.debugLineNum = 6488067;BA.debugLine="evento11E.Visible = True";
mostCurrent._evento11e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6488068;
 //BA.debugLineNum = 6488068;BA.debugLine="titulo11E.Text = titulo1E.Text";
mostCurrent._titulo11e.setText(BA.ObjectToCharSequence(mostCurrent._titulo1e.getText()));
RDebugUtils.currentLine=6488069;
 //BA.debugLineNum = 6488069;BA.debugLine="fecha11E.Text = fecha1E.Text";
mostCurrent._fecha11e.setText(BA.ObjectToCharSequence(mostCurrent._fecha1e.getText()));
RDebugUtils.currentLine=6488070;
 //BA.debugLineNum = 6488070;BA.debugLine="hora11E.Text = hora1E.Text";
mostCurrent._hora11e.setText(BA.ObjectToCharSequence(mostCurrent._hora1e.getText()));
RDebugUtils.currentLine=6488071;
 //BA.debugLineNum = 6488071;BA.debugLine="desc11E.Text = desc1";
mostCurrent._desc11e.setText(BA.ObjectToCharSequence(_desc1));
RDebugUtils.currentLine=6488072;
 //BA.debugLineNum = 6488072;BA.debugLine="If tipo1 = \"Celebracion\" Then";
if ((_tipo1).equals("Celebracion")) { 
RDebugUtils.currentLine=6488073;
 //BA.debugLineNum = 6488073;BA.debugLine="celebracion11E.Visible = True";
mostCurrent._celebracion11e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6488074;
 //BA.debugLineNum = 6488074;BA.debugLine="cambio11E.Visible = False";
mostCurrent._cambio11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6488075;
 //BA.debugLineNum = 6488075;BA.debugLine="reunion11E.Visible = False";
mostCurrent._reunion11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=6488077;
 //BA.debugLineNum = 6488077;BA.debugLine="If tipo1 = \"Reunion\" Then";
if ((_tipo1).equals("Reunion")) { 
RDebugUtils.currentLine=6488078;
 //BA.debugLineNum = 6488078;BA.debugLine="celebracion11E.Visible = False";
mostCurrent._celebracion11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6488079;
 //BA.debugLineNum = 6488079;BA.debugLine="cambio11E.Visible = False";
mostCurrent._cambio11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6488080;
 //BA.debugLineNum = 6488080;BA.debugLine="reunion11E.Visible = True";
mostCurrent._reunion11e.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=6488082;
 //BA.debugLineNum = 6488082;BA.debugLine="If tipo1 = \"Cambio\" Then";
if ((_tipo1).equals("Cambio")) { 
RDebugUtils.currentLine=6488083;
 //BA.debugLineNum = 6488083;BA.debugLine="celebracion11E.Visible = False";
mostCurrent._celebracion11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6488084;
 //BA.debugLineNum = 6488084;BA.debugLine="cambio11E.Visible = True";
mostCurrent._cambio11e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6488085;
 //BA.debugLineNum = 6488085;BA.debugLine="reunion11E.Visible = False";
mostCurrent._reunion11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=6488089;
 //BA.debugLineNum = 6488089;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=6488091;
 //BA.debugLineNum = 6488091;BA.debugLine="End Sub";
return "";
}
public static String  _evento2e_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento2e_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento2e_click", null));}
RDebugUtils.currentLine=6553600;
 //BA.debugLineNum = 6553600;BA.debugLine="Sub evento2E_Click";
RDebugUtils.currentLine=6553601;
 //BA.debugLineNum = 6553601;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=6553602;
 //BA.debugLineNum = 6553602;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6553603;
 //BA.debugLineNum = 6553603;BA.debugLine="evento22E.Visible = True";
mostCurrent._evento22e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6553604;
 //BA.debugLineNum = 6553604;BA.debugLine="titulo22E.Text = titulo2E.Text";
mostCurrent._titulo22e.setText(BA.ObjectToCharSequence(mostCurrent._titulo2e.getText()));
RDebugUtils.currentLine=6553605;
 //BA.debugLineNum = 6553605;BA.debugLine="fecha22E.Text = fecha2E.Text";
mostCurrent._fecha22e.setText(BA.ObjectToCharSequence(mostCurrent._fecha2e.getText()));
RDebugUtils.currentLine=6553606;
 //BA.debugLineNum = 6553606;BA.debugLine="hora22E.Text = hora2E.Text";
mostCurrent._hora22e.setText(BA.ObjectToCharSequence(mostCurrent._hora2e.getText()));
RDebugUtils.currentLine=6553607;
 //BA.debugLineNum = 6553607;BA.debugLine="descripcion22E.Text = desc2";
mostCurrent._descripcion22e.setText(BA.ObjectToCharSequence(_desc2));
RDebugUtils.currentLine=6553608;
 //BA.debugLineNum = 6553608;BA.debugLine="If tipo2 = \"Celebracion\" Then";
if ((_tipo2).equals("Celebracion")) { 
RDebugUtils.currentLine=6553609;
 //BA.debugLineNum = 6553609;BA.debugLine="celebracion22E.Visible = True";
mostCurrent._celebracion22e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6553610;
 //BA.debugLineNum = 6553610;BA.debugLine="cambio22E.Visible = False";
mostCurrent._cambio22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6553611;
 //BA.debugLineNum = 6553611;BA.debugLine="reunion22E.Visible = False";
mostCurrent._reunion22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=6553613;
 //BA.debugLineNum = 6553613;BA.debugLine="If tipo2 = \"Reunion\" Then";
if ((_tipo2).equals("Reunion")) { 
RDebugUtils.currentLine=6553614;
 //BA.debugLineNum = 6553614;BA.debugLine="celebracion22E.Visible = False";
mostCurrent._celebracion22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6553615;
 //BA.debugLineNum = 6553615;BA.debugLine="cambio22E.Visible = False";
mostCurrent._cambio22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6553616;
 //BA.debugLineNum = 6553616;BA.debugLine="reunion22E.Visible = True";
mostCurrent._reunion22e.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=6553618;
 //BA.debugLineNum = 6553618;BA.debugLine="If tipo2 = \"Cambio\" Then";
if ((_tipo2).equals("Cambio")) { 
RDebugUtils.currentLine=6553619;
 //BA.debugLineNum = 6553619;BA.debugLine="celebracion22E.Visible = False";
mostCurrent._celebracion22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6553620;
 //BA.debugLineNum = 6553620;BA.debugLine="cambio22E.Visible = True";
mostCurrent._cambio22e.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=6553621;
 //BA.debugLineNum = 6553621;BA.debugLine="reunion22E.Visible = False";
mostCurrent._reunion22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
 };
 };
 };
RDebugUtils.currentLine=6553625;
 //BA.debugLineNum = 6553625;BA.debugLine="event = 1";
_event = (int) (1);
 };
RDebugUtils.currentLine=6553627;
 //BA.debugLineNum = 6553627;BA.debugLine="End Sub";
return "";
}
public static String  _inicio_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inicio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "inicio_click", null));}
RDebugUtils.currentLine=6422528;
 //BA.debugLineNum = 6422528;BA.debugLine="Sub inicio_Click";
RDebugUtils.currentLine=6422529;
 //BA.debugLineNum = 6422529;BA.debugLine="If event = 1 Then";
if (_event==1) { 
RDebugUtils.currentLine=6422530;
 //BA.debugLineNum = 6422530;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6422531;
 //BA.debugLineNum = 6422531;BA.debugLine="evento22E.Visible = False";
mostCurrent._evento22e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6422532;
 //BA.debugLineNum = 6422532;BA.debugLine="evento11E.Visible = False";
mostCurrent._evento11e.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6422533;
 //BA.debugLineNum = 6422533;BA.debugLine="event = 0";
_event = (int) (0);
 };
RDebugUtils.currentLine=6422535;
 //BA.debugLineNum = 6422535;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=6160384;
 //BA.debugLineNum = 6160384;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=6160385;
 //BA.debugLineNum = 6160385;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=6160386;
 //BA.debugLineNum = 6160386;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
anywheresoftware.b4a.keywords.Common.LogImpl("76160386","OK, se actualizó correctamente",0);
RDebugUtils.currentLine=6160387;
 //BA.debugLineNum = 6160387;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito"),BA.ObjectToCharSequence("AVISO"),processBA);
RDebugUtils.currentLine=6160388;
 //BA.debugLineNum = 6160388;BA.debugLine="txtconactE.Text=\"\"";
mostCurrent._txtconacte.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=6160389;
 //BA.debugLineNum = 6160389;BA.debugLine="txtconnuvE.Text=\"\"";
mostCurrent._txtconnuve.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=6160390;
 //BA.debugLineNum = 6160390;BA.debugLine="txtconfconE.Text=\"\"";
mostCurrent._txtconfcone.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=6160391;
 //BA.debugLineNum = 6160391;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6160392;
 //BA.debugLineNum = 6160392;BA.debugLine="inicio.Visible=False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6160393;
 //BA.debugLineNum = 6160393;BA.debugLine="estado=0";
_estado = (int) (0);
 }else {
RDebugUtils.currentLine=6160395;
 //BA.debugLineNum = 6160395;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("76160395",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=6160396;
 //BA.debugLineNum = 6160396;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=6160398;
 //BA.debugLineNum = 6160398;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=6160399;
 //BA.debugLineNum = 6160399;BA.debugLine="End Sub";
return "";
}
public static String  _retroceder_click() throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "retroceder_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "retroceder_click", null));}
RDebugUtils.currentLine=6225920;
 //BA.debugLineNum = 6225920;BA.debugLine="Sub retroceder_Click";
RDebugUtils.currentLine=6225921;
 //BA.debugLineNum = 6225921;BA.debugLine="If estado = 1 Then";
if (_estado==1) { 
RDebugUtils.currentLine=6225922;
 //BA.debugLineNum = 6225922;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6225923;
 //BA.debugLineNum = 6225923;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=6225924;
 //BA.debugLineNum = 6225924;BA.debugLine="estado = 0";
_estado = (int) (0);
 };
RDebugUtils.currentLine=6225926;
 //BA.debugLineNum = 6225926;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfcone_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfcone_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfcone_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=6029312;
 //BA.debugLineNum = 6029312;BA.debugLine="Sub txtconfconE_TextChanged (Old As String, New As";
RDebugUtils.currentLine=6029313;
 //BA.debugLineNum = 6029313;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=6029314;
 //BA.debugLineNum = 6029314;BA.debugLine="MsgboxAsync(\"La confirmación de la contraseña no";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La confirmación de la contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=6029316;
 //BA.debugLineNum = 6029316;BA.debugLine="End Sub";
return "";
}
public static String  _txtconnuve_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingresoestudiante";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconnuve_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconnuve_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=5963776;
 //BA.debugLineNum = 5963776;BA.debugLine="Sub txtconnuvE_TextChanged (Old As String, New As";
RDebugUtils.currentLine=5963777;
 //BA.debugLineNum = 5963777;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=5963778;
 //BA.debugLineNum = 5963778;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=5963780;
 //BA.debugLineNum = 5963780;BA.debugLine="End Sub";
return "";
}
}
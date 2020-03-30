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
public static String _codigo = "";
public static String _desc1 = "";
public static String _desc2 = "";
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
public b4a.example.main _main = null;
public b4a.example.starter _starter = null;
public b4a.example.perfiles _perfiles = null;
public b4a.example.iniciodocente _iniciodocente = null;
public b4a.example.registrodocente _registrodocente = null;
public b4a.example.ingresodocente _ingresodocente = null;
public b4a.example.ingresoestudiante _ingresoestudiante = null;
public b4a.example.inicioacudiente _inicioacudiente = null;
public b4a.example.inicioestudiante _inicioestudiante = null;
public b4a.example.registroacudiente _registroacudiente = null;
public b4a.example.registroestudiante _registroestudiante = null;
public b4a.example.httputils2service _httputils2service = null;
public static String  _activity_create(boolean _firsttime) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_create", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_create", new Object[] {_firsttime}));}
RDebugUtils.currentLine=4653056;
 //BA.debugLineNum = 4653056;BA.debugLine="Sub Activity_Create(FirstTime As Boolean)";
RDebugUtils.currentLine=4653058;
 //BA.debugLineNum = 4653058;BA.debugLine="Activity.LoadLayout(\"ingreso\")";
mostCurrent._activity.LoadLayout("ingreso",mostCurrent.activityBA);
RDebugUtils.currentLine=4653059;
 //BA.debugLineNum = 4653059;BA.debugLine="TabHost1.AddTab(\"EVENTOS\",\"evento\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"EVENTOS","evento");
RDebugUtils.currentLine=4653060;
 //BA.debugLineNum = 4653060;BA.debugLine="TabHost1.AddTab(\"PERFIL\",\"perfil\")";
mostCurrent._tabhost1.AddTab(mostCurrent.activityBA,"PERFIL","perfil");
RDebugUtils.currentLine=4653061;
 //BA.debugLineNum = 4653061;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653062;
 //BA.debugLineNum = 4653062;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4653063;
 //BA.debugLineNum = 4653063;BA.debugLine="evento1A.Visible=False";
mostCurrent._evento1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653064;
 //BA.debugLineNum = 4653064;BA.debugLine="evento2A.Visible=False";
mostCurrent._evento2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653065;
 //BA.debugLineNum = 4653065;BA.debugLine="evento11A.Visible=False";
mostCurrent._evento11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653066;
 //BA.debugLineNum = 4653066;BA.debugLine="evento22A.Visible=False";
mostCurrent._evento22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653067;
 //BA.debugLineNum = 4653067;BA.debugLine="Anuncio.Visible=False";
mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4653068;
 //BA.debugLineNum = 4653068;BA.debugLine="eventos = 0";
_eventos = (int) (0);
RDebugUtils.currentLine=4653069;
 //BA.debugLineNum = 4653069;BA.debugLine="End Sub";
return "";
}
public static String  _activity_pause(boolean _userclosed) throws Exception{
RDebugUtils.currentModule="ingreso";
RDebugUtils.currentLine=4784128;
 //BA.debugLineNum = 4784128;BA.debugLine="Sub Activity_Pause (UserClosed As Boolean)";
RDebugUtils.currentLine=4784130;
 //BA.debugLineNum = 4784130;BA.debugLine="End Sub";
return "";
}
public static String  _activity_resume() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "activity_resume", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "activity_resume", null));}
RDebugUtils.currentLine=4718592;
 //BA.debugLineNum = 4718592;BA.debugLine="Sub Activity_Resume";
RDebugUtils.currentLine=4718594;
 //BA.debugLineNum = 4718594;BA.debugLine="End Sub";
return "";
}
public static String  _btncambiaracudiente_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambiaracudiente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambiaracudiente_click", null));}
RDebugUtils.currentLine=4849664;
 //BA.debugLineNum = 4849664;BA.debugLine="Sub btncambiaracudiente_Click";
RDebugUtils.currentLine=4849665;
 //BA.debugLineNum = 4849665;BA.debugLine="If estado = 0 Then";
if (_estado==0) { 
RDebugUtils.currentLine=4849666;
 //BA.debugLineNum = 4849666;BA.debugLine="Panel1.Visible = True";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4849667;
 //BA.debugLineNum = 4849667;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=4849668;
 //BA.debugLineNum = 4849668;BA.debugLine="estado = 1";
_estado = (int) (1);
 };
RDebugUtils.currentLine=4849670;
 //BA.debugLineNum = 4849670;BA.debugLine="End Sub";
return "";
}
public static String  _btncambio_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncambio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncambio_click", null));}
String _apiaddress = "";
b4a.example.httpjob _job = null;
RDebugUtils.currentLine=5242880;
 //BA.debugLineNum = 5242880;BA.debugLine="Sub btncambio_Click";
RDebugUtils.currentLine=5242881;
 //BA.debugLineNum = 5242881;BA.debugLine="If txtconact.Text<>\"\" And txtconnuv.Text<>\"\" And";
if ((mostCurrent._txtconact.getText()).equals("") == false && (mostCurrent._txtconnuv.getText()).equals("") == false && (mostCurrent._txtconfcon.getText()).equals("") == false) { 
RDebugUtils.currentLine=5242882;
 //BA.debugLineNum = 5242882;BA.debugLine="If txtconnuv.Text = txtconfcon.Text Then";
if ((mostCurrent._txtconnuv.getText()).equals(mostCurrent._txtconfcon.getText())) { 
RDebugUtils.currentLine=5242883;
 //BA.debugLineNum = 5242883;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
_apiaddress = "http://192.168.1.3/schooltime1.php";
RDebugUtils.currentLine=5242884;
 //BA.debugLineNum = 5242884;BA.debugLine="Dim job As HttpJob";
_job = new b4a.example.httpjob();
RDebugUtils.currentLine=5242885;
 //BA.debugLineNum = 5242885;BA.debugLine="job.Initialize(\"\", Me)";
_job._initialize /*String*/ (null,processBA,"",ingreso.getObject());
RDebugUtils.currentLine=5242886;
 //BA.debugLineNum = 5242886;BA.debugLine="job.PostString(ApiAddress,\"UPDATE tblregistroac";
_job._poststring /*String*/ (null,_apiaddress,"UPDATE tblregistroacudiente SET contrasenaAcudiente='"+mostCurrent._txtconnuv.getText()+"' WHERE contrasenaAcudiente='"+mostCurrent._txtconact.getText()+"'");
 }else {
RDebugUtils.currentLine=5242888;
 //BA.debugLineNum = 5242888;BA.debugLine="MsgboxAsync(\"Las contraseñas deben coincidir\",\"";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Las contraseñas deben coincidir"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
 }else {
RDebugUtils.currentLine=5242891;
 //BA.debugLineNum = 5242891;BA.debugLine="MsgboxAsync(\"Todos los campos son requeridos par";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Todos los campos son requeridos para el cambio"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=5242893;
 //BA.debugLineNum = 5242893;BA.debugLine="End Sub";
return "";
}
public static String  _btncerraracudiente_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "btncerraracudiente_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "btncerraracudiente_click", null));}
RDebugUtils.currentLine=4915200;
 //BA.debugLineNum = 4915200;BA.debugLine="Sub btncerraracudiente_Click";
RDebugUtils.currentLine=4915201;
 //BA.debugLineNum = 4915201;BA.debugLine="StartActivity(perfiles)";
anywheresoftware.b4a.keywords.Common.StartActivity(processBA,(Object)(mostCurrent._perfiles.getObject()));
RDebugUtils.currentLine=4915202;
 //BA.debugLineNum = 4915202;BA.debugLine="Activity.Finish";
mostCurrent._activity.Finish();
RDebugUtils.currentLine=4915203;
 //BA.debugLineNum = 4915203;BA.debugLine="End Sub";
return "";
}
public static String  _cerrar_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "cerrar_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "cerrar_click", null));}
RDebugUtils.currentLine=4980736;
 //BA.debugLineNum = 4980736;BA.debugLine="Sub cerrar_Click";
RDebugUtils.currentLine=4980737;
 //BA.debugLineNum = 4980737;BA.debugLine="If estado = 1 Then";
if (_estado==1) { 
RDebugUtils.currentLine=4980738;
 //BA.debugLineNum = 4980738;BA.debugLine="Panel1.Visible = False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4980739;
 //BA.debugLineNum = 4980739;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=4980740;
 //BA.debugLineNum = 4980740;BA.debugLine="estado = 0";
_estado = (int) (0);
 };
RDebugUtils.currentLine=4980742;
 //BA.debugLineNum = 4980742;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5505025;
 //BA.debugLineNum = 5505025;BA.debugLine="If contraseñaA.Text <> \"\" Then";
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
 //BA.debugLineNum = 5505027;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/";
_apiaddress = "http://192.168.1.3/schooltime.php";
RDebugUtils.currentLine=5505028;
 //BA.debugLineNum = 5505028;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=5505029;
 //BA.debugLineNum = 5505029;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingreso.getObject());
RDebugUtils.currentLine=5505030;
 //BA.debugLineNum = 5505030;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","cedula","pin",parent.mostCurrent._contraseñaa.getText(),"tabla","tblregistroacudiente","codigo","codigoAcudiente","cedula","cedulaAcudiente"});
RDebugUtils.currentLine=5505031;
 //BA.debugLineNum = 5505031;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingreso", "enviara_click"), (Object)(_js));
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
anywheresoftware.b4a.keywords.Common.LogImpl("75505041",BA.ObjectToString(_tabla),0);
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
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=5505045;
 //BA.debugLineNum = 5505045;BA.debugLine="codigo = fila.Get(\"codigoAcudiente\")";
parent._codigo = BA.ObjectToString(_fila.Get((Object)("codigoAcudiente")));
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
anywheresoftware.b4a.keywords.Common.LogImpl("75505049",_js._errormessage /*String*/ ,0);
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
anywheresoftware.b4a.keywords.Common.LogImpl("75505052",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
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
 //BA.debugLineNum = 5505059;BA.debugLine="remoreA";
_remorea();
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
RDebugUtils.currentLine=5570561;
 //BA.debugLineNum = 5570561;BA.debugLine="If eventos = 0 Then";
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
RDebugUtils.currentLine=5570562;
 //BA.debugLineNum = 5570562;BA.debugLine="Anuncio.Visible = True";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 5:
//C
this.state = 6;
RDebugUtils.currentLine=5570564;
 //BA.debugLineNum = 5570564;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;
;
RDebugUtils.currentLine=5570566;
 //BA.debugLineNum = 5570566;BA.debugLine="Try";

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
RDebugUtils.currentLine=5570567;
 //BA.debugLineNum = 5570567;BA.debugLine="Dim ApiAddress As String = \"http://192.168.1.3/s";
_apiaddress = "http://192.168.1.3/schooltime.php";
RDebugUtils.currentLine=5570568;
 //BA.debugLineNum = 5570568;BA.debugLine="Dim js As HttpJob";
_js = new b4a.example.httpjob();
RDebugUtils.currentLine=5570569;
 //BA.debugLineNum = 5570569;BA.debugLine="js.Initialize(\"\",Me)";
_js._initialize /*String*/ (null,processBA,"",ingreso.getObject());
RDebugUtils.currentLine=5570570;
 //BA.debugLineNum = 5570570;BA.debugLine="js.Download2(ApiAddress,Array As String (\"act\",\"";
_js._download2 /*String*/ (null,_apiaddress,new String[]{"act","evento","codigo",parent._codigo});
RDebugUtils.currentLine=5570571;
 //BA.debugLineNum = 5570571;BA.debugLine="Wait For(js) JobDone(js As HttpJob)";
anywheresoftware.b4a.keywords.Common.WaitFor("jobdone", processBA, new anywheresoftware.b4a.shell.DebugResumableSub.DelegatableResumableSub(this, "ingreso", "remorea"), (Object)(_js));
this.state = 72;
return;
case 72:
//C
this.state = 9;
_js = (b4a.example.httpjob) result[0];
;
RDebugUtils.currentLine=5570572;
 //BA.debugLineNum = 5570572;BA.debugLine="If js.Success Then";
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
RDebugUtils.currentLine=5570573;
 //BA.debugLineNum = 5570573;BA.debugLine="Dim res As String";
_res = "";
RDebugUtils.currentLine=5570574;
 //BA.debugLineNum = 5570574;BA.debugLine="res = js.GetString' Esto no se debe hacer, tu s";
_res = _js._getstring /*String*/ (null);
RDebugUtils.currentLine=5570575;
 //BA.debugLineNum = 5570575;BA.debugLine="res = res.Replace(\"null\",\"\")";
_res = _res.replace("null","");
RDebugUtils.currentLine=5570576;
 //BA.debugLineNum = 5570576;BA.debugLine="Dim parser As JSONParser";
_parser = new anywheresoftware.b4a.objects.collections.JSONParser();
RDebugUtils.currentLine=5570577;
 //BA.debugLineNum = 5570577;BA.debugLine="parser.Initialize(res)";
_parser.Initialize(_res);
RDebugUtils.currentLine=5570578;
 //BA.debugLineNum = 5570578;BA.debugLine="If (res.Length >0) Then";
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
RDebugUtils.currentLine=5570579;
 //BA.debugLineNum = 5570579;BA.debugLine="eventos = 1";
parent._eventos = (int) (1);
RDebugUtils.currentLine=5570580;
 //BA.debugLineNum = 5570580;BA.debugLine="If eventos = 1 Then";
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
RDebugUtils.currentLine=5570581;
 //BA.debugLineNum = 5570581;BA.debugLine="evento1A.Visible = True";
parent.mostCurrent._evento1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 if (true) break;

case 18:
//C
this.state = 19;
;
RDebugUtils.currentLine=5570583;
 //BA.debugLineNum = 5570583;BA.debugLine="Dim tabla As List";
_tabla = new anywheresoftware.b4a.objects.collections.List();
RDebugUtils.currentLine=5570584;
 //BA.debugLineNum = 5570584;BA.debugLine="tabla = parser.NextArray";
_tabla = _parser.NextArray();
RDebugUtils.currentLine=5570585;
 //BA.debugLineNum = 5570585;BA.debugLine="Log(tabla)";
anywheresoftware.b4a.keywords.Common.LogImpl("75570585",BA.ObjectToString(_tabla),0);
RDebugUtils.currentLine=5570586;
 //BA.debugLineNum = 5570586;BA.debugLine="Dim fila As Map";
_fila = new anywheresoftware.b4a.objects.collections.Map();
RDebugUtils.currentLine=5570587;
 //BA.debugLineNum = 5570587;BA.debugLine="For i=0 To tabla.Size-1";
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
RDebugUtils.currentLine=5570588;
 //BA.debugLineNum = 5570588;BA.debugLine="fila= tabla.Get(i)";
_fila.setObject((anywheresoftware.b4a.objects.collections.Map.MyMap)(_tabla.Get(_i)));
RDebugUtils.currentLine=5570589;
 //BA.debugLineNum = 5570589;BA.debugLine="titulo = fila.Get(\"titulo\")";
parent._titulo = BA.ObjectToString(_fila.Get((Object)("titulo")));
RDebugUtils.currentLine=5570590;
 //BA.debugLineNum = 5570590;BA.debugLine="tipo = fila.Get(\"tipo\")";
parent._tipo = BA.ObjectToString(_fila.Get((Object)("tipo")));
RDebugUtils.currentLine=5570591;
 //BA.debugLineNum = 5570591;BA.debugLine="fecha = fila.Get(\"fecha\")";
parent._fecha = BA.ObjectToString(_fila.Get((Object)("fecha")));
RDebugUtils.currentLine=5570592;
 //BA.debugLineNum = 5570592;BA.debugLine="hora = fila.Get(\"hora\")";
parent._hora = BA.ObjectToString(_fila.Get((Object)("hora")));
RDebugUtils.currentLine=5570593;
 //BA.debugLineNum = 5570593;BA.debugLine="descripcion = fila.Get(\"descripcion\")";
parent._descripcion = BA.ObjectToString(_fila.Get((Object)("descripcion")));
RDebugUtils.currentLine=5570594;
 //BA.debugLineNum = 5570594;BA.debugLine="If eventos =1 Then";
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
RDebugUtils.currentLine=5570595;
 //BA.debugLineNum = 5570595;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570596;
 //BA.debugLineNum = 5570596;BA.debugLine="evento2A.Visible = False";
parent.mostCurrent._evento2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570597;
 //BA.debugLineNum = 5570597;BA.debugLine="titulo1A.Text = titulo";
parent.mostCurrent._titulo1a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=5570598;
 //BA.debugLineNum = 5570598;BA.debugLine="fecha1A.Text = fecha";
parent.mostCurrent._fecha1a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=5570599;
 //BA.debugLineNum = 5570599;BA.debugLine="tipo1 = tipo";
parent._tipo1 = parent._tipo;
RDebugUtils.currentLine=5570600;
 //BA.debugLineNum = 5570600;BA.debugLine="hora1A.Text = hora";
parent.mostCurrent._hora1a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=5570601;
 //BA.debugLineNum = 5570601;BA.debugLine="desc1 = descripcion";
parent._desc1 = parent._descripcion;
RDebugUtils.currentLine=5570602;
 //BA.debugLineNum = 5570602;BA.debugLine="If tipo1 = \"Celebracion\" Then";
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
RDebugUtils.currentLine=5570603;
 //BA.debugLineNum = 5570603;BA.debugLine="celebracion1A.Visible = True";
parent.mostCurrent._celebracion1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5570604;
 //BA.debugLineNum = 5570604;BA.debugLine="cambio1A.Visible = False";
parent.mostCurrent._cambio1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570605;
 //BA.debugLineNum = 5570605;BA.debugLine="reunion1A.Visible = False";
parent.mostCurrent._reunion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 29:
//C
this.state = 30;
RDebugUtils.currentLine=5570607;
 //BA.debugLineNum = 5570607;BA.debugLine="If tipo1 = \"Cambio\" Then";
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
RDebugUtils.currentLine=5570608;
 //BA.debugLineNum = 5570608;BA.debugLine="celebracion1A.Visible = False";
parent.mostCurrent._celebracion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570609;
 //BA.debugLineNum = 5570609;BA.debugLine="cambio1A.Visible = True";
parent.mostCurrent._cambio1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5570610;
 //BA.debugLineNum = 5570610;BA.debugLine="reunion1A.Visible = False";
parent.mostCurrent._reunion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 34:
//C
this.state = 35;
RDebugUtils.currentLine=5570612;
 //BA.debugLineNum = 5570612;BA.debugLine="If tipo1 = \"Reunion\" Then";
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
RDebugUtils.currentLine=5570613;
 //BA.debugLineNum = 5570613;BA.debugLine="celebracion1A.Visible = False";
parent.mostCurrent._celebracion1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570614;
 //BA.debugLineNum = 5570614;BA.debugLine="cambio1A.Visible = False";
parent.mostCurrent._cambio1a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570615;
 //BA.debugLineNum = 5570615;BA.debugLine="reunion1A.Visible = True";
parent.mostCurrent._reunion1a.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5570620;
 //BA.debugLineNum = 5570620;BA.debugLine="If eventos =2 Then";
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
RDebugUtils.currentLine=5570621;
 //BA.debugLineNum = 5570621;BA.debugLine="Anuncio.Visible = False";
parent.mostCurrent._anuncio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570622;
 //BA.debugLineNum = 5570622;BA.debugLine="evento2A.Visible = True";
parent.mostCurrent._evento2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5570623;
 //BA.debugLineNum = 5570623;BA.debugLine="titulo2A.Text = titulo";
parent.mostCurrent._titulo2a.setText(BA.ObjectToCharSequence(parent._titulo));
RDebugUtils.currentLine=5570624;
 //BA.debugLineNum = 5570624;BA.debugLine="fecha2A.Text = fecha";
parent.mostCurrent._fecha2a.setText(BA.ObjectToCharSequence(parent._fecha));
RDebugUtils.currentLine=5570625;
 //BA.debugLineNum = 5570625;BA.debugLine="tipo2 = tipo";
parent._tipo2 = parent._tipo;
RDebugUtils.currentLine=5570626;
 //BA.debugLineNum = 5570626;BA.debugLine="hora2A.Text = hora";
parent.mostCurrent._hora2a.setText(BA.ObjectToCharSequence(parent._hora));
RDebugUtils.currentLine=5570627;
 //BA.debugLineNum = 5570627;BA.debugLine="desc2 = descripcion";
parent._desc2 = parent._descripcion;
RDebugUtils.currentLine=5570628;
 //BA.debugLineNum = 5570628;BA.debugLine="If tipo2 = \"Celebracion\" Then";
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
RDebugUtils.currentLine=5570629;
 //BA.debugLineNum = 5570629;BA.debugLine="celebracion2A.Visible = True";
parent.mostCurrent._celebracion2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5570630;
 //BA.debugLineNum = 5570630;BA.debugLine="cambio2A.Visible = False";
parent.mostCurrent._cambio2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570631;
 //BA.debugLineNum = 5570631;BA.debugLine="reunion2A.Visible = False";
parent.mostCurrent._reunion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 50:
//C
this.state = 51;
RDebugUtils.currentLine=5570633;
 //BA.debugLineNum = 5570633;BA.debugLine="If tipo2 = \"Cambio\" Then";
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
RDebugUtils.currentLine=5570634;
 //BA.debugLineNum = 5570634;BA.debugLine="celebracion2A.Visible = False";
parent.mostCurrent._celebracion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570635;
 //BA.debugLineNum = 5570635;BA.debugLine="cambio2A.Visible = True";
parent.mostCurrent._cambio2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5570636;
 //BA.debugLineNum = 5570636;BA.debugLine="reunion2A.Visible = False";
parent.mostCurrent._reunion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 if (true) break;

case 55:
//C
this.state = 56;
RDebugUtils.currentLine=5570638;
 //BA.debugLineNum = 5570638;BA.debugLine="If tipo2 = \"Reunion\" Then";
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
RDebugUtils.currentLine=5570639;
 //BA.debugLineNum = 5570639;BA.debugLine="celebracion2A.Visible = False";
parent.mostCurrent._celebracion2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570640;
 //BA.debugLineNum = 5570640;BA.debugLine="cambio2A.Visible = False";
parent.mostCurrent._cambio2a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5570641;
 //BA.debugLineNum = 5570641;BA.debugLine="reunion2A.Visible = True";
parent.mostCurrent._reunion2a.setVisible(anywheresoftware.b4a.keywords.Common.True);
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
RDebugUtils.currentLine=5570647;
 //BA.debugLineNum = 5570647;BA.debugLine="eventos = eventos  + 1";
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
RDebugUtils.currentLine=5570651;
 //BA.debugLineNum = 5570651;BA.debugLine="Log(js.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("75570651",_js._errormessage /*String*/ ,0);
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
RDebugUtils.currentLine=5570654;
 //BA.debugLineNum = 5570654;BA.debugLine="Log(LastException)";
anywheresoftware.b4a.keywords.Common.LogImpl("75570654",BA.ObjectToString(anywheresoftware.b4a.keywords.Common.LastException(mostCurrent.activityBA)),0);
 if (true) break;
if (true) break;

case 71:
//C
this.state = -1;
this.catchState = 0;
;
RDebugUtils.currentLine=5570656;
 //BA.debugLineNum = 5570656;BA.debugLine="End Sub";
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
RDebugUtils.currentLine=5439488;
 //BA.debugLineNum = 5439488;BA.debugLine="Sub evento1A_Click";
RDebugUtils.currentLine=5439489;
 //BA.debugLineNum = 5439489;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=5439490;
 //BA.debugLineNum = 5439490;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439491;
 //BA.debugLineNum = 5439491;BA.debugLine="evento11A.Visible = True";
mostCurrent._evento11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439492;
 //BA.debugLineNum = 5439492;BA.debugLine="titulo11A.Text = titulo1A.Text";
mostCurrent._titulo11a.setText(BA.ObjectToCharSequence(mostCurrent._titulo1a.getText()));
RDebugUtils.currentLine=5439493;
 //BA.debugLineNum = 5439493;BA.debugLine="fecha11A.Text = fecha1A.Text";
mostCurrent._fecha11a.setText(BA.ObjectToCharSequence(mostCurrent._fecha1a.getText()));
RDebugUtils.currentLine=5439494;
 //BA.debugLineNum = 5439494;BA.debugLine="hora11A.Text = hora1A.Text";
mostCurrent._hora11a.setText(BA.ObjectToCharSequence(mostCurrent._hora1a.getText()));
RDebugUtils.currentLine=5439495;
 //BA.debugLineNum = 5439495;BA.debugLine="desc11A.Text = desc1";
mostCurrent._desc11a.setText(BA.ObjectToCharSequence(_desc1));
RDebugUtils.currentLine=5439496;
 //BA.debugLineNum = 5439496;BA.debugLine="If tipo1 = \"Celebracion\" Then";
if ((_tipo1).equals("Celebracion")) { 
RDebugUtils.currentLine=5439497;
 //BA.debugLineNum = 5439497;BA.debugLine="celebracion11A.Visible = True";
mostCurrent._celebracion11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439498;
 //BA.debugLineNum = 5439498;BA.debugLine="cambio11A.Visible = False";
mostCurrent._cambio11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439499;
 //BA.debugLineNum = 5439499;BA.debugLine="reunion11A.Visible = False";
mostCurrent._reunion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=5439501;
 //BA.debugLineNum = 5439501;BA.debugLine="If tipo1 = \"Reunion\" Then";
if ((_tipo1).equals("Reunion")) { 
RDebugUtils.currentLine=5439502;
 //BA.debugLineNum = 5439502;BA.debugLine="celebracion11A.Visible = False";
mostCurrent._celebracion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439503;
 //BA.debugLineNum = 5439503;BA.debugLine="cambio11A.Visible = False";
mostCurrent._cambio11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439504;
 //BA.debugLineNum = 5439504;BA.debugLine="reunion11A.Visible = True";
mostCurrent._reunion11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=5439506;
 //BA.debugLineNum = 5439506;BA.debugLine="If tipo1 = \"Cambio\" Then";
if ((_tipo1).equals("Cambio")) { 
RDebugUtils.currentLine=5439507;
 //BA.debugLineNum = 5439507;BA.debugLine="celebracion11A.Visible = False";
mostCurrent._celebracion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5439508;
 //BA.debugLineNum = 5439508;BA.debugLine="cambio11A.Visible = True";
mostCurrent._cambio11a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5439509;
 //BA.debugLineNum = 5439509;BA.debugLine="reunion11A.Visible = False";
mostCurrent._reunion11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
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
public static String  _evento2a_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "evento2a_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "evento2a_click", null));}
RDebugUtils.currentLine=5373952;
 //BA.debugLineNum = 5373952;BA.debugLine="Sub evento2A_Click";
RDebugUtils.currentLine=5373953;
 //BA.debugLineNum = 5373953;BA.debugLine="If event = 0 Then";
if (_event==0) { 
RDebugUtils.currentLine=5373954;
 //BA.debugLineNum = 5373954;BA.debugLine="inicio.Visible = True";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5373955;
 //BA.debugLineNum = 5373955;BA.debugLine="evento22A.Visible = True";
mostCurrent._evento22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5373956;
 //BA.debugLineNum = 5373956;BA.debugLine="titulo22A.Text = titulo2A.Text";
mostCurrent._titulo22a.setText(BA.ObjectToCharSequence(mostCurrent._titulo2a.getText()));
RDebugUtils.currentLine=5373957;
 //BA.debugLineNum = 5373957;BA.debugLine="fecha22A.Text = fecha2A.Text";
mostCurrent._fecha22a.setText(BA.ObjectToCharSequence(mostCurrent._fecha2a.getText()));
RDebugUtils.currentLine=5373958;
 //BA.debugLineNum = 5373958;BA.debugLine="hora22A.Text = hora2A.Text";
mostCurrent._hora22a.setText(BA.ObjectToCharSequence(mostCurrent._hora2a.getText()));
RDebugUtils.currentLine=5373959;
 //BA.debugLineNum = 5373959;BA.debugLine="desc22A.Text = desc2";
mostCurrent._desc22a.setText(BA.ObjectToCharSequence(_desc2));
RDebugUtils.currentLine=5373960;
 //BA.debugLineNum = 5373960;BA.debugLine="If tipo2 = \"Celebracion\" Then";
if ((_tipo2).equals("Celebracion")) { 
RDebugUtils.currentLine=5373961;
 //BA.debugLineNum = 5373961;BA.debugLine="celebracion22A.Visible = True";
mostCurrent._celebracion22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5373962;
 //BA.debugLineNum = 5373962;BA.debugLine="cambio22A.Visible = False";
mostCurrent._cambio22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5373963;
 //BA.debugLineNum = 5373963;BA.debugLine="reunion22A.Visible = False";
mostCurrent._reunion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
 }else {
RDebugUtils.currentLine=5373965;
 //BA.debugLineNum = 5373965;BA.debugLine="If tipo2 = \"Reunion\" Then";
if ((_tipo2).equals("Reunion")) { 
RDebugUtils.currentLine=5373966;
 //BA.debugLineNum = 5373966;BA.debugLine="celebracion22A.Visible = False";
mostCurrent._celebracion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5373967;
 //BA.debugLineNum = 5373967;BA.debugLine="cambio22A.Visible = False";
mostCurrent._cambio22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5373968;
 //BA.debugLineNum = 5373968;BA.debugLine="reunion22A.Visible = True";
mostCurrent._reunion22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
 }else {
RDebugUtils.currentLine=5373970;
 //BA.debugLineNum = 5373970;BA.debugLine="If tipo2 = \"Cambio\" Then";
if ((_tipo2).equals("Cambio")) { 
RDebugUtils.currentLine=5373971;
 //BA.debugLineNum = 5373971;BA.debugLine="celebracion22A.Visible = False";
mostCurrent._celebracion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5373972;
 //BA.debugLineNum = 5373972;BA.debugLine="cambio22A.Visible = True";
mostCurrent._cambio22a.setVisible(anywheresoftware.b4a.keywords.Common.True);
RDebugUtils.currentLine=5373973;
 //BA.debugLineNum = 5373973;BA.debugLine="reunion22A.Visible = False";
mostCurrent._reunion22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
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
public static String  _inicio_click() throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "inicio_click", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "inicio_click", null));}
RDebugUtils.currentLine=5046272;
 //BA.debugLineNum = 5046272;BA.debugLine="Sub inicio_Click";
RDebugUtils.currentLine=5046273;
 //BA.debugLineNum = 5046273;BA.debugLine="If event = 1 Then";
if (_event==1) { 
RDebugUtils.currentLine=5046274;
 //BA.debugLineNum = 5046274;BA.debugLine="inicio.Visible = False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046275;
 //BA.debugLineNum = 5046275;BA.debugLine="evento22A.Visible = False";
mostCurrent._evento22a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046276;
 //BA.debugLineNum = 5046276;BA.debugLine="evento11A.Visible = False";
mostCurrent._evento11a.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5046277;
 //BA.debugLineNum = 5046277;BA.debugLine="event = 0";
_event = (int) (0);
 };
RDebugUtils.currentLine=5046279;
 //BA.debugLineNum = 5046279;BA.debugLine="End Sub";
return "";
}
public static String  _jobdone(b4a.example.httpjob _job) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "jobdone", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "jobdone", new Object[] {_job}));}
RDebugUtils.currentLine=5308416;
 //BA.debugLineNum = 5308416;BA.debugLine="Sub JobDone(Job As HttpJob)";
RDebugUtils.currentLine=5308417;
 //BA.debugLineNum = 5308417;BA.debugLine="If Job.Success Then";
if (_job._success /*boolean*/ ) { 
RDebugUtils.currentLine=5308418;
 //BA.debugLineNum = 5308418;BA.debugLine="Log(\"OK, se actualizó correctamente\")";
anywheresoftware.b4a.keywords.Common.LogImpl("75308418","OK, se actualizó correctamente",0);
RDebugUtils.currentLine=5308419;
 //BA.debugLineNum = 5308419;BA.debugLine="MsgboxAsync(\"Su contraseña se actualizó con éxit";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Su contraseña se actualizó con éxito"),BA.ObjectToCharSequence("AVISO"),processBA);
RDebugUtils.currentLine=5308420;
 //BA.debugLineNum = 5308420;BA.debugLine="txtconact.Text=\"\"";
mostCurrent._txtconact.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=5308421;
 //BA.debugLineNum = 5308421;BA.debugLine="txtconnuv.Text=\"\"";
mostCurrent._txtconnuv.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=5308422;
 //BA.debugLineNum = 5308422;BA.debugLine="txtconfcon.Text=\"\"";
mostCurrent._txtconfcon.setText(BA.ObjectToCharSequence(""));
RDebugUtils.currentLine=5308423;
 //BA.debugLineNum = 5308423;BA.debugLine="Panel1.Visible=False";
mostCurrent._panel1.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5308424;
 //BA.debugLineNum = 5308424;BA.debugLine="inicio.Visible=False";
mostCurrent._inicio.setVisible(anywheresoftware.b4a.keywords.Common.False);
RDebugUtils.currentLine=5308425;
 //BA.debugLineNum = 5308425;BA.debugLine="estado=0";
_estado = (int) (0);
 }else {
RDebugUtils.currentLine=5308427;
 //BA.debugLineNum = 5308427;BA.debugLine="Log(Job.ErrorMessage)";
anywheresoftware.b4a.keywords.Common.LogImpl("75308427",_job._errormessage /*String*/ ,0);
RDebugUtils.currentLine=5308428;
 //BA.debugLineNum = 5308428;BA.debugLine="ToastMessageShow(\"Error: \" & Job.ErrorMessage, T";
anywheresoftware.b4a.keywords.Common.ToastMessageShow(BA.ObjectToCharSequence("Error: "+_job._errormessage /*String*/ ),anywheresoftware.b4a.keywords.Common.True);
 };
RDebugUtils.currentLine=5308430;
 //BA.debugLineNum = 5308430;BA.debugLine="Job.Release";
_job._release /*String*/ (null);
RDebugUtils.currentLine=5308431;
 //BA.debugLineNum = 5308431;BA.debugLine="End Sub";
return "";
}
public static String  _txtconfcon_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconfcon_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconfcon_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=5177344;
 //BA.debugLineNum = 5177344;BA.debugLine="Sub txtconfcon_TextChanged (Old As String, New As";
RDebugUtils.currentLine=5177345;
 //BA.debugLineNum = 5177345;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=5177346;
 //BA.debugLineNum = 5177346;BA.debugLine="MsgboxAsync(\"Laconfirmación de la contraseña no";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("Laconfirmación de la contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=5177348;
 //BA.debugLineNum = 5177348;BA.debugLine="End Sub";
return "";
}
public static String  _txtconnuv_textchanged(String _old,String _new) throws Exception{
RDebugUtils.currentModule="ingreso";
if (Debug.shouldDelegate(mostCurrent.activityBA, "txtconnuv_textchanged", false))
	 {return ((String) Debug.delegate(mostCurrent.activityBA, "txtconnuv_textchanged", new Object[] {_old,_new}));}
RDebugUtils.currentLine=5111808;
 //BA.debugLineNum = 5111808;BA.debugLine="Sub txtconnuv_TextChanged (Old As String, New As S";
RDebugUtils.currentLine=5111809;
 //BA.debugLineNum = 5111809;BA.debugLine="If New.Length >= 20 Then";
if (_new.length()>=20) { 
RDebugUtils.currentLine=5111810;
 //BA.debugLineNum = 5111810;BA.debugLine="MsgboxAsync(\"La nueva contraseña no puede sobrep";
anywheresoftware.b4a.keywords.Common.MsgboxAsync(BA.ObjectToCharSequence("La nueva contraseña no puede sobrepasar los 20 caracteres"),BA.ObjectToCharSequence("ATENCIÓN"),processBA);
 };
RDebugUtils.currentLine=5111812;
 //BA.debugLineNum = 5111812;BA.debugLine="End Sub";
return "";
}
}
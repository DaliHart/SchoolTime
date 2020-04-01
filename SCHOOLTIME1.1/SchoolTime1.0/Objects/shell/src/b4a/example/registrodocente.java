
package b4a.example;

import java.io.IOException;
import anywheresoftware.b4a.BA;
import anywheresoftware.b4a.pc.PCBA;
import anywheresoftware.b4a.pc.RDebug;
import anywheresoftware.b4a.pc.RemoteObject;
import anywheresoftware.b4a.pc.RDebug.IRemote;
import anywheresoftware.b4a.pc.Debug;
import anywheresoftware.b4a.pc.B4XTypes.B4XClass;
import anywheresoftware.b4a.pc.B4XTypes.DeviceClass;

public class registrodocente implements IRemote{
	public static registrodocente mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public registrodocente() {
		mostCurrent = this;
	}
    public RemoteObject getRemoteMe() {
        return remoteMe;    
    }
    
	public static void main (String[] args) throws Exception {
		new RDebug(args[0], Integer.parseInt(args[1]), Integer.parseInt(args[2]), args[3]);
		RDebug.INSTANCE.waitForTask();

	}
    static {
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("registrodocente"), "b4a.example.registrodocente");
	}

public boolean isSingleton() {
		return true;
	}
     public static RemoteObject getObject() {
		return myClass;
	 }

	public RemoteObject activityBA;
	public RemoteObject _activity;
    private PCBA pcBA;

	public PCBA create(Object[] args) throws ClassNotFoundException{
		processBA = (RemoteObject) args[1];
		activityBA = (RemoteObject) args[2];
		_activity = (RemoteObject) args[3];
        anywheresoftware.b4a.keywords.Common.Density = (Float)args[4];
        remoteMe = (RemoteObject) args[5];
		pcBA = new PCBA(this, registrodocente.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _hecho = RemoteObject.declareNull("anywheresoftware.b4a.objects.Timer");
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _label1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _retroceder = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _btnregistrardocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _txtnombredocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtceduladocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtcorreodocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtcondocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtconfirmaciondocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtapellidodocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtcodigodocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _opcioncodigo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _fondo = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cerrarcodigo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _doc = RemoteObject.createImmutable(0);
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.perfiles _perfiles = null;
public static b4a.example.ingresodocente _ingresodocente = null;
public static b4a.example.ingreso _ingreso = null;
public static b4a.example.ingresoestudiante _ingresoestudiante = null;
public static b4a.example.inicioacudiente _inicioacudiente = null;
public static b4a.example.iniciodocente _iniciodocente = null;
public static b4a.example.inicioestudiante _inicioestudiante = null;
public static b4a.example.registroacudiente _registroacudiente = null;
public static b4a.example.registroestudiante _registroestudiante = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",registrodocente.mostCurrent._activity,"btnregistrardocente",registrodocente.mostCurrent._btnregistrardocente,"cerrarCodigo",registrodocente.mostCurrent._cerrarcodigo,"doc",registrodocente._doc,"fondo",registrodocente.mostCurrent._fondo,"hecho",registrodocente._hecho,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"ingreso",Debug.moduleToString(b4a.example.ingreso.class),"ingresoDocente",Debug.moduleToString(b4a.example.ingresodocente.class),"ingresoEstudiante",Debug.moduleToString(b4a.example.ingresoestudiante.class),"inicioAcudiente",Debug.moduleToString(b4a.example.inicioacudiente.class),"inicioDocente",Debug.moduleToString(b4a.example.iniciodocente.class),"inicioEstudiante",Debug.moduleToString(b4a.example.inicioestudiante.class),"Label1",registrodocente.mostCurrent._label1,"Main",Debug.moduleToString(b4a.example.main.class),"opcioncodigo",registrodocente.mostCurrent._opcioncodigo,"Panel2",registrodocente.mostCurrent._panel2,"perfiles",Debug.moduleToString(b4a.example.perfiles.class),"registroAcudiente",Debug.moduleToString(b4a.example.registroacudiente.class),"registroEstudiante",Debug.moduleToString(b4a.example.registroestudiante.class),"retroceder",registrodocente.mostCurrent._retroceder,"ScrollView1",registrodocente.mostCurrent._scrollview1,"Starter",Debug.moduleToString(b4a.example.starter.class),"txtapellidodocente",registrodocente.mostCurrent._txtapellidodocente,"txtceduladocente",registrodocente.mostCurrent._txtceduladocente,"txtcodigodocente",registrodocente.mostCurrent._txtcodigodocente,"txtcondocente",registrodocente.mostCurrent._txtcondocente,"txtconfirmaciondocente",registrodocente.mostCurrent._txtconfirmaciondocente,"txtcorreodocente",registrodocente.mostCurrent._txtcorreodocente,"txtnombredocente",registrodocente.mostCurrent._txtnombredocente};
}
}
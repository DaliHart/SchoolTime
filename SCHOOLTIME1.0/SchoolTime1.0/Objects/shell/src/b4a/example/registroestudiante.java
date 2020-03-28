
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

public class registroestudiante implements IRemote{
	public static registroestudiante mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public registroestudiante() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("registroestudiante"), "b4a.example.registroestudiante");
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
		pcBA = new PCBA(this, registroestudiante.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _est = RemoteObject.createImmutable(0);
public static RemoteObject _scrollview1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ScrollViewWrapper");
public static RemoteObject _retroceder = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _txtnombreestudiante = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtidentificacion = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtmatricula = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtcodigogrupo = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtcontrasenaestudiante = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtconfirmaestudiante = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _btnregistroestudiante = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panel2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fondo = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cerrarcodigo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _opcioncodigo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _txtapellidoestudiante = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtcorreoestudiante = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.perfiles _perfiles = null;
public static b4a.example.iniciodocente _iniciodocente = null;
public static b4a.example.registrodocente _registrodocente = null;
public static b4a.example.ingresodocente _ingresodocente = null;
public static b4a.example.ingreso _ingreso = null;
public static b4a.example.ingresoestudiante _ingresoestudiante = null;
public static b4a.example.inicioacudiente _inicioacudiente = null;
public static b4a.example.inicioestudiante _inicioestudiante = null;
public static b4a.example.registroacudiente _registroacudiente = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",registroestudiante.mostCurrent._activity,"btnregistroEstudiante",registroestudiante.mostCurrent._btnregistroestudiante,"cerrarCodigo",registroestudiante.mostCurrent._cerrarcodigo,"est",registroestudiante._est,"fondo",registroestudiante.mostCurrent._fondo,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"ingreso",Debug.moduleToString(b4a.example.ingreso.class),"ingresoDocente",Debug.moduleToString(b4a.example.ingresodocente.class),"ingresoEstudiante",Debug.moduleToString(b4a.example.ingresoestudiante.class),"inicioAcudiente",Debug.moduleToString(b4a.example.inicioacudiente.class),"inicioDocente",Debug.moduleToString(b4a.example.iniciodocente.class),"inicioEstudiante",Debug.moduleToString(b4a.example.inicioestudiante.class),"Main",Debug.moduleToString(b4a.example.main.class),"opcioncodigo",registroestudiante.mostCurrent._opcioncodigo,"Panel2",registroestudiante.mostCurrent._panel2,"perfiles",Debug.moduleToString(b4a.example.perfiles.class),"registroAcudiente",Debug.moduleToString(b4a.example.registroacudiente.class),"registroDocente",Debug.moduleToString(b4a.example.registrodocente.class),"retroceder",registroestudiante.mostCurrent._retroceder,"ScrollView1",registroestudiante.mostCurrent._scrollview1,"Starter",Debug.moduleToString(b4a.example.starter.class),"txtapellidoEstudiante",registroestudiante.mostCurrent._txtapellidoestudiante,"txtcodigogrupo",registroestudiante.mostCurrent._txtcodigogrupo,"txtconfirmaEstudiante",registroestudiante.mostCurrent._txtconfirmaestudiante,"txtcontrasenaEstudiante",registroestudiante.mostCurrent._txtcontrasenaestudiante,"txtcorreoEstudiante",registroestudiante.mostCurrent._txtcorreoestudiante,"txtidentificacion",registroestudiante.mostCurrent._txtidentificacion,"txtmatricula",registroestudiante.mostCurrent._txtmatricula,"txtnombreEstudiante",registroestudiante.mostCurrent._txtnombreestudiante};
}
}
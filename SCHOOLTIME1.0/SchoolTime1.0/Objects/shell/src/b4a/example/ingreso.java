
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

public class ingreso implements IRemote{
	public static ingreso mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public ingreso() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("ingreso"), "b4a.example.ingreso");
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
		pcBA = new PCBA(this, ingreso.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _estado = RemoteObject.createImmutable(0);
public static RemoteObject _titulo = RemoteObject.createImmutable("");
public static RemoteObject _descripcion = RemoteObject.createImmutable("");
public static RemoteObject _fecha = RemoteObject.createImmutable("");
public static RemoteObject _hora = RemoteObject.createImmutable("");
public static RemoteObject _tipo = RemoteObject.createImmutable("");
public static RemoteObject _tipo1 = RemoteObject.createImmutable("");
public static RemoteObject _tipo2 = RemoteObject.createImmutable("");
public static RemoteObject _codigo = RemoteObject.createImmutable("");
public static RemoteObject _desc1 = RemoteObject.createImmutable("");
public static RemoteObject _desc2 = RemoteObject.createImmutable("");
public static RemoteObject _eventos = RemoteObject.createImmutable(0);
public static RemoteObject _event = RemoteObject.createImmutable(0);
public static RemoteObject _tabhost1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabHostWrapper");
public static RemoteObject _btncambiaracudiente = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btncerraracudiente = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _inicio = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cerrar = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _txtconact = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtconnuv = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtconfcon = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btncambio = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _anuncio = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio1a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _cambio2a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion1a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion2a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _evento1a = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _evento2a = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha1a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _fecha2a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora1a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora2a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _reunion1a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _reunion2a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo1a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _titulo2a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio11a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _cambio22a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion11a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion22a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _contraseñaa = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _datos = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _desc11a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _desc22a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _enviara = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _evento11a = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha11a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _fecha22a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora11a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora22a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _reunion11a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _reunion22a = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo11a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _titulo22a = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _evento22a = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.perfiles _perfiles = null;
public static b4a.example.iniciodocente _iniciodocente = null;
public static b4a.example.registrodocente _registrodocente = null;
public static b4a.example.ingresodocente _ingresodocente = null;
public static b4a.example.ingresoestudiante _ingresoestudiante = null;
public static b4a.example.inicioacudiente _inicioacudiente = null;
public static b4a.example.inicioestudiante _inicioestudiante = null;
public static b4a.example.registroacudiente _registroacudiente = null;
public static b4a.example.registroestudiante _registroestudiante = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",ingreso.mostCurrent._activity,"Anuncio",ingreso.mostCurrent._anuncio,"btncambiaracudiente",ingreso.mostCurrent._btncambiaracudiente,"btncambio",ingreso.mostCurrent._btncambio,"btncerraracudiente",ingreso.mostCurrent._btncerraracudiente,"cambio11A",ingreso.mostCurrent._cambio11a,"cambio1A",ingreso.mostCurrent._cambio1a,"cambio22A",ingreso.mostCurrent._cambio22a,"cambio2A",ingreso.mostCurrent._cambio2a,"celebracion11A",ingreso.mostCurrent._celebracion11a,"celebracion1A",ingreso.mostCurrent._celebracion1a,"celebracion22A",ingreso.mostCurrent._celebracion22a,"celebracion2A",ingreso.mostCurrent._celebracion2a,"cerrar",ingreso.mostCurrent._cerrar,"codigo",ingreso._codigo,"contraseñaA",ingreso.mostCurrent._contraseñaa,"Datos",ingreso.mostCurrent._datos,"desc1",ingreso._desc1,"desc11A",ingreso.mostCurrent._desc11a,"desc2",ingreso._desc2,"desc22A",ingreso.mostCurrent._desc22a,"descripcion",ingreso._descripcion,"EnviarA",ingreso.mostCurrent._enviara,"estado",ingreso._estado,"event",ingreso._event,"evento11A",ingreso.mostCurrent._evento11a,"evento1A",ingreso.mostCurrent._evento1a,"evento22A",ingreso.mostCurrent._evento22a,"evento2A",ingreso.mostCurrent._evento2a,"eventos",ingreso._eventos,"fecha",ingreso._fecha,"fecha11A",ingreso.mostCurrent._fecha11a,"fecha1A",ingreso.mostCurrent._fecha1a,"fecha22A",ingreso.mostCurrent._fecha22a,"fecha2A",ingreso.mostCurrent._fecha2a,"hora",ingreso._hora,"hora11A",ingreso.mostCurrent._hora11a,"hora1A",ingreso.mostCurrent._hora1a,"hora22A",ingreso.mostCurrent._hora22a,"hora2A",ingreso.mostCurrent._hora2a,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"ingresoDocente",Debug.moduleToString(b4a.example.ingresodocente.class),"ingresoEstudiante",Debug.moduleToString(b4a.example.ingresoestudiante.class),"inicio",ingreso.mostCurrent._inicio,"inicioAcudiente",Debug.moduleToString(b4a.example.inicioacudiente.class),"inicioDocente",Debug.moduleToString(b4a.example.iniciodocente.class),"inicioEstudiante",Debug.moduleToString(b4a.example.inicioestudiante.class),"Main",Debug.moduleToString(b4a.example.main.class),"Panel1",ingreso.mostCurrent._panel1,"perfiles",Debug.moduleToString(b4a.example.perfiles.class),"registroAcudiente",Debug.moduleToString(b4a.example.registroacudiente.class),"registroDocente",Debug.moduleToString(b4a.example.registrodocente.class),"registroEstudiante",Debug.moduleToString(b4a.example.registroestudiante.class),"reunion11A",ingreso.mostCurrent._reunion11a,"reunion1A",ingreso.mostCurrent._reunion1a,"reunion22A",ingreso.mostCurrent._reunion22a,"reunion2A",ingreso.mostCurrent._reunion2a,"Starter",Debug.moduleToString(b4a.example.starter.class),"TabHost1",ingreso.mostCurrent._tabhost1,"tipo",ingreso._tipo,"tipo1",ingreso._tipo1,"tipo2",ingreso._tipo2,"titulo",ingreso._titulo,"titulo11A",ingreso.mostCurrent._titulo11a,"titulo1A",ingreso.mostCurrent._titulo1a,"titulo22A",ingreso.mostCurrent._titulo22a,"titulo2A",ingreso.mostCurrent._titulo2a,"txtconact",ingreso.mostCurrent._txtconact,"txtconfcon",ingreso.mostCurrent._txtconfcon,"txtconnuv",ingreso.mostCurrent._txtconnuv};
}
}
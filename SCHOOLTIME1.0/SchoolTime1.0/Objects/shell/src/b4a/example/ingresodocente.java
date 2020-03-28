
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

public class ingresodocente implements IRemote{
	public static ingresodocente mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public ingresodocente() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("ingresodocente"), "b4a.example.ingresodocente");
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
		pcBA = new PCBA(this, ingresodocente.class);
        main_subs_0.initializeProcessGlobals();
		return pcBA;
	}
public static RemoteObject __c = RemoteObject.declareNull("anywheresoftware.b4a.keywords.Common");
public static RemoteObject _event = RemoteObject.createImmutable(0);
public static RemoteObject _tit = RemoteObject.createImmutable("");
public static RemoteObject _fec = RemoteObject.createImmutable("");
public static RemoteObject _tip = RemoteObject.createImmutable("");
public static RemoteObject _hor = RemoteObject.createImmutable("");
public static RemoteObject _des = RemoteObject.createImmutable("");
public static RemoteObject _desc11 = RemoteObject.createImmutable("");
public static RemoteObject _desc2 = RemoteObject.createImmutable("");
public static RemoteObject _codigo = RemoteObject.createImmutable("");
public static RemoteObject _tipo2 = RemoteObject.createImmutable("");
public static RemoteObject _eventos = RemoteObject.createImmutable(0);
public static RemoteObject _tabhost1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabHostWrapper");
public static RemoteObject _btncambiardocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btncerrardocente = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _estado = RemoteObject.createImmutable(0);
public static RemoteObject _inicio = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _retroceder = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _txtconnuv = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _btncambio = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _txtconact = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtconfcon = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _evento1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _titulo = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _reunion = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _tipo = RemoteObject.createImmutable("");
public static RemoteObject _hora = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _icono1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _fecha1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _desc1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _icono1r = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _icono1c = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _evento11 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _anuncio = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _evento2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _cambio2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _reunion2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _fecha2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora2 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio22 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion22 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _descripcion22 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _evento22 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha22 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora22 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _reunion22 = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo22 = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _datos = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _contraseñad = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _enviar = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _notifica = RemoteObject.declareNull("anywheresoftware.b4a.objects.NotificationWrapper");
public static RemoteObject _fechacomplet = RemoteObject.createImmutable("");
public static b4a.example.main _main = null;
public static b4a.example.starter _starter = null;
public static b4a.example.perfiles _perfiles = null;
public static b4a.example.iniciodocente _iniciodocente = null;
public static b4a.example.registrodocente _registrodocente = null;
public static b4a.example.ingreso _ingreso = null;
public static b4a.example.ingresoestudiante _ingresoestudiante = null;
public static b4a.example.inicioacudiente _inicioacudiente = null;
public static b4a.example.inicioestudiante _inicioestudiante = null;
public static b4a.example.registroacudiente _registroacudiente = null;
public static b4a.example.registroestudiante _registroestudiante = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",ingresodocente.mostCurrent._activity,"Anuncio",ingresodocente.mostCurrent._anuncio,"btncambiardocente",ingresodocente.mostCurrent._btncambiardocente,"btncambio",ingresodocente.mostCurrent._btncambio,"btncerrardocente",ingresodocente.mostCurrent._btncerrardocente,"cambio",ingresodocente.mostCurrent._cambio,"cambio2",ingresodocente.mostCurrent._cambio2,"cambio22",ingresodocente.mostCurrent._cambio22,"celebracion",ingresodocente.mostCurrent._celebracion,"celebracion2",ingresodocente.mostCurrent._celebracion2,"celebracion22",ingresodocente.mostCurrent._celebracion22,"codigo",ingresodocente._codigo,"contraseñaD",ingresodocente.mostCurrent._contraseñad,"Datos",ingresodocente.mostCurrent._datos,"des",ingresodocente._des,"desc1",ingresodocente.mostCurrent._desc1,"desc11",ingresodocente._desc11,"desc2",ingresodocente._desc2,"descripcion22",ingresodocente.mostCurrent._descripcion22,"Enviar",ingresodocente.mostCurrent._enviar,"estado",ingresodocente._estado,"event",ingresodocente._event,"evento1",ingresodocente.mostCurrent._evento1,"evento11",ingresodocente.mostCurrent._evento11,"evento2",ingresodocente.mostCurrent._evento2,"evento22",ingresodocente.mostCurrent._evento22,"eventos",ingresodocente._eventos,"fec",ingresodocente._fec,"fecha",ingresodocente.mostCurrent._fecha,"fecha1",ingresodocente.mostCurrent._fecha1,"fecha2",ingresodocente.mostCurrent._fecha2,"fecha22",ingresodocente.mostCurrent._fecha22,"fechaComplet",ingresodocente.mostCurrent._fechacomplet,"hor",ingresodocente._hor,"hora",ingresodocente.mostCurrent._hora,"hora1",ingresodocente.mostCurrent._hora1,"hora2",ingresodocente.mostCurrent._hora2,"hora22",ingresodocente.mostCurrent._hora22,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"icono1",ingresodocente.mostCurrent._icono1,"icono1C",ingresodocente.mostCurrent._icono1c,"icono1R",ingresodocente.mostCurrent._icono1r,"ingreso",Debug.moduleToString(b4a.example.ingreso.class),"ingresoEstudiante",Debug.moduleToString(b4a.example.ingresoestudiante.class),"inicio",ingresodocente.mostCurrent._inicio,"inicioAcudiente",Debug.moduleToString(b4a.example.inicioacudiente.class),"inicioDocente",Debug.moduleToString(b4a.example.iniciodocente.class),"inicioEstudiante",Debug.moduleToString(b4a.example.inicioestudiante.class),"Main",Debug.moduleToString(b4a.example.main.class),"notifica",ingresodocente.mostCurrent._notifica,"Panel1",ingresodocente.mostCurrent._panel1,"perfiles",Debug.moduleToString(b4a.example.perfiles.class),"registroAcudiente",Debug.moduleToString(b4a.example.registroacudiente.class),"registroDocente",Debug.moduleToString(b4a.example.registrodocente.class),"registroEstudiante",Debug.moduleToString(b4a.example.registroestudiante.class),"retroceder",ingresodocente.mostCurrent._retroceder,"reunion",ingresodocente.mostCurrent._reunion,"reunion2",ingresodocente.mostCurrent._reunion2,"reunion22",ingresodocente.mostCurrent._reunion22,"Starter",Debug.moduleToString(b4a.example.starter.class),"TabHost1",ingresodocente.mostCurrent._tabhost1,"tip",ingresodocente._tip,"tipo",ingresodocente.mostCurrent._tipo,"tipo2",ingresodocente._tipo2,"tit",ingresodocente._tit,"titulo",ingresodocente.mostCurrent._titulo,"titulo1",ingresodocente.mostCurrent._titulo1,"titulo2",ingresodocente.mostCurrent._titulo2,"titulo22",ingresodocente.mostCurrent._titulo22,"txtconact",ingresodocente.mostCurrent._txtconact,"txtconfcon",ingresodocente.mostCurrent._txtconfcon,"txtconnuv",ingresodocente.mostCurrent._txtconnuv};
}
}
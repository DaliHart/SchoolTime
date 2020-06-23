
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

public class ingresoestudiante implements IRemote{
	public static ingresoestudiante mostCurrent;
	public static RemoteObject processBA;
    public static boolean processGlobalsRun;
    public static RemoteObject myClass;
    public static RemoteObject remoteMe;
	public ingresoestudiante() {
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
        anywheresoftware.b4a.pc.RapidSub.moduleToObject.put(new B4XClass("ingresoestudiante"), "b4a.example.ingresoestudiante");
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
		pcBA = new PCBA(this, ingresoestudiante.class);
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
public static RemoteObject _tipo3 = RemoteObject.createImmutable("");
public static RemoteObject _tipo4 = RemoteObject.createImmutable("");
public static RemoteObject _codigoe = RemoteObject.createImmutable("");
public static RemoteObject _desc1 = RemoteObject.createImmutable("");
public static RemoteObject _desc2 = RemoteObject.createImmutable("");
public static RemoteObject _desc3 = RemoteObject.createImmutable("");
public static RemoteObject _desc4 = RemoteObject.createImmutable("");
public static RemoteObject _c = RemoteObject.createImmutable("");
public static RemoteObject _eventos = RemoteObject.createImmutable(0);
public static RemoteObject _event = RemoteObject.createImmutable(0);
public static RemoteObject _tabhost1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.TabHostWrapper");
public static RemoteObject _inicio = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _panel1 = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _btncambioe = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _retroceder = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _txtconacte = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtconfcone = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _txtconnuve = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _btncambiarestudiante = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _btncerrarestudiante = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _anuncio = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio1e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _cambio2e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion1e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion2e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _evento1e = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _evento2e = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha1e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _fecha2e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora1e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora2e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _reunion1e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _reunion2e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo1e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _titulo2e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio11e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _cambio22e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion11e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion22e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _contraseñae = RemoteObject.declareNull("anywheresoftware.b4a.objects.EditTextWrapper");
public static RemoteObject _datos = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _desc11e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _descripcion22e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _enviare = RemoteObject.declareNull("anywheresoftware.b4a.objects.ButtonWrapper");
public static RemoteObject _evento11e = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _evento22e = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha11e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _fecha22e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora11e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora22e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _reunion11e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _reunion22e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo11e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _titulo22e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio3e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion3e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _evento3e = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha3e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora3e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _reunion3e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo3e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio33e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion33e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _descripcion33e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _evento33e = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha33e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora33e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _reunion33e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo33e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio4e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion4e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _evento4e = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha4e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora4e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _reunion4e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo4e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _cambio44e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _celebracion44e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _descripcion44e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _evento44e = RemoteObject.declareNull("anywheresoftware.b4a.objects.PanelWrapper");
public static RemoteObject _fecha44e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _hora44e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static RemoteObject _reunion44e = RemoteObject.declareNull("anywheresoftware.b4a.objects.ImageViewWrapper");
public static RemoteObject _titulo44e = RemoteObject.declareNull("anywheresoftware.b4a.objects.LabelWrapper");
public static b4a.example.main _main = null;
public static b4a.example.ingreso _ingreso = null;
public static b4a.example.ingresodocente _ingresodocente = null;
public static b4a.example.inicioacudiente _inicioacudiente = null;
public static b4a.example.iniciodocente _iniciodocente = null;
public static b4a.example.inicioestudiante _inicioestudiante = null;
public static b4a.example.perfiles _perfiles = null;
public static b4a.example.registroacudiente _registroacudiente = null;
public static b4a.example.registrodocente _registrodocente = null;
public static b4a.example.registroestudiante _registroestudiante = null;
public static b4a.example.starter _starter = null;
public static b4a.example.httputils2service _httputils2service = null;
  public Object[] GetGlobals() {
		return new Object[] {"Activity",ingresoestudiante.mostCurrent._activity,"Anuncio",ingresoestudiante.mostCurrent._anuncio,"btncambiarestudiante",ingresoestudiante.mostCurrent._btncambiarestudiante,"btncambioE",ingresoestudiante.mostCurrent._btncambioe,"btncerrarestudiante",ingresoestudiante.mostCurrent._btncerrarestudiante,"c",ingresoestudiante._c,"cambio11E",ingresoestudiante.mostCurrent._cambio11e,"cambio1E",ingresoestudiante.mostCurrent._cambio1e,"cambio22E",ingresoestudiante.mostCurrent._cambio22e,"cambio2E",ingresoestudiante.mostCurrent._cambio2e,"cambio33E",ingresoestudiante.mostCurrent._cambio33e,"cambio3E",ingresoestudiante.mostCurrent._cambio3e,"cambio44E",ingresoestudiante.mostCurrent._cambio44e,"cambio4E",ingresoestudiante.mostCurrent._cambio4e,"celebracion11E",ingresoestudiante.mostCurrent._celebracion11e,"celebracion1E",ingresoestudiante.mostCurrent._celebracion1e,"celebracion22E",ingresoestudiante.mostCurrent._celebracion22e,"celebracion2E",ingresoestudiante.mostCurrent._celebracion2e,"celebracion33E",ingresoestudiante.mostCurrent._celebracion33e,"celebracion3E",ingresoestudiante.mostCurrent._celebracion3e,"celebracion44E",ingresoestudiante.mostCurrent._celebracion44e,"celebracion4E",ingresoestudiante.mostCurrent._celebracion4e,"codigoE",ingresoestudiante._codigoe,"contraseñaE",ingresoestudiante.mostCurrent._contraseñae,"Datos",ingresoestudiante.mostCurrent._datos,"desc1",ingresoestudiante._desc1,"desc11E",ingresoestudiante.mostCurrent._desc11e,"desc2",ingresoestudiante._desc2,"desc3",ingresoestudiante._desc3,"desc4",ingresoestudiante._desc4,"descripcion",ingresoestudiante._descripcion,"descripcion22E",ingresoestudiante.mostCurrent._descripcion22e,"descripcion33E",ingresoestudiante.mostCurrent._descripcion33e,"descripcion44E",ingresoestudiante.mostCurrent._descripcion44e,"EnviarE",ingresoestudiante.mostCurrent._enviare,"estado",ingresoestudiante._estado,"event",ingresoestudiante._event,"evento11E",ingresoestudiante.mostCurrent._evento11e,"evento1E",ingresoestudiante.mostCurrent._evento1e,"evento22E",ingresoestudiante.mostCurrent._evento22e,"evento2E",ingresoestudiante.mostCurrent._evento2e,"evento33E",ingresoestudiante.mostCurrent._evento33e,"evento3E",ingresoestudiante.mostCurrent._evento3e,"evento44E",ingresoestudiante.mostCurrent._evento44e,"evento4E",ingresoestudiante.mostCurrent._evento4e,"eventos",ingresoestudiante._eventos,"fecha",ingresoestudiante._fecha,"fecha11E",ingresoestudiante.mostCurrent._fecha11e,"fecha1E",ingresoestudiante.mostCurrent._fecha1e,"fecha22E",ingresoestudiante.mostCurrent._fecha22e,"fecha2E",ingresoestudiante.mostCurrent._fecha2e,"fecha33E",ingresoestudiante.mostCurrent._fecha33e,"fecha3E",ingresoestudiante.mostCurrent._fecha3e,"fecha44E",ingresoestudiante.mostCurrent._fecha44e,"fecha4E",ingresoestudiante.mostCurrent._fecha4e,"hora",ingresoestudiante._hora,"hora11E",ingresoestudiante.mostCurrent._hora11e,"hora1E",ingresoestudiante.mostCurrent._hora1e,"hora22E",ingresoestudiante.mostCurrent._hora22e,"hora2E",ingresoestudiante.mostCurrent._hora2e,"hora33E",ingresoestudiante.mostCurrent._hora33e,"hora3E",ingresoestudiante.mostCurrent._hora3e,"hora44E",ingresoestudiante.mostCurrent._hora44e,"hora4E",ingresoestudiante.mostCurrent._hora4e,"HttpUtils2Service",Debug.moduleToString(b4a.example.httputils2service.class),"ingreso",Debug.moduleToString(b4a.example.ingreso.class),"ingresoDocente",Debug.moduleToString(b4a.example.ingresodocente.class),"inicio",ingresoestudiante.mostCurrent._inicio,"inicioAcudiente",Debug.moduleToString(b4a.example.inicioacudiente.class),"inicioDocente",Debug.moduleToString(b4a.example.iniciodocente.class),"inicioEstudiante",Debug.moduleToString(b4a.example.inicioestudiante.class),"Main",Debug.moduleToString(b4a.example.main.class),"Panel1",ingresoestudiante.mostCurrent._panel1,"perfiles",Debug.moduleToString(b4a.example.perfiles.class),"registroAcudiente",Debug.moduleToString(b4a.example.registroacudiente.class),"registroDocente",Debug.moduleToString(b4a.example.registrodocente.class),"registroEstudiante",Debug.moduleToString(b4a.example.registroestudiante.class),"retroceder",ingresoestudiante.mostCurrent._retroceder,"reunion11E",ingresoestudiante.mostCurrent._reunion11e,"reunion1E",ingresoestudiante.mostCurrent._reunion1e,"reunion22E",ingresoestudiante.mostCurrent._reunion22e,"reunion2E",ingresoestudiante.mostCurrent._reunion2e,"reunion33E",ingresoestudiante.mostCurrent._reunion33e,"reunion3E",ingresoestudiante.mostCurrent._reunion3e,"reunion44E",ingresoestudiante.mostCurrent._reunion44e,"reunion4E",ingresoestudiante.mostCurrent._reunion4e,"Starter",Debug.moduleToString(b4a.example.starter.class),"TabHost1",ingresoestudiante.mostCurrent._tabhost1,"tipo",ingresoestudiante._tipo,"tipo1",ingresoestudiante._tipo1,"tipo2",ingresoestudiante._tipo2,"tipo3",ingresoestudiante._tipo3,"tipo4",ingresoestudiante._tipo4,"titulo",ingresoestudiante._titulo,"titulo11E",ingresoestudiante.mostCurrent._titulo11e,"titulo1E",ingresoestudiante.mostCurrent._titulo1e,"titulo22E",ingresoestudiante.mostCurrent._titulo22e,"titulo2E",ingresoestudiante.mostCurrent._titulo2e,"titulo33E",ingresoestudiante.mostCurrent._titulo33e,"titulo3E",ingresoestudiante.mostCurrent._titulo3e,"titulo44E",ingresoestudiante.mostCurrent._titulo44e,"titulo4E",ingresoestudiante.mostCurrent._titulo4e,"txtconactE",ingresoestudiante.mostCurrent._txtconacte,"txtconfconE",ingresoestudiante.mostCurrent._txtconfcone,"txtconnuvE",ingresoestudiante.mostCurrent._txtconnuve};
}
}
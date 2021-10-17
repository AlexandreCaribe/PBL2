package system;

import java.util.TimerTask;
import java.util.GregorianCalendar;
import colections.LinkList;

public class SystemDataHora extends TimerTask {
	
	public SystemDataHora(LinkList<Tarefa> list) {
		observers = list;
	}
	
	public LinkList<Tarefa> getObservers() {
		return observers;
	}

	public void setObservers(LinkList<Tarefa> observers) {
		this.observers = observers;
	}

	GregorianCalendar clock;
	LinkList<Tarefa> observers;
	
	@Override
	public void run() {
		
		while(true) {
			clock = new GregorianCalendar();
			observers.resetIndex();
			Tarefa a = (Tarefa)observers.next();
			while(observers.getIndex()!=null) {
				GregorianCalendar data = a.getPrevisao();
				if(clock.after(data)) {
					a.marcarPedente();
				}
				a = observers.next();
			}
		}
	}

	public GregorianCalendar getClock() {
		return clock;
	}

	public void setClock(GregorianCalendar clock) {
		this.clock = clock;
	}
}

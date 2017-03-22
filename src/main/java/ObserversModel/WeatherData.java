/**
 * 
 */
package ObserversModel;

import java.util.ArrayList;

/**
 *下午12:51:43
 * @author yuzhao.yang
 *
 */
public class WeatherData implements Subject {

	//建立观察者组
	private ArrayList Observers;
	
	private double temperature;
	
	private double humidity;
	
	private double pressure;
	
	public WeatherData(){
		Observers = new ArrayList();
	}
	
	@Override
	public void registerObserver(Observer o){
		Observers.add(o);
	}

	/**
	 * @desc 
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2016年10月6日
	 */
	@Override
	public void removeObserver(Observer o) {
		// TODO Auto-generated method stub
		int i = Observers.indexOf(o);
		if(i >= 0 ){
			Observers.remove(o);
		}
	}

	/**
	 * @desc 
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2016年10月6日
	 */
	@Override
	public void notifyAllObservers() {
		for(int i = 0 ;i < Observers.size() ; i++){
			Observer observer = (Observer)Observers.get(i);
			observer.update(temperature, humidity, pressure);
		}
	}
	
	public void measurementsChanged(){
		notifyAllObservers();
	}
	
	public void setMeasurements(double temp , double humid , double pres){
		this.temperature = temp;
		this.humidity = humid;
		this.pressure = pres;
		measurementsChanged();
	}
}

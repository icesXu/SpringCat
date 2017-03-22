/**
 * 
 */
package ObserversModel;

/**
 *下午1:01:26
 * @author yuzhao.yang
 *
 */
public class CurrentConditionDisplay implements Observer,DisplayElement{

	private double temperature;
	private double humidity;
	private double pressure;
	private Subject weatherData;
	/**
	 * @param weatherData
	 */
	public CurrentConditionDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
		
	}
	/**
	 * @desc 
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2016年10月6日
	 */
	@Override
	public void display() {
		System.out.println("now temperature is:"+temperature+"摄氏度");
		System.out.println("now humidity is"+humidity);
		System.out.println("now pressure is"+pressure+"帕");
	}
	/**
	 * @desc 
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2016年10月6日
	 */
	@Override
	public void update(double temp, double humidity, double pressure) {

		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}
}

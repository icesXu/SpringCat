/**
 * 
 */
package ObserversModel;

/**
 *下午1:05:23
 * @author yuzhao.yang
 *
 */
public class WeatherStation {

	public static void main(String [] args){
		WeatherData weatherData = new WeatherData();
		
		CurrentConditionDisplay currentConditionDisplay = 
				new CurrentConditionDisplay(weatherData);
		
		weatherData.setMeasurements(27.0f, 65, 30.4f);
	}
}

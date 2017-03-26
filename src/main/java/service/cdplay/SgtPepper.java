/**
 * 
 */
package service.cdplay;

import org.springframework.stereotype.Component;

/**
 * 下午2:56:22
 * 
 * @author yuzhao.yang
 *
 */
@Component
public class SgtPepper implements CompactDisc {
	private String title = "Sgt. Pepper's lonely hearts Club Band";
	private String artist = "The Bettles";

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月24日
	 */
	public void play() {
		// TODO Auto-generated method stub
		System.out.println("Playing " + title + "by " + artist);
	}

}

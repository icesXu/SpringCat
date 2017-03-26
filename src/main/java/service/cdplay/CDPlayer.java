package service.cdplay;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {
	@Autowired
	private CompactDisc cd;

	/**
	 * @desc
	 * @param
	 * @return
	 * @author yuzhao.yang
	 * @date 2017年3月24日
	 */
	public void play() {
		// TODO Auto-generated method stub
		cd.play();
	}

}
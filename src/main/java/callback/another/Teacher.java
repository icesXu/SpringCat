/**
 * 
 */
package callback.another;

/**
 * @author yuzhao.yang
 * @description:
 * @time:2017年4月19日 下午3:38:56
 */
public class Teacher implements Callback {
	private Student student;

	public Teacher(Student student) {
		this.student = student;
	}

	/**
	 * @description:
	 * @author:
	 * @param:
	 * @return:
	 **/
	@Override
	public void tellAnswer(int answer) {
		// TODO Auto-generated method stub
		System.out.println("知道了，你的答案是:" + answer);
	}

	public void askQuestion() {
		student.resolveQuestion(this);
	}
}

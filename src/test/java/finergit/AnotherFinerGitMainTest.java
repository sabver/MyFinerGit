package finergit;

import org.junit.Test;

public class AnotherFinerGitMainTest {

	@Test
	public void main() {
		// --src /Users/yejianfeng/Desktop/code/moduleData-ye/ --des /Users/yejianfeng/Desktop/code/moduleData-ye-finergit/
		String srcPath = "/Users/yejianfeng/Desktop/code/moduleData-ye/", desPath = "/Users/yejianfeng/Desktop/code/moduleData-ye-finergit/";
		AnotherFinerGitMain anotherFinerGitMain = new AnotherFinerGitMain();
		anotherFinerGitMain.main(srcPath, desPath);
	}
}

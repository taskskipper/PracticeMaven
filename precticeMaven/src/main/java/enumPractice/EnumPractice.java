package enumPractice;



public class EnumPractice {

	
	public enum exam{
		PASS, FAIL, REGRET;
	}
	
	public static void main(String[] args) {
		//TODO
	System.out.println(exam.REGRET);
		
		exam e = exam.FAIL;
		
		if (e == exam.FAIL ) {
			System.out.println(exam.FAIL);
		}else {
			System.out.println(e);
		}
	}

}

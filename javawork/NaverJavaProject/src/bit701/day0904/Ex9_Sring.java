package bit701.day0904;

public class Ex9_Sring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1="apple";
		String str2="Apple";
		String str3="Have a Good Day";
		String str4="    Happy    ";
		
		System.out.println("1 : "+str3.length()); //str3의 총 길이 : 15(공백포함)
		System.out.println("2 : "+str2.toLowerCase()); //str2을 모두 소문자로 변환
		System.out.println("3 : "+str2.toUpperCase()); //str2를 모두 대문자로 변환
		System.out.println("4 : "+str3.substring(5)); // str3 5번째 인덱스부터 모두 출력
		System.out.println("5 : "+str3.substring(7,11)); //str3 7번째 인덱스부터 10번째까지 출력
		System.out.println("6 : "+str3.charAt(0)); //str3에서 0번 문자 출력
		System.out.println("7 : "+str3.charAt(7)); //str3에서 7번 문자 출력
		System.out.println("8 : "+str1.indexOf('a')); //str1에서 첫번째 'a'의 인덱스값
		System.out.println("9 : "+str3.lastIndexOf('a')); //str3에서 마지막 'a'의 위치
		System.out.println("10 : "+str4.length()); //앞뒤 공백을포함한 전체 길이
		System.out.println("11 : "+str4.trim().length()); //앞뒤 공백을 제거후 길이 구하기
		System.out.println("12 : "+str3.startsWith("Have")); //str3가 Have로 시작하면 true
		System.out.println("13 : "+str3.endsWith("day")); // str3가 day로 끝나면 true (대소문자 구분)
		System.out.println("14 : "+str1.equals(str2)); // str1 이 str2와 대소문자까지 완벽하게 같은 경우 true
		System.out.println("15 : "+str1.equalsIgnoreCase(str2)); // 대소문자 상관없이 절차만 같으면 true
		System.out.println("16 : "+str1.compareTo(str2)); //str1과 str2의 차이(양수값이 나오면:str1이 더 큰값, 음수값: str2가 더 큰경우)
		System.out.println("17 : "+str1.compareTo("apple")); //완전 같을 경우 0
	}

}

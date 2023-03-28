package hospital;

public class Doctor {
	
	private String id; // 의사 번호
	private String jumin; // 의사 주민번호
	private String name; // 의사 이름
	private String address; // 의사 주소
	private String code; // 진료과 코드
	private String medicalDep; // 진료과
	private String hiredate; // 입사일
	
	
	public Doctor() {
		super();
	}


	public Doctor(String id, String jumin, String name, String address, String code, String medicalDep, String hiredate) {
		super();
		this.id = id;
		this.jumin = jumin;
		this.name = name;
		this.address = address;
		this.code = code;
		this.medicalDep = medicalDep;
		this.hiredate = hiredate;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getJumin() {
		return jumin;
	}


	public void setJumin(String jumin) {
		this.jumin = jumin;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public String getMedicalDep() {
		return medicalDep;
	}


	public void setMedicalDep(String medicalDep) {
		this.medicalDep = medicalDep;
	}
	
	
	public String getHiredate() {
		return hiredate;
	}


	public void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}


	@Override
	public String toString() {
		return "Doctor [id=" + id + ", jumin=" + jumin + ", name=" + name + ", address=" + address + ", code=" + code
				+ ", medicalDep=" + medicalDep + ", hiredate=" + hiredate + "]";
	}

}

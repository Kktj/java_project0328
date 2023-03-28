package hospital;

public class Patient {
	
	private int id; // 환자 번호
	private String jumin; // 환자 주민번호
	private String name; // 환자 이름
	private String address; // 환자 주소
	private String code; // 진료과 코드
	private String medicalDep; // 진료과
	
	
	public Patient() {
		super();
	}


	public Patient(int id, String jumin, String name, String address, String code, String medicalDep) {
		super();
		this.id = id;
		this.jumin = jumin;
		this.name = name;
		this.address = address;
		this.code = code;
		this.medicalDep = medicalDep;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
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


	@Override
	public String toString() {
		return "Patient [id=" + id + ", jumin=" + jumin + ", name=" + name + ", address=" + address + ", code=" + code
				+ ", medicalDep=" + medicalDep + "]";
	}

}

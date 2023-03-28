package hospital;

public class MedicalDepartment {
	
	private String code; // 진료과 코드
	private String medicalDep; // 진료과
	private String ward; // 병동
	
	public MedicalDepartment() {
		super();
	}


	public MedicalDepartment(String code, String medicalDep, String ward) {
		super();
		this.code = code;
		this.medicalDep = medicalDep;
		this.ward = ward;
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


	public String getWard() {
		return ward;
	}


	public void setWard(String ward) {
		this.ward = ward;
	}


	@Override
	public String toString() {
		return "MedicalDepartment [code=" + code + ", medicalDep=" + medicalDep + ", ward=" + ward + "]";
	}
	

}

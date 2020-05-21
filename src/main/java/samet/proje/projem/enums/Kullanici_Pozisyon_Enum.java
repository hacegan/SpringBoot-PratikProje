package samet.proje.projem.enums;

public enum Kullanici_Pozisyon_Enum {
	None(0), CEO(1), COO(2), SEO_MARKETING(3), DEVELOPMENT_TEAM(4), DESIGN_TEAM(5), Finance_and_Accounting(6), HR(7),
	Marketing_Leader(8), Blogger(9), Ads_Marketer(10), EU_Language_SEO(11), B2B_Marketer(12), Head_Programmer(13),
	Full_Stack_Developer(14), Front_End_Developer(15), Mobile_App_Developer(16), Intern(17), Design_Team_Leader(18),
	Designer(19), Designer_Intern(20), Finance_Accounting_Team_Leader(21), Accountant(22), HR_Executive(23),
	HR_Worker(24);

	private final int id;

	Kullanici_Pozisyon_Enum(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public static Kullanici_Pozisyon_Enum getById(int id) {
		for (Kullanici_Pozisyon_Enum employeePositionType : Kullanici_Pozisyon_Enum.values()) {
			if (employeePositionType.getId() == id) {
				return employeePositionType;
			}
		}
		return Kullanici_Pozisyon_Enum.None;
	}

}

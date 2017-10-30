package studentdatabaseapp;

public enum GradeYear {
    FRESHMAN(1, "Freshman"),
    SOPHOMORE(2, "Sophomore"),
    JUNIOR(3, "Junior"),
    SENIOR(4, "Senior");

    private final int gradeYearCode;
    private final String title;

    GradeYear(int gradeYearCode, String title) {
        this.gradeYearCode = gradeYearCode;
        this.title = title;
    }

    public int getGradeYearCode() {
        return gradeYearCode;
    }

    public static GradeYear getGradeYearFromCode(int code) {
        switch (code) {
            case 2:
                return GradeYear.SOPHOMORE;
            case 3:
                return GradeYear.JUNIOR;
            case 4:
                return GradeYear.SENIOR;
            default:
                return GradeYear.FRESHMAN;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public String toString() {
        return getTitle();
    }
}
